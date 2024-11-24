package io.github.junrdev.recycler.features.auth.login_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.github.junrdev.recycler.databinding.FragmentPhoneNumberLoginRegisterBinding

class PhoneNumberLoginRegister : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentPhoneNumberLoginRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPhoneNumberLoginRegisterBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

        }
    }

    companion object {
        fun newInstance(): PhoneNumberLoginRegister {
            val args = Bundle()
                .apply { }
            val fragment = PhoneNumberLoginRegister()
            fragment.arguments = args
            return fragment
        }
    }

}
