package net.adrote.toolboxtest.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_carousel_poster.view.*
import kotlinx.android.synthetic.main.item_carousel_thumb.view.*
import net.adrote.toolboxtest.R
import net.adrote.toolboxtest.ui.model.Item

class PosterAdapter(private val list: List<Item>) : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PosterViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        var itemFromList:Item = list[position]
        holder.bind(itemFromList)
    }

    override fun getItemCount(): Int = list.size

    class PosterViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_carousel_poster,parent,false)) {

        var context: Context = parent.context

        fun bind (item: Item) {
            itemView.poster_title_textView.text = item.title
            loadImageUrl(context,item.imageUrl!!,itemView.poster_imageview)
        }

        fun loadImageUrl(contexto: Context, url:String, imageView: AppCompatImageView) {
            Glide.with(contexto)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }
    }
}
