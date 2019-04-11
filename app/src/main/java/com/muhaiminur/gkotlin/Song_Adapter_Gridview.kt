package com.muhaiminur.gkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.song_row.view.*

class Song_Adapter_Gridview(private val context: GridPage, private val song_list: ArrayList<Song>) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val song = song_list[p0]
        val inflator = context.activity!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val songView = inflator.inflate(R.layout.song_row, null)
        songView.song_name.text = song.name
        songView.song_cat.text = song.category
        songView.song_card.setOnClickListener {
            Toast.makeText(context.activity, song_list[p0].name, Toast.LENGTH_SHORT).show()
            Log.d("Click", song_list[p0].name)
        }

        return songView
    }

    override fun getItem(p0: Int): Any {
        return song_list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return song_list.size
    }
}
