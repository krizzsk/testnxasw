package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.h */
class C20097h extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f56122a;

    public C20097h(X509Certificate x509Certificate) {
        this.f56122a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f56122a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f56122a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f56122a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f56122a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f56122a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f56122a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f56122a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f56122a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f56122a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f56122a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f56122a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f56122a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f56122a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f56122a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f56122a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f56122a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f56122a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f56122a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f56122a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f56122a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f56122a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f56122a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f56122a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f56122a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f56122a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f56122a.verify(publicKey, str);
    }
}
