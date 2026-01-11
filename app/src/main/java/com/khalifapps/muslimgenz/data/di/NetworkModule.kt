package com.khalifapps.muslimgenz.data.di

import com.khalifapps.muslimgenz.data.remote.ApiConstant
import com.khalifapps.muslimgenz.data.remote.auth.AuthApiService
import com.khalifapps.muslimgenz.data.remote.auth.AuthApiHelper
import com.khalifapps.muslimgenz.data.remote.auth.AuthApiHelperImpl
import com.khalifapps.muslimgenz.data.remote.interceptor.HeaderInterceptor
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = ApiConstant.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val prettyLogger = LoggingInterceptor.Builder()
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .addHeader("version", "1")
            .build()
            
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(prettyLogger)
            .connectTimeout(ApiConstant.TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .readTimeout(ApiConstant.TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(ApiConstant.TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApiHelper(apiHelper: AuthApiHelperImpl): AuthApiHelper = apiHelper
}
