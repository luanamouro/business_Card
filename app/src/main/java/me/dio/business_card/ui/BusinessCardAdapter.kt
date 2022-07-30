package me.dio.business_card.ui

import android.graphics.Color
import android.view.View
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.business_card.data.BusinessCard

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter, RecyclerView.ViewHolder>(DiffCallback()){

    var listenerShare: (View) -> Unit={ }

    inner class ViewHolder{
        private val binding=ItemBusinessCardBinding
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
