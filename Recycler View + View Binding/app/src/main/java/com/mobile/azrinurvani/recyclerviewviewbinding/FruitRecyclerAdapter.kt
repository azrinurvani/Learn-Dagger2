package com.mobile.azrinurvani.recyclerviewviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mobile.azrinurvani.recyclerviewviewbinding.databinding.ItemListFruitsBinding

class FruitRecyclerAdapter(val fruitName:ArrayList<String>,val fruitImage:ArrayList<Int>) : RecyclerView.Adapter<FruitRecyclerAdapter.FruitViewHolder>() {

    lateinit var recyclerRowBinding : ItemListFruitsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        recyclerRowBinding = ItemListFruitsBinding.inflate(inflater,parent,false)
        return FruitViewHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return fruitName.size
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.image.setImageResource(fruitImage[position])
        holder.name.text = fruitName[position]

        holder.image.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Anda memilih : ${fruitName[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    class FruitViewHolder(itemListFruitsBinding: ItemListFruitsBinding): RecyclerView.ViewHolder(itemListFruitsBinding.root) {
        private var itemListFruitsBinding : ItemListFruitsBinding = itemListFruitsBinding

        val image = this.itemListFruitsBinding.imgFruit
        val name = this.itemListFruitsBinding.txtFruit

    }

}