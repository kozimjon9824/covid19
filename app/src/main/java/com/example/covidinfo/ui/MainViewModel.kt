package com.example.covidinfo.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.covidinfo.model.StateData
import com.example.covidinfo.repository.NetworkRepository
import com.example.covidinfo.util.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject  constructor(
    private val repository: NetworkRepository):ViewModel(){

    private  var data = MutableLiveData<Resource<StateData>>()

    fun getData():LiveData<Resource<StateData>>{
        loadData()
        return data
    }

    private fun loadData(){

         viewModelScope.launch {
             val m=repository.getAllData()
             if (m.isSuccessful){
                 data.value=Resource.success(repository.getAllData().body() as StateData)
             }else{
                 data.value= Resource.error((m.message() as String))
             }
         }
          }
    }
