package ru.kryu.catalogtest.screen.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.kryu.catalogtest.utils.MyList
import ru.kryu.catalogtest.utils.MyTopAppBar

@Composable
fun Categories(
    viewModel: CategoriesViewModel = hiltViewModel(),
    onClick: () -> Unit,
    onNavUp: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column {
        MyTopAppBar(
            title = "Категории",
            colored = true,
            navigationIcon = false,
            shareIcon = false,
            onBack = {},
            share = {},
        )
        MyList(categories = uiState.subcategories, onClick = onClick)
    }
}
