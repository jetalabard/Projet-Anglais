package com.projectenglish;

import java.util.List;

import android.app.ActivityManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class NotificationService extends IntentService {

	private NotificationManager mNotificationManager;
	private int notificationId;
	public NotificationService() {
		super("NotificationService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
			/*NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setAutoCancel(true)
				.setContentTitle("Chemistry Quiz")
				.setVibrate(new long[] { 100, 100, 100, 100, 100 })
				.setContentText("Chemistry is fun so come play with Chemistry Quiz");

				Intent resultIntent = new Intent(this, SplashScreen.class);
				TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

				stackBuilder.addParentStack(SplashScreen.class);
				stackBuilder.addNextIntent(resultIntent);

				PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
				mBuilder.setContentIntent(resultPendingIntent);

				NotificationManager mNotificationManager =
						(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());*/
			Intent resultIntent = new Intent(this, SplashScreen.class);
			sendNotification(resultIntent);
			MyBroadcastReceiver.completeWakefulIntent(resultIntent);

	}
	private void sendNotification(Intent resultIntent) {

		mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setAutoCancel(true)
				.setContentTitle("Chemistry Quiz")
				.setVibrate(new long[] { 100, 100, 100, 100, 100 })
				.setContentText("Chemistry is fun so come play with Chemistry Quiz");
		Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		mBuilder.setSound(uri);
		mBuilder.setContentIntent(contentIntent);
		mBuilder.setAutoCancel(true);
		mNotificationManager.notify(notificationId++, mBuilder.build());
	}

	


}