package com.youssef.ui_core.core.error


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.youssef.ui_components.R
import com.youssef.ui_core.core.buttons.ButtonPrimary
import com.youssef.ui_core.core.text.HeadlineSText
import com.youssef.ui_core.theme.AppTheme

@Composable
fun ErrorFullScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    title: String,
    message: String? = null,
    retry: String = stringResource(R.string.id_retry),
    retryAction: (() -> Unit)? = null
) {
    Column(
        modifier = modifier.padding(AppTheme.spaces.spaceL),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_error),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        HeadlineSText(text = title, isCenter = true)
        message?.let {
            Text(
                modifier = Modifier
                    .padding(AppTheme.spaces.spaceL)
                    .align(Alignment.CenterHorizontally),
                text = it,
                style = AppTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = AppTheme.colors.textPrimary
            )
        }
        retryAction?.let {
            ButtonPrimary(
                label = retry,
                onClick = {
                    retryAction()
                })
        }
    }
}