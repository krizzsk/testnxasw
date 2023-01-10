package com.didi.component.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo {
    public static final int DEVICEINFO_UNKNOWN = -1;

    /* renamed from: a */
    private static final FileFilter f13588a = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int b = m11349b("/sys/devices/system/cpu/possible");
            if (b == -1) {
                b = m11349b("/sys/devices/system/cpu/present");
            }
            return b == -1 ? m11345a() : b;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m11349b(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002b, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002b, all -> 0x0024 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            int r2 = m11346a(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r0 = r1
            goto L_0x002c
        L_0x0024:
            r2 = move-exception
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            throw r2
        L_0x002b:
        L_0x002c:
            r2 = -1
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.util.DeviceInfo.m11349b(java.lang.String):int");
    }

    /* renamed from: a */
    static int m11346a(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    /* renamed from: a */
    private static int m11345a() {
        return new File("/sys/devices/system/cpu/").listFiles(f13588a).length;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCPUMaxFreqKHz() {
        /*
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = -1
        L_0x0004:
            int r4 = getNumberOfCPUCores()     // Catch:{ IOException -> 0x008c }
            if (r2 >= r4) goto L_0x006e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
            r4.<init>()     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            r4.append(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x008c }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x008c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x008c }
            boolean r4 = r5.exists()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            boolean r4 = r5.canRead()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            r4 = 128(0x80, float:1.794E-43)
            byte[] r6 = new byte[r4]     // Catch:{ IOException -> 0x008c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            r7.<init>(r5)     // Catch:{ IOException -> 0x008c }
            r7.read(r6)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r5 = 0
        L_0x003e:
            byte r8 = r6[r5]     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            boolean r8 = java.lang.Character.isDigit(r8)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r8 == 0) goto L_0x004b
            if (r5 >= r4) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x003e
        L_0x004b:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r4.<init>(r6, r0, r5)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r5 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r5 <= r3) goto L_0x0062
            int r3 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
        L_0x0062:
            r7.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x006b
        L_0x0066:
            r0 = move-exception
            r7.close()     // Catch:{ IOException -> 0x008c }
            throw r0     // Catch:{ IOException -> 0x008c }
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x006e:
            if (r3 != r1) goto L_0x008b
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "/proc/cpuinfo"
            r0.<init>(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "cpu MHz"
            int r2 = m11347a((java.lang.String) r2, (java.io.FileInputStream) r0)     // Catch:{ all -> 0x0086 }
            int r2 = r2 * 1000
            if (r2 <= r3) goto L_0x0082
            r3 = r2
        L_0x0082:
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x008b
        L_0x0086:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x008c }
            throw r2     // Catch:{ IOException -> 0x008c }
        L_0x008b:
            r1 = r3
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.util.DeviceInfo.getCPUMaxFreqKHz():int");
    }

    public static long getTotalMemory(Context context) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) m11347a("MemTotal", fileInputStream)) * 1024;
            fileInputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        return j;
    }

    /* renamed from: a */
    private static int m11347a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return m11348a(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static int m11348a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}
