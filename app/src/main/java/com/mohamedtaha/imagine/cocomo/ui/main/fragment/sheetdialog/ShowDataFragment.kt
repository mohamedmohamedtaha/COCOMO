package com.mohamedtaha.imagine.cocomo.ui.main.fragment.sheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mohamedtaha.imagine.cocomo.R
import com.mohamedtaha.imagine.cocomo.databinding.FragmentShowDataBinding
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.EmbeddedViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.OrganicViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.viewmodel.SemiViewModel

class ShowDataFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentShowDataBinding
    private val args: ShowDataFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShowDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (args.value) {
            1 -> observeValuesOrganic()
            2 -> observeValuesSemiDetached()
            3 -> observeValuesEmbedded()
        }
    }

    private fun observeValuesOrganic() {
        val organicViewModel by activityViewModels<OrganicViewModel>()
        organicViewModel.organicTitle.observe(viewLifecycleOwner) {
            binding.textViewTitle.text = it
        }
        organicViewModel.organicValues.observe(viewLifecycleOwner) {
            binding.textViewEffort.text =
                String.format(getString(R.string.pm), it.effort)
            binding.textViewTDev.text = String.format(getString(R.string.pm), it.tDev)
            binding.textViewProductivity.text =
                String.format(getString(R.string.klon_pm), it.productivity)
            binding.textViewAverageStaffSize.text =
                String.format(getString(R.string.persons), it.averageStaffSize)
        }
    }

    private fun observeValuesSemiDetached() {
         val semiViewModel by activityViewModels<SemiViewModel>()
        semiViewModel.semidetachedTitle.observe(viewLifecycleOwner) {
            binding.textViewTitle.text = it
        }
        semiViewModel.semidetachedValues.observe(viewLifecycleOwner) {
            binding.textViewEffort.text =
                String.format(getString(R.string.pm), it.effort)
            binding.textViewTDev.text = String.format(getString(R.string.pm), it.tDev)
            binding.textViewProductivity.text =
                String.format(getString(R.string.klon_pm), it.productivity)
            binding.textViewAverageStaffSize.text =
                String.format(getString(R.string.persons), it.averageStaffSize)
        }
    }

    private fun observeValuesEmbedded() {
        val embeddedViewModel by activityViewModels<EmbeddedViewModel>()
        embeddedViewModel.embeddedTitle.observe(viewLifecycleOwner) {
            binding.textViewTitle.text = it
        }
        embeddedViewModel.embeddedValues.observe(viewLifecycleOwner) {
            binding.textViewEffort.text =
                String.format(getString(R.string.pm), it.effort)
            binding.textViewTDev.text = String.format(getString(R.string.pm), it.tDev)
            binding.textViewProductivity.text =
                String.format(getString(R.string.klon_pm), it.productivity)
            binding.textViewAverageStaffSize.text =
                String.format(getString(R.string.persons), it.averageStaffSize)
        }
    }

}