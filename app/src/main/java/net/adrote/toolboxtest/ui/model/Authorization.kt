package net.adrote.toolboxtest.ui.model


import com.google.gson.annotations.SerializedName

data class Authorization(
    @SerializedName("sub")
    val sub: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("type")
    val type: String?
)