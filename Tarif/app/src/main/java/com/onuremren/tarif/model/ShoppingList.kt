package com.onuremren.tarif.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class ShoppingList (
    @ColumnInfo(name = "shoppingList")
    var shoppingList: String?

){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}