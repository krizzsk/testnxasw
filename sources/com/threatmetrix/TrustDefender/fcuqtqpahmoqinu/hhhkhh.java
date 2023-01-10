package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import android.content.ContentResolver;
import android.content.Context;
import com.threatmetrix.TrustDefender.AuthNativeGathererHelper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class hhhkhh {
    public static int b006C006C006C006C006Cl = 1;
    public static int b006Cl006C006C006Cl = b006Cllll006C();
    private static final String b007400740074ttt;
    private static volatile hhhkhh b0074tt0074tt = null;
    public static int bl006C006C006C006Cl = b006Cllll006C();
    public static int blllll006C = 2;
    private static final Lock bt0074t0074tt;
    private static final String bttt0074tt;
    private final Lock b00740074t0074tt = new ReentrantLock();
    public boolean b0074t00740074tt = false;
    private final AuthNativeGathererHelper bt007400740074tt = new AuthNativeGathererHelper();
    public boolean btt00740074tt = false;

    static {
        if (((b006Cllll006C() + b006C006Clll006C()) * b006Cllll006C()) % blllll006C != bl006C006C006C006Cl) {
        }
        try {
            bttt0074tt = khhkhk.bqqqqq0071("!5I?M=x\u001dJ@B\u0018", 'p', 1);
            try {
                b007400740074ttt = hkkhhh.bjjjjj006A(hhhkhh.class);
                bt0074t0074tt = new ReentrantLock();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static hhhkhh b006Aj006Ajj006A() {
        if (b0074tt0074tt == null) {
            try {
                bt0074t0074tt.lock();
                if (b0074tt0074tt == null) {
                    b0074tt0074tt = new hhhkhh();
                    int i = b006Cl006C006C006Cl;
                    if (((b006C006C006C006C006Cl + i) * i) % blllll006C != bl006C006C006C006Cl) {
                        b006Cl006C006C006Cl = 93;
                        bl006C006C006C006Cl = b006Cllll006C();
                    }
                }
            } finally {
                bt0074t0074tt.unlock();
            }
        }
        return b0074tt0074tt;
    }

    public static int b006C006Clll006C() {
        return 1;
    }

    public static int b006Cllll006C() {
        return 92;
    }

    public static int bl006Clll006C() {
        return 0;
    }

    public boolean b006A006A006Ajj006A(@Nonnull Context context, @Nonnull final String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String str2 = context.getApplicationInfo().nativeLibraryDir;
        if (!bjjj006Aj006A(str, absolutePath)) {
            C215711 r0 = new FilenameFilter() {
                public static int b006C006C006Cll006C = 2;
                public static int b006Cl006Cll006C = 0;
                public static int bl006C006Cll006C = 1;

                public static int bll006Cll006C() {
                    return 26;
                }

                public boolean accept(File file, @Nonnull String str) {
                    if (((bll006Cll006C() + bl006C006Cll006C) * bll006Cll006C()) % b006C006C006Cll006C != b006Cl006Cll006C) {
                        b006Cl006Cll006C = bll006Cll006C();
                    }
                    return str.contains(str);
                }
            };
            File file = new File(str2);
            int i = b006Cl006C006C006Cl;
            if ((i * (b006C006C006C006C006Cl + i)) % blllll006C != 0) {
                b006Cl006C006C006Cl = 79;
                bl006C006C006C006Cl = 32;
            }
            String[] list = file.list(r0);
            if (!(list == null || list.length == 0)) {
                this.b0074t00740074tt = true;
            }
        }
        return this.btt00740074tt;
    }

    @Nullable
    public String b006A006Aj006Aj006A(@Nullable byte[] bArr) {
        try {
            if (!this.btt00740074tt || bArr == null) {
                return null;
            }
            AuthNativeGathererHelper authNativeGathererHelper = this.bt007400740074tt;
            int i = b006Cl006C006C006Cl;
            if (((b006C006C006C006C006Cl + i) * i) % blllll006C != bl006C006C006C006Cl) {
                b006Cl006C006C006Cl = b006Cllll006C();
                bl006C006C006C006Cl = 89;
            }
            return authNativeGathererHelper.sha256HexEncode(bArr);
        } catch (Throwable th) {
            hkkhhh.m44479e(b007400740074ttt, khhkhk.bqqqqq0071("FZndrb\u001eboeg=", 246, 0), th);
            return null;
        }
    }

    @Nullable
    public Map<String, String> b006A006Ajjj006A(String str, String str2, Context context) {
        khhkhk.bqqqqq0071("\u0004xu{m{m", 'o', 3);
        khhkhk.b00710071007100710071q("#\u0011\u001d\u0012\u001c\u0019", 196, 244, 2);
        khhkhk.b00710071007100710071q("JND8", 't', '5', 1);
        khhkhk.bqqqqq0071("\t\u0005\u0017\u0007", 's', 4);
        khhkhk.b00710071007100710071q("ni~", 28, 152, 0);
        khhkhk.bqqqqq0071("/24245%#", 29, 2);
        khhkhk.b00710071007100710071q("DRSQU", 135, 213, 3);
        try {
            if (this.btt00740074tt) {
                HashMap hashMap = new HashMap();
                String[] attestStrongID = this.bt007400740074tt.attestStrongID(str, str2, context, kkhkhh.btt0074t0074t);
                if (attestStrongID.length == 1) {
                    String b00710071007100710071q = khhkhk.b00710071007100710071q("myxtv", 'a', 22, 1);
                    int i = b006Cl006C006C006Cl;
                    if ((i * (b006C006C006C006C006Cl + i)) % blllll006C != 0) {
                        b006Cl006C006C006Cl = b006Cllll006C();
                        bl006C006C006C006Cl = 90;
                    }
                    hashMap.put(b00710071007100710071q, attestStrongID[0]);
                } else if (attestStrongID.length == 6) {
                    hashMap.put(khhkhk.bqqqqq0071("2)(0$8:8,", 31, 5), attestStrongID[4]);
                    hashMap.put(khhkhk.bqqqqq0071("\\LZQ]\\", 't', 5), attestStrongID[0]);
                    hashMap.put(khhkhk.bqqqqq0071("/3)\u001d", 'E', 3), attestStrongID[2]);
                    hashMap.put(khhkhk.b00710071007100710071q("yu\bw", 199, 161, 1), attestStrongID[1]);
                    hashMap.put(khhkhk.b00710071007100710071q("\u001d\u0018-", 202, 26, 0), attestStrongID[3]);
                    hashMap.put(khhkhk.b00710071007100710071q("\u0011\u0016\u001a\u001a\u001e!\u0013\u0013", 157, 9, 3), attestStrongID[5]);
                    hashMap.put(khhkhk.bqqqqq0071("\u0010\u001c\u001b\u0017\u0019", 212, 3), (Object) null);
                }
                return hashMap;
            }
        } catch (Throwable th) {
            hkkhhh.m44479e(b007400740074ttt, khhkhk.b00710071007100710071q("\u0014&8,8&_\"-!!t", 164, 148, 1), th);
        }
        return null;
    }

    public boolean b006Ajj006Aj006A() {
        int i = b006Cl006C006C006Cl;
        if ((i * (b006C006C006C006C006Cl + i)) % blllll006C != 0) {
            b006Cl006C006C006Cl = b006Cllll006C();
            bl006C006C006C006Cl = b006Cllll006C();
        }
        try {
            return this.btt00740074tt;
        } catch (Exception e) {
            throw e;
        }
    }

    public long bj006A006Ajj006A(int i) {
        try {
            if (this.btt00740074tt) {
                return this.bt007400740074tt.getTamperCode(i);
            }
            int i2 = b006Cl006C006C006Cl;
            if (((b006C006C006C006C006Cl + i2) * i2) % blllll006C == bl006C006C006C006Cl) {
                return 0;
            }
            b006Cl006C006C006Cl = b006Cllll006C();
            bl006C006C006C006Cl = 79;
            return 0;
        } catch (Throwable th) {
            hkkhhh.m44479e(b007400740074ttt, khhkhk.bqqqqq0071("\\n\u0001t\u0001n(Juii=", 247, 2), th);
            return 0;
        }
    }

    public boolean bj006Aj006Aj006A() {
        if (this.btt00740074tt || !this.b0074t00740074tt) {
            return false;
        }
        int i = b006Cl006C006C006Cl;
        if ((i * (b006C006C006C006C006Cl + i)) % blllll006C != 0) {
            b006Cl006C006C006Cl = b006Cllll006C();
            bl006C006C006C006Cl = 12;
        }
        return true;
    }

    @Nullable
    public byte[] bjj006A006Aj006A(byte[] bArr, ContentResolver contentResolver) {
        try {
            if (!this.btt00740074tt) {
                return null;
            }
            int i = b006Cl006C006C006Cl;
            if (((b006C006C006C006C006Cl + i) * i) % blllll006C != bl006C006C006C006Cl) {
                b006Cl006C006C006Cl = b006Cllll006C();
                bl006C006C006C006Cl = 99;
            }
            return this.bt007400740074tt.sign(bArr, contentResolver);
        } catch (Throwable th) {
            hkkhhh.m44479e(b007400740074ttt, khhkhk.b00710071007100710071q("\u0013';1?/j/<24\n", 212, 17, 0), th);
            return null;
        }
    }

    public int bjj006Ajj006A() {
        try {
            if (this.btt00740074tt) {
                return this.bt007400740074tt.cancel();
            }
            return -1;
        } catch (Throwable th) {
            hkkhhh.m44479e(b007400740074ttt, khhkhk.b00710071007100710071q("6J^TbR\u000e2_UW-", 156, 201, 3), th);
            return -1;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bjjj006Aj006A(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = r5.btt00740074tt     // Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x0006
            r6 = 1
            return r6
        L_0x0006:
            java.util.concurrent.locks.Lock r0 = r5.b00740074t0074tt     // Catch:{ all -> 0x0071 }
            r0.lock()     // Catch:{ all -> 0x0071 }
            boolean r0 = r5.btt00740074tt     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x0017
            boolean r6 = r5.btt00740074tt     // Catch:{ all -> 0x0071 }
            java.util.concurrent.locks.Lock r7 = r5.b00740074t0074tt     // Catch:{ Exception -> 0x0078 }
            r7.unlock()     // Catch:{ Exception -> 0x0078 }
            return r6
        L_0x0017:
            r0 = 147(0x93, float:2.06E-43)
            r1 = 0
            com.threatmetrix.TrustDefender.AuthNativeGathererHelper r2 = r5.bt007400740074tt     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            boolean r6 = r2.b006Aj006A006Aj006A(r6, r7)     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            r5.btt00740074tt = r6     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            java.lang.String r7 = b007400740074ttt     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            if (r6 == 0) goto L_0x002f
            java.lang.String r6 = "\u000f\r\u0007E\b\u001e\n\u0013\u0017\r\u000f\u001a\u0014O"
            r2 = 240(0xf0, float:3.36E-43)
            java.lang.String r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r6, r0, r2, r1)     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            goto L_0x003a
        L_0x002f:
            java.lang.String r6 = "b^V\u0013``d\u000fOcMTVJJSK\u0005"
            r2 = 168(0xa8, float:2.35E-43)
            r3 = 31
            r4 = 2
            java.lang.String r6 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r6, r2, r3, r4)     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
        L_0x003a:
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.m44481i(r7, r6)     // Catch:{ UnsatisfiedLinkError -> 0x0041, all -> 0x003e }
            goto L_0x0051
        L_0x003e:
            r5.btt00740074tt = r1     // Catch:{ all -> 0x0071 }
            goto L_0x0051
        L_0x0041:
            r6 = move-exception
            java.lang.String r7 = b007400740074ttt     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = "r\u0007\u001b\u0011\u001f\u000fJn\u001c\u0012\u0014i"
            r3 = 143(0x8f, float:2.0E-43)
            r4 = 3
            java.lang.String r0 = com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.khhkhk.b00710071007100710071q(r2, r3, r0, r4)     // Catch:{ all -> 0x0071 }
            com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh.kkkhhh.m44488e((java.lang.String) r7, (java.lang.String) r0, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0071 }
            goto L_0x003e
        L_0x0051:
            java.util.concurrent.locks.Lock r6 = r5.b00740074t0074tt     // Catch:{ Exception -> 0x0078 }
            r6.unlock()     // Catch:{ Exception -> 0x0078 }
            int r6 = b006Cl006C006C006Cl
            int r7 = b006C006C006C006C006Cl
            int r7 = r7 + r6
            int r6 = r6 * r7
            int r7 = blllll006C
            int r6 = r6 % r7
            if (r6 == 0) goto L_0x006e
            int r6 = b006Cllll006C()
            b006Cl006C006C006Cl = r6
            int r6 = b006Cllll006C()
            bl006C006C006C006Cl = r6
        L_0x006e:
            boolean r6 = r5.btt00740074tt     // Catch:{ Exception -> 0x0078 }
            return r6
        L_0x0071:
            r6 = move-exception
            java.util.concurrent.locks.Lock r7 = r5.b00740074t0074tt     // Catch:{ Exception -> 0x0078 }
            r7.unlock()     // Catch:{ Exception -> 0x0078 }
            throw r6     // Catch:{ Exception -> 0x0078 }
        L_0x0078:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hhhkhh.bjjj006Aj006A(java.lang.String, java.lang.String):boolean");
    }
}
