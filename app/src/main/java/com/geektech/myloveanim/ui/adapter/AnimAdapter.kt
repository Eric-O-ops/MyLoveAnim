package com.geektech.myloveanim.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.myloveanim.R
import com.geektech.myloveanim.databinding.ItemAnimBinding
import com.geektech.myloveanim.model.AnimModel

class AnimAdapter: RecyclerView.Adapter<AnimAdapter.ViewHolder>() {

    private var animList: List<AnimModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setupAnimList(list: List<AnimModel>){
        this.animList = list
        notifyDataSetChanged()

    }

    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding = ItemAnimBinding.bind(item)

        fun onBind(model: AnimModel) {
            binding.itemTitle.text = model.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anim,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(animList[position])

    }


    override fun getItemCount(): Int {
        return animList.size
    }
}