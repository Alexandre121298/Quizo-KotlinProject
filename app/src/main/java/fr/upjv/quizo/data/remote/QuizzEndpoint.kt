package fr.upjv.quizo.data.remote

import fr.upjv.quizo.data.model.QuizzDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuizzEndpoint {
    @GET("questions?limit=1")
    suspend fun getRandomQuestion() : QuizzDto
}
