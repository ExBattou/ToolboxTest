package net.adrote.toolboxtest.ui.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("videoUrl")
    val videoUrl: String?
)