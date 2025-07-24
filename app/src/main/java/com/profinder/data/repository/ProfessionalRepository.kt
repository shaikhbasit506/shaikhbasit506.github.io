package com.profinder.data.repository

import com.profinder.data.database.ProfessionalDao
import com.profinder.data.model.Professional
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfessionalRepository @Inject constructor(
    private val professionalDao: ProfessionalDao
) {

    fun getAllProfessionals(): Flow<List<Professional>> {
        return professionalDao.getAllProfessionals()
    }

    fun getProfessionalsByCategory(category: String): Flow<List<Professional>> {
        return professionalDao.getProfessionalsByCategory(category)
    }

    suspend fun getProfessionalById(id: String): Professional? {
        return professionalDao.getProfessionalById(id)
    }

    fun searchProfessionals(query: String): Flow<List<Professional>> {
        return professionalDao.searchProfessionals(query)
    }

    fun getProfessionalsNearby(userLat: Double, userLng: Double): Flow<List<Professional>> {
        return professionalDao.getProfessionalsNearby(userLat, userLng)
    }

    fun getProfessionalsByRating(minRating: Float): Flow<List<Professional>> {
        return professionalDao.getProfessionalsByRating(minRating)
    }

    suspend fun insertProfessional(professional: Professional) {
        professionalDao.insertProfessional(professional)
    }

    suspend fun updateProfessional(professional: Professional) {
        professionalDao.updateProfessional(professional)
    }

    suspend fun deleteProfessional(professional: Professional) {
        professionalDao.deleteProfessional(professional)
    }

    suspend fun getAllCategories(): List<String> {
        return professionalDao.getAllCategories()
    }

    // Initialize with sample data
    suspend fun initializeSampleData() {
        val sampleProfessionals = listOf(
            Professional(
                id = "1",
                name = "John Smith",
                email = "john.smith@email.com",
                phone = "+1234567890",
                category = "Electrician",
                specialization = "Residential Electrical Work",
                description = "Experienced electrician with 10+ years in residential and commercial electrical installations and repairs.",
                experience = 10,
                rating = 4.8f,
                reviewCount = 127,
                hourlyRate = 75.0,
                location = "New York, NY",
                latitude = 40.7128,
                longitude = -74.0060,
                isVerified = true,
                skills = listOf("Wiring", "Circuit Installation", "Electrical Repairs", "Panel Upgrades")
            ),
            Professional(
                id = "2",
                name = "Sarah Johnson",
                email = "sarah.johnson@email.com",
                phone = "+1234567891",
                category = "Plumber",
                specialization = "Emergency Plumbing Services",
                description = "Licensed plumber specializing in emergency repairs, pipe installations, and bathroom renovations.",
                experience = 8,
                rating = 4.9f,
                reviewCount = 89,
                hourlyRate = 80.0,
                location = "New York, NY",
                latitude = 40.7589,
                longitude = -73.9851,
                isVerified = true,
                skills = listOf("Pipe Repair", "Drain Cleaning", "Water Heater Installation", "Bathroom Renovation")
            ),
            Professional(
                id = "3",
                name = "Michael Chen",
                email = "michael.chen@email.com",
                phone = "+1234567892",
                category = "Tutor",
                specialization = "Mathematics and Science",
                description = "PhD in Mathematics with 5 years of tutoring experience. Specializing in high school and college level math and science.",
                experience = 5,
                rating = 4.7f,
                reviewCount = 45,
                hourlyRate = 50.0,
                location = "New York, NY",
                latitude = 40.7282,
                longitude = -73.7949,
                isVerified = true,
                skills = listOf("Calculus", "Physics", "Chemistry", "Statistics")
            ),
            Professional(
                id = "4",
                name = "Emily Davis",
                email = "emily.davis@email.com",
                phone = "+1234567893",
                category = "Graphic Designer",
                specialization = "Brand Identity Design",
                description = "Creative graphic designer with expertise in brand identity, logo design, and digital marketing materials.",
                experience = 7,
                rating = 4.6f,
                reviewCount = 63,
                hourlyRate = 65.0,
                location = "New York, NY",
                latitude = 40.7505,
                longitude = -73.9934,
                isVerified = true,
                skills = listOf("Logo Design", "Brand Identity", "Print Design", "Digital Marketing")
            ),
            Professional(
                id = "5",
                name = "Robert Wilson",
                email = "robert.wilson@email.com",
                phone = "+1234567894",
                category = "Carpenter",
                specialization = "Custom Furniture",
                description = "Skilled carpenter specializing in custom furniture, kitchen cabinets, and home renovations.",
                experience = 12,
                rating = 4.9f,
                reviewCount = 98,
                hourlyRate = 70.0,
                location = "New York, NY",
                latitude = 40.7831,
                longitude = -73.9712,
                isVerified = true,
                skills = listOf("Custom Furniture", "Kitchen Cabinets", "Woodworking", "Home Renovation")
            )
        )
        
        professionalDao.insertProfessionals(sampleProfessionals)
    }
}