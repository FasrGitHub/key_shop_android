package com.example.ps_shop_android.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.ps_shop_android.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    fun onClickBasked(view: View) {}
}