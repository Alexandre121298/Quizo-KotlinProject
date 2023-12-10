package fr.upjv.quizo.ui.model

import fr.upjv.quizo.data.model.QuizzObject

data class QuizzItemUi (
    val question: String,
//    val reponses: List<String>,
//    val reponseCorrecte: List<String>
)

//fun List<QuizzObject>.toUI(): List<QuizzItemUi>{
//    return map { item ->
//        QuizzItemUi(
//            question = item.Question,
////            reponses = item.Reponses,
////            reponseCorrecte = item.ReponsesCorrectes,
//        )
//    }
//}

fun List<QuizzObject>.toUI(): String{
    return "Test ItemUi"
}