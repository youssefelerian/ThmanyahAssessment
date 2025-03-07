package com.youssef.home.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.youssef.base.presntation.viewmodel.uimodel.unpack
import com.youssef.home.domain.entity.content.AudioArticleEntity
import com.youssef.home.domain.entity.content.AudioBookEntity
import com.youssef.home.domain.entity.content.EpisodeEntity
import com.youssef.home.domain.entity.content.PodcastEntity
import com.youssef.home.presentation.contract.HomeUiAction
import com.youssef.home.presentation.contract.HomeUiState
import com.youssef.home.presentation.viewmodel.HomeViewModel
import com.youssef.ui_core.core.text.TitleLText
import com.youssef.ui_core.core.views.MainContent
import com.youssef.ui_core.theme.AppTheme
import com.youssef.uikit.podcast.PodcastView
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.youssef.home.domain.entity.content.ContentEntity
import com.youssef.home.domain.entity.type.HomeType
import com.youssef.ui_core.core.views.SpacerVertical
import com.youssef.uikit.line_grid.OneRowGrid
import com.youssef.uikit.two_row_grid.TwoRowGrid

@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = hiltViewModel()) {

    val (uiState, onAction, sideEffect) = viewModel.unpack()
    HomeScreen(modifier, uiState, onAction)
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
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(uiState.home?.sections ?: listOf()) { sections ->
                    TitleLText(sections.name)
                    SpacerVertical(AppTheme.spaces.spaceS)
                    if (sections.type == HomeType.TWO_LINES_GRID){
                        TwoGrid(sections.content)
                    }else{
                        OneGrid(sections.content)
                    }

                }
            }
        })

}

@Composable
fun TwoGrid(items: List<ContentEntity>) {
    TwoRowGrid(AppTheme.spaces.space200) {
        items(items) { content ->
            when (content) {
                is PodcastEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is EpisodeEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is AudioBookEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is AudioArticleEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }
            }
        }
    }
}

@Composable
fun OneGrid(items: List<ContentEntity>) {
    OneRowGrid(AppTheme.spaces.space200) {
        items(items) { content ->
            when (content) {
                is PodcastEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is EpisodeEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is AudioBookEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }

                is AudioArticleEntity -> {
                    PodcastView(content.avatarUrl, title = content.name)
                }
            }
        }
    }
}