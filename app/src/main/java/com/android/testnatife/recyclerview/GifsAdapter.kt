package com.android.testnatife.recyclerview

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.testnatife.R
import com.android.testnatife.databinding.TableRowViewBinding
import com.bumptech.glide.Glide


class GifsAdapter(private val gifList:ArrayList<Gif> ): RecyclerView.Adapter<GifsAdapter.GifsHolder>() {
    class GifsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = TableRowViewBinding.bind(itemView)

        fun bind(gif: Gif){
           with(binding){
               gifName.text = gif.name
               Glide.with(itemView)
                   .asGif()
                   .load(gif.getUrl())
                   .error(R.drawable.error_icon)
                   .centerCrop()
                   .into(gifsImageview)
           }





        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.table_row_view, parent, false)
        return GifsHolder(view)
    }

    override fun onBindViewHolder(holder: GifsHolder, position: Int) {

          holder.bind(gifList[position])



    }

    override fun getItemCount(): Int {

        return gifList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addGifs(gif: Gif){
        gifList.add(gif)
        notifyDataSetChanged()
    }
}