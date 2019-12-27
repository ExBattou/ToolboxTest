package net.adrote.toolboxtest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main_carousel.view.*
import net.adrote.toolboxtest.R
import net.adrote.toolboxtest.ui.model.Data
import net.adrote.toolboxtest.ui.model.Item


class MainAdapter(private val list: List<Data>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: MainViewHolder, position: Int) {
        var carousel: Data = list[position]
        viewHolder.bind(carousel)
    }

    class MainViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_main_carousel, parent, false)) {

        var contexto = parent.context

        fun bind(data: Data) {
            itemView.carousel_title_textview.text = data.title
            if(data.type.equals("poster")) {

                prepareRecyclerPoster(data.items as List<Item>,itemView.carousel_recycler)
            } else {
                prepareRecyclerThumb(data.items as List<Item>,itemView.carousel_recycler)
            }
        }

        private fun prepareRecyclerThumb(itemList:List<Item>, recycler:RecyclerView) {
            if(itemList.size>0) {
                var thumbAdapter = ThumbAdapter(itemList)
                recycler.adapter = thumbAdapter
                recycler.layoutManager = LinearLayoutManager(contexto,RecyclerView.HORIZONTAL,true)
                recycler.itemAnimator = DefaultItemAnimator()
                thumbAdapter.notifyDataSetChanged()
            }

        }

        private fun prepareRecyclerPoster(itemList:List<Item>, recycler:RecyclerView) {
            if(itemList.size>0) {
                var posterAdapter = PosterAdapter(itemList)
                recycler.adapter = posterAdapter
                recycler.layoutManager = LinearLayoutManager(contexto,RecyclerView.HORIZONTAL,true)
                recycler.itemAnimator = DefaultItemAnimator()
                posterAdapter.notifyDataSetChanged()
            }

        }


    }

}