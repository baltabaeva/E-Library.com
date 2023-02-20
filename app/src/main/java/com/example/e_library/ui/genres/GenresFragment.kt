package com.example.e_library.ui.genres

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.e_library.GenresAdapter
import com.example.e_library.data.GenresData
import com.example.e_library.databinding.FragmentGenresBinding
import com.example.e_library.model.Genres

import java.util.*
import kotlin.collections.ArrayList
import kotlinx.parcelize.Parcelize


class GenresFragment : Fragment() {

    private val genresViewModel: GenresViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentGenresBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGenresBinding.bind(view)
        val slidingPaneLayout = binding.slidingPaneLayout
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            GenresOnBackPressedCallback(slidingPaneLayout)
        )

        val adapter = GenresAdapter {

            genresViewModel.updateCurrentGenres(it)

            binding.slidingPaneLayout.openPane()
        }
        binding.recyclerViewGenres.adapter = adapter
        adapter.submitList(genresViewModel.genresData)
   }
}



class GenresOnBackPressedCallback(
    private val slidingPaneLayout: SlidingPaneLayout
) : OnBackPressedCallback(
    slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen
), SlidingPaneLayout.PanelSlideListener {

    init {
        slidingPaneLayout.addPanelSlideListener(this)
    }

    override fun handleOnBackPressed() {

        slidingPaneLayout.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {}

    override fun onPanelOpened(panel: View) {

        isEnabled = true
    }

    override fun onPanelClosed(panel: View) {

        isEnabled = false
    }


}
