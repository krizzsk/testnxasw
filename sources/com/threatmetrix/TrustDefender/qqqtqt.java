package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.HashSet;
import java.util.Set;

public class qqqtqt {
    private static final String b007200720072rrr = "java.lang.SecurityException: ";
    private static final Object b0072r0072rrr = new Object();
    private static final String br00720072rrr = "android.permission.";
    private static Set<String> brr0072rrr = new HashSet();

    private qqqtqt() {
    }

    public static void b0079007900790079yy(Set<String> set) {
        for (String by0079yy0079y : set) {
            by0079yy0079y(by0079yy0079y);
        }
    }

    public static void b00790079yy0079y(String str, String str2) {
        yyyyqy.qyyyqy.b00740074tttt(str2, "User refuse granting permission {}", str);
        by0079yy0079y(str);
    }

    public static void b0079y0079y0079y() {
        synchronized (b0072r0072rrr) {
            brr0072rrr.clear();
        }
    }

    public static void b0079yyy0079y(Exception exc, String str) {
        yyyyqy.qyyyqy.b00740074tttt(str, "User refuse granting permission {}", exc.toString());
        byyyy0079y(exc);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void by0079yy0079y(java.lang.String r4) {
        /*
            java.lang.String r0 = "android.permission."
            int r0 = r4.indexOf(r0)
            if (r0 != 0) goto L_0x000f
            r0 = 19
        L_0x000a:
            java.lang.String r4 = r4.substring(r0)
            goto L_0x001a
        L_0x000f:
            java.lang.String r0 = "java.lang.SecurityException: "
            int r0 = r4.indexOf(r0)
            if (r0 != 0) goto L_0x001a
            r0 = 29
            goto L_0x000a
        L_0x001a:
            java.lang.Object r0 = b0072r0072rrr
            monitor-enter(r0)
            java.util.Set<java.lang.String> r1 = brr0072rrr     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ all -> 0x003a }
            r2.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "\""
            r2.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x003a }
            r1.add(r4)     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qqqtqt.by0079yy0079y(java.lang.String):void");
    }

    public static String byy0079y0079y() {
        synchronized (b0072r0072rrr) {
            if (brr0072rrr.isEmpty()) {
                return "";
            }
            String obj = brr0072rrr.toString();
            return obj;
        }
    }

    public static void byyyy0079y(Exception exc) {
        if (exc instanceof SecurityException) {
            String b00690069iii0069 = yqqyqq.b00690069iii0069(exc.toString(), br00720072rrr, " ", true);
            if (yqqyqq.b0069ii0069i0069(b00690069iii0069)) {
                by0079yy0079y(b00690069iii0069);
            }
        }
    }
}
