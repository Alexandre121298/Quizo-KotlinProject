package fr.upjv.quizo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.Locale.Category

@Entity(tableName = "quizo_table")
data class QuizzEntity(
    @ColumnInfo(name = "question")
    val question: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "time_stamp")
    val timestamp: Long

//    @ColumnInfo(name = "reponses")
//    val reponses: List<String>,
//
//    @ColumnInfo(name = "reponsesCorrectes")
//    val reponsesCorrectes: List<String>
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
