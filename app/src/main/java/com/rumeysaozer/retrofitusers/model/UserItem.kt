package com.rumeysaozer.retrofitusers.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserItem(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String
):Serializable