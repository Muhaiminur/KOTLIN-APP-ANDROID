package com.muhaiminur.gkotlin

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.song_row.view.*

class Song_Adapter_Recycler(val context: Recycler_Page, val song_list: ArrayList<Song>) :
    RecyclerView.Adapter<Song_Adapter_Recycler.Song_Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Song_Adapter_Recycler.Song_Holder {
        val v = LayoutInflater.from(context.activity).inflate(R.layout.song_row, p0, false)
        return Song_Holder(v)
    }

    override fun getItemCount(): Int {
        return song_list.size
    }

    override fun onBindViewHolder(p0: Song_Adapter_Recycler.Song_Holder, p1: Int) {
        p0.song_Name.setText(song_list[p1].name)
        p0.song_cat.setText(song_list[p1].category)
        p0.song_view.setOnClickListener {
            Toast.makeText(context.activity, song_list.get(p1).name, Toast.LENGTH_SHORT).show()
            Log.d("Click", song_list.get(p1).name)
        }
    }

    class Song_Holder(view: View) : RecyclerView.ViewHolder(view) {
        val song_Name = view.song_name
        val song_cat = view.song_cat
        val song_view = view.song_card
    }
}
