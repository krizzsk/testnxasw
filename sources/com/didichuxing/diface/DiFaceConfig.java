package com.didichuxing.diface;

import android.content.Context;

public class DiFaceConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f49619a;

    /* renamed from: b */
    private String f49620b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f49621c;

    /* renamed from: d */
    private int f49622d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f49623e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f49624f;

    /* renamed from: g */
    private boolean f49625g;

    /* renamed from: h */
    private boolean f49626h;

    private DiFaceConfig() {
        this.f49622d = 2;
        this.f49625g = false;
    }

    public boolean isDebug() {
        return this.f49619a;
    }

    public String getDebugEnv() {
        return this.f49620b;
    }

    public Context getAppContext() {
        return this.f49621c;
    }

    public String getFacePicName() {
        if (this.f49624f == null) {
            this.f49624f = "DFFace.jpg";
        }
        return this.f49624f;
    }

    public int getMaxBioassayRetryCount() {
        return this.f49622d;
    }

    public boolean isForceCaptureVideo() {
        return this.f49625g;
    }

    public void setForceCaptureVideo(boolean z) {
        this.f49625g = z;
    }

    public void setForceUseBackCamera(boolean z) {
        this.f49626h = z;
    }

    public boolean getForceUseBackCamera() {
        return this.f49626h;
    }

    public static class Builder {
        private DiFaceConfig config = new DiFaceConfig();

        public Builder setDebug(boolean z) {
            boolean unused = this.config.f49619a = z;
            return this;
        }

        public Builder setAppContext(Context context) {
            Context unused = this.config.f49621c = context;
            return this;
        }

        public Builder setFacePicDir(String str) {
            String unused = this.config.f49623e = str;
            return this;
        }

        public Builder setFacePicName(String str) {
            String unused = this.config.f49624f = str;
            return this;
        }

        public DiFaceConfig create() {
            return this.config;
        }
    }
}
