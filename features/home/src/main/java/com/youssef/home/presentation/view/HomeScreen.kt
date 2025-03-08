package com.youssef.home.presentation.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.unpack
import com.youssef.home.presentation.contract.HomeUiAction
import com.youssef.home.presentation.contract.HomeUiState
import com.youssef.home.presentation.viewmodel.HomeViewModel
import com.youssef.ui_core.core.views.MainContent
import com.youssef.ui_core.theme.AppTheme

@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = hiltViewModel()) {

    val (uiState, onAction, sideEffect) = viewModel.unpack()
    HomeScreen(modifier, uiState, onAction)
}

@Composable
private fun HomeScreen(modifier: Modifier, uiState: HomeUiState, onAction: (HomeUiAction) -> Unit) {
    val listState = rememberLazyListState()
    MainContent(
        modifier = modifier,
        modifierContent = Modifier
            .fillMaxSize()
            .padding(AppTheme.spaces.spaceL),
        uiState = uiState,
        {
        },
        {
            LaunchedEffect(listState.firstVisibleItemIndex) {
                // Detect when user reaches the end of the list
                val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                if (uiState.loadingState == null && lastVisibleItemIndex == uiState.homeList.lastIndex) {
                    onAction.invoke(HomeUiAction.LoadHomeAction)
                }
            }
            LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
                items(uiState.homeList) { sections ->
                    sections.Render()
                }
                item {
                    if (uiState.loadingState == LoadingState.LoadMore) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                }
            }
        })

}
