package com.example.wisata_malang.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_malang.databinding.ItemVacationBinding
import com.example.wisata_malang.model.Vacation

class VacationAdapter : RecyclerView.Adapter<VacationAdapter.ViewHolder>() {
    private val listTourism = ArrayList<Vacation>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(list: ArrayList<Vacation>) {
        listTourism.clear()
        listTourism.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVacationBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listTourism.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTourism[position])
    }


    inner class ViewHolder(private val binding: ItemVacationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(vacation: Vacation) {
            binding.vacation = vacation
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(vacation)}
            binding.executePendingBindings()
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Vacation)
    }
}