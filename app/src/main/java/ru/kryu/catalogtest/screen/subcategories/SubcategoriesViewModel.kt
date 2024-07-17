package ru.kryu.catalogtest.screen.subcategories

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kryu.catalogtest.domain.model.Category
import javax.inject.Inject

data class SubcategoriesUiState(
    val isLoading: Boolean = false,
    val subcategories: MutableList<Category> = mutableListOf(),
)

@HiltViewModel
class SubcategoriesViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SubcategoriesUiState())
    val uiState: StateFlow<SubcategoriesUiState> = _uiState.asStateFlow()
}