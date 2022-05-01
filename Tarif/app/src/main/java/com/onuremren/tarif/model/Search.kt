package com.onuremren.tarif.model

import java.io.Serializable

data class Search(
    var name: String,
    var checked: Boolean
): Serializable {
}