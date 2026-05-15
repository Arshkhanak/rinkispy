package com.mine.spy.utils.async

import android.os.AsyncTask

class AsyncTaskRunCommand(
    private val onPostFunc: (() -> Unit)? = null
) : AsyncTask<String, Void, Void?>() {

    override fun doInBackground(vararg params: String?): Void? {
        for (cmd in params) {
            if (cmd.isNullOrBlank()) continue
            try {
                Runtime.getRuntime().exec(arrayOf("sh", "-c", cmd))
            } catch (e: Exception) {
                // Best-effort; full root pipeline restored when sources are complete.
            }
        }
        return null
    }

    override fun onPostExecute(result: Void?) {
        onPostFunc?.invoke()
    }
}
