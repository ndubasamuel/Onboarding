package com.chama.onboarding.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.chama.onboarding.R
import com.chama.onboarding.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            continueButton.setOnClickListener {
                if (validateFields()) {
                    findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(),"Validation Failed", Toast.LENGTH_SHORT).show()
                }
            }

            val toolbar: Toolbar = view.findViewById(R.id.register_toolbar)
            (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

            toolbar.setNavigationOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        navController = findNavController()


        }
    private fun validateFields(): Boolean {
        val idEditText = binding.tvEdId
        val emailEditText =  binding.tvEdEmailAddress
        val sirNameEditText = binding.tvEdSirName
        val otherNamesEditText = binding.tvEdOtherNames

        val idNumber = idEditText.text.toString().trim()
        val emailAddress = emailEditText.text.toString().trim()
        val sirName = sirNameEditText.text.toString().trim()
        val otherNames = otherNamesEditText.text.toString().trim()

        if (idNumber.length != 8) {
            idEditText.error = "ID number must be 8 characters"
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            emailEditText.error = "Invalid email address"
            return false
        }
        if (sirName.isEmpty()) {
            sirNameEditText.error = "Surname cannot be empty"
            return false
        }
        if (otherNames.isEmpty()) {
            otherNamesEditText.error = "Other names cannot be empty"
            return false
        }
        if (!binding.checkbox.isChecked) {

            Toast.makeText(requireContext(),"Check box required", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}