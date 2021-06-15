package com.example.exo7

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat


class StartServiceOnBootReceiver:BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?) {
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent!!.action)){

            val serviceIntent = Intent(context, MyService::class.java)
            ContextCompat.startForegroundService(context!!, serviceIntent)

        }
    }

}



