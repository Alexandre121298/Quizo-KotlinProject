package fr.upjv.quizo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.quizo.data.model.QuizzEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChuckNorrisDao {


    @Query("SELECT * FROM quizo_table ORDER BY question ASC")
    fun selectAll(): Flow<List<QuizzEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisEntity: QuizzEntity)


    @Query("DELETE FROM quizo_table")
    fun deleteAll()
}
