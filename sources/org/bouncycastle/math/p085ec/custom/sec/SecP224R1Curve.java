package org.bouncycastle.math.p085ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.p085ec.AbstractECLookupTable;
import org.bouncycastle.math.p085ec.ECConstants;
import org.bouncycastle.math.p085ec.ECCurve;
import org.bouncycastle.math.p085ec.ECFieldElement;
import org.bouncycastle.math.p085ec.ECLookupTable;
import org.bouncycastle.math.p085ec.ECPoint;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.encoders.Hex;

/* renamed from: org.bouncycastle.math.ec.custom.sec.SecP224R1Curve */
public class SecP224R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP224R1_AFFINE_ZS = {new SecP224R1FieldElement(ECConstants.ONE)};
    private static final int SECP224R1_DEFAULT_COORDS = 2;

    /* renamed from: q */
    public static final BigInteger f8209q = SecP224R1FieldElement.f8213Q;
    protected SecP224R1Point infinity = new SecP224R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP224R1Curve() {
        super(f8209q);
        this.f8145a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f8146b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecP224R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final int[] iArr = new int[(i2 * 7 * 2)];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat224.copy(((SecP224R1FieldElement) eCPoint.getRawXCoord()).f8214x, 0, iArr, i3);
            int i5 = i3 + 7;
            Nat224.copy(((SecP224R1FieldElement) eCPoint.getRawYCoord()).f8214x, 0, iArr, i5);
            i3 = i5 + 7;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP224R1Curve.this.createRawPoint(new SecP224R1FieldElement(iArr), new SecP224R1FieldElement(iArr2), SecP224R1Curve.SECP224R1_AFFINE_ZS);
            }

            public int getSize() {
                return i2;
            }

            public ECPoint lookup(int i) {
                int[] create = Nat224.create();
                int[] create2 = Nat224.create();
                int i2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 7; i5++) {
                        int i6 = create[i5];
                        int[] iArr = iArr;
                        create[i5] = i6 ^ (iArr[i2 + i5] & i4);
                        create2[i5] = create2[i5] ^ (iArr[(i2 + 7) + i5] & i4);
                    }
                    i2 += 14;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i) {
                int[] create = Nat224.create();
                int[] create2 = Nat224.create();
                int i2 = i * 7 * 2;
                for (int i3 = 0; i3 < 7; i3++) {
                    int[] iArr = iArr;
                    create[i3] = iArr[i2 + i3];
                    create2[i3] = iArr[i2 + 7 + i3];
                }
                return createPoint(create, create2);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP224R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f8209q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f8209q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat224.create();
        SecP224R1Field.random(secureRandom, create);
        return new SecP224R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat224.create();
        SecP224R1Field.randomMult(secureRandom, create);
        return new SecP224R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }
}
