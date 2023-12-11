package fr.upjv.quizo.data.model

data class QuizzObject(
    val Question: String,
    val Category: String,
    val Timestamp: Long,
//    val Reponses: List<String>,
//    val ReponsesCorrectes: List<String>,
)

fun List<QuizzEntity>.toDomain(): List<QuizzObject> {
    return map { eachEntity ->
        QuizzObject(
            Question = eachEntity.question,
            Category = eachEntity.category,
            Timestamp = eachEntity.timestamp,
//            Reponses = eachEntity.reponses,
//            ReponsesCorrectes = eachEntity.reponsesCorrectes,
        )
    }
}

