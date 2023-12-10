package fr.upjv.quizo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.quizo.ui.model.QuizzItemUi
import fr.upjv.quizo.ui.model.toUI
import fr.upjv.quizo.data.repository.QuizzRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class QuizzViewModel : ViewModel() {
    private val quizzRepository: QuizzRepository by lazy { QuizzRepository() }
//    private val _questions: Flow<List<QuizzItemUi>>
//        get() = quizzRepository.selectAll().map { list ->
//            list.toUI()
//        }

    private val _questions: String
        get() = quizzRepository.selectAll()

    val questions = _questions

    fun insertNewQuestion(){
        viewModelScope.launch(Dispatchers.IO){
            quizzRepository.fetchData()
        }
    }

    fun deleteAllQuestions(){
        viewModelScope.launch(Dispatchers.IO)
        {
            quizzRepository.deleteAll()
        }
    }
}