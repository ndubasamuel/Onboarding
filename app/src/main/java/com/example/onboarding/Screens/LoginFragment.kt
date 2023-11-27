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
import com.example.onboarding.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sendButton.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
        val toolbar: Toolbar = view.findViewById(R.id.tool_bar_button)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)


        navController = findNavController()

        toolbar.setNavigationOnClickListener{
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


}