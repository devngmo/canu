package com.tml.clibs.canu

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

@Suppress("unused")
class VolleyPool private constructor() {

    companion object {
        val ins = VolleyPool()

        @JvmStatic fun <T> add(request: Request<T>) {
            ins.queue!!.add(request)
        }
    }
    var queue: RequestQueue? = null

    fun init(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    fun release() {
        queue?.let {
            it.stop()
        }
        queue = null
    }

}