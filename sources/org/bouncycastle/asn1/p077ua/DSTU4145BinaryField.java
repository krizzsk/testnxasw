package org.bouncycastle.asn1.p077ua;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* renamed from: org.bouncycastle.asn1.ua.DSTU4145BinaryField */
public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j */
    private int f7516j;

    /* renamed from: k */
    private int f7517k;

    /* renamed from: l */
    private int f7518l;

    /* renamed from: m */
    private int f7519m;

    public DSTU4145BinaryField(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public DSTU4145BinaryField(int i, int i2, int i3, int i4) {
        this.f7519m = i;
        this.f7517k = i2;
        this.f7516j = i3;
        this.f7518l = i4;
    }

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f7519m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intPositiveValueExact();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f7517k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intPositiveValueExact();
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f7517k = ASN1Integer.getInstance(instance.getObjectAt(0)).intPositiveValueExact();
            this.f7516j = ASN1Integer.getInstance(instance.getObjectAt(1)).intPositiveValueExact();
            this.f7518l = ASN1Integer.getInstance(instance.getObjectAt(2)).intPositiveValueExact();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getK1() {
        return this.f7517k;
    }

    public int getK2() {
        return this.f7516j;
    }

    public int getK3() {
        return this.f7518l;
    }

    public int getM() {
        return this.f7519m;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer((long) this.f7519m));
        if (this.f7516j == 0) {
            aSN1EncodableVector.add(new ASN1Integer((long) this.f7517k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f7517k));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f7516j));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f7518l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
