package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f7593A;

    /* renamed from: B */
    protected BigInteger f7594B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f7595M1;

    /* renamed from: M2 */
    protected BigInteger f7596M2;

    /* renamed from: N */
    protected BigInteger f7597N;

    /* renamed from: S */
    protected BigInteger f7598S;

    /* renamed from: a */
    protected BigInteger f7599a;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7600g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f7601u;

    /* renamed from: x */
    protected BigInteger f7602x;

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f7597N, this.f7600g);
        return this.f7594B.subtract(this.f7600g.modPow(this.f7602x, this.f7597N).multiply(calculateK).mod(this.f7597N)).mod(this.f7597N).modPow(this.f7601u.multiply(this.f7602x).add(this.f7599a), this.f7597N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f7593A;
        if (bigInteger3 == null || (bigInteger = this.f7594B) == null || (bigInteger2 = this.f7598S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger calculateM1 = SRP6Util.calculateM1(this.digest, this.f7597N, bigInteger3, bigInteger, bigInteger2);
        this.f7595M1 = calculateM1;
        return calculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f7597N, bigInteger);
        this.f7594B = validatePublicValue;
        this.f7601u = SRP6Util.calculateU(this.digest, this.f7597N, this.f7593A, validatePublicValue);
        BigInteger calculateS = calculateS();
        this.f7598S = calculateS;
        return calculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f7598S;
        if (bigInteger == null || this.f7595M1 == null || this.f7596M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f7597N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f7602x = SRP6Util.calculateX(this.digest, this.f7597N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.f7599a = selectPrivateValue;
        BigInteger modPow = this.f7600g.modPow(selectPrivateValue, this.f7597N);
        this.f7593A = modPow;
        return modPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.f7597N = bigInteger;
        this.f7600g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f7597N, this.f7600g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f7593A;
        if (bigInteger4 == null || (bigInteger2 = this.f7595M1) == null || (bigInteger3 = this.f7598S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.f7597N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f7596M2 = bigInteger;
            return true;
        }
    }
}
