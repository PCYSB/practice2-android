package com.example.practice_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.practice_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)
        val itemList = ArrayList<BoardItem>()
        for (i in 1.. 100){
            itemList.add(BoardItem("$i", "$i 번째 제목", "$i 번째 이름"))
            val boardAdapter = RecyclerViewAdapter(itemList)
            boardAdapter.notifyDataSetChanged()

            rv.adapter = boardAdapter
            rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        }

    }
}

class RecyclerViewAdapter(val itemList: ArrayList<BoardItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.BoardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_time.text = itemList[position].time
        holder.tv_title.text = itemList[position].title
        holder.tv_name.text = itemList[position].name
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_time = itemView.findViewById<TextView>(R.id.tv_time)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
    }
}