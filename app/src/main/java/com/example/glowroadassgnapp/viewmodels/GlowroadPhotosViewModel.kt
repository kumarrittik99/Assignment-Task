package com.example.glowroadassgnapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glowroadassgnapp.models.GlowroadPhoto
import com.example.glowroadassgnapp.models.Photo
import com.example.glowroadassgnapp.repositories.GlowroadPhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class GlowroadPhotosViewModel(
    private val repository: GlowroadPhotoRepository
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos : LiveData<List<Photo>>
        get() = _photos


    fun getPhotos() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.getGRPhotoResponse()
            _photos.value = response.photos.photo
        }
    }

}