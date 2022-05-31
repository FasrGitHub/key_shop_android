package com.example.ps_shop_android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentShoppingCartBinding

class ShoppingCartFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var productAdapter: ProductAdapter

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding: FragmentShoppingCartBinding
        get() = _binding ?: throw RuntimeException("FragmentShoppingCartBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.productCartList.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }

        binding.buttonBuy.setOnClickListener {
            launchPaymentWindowFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val rvCartList = binding.rvCartList
        productAdapter = ProductAdapter()
        rvCartList.adapter = productAdapter
    }

    private fun launchPaymentWindowFragment(){
        findNavController().navigate(R.id.action_shoppingCartFragment_to_paymentWindowFragment)
    }
}