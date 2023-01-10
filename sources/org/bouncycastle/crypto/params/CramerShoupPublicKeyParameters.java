package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c */
    private BigInteger f7995c;

    /* renamed from: d */
    private BigInteger f7996d;

    /* renamed from: h */
    private BigInteger f7997h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f7995c = bigInteger;
        this.f7996d = bigInteger2;
        this.f7997h = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f7995c) && cramerShoupPublicKeyParameters.getD().equals(this.f7996d) && cramerShoupPublicKeyParameters.getH().equals(this.f7997h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f7995c;
    }

    public BigInteger getD() {
        return this.f7996d;
    }

    public BigInteger getH() {
        return this.f7997h;
    }

    public int hashCode() {
        return ((this.f7995c.hashCode() ^ this.f7996d.hashCode()) ^ this.f7997h.hashCode()) ^ super.hashCode();
    }
}
