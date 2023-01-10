package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {

    /* renamed from: g */
    private final GF2Matrix f8287g;

    /* renamed from: n */
    private final int f8288n;

    /* renamed from: t */
    private final int f8289t;

    public McEliecePublicKey(int i, int i2, GF2Matrix gF2Matrix) {
        this.f8288n = i;
        this.f8289t = i2;
        this.f8287g = new GF2Matrix(gF2Matrix);
    }

    private McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.f8288n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f8289t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f8287g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f8287g);
    }

    public int getN() {
        return this.f8288n;
    }

    public int getT() {
        return this.f8289t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f8288n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f8289t));
        aSN1EncodableVector.add(new DEROctetString(this.f8287g.getEncoded()));
        return new DERSequence(aSN1EncodableVector);
    }
}
