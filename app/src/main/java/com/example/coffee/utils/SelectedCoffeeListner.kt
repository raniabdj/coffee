package com.example.coffee.utils

import com.example.coffee.models.Coffee

interface SelectedCoffeeListner {
    fun onSlelectedCoffee(selected: Coffee)
}