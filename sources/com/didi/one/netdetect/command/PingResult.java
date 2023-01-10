package com.didi.one.netdetect.command;

import android.text.TextUtils;
import com.didi.one.netdetect.util.PingParse;
import java.util.List;

public class PingResult {

    /* renamed from: a */
    private String f31887a;

    /* renamed from: b */
    private String f31888b;

    /* renamed from: c */
    private String f31889c;

    /* renamed from: d */
    private int f31890d;

    /* renamed from: e */
    private int f31891e;

    /* renamed from: f */
    private int f31892f;

    /* renamed from: g */
    private float f31893g;

    public PingResult(int i, String str, String str2) {
        this.f31887a = str;
        this.f31888b = str2;
        this.f31890d = i;
        if (TextUtils.isEmpty(str)) {
            this.f31889c = "";
            this.f31893g = -1.0f;
            this.f31892f = i;
            return;
        }
        m24344a();
    }

    /* renamed from: a */
    private void m24344a() {
        this.f31889c = PingParse.getIP(this.f31887a);
        List<String> time = PingParse.getTime(this.f31887a);
        int size = time.size();
        this.f31891e = size;
        this.f31892f = this.f31890d - size;
        if (size == 0) {
            this.f31893g = -1.0f;
            return;
        }
        float f = 0.0f;
        for (String parseFloat : time) {
            try {
                f += Float.parseFloat(parseFloat);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        this.f31893g = f / ((float) this.f31891e);
    }

    public String getNormalValue() {
        return this.f31887a;
    }

    public void setNormalValue(String str) {
        this.f31887a = str;
    }

    public String getIp() {
        return this.f31889c;
    }

    public void setIp(String str) {
        this.f31889c = str;
    }

    public int getSucCount() {
        return this.f31891e;
    }

    public void setSucCount(int i) {
        this.f31891e = i;
    }

    public int getFailCount() {
        return this.f31892f;
    }

    public void setFailCount(int i) {
        this.f31892f = i;
    }

    public float getAverageTime() {
        return this.f31893g;
    }

    public void setAverageTime(float f) {
        this.f31893g = f;
    }

    public int getTotalCount() {
        return this.f31890d;
    }

    public void setTotalCount(int i) {
        this.f31890d = i;
    }

    public boolean isFailAll() {
        return !TextUtils.isEmpty(this.f31887a) && this.f31892f == this.f31890d;
    }

    public String getErrValue() {
        return this.f31888b;
    }

    public void setErrValue(String str) {
        this.f31888b = str;
    }

    public String toString() {
        return "PingResult{normalValue='" + this.f31887a + '\'' + ", errValue='" + this.f31888b + '\'' + ", ip='" + this.f31889c + '\'' + ", totalCount=" + this.f31890d + ", sucCount=" + this.f31891e + ", failCount=" + this.f31892f + ", averageTime=" + this.f31893g + '}';
    }
}
