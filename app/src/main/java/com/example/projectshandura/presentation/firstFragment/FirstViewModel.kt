package com.example.projectshandura.presentation.firstFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectshandura.data.local.FruitDB
import com.example.projectshandura.data.local.model.Fruit
import com.example.projectshandura.domain.FruitUseCase
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {
    private val fruitUseCase = FruitUseCase

    val fruits = MutableLiveData<ArrayList<Fruit>>()

    fun getFruits() {
        viewModelScope.launch {
            fruits.postValue(fruitUseCase.getFruits())
        }
    }
}