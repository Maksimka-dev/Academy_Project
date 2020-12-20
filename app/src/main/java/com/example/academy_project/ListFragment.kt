package com.example.academy_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academy_project.domain.FilmDataSource

class ListFragment: Fragment() {

    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.list_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.listFilmRecyclerView)
        recycler?.adapter = ListFilmAdapter(clickListener)
        recycler?.layoutManager = GridLayoutManager(requireActivity(),2)
        recycler?.addItemDecoration(FilmDecorator())
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? ListFilmAdapter)?.apply {
            bindActors(FilmDataSource().getFilms())
        }
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(position: Int) {
            (requireActivity() as MainActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainWindow, DeteilFragment(position))
                .commit()
        }
    }

}