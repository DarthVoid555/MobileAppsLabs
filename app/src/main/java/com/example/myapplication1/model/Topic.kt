package com.example.myapplication1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResId: Int,
    val availableCourses: Int,
    @DrawableRes val imageResId: Int
)