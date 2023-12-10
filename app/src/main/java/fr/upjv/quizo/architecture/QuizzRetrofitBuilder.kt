package fr.upjv.quizo.architecture

import com.google.gson.GsonBuilder
import fr.upjv.quizo.data.remote.QuizzEndpoint
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // Réécrire la requête pour ajouter le jeton Bearer
        val newRequest = chain.request().newBuilder()
            .header("Authorization", "Bearer cT5hnnmD4yXklIYQyWiHNWCtoMtOo6KLez5E8TSf")
            .build()

        return chain.proceed(newRequest)
    }
}

object RetrofitBuilder {

    private val interceptor = TokenInterceptor()

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://quizapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getQuizz(): QuizzEndpoint = retrofit.create(QuizzEndpoint::class.java)
}
