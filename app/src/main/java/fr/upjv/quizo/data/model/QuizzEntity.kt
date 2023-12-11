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
    val timestamp: Long,

    @ColumnInfo(name = "reponse_a")
    val reponseA: String,

    @ColumnInfo(name = "reponse_b")
    val reponseB: String,

    @ColumnInfo(name = "reponse_c")
    val reponseC: String,

    @ColumnInfo(name = "reponse_d")
    val reponseD: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
