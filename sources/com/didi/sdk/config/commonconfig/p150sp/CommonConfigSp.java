package com.didi.sdk.config.commonconfig.p150sp;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.sdk.config.commonconfig.sp.CommonConfigSp */
public class CommonConfigSp {
    public static final String KEY_COMMON_LASTEMAIL = "key_common_lastemail";
    public static final String KEY_COMMON_LASTTITLE = "key_common_lasttitle";
    public static final String KEY_FIREBASE_APP_ID = "key_firebase_app_id";

    /* renamed from: a */
    private static final String f38469a = "commoncfg-debug";

    /* renamed from: c */
    private static final String f38470c = "common_config_store";

    /* renamed from: f */
    private static CommonConfigSp f38471f;

    /* renamed from: b */
    private Logger f38472b = LoggerFactory.getLogger("CommonConfigSp");

    /* renamed from: d */
    private Context f38473d;

    /* renamed from: e */
    private SharedPreferences f38474e;

    private CommonConfigSp() {
    }

    public void init(Context context) {
        this.f38473d = context;
        this.f38474e = SystemUtils.getSharedPreferences(context, f38470c, 0);
    }

    public static CommonConfigSp getInstance() {
        if (f38471f == null) {
            f38471f = new CommonConfigSp();
        }
        return f38471f;
    }

    public void clear() {
        SharedPreferences.Editor edit = this.f38474e.edit();
        if (edit != null) {
            edit.clear();
            edit.apply();
        }
    }

    public void put(String str, String str2) {
        this.f38474e.edit().putString(str, str2).apply();
    }

    public void put(String str, int i) {
        this.f38474e.edit().putInt(str, i).apply();
    }

    public void put(String str, long j) {
        this.f38474e.edit().putLong(str, j).apply();
    }

    public void put(String str, float f) {
        this.f38474e.edit().putFloat(str, f).apply();
    }

    public String get(String str, String str2) {
        return this.f38474e.getString(str, str2);
    }

    public int get(String str, int i) {
        return this.f38474e.getInt(str, i);
    }

    public long get(String str, long j) {
        return this.f38474e.getLong(str, j);
    }

    public float get(String str, float f) {
        return this.f38474e.getFloat(str, f);
    }
}
