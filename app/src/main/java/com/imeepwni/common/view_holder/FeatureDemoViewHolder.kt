package com.imeepwni.common.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imeepwni.common.data.FeatureDemo
import com.imeepwni.common.databinding.ItemIndexBinding

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
class FeatureDemoViewHolder(
    private val binding: ItemIndexBinding,
    onItemClickListener: (View, FeatureDemo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { onItemClickListener(it, binding.data!!) }
    }

    fun bind(featureDemo: FeatureDemo) {
        binding.data = featureDemo
        binding.executePendingBindings()
    }

    companion object {

        fun create(parent: ViewGroup, onItemClickListener: (View, FeatureDemo) -> Unit) =
            FeatureDemoViewHolder(
                ItemIndexBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onItemClickListener,
            )
    }
}