package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class HeartbeatInfoCollector {

    /* renamed from: a */
    private static final String f50724a = "HeartbeatInfoCollector";

    /* renamed from: b */
    private static Context f50725b;

    /* renamed from: c */
    private static LocationManager f50726c;

    /* renamed from: d */
    private static ConnectivityManager f50727d;

    /* renamed from: e */
    private static NetworkInfo f50728e;

    /* renamed from: f */
    private static TelephonyManager f50729f;

    public static void init(Context context) {
        f50725b = context;
        try {
            f50726c = (LocationManager) context.getSystemService("location");
            ConnectivityManager connectivityManager = (ConnectivityManager) f50725b.getSystemService("connectivity");
            f50727d = connectivityManager;
            if (connectivityManager != null) {
                f50728e = SystemUtils.getActiveNetworkInfo(connectivityManager);
            }
            f50729f = (TelephonyManager) f50725b.getSystemService("phone");
        } catch (Throwable th) {
            SystemUtils.log(6, f50724a, "init err:" + th.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 41);
        }
    }

    public static int getNetworkType() {
        try {
            if (f50728e == null || !f50728e.isConnected()) {
                return -1;
            }
            int type = f50728e.getType();
            int subtype = f50728e.getSubtype();
            if (1 == type) {
                return 1;
            }
            if (type == 0) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            OLog.m37868w("getNetworkType fail,", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[Catch:{ all -> 0x005b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[Catch:{ all -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCarrier() {
        /*
            android.telephony.TelephonyManager r0 = f50729f
            r1 = -1
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = r0.getNetworkOperatorName()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "google_sdk"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x005b }
            r3 = 1
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "sdk"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "sdk_x86"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "generic"
            boolean r2 = r2.startsWith(r4)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = 0
            goto L_0x0038
        L_0x0037:
            r2 = 1
        L_0x0038:
            if (r2 == 0) goto L_0x003b
            return r1
        L_0x003b:
            java.lang.String r2 = "中国移动"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0045
            return r3
        L_0x0045:
            java.lang.String r2 = "中国电信"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0050
            r0 = 2
            return r0
        L_0x0050:
            java.lang.String r2 = "中国联通"
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x006b
            r0 = 3
            return r0
        L_0x005b:
            r0 = move-exception
            java.lang.String r4 = r0.toString()
            r2 = 6
            r5 = 0
            r7 = 158(0x9e, float:2.21E-43)
            java.lang.String r3 = "HeartbeatInfoCollector"
            java.lang.String r6 = "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector.getCarrier():int");
    }

    public static GSMCellLocationInfo getGSMCellLocationInfo() {
        int i;
        int i2;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) f50729f.getCellLocation();
                if (gsmCellLocation != null) {
                    i2 = gsmCellLocation.getLac();
                    try {
                        i = gsmCellLocation.getCid();
                        i3 = i2;
                    } catch (Exception e) {
                        e = e;
                        SystemUtils.log(6, f50724a, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 185);
                        i3 = i2;
                        i = 0;
                        return new GSMCellLocationInfo(i3, i);
                    }
                    return new GSMCellLocationInfo(i3, i);
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                SystemUtils.log(6, f50724a, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 185);
                i3 = i2;
                i = 0;
                return new GSMCellLocationInfo(i3, i);
            }
        }
        i = 0;
        return new GSMCellLocationInfo(i3, i);
    }

    public static String getPackageName() {
        return f50725b.getPackageName();
    }

    public static class GSMCellLocationInfo {
        private int cellid;
        private int lac;

        private GSMCellLocationInfo(int i, int i2) {
            this.lac = i;
            this.cellid = i2;
        }

        public int getLac() {
            return this.lac;
        }

        public int getCellid() {
            return this.cellid;
        }
    }
}
