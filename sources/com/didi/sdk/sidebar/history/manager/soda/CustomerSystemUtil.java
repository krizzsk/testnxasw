package com.didi.sdk.sidebar.history.manager.soda;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public final class CustomerSystemUtil {
    public static String getMacAddr() {
        return "";
    }

    public static String getMapType() {
        return "gmap";
    }

    private CustomerSystemUtil() {
    }

    public static void doCall(Context context, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("tel:")) {
                uri = Uri.parse(str);
            } else {
                uri = Uri.parse("tel:" + str);
            }
            Intent intent = new Intent("android.intent.action.DIAL", uri);
            intent.setFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void sendMessage(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void playNotificationRingtone(Context context) {
        RingtoneManager.getRingtone(context, RingtoneManager.getDefaultUri(2)).play();
    }

    public static void openLocationSettingActivity(Context context) {
        try {
            context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static boolean isGpsEnabled(Context context) {
        if (context == null) {
            return false;
        }
        String string = Settings.System.getString(context.getContentResolver(), "location_providers_allowed");
        if (TextUtils.isEmpty(string) || !string.contains("gps")) {
            return false;
        }
        return true;
    }

    public static String getDeviceBrand() {
        String str = Build.BRAND;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getImmersiveStatusBarHeight(Context context) {
        int identifier;
        if (Build.VERSION.SDK_INT >= 21 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getAllInstallAppNames(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PackageManager packageManager = context.getPackageManager();
            int i = 0;
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                int size = queryIntentActivities.size();
                for (ResolveInfo loadLabel : queryIntentActivities) {
                    sb.append(loadLabel.loadLabel(packageManager));
                    if (i != size - 1) {
                        sb.append(",");
                    }
                    i++;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return sb.toString();
        }
    }

    public static String int2ip(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static String getLocalIpAddress(Context context) {
        if (context == null || !checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            return int2ip(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getLocationType() {
        int access$000 = LocType.UNKNOW.mValue;
        DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
        if (lastLocation == null) {
            return access$000;
        }
        String provider = lastLocation.getProvider();
        if ("gps".equals(provider)) {
            return LocType.GPS.mValue;
        }
        if (DIDILocation.WIFI_PROVIDER.equals(provider)) {
            return LocType.WIFI.mValue;
        }
        if (DIDILocation.CELL_PROVIDER.equals(provider)) {
            return LocType.CELL.mValue;
        }
        return LocType.UNKNOW.mValue;
    }

    public static boolean checkPermission(Context context, String str) {
        return checkPermission(context, str, false);
    }

    public static boolean checkPermission(Context context, String str, boolean z) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception unused) {
            return z;
        }
    }

    public static String getKernelVersion() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            String str = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    bufferedReader.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            fileInputStream.close();
            try {
                if (!"".equals(str)) {
                    return "";
                }
                String substring = str.substring(str.indexOf("version ") + 8);
                return substring.substring(0, substring.indexOf(" "));
            } catch (IndexOutOfBoundsException e4) {
                e4.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String getSsId(Context context) {
        if (context == null || !checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getPhoneNum(Context context) {
        if (context == null || !checkPermission(context, Permission.READ_PHONE_STATE)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getLine1Number();
    }

    public static String getCompleteVersionName(Context context) {
        if (context == null) {
            return "";
        }
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED + SystemUtil.getVersionName(context) + "_" + SystemUtil.getVersionCode();
    }

    public static String getDeviceId() {
        return SecurityUtil.getDeviceId();
    }

    public static int getTimeZoneUtcOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone == null) {
            return -1;
        }
        int rawOffset = timeZone.getRawOffset() / 60000;
        return timeZone.inDaylightTime(new Date()) ? rawOffset + 60 : rawOffset;
    }

    enum LocType {
        UNKNOW(-1, "unknown"),
        GPS(1, "gps"),
        WIFI(2, "wifi"),
        CELL(3, "cell");
        
        private String mName;
        /* access modifiers changed from: private */
        public int mValue;

        private LocType(int i, String str) {
            this.mValue = i;
            this.mName = str;
        }

        public int getId() {
            return this.mValue;
        }

        public String getName() {
            return this.mName;
        }
    }
}
