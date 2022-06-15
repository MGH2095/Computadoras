package com.example.computadoras.repository

import androidx.lifecycle.LiveData
import com.example.computadoras.data.ComputadorDao
import com.example.computadoras.model.Computador

class ComputadorRepository(private val computadorDao: ComputadorDao) {
    val getAllData: LiveData<List<Computador>> = computadorDao.getAllData()

    suspend fun addComputador(computador: Computador){
        computadorDao.addComputador(computador)
    }

    suspend fun updateComputador(computador: Computador){
        computadorDao.updateComputador(computador)
    }

    suspend fun deleteComputador(computador: Computador){
        computadorDao.deleteComputador(computador)
    }

}