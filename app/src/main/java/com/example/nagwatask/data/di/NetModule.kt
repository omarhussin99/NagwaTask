package com.example.nagwatask.data.di

import android.annotation.SuppressLint
import com.example.nagwatask.BuildConfig
import com.example.nagwatask.data.remote.ApiServices

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetModule {
    @Provides
    @JvmStatic
    fun provideLoggingInterceptor() : HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @JvmStatic
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) : OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @JvmStatic
    fun provideApiService(retrofit: Retrofit) : ApiServices{
        return retrofit.create(ApiServices::class.java)
    }
}