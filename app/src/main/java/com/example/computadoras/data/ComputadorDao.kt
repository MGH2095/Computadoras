package com.example.computadoras.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.computadoras.model.Computador


@Dao
interface ComputadorDao {
    @Query("SELECT *FROM computador")
    fun getAllData(): LiveData<List<Computador>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addComputador(computador: Computador)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateComputador(computador: Computador)

    @Delete
    suspend fun deleteComputador(computador: Computador)
}