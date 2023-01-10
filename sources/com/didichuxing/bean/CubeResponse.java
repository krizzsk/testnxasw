package com.didichuxing.bean;

public class CubeResponse {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static CubeResponse f48322e;

    /* renamed from: a */
    private int f48323a;

    /* renamed from: b */
    private String f48324b;

    /* renamed from: c */
    private boolean f48325c;

    /* renamed from: d */
    private int f48326d;

    public int getErrno() {
        return this.f48323a;
    }

    public void setErrno(int i) {
        this.f48323a = i;
    }

    public String getErrMsg() {
        return this.f48324b;
    }

    public void setErrMsg(String str) {
        this.f48324b = str;
    }

    public boolean isUpdate() {
        return this.f48325c;
    }

    public void setUpdate(boolean z) {
        this.f48325c = z;
    }

    public int getInterval() {
        return this.f48326d;
    }

    public void setInterval(int i) {
        this.f48326d = i;
    }

    public static class Builder {
        public Builder() {
            CubeResponse unused = CubeResponse.f48322e = new CubeResponse();
        }

        public Builder setErrNo(int i) {
            CubeResponse.f48322e.setErrno(i);
            return this;
        }

        public Builder setErrMsg(String str) {
            CubeResponse.f48322e.setErrMsg(str);
            return this;
        }

        public Builder setInterval(int i) {
            CubeResponse.f48322e.setInterval(i);
            return this;
        }

        public Builder setUpdate(boolean z) {
            CubeResponse.f48322e.setUpdate(z);
            return this;
        }

        public CubeResponse build() {
            return CubeResponse.f48322e;
        }
    }

    public String toString() {
        return "CubeResponse :   errno = " + this.f48323a + " errMsg = " + this.f48324b + "update : " + this.f48325c + "  interval : " + this.f48326d;
    }
}
