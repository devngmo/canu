@file:Suppress("unused")

package com.tml.clibs.canu

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.ParseError
import org.json.JSONException
import com.android.volley.toolbox.HttpHeaderParser
import org.json.JSONObject
import android.R.attr.data
import com.android.volley.NetworkResponse
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset


/**
 * Created by TML on 28/03/2018.
 */
open class UTF8StringRequest(method:Int, url:String, listener:Response.Listener<String>, errorListener:Response.ErrorListener) : StringRequest(method, url, listener, errorListener) {
    override fun parseNetworkResponse(response: NetworkResponse): Response<String> {
        try {
            val utf8String = String(response.data, Charset.forName("UTF-8"))
            return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response))
        } catch (e: UnsupportedEncodingException) {
            // log error
            return Response.error(ParseError(e))
        } catch (e: JSONException) {
            // log error
            return Response.error(ParseError(e))
        }

    }
}