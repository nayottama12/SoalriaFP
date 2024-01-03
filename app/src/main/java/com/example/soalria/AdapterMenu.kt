package com.example.soalria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterMenu(private  val listMenu:List<MenuModel>): RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val image:ImageView = itemView.findViewById(R.id.imageViewMenu)
        val title:TextView = itemView.findViewById(R.id.textViewJudulMenu)
        val desc:TextView = itemView.findViewById(R.id.textViewDescMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout_menu,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelMenu = listMenu[position]

        holder.image.setImageResource(modelMenu.image)
        holder.title.text = modelMenu.title
        holder.desc.text = modelMenu.desc
    }


    override fun getItemCount(): Int {
        return listMenu.size
    }
}




