package com.imeepwni.common.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.imeepwni.common.data.FeatureDemo
import com.imeepwni.common.view_holder.FeatureDemoViewHolder

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
class FeatureDemoAdapter(
    private val onItemClickListener: (View, FeatureDemo) -> Unit
) : ListAdapter<FeatureDemo, FeatureDemoViewHolder>(FeatureDemo.getDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FeatureDemoViewHolder.create(parent, onItemClickListener)

    override fun onBindViewHolder(holder: FeatureDemoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}