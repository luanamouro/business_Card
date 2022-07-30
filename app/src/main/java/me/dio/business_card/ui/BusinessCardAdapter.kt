package me.dio.business_card.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.business_card.data.BusinessCard

class BusinessCardAdapter : ListAdapter <BusinessCard, BusinessCardAdapter, RecyclerView.ViewHolder>(DiffCallback()){

    var listenerShare: (View) -> Unit={ }

   override fun onCreateViewHolder(parent: ViewGroup,viewType: Int){
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater,parent,false)

       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int){
        holder.binding(getItem(position))
    }

    inner class ViewHolder{
        private val binding= ItemBusinessCardBinding
    } RecyclerView.ViewHolder(binding.root){
        fun binding (item: BusinessCard){
            binding.tvName.text = item.nome
            binding.tvTelephone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvCompany.text = item.empresa
            binding.mcContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback:DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}
