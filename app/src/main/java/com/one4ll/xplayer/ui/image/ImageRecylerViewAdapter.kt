package com.one4ll.xplayer.ui.image

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.one4ll.xplayer.FullImageActivity
import com.one4ll.xplayer.Media
import com.one4ll.xplayer.R
import com.one4ll.xplayer.helpers.IMAGE_PATH
import com.one4ll.xplayer.helpers.setImageThumbNail

class ImageRecylerViewAdapter(var list: List<Media>) :
    RecyclerView.Adapter<ImageRecylerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.video_list,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun loadVideo(list: ArrayList<Media>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text= list[position].name
        holder.duration.text = list[position].duration
        val path = list[position].path
        setImageThumbNail(path,holder.imageView)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FullImageActivity::class.java)
            intent.putExtra(IMAGE_PATH,path)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.name)
        val duration = itemView.findViewById<TextView>(R.id.duration)

 }
}