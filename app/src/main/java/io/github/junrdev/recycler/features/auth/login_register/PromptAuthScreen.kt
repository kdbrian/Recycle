package io.github.junrdev.recycler.features.auth.login_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentPromptAuthScreenBinding

class PromptAuthScreen : Fragment() {

    private lateinit var binding: FragmentPromptAuthScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPromptAuthScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            button4.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_promptAuthScreen_to_homeScreen)
            }

            continueWithEmail.setOnClickListener {
                EmailLoginRegister
                    .newInstance()
                    .show(parentFragmentManager, null)
            }

            continueWithPhone.setOnClickListener {
                PhoneNumberLoginRegister
                    .newInstance()
                    .show(parentFragmentManager, null)
            }
        }
    }
}