package com.rubrik.rubrikapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationListenService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("PushNotificationListen", "got message from: " + remoteMessage.getFrom());
        if(remoteMessage.getData().size() > 0){
            Log.d("PushNotificationListen", "message data: " + remoteMessage.getData());
        }
        if(remoteMessage.getNotification() != null){
            Log.d("PushNotificationListen", "message body: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification());
        }
    }

    private void sendNotification(RemoteMessage.Notification notification) {
        Intent intent = new Intent(this, ContactSupport.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//
//        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "af")
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Notification checker")
//                .setContentText(body)
//                .setAutoCancel(true)
//                .setSound(notificationSound)
//                .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notificationBuilder.build());


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_MAX);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        String color =
           (notification.getTitle().equals("Success")) ? "#06FF12" : "#FF1517";

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Hearty365")
                .setColor(Color.parseColor(color))
                //     .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentInfo("Info")
                .setContentIntent(pendingIntent);

        notificationManager.notify(/*notification id*/1, notificationBuilder.build());
    }
}
