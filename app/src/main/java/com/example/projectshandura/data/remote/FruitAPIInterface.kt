package com.example.jetpacknav.data.remote

import com.example.projectshandura.data.remote.model.FruitApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitAPIInterface {

    //Making a GET request to the API
    @GET("/api/fruit/{fruitName}")
    suspend fun getFruit(@Path("fruitName") name : String ) : Response<FruitApiModel>


}