package com.didi.map.sdk.navtracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class TrackerPreference {

    /* renamed from: a */
    private static SharedPreferences f31016a = null;

    /* renamed from: b */
    private static final String f31017b = "MapTrackerPreference";

    /* renamed from: c */
    private static final String f31018c = "key_track_list_map";

    /* renamed from: d */
    private static final String f31019d = "key_track_list_nav";

    /* renamed from: e */
    private static final String f31020e = "key_track_user_info_country_code";

    /* renamed from: f */
    private static final String f31021f = "key_track_user_info_phone_num";

    /* renamed from: g */
    private static final String f31022g = "key_track_user_info_app_version";

    /* renamed from: h */
    private static final String f31023h = "key_track_user_info_user_id";

    public static String getMapTrackList(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31018c, "");
        }
        return "";
    }

    public static void setMapTrackList(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31018c, str).apply();
        }
    }

    public static String getNavTrackList(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31019d, "");
        }
        return "";
    }

    public static void setNavTrackList(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31019d, str).apply();
        }
    }

    public static String getCountryCode(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31020e, "");
        }
        return "";
    }

    public static void setCountryCode(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31020e, str).apply();
        }
    }

    public static String getPhoneNum(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31021f, "");
        }
        return "";
    }

    public static void setPhoneNum(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31021f, str).apply();
        }
    }

    public static String getAppVersion(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31022g, "");
        }
        return "";
    }

    public static void setAppVersion(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31022g, str).apply();
        }
    }

    public static String getUserId(Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f31023h, "");
        }
        return "";
    }

    public static void setUserId(String str, Context context) {
        if (f31016a == null) {
            f31016a = SystemUtils.getSharedPreferences(context, f31017b, 0);
        }
        SharedPreferences sharedPreferences = f31016a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f31023h, str).apply();
        }
    }
}
