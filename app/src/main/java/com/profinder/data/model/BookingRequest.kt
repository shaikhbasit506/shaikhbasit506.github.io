package com.profinder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Entity(tableName = "booking_requests")
@Parcelize
data class BookingRequest(
    @PrimaryKey
    val id: String,
    val professionalId: String,
    val userId: String,
    val title: String,
    val description: String,
    val requestedDate: Long,
    val requestedTime: String,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val estimatedDuration: Int, // in hours
    val status: BookingStatus = BookingStatus.PENDING,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val professionalResponse: String? = null
) : Parcelable

enum class BookingStatus {
    PENDING,
    ACCEPTED,
    DECLINED,
    COMPLETED,
    CANCELLED
}