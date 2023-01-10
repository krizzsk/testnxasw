package com.didi.zxing.barcodescanner;

import com.didi.dqr.DecodeOptions;

public class Decoder {

    /* renamed from: a */
    private DecodeOptions f47921a;

    /* renamed from: b */
    private boolean f47922b;

    public Decoder(DecodeOptions decodeOptions, boolean z) {
        this.f47921a = decodeOptions;
        this.f47922b = z;
    }

    public DecodeOptions getDecodeOptions() {
        return this.f47921a;
    }

    public boolean isInverted() {
        return this.f47922b;
    }
}
