package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p108ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CPUProvider implements IPerformance<Float>, ForegroundChecker.OnForegroundChange, Runnable {

    /* renamed from: a */
    private IDataProvider<Float> f19947a;

    /* renamed from: b */
    private float f19948b;

    /* renamed from: c */
    private long f19949c;

    /* renamed from: d */
    private long f19950d;

    /* renamed from: e */
    private RandomAccessFile f19951e;

    /* renamed from: f */
    private RandomAccessFile f19952f;

    public void registerProvider(IDataProvider<Float> iDataProvider) {
        this.f19947a = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        float f;
        try {
            f = getFpsByProc();
        } catch (IOException unused) {
            f = Float.parseFloat(C8333a.m16943a("CPU").replaceAll("\\D$", ""));
        }
        if (f <= 0.0f) {
            f = this.f19948b;
        }
        IDataProvider<Float> iDataProvider = this.f19947a;
        this.f19948b = f;
        iDataProvider.onProvide(Float.valueOf(f));
        GlobalDispatcher.postDelay(this, 1000);
    }

    public float getFpsByProc() throws IOException {
        String[] strArr;
        long j;
        if (this.f19951e == null) {
            this.f19951e = new RandomAccessFile("/proc/stat", "r");
        }
        this.f19951e.seek(0);
        String readLine = this.f19951e.readLine();
        if (this.f19952f == null) {
            this.f19952f = new RandomAccessFile("/proc/self/stat", "r");
        }
        this.f19952f.seek(0);
        String readLine2 = this.f19952f.readLine();
        String[] strArr2 = null;
        if (readLine == null || readLine2 == null) {
            strArr = null;
        } else {
            strArr2 = readLine.trim().split("\\s+");
            strArr = readLine2.trim().split("\\s+");
        }
        if (strArr2 != null) {
            if (strArr2.length >= 9) {
                j = 0;
                for (int i = 2; i <= 8; i++) {
                    j += Long.parseLong(strArr2[i]);
                }
            } else {
                j = 0;
            }
            long parseLong = strArr.length >= 15 ? Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]) : 0;
            long j2 = this.f19949c;
            if (j2 != 0) {
                long j3 = this.f19950d;
                if (j3 != 0) {
                    this.f19949c = j;
                    this.f19950d = parseLong;
                    return (float) ((((double) (parseLong - j3)) / ((double) (j - j2))) * 100.0d);
                }
            }
            this.f19949c = j;
            this.f19950d = parseLong;
            return -1.0f;
        }
        throw new IOException("status error");
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
