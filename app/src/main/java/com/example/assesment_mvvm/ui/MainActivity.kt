package com.example.assesment_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assesment_mvvm.databinding.ActivityMainBinding
import com.example.assesment_mvvm.model.Product
import com.example.assesment_mvvm.model.ProductAdapter
import com.example.assesment_mvvm.viewmodel.ProductViewModel


class MainActivity : AppCompatActivity() {
    val productViewModel: ProductViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductAdapter

    var productList: List<Product> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductAdapter(emptyList())
    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()

        productViewModel.productsLiveData.observe(this, Observer { productList ->

            var productAdapter = ProductAdapter(productList ?: emptyList())
            binding.rvProducts.layoutManager = GridLayoutManager(this,2)
            binding.rvProducts.adapter = productAdapter
            Toast
                .makeText(baseContext, "fetched ${productList?.size}products", Toast.LENGTH_LONG)
                .show()

        })


        productViewModel.errorLiveData.observe(this, Observer { error ->

            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()


        })
    }
}


