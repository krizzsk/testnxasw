package com.threatmetrix.TrustDefender;

import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Locale;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class jkkjjj {
    private static final String b006F006F006Fo006Fo = "ThreatMetrixMobileSDK";
    private static final String bo006F006Fo006Fo = yyyyqy.b0074t007400740074t(jkkjjj.class);
    private static String booo006F006Fo = null;

    private jkkjjj() {
    }

    public static String b006800680068h00680068(@Nonnull tqtqqt tqtqqt) {
        return tqttqq.qqtttq.bv0076v00760076v(tqtqqt.bll006C006C006C006C.getContentResolver(), "android_id");
    }

    @Nullable
    public static String b00680068h006800680068(tqtqqt tqtqqt) throws InterruptedException {
        if (!tqttqq.tqtttq.bv0076vvv0076()) {
            yyyyqy.qyyyqy.bt0074tttt(bo006F006Fo006Fo, "SharedPreferences wasn't found, generating GUID");
            return UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
        }
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, b006F006F006Fo006Fo, 0);
        String str = null;
        try {
            str = tqttqq.tqtttq.bvvvvv0076(sharedPreferences, b006F006F006Fo006Fo, (String) null);
            if (!Thread.interrupted()) {
                if (str == null) {
                    yyyyqy.qyyyqy.bt0074tttt(bo006F006Fo006Fo, "Found nothing in shared prefs, generating GUID");
                    str = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
                    SharedPreferences.Editor b00760076v00760076v = tqttqq.tqtttq.b00760076v00760076v(sharedPreferences);
                    if (b00760076v00760076v != null) {
                        tqttqq.tqtttq.bv00760076vv0076(b006F006F006Fo006Fo, str, b00760076v00760076v);
                        b00760076v00760076v.apply();
                    }
                }
                return str;
            }
            throw new InterruptedException();
        } catch (ClassCastException unused) {
            yyyyqy.qyyyqy.bt0074tttt(bo006F006Fo006Fo, "Incompatible type for GUID");
        }
    }

    @Nullable
    public static String b00680068hh00680068(String str, String str2, String str3, tqtqqt tqtqqt) throws InterruptedException {
        return yqqyqq.b0069i00690069i0069(bhhhh00680068(str, str2, str3, tqtqqt));
    }

    private static boolean b0068h0068006800680068(String str) {
        return yqqyqq.b0069ii0069i0069(str) && (str.equalsIgnoreCase("unknown") || str.equals("1234567890ABCDEF"));
    }

    @Nullable
    public static String b0068h0068h00680068(@Nonnull tqtqqt tqtqqt, int i) {
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        if (!new tqttqq.qtqttq(tqtqqt.bll006C006C006C006C).b0076v0076v0076v(Permission.READ_PHONE_STATE, tqtqqt.bll006C006C006C006C.getPackageName())) {
            return "";
        }
        try {
            Object systemService = tqtqqt.bll006C006C006C006C.getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E < tqttqq.ttttqq.tqqqtq.bkk006Bkkk) {
                    String deviceId = tqttqq.ttttqq.qqqqtq.b006E006En006En006E < 26 ? ((TelephonyManager) systemService).getDeviceId() : kkkjjj.b0073ssssss((TelephonyManager) systemService, i);
                    if (deviceId == null || deviceId.contains("00000000000000")) {
                        deviceId = "";
                    }
                    if (deviceId.isEmpty()) {
                        yyyyqy.qyyyqy.bt0074tttt(bo006F006Fo006Fo, "Failed to get useful imei");
                    }
                    String str = bo006F006Fo006Fo;
                    yyyyqy.qyyyqy.bt0074tttt(str, "imei: " + deviceId + " slot" + i);
                    return deviceId;
                }
            }
            return "";
        } catch (SecurityException e) {
            yyyyqy.qyyyqy.b00740074tttt(bo006F006Fo006Fo, "IMEI failed, User refuse granting permission {}", e.toString());
            qqqtqt.by0079yy0079y(Permission.READ_PHONE_STATE);
            return "";
        } catch (Exception e2) {
            yyyyqy.bt0074007400740074t(bo006F006Fo006Fo, e2.toString());
            return "";
        }
    }

    @Nullable
    public static String b0068hh006800680068(tqtqqt tqtqqt) {
        String str = tqttqq.ttttqq.bnn006E006E006En;
        if (!b0068h0068006800680068(str)) {
            return str;
        }
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        if (new tqttqq.qtqttq(tqtqqt.bll006C006C006C006C).b0076v0076v0076v(Permission.READ_PHONE_STATE, tqtqqt.bll006C006C006C006C.getPackageName())) {
            try {
                String bu0075uu00750075 = tqttqq.ttttqq.qqqqtq.b006E006En006En006E < tqttqq.ttttqq.tqqqtq.bkk006Bkkk ? tqttqq.ttttqq.bu0075uu00750075() : null;
                if (yqqyqq.b0069ii0069i0069(bu0075uu00750075)) {
                    return bu0075uu00750075;
                }
                if (yqqyqq.b0069ii0069i0069(str)) {
                    return str;
                }
            } catch (SecurityException e) {
                yyyyqy.qyyyqy.b00740074tttt(bo006F006Fo006Fo, "User refuse granting permission {}", e.toString());
                qqqtqt.by0079yy0079y(Permission.READ_PHONE_STATE);
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(bo006F006Fo006Fo, e2.toString());
            }
        }
        return null;
    }

    @Nullable
    public static String b0068hhh00680068(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() == 32) {
            return str;
        }
        if (str.length() >= 32) {
            return yqqyqq.b0069i00690069i0069(str);
        }
        String b0069i00690069i0069 = yqqyqq.b0069i00690069i0069(str);
        if (b0069i00690069i0069 == null) {
            return null;
        }
        int length = 32 - str.length();
        if (length > b0069i00690069i0069.length()) {
            length = b0069i00690069i0069.length();
        }
        return str + b0069i00690069i0069.substring(0, length);
    }

    public static void bh00680068006800680068(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        tqttqq.tqtttq.b007600760076vv0076(tqtqqt, str, str2, str3);
    }

    public static String bh00680068h00680068(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull String str2) {
        try {
            return tqttqq.tqtttq.b0076vvvv0076(tqtqqt, str, str2, (String) null);
        } catch (ClassCastException e) {
            yyyyqy.b00740074007400740074t(bo006F006Fo006Fo, "Found preference of different type", e);
            return null;
        }
    }

    public static int bh0068h006800680068(@Nonnull tqtqqt tqtqqt, int i) {
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        if (!new tqttqq.qtqttq(tqtqqt.bll006C006C006C006C).b0076v0076v0076v(Permission.READ_PHONE_STATE, tqtqqt.bll006C006C006C006C.getPackageName())) {
            return 0;
        }
        try {
            Object systemService = tqtqqt.bll006C006C006C006C.getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return 0;
            }
            int simState = tqttqq.ttttqq.qqqqtq.b006E006En006En006E < 26 ? ((TelephonyManager) systemService).getSimState() : kkkjjj.bs0073sssss((TelephonyManager) systemService, i);
            String str = bo006F006Fo006Fo;
            yyyyqy.qyyyqy.bt0074tttt(str, "Sim state:" + simState + " , slot" + i);
            return simState;
        } catch (SecurityException e) {
            yyyyqy.qyyyqy.b00740074tttt(bo006F006Fo006Fo, "Sim state failed, User refuse granting permission {}", e.toString());
            qqqtqt.by0079yy0079y(Permission.READ_PHONE_STATE);
            return 0;
        } catch (Exception e2) {
            yyyyqy.bt0074007400740074t(bo006F006Fo006Fo, e2.toString());
            return 0;
        }
    }

    @Nullable
    public static String bh0068hh00680068(String str) {
        if (bhh0068006800680068(str)) {
            return null;
        }
        String str2 = bo006F006Fo006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str2, "using ANDROID_ID for TPC:" + str);
        return b0068hhh00680068(str);
    }

    private static boolean bhh0068006800680068(String str) {
        if (str != null && !str.equals("9774d56d682e549c") && str.length() >= 15) {
            return false;
        }
        String str2 = bo006F006Fo006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str2, "ANDROID_ID contains nothing useful: " + str);
        return true;
    }

    @Nullable
    public static String bhh0068h00680068(@Nonnull tqtqqt tqtqqt) {
        return b0068h0068h00680068(tqtqqt, -1);
    }

    @Nullable
    public static String bhhh006800680068(String str) throws InterruptedException {
        String str2 = bo006F006Fo006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str2, "using generated ID for LSC:" + str);
        return b0068hhh00680068(str);
    }

    @Nonnull
    private static String bhhhh00680068(String str, String str2, String str3, tqtqqt tqtqqt) {
        StringBuilder sb;
        if (yqqyqq.bi0069i0069i0069(booo006F006Fo)) {
            booo006F006Fo = b0068hh006800680068(tqtqqt);
        }
        String str4 = b0068h0068006800680068(booo006F006Fo) ? "" : booo006F006Fo;
        if (yqqyqq.b0069ii0069i0069(str3)) {
            sb = new StringBuilder();
            sb.append(str4);
            sb.append(str3);
        } else if (!bhh0068006800680068(str)) {
            return str4 + str;
        } else if (!yqqyqq.b0069ii0069i0069(str2)) {
            return str4;
        } else {
            sb = new StringBuilder();
            sb.append(str4);
            sb.append(str2);
        }
        return sb.toString();
    }
}
