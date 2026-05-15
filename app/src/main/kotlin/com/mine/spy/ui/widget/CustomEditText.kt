package com.mine.spy.ui.widget

import android.content.Context
import android.text.InputFilter
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.mine.spy.R

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = androidx.appcompat.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText, defStyleAttr, 0)
            try {
                val hint = a.getString(R.styleable.CustomEditText_et_hint)
                if (hint != null) {
                    setHint(hint)
                }
                if (a.hasValue(R.styleable.CustomEditText_et_maxCharacters)) {
                    val max = a.getInt(R.styleable.CustomEditText_et_maxCharacters, Int.MAX_VALUE)
                    if (max in 1 until Int.MAX_VALUE) {
                        filters = arrayOf(InputFilter.LengthFilter(max))
                    }
                }
            } finally {
                a.recycle()
            }
        }
    }
}
