package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f7603A;

    /* renamed from: B */
    protected BigInteger f7604B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f7605M1;

    /* renamed from: M2 */
    protected BigInteger f7606M2;

    /* renamed from: N */
    protected BigInteger f7607N;

    /* renamed from: S */
    protected BigInteger f7608S;

    /* renamed from: b */
    protected BigInteger f7609b;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7610g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f7611u;

    /* renamed from: v */
    protected BigInteger f7612v;

    private BigInteger calculateS() {
        return this.f7612v.modPow(this.f7611u, this.f7607N).multiply(this.f7603A).mod(this.f7607N).modPow(this.f7609b, this.f7607N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f7607N, bigInteger);
        this.f7603A = validatePublicValue;
        this.f7611u = SRP6Util.calculateU(this.digest, this.f7607N, validatePublicValue, this.f7604B);
        BigInteger calculateS = calculateS();
        this.f7608S = calculateS;
        return calculateS;
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f7603A;
        if (bigInteger3 == null || (bigInteger = this.f7605M1) == null || (bigInteger2 = this.f7608S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger calculateM2 = SRP6Util.calculateM2(this.digest, this.f7607N, bigInteger3, bigInteger, bigInteger2);
        this.f7606M2 = calculateM2;
        return calculateM2;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f7608S;
        if (bigInteger == null || this.f7605M1 == null || this.f7606M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.f7607N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f7607N, this.f7610g);
        this.f7609b = selectPrivateValue();
        BigInteger mod = calculateK.multiply(this.f7612v).mod(this.f7607N).add(this.f7610g.modPow(this.f7609b, this.f7607N)).mod(this.f7607N);
        this.f7604B = mod;
        return mod;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest2, SecureRandom secureRandom) {
        this.f7607N = bigInteger;
        this.f7610g = bigInteger2;
        this.f7612v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), bigInteger, digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f7607N, this.f7610g, this.random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f7603A;
        if (bigInteger4 == null || (bigInteger2 = this.f7604B) == null || (bigInteger3 = this.f7608S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        } else if (!SRP6Util.calculateM1(this.digest, this.f7607N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f7605M1 = bigInteger;
            return true;
        }
    }
}
