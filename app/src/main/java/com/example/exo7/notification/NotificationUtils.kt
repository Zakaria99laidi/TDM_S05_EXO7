package com.example.exo7.notification

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color


class NotificationUtils(base: Context) : ContextWrapper(base) {

    lateinit var  mManager: NotificationManager
    val   ANDROID_CHANNEL_ID:String  = "com.testandroid.pushnotifications.ANDROID"
    val   ANDROID_CHANNEL_NAME:String  = "ANDROID CHANNEL"



    init {
        createChannels()
    }



    fun createChannels() {


        // create android channel
         val androidChannel: NotificationChannel =  NotificationChannel(ANDROID_CHANNEL_ID,
            ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)

        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true);
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true);
        // Sets the notification light color for notifications posted to this channel
        androidChannel.setLightColor(Color.GREEN);
        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);



        getManager().createNotificationChannel(androidChannel)


    }

    fun  getManager():NotificationManager {

            mManager =  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        return mManager;
    }

    fun getAndroidChannelNotification(
        title: String?,
        body: String?
    ): Notification.Builder? {
        return Notification.Builder(applicationContext, ANDROID_CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.stat_notify_more)
            .setAutoCancel(true)
    }
}