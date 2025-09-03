package com.vonesolution.magnifyingglass.listener

import android.os.SystemClock
import android.view.View

abstract class OnSingleClickListener: View.OnClickListener {
    private var lastClickTime: Long = 0L

    override fun onClick(view: View) {
        val currentTime = SystemClock.uptimeMillis()
        if (currentTime - lastClickTime < MIN_CLICK_INTERVAL) {
            // Ignore click if it's within 300ms
            return
        }
        lastClickTime = currentTime
        onSingleClick(view)

    }
    abstract fun onSingleClick(view: View)

    companion object {
        private const val MIN_CLICK_INTERVAL: Long = 300
    }
}