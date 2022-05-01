package com.onuremren.tarif.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Menu(
    @ColumnInfo(name = "menu")
    var menu: String?,


) {
    @PrimaryKey(autoGenerate = true)
    var menuid: Int = 0
}