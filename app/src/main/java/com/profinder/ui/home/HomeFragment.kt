package com.profinder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.profinder.ProfinderApplication
import com.profinder.databinding.FragmentHomeBinding
import com.profinder.data.model.Categories
import com.profinder.ui.components.CategoryAdapter
import com.profinder.ui.components.ProfessionalAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var professionalAdapter: ProfessionalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViewModel()
        setupRecyclerViews()
        setupObservers()
        setupClickListeners()
    }

    private fun setupViewModel() {
        val application = requireActivity().application as ProfinderApplication
        val factory = HomeViewModelFactory(application.professionalRepository)
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
    }

    private fun setupRecyclerViews() {
        // Categories RecyclerView
        categoryAdapter = CategoryAdapter { category ->
            // Handle category click - navigate to search with category filter
            // TODO: Implement navigation to search fragment with category filter
        }
        
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        // Professionals RecyclerView
        professionalAdapter = ProfessionalAdapter { professional ->
            // Handle professional click - navigate to professional detail
            // TODO: Implement navigation to professional detail
        }

        binding.rvFeaturedProfessionals.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = professionalAdapter
        }
    }

    private fun setupObservers() {
        viewModel.professionals.observe(viewLifecycleOwner) { professionals ->
            professionalAdapter.submitList(professionals)
            binding.progressBar.visibility = View.GONE
        }

        // Load categories
        categoryAdapter.submitList(Categories.getAllCategories())
    }

    private fun setupClickListeners() {
        binding.etSearch.setOnClickListener {
            // Navigate to search fragment
            // TODO: Implement navigation to search fragment
        }

        binding.tvViewAllCategories.setOnClickListener {
            // Navigate to categories view
            // TODO: Implement navigation to categories view
        }

        binding.tvViewAllProfessionals.setOnClickListener {
            // Navigate to all professionals view
            // TODO: Implement navigation to all professionals view
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}