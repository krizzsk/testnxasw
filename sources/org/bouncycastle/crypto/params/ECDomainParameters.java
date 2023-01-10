package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.p078x9.X9ECParameters;
import org.bouncycastle.math.p085ec.ECAlgorithms;
import org.bouncycastle.math.p085ec.ECConstants;
import org.bouncycastle.math.p085ec.ECCurve;
import org.bouncycastle.math.p085ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    private final ECPoint f8013G;
    private final ECCurve curve;

    /* renamed from: h */
    private final BigInteger f8014h;
    private BigInteger hInv;

    /* renamed from: n */
    private final BigInteger f8015n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters x9ECParameters) {
        this(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.hInv = null;
        if (eCCurve == null) {
            throw new NullPointerException("curve");
        } else if (bigInteger != null) {
            this.curve = eCCurve;
            this.f8013G = validatePublicPoint(eCCurve, eCPoint);
            this.f8015n = bigInteger;
            this.f8014h = bigInteger2;
            this.seed = Arrays.clone(bArr);
        } else {
            throw new NullPointerException(CampaignValue.f43060b);
        }
    }

    static ECPoint validatePublicPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCPoint != null) {
            ECPoint normalize = ECAlgorithms.importPoint(eCCurve, eCPoint).normalize();
            if (normalize.isInfinity()) {
                throw new IllegalArgumentException("Point at infinity");
            } else if (normalize.isValid()) {
                return normalize;
            } else {
                throw new IllegalArgumentException("Point not on curve");
            }
        } else {
            throw new NullPointerException("Point cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        return this.curve.equals(eCDomainParameters.curve) && this.f8013G.equals(eCDomainParameters.f8013G) && this.f8015n.equals(eCDomainParameters.f8015n);
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f8013G;
    }

    public BigInteger getH() {
        return this.f8014h;
    }

    public synchronized BigInteger getHInv() {
        if (this.hInv == null) {
            this.hInv = BigIntegers.modOddInverseVar(this.f8015n, this.f8014h);
        }
        return this.hInv;
    }

    public BigInteger getN() {
        return this.f8015n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        return ((((this.curve.hashCode() ^ 1028) * 257) ^ this.f8013G.hashCode()) * 257) ^ this.f8015n.hashCode();
    }

    public BigInteger validatePrivateScalar(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullPointerException("Scalar cannot be null");
        } else if (bigInteger.compareTo(ECConstants.ONE) >= 0 && bigInteger.compareTo(getN()) < 0) {
            return bigInteger;
        } else {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
    }

    public ECPoint validatePublicPoint(ECPoint eCPoint) {
        return validatePublicPoint(getCurve(), eCPoint);
    }
}
