package fr.upjv.quizo.architecture

import com.google.gson.GsonBuilder
import fr.upjv.quizo.data.remote.QuizzEndpoint
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://quizapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getQuizz(): QuizzEndpoint = retrofit.create(QuizzEndpoint::class.java)
}
