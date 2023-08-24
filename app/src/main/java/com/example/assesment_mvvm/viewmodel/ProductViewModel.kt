package com.example.assesment_mvvm.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment_mvvm.model.Product
import com.example.assesment_mvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    val productsRepo = ProductRepository()
    val productsLiveData = MutableLiveData<List<Product>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchProducts() {
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful) {
                productsLiveData.postValue(response.body()?.products)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}