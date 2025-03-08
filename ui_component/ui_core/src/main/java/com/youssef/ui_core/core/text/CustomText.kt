package com.youssef.ui_core.core.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import com.youssef.ui_core.theme.AppTheme

@Composable
fun HeadlineLText(
    text: String, modifier: Modifier = Modifier.fillMaxWidth(), isCenter: Boolean = true
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.headlineLarge,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = AppTheme.colors.textPrimary
    )
}

@Composable
fun HeadlineMText(
    text: String, modifier: Modifier = Modifier.fillMaxWidth(), isCenter: Boolean = true
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.headlineMedium,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = AppTheme.colors.textPrimary
    )
}

@Composable
fun HeadlineSText(
    text: String, modifier: Modifier = Modifier.fillMaxWidth(), isCenter: Boolean = true
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.headlineSmall,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = AppTheme.colors.textPrimary
    )
}

@Composable
fun BodyLText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textPrimary
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.bodyLarge.copy(textDirection = TextDirection.Content),
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color
    )
}

@Composable
fun BodyMText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textPrimary,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.bodyMedium.copy(textDirection = TextDirection.Content),
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun BodySText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textSecondary,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.bodySmall.copy(textDirection = TextDirection.Content),
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color,
        maxLines = maxLines
    )
}


@Composable
fun LabelSText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textSecondary
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.labelSmall.copy(textDirection = TextDirection.Content),
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color
    )
}

@Composable
fun LabelSBoldText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textSecondary,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.labelMedium.copy(textDirection = TextDirection.Content),
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color,
        maxLines = maxLines
    )
}

@Composable
fun TitleLText(
    text: String,
    modifier: Modifier = Modifier.wrapContentSize(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textPrimary
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.titleLarge,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color
    )
}

@Composable
fun TitleMText(
    text: String,
    modifier: Modifier = Modifier.wrapContentSize(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textPrimary
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTheme.typography.titleMedium,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color
    )
}

@Composable
fun TitleSText(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isCenter: Boolean = true,
    color: Color = AppTheme.colors.textSecondary
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        style = AppTheme.typography.titleSmall,
        textAlign = if (isCenter) TextAlign.Center else null,
        color = color
    )
}
