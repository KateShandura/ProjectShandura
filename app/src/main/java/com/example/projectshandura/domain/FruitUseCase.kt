package com.example.projectshandura.domain

import com.example.jetpacknav.data.remote.FruitRepository
import com.example.projectshandura.data.local.FruitDB
import com.example.projectshandura.data.local.model.Fruit
import com.example.projectshandura.data.remote.model.FruitApiModel

object FruitUseCase {

    private val localFruits = FruitDB()
    private val fruitRepo = FruitRepository
    

    suspend fun getFruitNutritions(name: String) : String {
        var fruit = fruitRepo.getFruit(name)
        if(fruit!= null){
            var stringResult = preparingStringForOutput(fruit.nutritions)
            return stringResult
        }
        return "Mistake in the fruit name"
    }

    fun getFruits() : ArrayList<Fruit>{
        var fruits = ArrayList<Fruit>()
        fruits.add(localFruits.apple)
        fruits.add(localFruits.banana)
        fruits.add(localFruits.strawberry)
        return fruits
    }

    fun preparingStringForOutput( map : Map<String, Double>) : String {

        var result = "Calories: " + map.get("calories") +
                "\nFat: " + map.get("fat") +
                "\nSugar: " + map.get("sugar") +
                "\nCarbohydrates: " + map.get("carbohydrates") +
                "\nProtein: " + map.get("protein")
        return result
    }
}