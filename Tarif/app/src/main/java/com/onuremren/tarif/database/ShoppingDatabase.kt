package com.onuremren.tarif.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.database.EatDao
import com.onuremren.tarif.model.ShoppingList

@Database(entities = [ShoppingList::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao

}