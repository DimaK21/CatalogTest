package ru.kryu.catalogtest.data.network

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kryu.catalogtest.R
import ru.kryu.catalogtest.utils.ConnectionChecker
import javax.inject.Inject

class RetrofitNetworkClient @Inject constructor(
    private val apiService: ApiService,
    private val context: Context
) : NetworkClient {
    override suspend fun doRequest(request: Request): Response {
        return if (!ConnectionChecker.isConnected(context)) {
            Response().apply {
                resultCode = CODE_NO_INTERNET
                text = context.resources.getString(R.string.check_connection)
            }
        } else {
            withContext(Dispatchers.IO) {
                when (request) {
                    is Request.CategoryRequest -> getCategories()
                    is Request.ProductSlugRequest -> getProductSlugs(request.slug)
                    is Request.ProductRequest -> getProducts(request.slug)
                }
            }
        }
    }

    private suspend fun getCategories(): Response {
        return try {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                response.body()!!.apply {
                    resultCode = response.code()
                }
            } else {
                Response().apply {
                    resultCode = response.code()
                    text = response.message()
                }
            }
        } catch (e: Exception) {
            Response().apply {
                resultCode = CODE_EXCEPTION
                text = e.message
            }
        }
    }

    private suspend fun getProductSlugs(slug: String): Response {
        return try {
            val response = apiService.getProductSlugs(slug)
            if (response.isSuccessful) {
                response.body()!!.apply {
                    resultCode = response.code()
                }
            } else {
                Response().apply {
                    resultCode = response.code()
                    text = response.message()
                }
            }
        } catch (e: Exception) {
            Response().apply {
                resultCode = CODE_EXCEPTION
                text = e.message
            }
        }
    }

    private suspend fun getProducts(slug: String): Response {
        return try {
            val response = apiService.getProducts(slug)
            if (response.isSuccessful) {
                response.body()!!.apply {
                    resultCode = response.code()
                }
            } else {
                Response().apply {
                    resultCode = response.code()
                    text = response.message()
                }
            }
        } catch (e: Exception) {
            Response().apply {
                resultCode = CODE_EXCEPTION
                text = e.message
            }
        }
    }


    companion object {
        const val CODE_NO_INTERNET = -1
        const val CODE_EXCEPTION = -2
        const val CODE_SUCCESS = 200
    }
}