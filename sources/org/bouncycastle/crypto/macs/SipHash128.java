package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Pack;

public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public SipHash128(int i, int i2) {
        super(i, i2);
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        this.f7923m >>>= (7 - this.wordPos) << 3;
        this.f7923m >>>= 8;
        this.f7923m |= (((long) ((this.wordCount << 3) + this.wordPos)) & 255) << 56;
        processMessageWord();
        this.f7926v2 ^= 238;
        applySipRounds(this.f7920d);
        long j = ((this.f7924v0 ^ this.f7925v1) ^ this.f7926v2) ^ this.f7927v3;
        this.f7925v1 ^= 221;
        applySipRounds(this.f7920d);
        reset();
        Pack.longToLittleEndian(j, bArr, i);
        Pack.longToLittleEndian(((this.f7924v0 ^ this.f7925v1) ^ this.f7926v2) ^ this.f7927v3, bArr, i + 8);
        return 16;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    public String getAlgorithmName() {
        return "SipHash128-" + this.f7919c + "-" + this.f7920d;
    }

    public int getMacSize() {
        return 16;
    }

    public void reset() {
        super.reset();
        this.f7925v1 ^= 238;
    }
}
