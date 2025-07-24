package com.profinder

import android.app.Application
import com.profinder.data.database.ProfinderDatabase
import com.profinder.data.model.Categories
import com.profinder.data.repository.ProfessionalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfinderApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    val database by lazy { ProfinderDatabase.getDatabase(this) }
    val professionalRepository by lazy { ProfessionalRepository(database.professionalDao()) }

    override fun onCreate() {
        super.onCreate()
        initializeDatabase()
    }

    private fun initializeDatabase() {
        applicationScope.launch {
            // Initialize categories
            database.categoryDao().insertCategories(Categories.getAllCategories())
            
            // Initialize sample professionals
            professionalRepository.initializeSampleData()
        }
    }
}