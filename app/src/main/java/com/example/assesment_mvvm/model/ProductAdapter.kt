package com.example.assesment_mvvm.model


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment_mvvm.databinding.ActivityProductListBinding


class ProductAdapter(var productList: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {
    lateinit var binding: ActivityProductListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ActivityProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        val binding = holder.binding
        binding.tvBody.text = currentItem.body
        binding.tvId.text = currentItem.id.toString()
        binding.tvTitle.text = currentItem.title
        binding.tvUserId.text = currentItem.userId.toString()


    }

    override fun getItemCount(): Int {
        return productList.size

    }
}

class ProductViewHolder(var binding: ActivityProductListBinding) :
    RecyclerView.ViewHolder(binding.root)









