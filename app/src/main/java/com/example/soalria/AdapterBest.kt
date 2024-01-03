package com.example.soalria

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soalria.model.RateModel2


class AdapterBest(private val list: ArrayList<RateModel2>) : RecyclerView.Adapter<AdapterBest.RateViewHolder>(){

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_food, parent, false)

        return RateViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {

        holder.bind(list[position])

    }

    inner class RateViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val textMenu : TextView
        val context = v.context

        init {
            textMenu = v.findViewById(R.id.textViewJudulMenu)

        }


        fun bind(data: RateModel2){
            val menu:String = data.menu


            textMenu.text = menu

        }
    }


}