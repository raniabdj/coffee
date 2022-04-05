package com.example.coffee.utils

import com.example.coffee.models.Coffee
import com.example.coffee.models.CoffeeItem

interface SelectedCoffeeListner {
    fun onSlelectedCoffee(selected: CoffeeItem)
}