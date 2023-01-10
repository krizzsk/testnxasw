package com.didi.safety.god.manager;

public class SafetyGodConfig {

    /* renamed from: a */
    private boolean f37366a;

    /* renamed from: b */
    private int f37367b;

    /* renamed from: c */
    private String f37368c;

    /* renamed from: d */
    private String f37369d;

    /* renamed from: e */
    private String f37370e;

    /* renamed from: f */
    private String f37371f;

    /* renamed from: g */
    private String f37372g;

    /* renamed from: h */
    private String f37373h;

    /* renamed from: i */
    private SafetyGodActivityDelegate f37374i;

    private SafetyGodConfig(Builder builder) {
        this.f37371f = "";
        this.f37367b = builder.bizCode;
        this.f37366a = builder.debug;
        this.f37368c = builder.token;
        this.f37369d = builder.keeperId;
        this.f37371f = builder.offLineEnv;
        this.f37370e = builder.cardArray;
        this.f37372g = builder.mNation;
        this.f37373h = builder.mLanguage;
        this.f37374i = builder.activityDelegate;
    }

    public void setNation(String str) {
        this.f37372g = str;
    }

    public String getNation() {
        return this.f37372g;
    }

    public void setLanguage(String str) {
        this.f37373h = str;
    }

    public String getLanguage() {
        return this.f37373h;
    }

    public boolean isDebug() {
        return this.f37366a;
    }

    public String getToken() {
        return this.f37368c;
    }

    public int getBizCode() {
        return this.f37367b;
    }

    public String getKeeperId() {
        return this.f37369d;
    }

    public String getCardArray() {
        return this.f37370e;
    }

    public boolean hasOffLineEnv() {
        String str = this.f37371f;
        return str != null && !str.equals("");
    }

    public String getOffLineEnv() {
        return this.f37371f;
    }

    public SafetyGodActivityDelegate getActivityDelegate() {
        return this.f37374i;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public SafetyGodActivityDelegate activityDelegate;
        /* access modifiers changed from: private */
        public int bizCode;
        /* access modifiers changed from: private */
        public String cardArray;
        /* access modifiers changed from: private */
        public boolean debug;
        /* access modifiers changed from: private */
        public String keeperId;
        /* access modifiers changed from: private */
        public String mLanguage;
        /* access modifiers changed from: private */
        public String mNation;
        /* access modifiers changed from: private */
        public String offLineEnv;
        /* access modifiers changed from: private */
        public String token;

        public Builder setCardArray(String str) {
            this.cardArray = str;
            return this;
        }

        public Builder setKeeperId(String str) {
            this.keeperId = str;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setBizCode(int i) {
            this.bizCode = i;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setActivityDelegate(SafetyGodActivityDelegate safetyGodActivityDelegate) {
            this.activityDelegate = safetyGodActivityDelegate;
            return this;
        }

        public Builder setOffLineEnv(String str) {
            this.offLineEnv = str;
            return this;
        }

        public Builder setNation(String str) {
            this.mNation = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.mLanguage = str;
            return this;
        }

        public SafetyGodConfig builder() {
            return new SafetyGodConfig(this);
        }
    }
}
