@file:OptIn(ExperimentalMaterial3Api::class)

package ru.kryu.catalogtest.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.kryu.catalogtest.R
import ru.kryu.catalogtest.domain.model.Category
import ru.kryu.catalogtest.ui.theme.GrayMain
import ru.kryu.catalogtest.ui.theme.GreenMain

@Composable
fun MyTopAppBar(
    title: String?,
    colored: Boolean = true,
    navigationIcon: Boolean = false,
    shareIcon: Boolean = false,
    onBack: () -> Unit,
    share: () -> Unit,
) {
    TopAppBar(
        title = { title?.let { Text(text = it, style = MaterialTheme.typography.titleLarge) } },
        navigationIcon = {
            if (navigationIcon) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, stringResource(id = R.string.back))
                }
            }
        },
        actions = {
            if (shareIcon) {
                IconButton(onClick = share) {
                    Icon(Icons.Filled.Share, stringResource(id = R.string.back))
                }
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = if (colored) {
            TopAppBarDefaults.topAppBarColors(
                containerColor = GreenMain,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        } else {
            TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = GrayMain,
                navigationIconContentColor = GrayMain,
                actionIconContentColor = GrayMain
            )
        }
    )
}

@Composable
fun MyList(categories: List<Category>, onClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category, onClick)
        }
    }
}

@Composable
fun CategoryItem(category: Category, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (category.icon.isNotBlank()) {
            AsyncImage(
                model = category.icon,
                contentDescription = null,
                modifier = Modifier.size(36.dp),
            )
        }
        Text(text = category.title, style = MaterialTheme.typography.bodySmall)
    }
}