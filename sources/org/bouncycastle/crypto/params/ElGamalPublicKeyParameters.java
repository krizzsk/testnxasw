package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* renamed from: y */
    private BigInteger f8022y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f8022y = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.f8022y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.f8022y;
    }

    public int hashCode() {
        return this.f8022y.hashCode() ^ super.hashCode();
    }
}
