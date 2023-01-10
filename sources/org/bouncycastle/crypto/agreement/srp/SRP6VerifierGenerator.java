package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f7613N;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7614g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f7614g.modPow(SRP6Util.calculateX(this.digest, this.f7613N, bArr, bArr2, bArr3), this.f7613N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.f7613N = bigInteger;
        this.f7614g = bigInteger2;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2) {
        this.f7613N = sRP6GroupParameters.getN();
        this.f7614g = sRP6GroupParameters.getG();
        this.digest = digest2;
    }
}
