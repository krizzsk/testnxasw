package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavedState {

    /* renamed from: a */
    private final String f50459a = "com.didichuxing.massdk.quality.android.agent.v1_";

    /* renamed from: b */
    private final SharedPreferences f50460b;

    /* renamed from: c */
    private final SharedPreferences.Editor f50461c;

    /* renamed from: d */
    private final Lock f50462d = new ReentrantLock();

    public SavedState(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, m37659a(context.getPackageName()), 0);
        this.f50460b = sharedPreferences;
        this.f50461c = sharedPreferences.edit();
    }

    public void save(final String str, final String str2) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveString(str, str2);
                }
            }.start();
        } else {
            saveString(str, str2);
        }
    }

    public void saveString(String str, String str2) {
        this.f50462d.lock();
        try {
            this.f50461c.putString(str, str2);
            this.f50461c.commit();
        } finally {
            this.f50462d.unlock();
        }
    }

    public void save(final String str, final boolean z) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveBoolean(str, z);
                }
            }.start();
        } else {
            saveBoolean(str, z);
        }
    }

    public void saveBoolean(String str, boolean z) {
        this.f50462d.lock();
        try {
            this.f50461c.putBoolean(str, z);
            this.f50461c.commit();
        } finally {
            this.f50462d.unlock();
        }
    }

    public void save(final String str, final int i) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveInt(str, i);
                }
            }.start();
        } else {
            saveInt(str, i);
        }
    }

    public void saveInt(String str, int i) {
        this.f50462d.lock();
        try {
            this.f50461c.putInt(str, i);
            this.f50461c.commit();
        } finally {
            this.f50462d.unlock();
        }
    }

    public void save(final String str, final long j) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveLong(str, j);
                }
            }.start();
        } else {
            saveLong(str, j);
        }
    }

    public void saveLong(String str, long j) {
        this.f50462d.lock();
        try {
            this.f50461c.putLong(str, j);
            this.f50461c.commit();
        } finally {
            this.f50462d.unlock();
        }
    }

    public void save(final String str, final float f) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveFloat(str, f);
                }
            }.start();
        } else {
            saveFloat(str, f);
        }
    }

    public void saveFloat(String str, float f) {
        this.f50462d.lock();
        try {
            this.f50461c.putFloat(str, f);
            this.f50461c.commit();
        } finally {
            this.f50462d.unlock();
        }
    }

    public String getString(String str) {
        if (!this.f50460b.contains(str)) {
            return null;
        }
        return this.f50460b.getString(str, (String) null);
    }

    public boolean getBoolean(String str) {
        return this.f50460b.getBoolean(str, false);
    }

    public long getLong(String str) {
        return this.f50460b.getLong(str, 0);
    }

    public int getInt(String str) {
        return this.f50460b.getInt(str, 0);
    }

    public Float getFloat(String str) {
        if (!this.f50460b.contains(str)) {
            return null;
        }
        return Float.valueOf(((float) ((int) (this.f50460b.getFloat(str, 0.0f) * 100.0f))) / 100.0f);
    }

    /* renamed from: a */
    private String m37659a(String str) {
        return "com.didichuxing.massdk.quality.android.agent.v1_" + str;
    }
}
