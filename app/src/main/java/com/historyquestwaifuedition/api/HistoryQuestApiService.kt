package com.historyquestwaifuedition.api

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val READ_TIMEOUT = 10000L
const val CONNECT_TIMEOUT = 10000L

class HistoryQuestApi(context: Context) {

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("") // TODO
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(okHttpClient)
        .build()

    val service = retrofit.create(HistoryQuestApiService::class.java)
}

interface HistoryQuestApiService {

}