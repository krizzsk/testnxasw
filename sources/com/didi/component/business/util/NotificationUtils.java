package com.didi.component.business.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.MainActivityDispatcher;
import com.didi.sdk.app.RouterIntentFilter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import java.util.ArrayList;
import rui.config.RConfigConstants;

public class NotificationUtils {

    /* renamed from: b */
    private static final String f13219b = "channel_normal";

    /* renamed from: c */
    private static final String f13220c = "channel_hangup";

    /* renamed from: d */
    private static NotificationUtils f13221d;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f13222a = LoggerFactory.getLogger(getClass());

    /* renamed from: e */
    private Context f13223e;

    /* renamed from: f */
    private NotificationManager f13224f;

    /* renamed from: g */
    private int f13225g;

    /* renamed from: h */
    private long f13226h = 0;

    /* renamed from: i */
    private int f13227i = 1000;

    public static class NotificationID {
        public static final int DEFAULT_NOTIFICATION_ID = 1001;
        public static final int JP_SUGGEST_PSGR_SWITCH_ORDER_BROADCAST = 1114;
        public static final int ONSERVICE_TOPUP_NOTIFICATION_ID = 1113;
        public static final int RECOMMEND_BOARDING_POINT_PRESENT = 1114;
        public static final int WAIT_4_COMPENSATE_NOTIFICATION_ID = 1112;
    }

    private NotificationUtils(Context context) {
        this.f13223e = context.getApplicationContext();
    }

    public static NotificationUtils getInstance(Context context) {
        if (f13221d == null) {
            m11105a(context);
        }
        return f13221d;
    }

    /* renamed from: a */
    private static synchronized void m11105a(Context context) {
        synchronized (NotificationUtils.class) {
            if (f13221d == null) {
                f13221d = new NotificationUtils(context);
            }
        }
    }

    /* renamed from: b */
    private NotificationManager m11106b(Context context) {
        if (context == null) {
            return null;
        }
        if (this.f13224f == null) {
            try {
                this.f13224f = (NotificationManager) context.getSystemService("notification");
            } catch (Exception e) {
                Logger logger = this.f13222a;
                logger.info("getNotificationManager error:" + e.getMessage(), new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                String string = context.getString(R.string.app_name);
                NotificationChannel notificationChannel = new NotificationChannel(f13219b, string, 2);
                NotificationChannel notificationChannel2 = new NotificationChannel(f13220c, string, 4);
                ArrayList arrayList = new ArrayList();
                arrayList.add(notificationChannel);
                arrayList.add(notificationChannel2);
                this.f13224f.createNotificationChannels(arrayList);
            }
        }
        return this.f13224f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Notification m11103a(String str, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, String str2, boolean z3) {
        int i;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f13223e, str);
        Intent intent = new Intent(this.f13223e, MainActivityDispatcher.class);
        if (str2 != null) {
            intent.putExtra(RouterIntentFilter.ROUTER_URL_KEY, str2);
        }
        if (z3) {
            i = this.f13227i + 1;
            this.f13227i = i;
        } else {
            i = 0;
        }
        GLog.m11354d("NotificationUtils", "in createNotification() requestCode = " + i + " flag = " + 201326592);
        PendingIntent activity = PendingIntent.getActivity(this.f13223e, i, intent, 201326592);
        NotificationCompat.Builder smallIcon = builder.setSmallIcon(m11101a());
        if (this.f13226h == 0 || Build.VERSION.SDK_INT >= 21) {
            this.f13226h = System.currentTimeMillis();
        }
        smallIcon.setWhen(this.f13226h).setCategory("msg").setLocalOnly(true);
        smallIcon.setOngoing(z);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        smallIcon.setAutoCancel(true).setContentIntent(activity).setContentText(charSequence2);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (!TextUtils.isEmpty(charSequence)) {
            bigTextStyle.setBigContentTitle(charSequence);
        }
        bigTextStyle.bigText(charSequence2);
        smallIcon.setStyle(bigTextStyle);
        if (!z && Build.VERSION.SDK_INT >= 21 && f13220c.equals(str)) {
            this.f13222a.info("showNotification setFullScreenIntent", new Object[0]);
            smallIcon.setDefaults(z2 ? 3 : 2).setPriority(1);
        }
        return smallIcon.build();
    }

    /* renamed from: a */
    private int m11101a() {
        if (this.f13225g <= 0) {
            Resources resources = this.f13223e.getResources();
            try {
                this.f13225g = resources.getIdentifier(resources.getString(R.string.notification_small_icon), RConfigConstants.TYPE_DRAWABLE, this.f13223e.getPackageName());
            } catch (Exception unused) {
                this.f13225g = R.drawable.notification_small_icon_didi;
            }
        }
        return this.f13225g;
    }

    public void showNotification(CharSequence charSequence, CharSequence charSequence2) {
        showNotification(charSequence, charSequence2, false);
    }

    public void showNotification(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        showNotification(charSequence, charSequence2, z, false);
    }

    public void showNotification(CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        showNotification(1001, charSequence, charSequence2, z, z2, true, (String) null);
    }

    public void showNotificationNoSound(CharSequence charSequence, CharSequence charSequence2) {
        showNotification(1001, charSequence, charSequence2, false, false, false, (String) null);
    }

    public void showNotification(int i, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, boolean z3, String str) {
        showNotification(i, charSequence, charSequence2, z, z2, z3, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
        r4 = m11106b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showNotification(int r14, java.lang.CharSequence r15, java.lang.CharSequence r16, boolean r17, boolean r18, boolean r19, java.lang.String r20, boolean r21) {
        /*
            r13 = this;
            r11 = r13
            com.didi.sdk.logging.Logger r0 = r11.f13222a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "showNotification isNormal="
            r1.append(r2)
            r3 = r17
            r1.append(r3)
            java.lang.String r2 = ": isShowInActive:"
            r1.append(r2)
            r2 = r18
            r1.append(r2)
            java.lang.String r4 = " isSound:"
            r1.append(r4)
            r8 = r19
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r0.info((java.lang.String) r1, (java.lang.Object[]) r4)
            android.content.Context r0 = r11.f13223e
            if (r0 != 0) goto L_0x0035
            return
        L_0x0035:
            android.app.NotificationManager r4 = r13.m11106b(r0)
            if (r4 != 0) goto L_0x003c
            return
        L_0x003c:
            com.didi.component.business.util.NotificationUtils$1 r12 = new com.didi.component.business.util.NotificationUtils$1
            r0 = r12
            r1 = r13
            r2 = r18
            r3 = r17
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r19
            r9 = r20
            r10 = r21
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.didi.sdk.apm.utils.ApmThreadPool.executeOnSingle(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.util.NotificationUtils.showNotification(int, java.lang.CharSequence, java.lang.CharSequence, boolean, boolean, boolean, java.lang.String, boolean):void");
    }

    public void hideNotification(int i) {
        NotificationManager b = m11106b(this.f13223e);
        if (b != null) {
            if (i <= 0) {
                i = 1001;
            }
            try {
                b.cancel(i);
            } catch (Exception e) {
                Logger logger = this.f13222a;
                logger.info("hideNotification exception:" + e.toString(), new Object[0]);
            }
        }
    }

    public void hideNotification() {
        hideNotification(1001);
    }

    public static boolean isNotificationEnabled(Context context) {
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            return from.areNotificationsEnabled();
        }
        return false;
    }
}
