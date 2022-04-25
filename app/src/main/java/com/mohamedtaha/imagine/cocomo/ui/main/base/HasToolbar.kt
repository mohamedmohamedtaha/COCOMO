package com.mohamedtaha.imagine.cocomo.ui.main.base

import androidx.appcompat.widget.Toolbar

interface HasToolbar {
    fun setToolbar(toolbar: Toolbar)
    fun getToolbar(): Toolbar
    fun showProfileImage(b:Boolean)
}