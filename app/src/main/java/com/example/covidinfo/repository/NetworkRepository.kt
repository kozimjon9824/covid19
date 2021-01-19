package com.example.covidinfo.repository

import com.example.covidinfo.network.ApiService
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: ApiService){

      suspend fun getAllData()=apiService.getAllData()



}