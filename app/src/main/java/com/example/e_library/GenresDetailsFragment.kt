package com.example.e_library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.e_library.databinding.FragmentGenresDetailsBinding
import com.example.e_library.ui.genres.GenresViewModel


class GenresDetailsFragment : Fragment() {

    private val genresViewModel: GenresViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentGenresDetailsBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGenresDetailsBinding.bind(view)

        genresViewModel.currentGenre.observe(this.viewLifecycleOwner) {
            binding.titleDetail.text = getString(it.titleBook)
            binding.booksImageDetail.load(it.genresImageBanner)
            binding.newsDetail.text = getString(it.genresDetails)
        }
    }
}
