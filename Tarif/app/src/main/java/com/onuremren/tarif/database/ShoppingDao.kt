package com.onuremren.tarif.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.model.ShoppingList
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface ShoppingDao {


    @Query("SELECT shoppingList,id FROM shoppinglist")
    fun getListWithNameAndId(): Flowable<List<ShoppingList>>

    @Query("SELECT * FROM shoppinglist WHERE id = :id")
    fun getListById(id: Int): Flowable<ShoppingList>

    @Insert
    fun insert(shoppingList: ShoppingList): Completable

    @Delete
    fun delete(shoppingList: ShoppingList): Completable

}