package com.didi.dynamic.manager.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.ArrayMap;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SharedPreferencesWrapper implements SharedPreferences {

    /* renamed from: a */
    private static final String f21266a = "DM.SP";

    /* renamed from: b */
    private static final Map<SharedPreferences, SharedPreferencesWrapper> f21267b;

    /* renamed from: c */
    private static Method f21268c;

    /* renamed from: d */
    private static Method f21269d;

    /* renamed from: e */
    private SharedPreferences f21270e;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f21267b = new ArrayMap();
        } else {
            f21267b = new HashMap();
        }
    }

    /* renamed from: of */
    public static SharedPreferencesWrapper m17956of(SharedPreferences sharedPreferences) {
        SharedPreferencesWrapper sharedPreferencesWrapper;
        if (sharedPreferences instanceof SharedPreferencesWrapper) {
            return (SharedPreferencesWrapper) sharedPreferences;
        }
        synchronized (SharedPreferencesWrapper.class) {
            sharedPreferencesWrapper = f21267b.get(sharedPreferences);
            if (sharedPreferencesWrapper == null) {
                sharedPreferencesWrapper = new SharedPreferencesWrapper(sharedPreferences);
                f21267b.put(sharedPreferences, sharedPreferencesWrapper);
            }
        }
        return sharedPreferencesWrapper;
    }

    /* renamed from: of */
    public static SharedPreferencesWrapper m17955of(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        try {
            Method method = f21268c;
            if (method == null) {
                method = Context.class.getMethod("getSharedPreferences", new Class[]{String.class, Integer.TYPE});
                f21268c = method;
            }
            sharedPreferences = (SharedPreferences) method.invoke(context, new Object[]{str, Integer.valueOf(i)});
        } catch (Exception unused) {
            sharedPreferences = SystemUtils.getSharedPreferences(context, str, i);
        }
        return m17956of(sharedPreferences);
    }

    /* renamed from: of */
    public static SharedPreferencesWrapper m17954of(Activity activity, int i) {
        SharedPreferences sharedPreferences;
        try {
            Method method = f21269d;
            if (method == null) {
                method = Activity.class.getMethod("getPreferences", new Class[]{Integer.TYPE});
                f21269d = method;
            }
            sharedPreferences = (SharedPreferences) method.invoke(activity, new Object[]{Integer.valueOf(i)});
        } catch (Exception unused) {
            sharedPreferences = SystemUtils.getPreferences(activity, i);
        }
        return m17956of(sharedPreferences);
    }

    private SharedPreferencesWrapper(SharedPreferences sharedPreferences) {
        this.f21270e = sharedPreferences;
    }

    /* renamed from: a */
    private void m17953a(String str, Class cls, Object obj, Throwable th) {
        if (obj == null) {
            Log.m17932w(f21266a, "Null value, type: " + cls + ", key: " + str, th);
            return;
        }
        Log.m17932w(f21266a, "Wrong type: " + cls + ", key: " + str + ", type: " + obj.getClass() + ", value: " + obj, th);
    }

    public Map<String, ?> getAll() {
        return this.f21270e.getAll();
    }

    public String getString(String str, String str2) {
        try {
            return this.f21270e.getString(str, str2);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return str2;
            }
            m17953a(str, String.class, obj, e);
            return str2;
        }
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.f21270e.getStringSet(str, set);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return set;
            }
            m17953a(str, Set.class, obj, e);
            return set;
        }
    }

    public int getInt(String str, int i) {
        try {
            return this.f21270e.getInt(str, i);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return i;
            }
            m17953a(str, Integer.TYPE, obj, e);
            return i;
        }
    }

    public long getLong(String str, long j) {
        try {
            return this.f21270e.getLong(str, j);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return j;
            }
            m17953a(str, Long.TYPE, obj, e);
            return j;
        }
    }

    public float getFloat(String str, float f) {
        try {
            return this.f21270e.getFloat(str, f);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return f;
            }
            m17953a(str, Float.TYPE, obj, e);
            return f;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return this.f21270e.getBoolean(str, z);
        } catch (Exception e) {
            Object obj = getAll().get(str);
            if (obj == null) {
                return z;
            }
            m17953a(str, Boolean.TYPE, obj, e);
            return z;
        }
    }

    public boolean contains(String str) {
        return this.f21270e.contains(str);
    }

    public Editor edit() {
        return new Editor(this.f21270e.edit());
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f21270e.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f21270e.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static class Editor implements SharedPreferences.Editor {
        private static Method sCommitMethod;
        private SharedPreferences.Editor mBase;

        Editor(SharedPreferences.Editor editor) {
            this.mBase = editor;
        }

        public Editor putString(String str, String str2) {
            this.mBase.putString(str, str2);
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            this.mBase.putStringSet(str, set);
            return this;
        }

        public Editor putInt(String str, int i) {
            this.mBase.putInt(str, i);
            return this;
        }

        public Editor putLong(String str, long j) {
            this.mBase.putLong(str, j);
            return this;
        }

        public Editor putFloat(String str, float f) {
            this.mBase.putFloat(str, f);
            return this;
        }

        public Editor putBoolean(String str, boolean z) {
            this.mBase.putBoolean(str, z);
            return this;
        }

        public Editor remove(String str) {
            this.mBase.remove(str);
            return this;
        }

        public Editor clear() {
            this.mBase.clear();
            return this;
        }

        public boolean commitNow() {
            try {
                Method method = sCommitMethod;
                if (method == null) {
                    method = SharedPreferences.Editor.class.getMethod("commit", new Class[0]);
                    sCommitMethod = method;
                }
                return ((Boolean) method.invoke(this.mBase, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return this.mBase.commit();
            }
        }

        public boolean commit() {
            return commitNow();
        }

        public void apply() {
            this.mBase.apply();
        }
    }
}
