package com.didichuxing.sdk.alphaface.core.liveness;

public class LivenessConfig {

    /* renamed from: a */
    private final long f51249a;

    /* renamed from: b */
    private final int f51250b;

    /* renamed from: c */
    private final int f51251c;

    /* renamed from: d */
    private final int f51252d;

    /* renamed from: e */
    private final double f51253e;

    /* renamed from: f */
    private final double f51254f;

    /* renamed from: g */
    private final int f51255g;

    /* renamed from: h */
    private final int f51256h;

    /* renamed from: i */
    private final ILivenessCallback f51257i;

    /* renamed from: j */
    private final int[] f51258j;

    /* renamed from: k */
    private final int f51259k;

    /* renamed from: l */
    private final int f51260l;

    /* renamed from: m */
    private final boolean f51261m;

    /* renamed from: n */
    private final int f51262n;

    /* renamed from: o */
    private final float f51263o;

    /* renamed from: p */
    private final float f51264p;

    /* renamed from: q */
    private final float f51265q;

    /* renamed from: r */
    private final float f51266r;

    /* renamed from: s */
    private final float f51267s;

    /* renamed from: t */
    private final int f51268t;

    private LivenessConfig(Builder builder) {
        this.f51249a = builder.skipTime;
        this.f51250b = builder.detectTime;
        this.f51251c = builder.attackPicCount;
        this.f51252d = builder.faceErrorCountMax;
        this.f51253e = builder.bestPicQualityThreshold;
        this.f51254f = builder.attackPicQualityThreshold;
        this.f51255g = builder.faceQualityErrorMaxTimes;
        this.f51256h = builder.faceQualityErrorDelay;
        this.f51257i = builder.callback;
        this.f51258j = builder.detectAction;
        this.f51259k = builder.actionTimeout;
        this.f51260l = builder.actionInterruptTime;
        this.f51261m = builder.attackEnable;
        this.f51262n = builder.frame_time_interval;
        this.f51263o = builder.yaw_thresh;
        this.f51264p = builder.pitch_thresh;
        this.f51265q = builder.occ_thresh;
        this.f51266r = builder.illum_thresh;
        this.f51267s = builder.blur_thresh;
        this.f51268t = builder.waterType;
    }

    public long getSkipTime() {
        return this.f51249a;
    }

    public int getDetectTime() {
        return this.f51250b;
    }

    public int getAttackPicCount() {
        return this.f51251c;
    }

    public int getFaceErrorCountMax() {
        return this.f51252d;
    }

    public double getBestPicQualityThreshold() {
        return this.f51253e;
    }

    public double getAttackPicQualityThreshold() {
        return this.f51254f;
    }

    public int getFaceQualityErrorMaxTimes() {
        return this.f51255g;
    }

    public int getFaceQualityErrorDelay() {
        return this.f51256h;
    }

    public ILivenessCallback getCallback() {
        return this.f51257i;
    }

    public int[] getDetectAction() {
        return this.f51258j;
    }

    public int getActionTimeout() {
        return this.f51259k;
    }

    public int getActionInterruptTime() {
        return this.f51260l;
    }

    public boolean attackEnable() {
        return this.f51261m;
    }

    public int getFrame_time_interval() {
        return this.f51262n;
    }

    public float getYaw_thresh() {
        return this.f51263o;
    }

    public float getPitch_thresh() {
        return this.f51264p;
    }

    public float getOcc_thresh() {
        return this.f51265q;
    }

    public float getIllum_thresh() {
        return this.f51266r;
    }

    public float getBlur_thresh() {
        return this.f51267s;
    }

    public int getWaterType() {
        return this.f51268t;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int actionInterruptTime = 1000;
        /* access modifiers changed from: private */
        public int actionTimeout = 10000;
        /* access modifiers changed from: private */
        public boolean attackEnable = true;
        /* access modifiers changed from: private */
        public int attackPicCount = 5;
        /* access modifiers changed from: private */
        public double attackPicQualityThreshold;
        /* access modifiers changed from: private */
        public double bestPicQualityThreshold;
        /* access modifiers changed from: private */
        public float blur_thresh = 0.1f;
        /* access modifiers changed from: private */
        public ILivenessCallback callback;
        /* access modifiers changed from: private */
        public int[] detectAction = {3};
        /* access modifiers changed from: private */
        public int detectTime = 1000;
        /* access modifiers changed from: private */
        public int faceErrorCountMax = 3;
        /* access modifiers changed from: private */
        public int faceQualityErrorDelay = 1000;
        /* access modifiers changed from: private */
        public int faceQualityErrorMaxTimes = 1;
        /* access modifiers changed from: private */
        public int frame_time_interval = 500;
        /* access modifiers changed from: private */
        public float illum_thresh = 0.78f;
        /* access modifiers changed from: private */
        public float occ_thresh = 0.6f;
        /* access modifiers changed from: private */
        public float pitch_thresh = 0.3f;
        /* access modifiers changed from: private */
        public long skipTime = 75;
        /* access modifiers changed from: private */
        public int waterType = 0;
        /* access modifiers changed from: private */
        public float yaw_thresh = 0.3f;

        public Builder setWaterType(int i) {
            this.waterType = i;
            return this;
        }

        public Builder setFrameSkipTime(long j) {
            this.skipTime = j;
            return this;
        }

        public Builder setDetectTime(int i) {
            this.detectTime = i;
            return this;
        }

        public Builder setActionPicCount(int i) {
            this.attackPicCount = i;
            return this;
        }

        public Builder setFaceErrorCountMax(int i) {
            this.faceErrorCountMax = i;
            return this;
        }

        public Builder setBestPicQualityThreshold(double d) {
            this.bestPicQualityThreshold = d;
            return this;
        }

        public Builder setFaceQualityErrorMaxTimes(int i) {
            this.faceQualityErrorMaxTimes = i;
            return this;
        }

        public Builder setFaceQualityErrorDelay(int i) {
            this.faceQualityErrorDelay = i;
            return this;
        }

        public Builder setAttackPicQualityThreshold(double d) {
            this.attackPicQualityThreshold = d;
            return this;
        }

        public Builder setCallback(ILivenessCallback iLivenessCallback) {
            this.callback = iLivenessCallback;
            return this;
        }

        public Builder setDetectAction(int[] iArr) {
            this.detectAction = iArr;
            return this;
        }

        public Builder setActionTimeout(int i) {
            this.actionTimeout = i;
            return this;
        }

        public Builder setActionInterruptTime(int i) {
            this.actionInterruptTime = i;
            return this;
        }

        public Builder setAttackEnable(boolean z) {
            this.attackEnable = z;
            return this;
        }

        public Builder setFrame_time_interval(int i) {
            this.frame_time_interval = i;
            return this;
        }

        public Builder setYaw_thresh(float f) {
            this.yaw_thresh = f;
            return this;
        }

        public Builder setPitch_thresh(float f) {
            this.pitch_thresh = f;
            return this;
        }

        public Builder setOcc_thresh(float f) {
            this.occ_thresh = f;
            return this;
        }

        public Builder setIllum_thresh(float f) {
            this.illum_thresh = f;
            return this;
        }

        public Builder setBlur_thresh(float f) {
            this.blur_thresh = f;
            return this;
        }

        public LivenessConfig builder() {
            return new LivenessConfig(this);
        }
    }
}
