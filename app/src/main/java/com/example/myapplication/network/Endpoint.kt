package com.example.myapplication.network

import retrofit2.Call
import retrofit2.http.*

interface Endpoint {
    @GET("posts")
    fun getPosts() : Call<List<PostsResponseModel>>
}