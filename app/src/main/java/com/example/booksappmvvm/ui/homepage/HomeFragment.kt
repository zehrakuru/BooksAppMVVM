package com.example.booksappmvvm.ui.homepage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.booksappmvvm.data.model.GetBookResponse
import com.example.booksappmvvm.databinding.FragmentHomeBinding
import com.example.booksappmvvm.data.retrofit.retrofitClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), BooksAdapter.BookListener {
    private lateinit var binding: FragmentHomeBinding
    private val booksAdapter by lazy { BooksAdapter(this) }
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvBooks.adapter = booksAdapter
        viewModel.getBooks()
        observeData()
    }

    private fun observeData() {
        viewModel.booksLiveData.observe(viewLifecycleOwner) { list ->
            if (list != null) {
                booksAdapter.submitList(list)
            } else {
                Snackbar.make(requireView(), "There is no such a list!", 1000).show()
            }
        }
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(requireView(), it, 1000).show()
        }
    }

    override fun onBookClick(id: Int) {
        val direction = HomeFragmentDirections.actionHomeToDetail(id)
        findNavController().navigate(direction)
    }


}