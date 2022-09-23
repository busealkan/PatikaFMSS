package com.busealkan.marsapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busealkan.marsapp.ItemClickListener
import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.databinding.CardviewRealestateBinding
import com.busealkan.marsapp.loadFromUrl

//ListAdapter sınıfıdır.
class ListAdapter(
    var mars: List<MarsModelItem>,
    var onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //ViewHolder oluşturuluyor.
    inner class ViewHolder(val binding: CardviewRealestateBinding) :
        RecyclerView.ViewHolder(binding.root)

    //ViewHolder bind ediliyor.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardviewRealestateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    //mars listesinin boyutunu döndürür.
    override fun getItemCount(): Int {
        return mars.size
    }

    //mars listine, gelen parametre olan marsTypeFilter değerinin atamasını yapar.
    fun setData(marsTypeFilter: List<MarsModelItem>) {
        mars = marsTypeFilter
    }

    //Dataların oluşturulmasını sağlar.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.apply {
                imgMars.loadFromUrl(mars[position].img_src)
                txtPrice.text = mars[position].price.toString()

                realestateCard.setOnClickListener {
                    onItemClickListener.onItemClick(position)
                }
            }
        }
    }
}