package io.github.junrdev.recycler.ui.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.domain.model.WasteItem
import io.github.junrdev.recycler.domain.remote.WasteRepo

class WasteInfoViewModel(
    private val wateRepo: WasteRepo
) : ViewModel() {

    private val _myWastes: MutableLiveData<List<WasteItem>> = MutableLiveData()
    private val myWastes: LiveData<List<WasteItem>>
        get() = _myWastes

    private suspend fun getMyUploads(recyclerId : String) {
        val result = wateRepo.getFromDb(recyclerId)
        result.onSuccess {
            _myWastes.postValue(it)
        }

        result.onFailure {
            println("Failed to load waste : " + it.message.toString())
        }
    }


    suspend fun addToDb(recyclerId : String,wasteDto: WasteDto) : Result<WasteItem>{
        return wateRepo.addToDb(wasteDto, recyclerId)
    }

}