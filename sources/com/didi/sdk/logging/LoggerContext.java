package com.didi.sdk.logging;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.logging.util.Debug;
import java.io.File;

public class LoggerContext {

    /* renamed from: h */
    private static LoggerContext f39270h;

    /* renamed from: a */
    private String f39271a;

    /* renamed from: b */
    private File f39272b;

    /* renamed from: c */
    private File f39273c;

    /* renamed from: d */
    private File f39274d;

    /* renamed from: e */
    private File f39275e;

    /* renamed from: f */
    private boolean f39276f;

    /* renamed from: g */
    private boolean f39277g;

    private LoggerContext() {
    }

    public synchronized void init(Context context) {
        if (!this.f39276f) {
            boolean z = true;
            this.f39276f = true;
            this.f39271a = context.getPackageName();
            File filesDir = context.getFilesDir();
            this.f39275e = filesDir.getParentFile();
            File file = new File(filesDir, "logging");
            this.f39273c = file;
            if (!file.exists()) {
                this.f39273c.mkdirs();
            }
            File file2 = new File(filesDir, "logging-cache");
            this.f39274d = file2;
            if (!file2.exists()) {
                this.f39274d.mkdirs();
            }
            if ((context.getApplicationInfo().flags & 2) == 0) {
                z = false;
            }
            this.f39277g = z;
        }
    }

    public synchronized void update(LoggerConfig loggerConfig) {
        File logDir = loggerConfig.getLogDir();
        if (logDir != null) {
            this.f39272b = logDir;
        }
    }

    public static LoggerContext getDefault() {
        if (f39270h == null) {
            f39270h = new LoggerContext();
        }
        return f39270h;
    }

    public boolean isInitial() {
        return this.f39276f;
    }

    public String getPackageName() {
        return this.f39271a;
    }

    public File getSecondaryLogPathDir() {
        File file = this.f39272b;
        if (file != null && !TextUtils.equals(file.getPath(), this.f39273c.getPath())) {
            return this.f39273c;
        }
        return null;
    }

    public synchronized File getMainLogPathDir() {
        if (this.f39272b == null) {
            return this.f39273c;
        }
        try {
            if (!this.f39272b.exists() && !this.f39272b.mkdirs()) {
                return this.f39273c;
            } else if (!this.f39272b.exists()) {
                return this.f39273c;
            } else {
                if (!this.f39272b.canWrite() || !this.f39272b.canRead()) {
                    return this.f39273c;
                }
                return this.f39272b;
            }
        } catch (Exception e) {
            Debug.logOrThrow("check log dir " + this.f39272b + "failed", e);
        }
    }

    public File getLogCacheDir() {
        return this.f39274d;
    }

    public File getAppRootDir() {
        return this.f39275e;
    }

    public boolean isAppDebuggable() {
        return this.f39277g;
    }
}
