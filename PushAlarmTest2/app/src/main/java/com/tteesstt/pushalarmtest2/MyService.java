package com.tteesstt.pushalarmtest2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    NotificationManager  notificationManager;
    ServiceThread thread;
    Notification notification;
    Notification notification2;

    Notification summary;
    NotificationChannel notificationChannel;
    int tempID = 0;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("channel description"); notificationChannel.enableLights(true); notificationChannel.setLightColor(Color.GREEN);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        notificationManager.createNotificationChannel(notificationChannel);




        notification = new NotificationCompat.Builder(getApplicationContext(), "channel_id")
                .setContentTitle("명기님")
                .setContentText("보냄")
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setGroup("test")
                .build();


        notification2 = new NotificationCompat.Builder(getApplicationContext(), "channel_id")
                .setContentTitle("보성님")
                .setContentText("보냄")
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setGroup("test")
                .build();

        summary = new NotificationCompat.Builder(getApplicationContext(),"channel_id")
                .setContentText("no read")
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setGroup("test")
                .setGroupSummary(true) // summary noti 로 만드는 핵심, API 20 이상
                .build();




        myServiceHandler handler = new myServiceHandler();
        thread = new ServiceThread(handler);
        thread.start();


        return START_STICKY;
    }

    //서비스가 종료될 때 할 작업

    public void onDestroy() {
        thread.stopForever();
        thread = null;//쓰레기 값을 만들어서 빠르게 회수하라고 null을 넣어줌.
    }

    class myServiceHandler extends Handler {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void handleMessage(android.os.Message msg) {


            notificationManager.notify(tempID+1, notification);
            //notificationManager.notify(0, notification2);
            notificationManager.notify(0, summary);
            tempID++;
            Toast.makeText(MyService.this, "뜸?", Toast.LENGTH_LONG).show();

        }
    }


}
