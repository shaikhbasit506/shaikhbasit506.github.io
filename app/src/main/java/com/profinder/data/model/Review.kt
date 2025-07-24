package com.profinder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Entity(tableName = "reviews")
@Parcelize
data class Review(
    @PrimaryKey
    val id: String,
    val professionalId: String,
    val userId: String,
    val userName: String,
    val userImageUrl: String? = null,
    val rating: Float,
    val comment: String,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable