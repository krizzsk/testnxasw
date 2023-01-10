package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfnz {
    public static boolean zza(int i) {
        int i2 = i - 1;
        return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00ba */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0061=Splitter:B:17:0x0061, B:42:0x00ba=Splitter:B:42:0x00ba} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int zzb(android.content.Context r13, com.google.android.gms.internal.ads.zzfmx r14) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = new java.io.File
            android.content.pm.ApplicationInfo r2 = r13.getApplicationInfo()
            java.lang.String r2 = r2.dataDir
            r1.<init>(r2)
            java.lang.String r2 = "lib"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 5017(0x1399, float:7.03E-42)
            r3 = 7
            r4 = 6
            r5 = 1000(0x3e8, float:1.401E-42)
            r6 = 0
            r7 = 5
            r8 = 3
            r9 = 1
            if (r1 != 0) goto L_0x002b
            java.lang.String r0 = "No lib/"
            r14.zzb(r2, r0)
        L_0x0027:
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L_0x00cc
        L_0x002b:
            com.google.android.gms.internal.ads.zzfxq r1 = new com.google.android.gms.internal.ads.zzfxq
            java.lang.String r10 = ".*\\.so$"
            r11 = 2
            java.util.regex.Pattern r10 = java.util.regex.Pattern.compile(r10, r11)
            r1.<init>(r10)
            java.io.File[] r0 = r0.listFiles(r1)
            if (r0 == 0) goto L_0x00c5
            int r1 = r0.length
            if (r1 != 0) goto L_0x0042
            goto L_0x00c5
        L_0x0042:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00bb }
            r2 = 0
            r0 = r0[r2]     // Catch:{ IOException -> 0x00bb }
            r1.<init>(r0)     // Catch:{ IOException -> 0x00bb }
            r0 = 20
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x009f }
            int r12 = r1.read(r10)     // Catch:{ all -> 0x009f }
            if (r12 != r0) goto L_0x0061
            byte[] r0 = new byte[r11]     // Catch:{ all -> 0x009f }
            r0[r2] = r2     // Catch:{ all -> 0x009f }
            r0[r9] = r2     // Catch:{ all -> 0x009f }
            byte r12 = r10[r7]     // Catch:{ all -> 0x009f }
            if (r12 != r11) goto L_0x0065
            zzd(r10, r6, r13, r14)     // Catch:{ all -> 0x009f }
        L_0x0061:
            r1.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00c3
        L_0x0065:
            r11 = 19
            byte r11 = r10[r11]     // Catch:{ all -> 0x009f }
            r0[r2] = r11     // Catch:{ all -> 0x009f }
            r11 = 18
            byte r11 = r10[r11]     // Catch:{ all -> 0x009f }
            r0[r9] = r11     // Catch:{ all -> 0x009f }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ all -> 0x009f }
            short r0 = r0.getShort()     // Catch:{ all -> 0x009f }
            if (r0 == r8) goto L_0x009a
            r11 = 40
            if (r0 == r11) goto L_0x0095
            r11 = 62
            if (r0 == r11) goto L_0x0090
            r11 = 183(0xb7, float:2.56E-43)
            if (r0 == r11) goto L_0x008b
            zzd(r10, r6, r13, r14)     // Catch:{ all -> 0x009f }
            goto L_0x0061
        L_0x008b:
            r1.close()     // Catch:{ IOException -> 0x00bb }
            r0 = 6
            goto L_0x00cc
        L_0x0090:
            r1.close()     // Catch:{ IOException -> 0x00bb }
            r0 = 7
            goto L_0x00cc
        L_0x0095:
            r1.close()     // Catch:{ IOException -> 0x00bb }
            r0 = 3
            goto L_0x00cc
        L_0x009a:
            r1.close()     // Catch:{ IOException -> 0x00bb }
            r0 = 5
            goto L_0x00cc
        L_0x009f:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x00a4 }
            goto L_0x00ba
        L_0x00a4:
            r1 = move-exception
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x00ba }
            java.lang.Class<java.lang.Throwable> r11 = java.lang.Throwable.class
            r10[r2] = r11     // Catch:{ Exception -> 0x00ba }
            java.lang.Class<java.lang.Throwable> r11 = java.lang.Throwable.class
            java.lang.String r12 = "addSuppressed"
            java.lang.reflect.Method r10 = r11.getDeclaredMethod(r12, r10)     // Catch:{ Exception -> 0x00ba }
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00ba }
            r11[r2] = r1     // Catch:{ Exception -> 0x00ba }
            r10.invoke(r0, r11)     // Catch:{ Exception -> 0x00ba }
        L_0x00ba:
            throw r0     // Catch:{ IOException -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            zzd(r6, r0, r13, r14)
        L_0x00c3:
            r0 = 1
            goto L_0x00cc
        L_0x00c5:
            java.lang.String r0 = "No .so"
            r14.zzb(r2, r0)
            goto L_0x0027
        L_0x00cc:
            if (r0 != r5) goto L_0x011c
            java.lang.String r0 = zzc(r13, r14)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00df
            java.lang.String r0 = "Empty dev arch"
            zzd(r6, r0, r13, r14)
        L_0x00dd:
            r0 = 1
            goto L_0x011c
        L_0x00df:
            java.lang.String r1 = "i686"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x011b
            java.lang.String r1 = "x86"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00f0
            goto L_0x011b
        L_0x00f0:
            java.lang.String r1 = "x86_64"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00fa
            r0 = 7
            goto L_0x011c
        L_0x00fa:
            java.lang.String r1 = "arm64-v8a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0104
            r0 = 6
            goto L_0x011c
        L_0x0104:
            java.lang.String r1 = "armeabi-v7a"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0119
            java.lang.String r1 = "armv71"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0115
            goto L_0x0119
        L_0x0115:
            zzd(r6, r0, r13, r14)
            goto L_0x00dd
        L_0x0119:
            r0 = 3
            goto L_0x011c
        L_0x011b:
            r0 = 5
        L_0x011c:
            if (r0 == r9) goto L_0x0135
            if (r0 == r8) goto L_0x0132
            if (r0 == r7) goto L_0x012f
            if (r0 == r4) goto L_0x012c
            if (r0 == r3) goto L_0x0129
            java.lang.String r13 = "null"
            goto L_0x0137
        L_0x0129:
            java.lang.String r13 = "X86_64"
            goto L_0x0137
        L_0x012c:
            java.lang.String r13 = "ARM64"
            goto L_0x0137
        L_0x012f:
            java.lang.String r13 = "X86"
            goto L_0x0137
        L_0x0132:
            java.lang.String r13 = "ARM7"
            goto L_0x0137
        L_0x0135:
            java.lang.String r13 = "UNSUPPORTED"
        L_0x0137:
            r1 = 5018(0x139a, float:7.032E-42)
            r14.zzb(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfnz.zzb(android.content.Context, com.google.android.gms.internal.ads.zzfmx):int");
    }

    private static final String zzc(Context context, zzfmx zzfmx) {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String zza = zzftl.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzfmx.zzc(2024, 0, e);
        } catch (IllegalAccessException e2) {
            zzfmx.zzc(2024, 0, e2);
        }
        return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfmx zzfmx) {
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzftl.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfmx.zzb(4007, sb.toString());
    }
}
