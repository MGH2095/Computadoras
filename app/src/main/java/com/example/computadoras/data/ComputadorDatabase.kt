package com.example.computadoras.data
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.computadoras.model.Computador


@Database(entities = [Computador::class], version = 1, exportSchema = false)
abstract class ComputadorDatabase :RoomDatabase() {
    abstract  fun computadorDao():ComputadorDao

    companion object{
        @Volatile
        private var INSTANCE: ComputadorDatabase?=null

        fun getDatabase(context: android.content.Context):ComputadorDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComputadorDatabase::class.java,
                    "computador_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}