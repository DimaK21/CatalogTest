package ru.kryu.catalogtest.screen.categories

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kryu.catalogtest.domain.model.Category
import javax.inject.Inject

data class CategoriesUiState(
    val isLoading: Boolean = false,
    val subcategories: MutableList<Category> = mutableListOf(),
)

@HiltViewModel
class CategoriesViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState: StateFlow<CategoriesUiState> = _uiState.asStateFlow()
}