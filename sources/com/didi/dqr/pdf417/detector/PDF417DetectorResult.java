package com.didi.dqr.pdf417.detector;

import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import java.util.List;

public final class PDF417DetectorResult {

    /* renamed from: a */
    private final BitMatrix f20836a;

    /* renamed from: b */
    private final List<ResultPoint[]> f20837b;

    public PDF417DetectorResult(BitMatrix bitMatrix, List<ResultPoint[]> list) {
        this.f20836a = bitMatrix;
        this.f20837b = list;
    }

    public BitMatrix getBits() {
        return this.f20836a;
    }

    public List<ResultPoint[]> getPoints() {
        return this.f20837b;
    }
}
