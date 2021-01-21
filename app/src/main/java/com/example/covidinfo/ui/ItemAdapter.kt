package com.example.covidinfo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.covidinfo.databinding.ListItemsBinding
import com.example.covidinfo.model.StateData
import com.example.covidinfo.model.StateInfo

class ItemAdapter (val data:ArrayList<StateInfo>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ListItemsBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(dataItem:StateInfo){
            binding.itemName.text=dataItem.country
            binding.itemCases.text=dataItem.totalConfirmed.toString()
            binding.itemDeaths.text=dataItem.totalDeath.toString()
            binding.itemRecover.text=dataItem.totalRecovered.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        ListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)=holder.bind(data[position])

}