package ru.kryu.catalogtest.screen.product

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.kryu.catalogtest.screen.categories.CategoriesViewModel
import ru.kryu.catalogtest.utils.MyTopAppBar

@Composable
fun Product(
    viewModel: ProductViewModel = hiltViewModel(),
    onNavUp: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MyTopAppBar(
        title = "Категории",
        colored = false,
        navigationIcon = true,
        shareIcon = true,
        onBack = onNavUp,
        share = {},
    )
}