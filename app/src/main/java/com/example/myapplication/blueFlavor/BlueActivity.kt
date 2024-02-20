package com.example.myapplication.blueFlavor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.BuildConfig
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.network.Endpoint
import com.example.myapplication.network.NetworkUtils
import com.example.myapplication.network.PostsResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue)

        Toast.makeText(
            this,
            "Flavour: ${BuildConfig.FLAVOR} My type: ${BuildConfig.BUILD_TYPE}",
            Toast.LENGTH_SHORT
        ).show()

        val centerBtn: Button = findViewById(R.id.btnCenter)
        centerBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        getData()
    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        val textView = findViewById<TextView>(R.id.texto)

        callback.enqueue(object : Callback<List<PostsResponseModel>> {
            override fun onFailure(call: Call<List<PostsResponseModel>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<PostsResponseModel>>, response: Response<List<PostsResponseModel>>) {
                response.body()?.forEach {
                    textView.text = textView.text.toString().plus(it.body)
                }
            }
        })
    }
}