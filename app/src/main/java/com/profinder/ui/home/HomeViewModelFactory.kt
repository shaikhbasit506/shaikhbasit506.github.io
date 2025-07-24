package com.profinder.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.profinder.data.repository.ProfessionalRepository

class HomeViewModelFactory(
    private val professionalRepository: ProfessionalRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(professionalRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}