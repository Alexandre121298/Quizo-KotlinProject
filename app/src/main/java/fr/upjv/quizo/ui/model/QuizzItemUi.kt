package fr.upjv.quizo.ui.model

import fr.upjv.quizo.data.model.QuizzObject

data class QuizzItemUi (
    val question: String,
//    val reponses: List<String>,
//    val reponseCorrecte: List<String>
)

data class Header(
    val category: String,
)

data class Footer(
    val timestamp: Long,
)

fun List<QuizzObject>.toUI(): List<QuizzItemUi>{
    return map { item ->
        QuizzItemUi(
            question = item.Question,
//            reponses = item.Reponses,
//            reponseCorrecte = item.ReponsesCorrectes,
        )
    }
}