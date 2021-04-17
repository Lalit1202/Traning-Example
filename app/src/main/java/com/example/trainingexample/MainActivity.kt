package com.example.trainingexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val list = ArrayList<Data>()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recycler_view)
        var adapter = RecyclerViewAdapter(this,list)

        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE,"Resume Training",null,0,""))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO,"Wallet & Transactions",getDrawable(R.drawable.icon1),46,"46%"))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE,"Other Training",null,0,""))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO,"Accepting Order",getDrawable(R.drawable.icon1),30,"30%"))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO,"Helper Support",getDrawable(R.drawable.icon1),80,"80%"))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO,"Outstation Trip GuideLines",getDrawable(R.drawable.icon1),50,"50%"))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO,"Outstation Trip GuideLines",getDrawable(R.drawable.icon1),78,"78%"))
        list.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE,"Completed Training",null,0,""))



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }



}