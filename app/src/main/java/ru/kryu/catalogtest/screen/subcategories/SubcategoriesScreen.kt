package ru.kryu.catalogtest.screen.subcategories

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.kryu.catalogtest.utils.MyList
import ru.kryu.catalogtest.utils.MyTopAppBar

@Composable
fun Subcategories(
    viewModel: SubcategoriesViewModel = hiltViewModel(),
    onClick: () -> Unit,
    onNavUp: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column {
        MyTopAppBar(
            title = "Подкатегория",
            colored = true,
            navigationIcon = true,
            shareIcon = false,
            onBack = onNavUp,
            share = {},
        )
        MyList(categories = uiState.subcategories, onClick = onClick)
    }
}