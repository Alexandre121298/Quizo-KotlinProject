package fr.upjv.quizo.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.quizo.data.model.QuizzEntity
import fr.upjv.quizo.data.dao.QuizzDao

@Database(
    entities = [
        QuizzEntity::class,
    ],
    version = 4,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun quizzDao(): QuizzDao
}
