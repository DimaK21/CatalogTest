package ru.kryu.catalogtest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kryu.catalogtest.Destinations.CATEGORIES
import ru.kryu.catalogtest.Destinations.GOOD
import ru.kryu.catalogtest.Destinations.GOODS_LIST
import ru.kryu.catalogtest.Destinations.SUBCATEGORIES
import ru.kryu.catalogtest.screen.categories.Categories
import ru.kryu.catalogtest.screen.product.Product
import ru.kryu.catalogtest.screen.productlist.ProductList
import ru.kryu.catalogtest.screen.subcategories.Subcategories

object Destinations {
    const val CATEGORIES = "categories"
    const val SUBCATEGORIES = "subcategories"
    const val GOODS_LIST = "good_list"
    const val GOOD = "good"
}

@Composable
fun CatalogNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = CATEGORIES,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(CATEGORIES) {
            Categories(
                onClick = {
                    navController.navigate(SUBCATEGORIES)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(SUBCATEGORIES) {
            Subcategories(
                onClick = {
                    navController.navigate(GOODS_LIST)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(GOODS_LIST) {
            ProductList(
                onClick = {
                    navController.navigate(GOOD)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(GOOD) {
            Product(
                onNavUp = navController::navigateUp,
            )
        }
    }
}
