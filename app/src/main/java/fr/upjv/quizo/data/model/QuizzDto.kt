package fr.upjv.quizo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Locale.Category

data class QuizzDto(
    @Expose
    @SerializedName("question")
    val question: String,

    @Expose
    @SerializedName("category")
    val category: String,

    @Expose
    @SerializedName("answers")
    val answers: AnswersDto,
)


data class AnswersDto(
    @Expose
    @SerializedName("answer_a")
    val answerA: String,

    @Expose
    @SerializedName("answer_b")
    val answerB: String,

    @Expose
    @SerializedName("answer_c")
    val answerC: String,

    @Expose
    @SerializedName("answer_d")
    val answerD: String,
)

fun List<QuizzDto>.toRoom(): QuizzEntity {
    return this.map { quizzDto ->
        QuizzEntity(
            question = quizzDto.question,
            category = quizzDto.category,
            timestamp = System.currentTimeMillis(),
            reponseA = quizzDto.answers.answerA,
            reponseB = quizzDto.answers.answerB,
            reponseC = quizzDto.answers.answerC,
            reponseD = quizzDto.answers.answerD,
        )
    }.first()
}