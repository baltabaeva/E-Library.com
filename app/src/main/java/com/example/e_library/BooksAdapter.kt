package com.example.e_library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.e_library.databinding.BooksListBinding
import com.example.e_library.model.Books

class BooksAdapter (private val onItemClicked: (Books) -> Unit) :
    ListAdapter<Books, BooksAdapter.SportsViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class SportsViewHolder(private var binding: BooksListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sport: Books, context: Context) {
            binding.sportsImage.load(sport.imageResourceId)
            binding.title.text = context.getString(sport.titleResourceId)
            // Load the images into the ImageView using the Coil library.

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SportsViewHolder {
        context = parent.context
        return SportsViewHolder(
            BooksListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Books>() {
            override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.titleResourceId == newItem.titleResourceId ||
                        oldItem.subTitleResourceId == newItem.subTitleResourceId
                        )
            }

            override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
                return oldItem == newItem
            }
        }
    }
}
