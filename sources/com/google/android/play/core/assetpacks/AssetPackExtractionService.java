package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.service.ForegroundService;
import com.google.android.play.core.internal.C20030ag;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    Context f55628a;

    /* renamed from: b */
    C19999j f55629b;

    /* renamed from: c */
    C19917bb f55630c;

    /* renamed from: d */
    private final C20030ag f55631d = new C20030ag("AssetPackExtractionService");

    /* renamed from: e */
    private C19915b f55632e;

    /* renamed from: f */
    private NotificationManager f55633f;

    /* renamed from: b */
    private final synchronized void m41796b(Bundle bundle) {
        String string = bundle.getString(ForegroundService.ARG_NOTIFICATION_TITLE);
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f55628a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.f55628a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f55631d.mo164270c("Starting foreground service.", new Object[0]);
        this.f55629b.mo164241a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f55633f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    /* renamed from: a */
    public final synchronized Bundle mo164031a(Bundle bundle) {
        int i = bundle.getInt("action_type");
        C20030ag agVar = this.f55631d;
        Integer valueOf = Integer.valueOf(i);
        agVar.mo164267a("updateServiceState: %d", valueOf);
        if (i == 1) {
            m41796b(bundle);
        } else if (i == 2) {
            mo164032a();
        } else {
            this.f55631d.mo164269b("Unknown action type received: %d", valueOf);
        }
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo164032a() {
        this.f55631d.mo164270c("Stopping service.", new Object[0]);
        this.f55629b.mo164241a(false);
        stopForeground(true);
        stopSelf();
    }

    public final IBinder onBind(Intent intent) {
        return this.f55632e;
    }

    public final void onCreate() {
        super.onCreate();
        this.f55631d.mo164267a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        C19971db.m42011a(getApplicationContext()).mo164060a(this);
        this.f55632e = new C19915b(this.f55628a, this, this.f55630c);
        this.f55633f = (NotificationManager) this.f55628a.getSystemService("notification");
    }
}
