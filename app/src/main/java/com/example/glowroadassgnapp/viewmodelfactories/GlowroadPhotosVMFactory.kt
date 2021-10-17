package com.example.glowroadassgnapp.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.glowroadassgnapp.repositories.GlowroadPhotoRepository
import com.example.glowroadassgnapp.viewmodels.GlowroadPhotosViewModel

class GlowroadPhotosVMFactory(
    private val repsoitory: GlowroadPhotoRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GlowroadPhotosViewModel(repsoitory) as T
    }
}