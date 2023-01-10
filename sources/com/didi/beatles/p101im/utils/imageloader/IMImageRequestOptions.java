package com.didi.beatles.p101im.utils.imageloader;

/* renamed from: com.didi.beatles.im.utils.imageloader.IMImageRequestOptions */
public class IMImageRequestOptions {

    /* renamed from: a */
    private static final int f11670a = -1;

    /* renamed from: b */
    private static final int f11671b = 1;

    /* renamed from: c */
    private float f11672c = -1.0f;

    /* renamed from: d */
    private int f11673d = -1;

    /* renamed from: e */
    private int f11674e = -1;

    /* renamed from: f */
    private int f11675f;

    /* renamed from: g */
    private DiskCacheStrategy f11676g = DiskCacheStrategy.AUTOMATIC;

    /* renamed from: h */
    private int f11677h = -1;

    /* renamed from: com.didi.beatles.im.utils.imageloader.IMImageRequestOptions$DiskCacheStrategy */
    public enum DiskCacheStrategy {
        ALL,
        NONE,
        DATA,
        RESOURCE,
        AUTOMATIC
    }

    public IMImageRequestOptions sizeMultiplier(float f) {
        this.f11672c = f;
        return this;
    }

    public float getSizeMultiplier() {
        return this.f11672c;
    }

    public boolean isValidSizeMultiplier() {
        return this.f11672c != -1.0f;
    }

    public IMImageRequestOptions override(int i) {
        this.f11674e = i;
        this.f11673d = i;
        return this;
    }

    public IMImageRequestOptions override(int i, int i2) {
        this.f11674e = i;
        this.f11673d = i2;
        return this;
    }

    public boolean isValidOverrideSize() {
        return (this.f11674e == -1 || this.f11673d == -1) ? false : true;
    }

    public int getOverrideWidth() {
        return this.f11674e;
    }

    public int getOverrideHeight() {
        return this.f11673d;
    }

    public IMImageRequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.f11676g = diskCacheStrategy;
        return this;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.f11676g;
    }

    public IMImageRequestOptions placeholder(int i) {
        this.f11675f = i;
        return this;
    }

    public boolean isValidPlaceholderId() {
        return this.f11675f > 0;
    }

    public int getPlaceholderId() {
        return this.f11675f;
    }

    public IMImageRequestOptions centerCrop() {
        this.f11677h = 1;
        return this;
    }

    public boolean isValidCenterCrop() {
        return this.f11677h == 1;
    }
}
