package com.onuremren.tarif.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.database.EatDao

@Database(entities = [Eat::class], version = 1)
abstract class EatDatabase: RoomDatabase() {
    abstract fun eatDao(): EatDao

}