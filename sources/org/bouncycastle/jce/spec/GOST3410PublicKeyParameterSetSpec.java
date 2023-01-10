package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f8138a;

    /* renamed from: p */
    private BigInteger f8139p;

    /* renamed from: q */
    private BigInteger f8140q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f8139p = bigInteger;
        this.f8140q = bigInteger2;
        this.f8138a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f8138a.equals(gOST3410PublicKeyParameterSetSpec.f8138a) && this.f8139p.equals(gOST3410PublicKeyParameterSetSpec.f8139p) && this.f8140q.equals(gOST3410PublicKeyParameterSetSpec.f8140q);
    }

    public BigInteger getA() {
        return this.f8138a;
    }

    public BigInteger getP() {
        return this.f8139p;
    }

    public BigInteger getQ() {
        return this.f8140q;
    }

    public int hashCode() {
        return (this.f8138a.hashCode() ^ this.f8139p.hashCode()) ^ this.f8140q.hashCode();
    }
}
