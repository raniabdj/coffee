package com.example.coffee.models

data class CoffeeItem(
    val description: String,
    val id: Int,
    val ingredients: List<String>,
    val title: String
)