package com.onuremren.tarif.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.model.Menu
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface MenuDao {


    @Query("SELECT menu,menuid FROM menu")
    fun getMenuNameAndId(): Flowable<List<Menu>>

    @Query("SELECT * FROM menu WHERE menuid = :id")
    fun getMenuById(id: Int): Flowable<Menu>

    @Insert
    fun insert(menu: Menu): Completable

    @Delete
    fun delete(menu: Menu): Completable

}