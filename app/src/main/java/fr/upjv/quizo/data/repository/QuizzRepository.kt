package fr.upjv.quizo.data.repository

import fr.upjv.quizo.architecture.CustomApplication
import fr.upjv.quizo.architecture.RetrofitBuilder
import fr.upjv.quizo.data.dao.QuizzDao
import fr.upjv.quizo.data.model.QuizzObject
import fr.upjv.quizo.data.model.toDomain
import fr.upjv.quizo.data.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuizzRepository {

    private val quizzDao = CustomApplication.instance.mApplicationDatabase.quizzDao()

    suspend fun fetchData(){
//        quizzDao.insert(RetrofitBuilder.getQuizz().getRandomQuestion().toRoom())
    }

    fun deleteAll() {
//        quizzDao.deleteAll()
    }

//    fun selectAll(): Flow<List<QuizzObject>> {
//        return quizzDao.selectAll().map { list ->
//            list.toDomain()
//        }
//    }

    fun selectAll(): String {
        return "test Repository"
    }
}