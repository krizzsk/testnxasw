package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class ParSet extends ASN1Object {

    /* renamed from: h */
    private int[] f8290h;

    /* renamed from: k */
    private int[] f8291k;

    /* renamed from: t */
    private int f8292t;

    /* renamed from: w */
    private int[] f8293w;

    public ParSet(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f8292t = i;
        this.f8290h = iArr;
        this.f8293w = iArr2;
        this.f8291k = iArr3;
    }

    private ParSet(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 4) {
            this.f8292t = checkBigIntegerInIntRangeAndPositive(aSN1Sequence.getObjectAt(0));
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
            if (aSN1Sequence2.size() == this.f8292t && aSN1Sequence3.size() == this.f8292t && aSN1Sequence4.size() == this.f8292t) {
                this.f8290h = new int[aSN1Sequence2.size()];
                this.f8293w = new int[aSN1Sequence3.size()];
                this.f8291k = new int[aSN1Sequence4.size()];
                for (int i = 0; i < this.f8292t; i++) {
                    this.f8290h[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence2.getObjectAt(i));
                    this.f8293w[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence3.getObjectAt(i));
                    this.f8291k[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence4.getObjectAt(i));
                }
                return;
            }
            throw new IllegalArgumentException("invalid size of sequences");
        }
        throw new IllegalArgumentException("sie of seqOfParams = " + aSN1Sequence.size());
    }

    private static int checkBigIntegerInIntRangeAndPositive(ASN1Encodable aSN1Encodable) {
        int intValueExact = ((ASN1Integer) aSN1Encodable).intValueExact();
        if (intValueExact > 0) {
            return intValueExact;
        }
        throw new IllegalArgumentException("BigInteger not in Range: " + intValueExact);
    }

    public static ParSet getInstance(Object obj) {
        if (obj instanceof ParSet) {
            return (ParSet) obj;
        }
        if (obj != null) {
            return new ParSet(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int[] getH() {
        return Arrays.clone(this.f8290h);
    }

    public int[] getK() {
        return Arrays.clone(this.f8291k);
    }

    public int getT() {
        return this.f8292t;
    }

    public int[] getW() {
        return Arrays.clone(this.f8293w);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            int[] iArr = this.f8290h;
            if (i < iArr.length) {
                aSN1EncodableVector.add(new ASN1Integer((long) iArr[i]));
                aSN1EncodableVector2.add(new ASN1Integer((long) this.f8293w[i]));
                aSN1EncodableVector3.add(new ASN1Integer((long) this.f8291k[i]));
                i++;
            } else {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.add(new ASN1Integer((long) this.f8292t));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector2));
                aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector3));
                return new DERSequence(aSN1EncodableVector4);
            }
        }
    }
}
