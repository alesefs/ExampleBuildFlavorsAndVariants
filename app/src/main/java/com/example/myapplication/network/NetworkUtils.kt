package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils(val path: String) {
    companion object {
        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}