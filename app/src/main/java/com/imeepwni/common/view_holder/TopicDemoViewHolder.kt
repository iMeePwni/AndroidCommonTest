package com.imeepwni.common.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imeepwni.common.data.TopicDemo
import com.imeepwni.common.databinding.ItemDemoBinding

/**
 * Created by feng.guo on 2021/11/15.
 * feng.guo@bees360.com
 */
class TopicDemoViewHolder constructor(
    private val binding: ItemDemoBinding,
    onItemClickListener: (View, TopicDemo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { onItemClickListener(it, binding.data!!) }
    }

    fun bind(topicDemo: TopicDemo) {
        binding.data = topicDemo
        binding.executePendingBindings()
    }

    companion object {

        fun create(parent: ViewGroup, onItemClickListener: (View, TopicDemo) -> Unit) = TopicDemoViewHolder(
            ItemDemoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener,
        )
    }
}