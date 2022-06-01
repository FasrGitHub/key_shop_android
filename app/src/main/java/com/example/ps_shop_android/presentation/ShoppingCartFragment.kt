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
    private lateinit var productCartAdapter: ProductCartAdapter

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
            productCartAdapter.submitList(it)
        }
        areThereProductsList()
        setupClickListener()
        getSumPrice()

        binding.buttonBuy.setOnClickListener {
            launchPaymentWindowFragment()
        }
        binding.buttonBackToMain.setOnClickListener {
            launchMainFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSumPrice() {
        binding.tvSumCart.text = String.format(getString(
            R.string.sum,
            viewModel.getSumPriceCart().toString()
        ))
    }

    private fun areThereProductsList() {
        if (viewModel.areThereProductsList()) {
            binding.buttonBuy.visibility = View.INVISIBLE
            binding.tvSumCart.visibility = View.INVISIBLE
            binding.buttonBackToMain.visibility = View.VISIBLE
        }
    }

    private fun setupRecyclerView() {
        val rvCartList = binding.rvCartList
        productCartAdapter = ProductCartAdapter()
        rvCartList.adapter = productCartAdapter
    }

    private fun setupClickListener() {
        productCartAdapter.onProductClickListener = {
            viewModel.deleteProductCart(it)
            getSumPrice()
            areThereProductsList()
        }
    }

    private fun launchPaymentWindowFragment(){
        findNavController().navigate(R.id.action_shoppingCartFragment_to_paymentWindowFragment)
    }

    private fun launchMainFragment(){
        findNavController().popBackStack()
    }
}