package com.example.computadoras.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.computadoras.data.ComputadorDatabase
import com.example.computadoras.model.Computador
import com.example.computadoras.repository.ComputadorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComputadorViewModel (application: Application) : AndroidViewModel(application) {

    val getAllData:  LiveData<List<Computador>>

    private val repository: ComputadorRepository

    init {
        val computadorDao= ComputadorDatabase.getDatabase(application).computadorDao()
        repository= ComputadorRepository(computadorDao)
        getAllData=repository.getAllData
    }

    fun addComputador(computador: Computador){
        viewModelScope.launch (Dispatchers.IO){repository.addComputador(computador)  }
    }

    fun updateComputador(computador: Computador){
        viewModelScope.launch (Dispatchers.IO){repository.updateComputador(computador)  }
    }

    fun deleteComputador(computador: Computador){
        viewModelScope.launch (Dispatchers.IO){repository.deleteComputador(computador)  }
    }
}