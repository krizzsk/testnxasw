package com.didi.sdk.apm.utils;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;

public class TimingLogger {

    /* renamed from: a */
    ArrayList<Long> f37830a;

    /* renamed from: b */
    ArrayList<String> f37831b;

    /* renamed from: c */
    private String f37832c;

    /* renamed from: d */
    private String f37833d;

    /* renamed from: e */
    private boolean f37834e;

    public TimingLogger(String str, String str2) {
        reset(str, str2);
    }

    public TimingLogger setDisabled(boolean z) {
        this.f37834e = z;
        return this;
    }

    public void reset(String str, String str2) {
        this.f37832c = str;
        this.f37833d = str2;
        reset();
    }

    public void reset() {
        if (!this.f37834e) {
            ArrayList<Long> arrayList = this.f37830a;
            if (arrayList == null) {
                this.f37830a = new ArrayList<>();
                this.f37831b = new ArrayList<>();
            } else {
                arrayList.clear();
                this.f37831b.clear();
            }
            addSplit((String) null);
        }
    }

    public void addSplit(String str) {
        if (!this.f37834e) {
            this.f37830a.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.f37831b.add(str);
        }
    }

    public void dumpToLog() {
        if (!this.f37834e) {
            String str = this.f37832c;
            Log.d(str, this.f37833d + ": begin");
            long longValue = this.f37830a.get(0).longValue();
            long j = longValue;
            for (int i = 1; i < this.f37830a.size(); i++) {
                j = this.f37830a.get(i).longValue();
                long longValue2 = this.f37830a.get(i - 1).longValue();
                String str2 = this.f37832c;
                Log.d(str2, this.f37833d + ":      " + (j - longValue2) + " ms, " + this.f37831b.get(i));
            }
            String str3 = this.f37832c;
            Log.d(str3, this.f37833d + ": end, " + (j - longValue) + " ms");
        }
    }
}
