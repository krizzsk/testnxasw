package com.threatmetrix.TrustDefender;

import android.content.Context;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.threatmetrix.TrustDefender.jjkjkj;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class yyqyqy {
    private static final long b00700070ppp0070 = 2;
    /* access modifiers changed from: private */
    public static final String b0070p0070pp0070 = yyyyqy.b0074t007400740074t(yyqyqy.class);
    private static final Map<String, Long> bp00700070pp0070;
    private static final long bp0070ppp0070 = 1;
    public static final long bpp0070pp0070 = 4;
    private Map<String, qqyyqy> b007000700070pp0070 = new TreeMap();
    private long bppp0070p0070;

    static {
        HashMap hashMap = new HashMap();
        bp00700070pp0070 = hashMap;
        hashMap.put(qqyyqy.bp00700070p0070p, 1L);
        bp00700070pp0070.put(qqyyqy.b0070p0070p0070p, 2L);
        bp00700070pp0070.put(qqyyqy.b007000700070p0070p, 4L);
    }

    public static boolean b006700670067ggg(String str, qqyyqy qqyyqy) {
        if (qqyyqy == null) {
            return false;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1951042291) {
            if (hashCode != -96285750) {
                if (hashCode == 1026190327 && str.equals(qqyyqy.b007000700070p0070p)) {
                    c = 2;
                }
            } else if (str.equals(qqyyqy.bp00700070p0070p)) {
                c = 0;
            }
        } else if (str.equals(qqyyqy.b0070p0070p0070p)) {
            c = 1;
        }
        if (c == 0) {
            return qqyyqy instanceof qqqtqq;
        }
        if (c == 1) {
            return true;
        }
        if (c != 2) {
            return false;
        }
        return qqyyqy instanceof qqttqt;
    }

    public static TMXProfilingConnectionsInterface b0067gg0067gg() {
        ArrayList<TMXProfilingConnectionsInterface> bggg0067gg = bggg0067gg(TMXProfilingConnectionsInterface.class);
        if (bggg0067gg == null || bggg0067gg.isEmpty()) {
            return null;
        }
        return bggg0067gg.get(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.threatmetrix.TrustDefender.qqyyqy b00740074t007400740074(java.lang.String r4, java.lang.Object r5, java.lang.String r6) {
        /*
            int r0 = r4.hashCode()
            r1 = -1951042291(0xffffffff8bb5750d, float:-6.989478E-32)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -96285750(0xfffffffffa42cbca, float:-2.5285973E35)
            if (r0 == r1) goto L_0x0020
            r1 = 1026190327(0x3d2a6bf7, float:0.04160687)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "MODULE_TYPE_DEVICE_SECURITY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "MODULE_TYPE_AUTHENTICATION"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "MODULE_TYPE_BIOMETRICS"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0049
            if (r4 == r3) goto L_0x0043
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.threatmetrix.TrustDefender.qqttqt r4 = new com.threatmetrix.TrustDefender.qqttqt
            r4.<init>(r5, r6)
            return r4
        L_0x0043:
            com.threatmetrix.TrustDefender.qqyyqy r4 = new com.threatmetrix.TrustDefender.qqyyqy
            r4.<init>(r5, r6)
            return r4
        L_0x0049:
            com.threatmetrix.TrustDefender.qqqtqq r4 = new com.threatmetrix.TrustDefender.qqqtqq
            r4.<init>(r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyqy.b00740074t007400740074(java.lang.String, java.lang.Object, java.lang.String):com.threatmetrix.TrustDefender.qqyyqy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> b0074t0074007400740074(java.lang.String r6, android.content.Context r7) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r6.hashCode()
            r2 = -1951042291(0xffffffff8bb5750d, float:-6.989478E-32)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002f
            r2 = -96285750(0xfffffffffa42cbca, float:-2.5285973E35)
            if (r1 == r2) goto L_0x0025
            r2 = 1026190327(0x3d2a6bf7, float:0.04160687)
            if (r1 == r2) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r1 = "MODULE_TYPE_DEVICE_SECURITY"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0039
            r6 = 2
            goto L_0x003a
        L_0x0025:
            java.lang.String r1 = "MODULE_TYPE_AUTHENTICATION"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0039
            r6 = 0
            goto L_0x003a
        L_0x002f:
            java.lang.String r1 = "MODULE_TYPE_BIOMETRICS"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0039
            r6 = 1
            goto L_0x003a
        L_0x0039:
            r6 = -1
        L_0x003a:
            java.lang.String r1 = "androidVersion"
            if (r6 == 0) goto L_0x0093
            if (r6 == r4) goto L_0x007f
            if (r6 == r3) goto L_0x0044
            goto L_0x00c3
        L_0x0044:
            boolean r6 = com.threatmetrix.TrustDefender.yyyyqy.bttt00740074t()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r2 = "infoLoggingStatus"
            r0.put(r2, r6)
            boolean r6 = com.threatmetrix.TrustDefender.yyyyqy.b007400740074t0074t()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r2 = "nonFatalLoggingStatus"
            r0.put(r2, r6)
            int r6 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.b006E006En006En006E
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r1, r6)
            com.threatmetrix.TrustDefender.tqttqq$qtqttq r6 = new com.threatmetrix.TrustDefender.tqttqq$qtqttq
            com.threatmetrix.TrustDefender.tqttqq r1 = new com.threatmetrix.TrustDefender.tqttqq
            r1.<init>()
            r1.getClass()
            r6.<init>(r7)
            boolean r6 = r6.bvv0076v0076v()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "canCallGetInstalledApplications"
            goto L_0x00c0
        L_0x007f:
            int r6 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.b006E006En006En006E
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r1, r6)
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.tttttq.bvv00760076v0076()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "hasElapsedRealtimeNanos"
            goto L_0x00c0
        L_0x0093:
            int r6 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.b006E006En006En006E
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r1, r6)
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.qqtqtq.buu0075u00750075()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "isHardwareStrongIDCanSign"
            r0.put(r7, r6)
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.qqtqtq.b0075u0075u00750075()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "isHardwareStrongIDApi18Available"
            r0.put(r7, r6)
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.qqtqtq.bu00750075u00750075()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "isHardwareStrongIDApi23Available"
        L_0x00c0:
            r0.put(r7, r6)
        L_0x00c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyqy.b0074t0074007400740074(java.lang.String, android.content.Context):java.util.Map");
    }

    private qqyyqy bg0067gggg(String str) {
        if (!this.b007000700070pp0070.containsKey(str) || !b006700670067ggg(str, this.b007000700070pp0070.get(str))) {
            return null;
        }
        return this.b007000700070pp0070.get(str);
    }

    public static boolean bgg00670067gg(String str, String str2) {
        int indexOf;
        if (yqqyqq.bi0069i0069i0069(str) || yqqyqq.bi0069i0069i0069(str2) || (indexOf = str.indexOf(45)) <= 0) {
            return false;
        }
        return str.regionMatches(0, str2, 0, indexOf);
    }

    private static <T> ArrayList<T> bggg0067gg(final Class cls) {
        try {
            return (ArrayList) Executors.newSingleThreadExecutor().submit(new Callable<ArrayList<T>>() {
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
                    r5 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                    com.threatmetrix.TrustDefender.yyyyqy.bttttt0074(com.threatmetrix.TrustDefender.yyqyqy.b007400740074t00740074(), "Failed to load module ({}): {}", r4.getSimpleName(), r5.getMessage());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x009f, code lost:
                    r3 = e;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x009f A[ExcHandler: ClassNotFoundException (e java.lang.ClassNotFoundException), Splitter:B:1:0x0003] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.util.ArrayList<T> call() {
                    /*
                        r11 = this;
                        r0 = 1
                        r1 = 0
                        r2 = 2
                        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r3.<init>()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.Class r4 = r4     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        if (r4 == 0) goto L_0x007d
                        java.lang.Class r5 = r4     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        com.threatmetrix.TrustDefender.TMXModuleClassLoader r6 = new com.threatmetrix.TrustDefender.TMXModuleClassLoader     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r6.<init>(r4)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.util.ServiceLoader r4 = java.util.ServiceLoader.load(r5, r6)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.util.Iterator r4 = r4.iterator()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                    L_0x001f:
                        boolean r5 = r4.hasNext()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        if (r5 == 0) goto L_0x0076
                        java.lang.Object r5 = r4.next()     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        java.lang.String r6 = "6.3-80"
                        boolean r7 = r5 instanceof com.threatmetrix.TrustDefender.TMXModuleMetadataProviderInterface     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        if (r7 == 0) goto L_0x001f
                        r7 = r5
                        com.threatmetrix.TrustDefender.TMXModuleMetadataProviderInterface r7 = (com.threatmetrix.TrustDefender.TMXModuleMetadataProviderInterface) r7     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        java.lang.String r7 = r7.getModuleVersion()     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        boolean r8 = com.threatmetrix.TrustDefender.yyqyqy.bgg00670067gg(r6, r7)     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        if (r8 != 0) goto L_0x0055
                        java.lang.String r5 = com.threatmetrix.TrustDefender.yyqyqy.b0070p0070pp0070     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        java.lang.String r8 = "module {} version mismatch(expected {}, actual {})"
                        r9 = 3
                        java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        java.lang.Class r10 = r4     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        java.lang.String r10 = r10.getSimpleName()     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        r9[r1] = r10     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        r9[r0] = r6     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        r9[r2] = r7     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        com.threatmetrix.TrustDefender.yyyyqy.btt007400740074t(r5, r8, r9)     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        goto L_0x001f
                    L_0x0055:
                        r3.add(r5)     // Catch:{ ServiceConfigurationError -> 0x005b, SecurityException -> 0x0059, ClassNotFoundException -> 0x009f }
                        goto L_0x001f
                    L_0x0059:
                        r5 = move-exception
                        goto L_0x005c
                    L_0x005b:
                        r5 = move-exception
                    L_0x005c:
                        java.lang.String r6 = com.threatmetrix.TrustDefender.yyqyqy.b0070p0070pp0070     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r7 = "Failed to load module ({}): {}"
                        java.lang.String[] r8 = new java.lang.String[r2]     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.Class r9 = r4     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r9 = r9.getSimpleName()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r8[r1] = r9     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r5 = r5.getMessage()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r8[r0] = r5     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        com.threatmetrix.TrustDefender.yyyyqy.bttttt0074(r6, r7, r8)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        goto L_0x001f
                    L_0x0076:
                        boolean r0 = r3.isEmpty()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        if (r0 != 0) goto L_0x00bd
                        return r3
                    L_0x007d:
                        java.lang.ClassNotFoundException r3 = new java.lang.ClassNotFoundException     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r4.<init>()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r5 = "Failed to get "
                        r4.append(r5)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.Class r5 = r4     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r5 = r5.getSimpleName()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r4.append(r5)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r5 = " class loader"
                        r4.append(r5)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        java.lang.String r4 = r4.toString()     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        r3.<init>(r4)     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                        throw r3     // Catch:{ ServiceConfigurationError -> 0x00a3, SecurityException -> 0x00a1, ClassNotFoundException -> 0x009f }
                    L_0x009f:
                        r3 = move-exception
                        goto L_0x00a4
                    L_0x00a1:
                        r3 = move-exception
                        goto L_0x00a4
                    L_0x00a3:
                        r3 = move-exception
                    L_0x00a4:
                        java.lang.String r4 = com.threatmetrix.TrustDefender.yyqyqy.b0070p0070pp0070
                        java.lang.String[] r2 = new java.lang.String[r2]
                        java.lang.Class r5 = r4
                        java.lang.String r5 = r5.getSimpleName()
                        r2[r1] = r5
                        java.lang.String r1 = r3.getMessage()
                        r2[r0] = r1
                        java.lang.String r0 = "Failed to configure service loader ({}): {}"
                        com.threatmetrix.TrustDefender.yyyyqy.btt007400740074t(r4, r0, r2)
                    L_0x00bd:
                        r0 = 0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyqy.C215912.call():java.util.ArrayList");
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            yyyyqy.bttttt0074(b0070p0070pp0070, "Failed to load module({}): {}", cls.getSimpleName(), e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bttt007400740074(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1951042291(0xffffffff8bb5750d, float:-6.989478E-32)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = -96285750(0xfffffffffa42cbca, float:-2.5285973E35)
            if (r0 == r1) goto L_0x0021
            r1 = 1026190327(0x3d2a6bf7, float:0.04160687)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "MODULE_TYPE_DEVICE_SECURITY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "MODULE_TYPE_AUTHENTICATION"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 1
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "MODULE_TYPE_BIOMETRICS"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 0
            goto L_0x0036
        L_0x0035:
            r6 = -1
        L_0x0036:
            if (r6 == 0) goto L_0x003e
            if (r6 == r4) goto L_0x003d
            if (r6 == r2) goto L_0x003d
            return r3
        L_0x003d:
            return r4
        L_0x003e:
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.tqtttq.bv0076vvv0076()
            if (r6 == 0) goto L_0x004b
            boolean r6 = com.threatmetrix.TrustDefender.tqttqq.tqtttq.b00760076vvv0076()
            if (r6 == 0) goto L_0x004b
            r3 = 1
        L_0x004b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyqy.bttt007400740074(java.lang.String):boolean");
    }

    @Nullable
    public Map<String, String> b00670067g0067gg(yqqqqq yqqqqq, long j, Map<String, Object> map) {
        qqyyqy bg0067gggg = bg0067gggg(qqyyqy.b0070p0070p0070p);
        if (!b006700670067ggg(qqyyqy.b0070p0070p0070p, bg0067gggg)) {
            return null;
        }
        HashMap hashMap = new HashMap(16);
        hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, Long.valueOf(j));
        hashMap.put("uiDataDuration", Integer.valueOf(yqqqqq.bmm006Dmm006D));
        hashMap.put("uiDataInterval", Integer.valueOf(yqqqqq.b006Dm006Dmm006D));
        hashMap.put("uiDataPrecisionCount", Integer.valueOf(yqqqqq.bm006D006Dmm006D));
        hashMap.put("uiDataTransmissionLimit", Integer.valueOf(yqqqqq.b006D006D006Dmm006D));
        hashMap.put("sensorDuration", Integer.valueOf(yqqqqq.bmmm006Dm006D));
        hashMap.put("sensorInterval", Integer.valueOf(yqqqqq.b006Dmm006Dm006D));
        hashMap.put("sensorPrecisionCount", Integer.valueOf(yqqqqq.bm006Dm006Dm006D));
        hashMap.put("sensorTransmissionSize", Integer.valueOf(yqqqqq.b006D006Dm006Dm006D));
        hashMap.put("transmissionFrequency", Integer.valueOf(yqqqqq.bmm006D006Dm006D));
        hashMap.put("bbShouldSendSensorRawData", Integer.valueOf(yqqqqq.b006Dm006D006Dm006D));
        hashMap.put("bbShouldSendSensorStatsData", Integer.valueOf(yqqqqq.bm006D006D006Dm006D));
        hashMap.put("bbShouldSendUIRawData", Integer.valueOf(yqqqqq.b006D006D006D006Dm006D));
        hashMap.put("bbShouldSendUIStatsData", Integer.valueOf(yqqqqq.bmmmm006D006D));
        hashMap.put("sensorIntervalThreshold", Integer.valueOf(yqqqqq.b006Dmmm006D006D));
        hashMap.putAll(map);
        return bg0067gggg.bt00740074t00740074(hashMap);
    }

    public Long b00670067gggg(String str, int i) {
        qqyyqy bg0067gggg = bg0067gggg(str);
        if (b006700670067ggg(str, bg0067gggg)) {
            return bg0067gggg.b0074007400740074t0074(i);
        }
        return 0L;
    }

    public List<String> b0067g0067ggg(Context context) {
        qqyyqy b00740074t007400740074;
        ArrayList<TMXModuleInitializerInterface> bggg0067gg = bggg0067gg(TMXModuleInitializerInterface.class);
        if (bggg0067gg == null) {
            yyyyqy.qyyyqy.b00740074t0074tt(b0070p0070pp0070, "module list is null");
            return null;
        }
        Iterator<TMXModuleInitializerInterface> it = bggg0067gg.iterator();
        while (it.hasNext()) {
            TMXModuleInitializerInterface next = it.next();
            yyyyqy.qyyyqy.b00740074t0074tt(b0070p0070pp0070, "init module");
            Pair<String, Object> initialize = next.initialize();
            if (initialize != null && bttt007400740074((String) initialize.first) && (b00740074t007400740074 = b00740074t007400740074((String) initialize.first, initialize.second, next.getNativeLibName())) != null && b00740074t007400740074.b00750075007500750075u() && !this.b007000700070pp0070.containsKey(initialize.first)) {
                this.b007000700070pp0070.put(initialize.first, b00740074t007400740074);
            }
        }
        ArrayList arrayList = new ArrayList();
        this.bppp0070p0070 = 0;
        for (Map.Entry next2 : this.b007000700070pp0070.entrySet()) {
            qqyyqy qqyyqy = (qqyyqy) next2.getValue();
            if (qqyyqy != null) {
                if (qqyyqy.btt00740074t0074(context, b0074t0074007400740074((String) next2.getKey(), context))) {
                    arrayList.add(qqyyqy.btttt00740074());
                    if (bp00700070pp0070.containsKey(next2.getKey())) {
                        Long l = bp00700070pp0070.get(next2.getKey());
                        if (l != null) {
                            this.bppp0070p0070 |= l.longValue();
                        }
                        ((qqyyqy) next2.getValue()).b0074t0074t00740074();
                    }
                } else {
                    yyyyqy.btt007400740074t(b0070p0070pp0070, "Failed to configure module({})", qqyyqy.btttt00740074());
                }
            }
        }
        return arrayList;
    }

    public long b0067ggggg() {
        return this.bppp0070p0070;
    }

    public void b0074tt007400740074() {
        for (Map.Entry<String, qqyyqy> value : this.b007000700070pp0070.entrySet()) {
            qqyyqy qqyyqy = (qqyyqy) value.getValue();
            if (qqyyqy != null && qqyyqy.bt0074tt00740074()) {
                qqyyqy.b00740074t0074t0074();
            }
        }
    }

    public boolean bg00670067ggg() {
        for (Map.Entry<String, qqyyqy> value : this.b007000700070pp0070.entrySet()) {
            qqyyqy qqyyqy = (qqyyqy) value.getValue();
            if (qqyyqy != null && qqyyqy.btt0074t00740074()) {
                return true;
            }
        }
        return false;
    }

    public boolean bg0067g0067gg(tqtqqt tqtqqt, yqyyyq yqyyyq, @Nonnull jjkjkj.kjkjjk kjkjjk, long j, int i, @Nullable TMXScanEndNotifier tMXScanEndNotifier) {
        String str;
        String str2;
        jjkjkj.kjkjjk kjkjjk2 = kjkjjk;
        final qqyyqy bg0067gggg = bg0067gggg(qqyyqy.b007000700070p0070p);
        if (!(bg0067gggg instanceof qqttqt)) {
            str = b0070p0070pp0070;
            str2 = "Invalid module";
        } else {
            final boolean z = kjkjjk2 == jjkjkj.kjkjjk.INIT || kjkjjk2 == jjkjkj.kjkjjk.PROFILE;
            if (!z && (j & qqqqqy.b0061006100610061aa) == 0) {
                str = b0070p0070pp0070;
                str2 = "Scan option is not enabled";
            } else if (!yqyyyq.b0078x00780078x0078(z)) {
                str = b0070p0070pp0070;
                str2 = "Scan already in progress or cancel requested, aborting";
            } else {
                final jjkjkj.kjkjjk kjkjjk3 = kjkjjk;
                final tqtqqt tqtqqt2 = tqtqqt;
                final long j2 = j;
                final int i2 = i;
                final yqyyyq yqyyyq2 = yqyyyq;
                final TMXScanEndNotifier tMXScanEndNotifier2 = tMXScanEndNotifier;
                new Thread(new Runnable() {
                    public void run() {
                        StringBuilder sb;
                        String str;
                        try {
                            yyyyqy.bttttt0074(yyqyqy.b0070p0070pp0070, "scanPackages({}): marking scan as started", kjkjjk3.toString());
                            ((qqttqt) bg0067gggg).by00790079y0079y(tqtqqt2.bll006C006C006C006C, z, j2, i2);
                            String b007400740074t00740074 = yyqyqy.b0070p0070pp0070;
                            yyyyqy.qyyyqy.bt0074tttt(b007400740074t00740074, "scanPackages(" + kjkjjk3 + "): complete");
                            yqyyyq2.bxxxxx0078();
                            TMXScanEndNotifier tMXScanEndNotifier = tMXScanEndNotifier2;
                            if (tMXScanEndNotifier != null) {
                                try {
                                    tMXScanEndNotifier.complete();
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    str = yyqyqy.b0070p0070pp0070;
                                    sb = new StringBuilder();
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = yyqyqy.b0070p0070pp0070;
                            sb = new StringBuilder();
                        }
                        sb.append("Unexpected exception occurred when calling EndNotifier ");
                        sb.append(th.toString());
                        yyyyqy.bt0074t00740074t(str, sb.toString());
                    }
                }).start();
                return true;
            }
        }
        yyyyqy.qyyyqy.bt0074tttt(str, str2);
        return false;
    }

    public String bgg0067ggg(String str) {
        qqyyqy bg0067gggg = bg0067gggg(str);
        if (b006700670067ggg(str, bg0067gggg)) {
            return bg0067gggg.bt007400740074t0074();
        }
        return null;
    }

    public Set<String> bt00740074007400740074() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, qqyyqy> value : this.b007000700070pp0070.entrySet()) {
            qqyyqy qqyyqy = (qqyyqy) value.getValue();
            if (qqyyqy != null && qqyyqy.bt0074tt00740074()) {
                hashSet.addAll(qqyyqy.b0074t00740074t0074());
            }
        }
        return hashSet;
    }

    public Map<String, String> bt0074t007400740074(long j) {
        qqyyqy bg0067gggg = bg0067gggg(qqyyqy.b007000700070p0070p);
        if (!b006700670067ggg(qqyyqy.b007000700070p0070p, bg0067gggg)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, Long.valueOf(j));
        return bg0067gggg.bt00740074t00740074(hashMap);
    }

    public qqqtqq btt0074007400740074() {
        qqyyqy bg0067gggg = bg0067gggg(qqyyqy.bp00700070p0070p);
        if (bg0067gggg == null || !bg0067gggg.bt0074tt00740074()) {
            return null;
        }
        return (qqqtqq) bg0067gggg;
    }
}
