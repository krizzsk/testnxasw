package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f8130g;

    /* renamed from: p */
    private BigInteger f8131p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f8131p = bigInteger;
        this.f8130g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f8130g;
    }

    public BigInteger getP() {
        return this.f8131p;
    }
}
