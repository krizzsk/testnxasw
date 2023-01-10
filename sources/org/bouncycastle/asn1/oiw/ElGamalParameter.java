package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f7509g;

    /* renamed from: p */
    ASN1Integer f7510p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f7510p = new ASN1Integer(bigInteger);
        this.f7509g = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f7510p = (ASN1Integer) objects.nextElement();
        this.f7509g = (ASN1Integer) objects.nextElement();
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f7509g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f7510p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.f7510p);
        aSN1EncodableVector.add(this.f7509g);
        return new DERSequence(aSN1EncodableVector);
    }
}
