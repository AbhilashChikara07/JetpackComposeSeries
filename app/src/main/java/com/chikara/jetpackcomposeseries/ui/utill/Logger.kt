package com.chikara.jetpackcomposeseries.utils

import android.util.Log

object Logger {

    private const val DEFAULT_TAG = "AppLogger"

    // Debug logs
    fun d(tag: String = DEFAULT_TAG, message: String) {
        Log.d(tag, message)
    }

    // Info logs
    fun i(tag: String = DEFAULT_TAG, message: String) {
        Log.i(tag, message)
    }

    // Warning logs
    fun w(tag: String = DEFAULT_TAG, message: String) {
        Log.w(tag, message)
    }

    // Error logs
    fun e(tag: String = DEFAULT_TAG, message: String, throwable: Throwable? = null) {
        if (throwable != null) {
            Log.e(tag, message, throwable)
        } else {
            Log.e(tag, message)
        }
    }

    // Verbose logs
    fun v(tag: String = DEFAULT_TAG, message: String) {
        Log.v(tag, message)
    }

    // Optional: shortcut for printing any object
    fun print(tag: String = DEFAULT_TAG, any: Any?) {
        Log.d(tag, any.toString())
    }
}
