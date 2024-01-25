package com.example.mobileappprod.ui.fragments.map_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mobileappprod.R
import com.example.mobileappprod.databinding.FragmentIncidentsBinding
import com.example.mobileappprod.databinding.FragmentMapPageBinding
import com.example.mobileappprod.ui.fragments.incidents_page.IncidentsViewModel

class MapFragment : Fragment() {


    private var _binding: FragmentMapPageBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModels<MapViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapPageBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}