package com.profinder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Entity(tableName = "categories")
@Parcelize
data class Category(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val iconUrl: String? = null,
    val isActive: Boolean = true
) : Parcelable

// Predefined categories
object Categories {
    val ELECTRICIAN = Category("1", "Electrician", "Electrical repairs and installations")
    val PLUMBER = Category("2", "Plumber", "Plumbing services and repairs")
    val TUTOR = Category("3", "Tutor", "Educational and tutoring services")
    val GRAPHIC_DESIGNER = Category("4", "Graphic Designer", "Design and creative services")
    val CARPENTER = Category("5", "Carpenter", "Woodworking and furniture services")
    val MECHANIC = Category("6", "Mechanic", "Vehicle repair and maintenance")
    val CLEANER = Category("7", "Cleaner", "Cleaning services")
    val GARDENER = Category("8", "Gardener", "Landscaping and gardening services")
    val PHOTOGRAPHER = Category("9", "Photographer", "Photography services")
    val PAINTER = Category("10", "Painter", "Painting and decorating services")
    
    fun getAllCategories() = listOf(
        ELECTRICIAN, PLUMBER, TUTOR, GRAPHIC_DESIGNER, CARPENTER,
        MECHANIC, CLEANER, GARDENER, PHOTOGRAPHER, PAINTER
    )
}