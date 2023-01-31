package com.example.e_library.ui.genres

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_library.*
import com.example.e_library.databinding.FragmentGenresBinding
import java.util.*


class GenresFragment : Fragment() {


    private var _binding: FragmentGenresBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: GenresAdapter
    private lateinit var recyclerView: RecyclerView
//    lateinit var searchView: SearchView
    private var mList = ArrayList<GenresData>()

    lateinit var logo: Array<Int>
    lateinit var title: Array<String>
//    lateinit var genres: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GenresViewModel::class.java)

        _binding = FragmentGenresBinding.inflate(layoutInflater, container, false)
        return inflater.inflate(R.layout.fra, container, false)


        return binding.root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewGenres)
//        searchView = view.findViewById(R.id.searchViewGenres)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = GenresAdapter(mList)
        recyclerView.adapter = adapter


//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                filterList(newText)
//                return true
//            }
//
//        }) }
//    private fun filterList(query: String?) {
//
//        if (query != null) {
//            val filteredList = ArrayList<GenresData>()
//            for (i in mList) {
//                if (i.title.lowercase(Locale.ROOT).contains(query)) {
//                    filteredList.add(i)
//                }
//            }
//
//            if (filteredList.isEmpty()) {
//                Toast.makeText(activity, "No Data found", Toast.LENGTH_SHORT).show()
//            } else {
//                adapter.setFilteredList(filteredList)
//            }
//        }
    }

    private fun dataInitialize(){

        mList = arrayListOf<GenresData>()

        logo = arrayOf(
            R.drawable.adventure,
            R.drawable.children,
            R.drawable.detective,
            R.drawable.fantasy,
            R.drawable.horror,
            R.drawable.psychology,
            R.drawable.novel
        )
        title = arrayOf(
            getString(R.string.adventure),
            getString(R.string.Children),
            getString(R.string.Detective),
            getString(R.string.Fantasy),
            getString(R.string.Horror),
            getString(R.string.Psychology),
            getString(R.string.Romance)
        )
        for (i in logo.indices){
            val genres = GenresData(title[i], logo[i])
            mList.add(genres)
        }
    }
}