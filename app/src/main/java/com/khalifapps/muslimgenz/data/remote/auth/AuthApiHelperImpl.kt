package com.khalifapps.muslimgenz.data.remote.auth

import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginRequest
import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class AuthApiHelperImpl @Inject constructor(
    private val service: AuthApiService
) : AuthApiHelper {
    override suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return service.login(request)
    }
}

