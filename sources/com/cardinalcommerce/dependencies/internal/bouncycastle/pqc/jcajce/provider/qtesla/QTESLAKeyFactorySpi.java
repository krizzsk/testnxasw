package com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.jcajce.provider.qtesla;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.p060a.setDuplicateParentStateEnabled;
import com.cardinalcommerce.p060a.setLayerType;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class QTESLAKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        return new setDuplicateParentStateEnabled(privateKeyInfo);
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof setDuplicateParentStateEnabled) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else if (!(key instanceof setLayerType)) {
            StringBuilder sb = new StringBuilder("Unsupported key type: ");
            sb.append(key.getClass());
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        StringBuilder sb2 = new StringBuilder("Unknown key specification: ");
        sb2.append(cls);
        sb2.append(".");
        throw new InvalidKeySpecException(sb2.toString());
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof setDuplicateParentStateEnabled) || (key instanceof setLayerType)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return new setLayerType(subjectPublicKeyInfo);
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return new setDuplicateParentStateEnabled(PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder("Unsupported key specification: ");
            sb.append(keySpec.getClass());
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return new setLayerType(SubjectPublicKeyInfo.init(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder("Unknown key specification: ");
            sb.append(keySpec);
            sb.append(".");
            throw new InvalidKeySpecException(sb.toString());
        }
    }
}
