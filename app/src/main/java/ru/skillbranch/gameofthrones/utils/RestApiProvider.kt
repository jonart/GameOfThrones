package ru.skillbranch.gameofthrones.utils

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.skillbranch.gameofthrones.AppConfig
import java.util.concurrent.TimeUnit


object RestApiService {
    private val retrofit: Retrofit

    init {
        retrofit = buildRetrofit(buildOkHttpClient())
    }
    private fun buildOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun buildRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun buildGson(): Gson {
        return GsonBuilder().setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    fun getRetrofit():Api = retrofit.create(Api::class.java)
}