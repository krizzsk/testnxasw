package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.yyyyqy;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;

public class yyqqyq {
    private static final String b00610061a006100610061 = yyyyqy.b0074t007400740074t(yyqqyq.class);
    private static final int b0061a0061006100610061 = 10;
    private static final String baa0061006100610061 = "selinuxfs";

    private yyqqyq() {
    }

    @Nullable
    public static qyqqyq b006900690069iii() {
        try {
            String bi00690069iii = bi00690069iii();
            if (bi00690069iii == null) {
                return biii0069ii() ? qyqqyq.UNKNOWN : qyqqyq.NONE;
            }
            File file = new File(bi00690069iii + "/enforce");
            if (b0069ii0069ii(file) == qyqqyq.UNKNOWN) {
                yyyyqy.qyyyqy.bt00740074ttt(b00610061a006100610061, "Can't read enforce file {}");
                if (file.exists()) {
                    return qyqqyq.ENFORCING;
                }
            }
            return qyqqyq.UNKNOWN;
        } catch (IOException unused) {
            return qyqqyq.UNKNOWN;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.threatmetrix.TrustDefender.qyqqyq b0069ii0069ii(java.io.File r4) {
        /*
            r0 = 10
            byte[] r1 = new byte[r0]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
            int r4 = r2.read(r1)     // Catch:{ all -> 0x0032 }
            if (r4 < r0) goto L_0x0015
            com.threatmetrix.TrustDefender.qyqqyq r4 = com.threatmetrix.TrustDefender.qyqqyq.UNKNOWN     // Catch:{ all -> 0x0032 }
            r2.close()     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
            return r4
        L_0x0015:
            java.lang.String r0 = "1"
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0032 }
            byte[] r4 = java.util.Arrays.copyOf(r1, r4)     // Catch:{ all -> 0x0032 }
            r3.<init>(r4)     // Catch:{ all -> 0x0032 }
            boolean r4 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x002c
            com.threatmetrix.TrustDefender.qyqqyq r4 = com.threatmetrix.TrustDefender.qyqqyq.ENFORCING     // Catch:{ all -> 0x0032 }
            r2.close()     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
            return r4
        L_0x002c:
            com.threatmetrix.TrustDefender.qyqqyq r4 = com.threatmetrix.TrustDefender.qyqqyq.PERMISSIVE     // Catch:{ all -> 0x0032 }
            r2.close()     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
            return r4
        L_0x0032:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
        L_0x003d:
            throw r0     // Catch:{ IOException -> 0x0049, SecurityException -> 0x003e }
        L_0x003e:
            r4 = move-exception
            java.lang.String r0 = b00610061a006100610061
            java.lang.String r4 = r4.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r0, r4)
            goto L_0x0055
        L_0x0049:
            r4 = move-exception
            java.lang.String r0 = b00610061a006100610061
            java.lang.String r4 = r4.toString()
            java.lang.String r1 = "Fail to open file {}"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b007400740074ttt(r0, r1, r4)
        L_0x0055:
            com.threatmetrix.TrustDefender.qyqqyq r4 = com.threatmetrix.TrustDefender.qyqqyq.UNKNOWN
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqqyq.b0069ii0069ii(java.io.File):com.threatmetrix.TrustDefender.qyqqyq");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String bi00690069iii() throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ SecurityException -> 0x0044 }
            java.lang.String r1 = "/proc/mounts"
            r0.<init>(r1)     // Catch:{ SecurityException -> 0x0044 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0038 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0038 }
            r2.<init>(r0)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
        L_0x0011:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = " "
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ all -> 0x0038 }
            int r3 = r2.length     // Catch:{ all -> 0x0038 }
            r4 = 3
            if (r3 >= r4) goto L_0x0022
            goto L_0x0011
        L_0x0022:
            java.lang.String r3 = "selinuxfs"
            r4 = 2
            r4 = r2[r4]     // Catch:{ all -> 0x0038 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x0011
            r1 = 1
            r1 = r2[r1]     // Catch:{ all -> 0x0038 }
            r0.close()     // Catch:{ SecurityException -> 0x0044 }
            return r1
        L_0x0034:
            r0.close()     // Catch:{ SecurityException -> 0x0044 }
            goto L_0x004e
        L_0x0038:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ SecurityException -> 0x0044 }
        L_0x0043:
            throw r2     // Catch:{ SecurityException -> 0x0044 }
        L_0x0044:
            r0 = move-exception
            java.lang.String r1 = b00610061a006100610061
            java.lang.String r0 = r0.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r1, r0)
        L_0x004e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqqyq.bi00690069iii():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean biii0069ii() throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ SecurityException -> 0x0034 }
            java.lang.String r1 = "/proc/filesystems"
            r0.<init>(r1)     // Catch:{ SecurityException -> 0x0034 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0028 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0028 }
            r2.<init>(r0)     // Catch:{ all -> 0x0028 }
            r1.<init>(r2)     // Catch:{ all -> 0x0028 }
        L_0x0011:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0024
            java.lang.String r3 = "selinuxfs"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0011
            r1 = 1
            r0.close()     // Catch:{ SecurityException -> 0x0034 }
            return r1
        L_0x0024:
            r0.close()     // Catch:{ SecurityException -> 0x0034 }
            goto L_0x003e
        L_0x0028:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ SecurityException -> 0x0034 }
        L_0x0033:
            throw r2     // Catch:{ SecurityException -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            java.lang.String r1 = b00610061a006100610061
            java.lang.String r0 = r0.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r1, r0)
        L_0x003e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqqyq.biii0069ii():boolean");
    }
}
