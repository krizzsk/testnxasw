package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f8134a;

    /* renamed from: p */
    private BigInteger f8135p;

    /* renamed from: q */
    private BigInteger f8136q;

    /* renamed from: x */
    private BigInteger f8137x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f8137x = bigInteger;
        this.f8135p = bigInteger2;
        this.f8136q = bigInteger3;
        this.f8134a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f8134a;
    }

    public BigInteger getP() {
        return this.f8135p;
    }

    public BigInteger getQ() {
        return this.f8136q;
    }

    public BigInteger getX() {
        return this.f8137x;
    }
}
