package com.mohamedtaha.imagine.cocomo.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.model.CocomoModel
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.pow

@HiltViewModel
class EmbeddedViewModel @Inject constructor() : ViewModel() {
    private val _embeddedKLom = MutableLiveData(0.0)
    private val _embeddedTitle = MutableLiveData("")
    val embeddedTitle get() = _embeddedTitle
    private val _embeddedValues = MutableLiveData<CocomoModel>()
    val embeddedValues get() = _embeddedValues

    private fun setValues() {
        val embeddedEffort =
            (_embeddedKLom.value ?: 0.0).pow(Constant.ONE_TWO) * Constant.THREE_SIX
        val embeddedTDev = embeddedEffort.pow(Constant.ZERO_THIRTY_TWO) * Constant.TWO_FIVE
        val embeddedProductivity = (_embeddedKLom.value ?: 0.0) / embeddedEffort
        val embeddedAverageStaffSize = embeddedEffort / embeddedTDev
        val item = CocomoModel(
            _embeddedTitle.value.toString(),
            embeddedEffort,
            embeddedTDev,
            embeddedProductivity,
            embeddedAverageStaffSize
        )
        _embeddedValues.value = item
    }

    fun setKLom(value: String, title: String) {
        _embeddedKLom.value = value.toDouble()
        setValues()
        setTitle(title)
    }

    private fun setTitle(title: String) {
        _embeddedTitle.value = String.format(title, _embeddedKLom.value)
    }

}