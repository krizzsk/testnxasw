package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class G3413OFBBlockCipher extends StreamBlockCipher {

    /* renamed from: R */
    private byte[] f7946R;
    private byte[] R_init;

    /* renamed from: Y */
    private byte[] f7947Y;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean initialized = false;

    /* renamed from: m */
    private int f7948m;

    public G3413OFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.cipher = blockCipher;
        this.f7947Y = new byte[blockSize2];
    }

    private void generateR() {
        byte[] LSB = GOST3413CipherUtil.LSB(this.f7946R, this.f7948m - this.blockSize);
        System.arraycopy(LSB, 0, this.f7946R, 0, LSB.length);
        System.arraycopy(this.f7947Y, 0, this.f7946R, LSB.length, this.f7948m - LSB.length);
    }

    private void generateY() {
        this.cipher.processBlock(GOST3413CipherUtil.MSB(this.f7946R, this.blockSize), 0, this.f7947Y, 0);
    }

    private void initArrays() {
        int i = this.f7948m;
        this.f7946R = new byte[i];
        this.R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.f7948m = this.blockSize * 2;
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            generateY();
        }
        byte[] bArr = this.f7947Y;
        int i = this.byteCount;
        byte b2 = (byte) (b ^ bArr[i]);
        int i2 = i + 1;
        this.byteCount = i2;
        if (i2 == getBlockSize()) {
            this.byteCount = 0;
            generateR();
        }
        return b2;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length >= this.blockSize) {
                this.f7948m = iv.length;
                initArrays();
                byte[] clone = Arrays.clone(iv);
                this.R_init = clone;
                System.arraycopy(clone, 0, this.f7946R, 0, clone.length);
                if (parametersWithIV.getParameters() != null) {
                    blockCipher = this.cipher;
                    cipherParameters = parametersWithIV.getParameters();
                }
                this.initialized = true;
            }
            throw new IllegalArgumentException("Parameter m must blockSize <= m");
        }
        setupDefaultParams();
        initArrays();
        byte[] bArr = this.R_init;
        System.arraycopy(bArr, 0, this.f7946R, 0, bArr.length);
        if (cipherParameters != null) {
            blockCipher = this.cipher;
        }
        this.initialized = true;
        blockCipher.init(true, cipherParameters);
        this.initialized = true;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    public void reset() {
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.f7946R, 0, bArr.length);
            Arrays.clear(this.f7947Y);
            this.byteCount = 0;
            this.cipher.reset();
        }
    }
}
