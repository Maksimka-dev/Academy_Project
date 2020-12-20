package com.example.academy_project.data.models

data class Film (
    val movieName: String,
    val imgForListAddress: Int,
    val imgForDetailsAddress: Int,
    val rating: Double,
    val numOfRating: Int,
    val duration: Int,
    val ageRating: String,
    val genre: String,
    val storyline: String,
    val actors: List<Actor>
)