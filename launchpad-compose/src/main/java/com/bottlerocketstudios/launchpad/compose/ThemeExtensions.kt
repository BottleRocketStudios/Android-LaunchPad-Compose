package com.bottlerocketstudios.launchpad.compose

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight


fun TextStyle.light() = this.copy(fontWeight = FontWeight.Light)
fun TextStyle.normal() = this.copy(fontWeight = FontWeight.Normal)
fun TextStyle.bold() = this.copy(fontWeight = FontWeight.Bold)
