package com.example.e_library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.e_library.databinding.AnnotationBinding

class AnnotationFragment : Fragment() {

    private val booksViewModel: LibraryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return AnnotationBinding.inflate(inflater, container, false).root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = AnnotationBinding.bind(view)

        booksViewModel.currentBook.observe(this.viewLifecycleOwner) {
            binding.titleDetail.text = getString(it.titleResourceId)
            binding.booksImageDetail.load(it.booksImageBanner)
            binding.newsDetail.text = getString(it.annotationDetails)
        }
    }
}