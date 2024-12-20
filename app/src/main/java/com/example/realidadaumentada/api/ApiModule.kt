package com.example.proyectocafee.api

import com.example.proyectocafe.util.ConstantsKotlin.Companion.BASE_URL_GET
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

private fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL_GET)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

private fun provideService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

val networkModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(),get()) }
    single { provideService(get()) }
}

