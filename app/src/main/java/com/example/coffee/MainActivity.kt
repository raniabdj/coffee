package com.example.coffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffee.databinding.ActivityMainBinding
import com.example.coffee.models.CoffeeItem
import com.example.coffee.service.CoffeeRepository
import com.example.coffee.service.CoffeeService
import com.example.coffee.utils.SelectedCoffeeListner
import com.example.coffee.view.CoffeeAdapter
import com.example.coffee.viewModel.CoffeeViewModel
import com.example.coffee.viewModel.CoffeeViewModelFactory

class MainActivity : AppCompatActivity(), SelectedCoffeeListner{
    private lateinit var binding: ActivityMainBinding
   private val service=CoffeeService.getRetrofit()
    private val repository= CoffeeRepository(service)
    private val viewModel: CoffeeViewModel by lazy {
        ViewModelProvider(
            this,
            CoffeeViewModelFactory(repository)
        )[CoffeeViewModel::class.java]
    }
    private val coffeeAdapter = CoffeeAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("hellooo")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.coffeeList.layoutManager=LinearLayoutManager(this)

       configureObservers()
        viewModel.getCoffeeList()

        binding.coffeeList.adapter = coffeeAdapter

    }

   private fun configureObservers() {
      /*  viewModel.statusLiveData.observe(this) {
            when (it) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE

                    binding.errorText.visibility = View.GONE
                }

                Status.ERROR, null -> {
                    binding.progressBar.visibility = View.GONE

                    binding.errorText.visibility = View.VISIBLE
                }

                Status.SELECTED -> {

                }
            }
        }
*/
        println("----------------")

        viewModel.coffeeLiveData.observe(this) {
            println(it)
            coffeeAdapter.setCoffeeList(it)
        }
   }


    override fun onSlelectedCoffee(selected: CoffeeItem) {
        TODO("Not yet implemented")
    }
}