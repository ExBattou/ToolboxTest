package net.adrote.toolboxtest.api

import com.google.gson.annotations.SerializedName

data class AuthRequest (
    @SerializedName("sub")
    val sub: String
)