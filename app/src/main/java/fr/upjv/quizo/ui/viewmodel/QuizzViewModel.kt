package fr.upjv.quizo.ui.viewmodel

//import fr.upjv.quizo.ui.model.QuizzItemUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.quizo.data.repository.QuizzRepository
import fr.upjv.quizo.ui.model.QuizzItemUI
import fr.upjv.quizo.ui.model.toUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class QuizzViewModel : ViewModel() {
    private val quizzRepository: QuizzRepository by lazy { QuizzRepository() }
    private val _questions: Flow<List<QuizzItemUI>>
        get() = quizzRepository.selectAll().map { list ->
            list.groupBy { category ->
                category.Category
            }
                .flatMap {
                    buildList {
                        add(
                            QuizzItemUI.Header(
                                category = it.key,
                            )
                        )
                        addAll(it.value.toUI())
                    }
                }
            //list.toUI()
        }

    val questions = _questions

    fun insertNewQuestion(){
        viewModelScope.launch(Dispatchers.IO){
            deleteAllQuestions()
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