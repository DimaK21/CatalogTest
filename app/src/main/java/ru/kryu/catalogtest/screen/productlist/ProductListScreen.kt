package ru.kryu.catalogtest.screen.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.kryu.catalogtest.domain.model.Product

@Composable
fun ProductList(
    viewModel: ProductListViewModel = hiltViewModel(),
    onClick: () -> Unit,
    onNavUp: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LazyColumn {
        items(uiState.productList) { product ->
            ProductItem(product, onClick)
        }
    }
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Column {
        Row {
            Image(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
            Column {
                Text(text = product.title, style = MaterialTheme.typography.bodySmall)
                Text(text = product.price.toString(), style = MaterialTheme.typography.bodySmall)
                Text(
                    text = product.priceOld.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
        Icon(Icons.Filled.FavoriteBorder, null, modifier = Modifier.clickable { })
    }
}