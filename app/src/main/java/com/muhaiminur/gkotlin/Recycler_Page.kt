package com.muhaiminur.gkotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recycler__page.*

class Recycler_Page : Fragment() {

    var songList: ArrayList<Song> = ArrayList<Song>()
    var song_adapter: Song_Adapter? = null
    var recycler: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val rootview = inflater.inflate(R.layout.fragment_recycler__page, container, false)
        songList.add(Song("ABIR 1", "POP"))
        songList.add(Song("ABIR 2", "POP"))
        songList.add(Song("ABIR 3", "POP"))
        songList.add(Song("ABIR 4", "POP"))
        Log.d("Recycler Size", "" + songList.size + "")
        recycler = rootview.findViewById(R.id.abir_recycler) as RecyclerView // Add this
        song_adapter = Song_Adapter(this@Recycler_Page, songList)
        recycler!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler!!.adapter = song_adapter
        return rootview
    }
}
