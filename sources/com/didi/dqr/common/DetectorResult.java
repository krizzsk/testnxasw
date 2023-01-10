package com.didi.dqr.common;

import com.didi.dqr.ResultPoint;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;

public class DetectorResult {

    /* renamed from: a */
    private final BitMatrix f20408a;

    /* renamed from: b */
    private final ResultPoint[] f20409b;
    public int contourDilateCount;
    public FinderPatternInfo info;
    public boolean reCaculateMoudleSize;
    public int realContourDilateCount;
    public boolean success;

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this(bitMatrix, resultPointArr, true, false);
    }

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z, boolean z2) {
        this.f20408a = bitMatrix;
        this.f20409b = resultPointArr;
        this.success = z;
        this.reCaculateMoudleSize = z2;
    }

    public DetectorResult(BitMatrix bitMatrix, FinderPatternInfo finderPatternInfo, boolean z, boolean z2) {
        this.f20408a = bitMatrix;
        this.f20409b = finderPatternInfo.getPatternCenters();
        this.info = finderPatternInfo;
        this.success = z;
        this.reCaculateMoudleSize = z2;
    }

    public final BitMatrix getBits() {
        return this.f20408a;
    }

    public final ResultPoint[] getPoints() {
        return this.f20409b;
    }
}
