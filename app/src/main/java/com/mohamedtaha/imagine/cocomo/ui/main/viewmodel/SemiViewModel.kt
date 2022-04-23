package com.mohamedtaha.imagine.cocomo.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamedtaha.imagine.cocomo.ui.main.model.CocomoModel
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant
import com.mohamedtaha.imagine.cocomo.ui.utils.Constant.TWO_FIVE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.pow

@HiltViewModel
class SemiViewModel @Inject constructor() : ViewModel() {
    private val _semidetachedKLom = MutableLiveData(0.0)
    private val _semidetachedTitle = MutableLiveData("")
    val semidetachedTitle get() = _semidetachedTitle
    private val _semidetachedValues = MutableLiveData<CocomoModel>()
    val semidetachedValues get() = _semidetachedValues

    private fun setValues() {
        val semidetachedEffort = (_semidetachedKLom.value ?: 0.0).pow(Constant.ONE_TWELVE) * Constant.THREE
        val semidetachedTDev = semidetachedEffort.pow(Constant.ZERO_THIRTY_FIVE) * TWO_FIVE
        val semidetachedProductivity = (_semidetachedKLom.value ?: 0.0) / semidetachedEffort
        val semidetachedAverageStaffSize = semidetachedEffort / semidetachedTDev
        val item = CocomoModel(
            _semidetachedTitle.value.toString(),
            semidetachedEffort,
            semidetachedTDev,
            semidetachedProductivity,
            semidetachedAverageStaffSize
        )
        _semidetachedValues.value = item
    }

    fun setKLom(value: String, title: String) {
        _semidetachedKLom.value = value.toDouble()
        setValues()
        setTitle(title)
    }

    private fun setTitle(title: String) {
        _semidetachedTitle.value = String.format(title, _semidetachedKLom.value)
    }
}