package com.onuremren.tarif.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.model.Menu

@Database(entities = [Menu::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao

}