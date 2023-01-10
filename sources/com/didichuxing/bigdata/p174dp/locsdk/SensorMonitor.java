package com.didichuxing.bigdata.p174dp.locsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.util.Log;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.SensorMonitor */
public class SensorMonitor {

    /* renamed from: c */
    private static volatile SensorMonitor f48378c = null;

    /* renamed from: p */
    private static final long f48379p = 20000;

    /* renamed from: a */
    BroadcastReceiver f48380a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
                if (supplicantState == null || !supplicantState.equals(SupplicantState.COMPLETED)) {
                    boolean unused = SensorMonitor.this.f48387i = false;
                } else {
                    boolean unused2 = SensorMonitor.this.f48387i = true;
                }
            }
        }
    };

    /* renamed from: b */
    SensorEventListener f48381b = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            if (sensorEvent.sensor.getType() == 5) {
                long unused = SensorMonitor.this.f48390l = currentTimeMillis;
                float unused2 = SensorMonitor.this.f48388j = sensorEvent.values[0];
            }
            if (sensorEvent.sensor.getType() == 6) {
                long unused3 = SensorMonitor.this.f48391m = currentTimeMillis;
                float unused4 = SensorMonitor.this.f48389k = sensorEvent.values[0];
            }
        }
    };

    /* renamed from: d */
    private Context f48382d;

    /* renamed from: e */
    private WifiManager f48383e;

    /* renamed from: f */
    private SensorManager f48384f;

    /* renamed from: g */
    private Sensor f48385g;

    /* renamed from: h */
    private Sensor f48386h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f48387i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f48388j = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f48389k = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f48390l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f48391m = 0;

    /* renamed from: n */
    private long f48392n = 0;

    /* renamed from: o */
    private long f48393o = 0;

    private SensorMonitor(Context context) {
        this.f48382d = context;
        this.f48383e = (WifiManager) context.getSystemService("wifi");
    }

    public static SensorMonitor getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (f48378c == null) {
            synchronized (SensorMonitor.class) {
                if (f48378c == null) {
                    f48378c = new SensorMonitor(context);
                }
            }
        }
        return f48378c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:(4:3|4|5|6)|11|13|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f48382d
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x001f }
            r0.<init>()     // Catch:{ Exception -> 0x001f }
            java.lang.String r1 = "android.net.wifi.supplicant.STATE_CHANGE"
            r0.addAction(r1)     // Catch:{ Exception -> 0x001f }
            android.content.Context r1 = r4.f48382d     // Catch:{ Exception -> 0x001f }
            android.content.BroadcastReceiver r2 = r4.f48380a     // Catch:{ Exception -> 0x001f }
            r1.registerReceiver(r2, r0)     // Catch:{ Exception -> 0x0017 }
            goto L_0x001f
        L_0x0017:
            r0 = move-exception
            java.lang.String r1 = "Context"
            java.lang.String r2 = "registerReceiver"
            android.util.Log.d(r1, r2, r0)     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            android.content.Context r0 = r4.f48382d
            java.lang.String r1 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0
            r4.f48384f = r0
            r1 = 5
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)
            r4.f48385g = r0
            android.hardware.SensorManager r0 = r4.f48384f
            r1 = 6
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)
            r4.f48386h = r0
            r0 = 3
            android.hardware.SensorManager r1 = r4.f48384f     // Catch:{ Exception -> 0x0045 }
            android.hardware.SensorEventListener r2 = r4.f48381b     // Catch:{ Exception -> 0x0045 }
            android.hardware.Sensor r3 = r4.f48385g     // Catch:{ Exception -> 0x0045 }
            r1.registerListener(r2, r3, r0)     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            android.hardware.SensorManager r1 = r4.f48384f     // Catch:{ Exception -> 0x004e }
            android.hardware.SensorEventListener r2 = r4.f48381b     // Catch:{ Exception -> 0x004e }
            android.hardware.Sensor r3 = r4.f48386h     // Catch:{ Exception -> 0x004e }
            r1.registerListener(r2, r3, r0)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor.start():void");
    }

    public void stop() {
        if (this.f48382d != null) {
            this.f48384f.unregisterListener(this.f48381b);
            try {
                try {
                    this.f48382d.unregisterReceiver(this.f48380a);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean isWifiEnabled() {
        WifiManager wifiManager = this.f48383e;
        if (wifiManager == null) {
            return false;
        }
        try {
            return wifiManager.isWifiEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isWifiAllowScan() {
        if (this.f48383e == null || Utils.getSdk() <= 17) {
            return false;
        }
        try {
            return String.valueOf(Reflect.invokeMethod(this.f48383e, "isScanAlwaysAvailable", new Object[0])).equals("true");
        } catch (Exception e) {
            OmegaUtils.trackReflectError(e, "isWifiAllowScan");
            return false;
        }
    }

    public boolean isGpsEnabled() {
        LocationManager locationManager = (LocationManager) this.f48382d.getSystemService("location");
        if (locationManager == null) {
            return true;
        }
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Throwable th) {
            DLog.m36225d(th.toString());
            return true;
        }
    }

    public boolean isWifiConnected() {
        return this.f48387i;
    }

    public int getAirPressure() {
        if (System.currentTimeMillis() - this.f48391m > 20000) {
            return 0;
        }
        return (int) (this.f48389k * 100.0f);
    }

    public int getLight() {
        if (System.currentTimeMillis() - this.f48390l > 20000) {
            return 0;
        }
        return (int) this.f48388j;
    }

    public void setGpsFixedTimestamp(long j) {
        long j2 = this.f48392n;
        if (j2 != 0) {
            this.f48393o = j - j2;
        }
        this.f48392n = j;
    }

    public int getGpsFixedInterval() {
        if (System.currentTimeMillis() - this.f48392n > 20000) {
            return 0;
        }
        return (int) this.f48393o;
    }
}
