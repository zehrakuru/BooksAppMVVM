package com.example.booksappmvvm.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.booksappmvvm.common.loadImage
import com.example.booksappmvvm.data.model.GetBookDetailResponse
import com.example.booksappmvvm.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBookDetail(args.bookId)
        observeData()
    }

    private fun observeData() {

        viewModel.bookDetailLiveData.observe(viewLifecycleOwner) { bookDetail ->
            if (bookDetail != null) {
                with(binding) {
                    ivBook.loadImage(bookDetail.imageUrl)
                    tvBookName.text = bookDetail.name
                    tvAuthorName.text = bookDetail.author
                    tvPublisherName.text = bookDetail.publisher
                    tvPrice.text = "${bookDetail.price} ₺"
                }
            } else {
                Snackbar.make(requireView(), "Book is not found!", 1000).show()
            }
        }
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(requireView(), it, 1000).show()
        }
    }
}