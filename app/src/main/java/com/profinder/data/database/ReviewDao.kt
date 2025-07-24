package com.profinder.data.database

import androidx.room.*
import com.profinder.data.model.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {

    @Query("SELECT * FROM reviews WHERE professionalId = :professionalId ORDER BY createdAt DESC")
    fun getReviewsForProfessional(professionalId: String): Flow<List<Review>>

    @Query("SELECT * FROM reviews WHERE userId = :userId ORDER BY createdAt DESC")
    fun getReviewsByUser(userId: String): Flow<List<Review>>

    @Query("SELECT * FROM reviews WHERE id = :id")
    suspend fun getReviewById(id: String): Review?

    @Query("SELECT AVG(rating) FROM reviews WHERE professionalId = :professionalId")
    suspend fun getAverageRatingForProfessional(professionalId: String): Float?

    @Query("SELECT COUNT(*) FROM reviews WHERE professionalId = :professionalId")
    suspend fun getReviewCountForProfessional(professionalId: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(review: Review)

    @Update
    suspend fun updateReview(review: Review)

    @Delete
    suspend fun deleteReview(review: Review)

    @Query("DELETE FROM reviews WHERE id = :id")
    suspend fun deleteReviewById(id: String)
}