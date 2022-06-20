package com.example.ps_shop_android.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentShoppingCartBinding
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.presentation.adapters.ProductCartAdapter
import com.example.ps_shop_android.presentation.viewmodels.OrderViewModel
import javax.inject.Inject

class ShoppingCartFragment : Fragment() {

    private lateinit var viewModel: OrderViewModel
    private lateinit var productCartAdapter: ProductCartAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MainApp).component
    }

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding: FragmentShoppingCartBinding
        get() = _binding ?: throw RuntimeException("FragmentShoppingCartBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

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

        viewModel = ViewModelProvider(this, viewModelFactory)[OrderViewModel::class.java]
        viewModel.productCartList.observe(viewLifecycleOwner) {
            productCartAdapter.submitList(it)
            areThereProductsList(it)
            getSumPrice(it)
        }
        setupClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSumPrice(productsList: List<Product>) {
        binding.tvSumCart.text = String.format(
            getString(
                R.string.sum,
                viewModel.getSumPriceCart(productsList).toString()
            )
        )
    }

    private fun areThereProductsList(list:List<Product>) {
        if (list.isEmpty()) {
            binding.buttonBuy.visibility = View.INVISIBLE
            binding.tvSumCart.visibility = View.INVISIBLE
            binding.buttonBackToMain.visibility = View.VISIBLE
        } else {
            binding.buttonBuy.visibility = View.VISIBLE
            binding.tvSumCart.visibility = View.VISIBLE
            binding.buttonBackToMain.visibility = View.INVISIBLE
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
        }
        binding.buttonBuy.setOnClickListener {
            launchOrderFormFragment()
        }
        binding.buttonBackToMain.setOnClickListener {
            launchMainFragment()
        }
    }

    private fun launchOrderFormFragment() {
        findNavController().navigate(R.id.action_shoppingCartFragment_to_orderFormFragment)
    }

    private fun launchMainFragment() {
        findNavController().popBackStack()
    }
}