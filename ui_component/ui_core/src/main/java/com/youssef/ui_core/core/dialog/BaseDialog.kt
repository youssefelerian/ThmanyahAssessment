package com.youssef.ui_core.core.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.youssef.ui_core.theme.AppTheme


@Composable
fun BaseDialogFull(
    isDismiss: Boolean = true,
    isPadding: Boolean = true,
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.(openAlertDialog: MutableState<Boolean>) -> Unit
) {
    val openAlertDialog = remember { mutableStateOf(true) }
    if (openAlertDialog.value) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = isDismiss,
                usePlatformDefaultWidth = false
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = AppTheme.colors.backgroundOverlay)
            ) {
                if (isDismiss) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            openAlertDialog.value = false
                            onDismiss()
                        })
                }
                Card(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(unbounded = true)
                        .padding(AppTheme.spaces.space2Xl)
                        .align(Alignment.Center),
                    shape = AppTheme.radius.radiusL,
                    colors = CardDefaults.cardColors(
                        containerColor = AppTheme.colors.cardBackground,
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = AppTheme.spaces.defaultElevation
                    )
                ) {
                    if (isPadding) {
                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(AppTheme.spaces.space2Xl)
                        ) {
                            content(openAlertDialog)
                        }
                    } else {
                        content(openAlertDialog)
                    }
                }
            }
        }
    }
}

