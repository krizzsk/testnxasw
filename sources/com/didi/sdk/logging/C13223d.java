package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.RollingCalendar;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.sdk.logging.d */
/* compiled from: LogFileRemover */
class C13223d {

    /* renamed from: a */
    static final long f39300a = -1;

    /* renamed from: b */
    static final int f39301b = 336;

    /* renamed from: c */
    static final long f39302c = (TimeUnit.DAYS.toMillis(1) * 64);

    /* renamed from: d */
    private final RollingCalendar f39303d;

    /* renamed from: e */
    private int f39304e = LoggerFactory.getConfig().getFileMaxHistory();

    /* renamed from: f */
    private int f39305f;

    /* renamed from: g */
    private long f39306g = LoggerFactory.getConfig().getTotalFileSize();

    /* renamed from: h */
    private long f39307h = -1;

    /* renamed from: i */
    private File f39308i;

    C13223d(File file) {
        this.f39308i = file;
        this.f39303d = new RollingCalendar();
        mo99020a(this.f39304e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99021a(Date date) {
        long time = date.getTime();
        int a = m29618a(time);
        this.f39307h = time;
        for (int i = 0; i < a; i++) {
            m29619a(date, this.f39305f - i);
        }
        mo99022b(date);
    }

    /* renamed from: a */
    private int m29618a(long j) {
        long j2 = this.f39307h;
        long j3 = 336;
        if (j2 == -1) {
            long periodsElapsed = this.f39303d.periodsElapsed(j, f39302c + j);
            if (periodsElapsed <= 336) {
                j3 = periodsElapsed;
            }
        } else {
            j3 = this.f39303d.periodsElapsed(j2, j);
            if (j3 < 1) {
                j3 = 1;
            }
        }
        return (int) j3;
    }

    /* renamed from: a */
    private void m29619a(Date date, int i) {
        Date relativeDate = this.f39303d.getRelativeDate(date, i);
        if (Debug.isDebuggable()) {
            Debug.m29707d("cleanByPeriodOffset, now: " + date + " periodOffset: " + i + " date2delete: " + relativeDate);
        }
        File[] collectLogFiles = LoggerUtils.collectLogFiles(this.f39308i, (String) null, relativeDate);
        if (collectLogFiles.length != 0) {
            for (File file : collectLogFiles) {
                Debug.m29707d("cleanByPeriodOffset rm file:" + file + " size:" + file.length());
                file.delete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99020a(int i) {
        this.f39304e = i;
        this.f39305f = (-i) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo99022b(Date date) {
        HashSet hashSet = new HashSet();
        int i = 0;
        for (int i2 = 0; i2 < this.f39304e; i2++) {
            Date relativeDate = this.f39303d.getRelativeDate(date, -i2);
            File[] collectLogFiles = LoggerUtils.collectLogFiles(this.f39308i, (String) null, relativeDate);
            if (Debug.isDebuggable()) {
                Debug.m29707d("capTotalSize, now: " + date + " offset: " + i2 + " date: " + relativeDate + " matching size: " + collectLogFiles.length);
            }
            if (collectLogFiles.length > 0) {
                m29620a(collectLogFiles);
                for (File file : collectLogFiles) {
                    long length = ((long) i) + file.length();
                    if (length >= this.f39306g) {
                        break;
                    }
                    hashSet.add(file.getName());
                    i = (int) length;
                }
            }
        }
        File[] collectLogFiles2 = LoggerUtils.collectLogFiles(this.f39308i);
        if (collectLogFiles2 != null && collectLogFiles2.length > hashSet.size()) {
            for (File file2 : collectLogFiles2) {
                if (!hashSet.contains(file2.getName())) {
                    Debug.m29707d("capTotalSize rm file:" + file2 + " size:" + file2.length());
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private void m29620a(File[] fileArr) {
        if (fileArr != null) {
            for (int i = 0; i < fileArr.length - 1; i++) {
                File file = fileArr[i];
                int i2 = i;
                int i3 = i2;
                while (i2 < fileArr.length) {
                    if (fileArr[i2].lastModified() > file.lastModified()) {
                        file = fileArr[i2];
                        i3 = i2;
                    }
                    i2++;
                }
                if (i != i3) {
                    fileArr[i3] = fileArr[i];
                    fileArr[i] = file;
                }
            }
        }
    }
}
