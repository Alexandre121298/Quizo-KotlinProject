package fr.upjv.quizo.data.remote

import fr.upjv.quizo.data.model.QuizzDto
import retrofit2.http.GET

interface QuizzEndpoint {
    @GET("questions")
    suspend fun getRandomQuote() : QuizzDto
}
