package com.example.computadoras.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "computador")
data class Computador(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Marca")
    val marca:String,
    @ColumnInfo(name = "Modelo")
    val modelo:String?,
    @ColumnInfo(name = "Serie")
    val serie:String?,
    @ColumnInfo(name = "Almacenamiento")
    val Almacenamiento:String?,
    @ColumnInfo(name = "RAM")
    val ram:String?,
    @ColumnInfo(name = "rutaImagen")
    val rutaImagen:String?

): Parcelable