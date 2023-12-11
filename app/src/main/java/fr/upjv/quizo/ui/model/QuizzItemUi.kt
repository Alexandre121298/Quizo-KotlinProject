package fr.upjv.quizo.ui.model

import fr.upjv.quizo.data.model.QuizzObject

//Todo: Sealed interface --> Mettre le header et le footer dedans
//Attention , c'est peut-etre ça qui empeche l'acces aux propriété

sealed interface QuizzItemUI
{
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
}


fun List<QuizzObject>.toUI(): List<QuizzItemUI.QuizzItemUi>{
    return map { item ->
        QuizzItemUI.QuizzItemUi(
            question = item.Question,
//            reponses = item.Reponses,
//            reponseCorrecte = item.ReponsesCorrectes,
        )
    }
}
