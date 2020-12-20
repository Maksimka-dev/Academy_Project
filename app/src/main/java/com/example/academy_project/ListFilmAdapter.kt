package com.example.academy_project

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.academy_project.data.models.Film

class ListFilmAdapter(private val clickListener: OnRecyclerItemClicked): RecyclerView.Adapter<FilmViewHolder>() {

    private var films = listOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_list_element, parent, false))
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.itemView.setOnClickListener {
                clickListener.onClick(position)
            }
            holder.onBind(films[position])
        }
    }

    fun bindActors(newFilms: List<Film>) {
        films = newFilms
        notifyDataSetChanged()
    }
}

class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val icon: ImageView? = itemView.findViewById(R.id.smallMovieImageView)
    private val genre: TextView? = itemView.findViewById(R.id.filmCategoriesTextView)
    private val numOfRating: TextView? = itemView.findViewById(R.id.countReviewsTextView)
    private val movieName: TextView? = itemView.findViewById(R.id.filmNameSmallTextView)
    private val duration: TextView? = itemView.findViewById(R.id.timeTextView)
    private val ageRating: TextView? = itemView.findViewById(R.id.ageSmallTextView)

    fun onBind(film: Film){

        Glide
            .with(itemView.context)
            .load(film.imgForListAddress)
            .into(icon)

        genre?.text = film.genre
        numOfRating?.text = film.numOfRating.toString()
        movieName?.text = film.movieName
        duration?.text = film.duration.toString()
        ageRating?.text = film.ageRating
    }


}

interface OnRecyclerItemClicked {
    fun onClick(position: Int)
}

class FilmDecorator(
    private val left: Int = 50,
    private val top: Int = 50,
    private val right: Int = 0,
    private val bottom: Int = 0
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(left, top, right, bottom)
    }
}