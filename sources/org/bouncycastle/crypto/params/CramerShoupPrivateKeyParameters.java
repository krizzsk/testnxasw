package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk */
    private CramerShoupPublicKeyParameters f7989pk;

    /* renamed from: x1 */
    private BigInteger f7990x1;

    /* renamed from: x2 */
    private BigInteger f7991x2;

    /* renamed from: y1 */
    private BigInteger f7992y1;

    /* renamed from: y2 */
    private BigInteger f7993y2;

    /* renamed from: z */
    private BigInteger f7994z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f7990x1 = bigInteger;
        this.f7991x2 = bigInteger2;
        this.f7992y1 = bigInteger3;
        this.f7993y2 = bigInteger4;
        this.f7994z = bigInteger5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f7990x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f7991x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f7992y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f7993y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f7994z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f7989pk;
    }

    public BigInteger getX1() {
        return this.f7990x1;
    }

    public BigInteger getX2() {
        return this.f7991x2;
    }

    public BigInteger getY1() {
        return this.f7992y1;
    }

    public BigInteger getY2() {
        return this.f7993y2;
    }

    public BigInteger getZ() {
        return this.f7994z;
    }

    public int hashCode() {
        return ((((this.f7990x1.hashCode() ^ this.f7991x2.hashCode()) ^ this.f7992y1.hashCode()) ^ this.f7993y2.hashCode()) ^ this.f7994z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f7989pk = cramerShoupPublicKeyParameters;
    }
}
