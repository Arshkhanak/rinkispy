package com.mine.spy.services.calls

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CallsService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY
}
