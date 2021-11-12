package com.imeepwni.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.imeepwni.common.R
import com.imeepwni.common.adapter.FeatureDemoAdapter
import com.imeepwni.common.data.FeatureDemo
import com.imeepwni.common.databinding.FragmentIndexBinding
import com.imeepwni.common.divider.GridDividerDecoration

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
class IndexFragment : BaseFragment() {

    private lateinit var mBinding: FragmentIndexBinding
    private lateinit var mAdapter: FeatureDemoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentIndexBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val spanCount = 2
        mAdapter = FeatureDemoAdapter { view, data ->
            when (data.title) {
                getString(R.string.kotlin) -> IndexFragmentDirections.actionKotlinDescFragment()
                getString(R.string.flow) -> IndexFragmentDirections.actionFlowDescFragment()
                else -> null
            }?.let {
                val extras = FragmentNavigatorExtras(view to view.transitionName)
                findNavController().navigate(
                    it.actionId,
                    null,
                    null,
                    extras
                )
            }
        }
        requireContext().resources.getStringArray(R.array.feature_list).map { FeatureDemo(it) }
            .let { mAdapter.submitList(it) }
        mBinding.rvContent.run {
            layoutManager = GridLayoutManager(requireContext(), spanCount, GridLayoutManager.VERTICAL, false)
            addItemDecoration(
                GridDividerDecoration(
                    requireContext().resources.getDimensionPixelSize(R.dimen.divider_size),
                    ContextCompat.getColor(requireContext(), R.color.divider_color),
                    spanCount,
                )
            )
            adapter = mAdapter
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
    }
}