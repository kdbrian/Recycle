package io.github.junrdev.recycler.ui.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.domain.model.WasteItem
import io.github.junrdev.recycler.domain.remote.WasteRepo
import kotlinx.coroutines.launch

class WasteInfoViewModel(
    private val wateRepo: WasteRepo
) : ViewModel() {

    private val currUserId = Firebase.auth.currentUser?.uid

    private val _myWastes: MutableLiveData<List<WasteItem>> = MutableLiveData()
    private val myWastes: LiveData<List<WasteItem>>
        get() = _myWastes

    init {
        viewModelScope.launch {
            getMyUploads()
        }
    }

    private suspend fun getMyUploads() {
        val result = wateRepo.getFromDb(currUserId.toString())
        result.onSuccess {
            _myWastes.postValue(it)
        }

        result.onFailure {
            println("Failed to load waste : " + it.message.toString())
        }
    }


    suspend fun addToDb(wasteDto: WasteDto) : Result<WasteItem>{
        return wateRepo.addToDb(wasteDto, currUserId.toString())
    }

}