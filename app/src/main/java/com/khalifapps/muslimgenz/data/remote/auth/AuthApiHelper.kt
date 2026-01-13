package com.khalifapps.muslimgenz.data.remote.auth

import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginRequest
import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginResponse
import retrofit2.Response

interface AuthApiHelper {
    suspend fun login(request: LoginRequest): Response<LoginResponse>
}

