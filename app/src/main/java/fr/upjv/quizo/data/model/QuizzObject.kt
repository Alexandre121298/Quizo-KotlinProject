package fr.upjv.quizo.data.model

data class QuizzObject(
    val Question: String,
    val Reponses: List<String>,
    val ReponsesCorrectes: List<String>,
)

fun List<QuizzEntity>.toDomain(): List<QuizzObject> {
    return map { eachEntity ->
        QuizzObject(
            Question = eachEntity.question,
            Reponses = eachEntity.reponses,
            ReponsesCorrectes = eachEntity.reponsesCorrectes,
        )
    }
}

