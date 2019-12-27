package net.adrote.toolboxtest.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_carousel_thumb.view.*
import net.adrote.toolboxtest.R
import net.adrote.toolboxtest.ui.model.Item

class ThumbAdapter(private val list: List<Item>) : RecyclerView.Adapter<ThumbAdapter.ThumbViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ThumbViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: ThumbViewHolder, position: Int) {
        var itemFromList:Item = list[position]
        holder.bind(itemFromList)
    }

    override fun getItemCount(): Int = list.size

    class ThumbViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_carousel_thumb,parent,false)) {

        var context: Context = parent.context

        fun bind (item: Item) {
            itemView.thumb_title_textView.text = item.title
            loadImageUrl(context,item.imageUrl!!,itemView.thumb_imageview)
        }

        fun loadImageUrl(contexto: Context, url:String, imageView: AppCompatImageView) {
            Glide.with(contexto)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }
    }

}