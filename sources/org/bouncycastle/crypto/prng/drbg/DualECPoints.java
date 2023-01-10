package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.p085ec.ECPoint;

public class DualECPoints {
    private final int cofactor;

    /* renamed from: p */
    private final ECPoint f8058p;

    /* renamed from: q */
    private final ECPoint f8059q;
    private final int securityStrength;

    public DualECPoints(int i, ECPoint eCPoint, ECPoint eCPoint2, int i2) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.securityStrength = i;
            this.f8058p = eCPoint;
            this.f8059q = eCPoint2;
            this.cofactor = i2;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    private static int log2(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f8058p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f8058p;
    }

    public ECPoint getQ() {
        return this.f8059q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f8058p.getCurve().getFieldSize();
    }
}
