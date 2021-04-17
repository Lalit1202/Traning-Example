package com.example.trainingexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter (context:Context,list: ArrayList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    companion object{
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context: Context = context
    var list : ArrayList<Data> = list

    private inner class TextHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var textView: TextView = itemView.findViewById(R.id.textView2)
        fun bind(position: Int)
        {
            val recyclerViewModel = list[position]
            textView.text = recyclerViewModel.TextData
        }
    }


    private inner class ComplexHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var textView: TextView = itemView.findViewById(R.id.textView)
        var imageView:CircleImageView = itemView.findViewById(R.id.imageView2)
        var progressBar:ProgressBar = itemView.findViewById(R.id.progressBar)
        var percent: TextView = itemView.findViewById(R.id.percent)
        fun bind(position: Int)
        {
            val recyclerViewModel = list[position]
            textView.text = recyclerViewModel.TextData
            imageView.background = recyclerViewModel.image
            progressBar.progress = recyclerViewModel.progress
            percent.text = recyclerViewModel.percent
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType)
        {
            VIEW_TYPE_ONE ->
            {
                val view = LayoutInflater.from(context).inflate(R.layout.text_data,parent,false)
                TextHolder(view)
            }
            VIEW_TYPE_TWO ->
            {
                val view = LayoutInflater.from(context).inflate(R.layout.design_data,parent,false)
                ComplexHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(list[position].viewType)
        {
            VIEW_TYPE_ONE->
            {
                (holder as TextHolder).bind(position)
            }
            VIEW_TYPE_TWO->
            {
                (holder as ComplexHolder).bind(position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }



}