package fr.upjv.quizo.data.model

data class QuizzObject(
    val Question: String,
    val Category: String,
    val Timestamp: Long,
    val ReponseA: String?,
    val ReponseB: String?,
    val ReponseC: String?,
    val ReponseD: String?,
)

fun List<QuizzEntity>.toDomain(): List<QuizzObject> {
    return map { eachEntity ->
        QuizzObject(
            Question = eachEntity.question,
            Category = eachEntity.category,
            Timestamp = eachEntity.timestamp,
            ReponseA = eachEntity.reponseA,
            ReponseB = eachEntity.reponseB,
            ReponseC = eachEntity.reponseC,
            ReponseD = eachEntity.reponseD,
        )
    }
}

