package com.araskaplan.countries.domain.view.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.araskaplan.countries.R
import com.araskaplan.countries.domain.model.CountryHomePageUiModel

class CountryAdapter(val onClick: (position: Int) -> Unit) :
    ListAdapter<CountryHomePageUiModel, CountryAdapter.CountryUiModelViewHolder>(
        CountryAdapterDiffCallback()
    ) {

    class CountryUiModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val countryName: TextView = view.findViewById(R.id.textview_countrycard_countryname)

        fun bindData(countryUiModel: CountryHomePageUiModel) {
            countryName.text = countryUiModel.country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryUiModelViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_country_card, parent, false)
        return CountryUiModelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryUiModelViewHolder, position: Int) {
        holder.bindData(getItem(position))
        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }
}

class CountryAdapterDiffCallback : DiffUtil.ItemCallback<CountryHomePageUiModel>() {
    override fun areItemsTheSame(
        oldItem: CountryHomePageUiModel,
        newItem: CountryHomePageUiModel
    ): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(
        oldItem: CountryHomePageUiModel,
        newItem: CountryHomePageUiModel
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}