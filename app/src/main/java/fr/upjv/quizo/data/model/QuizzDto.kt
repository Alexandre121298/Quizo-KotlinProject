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

//    @Expose
//    @SerializedName("answers")
//    val reponses: List<String>,

//    @Expose
//    @SerializedName("correct_answers")
//    val reponsesCorrectes: List<String>,
)


//fun QuizzDto.toRoom(): QuizzEntity {
//    return QuizzEntity(
//        question = question,
//        reponses = reponses,
//        reponsesCorrectes = reponsesCorrectes
//    )
//}

fun List<QuizzDto>.toRoom(): QuizzEntity {
    return this.map { quizzDto ->
        QuizzEntity(
            question = quizzDto.question,
            category = quizzDto.category,
            timestamp = System.currentTimeMillis(),
            // Définissez les autres attributs en conséquence
            // reponses = quizzDto.reponses,
            // reponsesCorrectes = quizzDto.reponsesCorrectes
        )
    }.first()
}