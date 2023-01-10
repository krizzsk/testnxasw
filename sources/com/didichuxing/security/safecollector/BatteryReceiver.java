package com.didichuxing.security.safecollector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;

public class BatteryReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static BatteryReceiver f51549a = null;

    /* renamed from: b */
    private static String f51550b = "";

    public static Intent init(Context context) {
        try {
            f51549a = new BatteryReceiver();
            return context.registerReceiver(f51549a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getBatteryPercent() {
        return f51550b;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("level", 0);
                int intExtra2 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
                if (intExtra2 > 0) {
                    f51550b = String.valueOf((intExtra * 100) / intExtra2);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
