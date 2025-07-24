package com.profinder.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.profinder.data.model.*

@Database(
    entities = [
        Professional::class,
        User::class,
        Review::class,
        BookingRequest::class,
        Category::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ProfinderDatabase : RoomDatabase() {

    abstract fun professionalDao(): ProfessionalDao
    abstract fun userDao(): UserDao
    abstract fun reviewDao(): ReviewDao
    abstract fun bookingRequestDao(): BookingRequestDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: ProfinderDatabase? = null

        fun getDatabase(context: Context): ProfinderDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfinderDatabase::class.java,
                    "profinder_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}