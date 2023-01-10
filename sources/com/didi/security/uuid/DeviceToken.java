package com.didi.security.uuid;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class DeviceToken {

    /* renamed from: a */
    private static final String f41237a = "device_token";

    /* renamed from: b */
    private static final String f41238b = "createTime";

    /* renamed from: c */
    private static final String f41239c = "expireTime";

    /* renamed from: d */
    private static final String f41240d = "data";

    /* renamed from: e */
    private long f41241e;

    /* renamed from: f */
    private long f41242f;

    /* renamed from: g */
    private String f41243g;

    private DeviceToken() {
    }

    public long getExpireTime() {
        return this.f41242f;
    }

    public long getCreateTime() {
        return this.f41241e;
    }

    public static DeviceToken create(long j, long j2, String str) {
        DeviceToken deviceToken = new DeviceToken();
        deviceToken.f41241e = j;
        deviceToken.f41242f = j2;
        deviceToken.f41243g = str;
        return deviceToken;
    }

    public static DeviceToken create(long j, String str) {
        return create(System.currentTimeMillis(), j, str);
    }

    public boolean isValid() {
        return this.f41243g != null && System.currentTimeMillis() < this.f41242f;
    }

    public static DeviceToken load(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = SystemUtils.getSharedPreferences(context, "device_token", 0)) == null) {
            return null;
        }
        long j = sharedPreferences.getLong(f41238b, 0);
        long j2 = sharedPreferences.getLong(f41239c, 0);
        String string = sharedPreferences.getString("data", (String) null);
        if (string == null) {
            return null;
        }
        DeviceToken deviceToken = new DeviceToken();
        deviceToken.f41241e = j;
        deviceToken.f41242f = j2;
        deviceToken.f41243g = string;
        return deviceToken;
    }

    public void save(Context context) {
        SharedPreferences.Editor edit;
        if (context != null && (edit = SystemUtils.getSharedPreferences(context, "device_token", 0).edit()) != null && this.f41243g != null) {
            edit.putLong(f41238b, this.f41241e);
            edit.putLong(f41239c, this.f41242f);
            edit.putString("data", this.f41243g);
            edit.commit();
        }
    }

    public String toString() {
        return this.f41243g;
    }
}
