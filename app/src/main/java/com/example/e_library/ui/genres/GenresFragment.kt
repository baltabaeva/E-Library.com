package com.example.e_library.ui.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.e_library.GenresAdapter
import com.example.e_library.data.GenresData
import com.example.e_library.databinding.FragmentGenresBinding
import com.example.e_library.model.Genres
import kotlinx.android.synthetic.main.recommendations.*
import java.util.*
import kotlin.collections.ArrayList



class GenresFragment : Fragment() {

    private val genresViewModel: GenresViewModel by activityViewModels()

    //private lateinit var searchList: ArrayList<GenresData>

//    EditText searchView

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



//        val searchView = binding.searchViewGenres
//        val searchViewList = arrayListOf<GenresData>()
//
//        searchView.clearFocus()
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.clearFocus()
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                searchViewList.clear()
//                val searchText = newText!!.toLowerCase(Locale.getDefault())
//                if(searchText.isNotEmpty()){
//                    ArrayList<Genres>().forEach(){
//                        if (it.titleResourceId.toLowerCase(Locale.getDefault()).contains(searchText)){
//                            searchList.add(it)
//                        }
//                    }
//                    binding.recyclerViewGenres.adapter!!.notifyDataSetChanged()
//                }else{
//                    searchList.clear()
//                    searchList.addAll(ArrayList<Genres>)
//                    binding.recyclerViewGenres.adapter!!.notifyDataSetChanged()
//                }
//                return false
//            }
//
//        })
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
