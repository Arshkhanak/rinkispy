package com.mine.spy.ui.widget.pinlockview

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.mine.spy.R

class CustomPinLockView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CustomPinLockView, defStyleAttr, 0)
            try {
                val buttonSize = a.getDimensionPixelSize(R.styleable.CustomPinLockView_ButtonSize, 0)
                if (buttonSize > 0) {
                    minimumHeight = buttonSize
                }
            } finally {
                a.recycle()
            }
        }
    }
}
