package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface;
import java.util.Map;
import javax.annotation.Nonnull;

public class hkhhhh implements Runnable {
    private static final String b00660066ff00660066;
    public static int b00710071qq0071q = 2;
    public static int b0071q0071q0071q = bqq0071q0071q();
    public static int b0071qqq0071q = bqq0071q0071q();
    public static int bq0071qq0071q = 1;
    @Nonnull
    private final String b0066006600660066f0066;
    @Nonnull
    private final kkkhhh b0066f00660066f0066;
    private final byte[] b0066fff00660066;
    @Nonnull
    private final TMXProfilingConnectionsInterface.HttpMethod bf006600660066f0066;
    private final int bf0066ff00660066;
    private final TMXProfilingConnectionsInterface.TMXCallback bffff00660066;

    static {
        try {
            String bj006A006A006Ajj = kkhhhh.bj006A006A006Ajj(hkhhhh.class);
            int i = b0071qqq0071q;
            if (((bq0071qq0071q + i) * i) % b00710071qq0071q != b0071q0071q0071q) {
            }
            try {
                b00660066ff00660066 = bj006A006A006Ajj;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public hkhhhh(@Nonnull kkkhhh kkkhhh, @Nonnull TMXProfilingConnectionsInterface.HttpMethod httpMethod, @Nonnull String str, Map<String, String> map, byte[] bArr, int i, TMXProfilingConnectionsInterface.TMXCallback tMXCallback) {
        this.b0066f00660066f0066 = kkkhhh;
        if (map != null && !map.isEmpty()) {
            this.b0066f00660066f0066.b006Ajjjj006A(map);
        }
        this.bf006600660066f0066 = httpMethod;
        this.b0066fff00660066 = bArr;
        this.bffff00660066 = tMXCallback;
        this.b0066006600660066f0066 = str;
        this.bf0066ff00660066 = i <= 0 ? 0 : i;
    }

    public static int bqq0071q0071q() {
        return 58;
    }

    private void bt0074tt00740074(boolean z) {
        try {
            long nanoTime = System.nanoTime();
            String str = b00660066ff00660066;
            StringBuilder sb = new StringBuilder();
            sb.append(kkhhkh.b006Aj006A006A006A006A("qr\u0014eWebXScMW$\t", 168, 31, 2));
            sb.append(this.b0066006600660066f0066);
            kkhhhh.hhkhhh.btt0074t00740074(str, sb.toString(), z ? kkhhkh.b006Aj006A006A006A006A("\u0017\u000b\u001b\u001a\"\u0013\u0019\u0013", 143, 147, 3) : kkhhkh.bj006A006A006A006A006A("\u0004\u0004o\u0001txp", 'o', 3));
            int i = -1;
            if (this.bf006600660066f0066 == TMXProfilingConnectionsInterface.HttpMethod.GET) {
                i = this.b0066f00660066f0066.b006A006A006Ajj006A(this.b0066006600660066f0066);
            } else if (this.bf006600660066f0066 == TMXProfilingConnectionsInterface.HttpMethod.POST) {
                i = this.b0066f00660066f0066.bj006A006A006Aj006A(this.b0066006600660066f0066, this.b0066fff00660066);
            }
            try {
                long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
                if (i < 0) {
                    String str2 = b00660066ff00660066;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(kkhhkh.b006Aj006A006A006A006A("\u0017\u0011\u0018\u001a\u0012\u0010J\u001e\u0018G\u0019\u000b\u0019\u0016\f\u0007\u0017\u0005>\u0004\u000f\u000b\b9", 196, 244, 2));
                    int i2 = b0071qqq0071q;
                    if ((i2 * (bq0071qq0071q + i2)) % b00710071qq0071q != 0) {
                        b0071qqq0071q = bqq0071q0071q();
                        bq0071qq0071q = 93;
                    }
                    sb2.append(this.b0066006600660066f0066);
                    sb2.append(kkhhkh.b006Aj006A006A006A006A("uL=G:p", 't', '5', 1));
                    sb2.append(this.b0066f00660066f0066.b006A006Aj006Aj006A().toString());
                    sb2.append(kkhhkh.bj006A006A006A006A006A("D\r\u0011A", 's', 4));
                    sb2.append(nanoTime2);
                    sb2.append(kkhhkh.b006Aj006A006A006A006A("pw", 28, 152, 0));
                    kkhhhh.b006Aj006Aj006Aj(str2, sb2.toString());
                    return;
                }
                String str3 = b00660066ff00660066;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(kkhhkh.bj006A006A006A006A006A("8*85+&6$\"v[", 29, 2));
                sb3.append(this.b0066f00660066f0066.bjj006A006Aj006A());
                sb3.append(kkhhkh.b006Aj006A006A006A006A("~IO\u0002", 135, 213, 3));
                sb3.append(nanoTime2);
                sb3.append(kkhhkh.b006Aj006A006A006A006A("uz", 'a', 22, 1));
                kkhhhh.hhkhhh.b00740074tt00740074(str3, sb3.toString());
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r2 = b00660066ff00660066;
        com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.b006A006Aj006Ajj(r2, com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A("\t\u000e\u00035\u001f *-!&$T[", 'p', 'O', 1) + r0.toString() + com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A("KC\u0018\u001a\b\u001c\u001e\u001dJ\u001b\u001bM!\u0015\"'\u0018')U+'X", 147, 240, 0) + r9.b0066f00660066f0066.b006Ajj006Aj006A());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0 = r9.b0066f00660066f0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00df, code lost:
        r9.b0066f00660066f0066.b006Aj006Ajj006A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e6, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x009b, B:32:0x00a3] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00a3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r0 = r9.b0066f00660066f0066     // Catch:{ Exception -> 0x00e7 }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r0 = r0.b006A006Aj006Aj006A()     // Catch:{ Exception -> 0x00e7 }
            r1 = 0
            r2 = 0
        L_0x0008:
            int r3 = r9.bf0066ff00660066     // Catch:{ Exception -> 0x00e7 }
            r4 = 1
            if (r2 > r3) goto L_0x0083
            boolean r3 = r0.succeeded()     // Catch:{ Exception -> 0x00e7 }
            if (r3 != 0) goto L_0x0083
            int r3 = r0.getHttpResponseCode()     // Catch:{ Exception -> 0x00e7 }
            r5 = -6
            if (r3 == r5) goto L_0x0083
            int r3 = r0.getHttpResponseCode()     // Catch:{ Exception -> 0x00e7 }
            r5 = -5
            if (r3 == r5) goto L_0x0083
            if (r2 == 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            r9.bt0074tt00740074(r0)     // Catch:{ Exception -> 0x00e7 }
            int r2 = r2 + 1
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r0 = r9.b0066f00660066f0066     // Catch:{ Exception -> 0x00e7 }
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXHttpResponseCode r0 = r0.b006A006Aj006Aj006A()     // Catch:{ Exception -> 0x00e7 }
            boolean r3 = r0.succeeded()     // Catch:{ Exception -> 0x00e7 }
            if (r3 != 0) goto L_0x0008
            java.lang.String r3 = b00660066ff00660066     // Catch:{ Exception -> 0x00e7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r5.<init>()     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r6 = "JVUQS\u0007"
            r7 = 144(0x90, float:2.02E-43)
            r8 = 137(0x89, float:1.92E-43)
            java.lang.String r4 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r6, r7, r8, r4)     // Catch:{ Exception -> 0x00e7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00e7 }
            int r4 = r0.getHttpResponseCode()     // Catch:{ Exception -> 0x00e7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r4 = " \u0018ln\\prq\u001foo\"uiv{l{}*{-"
            r6 = 99
            r7 = 146(0x92, float:2.05E-43)
            r8 = 3
            java.lang.String r4 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r4, r6, r7, r8)     // Catch:{ Exception -> 0x00e7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00e7 }
            int r4 = b0071qqq0071q
            int r6 = bq0071qq0071q
            int r6 = r6 + r4
            int r4 = r4 * r6
            int r6 = b00710071qq0071q
            int r4 = r4 % r6
            if (r4 == 0) goto L_0x0076
            int r4 = bqq0071q0071q()
            b0071qqq0071q = r4
            r4 = 83
            bq0071qq0071q = r4
        L_0x0076:
            java.lang.String r4 = r9.b0066006600660066f0066     // Catch:{ Exception -> 0x00e7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00e7 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.b006Aj006Aj006Aj(r3, r4)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x0008
        L_0x0083:
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXCallback r2 = r9.bffff00660066     // Catch:{ IOException -> 0x00a3 }
            if (r2 == 0) goto L_0x009b
            r2 = 0
            int r3 = r0.getHttpResponseCode()     // Catch:{ IOException -> 0x00a3 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 != r5) goto L_0x0096
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r2 = r9.b0066f00660066f0066     // Catch:{ IOException -> 0x00a3 }
            java.io.InputStream r2 = r2.bj006Aj006Aj006A()     // Catch:{ IOException -> 0x00a3 }
        L_0x0096:
            com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface$TMXCallback r3 = r9.bffff00660066     // Catch:{ IOException -> 0x00a3 }
            r3.onComplete(r0, r2)     // Catch:{ IOException -> 0x00a3 }
        L_0x009b:
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r0 = r9.b0066f00660066f0066     // Catch:{ Exception -> 0x00e5 }
        L_0x009d:
            r0.b006Aj006Ajj006A()     // Catch:{ Exception -> 0x00e5 }
            goto L_0x00de
        L_0x00a1:
            r0 = move-exception
            goto L_0x00df
        L_0x00a3:
            java.lang.String r2 = b00660066ff00660066     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r3.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r5 = "\t\u000e\u00035\u001f *-!&$T["
            r6 = 112(0x70, float:1.57E-43)
            r7 = 79
            java.lang.String r4 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r5, r6, r7, r4)     // Catch:{ all -> 0x00a1 }
            r3.append(r4)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a1 }
            r3.append(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = "KC\u0018\u001a\b\u001c\u001e\u001dJ\u001b\u001bM!\u0015\"'\u0018')U+'X"
            r4 = 147(0x93, float:2.06E-43)
            r5 = 240(0xf0, float:3.36E-43)
            java.lang.String r0 = com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh.b006Aj006A006A006A006A(r0, r4, r5, r1)     // Catch:{ all -> 0x00a1 }
            r3.append(r0)     // Catch:{ all -> 0x00a1 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r0 = r9.b0066f00660066f0066     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r0.b006Ajj006Aj006A()     // Catch:{ all -> 0x00a1 }
            r3.append(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a1 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh.b006A006Aj006Ajj(r2, r0)     // Catch:{ all -> 0x00a1 }
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r0 = r9.b0066f00660066f0066     // Catch:{ Exception -> 0x00e5 }
            goto L_0x009d
        L_0x00de:
            return
        L_0x00df:
            com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh r1 = r9.b0066f00660066f0066     // Catch:{ Exception -> 0x00e5 }
            r1.b006Aj006Ajj006A()     // Catch:{ Exception -> 0x00e5 }
            throw r0     // Catch:{ Exception -> 0x00e5 }
        L_0x00e5:
            r0 = move-exception
            throw r0
        L_0x00e7:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hkhhhh.run():void");
    }
}
