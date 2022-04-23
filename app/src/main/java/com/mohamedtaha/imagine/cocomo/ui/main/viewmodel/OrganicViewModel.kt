package com.mohamedtaha.imagine.cocomo.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.model.CocomoModel
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant.ONE_ZERO_FIVE
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant.TWO_FIVE
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant.TWO_FOUR
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant.ZERO_THIRTY_EIGHT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.pow

@HiltViewModel
class OrganicViewModel @Inject constructor() : ViewModel() {
    private val _organicKLom = MutableLiveData(0.0)
    private val _organicTitle = MutableLiveData("")
    val organicTitle get() = _organicTitle
    private val _organicValues = MutableLiveData<CocomoModel>()
    val organicValues get() = _organicValues

    private fun setValues() {
        val organicEffort = (_organicKLom.value ?: 0.0).pow(ONE_ZERO_FIVE) * TWO_FOUR
        val organicTDev = organicEffort.pow(ZERO_THIRTY_EIGHT) * TWO_FIVE
        val organicProductivity = (_organicKLom.value ?: 0.0) / organicEffort
        val organicAverageStaffSize = organicEffort / organicTDev
        val item = CocomoModel(
            _organicTitle.value.toString(),
            organicEffort,
            organicTDev,
            organicProductivity,
            organicAverageStaffSize
        )
        _organicValues.value = item
    }

    fun setKLom(value: String, title: String) {
        _organicKLom.value = value.toDouble()
        setValues()
        setTitle(title)
    }

    private fun setTitle(title: String) {
        _organicTitle.value = String.format(title, _organicKLom.value)
    }
}