package com.profinder.data.database

import androidx.room.*
import com.profinder.data.model.Professional
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfessionalDao {

    @Query("SELECT * FROM professionals WHERE isAvailable = 1 ORDER BY rating DESC")
    fun getAllProfessionals(): Flow<List<Professional>>

    @Query("SELECT * FROM professionals WHERE category = :category AND isAvailable = 1 ORDER BY rating DESC")
    fun getProfessionalsByCategory(category: String): Flow<List<Professional>>

    @Query("SELECT * FROM professionals WHERE id = :id")
    suspend fun getProfessionalById(id: String): Professional?

    @Query("""
        SELECT * FROM professionals 
        WHERE isAvailable = 1 
        AND (name LIKE '%' || :query || '%' 
        OR category LIKE '%' || :query || '%' 
        OR specialization LIKE '%' || :query || '%')
        ORDER BY rating DESC
    """)
    fun searchProfessionals(query: String): Flow<List<Professional>>

    @Query("""
        SELECT * FROM professionals 
        WHERE isAvailable = 1 
        AND (
            (6371 * acos(cos(radians(:userLat)) * cos(radians(latitude)) * 
            cos(radians(longitude) - radians(:userLng)) + 
            sin(radians(:userLat)) * sin(radians(latitude)))) <= serviceRadius
        )
        ORDER BY rating DESC
    """)
    fun getProfessionalsNearby(userLat: Double, userLng: Double): Flow<List<Professional>>

    @Query("SELECT * FROM professionals WHERE rating >= :minRating AND isAvailable = 1 ORDER BY rating DESC")
    fun getProfessionalsByRating(minRating: Float): Flow<List<Professional>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfessional(professional: Professional)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfessionals(professionals: List<Professional>)

    @Update
    suspend fun updateProfessional(professional: Professional)

    @Delete
    suspend fun deleteProfessional(professional: Professional)

    @Query("DELETE FROM professionals WHERE id = :id")
    suspend fun deleteProfessionalById(id: String)

    @Query("SELECT DISTINCT category FROM professionals WHERE isAvailable = 1")
    suspend fun getAllCategories(): List<String>
}