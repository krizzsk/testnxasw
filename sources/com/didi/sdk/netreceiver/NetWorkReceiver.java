package com.didi.sdk.netreceiver;

import android.content.BroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

public class NetWorkReceiver extends BroadcastReceiver {
    public static final int NETSTATUS_INAVAILABLE = 0;
    public static final int NETSTATUS_MOBILE = 2;
    public static final int NETSTATUS_WIFI = 1;

    /* renamed from: b */
    private static NetWorkReceiver f39659b;
    public static int netStatus;

    /* renamed from: a */
    private List<NetWorkChangedListener> f39660a = new ArrayList();

    public interface NetWorkChangedListener {
        void onChanged(int i);
    }

    private NetWorkReceiver() {
    }

    public static NetWorkReceiver getInstance() {
        if (f39659b == null) {
            f39659b = new NetWorkReceiver();
        }
        return f39659b;
    }

    public void register(NetWorkChangedListener netWorkChangedListener) {
        synchronized (this.f39660a) {
            this.f39660a.add(netWorkChangedListener);
        }
    }

    public void unRegister(NetWorkChangedListener netWorkChangedListener) {
        synchronized (this.f39660a) {
            this.f39660a.remove(netWorkChangedListener);
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bb  */
    public void onReceive(android.content.Context r20, android.content.Intent r21) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "connectivity"
            r2 = r20
            java.lang.Object r0 = r2.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r2 = 0
            r3 = 1
            r4 = 0
            android.net.NetworkInfo r5 = r0.getNetworkInfo(r4)     // Catch:{ Exception -> 0x0021 }
            android.net.NetworkInfo r6 = r0.getNetworkInfo(r3)     // Catch:{ Exception -> 0x001e }
            android.net.NetworkInfo r2 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r0)     // Catch:{ Exception -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r0 = move-exception
            goto L_0x0024
        L_0x001e:
            r0 = move-exception
            r6 = r2
            goto L_0x0024
        L_0x0021:
            r0 = move-exception
            r5 = r2
            r6 = r5
        L_0x0024:
            r0.printStackTrace()
        L_0x0027:
            r0 = 2
            if (r2 != 0) goto L_0x00bb
            if (r5 == 0) goto L_0x0059
            java.lang.String r8 = "net-status"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "allNetInfo null  mobmobileNetInfo.isConnected() = "
            r2.append(r7)
            boolean r7 = r5.isConnected()
            r2.append(r7)
            java.lang.String r7 = " mobileNetInfo.isConnectedOrConnecting() = "
            r2.append(r7)
            boolean r7 = r5.isConnectedOrConnecting()
            r2.append(r7)
            java.lang.String r9 = r2.toString()
            r7 = 6
            r10 = 0
            java.lang.String r11 = "com.didi.sdk.netreceiver.NetWorkReceiver"
            r12 = 66
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            goto L_0x0088
        L_0x0059:
            if (r6 == 0) goto L_0x0088
            java.lang.String r14 = "net-status"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "allNetInfo null  wifiNetInfo.isConnected() = "
            r2.append(r7)
            boolean r7 = r6.isConnected()
            r2.append(r7)
            java.lang.String r7 = " wifiNetInfo.isConnectedOrConnecting() = "
            r2.append(r7)
            boolean r7 = r6.isConnectedOrConnecting()
            r2.append(r7)
            java.lang.String r15 = r2.toString()
            r13 = 6
            r16 = 0
            java.lang.String r17 = "com.didi.sdk.netreceiver.NetWorkReceiver"
            r18 = 68
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)
        L_0x0088:
            if (r5 == 0) goto L_0x009a
            boolean r2 = r5.isConnected()
            if (r2 != 0) goto L_0x0096
            boolean r2 = r5.isConnectedOrConnecting()
            if (r2 == 0) goto L_0x009a
        L_0x0096:
            netStatus = r0
            goto L_0x0117
        L_0x009a:
            if (r6 == 0) goto L_0x00ab
            boolean r0 = r6.isConnected()
            if (r0 != 0) goto L_0x00a8
            boolean r0 = r6.isConnectedOrConnecting()
            if (r0 == 0) goto L_0x00ab
        L_0x00a8:
            netStatus = r3
            goto L_0x0117
        L_0x00ab:
            java.lang.String r6 = "net-status"
            java.lang.String r7 = "allNetInfo null NETSTATUS_INAVAILABLE"
            r5 = 6
            r8 = 0
            java.lang.String r9 = "com.didi.sdk.netreceiver.NetWorkReceiver"
            r10 = 76
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
            netStatus = r4
            goto L_0x0117
        L_0x00bb:
            java.lang.String r12 = "net-status"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "allNetInfo not null  allNetInfo.isConnected() = "
            r6.append(r7)
            boolean r7 = r2.isConnected()
            r6.append(r7)
            java.lang.String r7 = " allNetInfo.isConnectedOrConnecting() = "
            r6.append(r7)
            boolean r7 = r2.isConnectedOrConnecting()
            r6.append(r7)
            java.lang.String r13 = r6.toString()
            r11 = 6
            r14 = 0
            java.lang.String r15 = "com.didi.sdk.netreceiver.NetWorkReceiver"
            r16 = 80
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
            boolean r6 = r2.isConnected()
            if (r6 != 0) goto L_0x0104
            boolean r2 = r2.isConnectedOrConnecting()
            if (r2 == 0) goto L_0x00f4
            goto L_0x0104
        L_0x00f4:
            java.lang.String r7 = "net-status"
            java.lang.String r8 = "allNetInfo not null NETSTATUS_INAVAILABLE"
            r6 = 6
            r9 = 0
            java.lang.String r10 = "com.didi.sdk.netreceiver.NetWorkReceiver"
            r11 = 89
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
            netStatus = r4
            goto L_0x0117
        L_0x0104:
            if (r5 == 0) goto L_0x0115
            boolean r2 = r5.isConnected()
            if (r2 != 0) goto L_0x0112
            boolean r2 = r5.isConnectedOrConnecting()
            if (r2 == 0) goto L_0x0115
        L_0x0112:
            netStatus = r0
            goto L_0x0117
        L_0x0115:
            netStatus = r3
        L_0x0117:
            java.util.List<com.didi.sdk.netreceiver.NetWorkReceiver$NetWorkChangedListener> r2 = r1.f39660a
            monitor-enter(r2)
        L_0x011a:
            java.util.List<com.didi.sdk.netreceiver.NetWorkReceiver$NetWorkChangedListener> r0 = r1.f39660a     // Catch:{ all -> 0x0134 }
            int r0 = r0.size()     // Catch:{ all -> 0x0134 }
            if (r4 >= r0) goto L_0x0132
            java.util.List<com.didi.sdk.netreceiver.NetWorkReceiver$NetWorkChangedListener> r0 = r1.f39660a     // Catch:{ all -> 0x0134 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0134 }
            com.didi.sdk.netreceiver.NetWorkReceiver$NetWorkChangedListener r0 = (com.didi.sdk.netreceiver.NetWorkReceiver.NetWorkChangedListener) r0     // Catch:{ all -> 0x0134 }
            int r3 = netStatus     // Catch:{ all -> 0x0134 }
            r0.onChanged(r3)     // Catch:{ all -> 0x0134 }
            int r4 = r4 + 1
            goto L_0x011a
        L_0x0132:
            monitor-exit(r2)     // Catch:{ all -> 0x0134 }
            return
        L_0x0134:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0134 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.netreceiver.NetWorkReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
