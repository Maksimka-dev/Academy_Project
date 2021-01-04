package com.example.academy_project

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.academy_project.data.Movie

class ListFilmAdapter(private val clickListener: OnRecyclerItemClicked): RecyclerView.Adapter<FilmViewHolder>() {

    private var films = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_list_element, parent, false))
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.itemView.setOnClickListener {
                clickListener.onClick(films[position])
            }
            holder.onBind(films[position])
        }
    }

    fun bindMovie(newFilms: List<Movie>) {
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
    private val rating: RatingBar? = itemView.findViewById(R.id.smallRating)

    fun onBind(film: Movie){

        Glide
            .with(itemView.context)
            .load(film.poster)
            .into(icon)

        for (i in film.genres.indices){
            val currentTextGenre: CharSequence? = genre?.text

            if (i == 0) {
                genre?.text = "${film.genres[i].name}, "
            }
            else if (i == film.genres.size - 1){
                genre?.text = "$currentTextGenre ${film.genres[i].name}."
            }

            genre?.text = "$currentTextGenre ${film.genres[i].name}, "

        }

        numOfRating?.text = film.numberOfRatings.toString()
        movieName?.text = film.title
        duration?.text = film.runtime.toString()
        ageRating?.text = film.minimumAge.toString() + "+"
        rating?.rating = (film.ratings / 2.0).toFloat()
    }


}

interface OnRecyclerItemClicked {
    fun onClick(film: Movie)
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