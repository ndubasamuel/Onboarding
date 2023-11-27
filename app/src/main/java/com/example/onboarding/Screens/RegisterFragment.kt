package com.example.onboarding.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.onboarding.R
import com.example.onboarding.databinding.FragmentRegisterBinding


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
            continueButton.setOnClickListener{
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
        val toolbar: Toolbar = view.findViewById(R.id.register_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        navController = findNavController()


        toolbar.setNavigationOnClickListener{
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}