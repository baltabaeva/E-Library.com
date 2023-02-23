package com.example.e_library.ui

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
    ListAdapter<Books, BooksAdapter.BooksViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class BooksViewHolder(private var binding: BooksListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Books, context: Context) {
            binding.booksImage.load(book.imageResourceId)
            binding.title.text = context.getString(book.titleResourceId)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        context = parent.context
        return BooksViewHolder(
            BooksListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
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