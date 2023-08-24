package com.example.assesment_mvvm.api



import com.example.assesment_mvvm.model.Product
import com.example.assesment_mvvm.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/product")
    suspend   fun getProducts():Response<ProductResponse>

    suspend  fun getProduct(@Path("id")productId: Int): Response<Product>
}