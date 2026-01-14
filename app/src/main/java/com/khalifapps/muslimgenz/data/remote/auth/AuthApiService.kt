package com.khalifapps.muslimgenz.data.remote.auth

import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApiService {
    @FormUrlEncoded
    @POST("users/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}


