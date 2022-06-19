package com.example.ps_shop_android.presentation

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ps_shop_android.R
import com.example.ps_shop_android.databinding.FragmentOrderFormBinding
import com.example.ps_shop_android.domain.model.Product
import javax.inject.Inject

class OrderFormFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MainApp).component
    }

    private var _binding: FragmentOrderFormBinding? = null
    private val binding: FragmentOrderFormBinding
        get() = _binding ?: throw RuntimeException("FragmentOrderFormBinding == null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.productCartList.observe(viewLifecycleOwner) {
            getSumPrice(it)
            launchPay(it)
        }
        addTextChangeListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchPay(productsList: List<Product>) {
        binding.buttonPay.setOnClickListener {
            viewModel.getJsonResponse(
                binding.etEmailAddress.text?.toString(),
                binding.etCryptoWallet.text?.toString(),
                productsList,
            )
            observeViewModel()
        }
    }

    private fun getSumPrice(productsList: List<Product>) {
        binding.tvSum.text = String.format(
            getString(
                R.string.sum,
                viewModel.getSumPriceCart(productsList).toString()
            )
        )
    }

    private fun addTextChangeListener() {
        binding.etEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputEmail()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.etCryptoWallet.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputWallet()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun observeViewModel() {
        var isValid = true
        viewModel.errorInputEmail.observe(viewLifecycleOwner) {
            val message = if (it) {
                isValid = false
                getString(R.string.error_input_email)
            } else {
                null
            }
            binding.tilEmailAddress.error = message
        }
        viewModel.errorInputWallet.observe(viewLifecycleOwner) {
            val message = if (it) {
                isValid = false
                getString(R.string.error_input_wallet)
            } else {
                null
            }
            binding.tilCryptoWallet.error = message
        }
        if (isValid){
            viewModel.deleteAllProductsCart()
            launchOrderCreatedFragment()
        }
    }

    private fun launchOrderCreatedFragment() {
        findNavController().navigate(R.id.action_orderFormFragment_to_orderCreatedFragment)
    }
}