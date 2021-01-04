package com.example.academy_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.homework.features.data.Actor
import com.bumptech.glide.Glide

class DetailAdapter(): RecyclerView.Adapter<ActorViewHolder>() {

    private var actors = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_detail_element, parent, false))
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION)
            holder.onBind(actors[position])
    }

    fun bindFilms(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }

}

class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val actorAvatar: ImageView? = itemView.findViewById(R.id.actorAvatarImageView)
    private val actorName: TextView? = itemView.findViewById(R.id.actorNameTextView)

    fun onBind(actor: Actor){

        Glide
            .with(itemView.context)
            .load(actor.picture)
            .into(actorAvatar)

        actorName?.text = actor.name
    }

}