@file:Suppress("unused")

package com.bottlerocketstudios.launchpad.compose.util

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

/**
 * These Preview utils provide easy to use functions to preview Composable code in multiple form
 *   factors and configurations.
 */


/**
 * PreviewAll - This function can be used to preview a full screen with Foldable, Tablet, and
 *   phone sizes.  Additionally, the phone form factor will display in both light and dark modes.
 */
@Preview(showSystemUi = true, device = Devices.FOLDABLE, group = "Foldable")
@Preview(showSystemUi = true, device = Devices.TABLET, group = "Tablet")
@PreviewLightDark
@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
annotation class PreviewAll


/**
 * PreviewLightDark - This function can be used to preview a full screen UI in both light and
 *   dark modes.
 */
@Preview(showSystemUi = true, device = Devices.DEFAULT, group = "Default")
@Preview(showSystemUi = true, device = Devices.DEFAULT, group = "Default", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
annotation class PreviewLightDark

/**
 * PreviewComposable - This function can be used to preview a composable widget without a
 *  full device frame.
 */
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
annotation class PreviewComposable


