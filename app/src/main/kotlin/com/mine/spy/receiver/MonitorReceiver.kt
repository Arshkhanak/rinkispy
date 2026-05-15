package com.mine.spy.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mine.spy.services.social.MonitorService
import com.mine.spy.utils.Consts.RESTART_MONITOR_RECEIVER
import com.pawegio.kandroid.IntentFor

class MonitorReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == RESTART_MONITOR_RECEIVER) {
            context.startService(IntentFor<MonitorService>(context))
        }
    }
}
