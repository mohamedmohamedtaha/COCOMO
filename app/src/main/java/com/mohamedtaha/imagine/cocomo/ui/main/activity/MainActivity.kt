package com.mohamedtaha.imagine.cocomo.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohamedtaha.imagine.cocomo.R
import com.mohamedtaha.imagine.cocomo.databinding.MainActivityBinding
import com.mohamedtaha.imagine.cocomo.databinding.MainFragmentBinding
import com.mohamedtaha.imagine.cocomo.ui.main.fragment.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Math.pow
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}