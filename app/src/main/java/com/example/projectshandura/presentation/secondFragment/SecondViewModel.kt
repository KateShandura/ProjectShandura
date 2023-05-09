package com.example.projectshandura.presentation.secondFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectshandura.domain.FruitUseCase
import kotlinx.coroutines.launch

class SecondViewModel:ViewModel() {
    private val fruitUseCase = FruitUseCase

    val nutritions = MutableLiveData<String>()

    fun getData(name:String){
        viewModelScope.launch {
            val data = fruitUseCase.getFruitNutritions(name)

            nutritions.postValue(data)
        }
    }
}