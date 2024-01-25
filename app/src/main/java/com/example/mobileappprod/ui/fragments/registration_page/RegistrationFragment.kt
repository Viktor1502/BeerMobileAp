package com.example.mobileappprod.ui.fragments.registration_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mobileappprod.R
import com.example.mobileappprod.databinding.FragmentIncidentsBinding
import com.example.mobileappprod.databinding.FragmentRegistrationPageBinding
import com.example.mobileappprod.ui.fragments.incidents_page.IncidentsViewModel

class RegistrationFragment : Fragment() {


    private var _binding: FragmentRegistrationPageBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationPageBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.registerNewUserByEmail("wiktor@test.com", "Tesssst123321!", "Wiktor")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}