package com.khalifapps.muslimgenz.data.remote.auth

import javax.inject.Inject

class AuthApiHelperImpl @Inject constructor(private val service: AuthApiService) : AuthApiHelper {
    // override suspend fun login(request: LoginRequest) = service.login(request)
}
