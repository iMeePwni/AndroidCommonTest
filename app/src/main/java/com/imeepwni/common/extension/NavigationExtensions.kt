package com.imeepwni.common.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections

/**
 * Created by feng.guo on 2021/11/12.
 * feng.guo@bees360.com
 */
fun NavController.navigateSafe(direction: NavDirections) {
    currentDestination?.getAction(direction.actionId)?.let { navigate(direction) }
}