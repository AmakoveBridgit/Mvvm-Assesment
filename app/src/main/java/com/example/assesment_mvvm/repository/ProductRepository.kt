package com.example.assesment_mvvm.repository



import com.example.assesment_mvvm.api.ApiClient
import com.example.assesment_mvvm.api.ApiInterface
import com.example.assesment_mvvm.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts(): Response<ProductResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.getProducts()
        }

    }
}