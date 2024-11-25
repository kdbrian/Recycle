package io.github.junrdev.recycler.features.auth.login_register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentEmailLoginRegisterBinding
import io.github.junrdev.recycler.ui.presentation.viewmodel.AuthScreenViewModel
import io.github.junrdev.recycler.util.Constants
import io.github.junrdev.recycler.util.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailLoginRegister : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentEmailLoginRegisterBinding
    private val authScreenViewModel by viewModel<AuthScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentEmailLoginRegisterBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            button.setOnClickListener {
                if (checkFields()) {
                    val emailStr = email.text.toString()
                    val passwordStr = password.text.toString()

                    CoroutineScope(Dispatchers.Main).launch {
                        println(
                            "found : ${authScreenViewModel.checkUserWithEmail(emailStr)}"
                        )
                        if (!authScreenViewModel.checkUserWithEmail(emailStr)) {

                            val result =
                                authScreenViewModel.signUpWithEmailAndPassword(emailStr, passwordStr)

                            requireContext().run {
                                result.onSuccess {
                                    toast("Login success.")

                                    //save info to cache
                                    val userInfo = Json.encodeToString(it)

                                    getSharedPreferences(Constants.appPrefs, Context.MODE_PRIVATE)
                                        .edit().putString(Constants.userInfo, userInfo)
                                        .apply()

                                    dismiss()
                                    findNavController().navigate(R.id.action_promptAuthScreen_to_homeScreen)
                                }

                                result.onFailure {
                                    authScreenViewModel.logoutUser()
                                    toast(it.message.toString())
                                }

                            }

                        } else {
                            //login
                            val result = authScreenViewModel.signInWithEmailAndPassword(emailStr, passwordStr)
                            requireContext().run {

                                result.onSuccess{

                                    val userInfo = Json.encodeToString(it)

                                    getSharedPreferences(Constants.appPrefs, Context.MODE_PRIVATE)
                                        .edit().putString(Constants.userInfo, userInfo)
                                        .apply()

                                    dismiss()
                                    findNavController().navigate(R.id.action_promptAuthScreen_to_homeScreen)

                                }

                                result.onFailure {
                                    toast(it.message.toString())
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    private fun FragmentEmailLoginRegisterBinding.checkFields(): Boolean {
        return !(email.text.toString().isEmpty() || password.text.toString().isEmpty())
    }

    companion object {
        fun newInstance(): EmailLoginRegister {
            val args = Bundle()
                .apply { }
            val fragment = EmailLoginRegister()
            fragment.arguments = args
            return fragment
        }
    }
}