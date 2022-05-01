package com.onuremren.tarif.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

class Eat (
    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "malzeme")
    var malzeme:String?,

    @ColumnInfo(name = "tarif")
    var tarif: String?,

    @ColumnInfo(name = "image")
    var image: ByteArray?,


        ) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

}