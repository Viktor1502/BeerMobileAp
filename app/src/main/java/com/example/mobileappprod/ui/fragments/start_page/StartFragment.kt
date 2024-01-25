package com.example.mobileappprod.ui.fragments.start_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mobileappprod.R
import com.example.mobileappprod.databinding.FragmentIncidentsBinding
import com.example.mobileappprod.databinding.FragmentStartPageBinding
import com.example.mobileappprod.ui.fragments.incidents_page.IncidentsViewModel

class StartFragment : Fragment() {


    private var _binding: FragmentStartPageBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModels<StartViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartPageBinding.inflate(layoutInflater,container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}