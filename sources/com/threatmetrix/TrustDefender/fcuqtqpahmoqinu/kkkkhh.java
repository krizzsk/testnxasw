package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import android.content.Context;
import android.security.KeyChain;
import android.security.KeyPairGeneratorSpec;
import com.threatmetrix.TrustDefender.TMXStrongAuth;
import com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.x500.X500Principal;
import org.osgi.framework.VersionRange;

public class kkkkhh {
    private static final String b00740074t00740074t;
    public static int b00780078x0078xx = 2;
    public static int b0078xx0078xx = bxx00780078xx();
    private static final String bt0074t00740074t;
    private static final String btt007400740074t;
    public static int bx0078x0078xx = 1;
    public static int bxxx0078xx = 42;

    /* renamed from: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh$2 */
    public static /* synthetic */ class C215742 {
        public static final /* synthetic */ int[] b00740074007400740074t;
        public static int b00780078007800780078x = 55;
        public static int b0078xxxx0078 = 1;
        public static int bx0078xxx0078 = 2;
        public static int bxxxxx0078 = 64;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|(1:7)|8|9|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
        static {
            /*
                com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus[] r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b00740074007400740074t = r0
                com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r1 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = b00740074007400740074t     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r1 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r0 = b00780078007800780078x
                int r1 = b0078xxxx0078
                int r1 = r1 + r0
                int r1 = r1 * r0
                int r0 = bx0078xxx0078
                int r1 = r1 % r0
                int r0 = bxxxxx0078
                if (r1 == r0) goto L_0x0033
                r0 = 55
                b00780078007800780078x = r0
                r0 = 64
                bxxxxx0078 = r0
            L_0x0033:
                int[] r0 = b00740074007400740074t     // Catch:{ NoSuchFieldError -> 0x003e }
                com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r1 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_CANCELLED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.C215742.<clinit>():void");
        }
    }

    public private static class hkhhkh implements kkhhkh {
        public static int b007800780078xx0078 = 0;
        public static int b00780078xxx0078 = 51;
        public static int b0078x0078xx0078 = 2;
        public static int bxx0078xx0078 = 1;
        public final BigInteger b0074tttt0074;
        public final byte[] bt0074ttt0074;
        @Nonnull
        public final PrivateKey bttttt0074;

        public hkhhkh(@Nonnull PrivateKey privateKey, BigInteger bigInteger, byte[] bArr) {
            this.bttttt0074 = privateKey;
            this.b0074tttt0074 = bigInteger;
            this.bt0074ttt0074 = bArr;
        }

        public static int bx00780078xx0078() {
            return 75;
        }

        public byte[] getOid() {
            try {
                byte[] bjjj006A006A006A = kkkkhh.bjjj006A006A006A(this.bttttt0074);
                int i = b00780078xxx0078;
                if (((bxx0078xx0078 + i) * i) % b0078x0078xx0078 != b007800780078xx0078) {
                    b00780078xxx0078 = bx00780078xx0078();
                    b007800780078xx0078 = bx00780078xx0078();
                }
                return bjjj006A006A006A;
            } catch (Exception e) {
                throw e;
            }
        }

        public BigInteger getSerialNumber() {
            return this.b0074tttt0074;
        }

        public byte[] getSubject() {
            return this.bt0074ttt0074;
        }

        public byte[] signData(byte[] bArr) {
            int i = b00780078xxx0078;
            if ((i * (bxx0078xx0078 + i)) % b0078x0078xx0078 != 0) {
                b00780078xxx0078 = bx00780078xx0078();
                bxx0078xx0078 = 78;
            }
            return kkkkhh.b006A006A006Aj006A006A(this.bttttt0074, bArr);
        }
    }

    public private interface kkhhkh {
        byte[] getOid();

        BigInteger getSerialNumber();

        byte[] getSubject();

        byte[] signData(byte[] bArr);
    }

    static {
        try {
            b00740074t00740074t = khhkhk.bqqqqq0071("/[P]YRL2K^7WQSE", 6, 4);
            try {
                btt007400740074t = khhkhk.b00710071007100710071q("\u0006%)(*z\u001d\u001f\u001f) \"0\u0012\u0004\f\u00157644.\t>>3", 207, 158, 0);
                bt0074t00740074t = hkkhhh.bjjjjj006A(kkkkhh.class);
                int i = bxxx0078xx;
                if (((bx0078x0078xx + i) * i) % b00780078x0078xx != b0078xx0078xx) {
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ byte[] b006A006A006Aj006A006A(PrivateKey privateKey, byte[] bArr) {
        int i = bxxx0078xx;
        if (((bx0078x0078xx + i) * i) % b0078x0078x0078x() != b0078xx0078xx) {
            bxxx0078xx = bxx00780078xx();
            b0078xx0078xx = 81;
        }
        return b007100710071qqq(privateKey, bArr);
    }

    public static TMXStrongAuth.AuthenticationStatus b006A006Aj006A006A006A(Context context, String str, String str2, @Nullable TMXStrongAuth.StrongAuthCallback strongAuthCallback) {
        if (strongAuthCallback == null || kkhkhh.btt0074t0074t < 21) {
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE;
        }
        while (true) {
            String str3 = null;
            try {
                str3.length();
            } catch (Exception unused) {
                bxxx0078xx = 23;
                return hhkkhh.b006A006Ajj006A006A(context, str, str2, strongAuthCallback);
            }
        }
    }

    private static TMXStrongAuth.AuthParamResult b006Aj006A006A006A006A(@Nonnull Context context, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull byte[] bArr, @Nonnull TMXStrongAuth.AuthMethod authMethod, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, boolean z, PrivateKey privateKey, long j) {
        Context context2 = context;
        String str4 = str2;
        String str5 = str3;
        TMXStrongAuth.StrongAuthCallback strongAuthCallback2 = strongAuthCallback;
        TMXStrongAuth.AuthenticationStatus b006A006Aj006A006A006A = b006A006Aj006A006A006A(context, str2, str3, strongAuthCallback);
        int i = C215742.b00740074007400740074t[b006A006Aj006A006A006A.ordinal()];
        if (i == 1) {
            return b0071q0071qqq(context, str, str3, bArr, authMethod, z, privateKey, j);
        }
        if (i == 2) {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.bqqqqq0071("e\by\u0006k\b8_{\u0005\t\u0013\u0011\u0005ZAc\u0019\u0019\u000e\f\u0016\u001d\u0013\u000e\r!\u0017\u001e\u001eP \"(T&&+,#\u001d(\"", 145, 0));
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.NOT_SUPPORTED, (String) null);
        } else if (i != 3) {
            String str6 = bt0074t00740074t;
            hkkhhh.kkkhhh.m44485e(str6, khhkhk.b00710071007100710071q("l\u000f\u0001\rr\u000f?f\u0003\f\u0010\u001a\u0018\faH\u000b  \u0015\u0013\u001d$\u001a\u0015\u0014(\u001e%%W,.\u001c021^)4a", 161, 'v', 3) + b006A006Aj006A006A006A);
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.STEPUP_FAILED, (String) null);
        } else {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.b00710071007100710071q("w\u001a\f\u0018}\u001aJq\u000e\u0017\u001b%#\u0017lS\n)\u001c*X\u001d\u001c* #+,&&b%::/-7>4/.B8??", 18, 'm', 0));
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.STEPUP_CANCELLED, (String) null);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b007100710071qqq(@javax.annotation.Nonnull java.security.PrivateKey r6, @javax.annotation.Nonnull byte[] r7) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkhkhh.b0074t0074t0074t     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            if (r2 != 0) goto L_0x0014
            java.lang.String r6 = bt0074t00740074t     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            java.lang.String r7 = "j\n\u0018Q L!\u0018\u0017\u001f]R&\u001a',!+\u001f\u001f[ * 34'6c&8,g79?k.D09=35@:\u0004"
            r2 = 39
            java.lang.String r7 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r7, r2, r1)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44484d(r6, r7)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            return r0
        L_0x0014:
            java.lang.String r2 = "]Z"
            r3 = 246(0xf6, float:3.45E-43)
            r4 = 4
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            java.lang.String r3 = r6.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = "(\u001e\u0018\n\u000e\u0010REQF$#%5$"
            r3 = 33
            r4 = 203(0xcb, float:2.84E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r4, r1)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            goto L_0x003b
        L_0x0032:
            java.lang.String r2 = "UIA133sdnaJJ7"
            r3 = 253(0xfd, float:3.55E-43)
            r4 = 2
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
        L_0x003b:
            java.security.Signature r2 = java.security.Signature.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            r2.initSign(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            r2.update(r7)     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            byte[] r6 = r2.sign()     // Catch:{ NoSuchAlgorithmException -> 0x0050, SignatureException -> 0x004e, InvalidKeyException -> 0x004c }
            return r6
        L_0x004a:
            r6 = move-exception
            goto L_0x0084
        L_0x004c:
            r6 = move-exception
            goto L_0x0051
        L_0x004e:
            r6 = move-exception
            goto L_0x0051
        L_0x0050:
            r6 = move-exception
        L_0x0051:
            java.lang.String r7 = bt0074t00740074t     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = "i\t\u0017P\u001fK \u0017\u0016\u001eP&\u001b\u0019T\u001f%(..Z7:"
            r3 = 49
            r4 = 11
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r4, r1)     // Catch:{ Exception -> 0x0082 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0082 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0082 }
            int r4 = bxxx0078xx
            int r5 = bx0078x0078xx
            int r5 = r5 + r4
            int r5 = r5 * r4
            int r4 = b00780078x0078xx
            int r5 = r5 % r4
            int r4 = b0078xx0078xx
            if (r5 == r4) goto L_0x007c
            int r4 = bxx00780078xx()
            bxxx0078xx = r4
            r4 = 29
            b0078xx0078xx = r4
        L_0x007c:
            r3[r1] = r6     // Catch:{ Exception -> 0x0082 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44483i((java.lang.String) r7, (java.lang.String) r2, (java.lang.String[]) r3)     // Catch:{ Exception -> 0x0082 }
            return r0
        L_0x0082:
            r6 = move-exception
            throw r6
        L_0x0084:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.b007100710071qqq(java.security.PrivateKey, byte[]):byte[]");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String, com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh$hkhhkh] */
    private static hkhhkh b00710071qqqq(@Nonnull String str) {
        BigInteger bigInteger;
        byte[] bArr;
        KeyStore.Entry b0071qqqqq = b0071qqqqq(str);
        ? r2 = 0;
        if (!(b0071qqqqq instanceof KeyStore.PrivateKeyEntry)) {
            return r2;
        }
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) b0071qqqqq;
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
        Certificate certificate = privateKeyEntry.getCertificate();
        if (certificate instanceof X509Certificate) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            bigInteger = x509Certificate.getSerialNumber();
            bArr = x509Certificate.getSubjectX500Principal().getEncoded();
        } else {
            BigInteger bigInteger2 = BigInteger.ZERO;
            while (true) {
                try {
                    r2.length();
                } catch (Exception unused) {
                    bxxx0078xx = bxx00780078xx();
                    BigInteger bigInteger3 = bigInteger2;
                    bArr = bqq0071qqq(str);
                    bigInteger = bigInteger3;
                }
            }
        }
        return new hkhhkh(privateKey, bigInteger, bArr);
    }

