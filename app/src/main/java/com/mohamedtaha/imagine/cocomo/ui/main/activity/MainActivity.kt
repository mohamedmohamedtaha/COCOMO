package com.mohamedtaha.imagine.cocomo.ui.main.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.mohamedtaha.imagine.cocomo.R
import com.mohamedtaha.imagine.cocomo.databinding.MainActivityBinding
import com.mohamedtaha.imagine.cocomo.ui.utils.ClickProfile
import com.mohamedtaha.imagine.cocomo.ui.main.base.HasToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), HasToolbar {
    private var clickProfile: ClickProfile? = null
    private lateinit var navController: NavController
    private lateinit var binding: MainActivityBinding
    fun setClickProfile(clickProfile: ClickProfile) {
        this.clickProfile = clickProfile
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        binding.customToolbar.imageProfile.setOnClickListener { clickProfile?.clickProfile() }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    override fun getToolbar(): Toolbar {
        return binding.toolbar
    }

    override fun showProfileImage(b: Boolean) {
        if (b)binding.customToolbar.imageProfile.visibility = View.VISIBLE
        else binding.customToolbar.imageProfile.visibility = View.GONE
    }
}