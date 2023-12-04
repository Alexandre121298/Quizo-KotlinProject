package fr.upjv.quizo.architecture

import com.google.gson.GsonBuilder
import fr.upjv.quizo.data.remote.QuizzEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getChuckNorrisQuote(): QuizzEndpoint = retrofit.create(QuizzEndpoint::class.java)
}
