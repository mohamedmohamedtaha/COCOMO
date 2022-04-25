package com.mohamedtaha.imagine.cocomo.ui.main.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mohamedtaha.imagine.cocomo.R
import com.mohamedtaha.imagine.cocomo.databinding.MainFragmentBinding
import com.mohamedtaha.imagine.cocomo.ui.main.base.BaseFragment
import com.mohamedtaha.imagine.cocomo.ui.utils.ClickProfile
import com.mohamedtaha.imagine.cocomo.ui.main.activity.MainActivity
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.EmbeddedViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.OrganicViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.SemiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment() {
    private lateinit var binding: MainFragmentBinding
    private val organicViewModel by activityViewModels<OrganicViewModel>()
    private val semiViewModel by activityViewModels<SemiViewModel>()
    private val embeddedViewModel by activityViewModels<EmbeddedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        listenerRadioGroup()
        toolbar.showProfileImage(true)
        clickProfile()
        return binding.root
    }

    private fun checkEditText(): Boolean {
        val text = binding.textInputEditText.text.toString()
        if (text.isEmpty()) {
            binding.textInputEditText.error = getString(R.string.enter_value)
            Snackbar.make(requireView(), getString(R.string.enter_value), Snackbar.LENGTH_LONG)
                .show()
            emptySelect()
            hideKeyBoard()
            return true
        }
        return false
    }

    private fun showData(value: Int) {
        emptySelect()
        val action = MainFragmentDirections.actionMainFragmentToShowDataFragment(value)
        findNavController().navigate(action)

    }

    private fun hideKeyBoard() {
        // Check if no view has focus:
        val view = requireActivity().currentFocus
        if (view != null) {
            val inputManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }


    }

    private fun listenerRadioGroup() {
        binding.radioGroupStyle.setOnCheckedChangeListener { p0, _ ->
            when (p0?.checkedRadioButtonId) {
                R.id.radioButtonOrganic -> {
                    if (!checkEditText()) {
                        organicViewModel.setKLom(
                            binding.textInputEditText.text.toString(),
                            getString(R.string.organic_model)
                        )
                        showData(1)
                    }

                }
                R.id.radioButtonSemi -> {
                    if (!checkEditText()) {
                        semiViewModel.setKLom(
                            binding.textInputEditText.text.toString(),
                            getString(R.string.semi_detached_model)
                        )
                        showData(2)
                    }
                }
                R.id.radioButtonEmbedded -> {
                    if (!checkEditText()) {
                        embeddedViewModel.setKLom(
                            binding.textInputEditText.text.toString(),
                            getString(R.string.embedded_model)
                        )
                        showData(3)
                    }
                }
            }
        }
    }

    private fun emptySelect() {
        binding.radioButtonEmbedded.isChecked = false
        binding.radioButtonOrganic.isChecked = false
        binding.radioButtonSemi.isChecked = false
    }

    private fun clickProfile() {
        (requireActivity() as MainActivity).setClickProfile(object : ClickProfile {
            override fun clickProfile() {
                findNavController().navigate(R.id.action_mainFragment_to_profileFragment)
            }
        })
    }
}