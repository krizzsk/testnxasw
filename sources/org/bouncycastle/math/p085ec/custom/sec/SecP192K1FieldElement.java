package org.bouncycastle.math.p085ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.p085ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* renamed from: org.bouncycastle.math.ec.custom.sec.SecP192K1FieldElement */
public class SecP192K1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f8196Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: x */
    protected int[] f8197x;

    public SecP192K1FieldElement() {
        this.f8197x = Nat192.create();
    }

    public SecP192K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f8196Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f8197x = SecP192K1Field.fromBigInteger(bigInteger);
    }

    protected SecP192K1FieldElement(int[] iArr) {
        this.f8197x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat192.create();
        SecP192K1Field.add(this.f8197x, ((SecP192K1FieldElement) eCFieldElement).f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat192.create();
        SecP192K1Field.addOne(this.f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat192.create();
        SecP192K1Field.inv(((SecP192K1FieldElement) eCFieldElement).f8197x, create);
        SecP192K1Field.multiply(create, this.f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP192K1FieldElement)) {
            return false;
        }
        return Nat192.m7127eq(this.f8197x, ((SecP192K1FieldElement) obj).f8197x);
    }

    public String getFieldName() {
        return "SecP192K1Field";
    }

    public int getFieldSize() {
        return f8196Q.bitLength();
    }

    public int hashCode() {
        return f8196Q.hashCode() ^ Arrays.hashCode(this.f8197x, 0, 6);
    }

    public ECFieldElement invert() {
        int[] create = Nat192.create();
        SecP192K1Field.inv(this.f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public boolean isOne() {
        return Nat192.isOne(this.f8197x);
    }

    public boolean isZero() {
        return Nat192.isZero(this.f8197x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat192.create();
        SecP192K1Field.multiply(this.f8197x, ((SecP192K1FieldElement) eCFieldElement).f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat192.create();
        SecP192K1Field.negate(this.f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f8197x;
        if (Nat192.isZero(iArr) || Nat192.isOne(iArr)) {
            return this;
        }
        int[] create = Nat192.create();
        SecP192K1Field.square(iArr, create);
        SecP192K1Field.multiply(create, iArr, create);
        int[] create2 = Nat192.create();
        SecP192K1Field.square(create, create2);
        SecP192K1Field.multiply(create2, iArr, create2);
        int[] create3 = Nat192.create();
        SecP192K1Field.squareN(create2, 3, create3);
        SecP192K1Field.multiply(create3, create2, create3);
        SecP192K1Field.squareN(create3, 2, create3);
        SecP192K1Field.multiply(create3, create, create3);
        SecP192K1Field.squareN(create3, 8, create);
        SecP192K1Field.multiply(create, create3, create);
        SecP192K1Field.squareN(create, 3, create3);
        SecP192K1Field.multiply(create3, create2, create3);
        int[] create4 = Nat192.create();
        SecP192K1Field.squareN(create3, 16, create4);
        SecP192K1Field.multiply(create4, create, create4);
        SecP192K1Field.squareN(create4, 35, create);
        SecP192K1Field.multiply(create, create4, create);
        SecP192K1Field.squareN(create, 70, create4);
        SecP192K1Field.multiply(create4, create, create4);
        SecP192K1Field.squareN(create4, 19, create);
        SecP192K1Field.multiply(create, create3, create);
        SecP192K1Field.squareN(create, 20, create);
        SecP192K1Field.multiply(create, create3, create);
        SecP192K1Field.squareN(create, 4, create);
        SecP192K1Field.multiply(create, create2, create);
        SecP192K1Field.squareN(create, 6, create);
        SecP192K1Field.multiply(create, create2, create);
        SecP192K1Field.square(create, create);
        SecP192K1Field.square(create, create2);
        if (Nat192.m7127eq(iArr, create2)) {
            return new SecP192K1FieldElement(create);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat192.create();
        SecP192K1Field.square(this.f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat192.create();
        SecP192K1Field.subtract(this.f8197x, ((SecP192K1FieldElement) eCFieldElement).f8197x, create);
        return new SecP192K1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat192.getBit(this.f8197x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f8197x);
    }
}
