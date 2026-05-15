package com.mine.spy.utils

import android.os.CountDownTimer
import com.mine.spy.utils.Consts.TAG
import com.pawegio.kandroid.i

/**
 * Created by samuel incoom on 19/03/15.
 */
class MyCountDownTimer(startTime: Long, interval: Long,private val timer:((timer:Long)->Unit)?=null,
                       private val func: () -> Unit) : CountDownTimer(startTime, interval) {
    override fun onFinish() = func()
    override fun onTick(t: Long) { i(TAG,"timer $t") ; timer?.invoke(t) }
}