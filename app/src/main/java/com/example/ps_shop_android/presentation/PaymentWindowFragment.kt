package com.example.ps_shop_android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentPaymentWindowBinding

class PaymentWindowFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentPaymentWindowBinding? = null
    private val binding: FragmentPaymentWindowBinding
        get() = _binding ?: throw RuntimeException("FragmentPaymentWindowBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentWindowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        getSumPrice()

        binding.buttonPay.setOnClickListener {
            launchOrderCreatedFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSumPrice() {
        binding.tvSum.text = String.format(getString(
            R.string.sum,
            viewModel.getSumPriceCart().toString()
        ))
    }

    private fun launchOrderCreatedFragment(){
        findNavController().navigate(R.id.action_paymentWindowFragment_to_orderCreatedFragment)
    }
}