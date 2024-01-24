package com.chama.onboarding.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chama.onboarding.Data.DataSource
import com.chama.onboarding.R
import com.chama.onboarding.RecyclerBusiness.Card1Adapter
import com.chama.onboarding.model.Item
import com.chama.onboarding.RecyclerBusiness.MyAdapter
import com.chama.onboarding.RecyclerBusiness.TransactionsAdapter
import com.chama.onboarding.databinding.FragmentHomeBinding
import com.chama.onboarding.model.MyStrings
import com.chama.onboarding.model.Transactions


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    //recyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var card1RecyclerView: RecyclerView
    private lateinit var transactionsRecyclerView: RecyclerView
    //adapters
    private lateinit var myAdapter: MyAdapter
    private lateinit var card1Adapter: Card1Adapter
    private lateinit var transactionsAdapter: TransactionsAdapter
    private var itemList: ArrayList<Item> = ArrayList()
    private lateinit var dataset: List<MyStrings>
    private lateinit var myListTransactions: List<Transactions>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = view.findViewById(R.id.Recycler_View)
        card1RecyclerView = view.findViewById(R.id.card1_recycler)
        transactionsRecyclerView = view.findViewById(R.id.card2_recycler)

        setupRecyclerViews()

        val dataSource = DataSource()
        dataset = dataSource.loadMyStrings()
        itemList = dataSource.setDataList()
        myListTransactions = dataSource.myTransactions()


        setupAdapters()

        return view
    }

    private fun setupRecyclerViews() {
        recyclerView.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.layoutManager = gridLayoutManager

//        val gridLayoutManager1 = GridLayoutManager(requireContext(), 2)
        val linearLayoutManager0 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        card1RecyclerView.layoutManager = linearLayoutManager0

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        transactionsRecyclerView.layoutManager = linearLayoutManager

    }

    private fun setupAdapters() {
        myAdapter = MyAdapter(itemList)
        recyclerView.adapter = myAdapter

        card1Adapter = Card1Adapter(dataset)
        card1RecyclerView.adapter = card1Adapter

        transactionsAdapter = TransactionsAdapter(myListTransactions)
        transactionsRecyclerView.adapter = transactionsAdapter



    }

}
