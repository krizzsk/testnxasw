package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;

public class MapTrafficIcon {
    public static final int BUBBLE_STATUS_BLOCK = 0;
    public static final int BUBBLE_STATUS_BLOCK_ACCIDENT = 1;
    public static final int BUBBLE_STATUS_BLOCK_HOSPITAL = 4;
    public static final int BUBBLE_STATUS_BLOCK_IMAGE = 5;
    public static final int BUBBLE_STATUS_BLOCK_MULTI = 2;
    public static final int BUBBLE_STATUS_BLOCK_SCHOOL = 3;
    public static final int BUBBLE_TYPE_ACCIDENT = 0;
    public static final int BUBBLE_TYPE_BLOCK_ACCIDENT = 1;

    /* renamed from: a */
    private long f26992a;

    /* renamed from: b */
    private int f26993b;

    /* renamed from: c */
    private int f26994c;

    /* renamed from: d */
    private boolean f26995d;

    /* renamed from: e */
    private int f26996e;

    /* renamed from: f */
    private int f26997f;

    /* renamed from: g */
    private LatLng f26998g;

    /* renamed from: h */
    private boolean f26999h = false;

    /* renamed from: i */
    private int f27000i = 0;

    /* renamed from: j */
    private String f27001j = "";

    /* renamed from: k */
    private int f27002k = 0;

    /* renamed from: l */
    private String f27003l = "";

    public MapTrafficIcon() {
    }

    public MapTrafficIcon(long j, int i, int i2, boolean z, LatLng latLng) {
        this.f26992a = j;
        this.f26993b = i;
        this.f26994c = i2;
        this.f26995d = z;
        this.f26998g = latLng;
    }

    public String getVideoImgUrl() {
        return this.f27003l;
    }

    public void setVideoImgUrl(String str) {
        this.f27003l = str;
    }

    public int getShapeOffset() {
        return this.f26997f;
    }

    public void setShapeOffset(int i) {
        this.f26997f = i;
    }

    public int getCoorIndex() {
        return this.f26996e;
    }

    public void setCoorIndex(int i) {
        this.f26996e = i;
    }

    public boolean isFromBubble() {
        return this.f26999h;
    }

    public void setFromBubble(boolean z) {
        this.f26999h = z;
    }

    public long getId() {
        return this.f26992a;
    }

    public void setId(long j) {
        this.f26992a = j;
    }

    public int getSubId() {
        return this.f26993b;
    }

    public void setSubId(int i) {
        this.f26993b = i;
    }

    public int getType() {
        return this.f26994c;
    }

    public void setType(int i) {
        this.f26994c = i;
    }

    public LatLng getLatLng() {
        return this.f26998g;
    }

    public void setLatLng(LatLng latLng) {
        this.f26998g = latLng;
    }

    public boolean getState() {
        return this.f26995d;
    }

    public void setState(boolean z) {
        this.f26995d = z;
    }

    public int getBlockType() {
        return this.f27000i;
    }

    public void setBlockType(int i) {
        this.f27000i = i;
    }

    public int getBlockBubbleStatus() {
        return this.f27002k;
    }

    public void setBlockBubbleStatus(int i) {
        this.f27002k = i;
    }

    public String getImgUrl() {
        return this.f27001j;
    }

    public void setImgUrl(String str) {
        this.f27001j = str;
    }

    public String toString() {
        return "MapTrafficIcon{mId=" + this.f26992a + ", mSubId=" + this.f26993b + ", mType=" + this.f26994c + ", mState=" + this.f26995d + ", mLatLng=" + this.f26998g + ", fromBubble=" + this.f26999h + ", bubbleType=" + this.f27000i + ", imgUrl='" + this.f27001j + '\'' + ", blockBubbleStatus=" + this.f27002k + '}';
    }
}
