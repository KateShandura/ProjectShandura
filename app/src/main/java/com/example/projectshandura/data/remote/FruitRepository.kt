package com.example.jetpacknav.data.remote

import com.example.projectshandura.data.remote.model.FruitApiModel

object FruitRepository {
    private val api = ApiFactory.fruitApi

    suspend fun getFruit(name: String): FruitApiModel? {
        val response = api.getFruit(name)
        if(response.isSuccessful){
            if(response.body() != null){
                val body = response.body()
                return body!!
            }
        }
        return null
    }
}