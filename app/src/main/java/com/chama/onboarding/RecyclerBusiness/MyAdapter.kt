package com.chama.onboarding.RecyclerBusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chama.onboarding.model.Item
import com.chama.onboarding.R

class MyAdapter(
    private val itemList: ArrayList<Item>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_image_view)
        val textView: TextView = itemView.findViewById(R.id.tv_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.title

    }

    override fun getItemCount() = itemList.size


}
