package com.example.covidinfo.network

import com.example.covidinfo.model.StateData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object{
        const val URL="https://api.covid19api.com/"
    }

    @GET("summary")
     suspend fun getAllData():Response<StateData>
}