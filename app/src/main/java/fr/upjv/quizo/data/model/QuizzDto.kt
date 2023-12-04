package fr.upjv.quizo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QuizzDto(
    @Expose
    @SerializedName("question")
    val question: String,

    @Expose
    @SerializedName("answers")
    val reponses: List<String>,

    @Expose
    @SerializedName("correct_answers")
    val reponsesCorrectes: List<String>,
)