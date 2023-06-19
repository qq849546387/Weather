package com.qsck.weather.ui

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.qsck.weather.common.dp

class WeatherItemDecoration(private val spacing: Int = 16.dp) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)

        if (itemPosition == 0) {
            outRect.top = spacing
        }
        outRect.bottom = spacing
        outRect.left = spacing
        outRect.right = spacing
    }
}