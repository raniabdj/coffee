package com.example.coffee.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffee.service.CoffeeRepository

class CoffeeViewModelFactory(private val repository: CoffeeRepository) : ViewModelProvider.Factory {

    override fun<T: ViewModel> create(modelClass: Class<T>):T{
        return  CoffeeViewModel(repository) as T
    }
}