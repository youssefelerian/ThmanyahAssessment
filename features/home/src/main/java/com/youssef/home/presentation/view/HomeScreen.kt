package com.youssef.home.presentation.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.youssef.home.presentation.contract.HomeUiAction
import com.youssef.home.presentation.contract.HomeUiState
import com.youssef.home.presentation.viewmodel.HomeViewModel
import com.youssef.ui_core.core.views.MainContent
import com.youssef.ui_core.theme.AppTheme


@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = hiltViewModel()) {

  //  val (uiState, onAction, sideEffect) = viewModel.unpack()
    //HomeScreen(modifier, uiState, onAction)
}

@Composable
private fun HomeScreen(modifier: Modifier, uiState: HomeUiState, onAction: (HomeUiAction) -> Unit) {
    MainContent(
        modifier = modifier,
        modifierContent = Modifier
            .fillMaxSize()
            .padding(AppTheme.spaces.spaceL),
        uiState = uiState,
        {
        },
        {

        })
}