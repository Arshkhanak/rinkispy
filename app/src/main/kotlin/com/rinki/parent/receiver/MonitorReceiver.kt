package com.rinki.parent.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pawegio.kandroid.IntentFor
import com.rinki.parent.services.social.MonitorService
import com.rinki.parent.utils.Consts.RESTART_MONITOR_RECEIVER

/**
 * Created by samuel incoom on 13/03/15.
 */
class MonitorReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == RESTART_MONITOR_RECEIVER) context.startService(IntentFor<MonitorService>(context))
    }
}