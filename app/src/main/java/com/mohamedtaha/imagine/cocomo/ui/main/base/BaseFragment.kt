package com.mohamedtaha.imagine.cocomo.ui.main.base

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment:Fragment() {
    protected lateinit var toolbar: HasToolbar
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (requireActivity() is HasToolbar)
            toolbar = requireActivity() as HasToolbar
    }

}