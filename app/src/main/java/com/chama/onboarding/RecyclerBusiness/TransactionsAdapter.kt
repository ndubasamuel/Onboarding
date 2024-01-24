package com.chama.onboarding.RecyclerBusiness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chama.onboarding.R
import com.chama.onboarding.model.Transactions

class TransactionsAdapter(private val myListTransactions: List<Transactions>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        val myTable = LayoutInflater.from(parent.context). inflate(R.layout.card_item2, parent, false)

        return TransactionsViewHolder(myTable)
    }
    override fun getItemCount(): Int {
        return myListTransactions.size
    }
    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val tableData = myListTransactions[position]
        holder.textView.text = tableData.date.toString()
        holder.textView1.text = tableData.description.toString()
        holder.textView2.text = tableData.mode.toString()
        holder.textView3.text = tableData.amount.toString()
    }
    class TransactionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.tv_Date)
        val textView1: TextView = itemView.findViewById(R.id.tv_Description)
        val textView2: TextView = itemView.findViewById(R.id.tv_Mode)
        val textView3: TextView = itemView.findViewById((R.id.tv_Amount))
    }
}