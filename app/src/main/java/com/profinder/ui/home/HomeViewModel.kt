package com.profinder.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.profinder.data.model.Professional
import com.profinder.data.repository.ProfessionalRepository

class HomeViewModel(
    private val professionalRepository: ProfessionalRepository
) : ViewModel() {

    val professionals: LiveData<List<Professional>> = 
        professionalRepository.getAllProfessionals().asLiveData()
}