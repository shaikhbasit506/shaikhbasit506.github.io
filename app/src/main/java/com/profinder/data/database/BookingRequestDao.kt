package com.profinder.data.database

import androidx.room.*
import com.profinder.data.model.BookingRequest
import com.profinder.data.model.BookingStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface BookingRequestDao {

    @Query("SELECT * FROM booking_requests WHERE userId = :userId ORDER BY createdAt DESC")
    fun getBookingRequestsByUser(userId: String): Flow<List<BookingRequest>>

    @Query("SELECT * FROM booking_requests WHERE professionalId = :professionalId ORDER BY createdAt DESC")
    fun getBookingRequestsForProfessional(professionalId: String): Flow<List<BookingRequest>>

    @Query("SELECT * FROM booking_requests WHERE id = :id")
    suspend fun getBookingRequestById(id: String): BookingRequest?

    @Query("SELECT * FROM booking_requests WHERE status = :status ORDER BY createdAt DESC")
    fun getBookingRequestsByStatus(status: BookingStatus): Flow<List<BookingRequest>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookingRequest(bookingRequest: BookingRequest)

    @Update
    suspend fun updateBookingRequest(bookingRequest: BookingRequest)

    @Delete
    suspend fun deleteBookingRequest(bookingRequest: BookingRequest)

    @Query("DELETE FROM booking_requests WHERE id = :id")
    suspend fun deleteBookingRequestById(id: String)

    @Query("UPDATE booking_requests SET status = :status, updatedAt = :updatedAt WHERE id = :id")
    suspend fun updateBookingStatus(id: String, status: BookingStatus, updatedAt: Long)
}