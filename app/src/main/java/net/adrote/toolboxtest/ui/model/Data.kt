package net.adrote.toolboxtest.ui.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?
)