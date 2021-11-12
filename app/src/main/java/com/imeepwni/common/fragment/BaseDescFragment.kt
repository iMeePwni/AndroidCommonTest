package com.imeepwni.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialContainerTransform
import com.imeepwni.common.adapter.TopicDemoAdapter
import com.imeepwni.common.data.TopicDemo
import com.imeepwni.common.databinding.FragmentBaseDescBinding

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
abstract class BaseDescFragment : BaseFragment() {

    private lateinit var mAdapter: TopicDemoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = getMaterialContainerTransform(true)
        sharedElementReturnTransition = getMaterialContainerTransform(false)
    }

    private fun getMaterialContainerTransform(entering: Boolean) =
        MaterialContainerTransform(requireContext(), entering).apply {
            containerColor = ContextCompat.getColor(requireContext(), android.R.color.white)
            fadeMode = MaterialContainerTransform.FADE_MODE_THROUGH
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentBaseDescBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            title = getString(getLabel())
            description = getString(getDesc())
        }
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        mAdapter = TopicDemoAdapter { view, topicDemo -> onItemClickCallback(view, topicDemo) }
        mAdapter.submitList(getTopicDemoList())
        binding.rvContent.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        binding.root.transitionName = getString(getLabel())
        return binding.root
    }

    @StringRes
    abstract fun getLabel(): Int

    @StringRes
    abstract fun getDesc(): Int

    abstract fun getTopicDemoList(): List<TopicDemo>

    abstract fun onItemClickCallback(view: View, topicDemo: TopicDemo)
}