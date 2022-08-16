package com.sem.roomexercise.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sem.roomexercise.data.localDB.TownDao
import com.sem.roomexercise.data.models.TownModel

class TownViewModel(private val townDao: TownDao) : ViewModel() {

    fun getAllTown() : List<TownModel> = townDao.getAll()

}

class TownViewModelFactory(
    private val townDao: TownDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TownViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TownViewModel(townDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}