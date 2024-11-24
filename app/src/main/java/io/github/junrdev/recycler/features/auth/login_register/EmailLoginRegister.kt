package io.github.junrdev.recycler.features.auth.login_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.github.junrdev.recycler.databinding.FragmentEmailLoginRegisterBinding

class EmailLoginRegister : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentEmailLoginRegisterBinding

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

        }
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