package org.bouncycastle.asn1.p078x9;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* renamed from: org.bouncycastle.asn1.x9.DHDomainParameters */
public class DHDomainParameters extends ASN1Object {

    /* renamed from: g */
    private ASN1Integer f7560g;

    /* renamed from: j */
    private ASN1Integer f7561j;

    /* renamed from: p */
    private ASN1Integer f7562p;

    /* renamed from: q */
    private ASN1Integer f7563q;
    private DHValidationParms validationParms;

    public DHDomainParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParms dHValidationParms) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (bigInteger3 != null) {
            this.f7562p = new ASN1Integer(bigInteger);
            this.f7560g = new ASN1Integer(bigInteger2);
            this.f7563q = new ASN1Integer(bigInteger3);
            this.f7561j = new ASN1Integer(bigInteger4);
            this.validationParms = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    public DHDomainParameters(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3, ASN1Integer aSN1Integer4, DHValidationParms dHValidationParms) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (aSN1Integer2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (aSN1Integer3 != null) {
            this.f7562p = aSN1Integer;
            this.f7560g = aSN1Integer2;
            this.f7563q = aSN1Integer3;
            this.f7561j = aSN1Integer4;
            this.validationParms = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    private DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f7562p = ASN1Integer.getInstance(objects.nextElement());
        this.f7560g = ASN1Integer.getInstance(objects.nextElement());
        this.f7563q = ASN1Integer.getInstance(objects.nextElement());
        ASN1Encodable next = getNext(objects);
        if (next != null && (next instanceof ASN1Integer)) {
            this.f7561j = ASN1Integer.getInstance(next);
            next = getNext(objects);
        }
        if (next != null) {
            this.validationParms = DHValidationParms.getInstance(next.toASN1Primitive());
        }
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private static ASN1Encodable getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (ASN1Encodable) enumeration.nextElement();
        }
        return null;
    }

    public ASN1Integer getG() {
        return this.f7560g;
    }

    public ASN1Integer getJ() {
        return this.f7561j;
    }

    public ASN1Integer getP() {
        return this.f7562p;
    }

    public ASN1Integer getQ() {
        return this.f7563q;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.add(this.f7562p);
        aSN1EncodableVector.add(this.f7560g);
        aSN1EncodableVector.add(this.f7563q);
        ASN1Integer aSN1Integer = this.f7561j;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            aSN1EncodableVector.add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
