package ru.kryu.catalogtest.screen.productlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kryu.catalogtest.domain.model.Category
import ru.kryu.catalogtest.domain.model.Product
import ru.kryu.catalogtest.screen.product.ProductUiState
import javax.inject.Inject

data class ProductListUiState(
    val isLoading: Boolean = false,
    val productList: MutableList<Product> = mutableListOf(),
)

@HiltViewModel
class ProductListViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProductListUiState())
    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()
}