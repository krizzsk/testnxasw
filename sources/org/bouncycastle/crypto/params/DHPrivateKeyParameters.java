package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x */
    private BigInteger f8004x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f8004x = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.f8004x) && super.equals(obj);
    }

    public BigInteger getX() {
        return this.f8004x;
    }

    public int hashCode() {
        return this.f8004x.hashCode() ^ super.hashCode();
    }
}
