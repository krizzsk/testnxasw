package com.iproov.sdk.crypto;

import android.content.Context;
import android.os.Build;
import android.security.KeyChain;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.iproov.sdk.logging.IPLog;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import p069native.C2947if;

/* renamed from: com.iproov.sdk.crypto.if */
/* compiled from: KeyStoreManager */
public final class C20899if {

    /* renamed from: a */
    private static final String f57197a = ("🗝 " + C20899if.class.getSimpleName());

    /* renamed from: b */
    private static C20899if f57198b;

    /* renamed from: c */
    private final Context f57199c;

    /* renamed from: d */
    private final KeyStore f57200d;

    /* renamed from: e */
    private final KeyPair f57201e;

    private C20899if(Context context) throws C20898for {
        this.f57199c = context.getApplicationContext();
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f57200d = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
            C2947if ifVar = new C2947if(context);
            if (m48141this() && ifVar.m46611catch() && m48140new()) {
                ifVar.m46619super();
            }
            KeyPair a = m43456a();
            this.f57201e = a;
            if (a.getPublic() == null) {
                throw new IllegalStateException("Public Key cannot be null");
            } else if (a.getPrivate() == null) {
                throw new IllegalStateException("Private Key cannot be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new C20898for(e);
        }
    }

    /* renamed from: a */
    private KeyPair m43456a() throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, C20898for {
        if (!this.f57200d.containsAlias("com.iproov.sdk")) {
            return m43461d();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return m43458b(this.f57200d);
        }
        return m43457a(this.f57200d);
    }

    /* renamed from: b */
    private boolean m43459b() {
        PrivateKey privateKey = this.f57201e.getPrivate();
        try {
            return ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
        } catch (Exception e) {
            IPLog.m43494w(f57197a, "Error retrieving key info");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private boolean m43460c() {
        return KeyChain.isBoundKeyAlgorithm("EC");
    }

    /* renamed from: d */
    private KeyPair m43461d() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i = Build.VERSION.SDK_INT;
        KeyPairGenerator instance = KeyPairGenerator.getInstance(i > 23 ? "EC" : "RSA", "AndroidKeyStore");
        if (i > 23) {
            algorithmParameterSpec = m43464e();
        } else {
            algorithmParameterSpec = m43465f();
        }
        instance.initialize(algorithmParameterSpec);
        return instance.generateKeyPair();
    }

    /* renamed from: do */
    public static synchronized C20899if m43463do(Context context) throws C20898for {
        C20899if ifVar;
        synchronized (C20899if.class) {
            if (f57198b == null) {
                f57198b = new C20899if(context);
            }
            ifVar = f57198b;
        }
        return ifVar;
    }

    /* renamed from: e */
    private AlgorithmParameterSpec m43464e() {
        KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder("com.iproov.sdk", 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"});
        if (Build.VERSION.SDK_INT >= 28 && this.f57199c.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
            digests.setIsStrongBoxBacked(false);
        }
        return digests.build();
    }

    /* renamed from: g */
    private Signature m43466g() throws NoSuchAlgorithmException {
        try {
            return Signature.getInstance("SHA256withECDSA", Build.VERSION.SDK_INT >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            m43467h();
            return Signature.getInstance("SHA256withECDSA");
        }
    }

    /* renamed from: h */
    private static void m43467h() {
        Provider[] providers = Security.getProviders();
        StringBuilder sb = new StringBuilder();
        sb.append("Services available for SHA256withECDSA algorithm: [");
        for (Provider service : providers) {
            Provider.Service service2 = service.getService("Signature", "SHA256withECDSA");
            if (service2 != null) {
                sb.append(service2.toString());
            }
        }
        sb.append(Const.jaRight);
        IPLog.m43494w(f57197a, sb.toString());
    }

    /* renamed from: break  reason: not valid java name */
    public boolean m48138break() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 23) {
                boolean c = m43460c();
                return c;
            }
            boolean b = m43459b();
            return b;
        }
    }

    /* renamed from: else  reason: not valid java name */
    public PublicKey m48139else() {
        return new PublicKey(this.f57201e.getPublic());
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m48140new() {
        try {
            this.f57200d.deleteEntry("com.iproov.sdk");
            return true;
        } catch (KeyStoreException e) {
            IPLog.m43490e(f57197a, e.getLocalizedMessage());
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: this  reason: not valid java name */
    public boolean m48141this() {
        return Build.VERSION.SDK_INT >= 28 && this.f57199c.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore");
    }

    /* renamed from: try  reason: not valid java name */
    public Context m48142try() {
        return this.f57199c;
    }

    /* renamed from: do */
    public synchronized byte[] mo171529do(byte[] bArr) throws C20898for {
        Signature g;
        try {
            g = m43466g();
            g.initSign(this.f57201e.getPrivate());
            g.update(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C20898for(e);
        }
        return g.sign();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return r1;
     */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.iproov.sdk.crypto.C20897do m43462do(com.iproov.sdk.crypto.C20899if r1) {
        /*
            java.lang.Class<com.iproov.sdk.crypto.if> r0 = com.iproov.sdk.crypto.C20899if.class
            monitor-enter(r0)
            if (r1 != 0) goto L_0x0009
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C20897do.UNSUPPORTED     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r1
        L_0x0009:
            boolean r1 = r1.m48138break()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0012
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C20897do.HARDWARE     // Catch:{ all -> 0x0016 }
            goto L_0x0014
        L_0x0012:
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C20897do.SOFTWARE     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)
            return r1
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.crypto.C20899if.m43462do(com.iproov.sdk.crypto.if):com.iproov.sdk.crypto.do");
    }

    /* renamed from: b */
    private KeyPair m43458b(KeyStore keyStore) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        Key key = keyStore.getKey("com.iproov.sdk", (char[]) null);
        Certificate certificate = keyStore.getCertificate("com.iproov.sdk");
        if (key instanceof PrivateKey) {
            return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
        }
        throw new IllegalStateException("Unsupported Key type");
    }

    /* renamed from: f */
    private AlgorithmParameterSpec m43465f() throws NoSuchAlgorithmException {
        return new KeyPairGeneratorSpec.Builder(this.f57199c).setAlias("com.iproov.sdk").setSubject(new X500Principal("CN=com.iproov.sdk")).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setSerialNumber(new BigInteger(25, new SecureRandom())).setStartDate(new Date(0)).setEndDate(new Date(2461449600000L)).setKeyType("EC").build();
    }

    /* renamed from: a */
    private KeyPair m43457a(KeyStore keyStore) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, C20898for {
        try {
            KeyStore.Entry entry = keyStore.getEntry("com.iproov.sdk", (KeyStore.ProtectionParameter) null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
                return new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
            throw new IllegalStateException("Unsupported Key type");
        } catch (NullPointerException e) {
            throw new C20898for(e);
        }
    }
}