    private static TMXStrongAuth.AuthParamResult b0071q0071qqq(@Nonnull final Context context, @Nonnull final String str, @Nonnull String str2, @Nonnull byte[] bArr, @Nonnull TMXStrongAuth.AuthMethod authMethod, boolean z, PrivateKey privateKey, long j) {
        if (!z) {
            return hhhkhh.b006Aj006Ajj006A().b006Ajj006Aj006A() ? bqqq0071qq(str2, bArr, authMethod, new kkhhkh() {
                public static int b00780078x00780078x = 2;
                public static int bx0078x00780078x = 1;
                public static int bxxx00780078x = 3;

                public static int b0078xx00780078x() {
                    return 0;
                }

                public static int bx0078007800780078x() {
                    return 73;
                }

                public byte[] getOid() {
                    return hkhhhh.b00660066ff00660066;
                }

                public BigInteger getSerialNumber() {
                    while (true) {
                        try {
                            int[] iArr = new int[-1];
                        } catch (Exception unused) {
                            bxxx00780078x = bx0078007800780078x();
                            return BigInteger.ZERO;
                        }
                    }
                }

                public byte[] getSubject() {
                    return kkkkhh.bqq0071qqq(str);
                }

                /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|9) */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
                    r3 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
                    throw r3;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public byte[] signData(byte[] r3) {
                    /*
                        r2 = this;
                    L_0x0000:
                        r0 = -1
                        int[] r0 = new int[r0]     // Catch:{ Exception -> 0x0004 }
                        goto L_0x0000
                    L_0x0004:
                        com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hhhkhh r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hhhkhh.b006Aj006Ajj006A()     // Catch:{ Exception -> 0x0015 }
                        android.content.Context r1 = r1     // Catch:{ Exception -> 0x0013 }
                        android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x0013 }
                        byte[] r3 = r0.bjj006A006Aj006A(r3, r1)     // Catch:{ Exception -> 0x0015 }
                        return r3
                    L_0x0013:
                        r3 = move-exception
                        throw r3
                    L_0x0015:
                        r3 = move-exception
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.C215731.signData(byte[]):byte[]");
                }
            }) : TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.NOT_SUPPORTED, (String) null);
        }
        int i = bxxx0078xx;
        if ((i * (bx0078x0078xx + i)) % b00780078x0078xx != 0) {
            bxxx0078xx = bxx00780078xx();
            b0078xx0078xx = bxx00780078xx();
        }
        return privateKey == null ? TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.CONTEXT_NOT_FOUND, (String) null) : bqqq0071qq(str2, bArr, authMethod, new hkhhkh(privateKey, BigInteger.valueOf(j), bqq0071qqq(str)));
    }

    @Nonnull
    public static TMXStrongAuth.AuthParamResult b0071qq0071qq(@Nonnull Context context, @Nonnull TMXStrongAuth.AuthMethod authMethod, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull byte[] bArr, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, boolean z, PrivateKey privateKey, long j) {
        TMXStrongAuth.AuthMethod authMethod2 = authMethod;
        if (authMethod2 == TMXStrongAuth.AuthMethod.TMX_USER_PRESENCE) {
            return bj006Aj006A006A006A(context, str3, str, str2, bArr, authMethod, strongAuthCallback);
        }
        if (authMethod2 != TMXStrongAuth.AuthMethod.TMX_DEVICE_PRESENCE) {
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.MISSING_FUNCTION, (String) null);
        }
        int i = bxxx0078xx;
        if (((bx0078x0078xx + i) * i) % b0078x0078x0078x() != b0078xx0078xx) {
            bxxx0078xx = bxx00780078xx();
            b0078xx0078xx = bxx00780078xx();
        }
        return b006Aj006A006A006A006A(context, str3, str, str2, bArr, authMethod, strongAuthCallback, z, privateKey, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[ExcHandler: IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:11:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.KeyStore.Entry b0071qqqqq(@javax.annotation.Nonnull java.lang.String r4) {
        /*
            java.lang.String r0 = "#@B??\u000e..,4))5\u0015\u0005\u000b\u00122/+)!y-+\u001e"
            r1 = 176(0xb0, float:2.47E-43)
            r2 = 3
            java.lang.String r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r0, r1, r2)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = r0.concat(r4)     // Catch:{ Exception -> 0x003c }
            r0 = 0
            java.lang.String r1 = "2`Wfd_[C^sNplpd"
            r2 = 112(0x70, float:1.57E-43)
            r3 = 0
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r1, r2, r3)     // Catch:{  }
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{  }
            r1.load(r0)     // Catch:{  }
            int r2 = bxxx0078xx
            int r3 = b0078xxx0078x()
            int r3 = r3 + r2
            int r2 = r2 * r3
            int r3 = b00780078x0078xx
            int r2 = r2 % r3
            if (r2 == 0) goto L_0x0036
            r2 = 69
            bxxx0078xx = r2
            int r2 = bxx00780078xx()
            b0078xx0078xx = r2
        L_0x0036:
            java.security.KeyStore$Entry r4 = r1.getEntry(r4, r0)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException -> 0x003b, IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException -> 0x003b, IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException -> 0x003b, IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException | CertificateException -> 0x003b }
            return r4
        L_0x003b:
            return r0
        L_0x003c:
            r4 = move-exception
            throw r4
        L_0x003e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.b0071qqqqq(java.lang.String):java.security.KeyStore$Entry");
    }

    public static int b0078x0078x0078x() {
        return 2;
    }

    public static int b0078xxx0078x() {
        return 1;
    }

    @Nullable
    private static KeyPair bj006A006A006A006A006A(@Nonnull String str, @Nonnull Context context, String str2, String str3, String str4, @Nonnull BigInteger bigInteger, @Nonnull Calendar calendar, @Nonnull Calendar calendar2, boolean z, boolean z2, byte[] bArr) {
        String str5 = str;
        if (!KeyChain.isKeyAlgorithmSupported(str)) {
            return null;
        }
        if (kkhkhh.b007400740074t0074t) {
            return khkkhh.bjj006Aj006A006A(str, str2, str3, str4, bigInteger, calendar, calendar2, z, z2, bArr);
        }
        if (z2) {
            try {
                if (!KeyChain.isBoundKeyAlgorithm(str)) {
                    return null;
                }
            } catch (InvalidAlgorithmParameterException | NoSuchProviderException e) {
                hkkhhh.m44483i(bt0074t00740074t, khhkhk.b00710071007100710071q("g\u0005\u0011H\u0015?\u0002\u0010\u0002|\u000f~8b{\u000fdt{\u00040\u000b\f", 239, 21, 2), e.toString());
            } catch (NoSuchAlgorithmException e2) {
                hkkhhh.kkkhhh.bjj006A006A006Aj(bt0074t00740074t, khhkhk.bqqqqq0071("Lky3\u0002.r\u0003vs\by5a|\u0012i{\u0005\u000f=\u001a\u001d", 130, 1), e2.toString());
            } catch (IllegalStateException e3) {
                hkkhhh.kkkhhh.bjj006A006A006Aj(bt0074t00740074t, khhkhk.bqqqqq0071("a~\u000bB\u000f9{\n{v\tx2\\u\t^nu}6)ll|ngh\"js\u001fllp\u001bjkgk[XhXV\u0011Rh\u000e]M^]`WYJ\u00144,0\u0001[\\", 'a', 3), e3.toString());
            }
        }
        if (kkhkhh.btt0074t0074t >= 19 && kkhkhh.btt0074t0074t < 23 && kkhkhh.bt00740074t0074t) {
            Context context2 = context;
            String str6 = str3;
            KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(context).setAlias(str3);
            StringBuilder sb = new StringBuilder();
            sb.append(khhkhk.b00710071007100710071q("\b\u0014\u0004", 'p', 210, 3));
            String str7 = str4;
            sb.append(str4);
            KeyPairGeneratorSpec.Builder endDate = alias.setSubject(new X500Principal(sb.toString())).setSerialNumber(bigInteger).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime());
            endDate.setKeyType(str);
            if (((bxx00780078xx() + bx0078x0078xx) * bxx00780078xx()) % b00780078x0078xx != b0078xx0078xx) {
                bxxx0078xx = bxx00780078xx();
                b0078xx0078xx = bxx00780078xx();
            }
            if (z) {
                endDate.setEncryptionRequired();
            }
            String str8 = str2;
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str, str2);
            instance.initialize(endDate.build());
            return instance.generateKeyPair();
        }
        return null;
    }

    private static TMXStrongAuth.AuthParamResult bj006Aj006A006A006A(@Nonnull Context context, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull byte[] bArr, @Nonnull TMXStrongAuth.AuthMethod authMethod, @Nullable TMXStrongAuth.StrongAuthCallback strongAuthCallback) {
        TMXStrongAuth.AuthResult authResult;
        hkhhkh b00710071qqqq = b00710071qqqq(str);
        if (b00710071qqqq == null) {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.bqqqqq0071(",N@L2N~&BKOYWK!\b>]P^\rWb\u0010_ag\u0014g[^aln`nbb", 'X', 0));
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.CONTEXT_NOT_FOUND, (String) null);
        }
        int i = C215742.b00740074007400740074t[b006A006Aj006A006A006A(context, str2, str3, strongAuthCallback).ordinal()];
        if (i == 1) {
            return bqqq0071qq(str3, bArr, authMethod, b00710071qqqq);
        }
        if (i == 2) {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.bqqqqq0071("\u00199)3\u00171_\u0005\u001f&(0,\u001eqVv*(\u001b\u0017\u001f$\u0018\u0011\u000e \u0014\u0019\u0017G\u0010\u0019D\u0013\u0011\u000e\u001a?\u0005\r\u000f;[ia7HF?", 'h', 4));
            authResult = TMXStrongAuth.AuthResult.NOT_SUPPORTED;
        } else if (i != 3) {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.bqqqqq0071("\"B2< :h\u000e(/195'z_\u00141\".Z\u001e\"\u001c%\\)S#$ \u0013\u0014\u0013\u0011K\"\u0013\u001d\u0010F\u0007\u001a\u0018\u000b\u0007\u000f\u0014\b\u0001}\u0010\u0004\t\u0007", 228, 4));
            authResult = TMXStrongAuth.AuthResult.STEPUP_FAILED;
        } else {
            hkkhhh.m44481i(bt0074t00740074t, khhkhk.b00710071007100710071q("+M?K1M}%AJNXVJ \u0007=\\O]\fPO]SV^_YY\u0016Xmmb`jqgbaukrr", 204, 10, 3));
            return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.STEPUP_CANCELLED, (String) null);
        }
        return TMXStrongAuth.generateAuthParamResult(authResult, (String) null);
    }

    @Nonnull
    public static TMXStrongAuth.AuthParamResult bjj006A006A006A006A(@Nullable String str) {
        TMXStrongAuth.AuthResult authResult;
        if (hkhkhh.b006Ajjj006A006A(str)) {
            authResult = TMXStrongAuth.AuthResult.MISSING_PARAMETER;
        } else {
            String bj006Ajj006A006A = hkhkhh.bj006Ajj006A006A(str.toLowerCase().getBytes());
            if (!hkhkhh.b006Ajjj006A006A(bj006Ajj006A006A)) {
                String concat = khhkhk.bqqqqq0071(")HLKM\u001e@BBLCES5'/8ZYWWQ,aaV", 211, 0).concat(bj006Ajj006A006A);
                try {
                    KeyStore instance = KeyStore.getInstance(khhkhk.bqqqqq0071("\u001bI@OMHD,G\\7YUYM", 'l', 5));
                    instance.load((KeyStore.LoadStoreParameter) null);
                    if (!instance.containsAlias(concat)) {
                        hkkhhh.m44481i(bt0074t00740074t, khhkhk.bqqqqq0071("Ww\u0004uvw\u0001\u0001p|)Nhoqyug; Tqbn\u001bhhl\u0017hZ[\\eeUaSQ", '$', 4));
                        TMXStrongAuth.AuthResult authResult2 = TMXStrongAuth.AuthResult.CONTEXT_NOT_FOUND;
                        int i = bxxx0078xx;
                        if (((bx0078x0078xx + i) * i) % b00780078x0078xx != b0078xx0078xx) {
                            bxxx0078xx = bxx00780078xx();
                            b0078xx0078xx = 78;
                        }
                        return TMXStrongAuth.generateAuthParamResult(authResult2, (String) null);
                    }
                    instance.deleteEntry(concat);
                    return TMXStrongAuth.generateAuthParamResult(TMXStrongAuth.AuthResult.DEREGISTERED, (String) null);
                } catch (IOException | RuntimeException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
                    String str2 = bt0074t00740074t;
                    hkkhhh.kkkhhh.m44484d(str2, khhkhk.b00710071007100710071q("9YeWXYbbR^\u000b0JQS[WI\u001d\u0002$AM\u0005Q{M?FGM;t?8Kp6>@\u0007k", '4', VersionRange.RIGHT_OPEN, 2) + concat);
                }
            }
            authResult = TMXStrongAuth.AuthResult.DEREGISTRATION_FAILED;
        }
        return TMXStrongAuth.generateAuthParamResult(authResult, (String) null);
    }

    public static /* synthetic */ byte[] bjjj006A006A006A(PrivateKey privateKey) {
        int i = bxxx0078xx;
        if ((i * (bx0078x0078xx + i)) % b00780078x0078xx != 0) {
            bxxx0078xx = bxx00780078xx();
            b0078xx0078xx = 9;
        }
        try {
            return bq0071qqqq(privateKey);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:42|43|44|(5:46|47|48|49|50)(12:51|(4:53|54|55|(4:57|(2:59|(1:61))(1:62)|63|(8:65|66|67|68|69|70|71|72)(5:73|74|75|76|77))(10:78|81|82|83|84|85|(7:88|89|90|91|92|(3:93|94|95)|86)|98|99|100))(1:79)|80|81|82|83|84|85|(1:86)|98|99|100)|101|102|103) */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44484d(bt0074t00740074t, com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071("\n\u001c\u001d\u001e''\u0017#Ot\u000f\u0016\u0018 \u001c\u000eaFh\u0006\u0012I\u0016@\u0007\u0004\u0012<\u0007\u0013\f\f\u0006\by", 199, 3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x024f, code lost:
        return com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED, (java.lang.String) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x022a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x023a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f9 A[Catch:{ KeyStoreException | CertificateException -> 0x022a }] */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.threatmetrix.TrustDefender.TMXStrongAuth.AuthParamResult bq00710071qqq(@javax.annotation.Nonnull android.content.Context r21, @javax.annotation.Nonnull java.lang.String r22, @javax.annotation.Nonnull java.lang.String r23, @javax.annotation.Nullable java.lang.String r24, @javax.annotation.Nonnull byte[] r25, @javax.annotation.Nullable com.threatmetrix.TrustDefender.TMXStrongAuth.StrongAuthCallback r26) {
        /*
            boolean r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.b006Ajjj006A006A(r24)     // Catch:{ Exception -> 0x0252 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.MISSING_PARAMETER     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x000e:
            java.lang.String r0 = r24.toLowerCase()     // Catch:{ Exception -> 0x0252 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0252 }
            java.lang.String r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006Ajj006A006A(r0)     // Catch:{ Exception -> 0x0252 }
            if (r0 != 0) goto L_0x0023
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x0023:
            java.security.KeyStore$Entry r2 = b0071qqqqq(r0)     // Catch:{ Exception -> 0x0252 }
            boolean r2 = r2 instanceof java.security.KeyStore.PrivateKeyEntry     // Catch:{ Exception -> 0x0252 }
            r13 = 0
            if (r2 == 0) goto L_0x0040
            java.lang.String r0 = bt0074t00740074t     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "Thkny{m{*Qmvz\u0005\u0003vL3i\t{\n8z\u0007\u000e\u0002~\u0003\u0019@\u0014\b\u000b\u000e\u0019\u001b\r\u001b\u000f\u000f"
            r3 = 129(0x81, float:1.81E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r13)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44481i(r0, r2)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.ALREADY_REGISTERED     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x0040:
            r14 = r21
            r2 = r22
            r3 = r23
            r4 = r26
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r2 = b006A006Aj006A006A006A(r14, r2, r3, r4)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r3 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE     // Catch:{ Exception -> 0x0252 }
            r15 = 3
            if (r2 != r3) goto L_0x0065
            java.lang.String r0 = bt0074t00740074t     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "+=>?HH8Dp\u0016079A=/\u0003g\u001559c6710.01!\u001feX\u0019,*\u001d\u0019!&\u001a\u0013\u0010\"\u0016\u001b\u0019I\u0018\u0016\u0013\u001fD\u0014\u0012\u0015\u0014\t\u0001\n\u0002;\n\b8\bw\t\b\u000b\u0002\u0004t/~{ol|lj%hhxjcdq\u001d$<JB\u0018)' \u001d"
            r3 = 39
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r15)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44481i(r0, r2)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.NOT_SUPPORTED     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x0065:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r3 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_CANCELLED     // Catch:{ Exception -> 0x0252 }
            r12 = 1
            if (r2 != r3) goto L_0x0080
            java.lang.String r0 = bt0074t00740074t     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "N`abkk[g\u00149SZ\\d`R&\u000b?\\MY\u0006HEQEFLKCA{<OM@<DI=63E9><"
            r3 = 155(0x9b, float:2.17E-43)
            r4 = 230(0xe6, float:3.22E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r4, r12)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44481i(r0, r2)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_CANCELLED     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x0080:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthenticationStatus r3 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_OK     // Catch:{ Exception -> 0x0252 }
            if (r2 == r3) goto L_0x009a
            java.lang.String r0 = bt0074t00740074t     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "G[^aln`n\u001dD`imwui?&\\{n|+pvr}7\u00062\u0004\u0007\u0005y|}}:\u0013\u0006\u0012\u0007?\u0002\u0017\u0017\f\n\u0014\u001b\u0011\f\u000b\u001f\u0015\u001c\u001c"
            r3 = 116(0x74, float:1.63E-43)
            r4 = 254(0xfe, float:3.56E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r4, r13)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44481i(r0, r2)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0252 }
            return r0
        L_0x009a:
            java.lang.String r2 = "r!\u0018'% \u001c\u0004\u001f4\u000f1-1%"
            r3 = 88
            r11 = 5
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r11)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x023a }
            java.security.KeyStore r10 = java.security.KeyStore.getInstance(r2)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x023a }
            r10.load(r1)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x023a }
            java.math.BigInteger r9 = new java.math.BigInteger     // Catch:{ Exception -> 0x0252 }
            r2 = 32
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0252 }
            r3.<init>()     // Catch:{ Exception -> 0x0252 }
            r9.<init>(r2, r3)     // Catch:{ Exception -> 0x0252 }
            java.util.Calendar r16 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0252 }
            java.util.Calendar r8 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0252 }
            r8.add(r12, r11)     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "\u0003 \"\u001f\u001fm\u000e\u000e\f\u0014\t\t\u0015tdjq\u0012\u000f\u000b\t\u0001Y\r\u000b}"
            r3 = 231(0xe7, float:3.24E-43)
            r7 = 2
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r7)     // Catch:{ Exception -> 0x0252 }
            java.lang.String r6 = r2.concat(r0)     // Catch:{ Exception -> 0x0252 }
            java.lang.String r2 = "mj"
            r5 = 234(0xea, float:3.28E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r5, r7)     // Catch:{ Exception -> 0x0252 }
            java.lang.String r3 = "&RGTPIC)BU.NHJ<"
            r4 = 27
            java.lang.String r4 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r3, r4, r15)     // Catch:{ Exception -> 0x0252 }
            r17 = 1
            r18 = 1
            r3 = r21
            r15 = 234(0xea, float:3.28E-43)
            r5 = r6
            r23 = r6
            r6 = r0
            r7 = r9
            r19 = r8
            r8 = r16
            r20 = r9
            r9 = r19
            r1 = r10
            r10 = r17
            r15 = 5
            r11 = r18
            r13 = 1
            r12 = r25
            java.security.KeyPair r2 = bj006A006A006A006A006A(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0252 }
            if (r2 != 0) goto L_0x0125
            java.lang.String r2 = "NP?"
            r3 = 125(0x7d, float:1.75E-43)
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r2, r3, r15)     // Catch:{ Exception -> 0x0252 }
            java.lang.String r3 = ")WN][VR:UjEgcg["
            r4 = 246(0xf6, float:3.45E-43)
            java.lang.String r4 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r3, r4, r13)     // Catch:{ Exception -> 0x0252 }
            r10 = 1
            r11 = 1
            r3 = r21
            r5 = r23
            r6 = r0
            r7 = r20
            r8 = r16
            r9 = r19
            r12 = r25
            java.security.KeyPair r2 = bj006A006A006A006A006A(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0252 }
        L_0x0125:
            if (r2 != 0) goto L_0x014d
            java.lang.String r2 = "-,"
            r3 = 111(0x6f, float:1.56E-43)
            r4 = 135(0x87, float:1.89E-43)
            r5 = 0
            java.lang.String r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r4, r5)     // Catch:{ Exception -> 0x0250 }
            java.lang.String r3 = "\u00053*972.\u00161F!C?C7"
            r4 = 234(0xea, float:3.28E-43)
            java.lang.String r4 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r3, r4, r13)     // Catch:{ Exception -> 0x0250 }
            r10 = 1
            r11 = 0
            r3 = r21
            r5 = r23
            r6 = r0
            r7 = r20
            r8 = r16
            r9 = r19
            r12 = r25
            java.security.KeyPair r2 = bj006A006A006A006A006A(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0250 }
        L_0x014d:
            if (r2 == 0) goto L_0x0232
            java.security.PrivateKey r0 = r2.getPrivate()     // Catch:{ Exception -> 0x0250 }
            if (r0 == 0) goto L_0x0232
            java.security.PublicKey r0 = r2.getPublic()     // Catch:{ Exception -> 0x0250 }
            if (r0 != 0) goto L_0x015d
            goto L_0x0232
        L_0x015d:
            r0 = r23
            java.security.cert.Certificate[] r0 = r1.getCertificateChain(r0)     // Catch:{  }
            int r1 = r0.length     // Catch:{  }
            if (r1 != 0) goto L_0x016e
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{  }
            r1 = 0
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            return r0
        L_0x016e:
            int r1 = r0.length     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            if (r1 != r13) goto L_0x01da
            r1 = 0
            r3 = r0[r1]     // Catch:{  }
            boolean r3 = r3 instanceof java.security.cert.X509Certificate     // Catch:{  }
            if (r3 == 0) goto L_0x01d8
            r3 = r0[r1]     // Catch:{  }
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch:{  }
            byte[] r1 = r3.getSignature()     // Catch:{  }
            if (r1 == 0) goto L_0x0187
            int r1 = r1.length     // Catch:{  }
            r4 = 2
            if (r1 > r4) goto L_0x01db
            goto L_0x0188
        L_0x0187:
            r4 = 2
        L_0x0188:
            byte[] r0 = r3.getTBSCertificate()     // Catch:{  }
            java.security.PrivateKey r1 = r2.getPrivate()     // Catch:{  }
            byte[] r1 = b007100710071qqq(r1, r0)     // Catch:{  }
            if (r1 != 0) goto L_0x01ab
            java.lang.String r0 = bt0074t00740074t     // Catch:{  }
            java.lang.String r1 = "aXW_Sgig[\u0017al\u001aiqij\u001frfvxvsouo)K\u0001\u0001u`t\u0004\u0007~\bBg[^alnm]qgnn\u0001hdmqkk"
            r2 = 121(0x79, float:1.7E-43)
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r1, r2, r13)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44485e(r0, r1)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            r1 = 0
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{  }
            return r0
        L_0x01ab:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{  }
            r5 = 0
            r3[r5] = r0     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            java.security.PrivateKey r0 = r2.getPrivate()     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            byte[] r0 = bq0071qqqq(r0)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            r3[r13] = r0     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            byte[] r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.b006A006Ajj006Aj(r1)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            r3[r4] = r0     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            java.util.List r0 = java.util.Arrays.asList(r3)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            byte[] r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006A006Ajj(r0)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r1 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTERED     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            java.lang.String r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006A006A006Aj006A(r0)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r1, r0)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            return r0
        L_0x01d8:
            r4 = 2
            goto L_0x01dc
        L_0x01da:
            r4 = 2
        L_0x01db:
            r1 = 0
        L_0x01dc:
            r1 = r0[r1]     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            byte[] r1 = r1.getEncoded()     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
            int r3 = r1.length     // Catch:{  }
            int r3 = r3 * 2
            int r3 = r3 + r13
            int r5 = r0.length     // Catch:{  }
            int r3 = r3 * r5
            r2.<init>(r3)     // Catch:{  }
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006A006A006Aj006A(r1)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            r2.append(r1)     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            r12 = 1
        L_0x01f6:
            int r1 = r0.length     // Catch:{ KeyStoreException | CertificateException -> 0x022a }
            if (r12 >= r1) goto L_0x021f
            java.lang.String r1 = "3"
            r3 = 211(0xd3, float:2.96E-43)
            r5 = 91
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r1, r3, r5, r4)     // Catch:{  }
            r2.append(r1)     // Catch:{  }
            r1 = r0[r12]     // Catch:{  }
            byte[] r1 = r1.getEncoded()     // Catch:{  }
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006A006A006Aj006A(r1)     // Catch:{  }
            r2.append(r1)     // Catch:{  }
            int r12 = r12 + 1
        L_0x0215:
            r1 = 0
            r1.length()     // Catch:{ Exception -> 0x021a }
            goto L_0x0215
        L_0x021a:
            r1 = 35
            bxxx0078xx = r1
            goto L_0x01f6
        L_0x021f:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTERED     // Catch:{  }
            java.lang.String r1 = r2.toString()     // Catch:{  }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{  }
            return r0
        L_0x022a:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ Exception -> 0x0250 }
            r1 = 0
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0250 }
            return r0
        L_0x0232:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ Exception -> 0x0250 }
            r1 = 0
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0250 }
            return r0
        L_0x023a:
            java.lang.String r0 = bt0074t00740074t     // Catch:{ Exception -> 0x0252 }
            java.lang.String r1 = "\n\u001c\u001d\u001e''\u0017#Ot\u000f\u0016\u0018 \u001c\u000eaFh\u0006\u0012I\u0016@\u0007\u0004\u0012<\u0007\u0013\f\f\u0006\by"
            r2 = 199(0xc7, float:2.79E-43)
            r3 = 3
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r1, r2, r3)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44484d(r0, r1)     // Catch:{ Exception -> 0x0252 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.REGISTRATION_FAILED     // Catch:{ Exception -> 0x0252 }
            r1 = 0
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r0 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r0, r1)     // Catch:{ Exception -> 0x0250 }
            return r0
        L_0x0250:
            r0 = move-exception
            throw r0
        L_0x0252:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.bq00710071qqq(android.content.Context, java.lang.String, java.lang.String, java.lang.String, byte[], com.threatmetrix.TrustDefender.TMXStrongAuth$StrongAuthCallback):com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult");
    }

    private static byte[] bq0071qqqq(PrivateKey privateKey) {
        String bqqqqq0071 = khhkhk.bqqqqq0071("$#", 221, 0);
        int i = bxxx0078xx;
        if (((bx0078x0078xx + i) * i) % b00780078x0078xx != b0078xx0078xx) {
            bxxx0078xx = bxx00780078xx();
            b0078xx0078xx = bxx00780078xx();
        }
        return bqqqqq0071.equalsIgnoreCase(privateKey.getAlgorithm()) ? hkhhhh.b00660066ff00660066 : hkhhhh.bff0066f00660066;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.Serializable[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bqq0071qqq(java.lang.String r7) {
        /*
            r0 = 1
            java.util.HashSet[] r1 = new java.util.HashSet[r0]     // Catch:{ Exception -> 0x0045 }
            int r2 = bxxx0078xx
            int r3 = bx0078x0078xx
            int r3 = r3 + r2
            int r3 = r3 * r2
            int r2 = b00780078x0078xx
            int r3 = r3 % r2
            int r2 = bxx0078x0078x()
            if (r3 == r2) goto L_0x001d
            int r2 = bxx00780078xx()
            bxxx0078xx = r2
            r2 = 32
            b0078xx0078xx = r2
        L_0x001d:
            java.util.HashSet r2 = new java.util.HashSet
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r4 = 2
            java.io.Serializable[] r4 = new java.io.Serializable[r4]
            byte[] r5 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.b0066f0066f00660066
            r6 = 0
            r4[r6] = r5
            r4[r0] = r7
            java.util.List r7 = java.util.Arrays.asList(r4)
            r3[r6] = r7
            java.util.List r7 = java.util.Arrays.asList(r3)
            r2.<init>(r7)
            r1[r6] = r2     // Catch:{ Exception -> 0x0043 }
            java.util.List r7 = java.util.Arrays.asList(r1)     // Catch:{ Exception -> 0x0043 }
            byte[] r7 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006A006Ajj(r7)     // Catch:{ Exception -> 0x0043 }
            return r7
        L_0x0043:
            r7 = move-exception
            throw r7
        L_0x0045:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.bqq0071qqq(java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.io.Serializable[]} */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:44|45|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01b4, code lost:
        return com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.MISSING_PARAMETER, (java.lang.String) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x01ae */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.threatmetrix.TrustDefender.TMXStrongAuth.AuthParamResult bqqq0071qq(@javax.annotation.Nonnull java.lang.String r10, @javax.annotation.Nonnull byte[] r11, @javax.annotation.Nonnull com.threatmetrix.TrustDefender.TMXStrongAuth.AuthMethod r12, @javax.annotation.Nonnull com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.kkhhkh r13) {
        /*
            r0 = 0
            java.lang.String r1 = "LB<)/35"
            r2 = 164(0xa4, float:2.3E-43)
            r3 = 171(0xab, float:2.4E-43)
            r4 = 0
            java.lang.String r1 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r1, r2, r3, r4)     // Catch:{ NoSuchAlgorithmException -> 0x01b7 }
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x01b7 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IllegalArgumentException -> 0x01ae }
            byte[] r10 = r10.getBytes(r2)     // Catch:{ IllegalArgumentException -> 0x01ae }
            r1.update(r10)     // Catch:{ IllegalArgumentException -> 0x01ae }
            byte[] r2 = r1.digest()     // Catch:{ IllegalArgumentException -> 0x01ae }
            r1.reset()     // Catch:{ IllegalArgumentException -> 0x01ae }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ Exception -> 0x01ac }
            r3 = 3
            r1.<init>(r3)     // Catch:{ Exception -> 0x01ac }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01ac }
            byte[] r7 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bf00660066f00660066     // Catch:{ Exception -> 0x01ac }
            r6[r4] = r7     // Catch:{ Exception -> 0x01ac }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x01ac }
            byte[] r2 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006Aj006Aj(r2)     // Catch:{ Exception -> 0x01ac }
            java.util.List r2 = java.util.Collections.singletonList(r2)     // Catch:{ Exception -> 0x01ac }
            r7.<init>(r2)     // Catch:{ Exception -> 0x01ac }
            r2 = 1
            r6[r2] = r7     // Catch:{ Exception -> 0x01b5 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x01ac }
            r1.add(r6)     // Catch:{ Exception -> 0x01ac }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01b5 }
            byte[] r7 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.b006600660066f00660066     // Catch:{ Exception -> 0x01b5 }
            r6[r4] = r7     // Catch:{ Exception -> 0x01b5 }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x01b5 }
            byte[] r11 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006Aj006Aj(r11)     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Collections.singletonList(r11)     // Catch:{ Exception -> 0x01b5 }
            r7.<init>(r11)     // Catch:{ Exception -> 0x01b5 }
            r6[r2] = r7     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x01b5 }
            r1.add(r11)     // Catch:{ Exception -> 0x01b5 }
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01ac }
            byte[] r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bfff006600660066     // Catch:{ Exception -> 0x01b5 }
            r11[r4] = r6     // Catch:{ Exception -> 0x01b5 }
            java.util.HashSet r6 = new java.util.HashSet     // Catch:{ Exception -> 0x01b5 }
            byte[] r7 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bf0066f006600660066     // Catch:{ Exception -> 0x01b5 }
            java.util.List r7 = java.util.Collections.singletonList(r7)     // Catch:{ Exception -> 0x01b5 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x01b5 }
            r11[r2] = r6     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Arrays.asList(r11)     // Catch:{ Exception -> 0x01b5 }
            r1.add(r11)     // Catch:{ Exception -> 0x01b5 }
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01b5 }
            byte[] r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.b0066ff006600660066     // Catch:{ Exception -> 0x01ac }
            r11[r4] = r6     // Catch:{ Exception -> 0x01ac }
            java.util.HashSet r6 = new java.util.HashSet     // Catch:{ Exception -> 0x01ac }
            java.lang.String r12 = r12.name     // Catch:{ Exception -> 0x01ac }
            byte[] r12 = r12.getBytes()     // Catch:{ Exception -> 0x01ac }
            byte[] r12 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006Aj006Aj(r12)     // Catch:{ Exception -> 0x01ac }
            java.util.List r12 = java.util.Collections.singletonList(r12)     // Catch:{ Exception -> 0x01ac }
            r6.<init>(r12)     // Catch:{ Exception -> 0x01ac }
            r11[r2] = r6     // Catch:{ Exception -> 0x01ac }
            java.util.List r11 = java.util.Arrays.asList(r11)     // Catch:{ Exception -> 0x01b5 }
            r1.add(r11)     // Catch:{ Exception -> 0x01b5 }
            byte[] r11 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006A006Ajj(r1)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r12 = bt0074t00740074t     // Catch:{ Exception -> 0x01b5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b5 }
            r1.<init>()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r6 = "d\u0018\u0016\t?\u0012\u0011\u000e\u0004{\u000e\f{\tN3"
            r7 = 173(0xad, float:2.42E-43)
            java.lang.String r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.bqqqqq0071(r6, r7, r5)     // Catch:{ Exception -> 0x01b5 }
            r1.append(r6)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006A006A006Aj006A(r11)     // Catch:{ Exception -> 0x01b5 }
            r1.append(r6)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01b5 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44484d(r12, r1)     // Catch:{ Exception -> 0x01ac }
            byte[] r12 = r13.signData(r11)     // Catch:{ Exception -> 0x01ac }
            if (r12 != 0) goto L_0x00dc
            java.lang.String r10 = bt0074t00740074t     // Catch:{ Exception -> 0x01ac }
            java.lang.String r11 = "odagYkkgY\u0013[d\u0010]cYX\u000b\\N\\\\XSMQI\u000133#-1+9\u001f\u0019 \"\u001a\u0018"
            r12 = 177(0xb1, float:2.48E-43)
            r13 = 46
            java.lang.String r11 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r11, r12, r13, r5)     // Catch:{ Exception -> 0x01ac }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44485e(r10, r11)     // Catch:{ Exception -> 0x01ac }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.STEPUP_FAILED     // Catch:{ Exception -> 0x01ac }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r10, r0)     // Catch:{ Exception -> 0x01b5 }
            return r10
        L_0x00dc:
            r1 = 4
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01b5 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01b5 }
            r6[r4] = r7     // Catch:{ Exception -> 0x01b5 }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x01b5 }
            byte[][] r8 = new byte[r5][]     // Catch:{ Exception -> 0x01b5 }
            byte[] r9 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bff0066006600660066     // Catch:{ Exception -> 0x01b5 }
            r8[r4] = r9     // Catch:{ Exception -> 0x01b5 }
            r8[r2] = r0     // Catch:{ Exception -> 0x01b5 }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x01b5 }
            java.util.List r8 = java.util.Collections.singletonList(r8)     // Catch:{ Exception -> 0x01b5 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01b5 }
            r6[r2] = r7     // Catch:{ Exception -> 0x01b5 }
            byte[][] r7 = new byte[r5][]     // Catch:{ Exception -> 0x01b5 }
            byte[] r8 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bf0066f006600660066     // Catch:{ Exception -> 0x01b5 }
            r7[r4] = r8     // Catch:{ Exception -> 0x01b5 }
            byte[] r10 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006Aj006Aj(r10)     // Catch:{ Exception -> 0x01ac }
            java.util.List r10 = java.util.Collections.singletonList(r10)     // Catch:{ Exception -> 0x01ac }
            byte[] r10 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bjj006A006Ajj(r10, r5, r4)     // Catch:{ Exception -> 0x01ac }
            r7[r2] = r10     // Catch:{ Exception -> 0x01ac }
            java.util.List r10 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x01ac }
            r6[r5] = r10     // Catch:{ Exception -> 0x01b5 }
            java.util.HashSet r10 = new java.util.HashSet     // Catch:{ Exception -> 0x01b5 }
            r7 = 6
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x01b5 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01b5 }
            r7[r4] = r8     // Catch:{ Exception -> 0x01b5 }
            java.io.Serializable[] r8 = new java.io.Serializable[r5]     // Catch:{ Exception -> 0x01b5 }
            byte[] r9 = r13.getSubject()     // Catch:{ Exception -> 0x01b5 }
            r8[r4] = r9     // Catch:{ Exception -> 0x01b5 }
            java.math.BigInteger r9 = r13.getSerialNumber()     // Catch:{ Exception -> 0x01b5 }
            r8[r2] = r9     // Catch:{ Exception -> 0x01b5 }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x01b5 }
            r7[r2] = r8     // Catch:{ Exception -> 0x01b5 }
            byte[][] r8 = new byte[r5][]     // Catch:{ Exception -> 0x01b5 }
            byte[] r9 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bff0066006600660066     // Catch:{ Exception -> 0x01b5 }
            r8[r4] = r9     // Catch:{ Exception -> 0x01b5 }
            r8[r2] = r0     // Catch:{ Exception -> 0x01b5 }
            java.util.List r0 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x01b5 }
            r7[r5] = r0     // Catch:{ Exception -> 0x01b5 }
            byte[] r11 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bjj006A006Ajj(r11, r5, r4)     // Catch:{ Exception -> 0x01b5 }
            r7[r3] = r11     // Catch:{ Exception -> 0x01b5 }
            byte[][] r11 = new byte[r2][]     // Catch:{ Exception -> 0x01b5 }
            byte[] r13 = r13.getOid()     // Catch:{ Exception -> 0x01b5 }
            r11[r4] = r13     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Arrays.asList(r11)     // Catch:{ Exception -> 0x01b5 }
            r7[r1] = r11     // Catch:{ Exception -> 0x01b5 }
            r11 = 5
            byte[] r12 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006Aj006Aj(r12)     // Catch:{ Exception -> 0x01b5 }
            r7[r11] = r12     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x01b5 }
            java.util.List r11 = java.util.Collections.singletonList(r11)     // Catch:{ Exception -> 0x01b5 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x01b5 }
            r6[r3] = r10     // Catch:{ Exception -> 0x01b5 }
            java.util.List r10 = java.util.Arrays.asList(r6)     // Catch:{ Exception -> 0x01b5 }
            byte[][] r11 = new byte[r5][]     // Catch:{ Exception -> 0x01ac }
            byte[] r12 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.b00660066f006600660066     // Catch:{ Exception -> 0x01ac }
            r11[r4] = r12     // Catch:{ Exception -> 0x01ac }
            java.util.List r10 = java.util.Collections.singletonList(r10)     // Catch:{ Exception -> 0x01ac }
            byte[] r10 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bjj006A006Ajj(r10, r5, r4)     // Catch:{ Exception -> 0x01ac }
            int r12 = bxxx0078xx
            int r13 = bx0078x0078xx
            int r13 = r13 + r12
            int r13 = r13 * r12
            int r12 = b00780078x0078xx
            int r13 = r13 % r12
            int r12 = b0078xx0078xx
            if (r13 == r12) goto L_0x0197
            int r12 = bxx00780078xx()
            bxxx0078xx = r12
            int r12 = bxx00780078xx()
            b0078xx0078xx = r12
        L_0x0197:
            r11[r2] = r10     // Catch:{ Exception -> 0x01ac }
            java.util.List r10 = java.util.Arrays.asList(r11)     // Catch:{ Exception -> 0x01ac }
            byte[] r10 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhhhh.bj006A006A006Ajj(r10)     // Catch:{ Exception -> 0x01ac }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r11 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.STEPUP_COMPLETE     // Catch:{ Exception -> 0x01ac }
            java.lang.String r10 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkhkhh.bj006A006A006Aj006A(r10)     // Catch:{ Exception -> 0x01ac }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r11, r10)     // Catch:{ Exception -> 0x01ac }
            return r10
        L_0x01ac:
            r10 = move-exception
            throw r10
        L_0x01ae:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.MISSING_PARAMETER     // Catch:{ Exception -> 0x01b5 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r10, r0)     // Catch:{ Exception -> 0x01b5 }
            return r10
        L_0x01b5:
            r10 = move-exception
            goto L_0x01be
        L_0x01b7:
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.AuthResult.NOT_SUPPORTED     // Catch:{ Exception -> 0x01b5 }
            com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult r10 = com.threatmetrix.TrustDefender.TMXStrongAuth.generateAuthParamResult(r10, r0)     // Catch:{ Exception -> 0x01b5 }
            return r10
        L_0x01be:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh.bqqq0071qq(java.lang.String, byte[], com.threatmetrix.TrustDefender.TMXStrongAuth$AuthMethod, com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.kkkkhh$kkhhkh):com.threatmetrix.TrustDefender.TMXStrongAuth$AuthParamResult");
    }

    public static int bxx00780078xx() {
        return 16;
    }

    public static int bxx0078x0078x() {
        return 0;
    }
}
