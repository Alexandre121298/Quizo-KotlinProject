package fr.upjv.quizo.data.remote

import fr.upjv.quizo.data.model.QuizzDto
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.security.auth.callback.Callback

interface QuizzEndpoint {
    @GET("questions?apiKey=bedvCvnBMp7W13OSeVPDmMBDX2po5kWpnDP6PWBE&limit=1")
    suspend fun getRandomQuestion() : List<QuizzDto>
}
