package com.example.ps_shop_android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentOrderCreatedBinding

class OrderCreatedFragment : Fragment() {

    private var _binding: FragmentOrderCreatedBinding? = null
    private val binding: FragmentOrderCreatedBinding
        get() = _binding ?: throw RuntimeException("FragmentOrderCreatedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderCreatedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBackToMain.setOnClickListener {
            launchMainFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchMainFragment(){
        findNavController().popBackStack()
    }
}