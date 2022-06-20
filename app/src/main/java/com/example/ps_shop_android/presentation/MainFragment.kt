package com.example.ps_shop_android.presentation

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentMainBinding
import com.example.ps_shop_android.presentation.adapters.ProductAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        lifecycleScope.launch {
            loadProducts()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private suspend fun loadProducts() {
        binding.progress.isVisible = true
        delay(2000)
        viewModel.loadData()
        binding.progress.isInvisible = true

        setupRecyclerView()
        setupObserver()
        setupClickListeners()
    }

    private fun launchShoppingCartFragment(){
        findNavController().navigate(R.id.action_mainFragment_to_shoppingCartFragment)
    }

    private fun setupRecyclerView() {
        val rvShopList = binding.rvShopList
        productAdapter = ProductAdapter()
        rvShopList.adapter = productAdapter
    }

    private fun setupObserver() {
        viewModel.productList.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }
    }

    private fun setupClickListeners() {
        productAdapter.onProductClickListener = {
            viewModel.addProductCart(it)
        }
        binding.ivBasked.setOnClickListener {
            launchShoppingCartFragment()
        }
    }
}