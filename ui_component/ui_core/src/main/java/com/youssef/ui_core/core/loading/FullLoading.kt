package com.youssef.ui_core.core.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.youssef.ui_components.R
import com.youssef.ui_core.core.text.BodyLText
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme


@Composable
fun FullLoading(
    modifier: Modifier = Modifier.wrapContentSize(), isLoading: Boolean = true
) {
    if (isLoading) Box(
        modifier.background(AppTheme.colors.backgroundOverlay),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(188.dp)
                .height(164.dp)
                .background(AppTheme.colors.backgroundPrimary, shape = AppTheme.radius.radiusL)
                .align(Alignment.Center)
        ) {
            SpacerVertical(AppTheme.spaces.spaceS)
            Box(
                Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            SpacerVertical(AppTheme.spaces.spaceS)
            BodyLText(text = stringResource(R.string.loading))
        }

    }
}


@Composable
fun LoadingDialog(isLoading: Boolean = true, onDismiss: () -> Unit = {}) {
    if (isLoading) Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
    ) {

        Column(
            modifier = Modifier
                .width(188.dp)
                .height(164.dp)
                .background(AppTheme.colors.backgroundPrimary, shape = AppTheme.radius.radiusL)
        ) {
            SpacerVertical(AppTheme.spaces.spaceS)
            Box(
                Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            SpacerVertical(AppTheme.spaces.spaceS)
            BodyLText(text = stringResource(R.string.loading))
        }

    }
}

