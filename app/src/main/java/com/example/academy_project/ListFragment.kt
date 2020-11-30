package com.example.academy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {

    private lateinit var buttonImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.list_fragment, container, false)

        buttonImageView = rootView.findViewById(R.id.backgroundsmall)
        buttonImageView.setOnClickListener{
            (requireActivity() as MainActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainWindow,DeteilFragment())
                .commit()
        }


        return rootView
    }
}