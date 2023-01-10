package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f8043dP;

    /* renamed from: dQ */
    private BigInteger f8044dQ;

    /* renamed from: e */
    private BigInteger f8045e;

    /* renamed from: p */
    private BigInteger f8046p;

    /* renamed from: q */
    private BigInteger f8047q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f8045e = bigInteger2;
        this.f8046p = bigInteger4;
        this.f8047q = bigInteger5;
        this.f8043dP = bigInteger6;
        this.f8044dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.f8043dP;
    }

    public BigInteger getDQ() {
        return this.f8044dQ;
    }

    public BigInteger getP() {
        return this.f8046p;
    }

    public BigInteger getPublicExponent() {
        return this.f8045e;
    }

    public BigInteger getQ() {
        return this.f8047q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
