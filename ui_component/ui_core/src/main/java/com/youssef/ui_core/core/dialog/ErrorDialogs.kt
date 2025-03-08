package com.youssef.ui_core.core.dialog


import androidx.compose.foundation.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.youssef.ui_components.R
import com.youssef.ui_core.core.buttons.ButtonPrimary
import com.youssef.ui_core.core.text.BodyMText
import com.youssef.ui_core.core.text.HeadlineSText


@Composable
fun ShowErrorAlert(
    showDialog: Boolean,
    title: String?,
    message: String?,
    dismissText: String = stringResource(R.string.ok),
    onDismiss: (() -> Unit)? = null,
    isDismiss: Boolean = true,
) {
    val openAlertDialog = remember { mutableStateOf(showDialog) }
    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { onDismiss?.invoke() },
            title = {
                title?.let {
                    HeadlineSText(text = it, isCenter = true)
                }
            },
            text = {
                message?.let {
                    BodyMText(text = it, isCenter = true)
                }
            },
            icon = {
                Image(
                    painter = painterResource(R.drawable.ic_error),
                    contentDescription = "",
                    modifier = Modifier

                )
            },
            confirmButton = {
                onDismiss?.let {
                    ButtonPrimary(
                        label = dismissText,
                        onClick = {
                            onDismiss()
                            openAlertDialog.value = false
                        })
                }
            },
            properties = DialogProperties(dismissOnBackPress = true, isDismiss)
        )
    }
}

