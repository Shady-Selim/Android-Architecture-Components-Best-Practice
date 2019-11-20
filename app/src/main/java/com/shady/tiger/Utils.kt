package com.shady.tiger

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils {
    fun online(context: Context): Boolean{
        var status = false
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if((cm?.getNetworkInfo(0)?.state == NetworkInfo.State.CONNECTED) || (cm?.getNetworkInfo(1)?.state == NetworkInfo.State.CONNECTED)){
                status = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return status
    }
}