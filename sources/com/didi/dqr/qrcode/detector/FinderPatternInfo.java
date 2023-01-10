package com.didi.dqr.qrcode.detector;

public final class FinderPatternInfo {

    /* renamed from: a */
    private FinderPattern f20939a;

    /* renamed from: b */
    private FinderPattern f20940b;

    /* renamed from: c */
    private FinderPattern f20941c;

    /* renamed from: d */
    private FinderPattern[] f20942d;
    public boolean success;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.f20939a = finderPatternArr[0];
        this.f20940b = finderPatternArr[1];
        this.f20941c = finderPatternArr[2];
        this.f20942d = finderPatternArr;
        this.success = true;
    }

    public FinderPatternInfo(FinderPattern[] finderPatternArr, boolean z) {
        this.success = z;
        if (z) {
            this.f20939a = finderPatternArr[0];
            this.f20940b = finderPatternArr[1];
            this.f20941c = finderPatternArr[2];
            this.f20942d = finderPatternArr;
            return;
        }
        this.f20942d = finderPatternArr;
    }

    public FinderPattern getBottomLeft() {
        return this.f20939a;
    }

    public FinderPattern getTopLeft() {
        return this.f20940b;
    }

    public FinderPattern getTopRight() {
        return this.f20941c;
    }

    public FinderPattern[] getPatternCenters() {
        return this.f20942d;
    }
}
