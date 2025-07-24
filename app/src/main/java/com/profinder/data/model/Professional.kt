package com.profinder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Entity(tableName = "professionals")
@Parcelize
data class Professional(
    @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val profileImageUrl: String? = null,
    val category: String,
    val specialization: String,
    val description: String,
    val experience: Int, // years of experience
    val rating: Float = 0f,
    val reviewCount: Int = 0,
    val hourlyRate: Double,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val isAvailable: Boolean = true,
    val isVerified: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val skills: List<String> = emptyList(),
    val workingHours: String = "9:00 AM - 6:00 PM",
    val serviceRadius: Int = 10 // in kilometers
) : Parcelable