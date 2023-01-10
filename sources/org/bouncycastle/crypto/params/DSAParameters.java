package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f8008g;

    /* renamed from: p */
    private BigInteger f8009p;

    /* renamed from: q */
    private BigInteger f8010q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f8008g = bigInteger3;
        this.f8009p = bigInteger;
        this.f8010q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f8008g = bigInteger3;
        this.f8009p = bigInteger;
        this.f8010q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f8009p) && dSAParameters.getQ().equals(this.f8010q) && dSAParameters.getG().equals(this.f8008g);
    }

    public BigInteger getG() {
        return this.f8008g;
    }

    public BigInteger getP() {
        return this.f8009p;
    }

    public BigInteger getQ() {
        return this.f8010q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
