package org.bouncycastle.math.p085ec.custom.p086gm;

import java.math.BigInteger;
import org.bouncycastle.math.p085ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* renamed from: org.bouncycastle.math.ec.custom.gm.SM2P256V1FieldElement */
public class SM2P256V1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f8174Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f8175x;

    public SM2P256V1FieldElement() {
        this.f8175x = Nat256.create();
    }

    public SM2P256V1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f8174Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f8175x = SM2P256V1Field.fromBigInteger(bigInteger);
    }

    protected SM2P256V1FieldElement(int[] iArr) {
        this.f8175x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SM2P256V1Field.add(this.f8175x, ((SM2P256V1FieldElement) eCFieldElement).f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat256.create();
        SM2P256V1Field.addOne(this.f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SM2P256V1Field.inv(((SM2P256V1FieldElement) eCFieldElement).f8175x, create);
        SM2P256V1Field.multiply(create, this.f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SM2P256V1FieldElement)) {
            return false;
        }
        return Nat256.m7129eq(this.f8175x, ((SM2P256V1FieldElement) obj).f8175x);
    }

    public String getFieldName() {
        return "SM2P256V1Field";
    }

    public int getFieldSize() {
        return f8174Q.bitLength();
    }

    public int hashCode() {
        return f8174Q.hashCode() ^ Arrays.hashCode(this.f8175x, 0, 8);
    }

    public ECFieldElement invert() {
        int[] create = Nat256.create();
        SM2P256V1Field.inv(this.f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public boolean isOne() {
        return Nat256.isOne(this.f8175x);
    }

    public boolean isZero() {
        return Nat256.isZero(this.f8175x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SM2P256V1Field.multiply(this.f8175x, ((SM2P256V1FieldElement) eCFieldElement).f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat256.create();
        SM2P256V1Field.negate(this.f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f8175x;
        if (Nat256.isZero(iArr) || Nat256.isOne(iArr)) {
            return this;
        }
        int[] create = Nat256.create();
        SM2P256V1Field.square(iArr, create);
        SM2P256V1Field.multiply(create, iArr, create);
        int[] create2 = Nat256.create();
        SM2P256V1Field.squareN(create, 2, create2);
        SM2P256V1Field.multiply(create2, create, create2);
        int[] create3 = Nat256.create();
        SM2P256V1Field.squareN(create2, 2, create3);
        SM2P256V1Field.multiply(create3, create, create3);
        SM2P256V1Field.squareN(create3, 6, create);
        SM2P256V1Field.multiply(create, create3, create);
        int[] create4 = Nat256.create();
        SM2P256V1Field.squareN(create, 12, create4);
        SM2P256V1Field.multiply(create4, create, create4);
        SM2P256V1Field.squareN(create4, 6, create);
        SM2P256V1Field.multiply(create, create3, create);
        SM2P256V1Field.square(create, create3);
        SM2P256V1Field.multiply(create3, iArr, create3);
        SM2P256V1Field.squareN(create3, 31, create4);
        SM2P256V1Field.multiply(create4, create3, create);
        SM2P256V1Field.squareN(create4, 32, create4);
        SM2P256V1Field.multiply(create4, create, create4);
        SM2P256V1Field.squareN(create4, 62, create4);
        SM2P256V1Field.multiply(create4, create, create4);
        SM2P256V1Field.squareN(create4, 4, create4);
        SM2P256V1Field.multiply(create4, create2, create4);
        SM2P256V1Field.squareN(create4, 32, create4);
        SM2P256V1Field.multiply(create4, iArr, create4);
        SM2P256V1Field.squareN(create4, 62, create4);
        SM2P256V1Field.square(create4, create2);
        if (Nat256.m7129eq(iArr, create2)) {
            return new SM2P256V1FieldElement(create4);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat256.create();
        SM2P256V1Field.square(this.f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat256.create();
        SM2P256V1Field.subtract(this.f8175x, ((SM2P256V1FieldElement) eCFieldElement).f8175x, create);
        return new SM2P256V1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat256.getBit(this.f8175x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f8175x);
    }
}
