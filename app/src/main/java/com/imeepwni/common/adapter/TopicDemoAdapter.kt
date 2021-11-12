package com.imeepwni.common.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.imeepwni.common.data.TopicDemo
import com.imeepwni.common.view_holder.TopicDemoViewHolder

/**
 * Created by feng.guo on 2021/11/15.
 * feng.guo@bees360.com
 */
class TopicDemoAdapter constructor(
    private val onItemClickListener: (View, TopicDemo) -> Unit,
) : ListAdapter<TopicDemo, TopicDemoViewHolder>(TopicDemo.getDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TopicDemoViewHolder.create(parent, onItemClickListener)

    override fun onBindViewHolder(holder: TopicDemoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}