package com.chama.onboarding.RecyclerBusiness

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chama.onboarding.R
import com.chama.onboarding.model.MyStrings

class Card1Adapter(
     private val dataset: List<MyStrings>
): RecyclerView.Adapter<Card1Adapter.Card1ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Card1ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item1, parent, false )

        return Card1ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: Card1ViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView1.text = item.text1.toString()
        holder.textView2.text = item.text2.toString()
        holder.textView3.text = item.text3.toString()
        holder.textView4.text = item.text4.toString()
        holder.textView5.text = item.text5.toString()
        holder.textView6.text = item.text6.toString()

    }
    class Card1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.card_text1)
        val textView2: TextView = itemView.findViewById(R.id.card_text2)
        val textView3: TextView = itemView.findViewById(R.id.card_text3)
        val textView4: TextView = itemView.findViewById(R.id.card_text4)
        val textView5: TextView = itemView.findViewById(R.id.card_text5)
        val textView6: TextView = itemView.findViewById(R.id.card_text6)


    }
}