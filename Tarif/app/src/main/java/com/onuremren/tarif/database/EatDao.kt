package com.onuremren.tarif.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.onuremren.tarif.model.Eat
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface EatDao {


    @Query("SELECT title,uid FROM eat")
    fun getEatWithNameAndId(): Flowable<List<Eat>>

    @Query("SELECT * FROM eat WHERE uid = :id")
    fun getEatById(id: Int): Flowable<Eat>

    @Insert
    fun insert(eat: Eat): Completable

    @Delete
    fun delete(eat: Eat): Completable

}