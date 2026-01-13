package com.khalifapps.muslimgenz.data.remote.auth

import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginRequest
import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("users/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}

