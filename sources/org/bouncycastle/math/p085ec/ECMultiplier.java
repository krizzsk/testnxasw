package org.bouncycastle.math.p085ec;

import java.math.BigInteger;

/* renamed from: org.bouncycastle.math.ec.ECMultiplier */
public interface ECMultiplier {
    ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger);
}
