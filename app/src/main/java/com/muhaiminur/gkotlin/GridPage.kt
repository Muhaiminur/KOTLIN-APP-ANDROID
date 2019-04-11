package com.muhaiminur.gkotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class GridPage : Fragment() {

    private var songList: ArrayList<Song> = ArrayList()
    private var songAdapterGridview: Song_Adapter_Gridview? = null
    private var gridview: GridView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_grid__page, container, false)
        songList.add(Song("ABIR 1", "POP"))
        songList.add(Song("ABIR 2", "POP"))
        songList.add(Song("ABIR 3", "POP"))
        songList.add(Song("ABIR 4", "POP"))
        Log.d("Grid Size", "" + songList.size + "")
        gridview = rootview.findViewById(R.id.song_grid) as GridView
        songAdapterGridview = Song_Adapter_Gridview(this, songList)
        gridview!!.adapter = songAdapterGridview
        return rootview
    }


}
