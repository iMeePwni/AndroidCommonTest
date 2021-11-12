package com.imeepwni.common.data

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by feng.guo on 2021/11/15.
 * feng.guo@bees360.com
 */
data class TopicDemo(
    val title: String,
    val className: String,
) {
    companion object {

        fun getDiffUtilItemCallback() = object : DiffUtil.ItemCallback<TopicDemo>() {
            override fun areItemsTheSame(oldItem: TopicDemo, newItem: TopicDemo) = oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: TopicDemo, newItem: TopicDemo) = oldItem == newItem
        }
    }
}
