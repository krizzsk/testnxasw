package com.threatmetrix.TrustDefender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.threatmetrix.TrustDefender.kkjkjk;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yqyqqy;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qyqqqy {
    private static final String b006500650065e0065e = yyyyqy.b0074t007400740074t(qyqqqy.class);

    private qyqqqy() {
    }

    @Nullable
    private static String b0078007800780078xx(@Nonnull Context context, @Nullable String str) {
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        tqttqq.qtqttq qtqttq = new tqttqq.qtqttq(context);
        if (tqttqq.qqqttq.bvvvv0076v() && qtqttq.b0076v0076v0076v("android.permission.ACCESS_WIFI_STATE", context.getPackageName())) {
            try {
                WifiManager bxxxx0078x = bxxxx0078x(context);
                if (bxxxx0078x == null) {
                    return null;
                }
                List<ScanResult> scanResults = bxxxx0078x.getScanResults();
                StringBuilder sb = new StringBuilder(scanResults.size() * 30);
                boolean z = true;
                for (ScanResult next : scanResults) {
                    String b0078x00780078xx = b0078x00780078xx(next.BSSID);
                    if (b0078x00780078xx != null && !b0078x00780078xx.equals(str)) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(":");
                        }
                        sb.append(b0078x00780078xx.replace(":", ""));
                        sb.append(";");
                        sb.append(next.level);
                    }
                }
                return sb.toString();
            } catch (SecurityException unused) {
                qqqtqt.b00790079yy0079y("android.permission.ACCESS_WIFI_STATE", b006500650065e0065e);
            } catch (Exception e) {
                yyyyqy.bt0074007400740074t(b006500650065e0065e, e.toString());
            }
        }
        return null;
    }

    public static void b007800780078xxx(@Nonnull Context context) {
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        tqttqq.qtqttq qtqttq = new tqttqq.qtqttq(context);
        if (tqttqq.qqqttq.b0076007600760076vv() && qtqttq.b0076v0076v0076v("android.permission.CHANGE_WIFI_STATE", context.getPackageName())) {
            try {
                WifiManager bxxxx0078x = bxxxx0078x(context);
                if (bxxxx0078x != null) {
                    bxxxx0078x.startScan();
                }
            } catch (SecurityException unused) {
                qqqtqt.b00790079yy0079y("android.permission.CHANGE_WIFI_STATE", b006500650065e0065e);
            } catch (Exception e) {
                yyyyqy.bt0074007400740074t(b006500650065e0065e, e.toString());
            }
        }
    }

    @Nullable
    private static String b00780078x0078xx(int i) {
        yqyqqy.yyqqqy yyqqqy;
        if (i == -99) {
            return null;
        }
        if (i == 4) {
            yyqqqy = yqyqqy.yyqqqy.MOBILE_DUN;
        } else if (i == 7) {
            yyqqqy = yqyqqy.yyqqqy.BLUETOOTH;
        } else if (i == 9) {
            yyqqqy = yqyqqy.yyqqqy.ETHERNET;
        } else if (i == 0) {
            yyqqqy = yqyqqy.yyqqqy.CELLULAR;
        } else if (i == 1) {
            yyqqqy = yqyqqy.yyqqqy.WIFI;
        } else if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E < tqttqq.ttttqq.tqqqtq.bn006En006E006E006E || !yqyqyy.b00710071q007100710071(i)) {
            Field[] b0073sss007300730073 = kkjkjk.b0073sss007300730073(kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CONNECTIVITY_MANAGER));
            if (b0073sss007300730073 == null) {
                return null;
            }
            for (Field field : b0073sss007300730073) {
                if (field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers())) {
                    try {
                        if (field.getInt((Object) null) == i) {
                            String name = field.getName();
                            if (yqqyqq.b0069ii0069i0069(name) && name.startsWith("TYPE_")) {
                                return bx00780078xxx(name);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable unused) {
                        continue;
                    }
                }
            }
            return null;
        } else {
            yyqqqy = yqyqqy.yyqqqy.VPN;
        }
        return yyqqqy.getValue();
    }

    @Nullable
    public static String b0078x00780078xx(@Nullable String str) {
        if (str == null || str.length() < 17 || "00:00:00:00:00:00".equals(str) || "02:00:00:00:00:00".equals(str)) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    @Nullable
    public static String[] b0078xx0078xx(@Nonnull Context context) {
        Intent intent;
        if (!tqttqq.qqqttq.b0076v00760076vv()) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        String[] strArr = new String[5];
        WifiInfo wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
        if (wifiInfo != null) {
            String b0078x00780078xx = b0078x00780078xx(wifiInfo.getBSSID());
            String bx007800780078xx = bx007800780078xx(wifiInfo.getSSID());
            int rssi = wifiInfo.getRssi();
            if (b0078x00780078xx != null) {
                strArr[0] = b0078x00780078xx;
            }
            if (bx007800780078xx != null) {
                strArr[1] = bx007800780078xx;
            }
            strArr[2] = String.valueOf(rssi);
            strArr[3] = yqyqqy.yyqqqy.WIFI.getValue();
            if (strArr[0] == null || strArr[1] == null || strArr[2] != null) {
                return strArr;
            }
        } else {
            Bundle extras = intent.getExtras();
            NetworkInfo networkInfo = (NetworkInfo) extras.get("networkInfo");
            if (networkInfo == null) {
                return null;
            }
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                String bx007800780078xx2 = bx007800780078xx(networkInfo.getExtraInfo());
                String b0078x00780078xx2 = b0078x00780078xx((String) extras.get("bssid"));
                if (b0078x00780078xx2 != null) {
                    strArr[0] = b0078x00780078xx2;
                }
                if (bx007800780078xx2 != null) {
                    strArr[1] = bx007800780078xx2;
                }
                strArr[3] = yqyqqy.yyqqqy.WIFI.getValue();
            }
        }
        return strArr;
    }

    @Nullable
    public static String bx007800780078xx(@Nullable String str) {
        if (str != null && !str.contains("unknown ssid") && str.length() >= 1) {
            if (str.charAt(0) == '\"') {
                str = str.substring(1);
            }
            if (str.length() >= 1 && str.charAt(str.length() - 1) == '\"') {
                str = str.substring(0, str.length() - 1);
            }
            if (!str.isEmpty()) {
                return str;
            }
        }
        return null;
    }

    @Nullable
    public static String bx00780078xxx(String str) {
        if (yqqyqq.bi0069i0069i0069(str)) {
            return null;
        }
        String trim = str.trim();
        if (yqqyqq.bi0069i0069i0069(trim)) {
            return null;
        }
        String lowerCase = trim.toLowerCase(Locale.US);
        if (lowerCase.startsWith("type")) {
            lowerCase = lowerCase.replaceFirst("type", "");
        }
        return lowerCase.replace("_", " ").trim();
    }

    @Nonnull
    public static yqyqqy bx0078x0078xx(@Nonnull Context context) throws InterruptedException {
        int dataState;
        yqyqqy yqyqqy = new yqyqqy();
        boolean z = false;
        if (!yqyqqy.bxx0078xxx(qqqyqy.bg00670067g0067g().bg0067g00670067g()) && !yqyqqy.bxx0078xxx(bxx00780078xx(context))) {
            if (!yqyqqy.bxx0078xxx(b0078xx0078xx(context))) {
                yqyqqy.bxx0078xxx(bxxx0078xx(context));
                z = true;
            }
            if (yqyqqy.b0067g0067006700670067() == null && tqttqq.qqqqqt.b0076v0076v00760076()) {
                try {
                    Object systemService = context.getSystemService("phone");
                    if ((systemService instanceof TelephonyManager) && ((dataState = ((TelephonyManager) systemService).getDataState()) == 2 || dataState == 1 || dataState == 3)) {
                        yqyqqy.b00780078xxxx(yqyqqy.yyqqqy.CELLULAR.getValue());
                    }
                } catch (SecurityException unused) {
                    qqqtqt.b00790079yy0079y("phone", b006500650065e0065e);
                } catch (Exception e) {
                    yyyyqy.bt0074007400740074t(b006500650065e0065e, e.toString());
                } catch (Throwable th) {
                    yqyqqy.b0078xxxxx();
                    throw th;
                }
                yqyqqy.b0078xxxxx();
            }
        }
        if (yqyqqy.bg00670067006700670067() == null && yyqyyy.b0071qq007100710071(context)) {
            yqyqqy.b0078x0078xxx("true");
        }
        if (!z && yqyqqy.bg00670067006700670067() == null) {
            yqyqqy.bxx0078xxx(bxxx0078xx(context));
        }
        yqyqqy.bx0078xxxx(b0078007800780078xx(context, yqyqqy.bg00670067g00670067()));
        String str = b006500650065e0065e;
        yyyyqy.qyyyqy.bt0074tttt(str, "Network Info (Final values) BSSID: " + yqyqqy.bg00670067g00670067() + " SSID: " + yqyqqy.bgg0067006700670067() + " RSSI: " + yqyqqy.bg0067g006700670067() + " Type: " + yqyqqy.b0067g0067006700670067());
        return yqyqqy;
    }

    @Nullable
    public static String[] bxx00780078xx(@Nonnull Context context) {
        String bx007800780078xx;
        if (!tqttqq.qqqttq.bv007600760076vv()) {
            return null;
        }
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        if (new tqttqq.qtqttq(context).b0076v0076v0076v("android.permission.ACCESS_WIFI_STATE", context.getPackageName())) {
            try {
                WifiManager bxxxx0078x = bxxxx0078x(context);
                if (bxxxx0078x == null) {
                    return null;
                }
                WifiInfo connectionInfo = bxxxx0078x.getConnectionInfo();
                String b0078x00780078xx = b0078x00780078xx(connectionInfo.getBSSID());
                if (b0078x00780078xx == null || (bx007800780078xx = bx007800780078xx(connectionInfo.getSSID())) == null) {
                    return null;
                }
                int rssi = connectionInfo.getRssi();
                String[] strArr = new String[5];
                strArr[0] = b0078x00780078xx;
                strArr[1] = bx007800780078xx;
                strArr[2] = String.valueOf(rssi);
                strArr[3] = yqyqqy.yyqqqy.WIFI.getValue();
                return strArr;
            } catch (SecurityException unused) {
                qqqtqt.b00790079yy0079y("android.permission.ACCESS_WIFI_STATE", b006500650065e0065e);
            } catch (Exception e) {
                yyyyqy.bt0074007400740074t(b006500650065e0065e, e.toString());
            }
        }
        return null;
    }

    @Nullable
    public static String[] bxxx0078xx(@Nonnull Context context) {
        Intent intent;
        String str = null;
        if (!tqttqq.qqqttq.bvv00760076vv()) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        String[] strArr = new String[5];
        int intExtra = intent.getIntExtra("networkType", -99);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        NetworkInfo networkInfo = (NetworkInfo) extras.get("networkInfo");
        if (networkInfo != null) {
            if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return null;
            }
            if (intExtra == -99) {
                try {
                    intExtra = networkInfo.getType();
                } catch (SecurityException e2) {
                    qqqtqt.b0079yyy0079y(e2, b006500650065e0065e);
                    return null;
                } catch (Exception e3) {
                    yyyyqy.bt0074007400740074t(b006500650065e0065e, e3.toString());
                    return null;
                }
            }
        }
        strArr[3] = b00780078x0078xx(intExtra);
        if (strArr[3] == null) {
            return null;
        }
        if (strArr[3].equals(yqyqqy.yyqqqy.WIFI.getValue())) {
            if (networkInfo != null) {
                str = bx007800780078xx(networkInfo.getExtraInfo());
            }
            String b0078x00780078xx = b0078x00780078xx((String) extras.get("bssid"));
            if (b0078x00780078xx != null) {
                strArr[0] = b0078x00780078xx;
            }
            if (str != null) {
                strArr[1] = str;
            }
        } else if (strArr[3].equals(yqyqqy.yyqqqy.VPN.getValue())) {
            strArr[4] = "true";
        }
        return strArr;
    }

    @Nullable
    private static WifiManager bxxxx0078x(@Nonnull Context context) {
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        if (!(systemService instanceof WifiManager)) {
            return null;
        }
        return (WifiManager) systemService;
    }
}
