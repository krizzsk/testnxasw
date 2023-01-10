package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g */
    private GF2Matrix f8372g;

    /* renamed from: n */
    private int f8373n;

    /* renamed from: t */
    private int f8374t;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false, (McElieceParameters) null);
        this.f8373n = i;
        this.f8374t = i2;
        this.f8372g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f8372g;
    }

    public int getK() {
        return this.f8372g.getNumRows();
    }

    public int getN() {
        return this.f8373n;
    }

    public int getT() {
        return this.f8374t;
    }
}
