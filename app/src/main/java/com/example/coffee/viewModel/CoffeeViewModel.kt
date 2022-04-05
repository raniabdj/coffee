package com.example.coffee.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffee.models.Coffee
import com.example.coffee.models.CoffeeItem
import com.example.coffee.service.CoffeeRepository
import com.example.coffee.utils.Status
import kotlinx.coroutines.*

class CoffeeViewModel(private val repository: CoffeeRepository): ViewModel() {
    private val _coffeeLiveData= MutableLiveData<ArrayList<CoffeeItem>>()
    val coffeeLiveData: LiveData<ArrayList<CoffeeItem>>
        get() = _coffeeLiveData

    private val _statusLiveData = MutableLiveData<Status>()
    val statusLiveData: LiveData<Status>
        get() = _statusLiveData

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Exception handled: ${throwable.localizedMessage}")
    }
    fun getCoffeeList() {
        println("---------- 1 ----")

        _statusLiveData.postValue(Status.LOADING)

            try {
        CoroutineScope(Dispatchers.IO ).launch {

            val response = repository.getResults()
            println(response)
            println("---------- 3 ------")
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    _coffeeLiveData.postValue(response.body())
                    _statusLiveData.postValue(Status.SUCCESS)
                } else {
                    _statusLiveData.postValue(Status.ERROR)
                }
            }

        }
            }catch (err:Error){
            println("------------ 2 ----------")
                println(err)

            }
        println("---------- 3 ----")

    }

    fun selectedCoffee() {
        _statusLiveData.value = Status.SELECTED
    }


}