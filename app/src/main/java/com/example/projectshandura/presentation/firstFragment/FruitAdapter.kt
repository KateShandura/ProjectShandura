package com.example.projectshandura.presentation.firstFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacknav.R
import com.example.projectshandura.data.local.model.Fruit

class FruitAdapter(
    val listner: Listener
) :RecyclerView.Adapter<FruitAdapter.FruitViewHolder>()  {

    private val fruits = ArrayList<Fruit>()

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewAnimalName : TextView = itemView.findViewById(R.id.nameOfFruit)
        var textViewAnimalShortDescription : TextView = itemView.findViewById(R.id.shortDescriptionOfFruit)
        var image : ImageView = itemView.findViewById(R.id.imageFruit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.animal_card,parent,false)
        return FruitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listner.onClick(fruits.get(position))
        }
        Glide.with(holder.itemView.context)
            .load(fruits.get(position).urlImage).fitCenter().into(holder.image)
        holder.textViewAnimalName.text = fruits.get(position).name
        holder.textViewAnimalShortDescription.text = fruits.get(position).desc
    }

    fun setList(newList: List<Fruit>){
        fruits.clear()
        fruits.addAll(newList)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(fruit: Fruit)
    }
}