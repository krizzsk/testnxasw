package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g */
    private BigInteger f7998g;

    /* renamed from: j */
    private BigInteger f7999j;

    /* renamed from: l */
    private int f8000l;

    /* renamed from: m */
    private int f8001m;

    /* renamed from: p */
    private BigInteger f8002p;

    /* renamed from: q */
    private BigInteger f8003q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, (BigInteger) null, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i), i, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, i, i2, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i <= bigInteger.bitLength() || Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            this.f7998g = bigInteger2;
            this.f8002p = bigInteger;
            this.f8003q = bigInteger3;
            this.f8001m = i;
            this.f8000l = i2;
            this.f7999j = bigInteger4;
            this.validation = dHValidationParameters;
            return;
        }
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    private static int getDefaultMParam(int i) {
        if (i != 0 && i < 160) {
            return i;
        }
        return 160;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        return dHParameters.getP().equals(this.f8002p) && dHParameters.getG().equals(this.f7998g);
    }

    public BigInteger getG() {
        return this.f7998g;
    }

    public BigInteger getJ() {
        return this.f7999j;
    }

    public int getL() {
        return this.f8000l;
    }

    public int getM() {
        return this.f8001m;
    }

    public BigInteger getP() {
        return this.f8002p;
    }

    public BigInteger getQ() {
        return this.f8003q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
