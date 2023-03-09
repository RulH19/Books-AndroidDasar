package com.example.books

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListBooksAdapter(private val listBooks:  ArrayList<Books>)  : RecyclerView.Adapter<ListBooksAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBooks.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description,  photo) = listBooks[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description


        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listBooks[holder.adapterPosition])
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listBooks[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
//            intentDetail.putExtra("DETAIL", listBooks[holder.adapterPosition])
//            holder.itemView.context.startActivity(intentDetail)
        }
//        holder.itemView.setOnClickListener{
//            val intent = Intent(it.context, DetailActivity::class.java)
//            it.context.startActivity(intent)
//        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Books)
    }
}