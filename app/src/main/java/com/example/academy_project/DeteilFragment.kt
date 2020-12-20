package com.example.academy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.academy_project.domain.FilmDataSource

class DeteilFragment(private val position: Int): Fragment() {

    private var recycler: RecyclerView? = null
    private var icon: ImageView? = null
    private var genre: TextView? =  null
    private var numOfRating: TextView? =  null
    private var movieName: TextView? = null
    private var ageRating: TextView? = null
    private var storyLine: TextView? = null

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

        recycler = view.findViewById(R.id.detailRecyclerView)
        recycler?.adapter = DetailAdapter()
        recycler?.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onStart() {
        super.onStart()

        Glide
            .with(requireActivity())
            .load(FilmDataSource().getFilms()[position].imgForDetailsAddress)
            .into(icon)

        genre?.text = FilmDataSource().getFilms()[position].genre
        numOfRating?.text = FilmDataSource().getFilms()[position].numOfRating.toString()
        movieName?.text = FilmDataSource().getFilms()[position].movieName
        ageRating?.text = FilmDataSource().getFilms()[position].ageRating
        storyLine?.text = FilmDataSource().getFilms()[position].storyline

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? DetailAdapter)?.apply {
            bindFilms(FilmDataSource().getFilms()[position].actors)
        }
    }

}