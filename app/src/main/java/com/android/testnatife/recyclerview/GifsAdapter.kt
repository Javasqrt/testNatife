package com.android.testnatife.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.testnatife.R
import com.android.testnatife.databinding.TableRowViewBinding
import com.bumptech.glide.Glide


class GifsAdapter(private var gifList:ArrayList<Gif>): RecyclerView.Adapter<GifsAdapter.GifsHolder>() {

    lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    class GifsHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        private val binding = TableRowViewBinding.bind(itemView)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(position = adapterPosition)
            }
        }

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
        return GifsHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: GifsHolder, position: Int) {

          holder.bind(gifList[position])



    }

    override fun getItemCount(): Int {

        return gifList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun getItemSearch(arrayList: ArrayList<Gif>) {
        gifList = arrayList
        notifyDataSetChanged()
    }
}