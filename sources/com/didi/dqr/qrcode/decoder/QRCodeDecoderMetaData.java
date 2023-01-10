package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.ResultPoint;

public final class QRCodeDecoderMetaData {

    /* renamed from: a */
    private final boolean f20894a;

    QRCodeDecoderMetaData(boolean z) {
        this.f20894a = z;
    }

    public boolean isMirrored() {
        return this.f20894a;
    }

    public void applyMirroredCorrection(ResultPoint[] resultPointArr) {
        if (this.f20894a && resultPointArr != null && resultPointArr.length >= 3) {
            ResultPoint resultPoint = resultPointArr[0];
            resultPointArr[0] = resultPointArr[2];
            resultPointArr[2] = resultPoint;
        }
    }
}
