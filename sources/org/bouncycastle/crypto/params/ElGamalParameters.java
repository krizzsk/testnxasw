package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f8018g;

    /* renamed from: l */
    private int f8019l;

    /* renamed from: p */
    private BigInteger f8020p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f8018g = bigInteger2;
        this.f8020p = bigInteger;
        this.f8019l = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f8020p) && elGamalParameters.getG().equals(this.f8018g) && elGamalParameters.getL() == this.f8019l;
    }

    public BigInteger getG() {
        return this.f8018g;
    }

    public int getL() {
        return this.f8019l;
    }

    public BigInteger getP() {
        return this.f8020p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f8019l;
    }
}
