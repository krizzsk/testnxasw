package com.didi.sdk.util.config;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

public class PreferenceEditorProxy {

    /* renamed from: a */
    private static final int f40428a = 5;

    /* renamed from: b */
    private static final int f40429b = 0;

    /* renamed from: c */
    private static final int f40430c = 1;

    /* renamed from: d */
    private static final int f40431d = 2;

    /* renamed from: e */
    private static final int f40432e = 3;

    /* renamed from: f */
    private static final int f40433f = 4;

    /* renamed from: g */
    private static PreferenceEditorProxy f40434g;

    /* renamed from: h */
    private SharedPreferences.Editor f40435h;

    /* renamed from: i */
    private ConcurrentHashMap<String, Object> f40436i;

    /* renamed from: j */
    private ConcurrentHashMap<String, Integer> f40437j = new ConcurrentHashMap<>();

    /* renamed from: k */
    private Handler f40438k;

    public interface PerferenceListener {
        void onCommit();
    }

    private PreferenceEditorProxy() {
        HandlerThread handlerThread = new HandlerThread(PreferenceEditorProxy.class.getSimpleName());
        handlerThread.start();
        this.f40438k = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                PreferenceEditorProxy.this.m30403a();
                Object obj = message.obj;
                if (obj != null) {
                    ((PerferenceListener) obj).onCommit();
                }
            }
        };
    }

    public static PreferenceEditorProxy getInstance() {
        PreferenceEditorProxy preferenceEditorProxy = f40434g;
        if (preferenceEditorProxy != null) {
            return preferenceEditorProxy;
        }
        synchronized (PreferenceEditorProxy.class) {
            if (f40434g == null) {
                f40434g = new PreferenceEditorProxy();
            }
        }
        return f40434g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo103112a(SharedPreferences.Editor editor) {
        this.f40435h = editor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo103113a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.f40436i = concurrentHashMap;
    }

    public void clear() {
        this.f40435h.clear();
        this.f40435h.apply();
    }

    public void putString(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.f40436i.put(str, str2);
        this.f40437j.put(str, 3);
    }

    public void putLong(String str, long j) {
        this.f40436i.put(str, Long.valueOf(j));
        this.f40437j.put(str, 1);
    }

    public void putInt(String str, int i) {
        this.f40436i.put(str, Integer.valueOf(i));
        this.f40437j.put(str, 0);
    }

    public void putBoolean(String str, boolean z) {
        this.f40436i.put(str, Boolean.valueOf(z));
        this.f40437j.put(str, 4);
    }

    public void putFloat(String str, float f) {
        this.f40436i.put(str, Float.valueOf(f));
        this.f40437j.put(str, 2);
    }

    public void commit() {
        if (this.f40437j.size() >= 5) {
            this.f40438k.sendEmptyMessage(0);
        }
    }

    public void commitCur() {
        this.f40435h.commit();
    }

    public void putStringCur(String str, String str2) {
        SharedPreferences.Editor editor = this.f40435h;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public void putIntCur(String str, int i) {
        SharedPreferences.Editor editor = this.f40435h;
        if (editor != null) {
            editor.putInt(str, i);
        }
    }

    public void commitImmediately(PerferenceListener perferenceListener) {
        Handler handler = this.f40438k;
        handler.sendMessage(Message.obtain(handler, 0, perferenceListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30403a() {
        for (String next : this.f40437j.keySet()) {
            m30405a(next, this.f40436i.get(next), this.f40437j.remove(next).intValue());
        }
        this.f40435h.apply();
    }

    /* renamed from: a */
    private void m30405a(String str, Object obj, int i) {
        if (i == 0) {
            this.f40435h.putInt(str, Integer.parseInt(String.valueOf(obj)));
        } else if (i == 1) {
            this.f40435h.putLong(str, Long.parseLong(String.valueOf(obj)));
        } else if (i == 2) {
            this.f40435h.putFloat(str, Float.parseFloat(String.valueOf(obj)));
        } else if (i == 3) {
            this.f40435h.putString(str, String.valueOf(obj));
        } else if (i == 4) {
            this.f40435h.putBoolean(str, Boolean.parseBoolean(String.valueOf(obj)));
        }
    }
}
