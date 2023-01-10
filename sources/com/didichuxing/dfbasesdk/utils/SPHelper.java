package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;

public class SPHelper {

    /* renamed from: a */
    private SharedPreferences f49408a;

    /* renamed from: b */
    private SharedPreferences.Editor f49409b;

    public SPHelper(Context context, String str) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, str, 0);
        this.f49408a = sharedPreferences;
        this.f49409b = sharedPreferences.edit();
    }

    public <T> T getWithType(String str, T t) {
        return get(str, t);
    }

    public Object get(String str, Object obj) {
        if (obj instanceof String) {
            return this.f49408a.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f49408a.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f49408a.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f49408a.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f49408a.getLong(str, ((Long) obj).longValue()));
        }
        String cls = obj != null ? obj.getClass().toString() : null;
        CheckUtils.throwExceptionIfDebug(new RuntimeException("sp not support " + cls));
        return null;
    }

    public SPHelper put(String str, Object obj) {
        SharedPreferences.Editor editor = this.f49409b;
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else {
            String cls = obj != null ? obj.getClass().toString() : null;
            CheckUtils.throwExceptionIfDebug(new RuntimeException("sp not support " + cls));
        }
        return this;
    }

    public void apply() {
        this.f49409b.apply();
    }

    public SPHelper remove(String str) {
        this.f49409b.remove(str);
        return this;
    }

    public SPHelper clear() {
        this.f49409b.clear();
        return this;
    }

    public boolean contains(String str) {
        return this.f49408a.contains(str);
    }

    @Deprecated
    public Map<String, ?> getAll(Context context) {
        return getAll();
    }

    public Map<String, ?> getAll() {
        return this.f49408a.getAll();
    }
}
