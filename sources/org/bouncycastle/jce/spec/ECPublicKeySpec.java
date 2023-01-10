package org.bouncycastle.jce.spec;

import org.bouncycastle.math.p085ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private ECPoint f8129q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f8129q = eCPoint.getCurve() != null ? eCPoint.normalize() : eCPoint;
    }

    public ECPoint getQ() {
        return this.f8129q;
    }
}
