package com.example.ps_shop_android.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentMainBinding
import com.example.ps_shop_android.presentation.adapters.ProductAdapter
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MainApp).component
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBasked.setOnClickListener {
            launchShoppingCartFragment()
        }

        setupRecyclerView()

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.productList.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }
        setupClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchShoppingCartFragment(){
        findNavController().navigate(R.id.action_mainFragment_to_shoppingCartFragment)
    }

    private fun setupRecyclerView() {
        val rvShopList = binding.rvShopList
        productAdapter = ProductAdapter()
        rvShopList.adapter = productAdapter
    }

    private fun setupClickListener() {
        productAdapter.onProductClickListener = {
            viewModel.addProductCart(it)
        }
    }
}