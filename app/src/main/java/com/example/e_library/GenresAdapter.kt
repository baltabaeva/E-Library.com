package com.example.e_library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.e_library.databinding.GenresBinding
import com.example.e_library.model.Genres


class GenresAdapter(private val onItemClicked: (Genres) -> Unit) :
    ListAdapter<Genres, GenresAdapter.GenresViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class GenresViewHolder(private var binding: GenresBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genres: Genres, context:Context) {
            binding.titleTv.text = context.getString(genres.titleResourceId)
            binding.logoIv.load(genres.imageResourceId)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenresViewHolder {
        context = parent.context
        return GenresViewHolder(
            GenresBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Genres>() {
            override fun areItemsTheSame(oldItem: Genres, newItem: Genres): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.titleResourceId == newItem.titleBook
                        )
            }

            override fun areContentsTheSame(oldItem: Genres, newItem: Genres): Boolean {
                return oldItem == newItem
            }
        }
    }
}
