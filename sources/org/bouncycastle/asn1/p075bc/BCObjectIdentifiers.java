package org.bouncycastle.asn1.p075bc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* renamed from: org.bouncycastle.asn1.bc.BCObjectIdentifiers */
public interface BCObjectIdentifiers {

    /* renamed from: bc */
    public static final ASN1ObjectIdentifier f7494bc;
    public static final ASN1ObjectIdentifier bc_exch;
    public static final ASN1ObjectIdentifier bc_ext;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12 = bc_pbe_sha1.branch("2");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc = bc_pbe_sha1_pkcs12.branch("1.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc = bc_pbe_sha1_pkcs12.branch("1.22");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc = bc_pbe_sha1_pkcs12.branch("1.42");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5 = bc_pbe_sha1.branch("1");
    public static final ASN1ObjectIdentifier bc_pbe_sha224 = bc_pbe.branch("2.4");
    public static final ASN1ObjectIdentifier bc_pbe_sha256 = bc_pbe.branch("2.1");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12 = bc_pbe_sha256.branch("2");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc = bc_pbe_sha256_pkcs12.branch("1.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc = bc_pbe_sha256_pkcs12.branch("1.22");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc = bc_pbe_sha256_pkcs12.branch("1.42");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5 = bc_pbe_sha256.branch("1");
    public static final ASN1ObjectIdentifier bc_pbe_sha384 = bc_pbe.branch("2.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha512 = bc_pbe.branch("2.3");
    public static final ASN1ObjectIdentifier bc_sig;
    public static final ASN1ObjectIdentifier linkedCertificate;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier qTESLA;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_I;
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_III_size = qTESLA.branch("2");
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_III_speed = qTESLA.branch("3");
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_p_I = qTESLA.branch("4");
    public static final ASN1ObjectIdentifier qTESLA_Rnd1_p_III = qTESLA.branch("5");
    public static final ASN1ObjectIdentifier qTESLA_p_I = qTESLA.branch("11");
    public static final ASN1ObjectIdentifier qTESLA_p_III = qTESLA.branch("12");
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512 = sphincs256.branch("3");
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512 = sphincs256.branch("2");
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256 = xmss.branch("5");
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512 = xmss.branch("6");
    public static final ASN1ObjectIdentifier xmss_SHA512ph = xmss.branch("2");
    public static final ASN1ObjectIdentifier xmss_SHAKE128 = xmss.branch("7");
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph = xmss.branch("3");
    public static final ASN1ObjectIdentifier xmss_SHAKE256 = xmss.branch("8");
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph = xmss.branch("4");
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256 = xmss_mt.branch("5");
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512 = xmss_mt.branch("6");
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph = xmss_mt.branch("2");
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128 = xmss_mt.branch("7");
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128ph = xmss_mt.branch("3");
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256ph = xmss_mt.branch("4");
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA256 = xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA512 = xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE128 = xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_with_SHA256 = xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_with_SHA512 = xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE128 = xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE256 = xmss_SHAKE256ph;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        f7494bc = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        bc_pbe = branch;
        bc_pbe_sha1 = branch.branch("1");
        ASN1ObjectIdentifier branch2 = f7494bc.branch("2");
        bc_sig = branch2;
        ASN1ObjectIdentifier branch3 = branch2.branch("1");
        sphincs256 = branch3;
        sphincs256_with_BLAKE512 = branch3.branch("1");
        ASN1ObjectIdentifier branch4 = bc_sig.branch("2");
        xmss = branch4;
        xmss_SHA256ph = branch4.branch("1");
        ASN1ObjectIdentifier branch5 = bc_sig.branch("3");
        xmss_mt = branch5;
        xmss_mt_SHA256ph = branch5.branch("1");
        ASN1ObjectIdentifier branch6 = xmss_mt.branch("8");
        xmss_mt_SHAKE256 = branch6;
        xmss_mt_with_SHAKE256 = branch6;
        ASN1ObjectIdentifier branch7 = bc_sig.branch("4");
        qTESLA = branch7;
        qTESLA_Rnd1_I = branch7.branch("1");
        ASN1ObjectIdentifier branch8 = f7494bc.branch("3");
        bc_exch = branch8;
        newHope = branch8.branch("1");
        ASN1ObjectIdentifier branch9 = f7494bc.branch("4");
        bc_ext = branch9;
        linkedCertificate = branch9.branch("1");
    }
}
