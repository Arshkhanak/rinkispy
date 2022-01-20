package com.worldcodes.parentalapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import com.worldcodes.parentalapp.data.preference.DataSharePreference.typeApp
import com.worldcodes.parentalapp.services.sms.SmsService
import com.worldcodes.parentalapp.utils.ConstFun.startServiceSms
import com.worldcodes.parentalapp.utils.Consts.TYPE_SMS_INCOMING


/**
 * Created by samuel incoom on 13/03/15.
 */
class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        var smsAddress = ""
        var smsBody = ""

        for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
            smsAddress = smsMessage.displayOriginatingAddress
            smsBody += smsMessage.messageBody
        }

        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION && !context.typeApp) context.startServiceSms<SmsService>(smsAddress, smsBody, TYPE_SMS_INCOMING)
    }

}