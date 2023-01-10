package com.didi.rfusion.config;

import android.app.Application;
import java.util.Locale;
import java.util.Map;

public class RFusionConfig {

    /* renamed from: a */
    private Application f35955a;

    /* renamed from: b */
    private IRFusionLogger f35956b;

    /* renamed from: c */
    private IRFusionTracker f35957c;

    /* renamed from: d */
    private Locale f35958d;

    /* renamed from: e */
    private RFFontDelegate f35959e;

    public interface IRFusionLogger {
        void debug(String str, String str2);

        void info(String str, String str2);
    }

    public interface IRFusionTracker {
        void track(String str, Map<String, Object> map);
    }

    private RFusionConfig(Builder builder) {
        this.f35955a = builder.mApplication;
        this.f35956b = builder.mLogger;
        this.f35957c = builder.mTracker;
        this.f35958d = builder.mLocale;
        this.f35959e = builder.mFontDelegate;
    }

    public Application getApplication() {
        return this.f35955a;
    }

    public IRFusionLogger getLogger() {
        return this.f35956b;
    }

    public IRFusionTracker getTracker() {
        return this.f35957c;
    }

    public Locale getLocale() {
        return this.f35958d;
    }

    public RFFontDelegate getFontDelegate() {
        return this.f35959e;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Application mApplication;
        /* access modifiers changed from: private */
        public RFFontDelegate mFontDelegate;
        /* access modifiers changed from: private */
        public Locale mLocale;
        /* access modifiers changed from: private */
        public IRFusionLogger mLogger;
        /* access modifiers changed from: private */
        public IRFusionTracker mTracker;

        public Builder(Application application) {
            this.mApplication = application;
        }

        public Builder setLogger(IRFusionLogger iRFusionLogger) {
            this.mLogger = iRFusionLogger;
            return this;
        }

        public Builder setTracker(IRFusionTracker iRFusionTracker) {
            this.mTracker = iRFusionTracker;
            return this;
        }

        public Builder setLocale(Locale locale) {
            this.mLocale = locale;
            return this;
        }

        public Builder setFontDelegate(RFFontDelegate rFFontDelegate) {
            this.mFontDelegate = rFFontDelegate;
            return this;
        }

        public RFusionConfig build() {
            return new RFusionConfig(this);
        }
    }
}
