package com.geektech.myloveanim.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.myloveanim.R
import com.geektech.myloveanim.databinding.ItemAnimBinding
import com.geektech.myloveanim.model.AnimModel

class AnimAdapter(
    private var onShortClick: OnClick
): RecyclerView.Adapter<AnimAdapter.ViewHolder>() {

    private var animList: List<AnimModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setupAnimList(list: List<AnimModel>){
        this.animList = list
        notifyDataSetChanged()

    }

    class ViewHolder(private val binding: ItemAnimBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: AnimModel, onShortClick: OnClick) {
            binding.itemTitle.text = model.title

            itemView.setOnClickListener {
                onShortClick.onShortClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(animList[position],onShortClick)

    }

    override fun getItemCount(): Int {
        return animList.size
    }
}

interface OnClick{
    fun onShortClick(model: AnimModel)
}