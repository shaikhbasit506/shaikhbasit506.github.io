package com.profinder.ui.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.profinder.R
import com.profinder.data.model.Professional
import com.profinder.databinding.ItemProfessionalBinding

class ProfessionalAdapter(
    private val onProfessionalClick: (Professional) -> Unit
) : ListAdapter<Professional, ProfessionalAdapter.ProfessionalViewHolder>(ProfessionalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalViewHolder {
        val binding = ItemProfessionalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProfessionalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfessionalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProfessionalViewHolder(
        private val binding: ItemProfessionalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(professional: Professional) {
            binding.apply {
                tvName.text = professional.name
                tvCategory.text = professional.category
                tvHourlyRate.text = itemView.context.getString(
                    R.string.dollar_per_hour, 
                    professional.hourlyRate
                )
                
                // Rating
                ratingBar.rating = professional.rating
                tvRating.text = professional.rating.toString()
                tvReviewCount.text = "(${professional.reviewCount})"
                
                // Location and experience
                tvLocation.text = professional.location
                tvExperience.text = itemView.context.getString(
                    R.string.years_experience,
                    professional.experience
                )
                
                // Verified badge
                ivVerified.visibility = if (professional.isVerified) View.VISIBLE else View.GONE
                
                // Profile image - placeholder for now
                // TODO: Load actual profile image using Coil or similar
                
                root.setOnClickListener {
                    onProfessionalClick(professional)
                }
            }
        }
    }

    private class ProfessionalDiffCallback : DiffUtil.ItemCallback<Professional>() {
        override fun areItemsTheSame(oldItem: Professional, newItem: Professional): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Professional, newItem: Professional): Boolean {
            return oldItem == newItem
        }
    }
}