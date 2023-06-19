package com.qsck.weather.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MarqueeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    override fun isFocused(): Boolean {
        return true
    }

}