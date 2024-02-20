package com.example.myapplication.network

import com.google.gson.annotations.SerializedName

data class PostsResponseModel(
    @SerializedName("userId")
    var userId : Int,
    @SerializedName("id")
    var id : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("body")
    var body : String
)