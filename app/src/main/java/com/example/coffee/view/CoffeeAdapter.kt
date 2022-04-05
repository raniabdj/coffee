package com.example.coffee.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee.databinding.CoffeeRowItemBinding
import com.example.coffee.models.CoffeeItem
import com.example.coffee.utils.SelectedCoffeeListner


class CoffeeAdapter(private val listner:SelectedCoffeeListner): RecyclerView.Adapter<CoffeeViewHolder>() {
    private val coffeeList=mutableListOf<CoffeeItem>()
    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    fun setCoffeeList(list:List<CoffeeItem>){
        coffeeList.clear()
        coffeeList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):CoffeeViewHolder{
        val inflater = LayoutInflater.from(parent.context)


        val binding = CoffeeRowItemBinding.inflate(inflater, parent,false)
        return CoffeeViewHolder(binding)


    }
    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int){
        val currentCoffee=coffeeList[position]
        holder.binding.coffeeTitle.text=currentCoffee.title
        holder.binding.coffeeDescription.text=currentCoffee.description

       // holder.itemView.setOnClickListener(
         //   listner.onSlelectedCoffee(currentCoffee)
        //)



    }

    override fun getItemCount() = coffeeList.size
}

class CoffeeViewHolder(val binding: CoffeeRowItemBinding): RecyclerView.ViewHolder(binding.root)