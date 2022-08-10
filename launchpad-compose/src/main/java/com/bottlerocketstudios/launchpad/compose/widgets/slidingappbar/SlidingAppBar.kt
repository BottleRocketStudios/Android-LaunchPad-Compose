package com.bottlerocketstudios.launchpad.compose.widgets.slidingappbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


/**
 * Sliding app bar
 *
 * @param visible - Controls visibility using sliding in/out animation
 * @param title - same as TopAppBar
 * @param modifier - same as TopAppBar
 * @param navigationIcon - same as TopAppBar
 * @param actions - same as TopAppBar
 * @param backgroundColor - same as TopAppBar
 * @param contentColor - same as TopAppBar
 * @param elevation - same as TopAppBar
 */
@Composable
fun SlidingAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    visible: Boolean = true,
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = spring(stiffness = Spring.StiffnessHigh)
        ),
        exit = slideOutVertically(
            animationSpec = spring(stiffness = Spring.StiffnessHigh)
        )
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            elevation = elevation,
            modifier = modifier,
        )
    }
}