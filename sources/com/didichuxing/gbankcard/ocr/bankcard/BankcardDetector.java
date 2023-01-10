package com.didichuxing.gbankcard.ocr.bankcard;

import com.didichuxing.gbankcard.ocr.alpha.AlphaDetector;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardResult;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;

public class BankcardDetector {

    /* renamed from: a */
    private final IBankcardDetector f50262a = new AlphaDetector();

    /* renamed from: b */
    private final BankcardResult f50263b;

    /* renamed from: c */
    private int f50264c;

    /* renamed from: d */
    private int f50265d;

    public BankcardDetector(GuideResp guideResp) {
        int i = guideResp.ocrType;
        this.f50263b = new BankcardResult(i, guideResp.getBorderThreshold(), guideResp.getCenterThreshold());
    }

    public int detect(byte[] bArr, int i, int i2) {
        this.f50264c = i;
        this.f50265d = i2;
        return this.f50262a.detect(bArr, i, i2, this.f50263b);
    }

    public void stop() {
        this.f50262a.stop();
    }

    public BankcardResult.CardNumInfo getCardNumInfo() {
        return this.f50263b.mo124260a(this.f50265d, this.f50264c);
    }

    public float[] getCardRect() {
        return this.f50263b.mo124261a();
    }

    public float[] getCardNumRect() {
        return this.f50263b.mo124262b();
    }

    public void reset() {
        this.f50263b.mo124263c();
    }
}
