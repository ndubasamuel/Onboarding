package com.chama.onboarding.Data

import com.chama.onboarding.R
import com.chama.onboarding.model.Item
import com.chama.onboarding.model.MyStrings
import com.chama.onboarding.model.Transactions

class DataSource {

    fun loadMyStrings(): List<MyStrings> {
        return listOf<MyStrings>(
            MyStrings(
                "Eclectics Chama",
                "Defaulted",
                "Due date: 06-09-2021",
                "Penalty Amount",
                "Amount due: ksh 14000",
                "Ksh 1400"
            )
            )
    }
    fun setDataList(): ArrayList<Item> {
        val items = ArrayList<Item>()
        items.add(Item(R.drawable.bank, "Bank Account"))
        items.add(Item(R.drawable.payment, "Loans"))
        items.add(Item(R.drawable.home, "My Approvals"))
        items.add(Item(R.drawable.user, "Edit Group"))
        items.add(Item(R.drawable.people, "Members"))
        items.add(Item(R.drawable.cash_withdrawal, "Withdrawals"))


        return items
    }

     fun myTransactions(): List<Transactions> {
        val transactions = mutableListOf<Transactions>()
        transactions.add(Transactions("07/02/2023", "Chama Cont", "MPESA", "1200.00"))
        transactions.add(Transactions("04/02/2022", "Chama Cont", "MPESA", "1200.00"))
        transactions.add(Transactions("30/01/2021", "Penalty", "MPESA", "400.00"))
        transactions.add(Transactions("07/02/2021", "Chama Cont", "MPESA", "1200.00"))
        transactions.add(Transactions("07/02/2021", "Overdraft", "MPESA", "2200.00"))


        return transactions
    }

}