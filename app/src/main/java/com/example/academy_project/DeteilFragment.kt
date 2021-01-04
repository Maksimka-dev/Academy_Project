package com.example.academy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.academy_project.data.Movie

class DeteilFragment(private val film: Movie): Fragment() {

    private var recycler: RecyclerView? = null
    private var icon: ImageView? = null
    private var genre: TextView? =  null
    private var numOfRating: TextView? =  null
    private var movieName: TextView? = null
    private var ageRating: TextView? = null
    private var storyLine: TextView? = null
    private var rating: RatingBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.datail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        icon = view.findViewById(R.id.topImageView)
        genre = view.findViewById(R.id.filmCategoriesTextView)
        numOfRating = view.findViewById(R.id.countReviewsTextView)
        movieName = view.findViewById(R.id.filmNameTextView)
        ageRating = view.findViewById(R.id.ageTextView)
        storyLine = view.findViewById(R.id.filmStoryTextView)
        rating = view.findViewById(R.id.rating)

        recycler = view.findViewById(R.id.detailRecyclerView)
        recycler?.adapter = DetailAdapter()
        recycler?.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onStart() {
        super.onStart()

        Glide
            .with(requireActivity())
            .load(film.backdrop)
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
        ageRating?.text = film.minimumAge.toString() + "+"
        storyLine?.text = film.overview
        rating?.rating = (film.ratings / 2.0).toFloat()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? DetailAdapter)?.apply {
            bindFilms(film.actors)
        }
    }

}