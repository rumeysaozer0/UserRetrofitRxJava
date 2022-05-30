package com.rumeysaozer.retrofitusers.service

import com.rumeysaozer.retrofitusers.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface UserAPI {
    @GET("public/v2/users")
    fun getUser(): Single<User>
}