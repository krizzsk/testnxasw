package com.didiglobal.privacy.domainmonitor.model;

import android.text.TextUtils;

public class NetworkParam {

    /* renamed from: a */
    private String f53058a = "";

    /* renamed from: b */
    private long f53059b;

    /* renamed from: c */
    private long f53060c;

    /* renamed from: d */
    private int f53061d = -1;

    /* renamed from: e */
    private String f53062e = "";

    public long getDownloadByteCount() {
        return this.f53060c;
    }

    public void setDownloadByteCount(long j) {
        this.f53060c = j;
    }

    public String getUrl() {
        return this.f53058a;
    }

    public void setUrl(String str) {
        this.f53058a = str;
    }

    public long getUploadByteCount() {
        return this.f53059b;
    }

    public void setUploadByteCount(long j) {
        this.f53059b = j;
    }

    public boolean isInvalid() {
        return TextUtils.isEmpty(this.f53058a) && (this.f53059b > 0 || this.f53060c > 0);
    }

    public int getStatusCode() {
        return this.f53061d;
    }

    public void setStatusCode(int i) {
        this.f53061d = i;
    }

    public String getErrorMessage() {
        return this.f53062e;
    }

    public void appendErrorMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f53062e = str;
        }
    }

    public String toString() {
        return "NetworkParam{url='" + this.f53058a + '\'' + ", uploadByteCount=" + this.f53059b + ", downloadByteCount=" + this.f53060c + ", statusCode=" + this.f53061d + ", errorMessage='" + this.f53062e + '\'' + '}';
    }
}
