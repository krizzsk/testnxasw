package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.yyyyqy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nonnull;

public class qttqqq {
    private static final String bw00770077007700770077 = yyyyqy.b0074t007400740074t(qttqqq.class);

    /* renamed from: com.threatmetrix.TrustDefender.qttqqq$1 */
    public static /* synthetic */ class C215881 {
        public static final /* synthetic */ int[] b006Ennnnn;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.threatmetrix.TrustDefender.tqtttt[] r0 = com.threatmetrix.TrustDefender.tqtttt.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b006Ennnnn = r0
                com.threatmetrix.TrustDefender.tqtttt r1 = com.threatmetrix.TrustDefender.tqtttt.MD5     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = b006Ennnnn     // Catch:{ NoSuchFieldError -> 0x001d }
                com.threatmetrix.TrustDefender.tqtttt r1 = com.threatmetrix.TrustDefender.tqtttt.SHA256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qttqqq.C215881.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b00750075u00750075u(@javax.annotation.Nonnull java.lang.String r6, com.threatmetrix.TrustDefender.tqtttt r7) throws java.lang.InterruptedException {
        /*
            com.threatmetrix.TrustDefender.qqqyqy r0 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            boolean r0 = r0.b00670067ggg0067()
            if (r0 == 0) goto L_0x0013
            com.threatmetrix.TrustDefender.qqqyqy r0 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            java.lang.String r6 = r0.bggggg0067(r6, r7)
            return r6
        L_0x0013:
            java.lang.String r0 = bw00770077007700770077
            java.lang.String r1 = "Falling back to managed code for hashing"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r0, r1)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
            java.lang.String r6 = r7.b006600660066fff     // Catch:{ all -> 0x0084 }
            java.security.MessageDigest r6 = bu0075u00750075u(r6)     // Catch:{ all -> 0x0084 }
            int[] r2 = com.threatmetrix.TrustDefender.qttqqq.C215881.b006Ennnnn     // Catch:{ all -> 0x0084 }
            int r7 = r7.ordinal()     // Catch:{ all -> 0x0084 }
            r7 = r2[r7]     // Catch:{ all -> 0x0084 }
            r2 = 1
            if (r7 == r2) goto L_0x0034
            java.lang.String r7 = "%64s"
            goto L_0x0036
        L_0x0034:
            java.lang.String r7 = "%32s"
        L_0x0036:
            if (r6 != 0) goto L_0x003c
            r1.close()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
            return r0
        L_0x003c:
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0084 }
        L_0x0040:
            int r4 = r1.read(r3)     // Catch:{ all -> 0x0084 }
            r5 = 0
            if (r4 <= 0) goto L_0x004b
            r6.update(r3, r5, r4)     // Catch:{ all -> 0x0084 }
            goto L_0x0040
        L_0x004b:
            byte[] r6 = r6.digest()     // Catch:{ all -> 0x0084 }
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch:{ all -> 0x0084 }
            r3.<init>(r2, r6)     // Catch:{ all -> 0x0084 }
            r6 = 16
            java.lang.String r6 = r3.toString(r6)     // Catch:{ all -> 0x0084 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0084 }
            r2[r5] = r6     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = java.lang.String.format(r7, r2)     // Catch:{ all -> 0x0084 }
            r7 = 32
            r2 = 48
            java.lang.String r6 = r6.replace(r7, r2)     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = bw00770077007700770077     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r2.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = "Got : "
            r2.append(r3)     // Catch:{ all -> 0x0084 }
            r2.append(r6)     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0084 }
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r7, r2)     // Catch:{ all -> 0x0084 }
            r1.close()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
            return r6
        L_0x0084:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r7 = move-exception
            r1.close()     // Catch:{ all -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r6.addSuppressed(r1)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
        L_0x008f:
            throw r7     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0090 }
        L_0x0090:
            r6 = move-exception
            java.lang.String r7 = bw00770077007700770077
            java.lang.String r1 = "Unable to process file for hashing"
            goto L_0x009b
        L_0x0096:
            r6 = move-exception
            java.lang.String r7 = bw00770077007700770077
            java.lang.String r1 = "Exception while getting FileInputStream"
        L_0x009b:
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r7, r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qttqqq.b00750075u00750075u(java.lang.String, com.threatmetrix.TrustDefender.tqtttt):java.lang.String");
    }

    public static String b0075uu00750075u(@Nonnull tqtqqt tqtqqt, tqtttt tqtttt) throws InterruptedException {
        String b0071q00710071q0071 = yyqyyy.b0071q00710071q0071(tqtqqt);
        String str = bw00770077007700770077;
        yyyyqy.qyyyqy.b00740074t0074tt(str, "sourceDir: " + b0071q00710071q0071);
        if (yqqyqq.b0069ii0069i0069(b0071q00710071q0071)) {
            return b00750075u00750075u(b0071q00710071q0071, tqtttt);
        }
        return null;
    }

    private static MessageDigest bu0075u00750075u(String str) {
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            return null;
        }
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            String str2 = bw00770077007700770077;
            yyyyqy.qyyyqy.b0074tt0074tt(str2, str + " digest failed", e);
            return null;
        }
    }
}
