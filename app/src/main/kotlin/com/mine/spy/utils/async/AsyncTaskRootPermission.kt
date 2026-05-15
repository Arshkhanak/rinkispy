package com.mine.spy.utils.async

import android.content.Context
import android.os.AsyncTask
import com.chrisplus.rootmanager.RootManager

class AsyncTaskRootPermission(
    @Suppress("UNUSED_PARAMETER") private val context: Context,
    private val callback: (Boolean) -> Unit
) : AsyncTask<Void, Void, Boolean>() {

    override fun doInBackground(vararg params: Void?): Boolean {
        return try {
            val instance = RootManager.getInstance()
            val clazz = instance.javaClass
            when {
                hasNoArgBooleanMethod(clazz, "hasRooted") ->
                    clazz.getMethod("hasRooted").invoke(instance) as Boolean
                hasNoArgBooleanMethod(clazz, "isRoot") ->
                    clazz.getMethod("isRoot").invoke(instance) as Boolean
                else -> false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun hasNoArgBooleanMethod(clazz: Class<*>, name: String): Boolean {
        return try {
            val m = clazz.getMethod(name)
            m.returnType == Boolean::class.javaPrimitiveType && m.parameterTypes.isEmpty()
        } catch (e: NoSuchMethodException) {
            false
        }
    }

    override fun onPostExecute(result: Boolean) {
        callback(result)
    }
}
