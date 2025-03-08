package com.youssef.ui_core.core.dialog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.youssef.ui_components.R
import com.youssef.ui_core.core.buttons.ButtonActionText
import com.youssef.ui_core.core.text.BodyMText
import com.youssef.ui_core.core.text.HeadlineSText
import com.youssef.ui_core.core.views.SpacerHorizontal
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme

@Composable
fun AlertDialogContent(
    title: String,
    message: String? = null,
    negativeButtonText: String = stringResource(R.string.cancel),
    positiveButtonText: String = stringResource(R.string.ok),
    isDismiss: Boolean = true,
    onNegativeClick: () -> Unit,
    onPositiveClick: () -> Unit
) {

    BaseDialogFull(isDismiss = isDismiss, onDismiss = onNegativeClick) { openAlertDialog ->
        HeadlineSText(text = title, isCenter = false)
        SpacerVertical(AppTheme.spaces.spaceL)
        message?.let {
            BodyMText(text = it, isCenter = false)
        }
        SpacerVertical(AppTheme.spaces.space2Xl)
        Row(modifier = Modifier
            .wrapContentSize()
            .align(Alignment.End)) {
            ButtonActionText(
                negativeButtonText,
                modifier = Modifier.wrapContentSize()
            ) {
                openAlertDialog.value = false
                onNegativeClick()
            }
            SpacerHorizontal(AppTheme.spaces.spaceS)
            ButtonActionText(
                positiveButtonText,
                modifier = Modifier.wrapContentSize()
            ) {
                openAlertDialog.value = false
                onPositiveClick()
            }
        }
    }

}