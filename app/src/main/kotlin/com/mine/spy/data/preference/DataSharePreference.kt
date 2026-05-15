package com.mine.spy.data.preference

import android.content.Context
import android.content.SharedPreferences

object DataSharePreference {
    lateinit var prefs: SharedPreferences
        private set

    fun init(context: Context) {
        if (!::prefs.isInitialized) {
            prefs = context.applicationContext.getSharedPreferences("mine_spy_prefs", Context.MODE_PRIVATE)
        }
    }
}

private const val KEY_TYPE_APP = "type_app_parent"
private const val KEY_CHILD_PHOTO = "child_photo"
private const val KEY_CHILD_SELECTED = "child_selected"
private const val KEY_DEVICE_CHILD = "device_child_selected"

val Context.typeApp: Boolean
    get() = DataSharePreference.prefs.getBoolean(KEY_TYPE_APP, false)

var Context.childPhoto: String
    get() = DataSharePreference.prefs.getString(KEY_CHILD_PHOTO, "") ?: ""
    set(value) {
        DataSharePreference.prefs.edit().putString(KEY_CHILD_PHOTO, value).apply()
    }

var Context.childSelected: String
    get() = DataSharePreference.prefs.getString(KEY_CHILD_SELECTED, "") ?: ""
    set(value) {
        DataSharePreference.prefs.edit().putString(KEY_CHILD_SELECTED, value).apply()
    }

var Context.deviceChildSelected: String
    get() = DataSharePreference.prefs.getString(KEY_DEVICE_CHILD, "") ?: ""
    set(value) {
        DataSharePreference.prefs.edit().putString(KEY_DEVICE_CHILD, value).apply()
    }
