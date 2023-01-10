package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f8141a;

    /* renamed from: p */
    private BigInteger f8142p;

    /* renamed from: q */
    private BigInteger f8143q;

    /* renamed from: y */
    private BigInteger f8144y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f8144y = bigInteger;
        this.f8142p = bigInteger2;
        this.f8143q = bigInteger3;
        this.f8141a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f8141a;
    }

    public BigInteger getP() {
        return this.f8142p;
    }

    public BigInteger getQ() {
        return this.f8143q;
    }

    public BigInteger getY() {
        return this.f8144y;
    }
}
