package org.bouncycastle.internal.asn1.bsi;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm = bsi_de.branch("1");
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160 = ecdsa_plain_signatures.branch("6");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224 = ecdsa_plain_signatures.branch("2");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256 = ecdsa_plain_signatures.branch("3");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384 = ecdsa_plain_signatures.branch("4");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_224 = ecdsa_plain_signatures.branch("8");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_256 = ecdsa_plain_signatures.branch("9");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_384 = ecdsa_plain_signatures.branch("10");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_512 = ecdsa_plain_signatures.branch("11");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512 = ecdsa_plain_signatures.branch("5");
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
    public static final ASN1ObjectIdentifier ecka_eg;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128 = ecka_eg_SessionKDF.branch("2");
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192 = ecka_eg_SessionKDF.branch("3");
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256 = ecka_eg_SessionKDF.branch("4");
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160 = ecka_eg_X963kdf.branch("6");
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224 = ecka_eg_X963kdf.branch("2");
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256 = ecka_eg_X963kdf.branch("3");
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384 = ecka_eg_X963kdf.branch("4");
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512 = ecka_eg_X963kdf.branch("5");
    public static final ASN1ObjectIdentifier id_ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1.1");
        id_ecc = branch;
        ASN1ObjectIdentifier branch2 = branch.branch("4.1");
        ecdsa_plain_signatures = branch2;
        ecdsa_plain_SHA1 = branch2.branch("1");
        ASN1ObjectIdentifier branch3 = id_ecc.branch("5.1");
        ecka_eg = branch3;
        ASN1ObjectIdentifier branch4 = branch3.branch("1");
        ecka_eg_X963kdf = branch4;
        ecka_eg_X963kdf_SHA1 = branch4.branch("1");
        ASN1ObjectIdentifier branch5 = ecka_eg.branch("2");
        ecka_eg_SessionKDF = branch5;
        ecka_eg_SessionKDF_3DES = branch5.branch("1");
    }
}
