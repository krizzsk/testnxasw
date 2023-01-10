package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.p060a.BCRSAPrivateKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.Curve;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.JOSEException;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private Object f3188a = null;

    /* renamed from: b */
    private KeyAgreementSpi.X448withSHA384CKDF f3189b = new KeyAgreementSpi.X448withSHA384CKDF();

    /* renamed from: c */
    private String f3190c = "ECGOST3410-2012";

    /* renamed from: d */
    private BCRSAPrivateKey f3191d;

    /* renamed from: e */
    private boolean f3192e = false;

    public KeyPairGeneratorSpi() {
        super("ECGOST3410-2012");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        Object obj = this.f3188a;
        if (obj != null) {
            try {
                initialize((ECGenParameterSpec) obj, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        } else {
            throw new InvalidParameterException("unknown key size.");
        }
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof JOSEException) {
            m2198a((JOSEException) algorithmParameterSpec, secureRandom);
        } else if (algorithmParameterSpec instanceof Container) {
            Container container = (Container) algorithmParameterSpec;
            this.f3188a = algorithmParameterSpec;
            BCRSAPrivateKey bCRSAPrivateKey = new BCRSAPrivateKey(new BCRSAPublicKey(container.init, container.Cardinal, container.getInstance, container.cca_continue), secureRandom);
            this.f3191d = bCRSAPrivateKey;
            this.f3189b.cca_continue(bCRSAPrivateKey);
            this.f3192e = true;
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            this.f3188a = algorithmParameterSpec;
            getSDKAppID Cardinal = EC5Util.Cardinal(eCParameterSpec.getCurve());
            BCRSAPrivateKey bCRSAPrivateKey2 = new BCRSAPrivateKey(new BCRSAPublicKey(Cardinal, EC5Util.init(Cardinal, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), secureRandom);
            this.f3191d = bCRSAPrivateKey2;
            this.f3189b.cca_continue(bCRSAPrivateKey2);
            this.f3192e = true;
        } else {
            boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (z || (algorithmParameterSpec instanceof Curve)) {
                m2198a(new JOSEException(z ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : null), secureRandom);
            } else if (algorithmParameterSpec == null && JWK.getInstance.cca_continue() != null) {
                Container cca_continue = JWK.getInstance.cca_continue();
                this.f3188a = algorithmParameterSpec;
                BCRSAPrivateKey bCRSAPrivateKey3 = new BCRSAPrivateKey(new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue), secureRandom);
                this.f3191d = bCRSAPrivateKey3;
                this.f3189b.cca_continue(bCRSAPrivateKey3);
                this.f3192e = true;
            } else if (algorithmParameterSpec == null && JWK.getInstance.cca_continue() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            } else {
                StringBuilder sb = new StringBuilder("parameter object not a ECParameterSpec: ");
                sb.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidAlgorithmParameterException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    private void m2198a(JOSEException jOSEException, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        BCRSAPublicKey init = KeyAgreementSpi.DHwithRFC2631KDF.init(jOSEException.getInstance);
        if (init != null) {
            this.f3188a = new Base64URL(KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(jOSEException.getInstance), init.Cardinal, init.init, init.cca_continue, init.getInstance, init.init());
            BCRSAPrivateKey bCRSAPrivateKey = new BCRSAPrivateKey(new CipherSpi.ISO9796d1Padding(new CipherSpi.PKCS1v1_5Padding_PublicOnly(jOSEException.getInstance, init), jOSEException.getInstance, jOSEException.init, (ASN1ObjectIdentifier) null), secureRandom);
            this.f3191d = bCRSAPrivateKey;
            this.f3189b.cca_continue(bCRSAPrivateKey);
            this.f3192e = true;
            return;
        }
        StringBuilder sb = new StringBuilder("unknown curve: ");
        sb.append(jOSEException.getInstance);
        throw new InvalidAlgorithmParameterException(sb.toString());
    }

    public KeyPair generateKeyPair() {
        if (this.f3192e) {
            ExtendedInvalidKeySpecException init = this.f3189b.init();
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) init.Cardinal;
            DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) init.cca_continue;
            Object obj = this.f3188a;
            if (obj instanceof Container) {
                Container container = (Container) obj;
                BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = new BCECGOST3410_2012PublicKey(this.f3190c, digestSignatureSpi, container);
                return new KeyPair(bCECGOST3410_2012PublicKey, new BCECGOST3410_2012PrivateKey(this.f3190c, md2, bCECGOST3410_2012PublicKey, container));
            } else if (obj == null) {
                return new KeyPair(new BCECGOST3410_2012PublicKey(this.f3190c, digestSignatureSpi), new BCECGOST3410_2012PrivateKey(this.f3190c, md2));
            } else {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey2 = new BCECGOST3410_2012PublicKey(this.f3190c, digestSignatureSpi, eCParameterSpec);
                return new KeyPair(bCECGOST3410_2012PublicKey2, new BCECGOST3410_2012PrivateKey(this.f3190c, md2, bCECGOST3410_2012PublicKey2, eCParameterSpec));
            }
        } else {
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
    }
}
