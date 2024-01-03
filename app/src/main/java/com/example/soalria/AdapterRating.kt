package com.example.soalria

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soalria.model.RateModel


class AdapterRating(private val list: ArrayList<RateModel>) : RecyclerView.Adapter<AdapterRating.RateViewHolder>(){

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_acc, parent, false)

        return RateViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {

        holder.bind(list[position])

    }

    inner class RateViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val textMenu : TextView
        val textRating: TextView
        val textSaran : TextView
        val context = v.context

        init {
            textMenu = v.findViewById(R.id.textViewRateFood)
            textRating = v.findViewById(R.id.textViewJudulRate)
            textSaran = v.findViewById(R.id.textViewDescRate)
        }


        fun bind(data: RateModel){
            val menu:String = data.menu
            val rating:Float = data.rate
            val saran:String = data.saran

            textMenu.text = menu
            textRating.text = rating.toString()
            textSaran.text = saran
        }
    }


}