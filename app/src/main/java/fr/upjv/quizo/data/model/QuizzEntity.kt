package fr.upjv.quizo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quizo_table")
data class QuizzEntity(
    @ColumnInfo(name = "question")
    val question: String,


//    @ColumnInfo(name = "reponses")
//    val reponses: List<String>,
//
//    @ColumnInfo(name = "reponsesCorrectes")
//    val reponsesCorrectes: List<String>
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
