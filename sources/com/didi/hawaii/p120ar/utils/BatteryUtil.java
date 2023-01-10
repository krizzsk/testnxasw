package com.didi.hawaii.p120ar.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;

/* renamed from: com.didi.hawaii.ar.utils.BatteryUtil */
public class BatteryUtil {

    /* renamed from: a */
    private static Context f25559a = null;

    /* renamed from: b */
    private static BatteryStateReceiver f25560b = new BatteryStateReceiver();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static BatteryChangeListener f25561c = null;
    public static float curBatteryPcn = 100.0f;

    /* renamed from: d */
    private static boolean f25562d = false;

    /* renamed from: com.didi.hawaii.ar.utils.BatteryUtil$BatteryChangeListener */
    public interface BatteryChangeListener {
        void onBatteryChange(float f);
    }

    public static void init(Context context) {
        if (f25559a == null && context != null) {
            f25559a = context.getApplicationContext();
            m20381b();
        }
    }

    /* renamed from: com.didi.hawaii.ar.utils.BatteryUtil$BatteryStateReceiver */
    static class BatteryStateReceiver extends BroadcastReceiver {
        BatteryStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            BatteryUtil.m20382b(intent);
            if (BatteryUtil.f25561c != null) {
                BatteryUtil.f25561c.onBatteryChange(BatteryUtil.curBatteryPcn);
            }
        }
    }

    public static float getCurBatteryPcn(Context context) {
        if (context == null) {
            return -1.0f;
        }
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (intent == null) {
            return -1.0f;
        }
        return (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1))) * 100.0f;
    }

    public static boolean isCharging(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (intent == null || intent.getIntExtra("plugged", -1) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static void m20381b() {
        if (f25559a != null) {
            Intent intent = null;
            try {
                intent = f25559a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            m20382b(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20382b(Intent intent) {
        if (intent != null) {
            curBatteryPcn = (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1))) * 100.0f;
        }
    }

    public static void startListenBatteryState(BatteryChangeListener batteryChangeListener) {
        if (f25559a != null) {
            try {
                f25559a.registerReceiver(f25560b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            f25561c = batteryChangeListener;
            f25562d = true;
        }
    }

    public static void stopListenBatteryState() {
        Context context = f25559a;
        if (context != null && f25562d) {
            try {
                context.unregisterReceiver(f25560b);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            f25562d = false;
            f25561c = null;
        }
    }
}
