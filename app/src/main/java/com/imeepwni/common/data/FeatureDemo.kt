package com.imeepwni.common.data

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
data class FeatureDemo(
    val title: String,
) {
    companion object {

        fun getDiffUtilItemCallback() = object : DiffUtil.ItemCallback<FeatureDemo>() {
            override fun areItemsTheSame(oldItem: FeatureDemo, newItem: FeatureDemo) = oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: FeatureDemo, newItem: FeatureDemo) = oldItem == newItem
        }
    }
}
