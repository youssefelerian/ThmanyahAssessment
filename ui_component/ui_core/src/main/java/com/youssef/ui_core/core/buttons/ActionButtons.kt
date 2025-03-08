package com.youssef.ui_core.core.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.youssef.ui_core.theme.AppTheme


@Composable
fun ButtonPrimary(
    label: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    onClick: () -> Unit,
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.spaces.spaceL)
            .height(AppTheme.spaces.space5Xl)
            .then(modifier),
        shape = AppTheme.radius.radiusL,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.buttonPrimaryDefault,
            contentColor = AppTheme.colors.buttonTextPrimary,
            disabledContainerColor = AppTheme.colors.buttonPrimaryDisabled,
            disabledContentColor = AppTheme.colors.buttonTextDisabled
        ),
        enabled = isEnabled,
        onClick = {
            if (!isLoading && isEnabled) onClick.invoke()
        },
    ) {
        if (isLoading) CircularProgressIndicator(
            modifier = Modifier
                .size(AppTheme.spaces.space3Xl)
                .align(Alignment.CenterVertically),
            strokeWidth = AppTheme.spaces.spaceXs,
            color = AppTheme.colors.buttonTextPrimary
        )
        else Text(
            text = label, style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.buttonTextPrimary
        )

    }

}

@Composable
fun ButtonOutline(
    label: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {

    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.spaces.spaceL)
            .height(AppTheme.spaces.space5Xl)
            .then(modifier),
        shape = AppTheme.radius.radiusL,
        border = BorderStroke(AppTheme.spaces.border, AppTheme.colors.buttonPrimaryDefault),
        enabled = isEnabled,
        onClick = {
            if (isEnabled) onClick.invoke()
        },
    ) {
        Text(
            text = label, style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.buttonTextSecondary
        )

    }

}


@Composable
fun ButtonActionText(
    label: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isEnabled: Boolean = true,
    textColor: Color? = null,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .height(AppTheme.spaces.space5Xl)
            .then(modifier),
        enabled = isEnabled
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            style = AppTheme.typography.bodyLarge,
            color = textColor ?: AppTheme.colors.buttonTextSecondary,
            textAlign = TextAlign.Center,
            text = label
        )
    }
}