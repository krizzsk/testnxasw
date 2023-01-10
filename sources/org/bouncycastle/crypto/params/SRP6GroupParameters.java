package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters {

    /* renamed from: N */
    private BigInteger f8048N;

    /* renamed from: g */
    private BigInteger f8049g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f8048N = bigInteger;
        this.f8049g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f8049g;
    }

    public BigInteger getN() {
        return this.f8048N;
    }
}
