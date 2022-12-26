package com.example.app_imddb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_imddb.data.MovieData
import com.example.app_imddb.databinding.ListDatamovieBinding

class MovieAdapter (
    private val listMovie : ArrayList<MovieData>
):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(itemView: ListDatamovieBinding):RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(movieData: MovieData){
            with(binding){
                Glide.with(itemView).load(movieData.img).into(idPoster)
                tvTitle.text = movieData.Title
                tvYear.text = movieData.Year

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ListDatamovieBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
    override fun getItemCount(): Int = listMovie.size

}