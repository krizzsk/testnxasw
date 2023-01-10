package com.didi.dqr;

import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.BitMatrix;

public abstract class Binarizer {

    /* renamed from: a */
    private final LuminanceSource f20346a;

    /* renamed from: b */
    private LuminanceSource f20347b;

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    public abstract BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException;

    public abstract BitArray getRotatedBlackRow(int i, BitArray bitArray) throws NotFoundException;

    protected Binarizer(LuminanceSource luminanceSource) {
        this.f20346a = luminanceSource;
    }

    public final LuminanceSource getLuminanceSource() {
        return this.f20346a;
    }

    public final int getWidth() {
        return this.f20346a.getWidth();
    }

    public final int getHeight() {
        return this.f20346a.getHeight();
    }

    public final LuminanceSource getRotateLuminanceSource() {
        if (this.f20347b == null) {
            this.f20347b = new PlanarYUVLuminanceSource(this.f20346a.getMatrix(), this.f20346a.getHeight(), this.f20346a.getWidth());
        }
        return this.f20347b;
    }
}
