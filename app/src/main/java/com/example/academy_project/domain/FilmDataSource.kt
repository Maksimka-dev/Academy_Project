package com.example.academy_project.domain

import com.example.academy_project.R
import com.example.academy_project.data.models.Actor
import com.example.academy_project.data.models.Film

class FilmDataSource {
    fun getFilms(): List<Film>{
        return listOf(
            Film("Dolittle", R.drawable.pic_movie_image_in_list_dolittle, R.drawable.pic_movie_image_in_details_dolittle,
                2.3, 87, 101, "PG", "Adventure, Comedy, Family",
                "A physician who can talk to animals embarks on an adventure to find a legendary island with a young apprentice and a crew of strange pets.",
                listOf(
                    Actor("Robert Downey Jr.", R.drawable.pic_actor_photo_robert_downey_jr),
                    Actor("Antonio Banderas", R.drawable.pic_actor_photo_antonio_banderas),
                    Actor("Michael Sheen", R.drawable.pic_actor_photo_michael_sheen),
                    Actor("Jim Broadbent", R.drawable.pic_actor_photo_jim_broadbent),
                    Actor("Jessie Buckley", R.drawable.pic_actor_photo_jessie_buckley),
                    Actor("Harry Colett", R.drawable.pic_actor_photo_harry_colett)
                )
            ),
            Film("Underwater", R.drawable.pic_movie_image_in_list_underwater, R.drawable.pic_movie_image_in_details_underwater,
                2.6, 113, 95, "18+", "Action, Horror, Sci-Fi",
                "A crew of oceanic researchers working for a deep sea drilling company try to get to safety after a mysterious earthquake devastates their " +
                        "deepwater research and drilling facility located at the bottom of the Mariana Trench.",
                listOf(
                    Actor("Kristen Stewart", R.drawable.pic_actor_photo_kristen_stewart),
                    Actor("Vincent Cassel", R.drawable.pic_actor_photo_vincent_cassel),
                    Actor("Mamoudou Athie", R.drawable.pic_actor_photo_mamoudou_athie),
                    Actor("T. J. Miller", R.drawable.pic_actor_photo_tj_miller),
                    Actor("John Gallagher Jr.", R.drawable.pic_actor_photo_john_gallagher_jr),
                    Actor("Jessica Henwick", R.drawable.pic_actor_photo_jessica_henwick),
                    Actor("Gunner Wright", R.drawable.pic_actor_photo_gunner_wright),
                    Actor("Fiona Rene", R.drawable.pic_actor_photo_fiona_rene)
                )
            ),
            Film("The Call Of The Wild", R.drawable.pic_movie_image_in_list_the_call_of_the_wild, R.drawable.pic_movie_image_in_details_the_call_of_the_wild,
                3.4, 321, 119, "PG", "Adventure, Drama, Family",
                "A sled dog struggles for survival in the wilds of the Yukon.",
                listOf(
                    Actor("Harrison Ford", R.drawable.pic_actor_photo_harrison_ford),
                    Actor("Omar Sy", R.drawable.pic_actor_photo_omar_sy),
                    Actor("Cara Gee", R.drawable.pic_actor_photo_cara_gee),
                    Actor("Dan Stevens", R.drawable.pic_actor_photo_dan_stevens),
                    Actor("Bradley Whitford", R.drawable.pic_actor_photo_bradley_whitford),
                    Actor("Jean Louisa Kelly", R.drawable.pic_actor_photo_jean_louisa_kelly)
                )
            ),
            Film("Last Christmas", R.drawable.pic_movie_image_in_list_last_christmas, R.drawable.pic_movie_image_in_details_last_christmas,
                3.3, 208, 121, "13+", "Comedy, Drama, Romance",
                "Kate is a young woman subscribed to bad decisions. Working as an elf in a year round Christmas store is not good for the wannabe singer. " +
                        "However, she meets Tom there. Her life takes a new turn. For Kate, it seems too good to be true.",
                listOf(
                    Actor("Emilia Clarke", R.drawable.pic_actor_photo_emilia_clarke),
                    Actor("Madison Ingoldsby", R.drawable.pic_actor_photo_madison_ingoldsby),
                    Actor("Emma Thompson", R.drawable.pic_actor_photo_emma_thompson),
                    Actor("Boris Isakovic", R.drawable.pic_actor_photo_boris_isakovich),
                    Actor("Maxim Baldry", R.drawable.pic_actor_photo_maxim_baldry)
                )

            )
        )
    }
}