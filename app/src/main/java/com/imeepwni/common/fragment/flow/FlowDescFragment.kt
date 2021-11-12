package com.imeepwni.common.fragment.flow

import android.view.View
import com.imeepwni.common.R
import com.imeepwni.common.data.TopicDemo
import com.imeepwni.common.fragment.BaseDescFragment

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
class FlowDescFragment : BaseDescFragment() {

    override fun getLabel() = R.string.flow

    override fun getDesc() = R.string.flow_desc

    override fun getTopicDemoList() = listOf(
        TopicDemo("Flow Mock", "Mock Class Name")
    )

    override fun onItemClickCallback(view: View, topicDemo: TopicDemo) {

    }
}