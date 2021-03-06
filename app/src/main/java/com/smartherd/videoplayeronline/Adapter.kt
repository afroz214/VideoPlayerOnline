package com.smartherd.videoplayeronline

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter(data:ArrayList<Lesson>, var context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var data:List<Lesson>
    init {
        this.data = data
    }


    class ViewHolder(item:View) : RecyclerView.ViewHolder(item){

        var title:TextView
        var desc:TextView
        var video:VideoView

        init {
            title = item.findViewById(R.id.video_title)
            desc = item.findViewById(R.id.video_desc)
            video = item.findViewById(R.id.lesson_video)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val videoItem = data[position]

        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)
    }
}