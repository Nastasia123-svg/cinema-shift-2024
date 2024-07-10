package com.example.api_ktx

import com.example.api_ktx.models.CinemaTodayResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Сервис для получения списка фильмов
 */
interface CinemaService {

    @GET("/cinema/today")
    suspend fun getAll(): CinemaTodayResponse


    // паттерн синглтон для получения еинственного экземпляра класса
    companion object {

        const val BASE_URL = "https://shift-backend.onrender.com/"
        private var INSTANCE: CinemaService? = null

        operator fun invoke(): CinemaService {
            if (INSTANCE == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CinemaService::class.java)
            }

            return INSTANCE!!
        }
    }
}