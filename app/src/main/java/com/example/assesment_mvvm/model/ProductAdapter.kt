package com.example.assesment_mvvm.model



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(var productList: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        val binding = holder.binding



//        binding.tvId.text = currentProduct.id.toString()
//        binding.tvTitle.text = currentProduct.title.toString()
//        binding.tvDescription.text = currentProduct.description.toString()
//        binding.tvPrice.text = currentProduct.price.toString()
//        binding.tvRatings.text = currentProduct.rating.toString()
//        binding.tvStock.text = currentProduct.stock.toString()
//        binding.tvCategory.text = currentProduct.category.toString()




    }

    override fun getItemCount(): Int {
        return productList.size

    }
}

class ProductViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)