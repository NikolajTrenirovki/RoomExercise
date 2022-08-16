package com.sem.roomexercise.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.roomexercise.R
import com.sem.roomexercise.data.models.TownModel
import com.sem.roomexercise.databinding.ItemBinding

class TownAdapter() : RecyclerView.Adapter<TownAdapter.TownHolder>() {

    private val townList = ArrayList<TownModel>()

    class TownHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(townModel: TownModel){
            binding.name.text = townModel.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item, parent, false)
        return TownHolder(binding)
    }

    override fun onBindViewHolder(holder: TownHolder, position: Int) {
        holder.bind(townList[position])
    }

    override fun getItemCount(): Int {
        return townList.size
    }
}