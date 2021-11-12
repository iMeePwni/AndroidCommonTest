package com.imeepwni.common.fragment.kotlin

import android.content.Intent
import android.view.View
import androidx.core.net.toUri
import com.imeepwni.common.R
import com.imeepwni.common.data.TopicDemo
import com.imeepwni.common.fragment.BaseDescFragment

private const val HOME = "Home"
private const val IDIOMS = "Idioms"

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
class KotlinDescFragment : BaseDescFragment() {

    override fun getLabel() = R.string.kotlin

    override fun getDesc() = R.string.kotlin_desc

    override fun getTopicDemoList() = listOf(
        TopicDemo(HOME, Intent.ACTION_VIEW),
        TopicDemo(IDIOMS, Intent.ACTION_VIEW),
    )

    override fun onItemClickCallback(view: View, topicDemo: TopicDemo) {
        when (topicDemo.title) {
            HOME -> "https://kotlinlang.org/docs/home.html"
            IDIOMS -> "https://kotlinlang.org/docs/idioms.html"
            else -> null
        }?.let { requireActivity().startActivity(Intent(Intent.ACTION_VIEW, it.toUri())) }
    }
}