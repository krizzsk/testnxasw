package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f8023a;

    /* renamed from: p */
    private BigInteger f8024p;

    /* renamed from: q */
    private BigInteger f8025q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f8024p = bigInteger;
        this.f8025q = bigInteger2;
        this.f8023a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f8023a = bigInteger3;
        this.f8024p = bigInteger;
        this.f8025q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f8024p) && gOST3410Parameters.getQ().equals(this.f8025q) && gOST3410Parameters.getA().equals(this.f8023a);
    }

    public BigInteger getA() {
        return this.f8023a;
    }

    public BigInteger getP() {
        return this.f8024p;
    }

    public BigInteger getQ() {
        return this.f8025q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f8024p.hashCode() ^ this.f8025q.hashCode()) ^ this.f8023a.hashCode();
    }
}
