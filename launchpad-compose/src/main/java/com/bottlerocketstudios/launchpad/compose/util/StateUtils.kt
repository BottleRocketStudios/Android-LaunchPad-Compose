@file:Suppress("unused")

package com.bottlerocketstudios.launchpad.compose.util

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf

@SuppressLint("UnrememberedMutableState")
fun <T> T.asMutableState() = mutableStateOf(this)
