package com.chama.onboarding.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.chama.onboarding.R
import com.chama.onboarding.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    private lateinit var phoneTextInput: TextInputEditText
    private lateinit var sendButton: Button
    private lateinit var textInputLayout: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        phoneTextInput = binding.phoneTextInput
        textInputLayout = binding.textInputLayout
        sendButton = binding.sendButton

        phoneTextInput.setOnClickListener {
            textInputLayout.error = null
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendButton.setOnClickListener {
            val isValid = checkValidPhoneNumber()
            if (isValid == null) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                textInputLayout.error = isValid
            }
        }

        val toolbar: Toolbar = binding.toolBarButton
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        navController = findNavController()
        toolbar.setNavigationOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun checkValidPhoneNumber(): String? {
        val phoneText = phoneTextInput.text.toString()
        if (!phoneText.matches(Regex("0.*[0-9].*"))) {
            return "Wrong format"
        }
        if (phoneText.length != 10) {
            return "Must be 10 digits"
        }
        return null
    }
}
