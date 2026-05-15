package com.mine.spy.ui.widget.pinlockview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class IndicatorDots @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        orientation = HORIZONTAL
    }
}
