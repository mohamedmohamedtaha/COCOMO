package com.mohamedtaha.imagine.cocomo.ui.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CocomoModel(val title:String ,val effort:Double= 0.0,val tDev:Double =0.0,val productivity:Double =0.0 ,val averageStaffSize:Double =0.0) :
    Parcelable