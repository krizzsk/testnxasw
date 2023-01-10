package org.bouncycastle.crypto.p079ec;

import org.bouncycastle.math.p085ec.ECPoint;

/* renamed from: org.bouncycastle.crypto.ec.ECPair */
public class ECPair {

    /* renamed from: x */
    private final ECPoint f7759x;

    /* renamed from: y */
    private final ECPoint f7760y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f7759x = eCPoint;
        this.f7760y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f7759x;
    }

    public ECPoint getY() {
        return this.f7760y;
    }

    public int hashCode() {
        return this.f7759x.hashCode() + (this.f7760y.hashCode() * 37);
    }
}
