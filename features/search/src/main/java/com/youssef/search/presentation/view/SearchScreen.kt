package com.youssef.search.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.youssef.base.presntation.viewmodel.uimodel.unpack
import com.youssef.search.presentation.contract.SearchUiAction
import com.youssef.search.presentation.contract.SearchUiState
import com.youssef.search.presentation.viewmodel.SearchViewModel
import com.youssef.ui_core.core.text.BodyMText
import com.youssef.ui_core.core.views.MainContent
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.ui_core.theme.AppTheme

@Composable
fun SearchScreen(modifier: Modifier, viewModel: SearchViewModel = hiltViewModel()) {
    val (uiState, onAction, sideEffect) = viewModel.unpack()
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = modifier) {
        TextField(
            value = searchQuery.value,
            onValueChange = {
                searchQuery.value = it
                onAction(SearchUiAction.SearchAction(it.text))
            },
            placeholder = { BodyMText("Search...", isCenter = false) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppTheme.colors.textPrimary,
                unfocusedTextColor = AppTheme.colors.textPrimary
            )
        )

        SpacerVertical(AppTheme.spaces.spaceL)
        SearchScreen(uiState)
    }

}

@Composable
private fun SearchScreen(uiState: SearchUiState) {
    MainContent(
        modifier = Modifier.fillMaxSize(),
        modifierContent = Modifier
            .fillMaxSize()
            .padding(AppTheme.spaces.spaceL),
        uiState = uiState,
        {},
        {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(uiState.searchList) { sections ->
                    sections.Render()
                }
            }
        })

}
