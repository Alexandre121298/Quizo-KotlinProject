package fr.upjv.quizo.ui.model

import fr.upjv.quizo.data.model.QuizzObject

//Todo: Sealed interface --> Mettre le header et le footer dedans
//Attention , c'est peut-etre ça qui empeche l'acces aux propriété

sealed interface QuizzItemUI
{
    data class QuizzItem (
        val question: String,
        val reponseA: String?,
        val reponseB: String?,
        val reponseC: String?,
        val reponseD: String?,
    ):QuizzItemUI

    data class Header(
        val category: String,
    ):QuizzItemUI

    data class Footer(
        val timestamp: Long,
    ):QuizzItemUI
}


fun List<QuizzObject>.toUI(): List<QuizzItemUI.QuizzItem>{
    return map { item ->
        QuizzItemUI.QuizzItem(
            question = item.Question,
            reponseA = item.ReponseA,
            reponseB = item.ReponseB,
            reponseC = item.ReponseC,
            reponseD = item.ReponseD,
        )
    }
}
