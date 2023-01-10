package com.didi.global.ninja;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.ninja.NinjaConst;
import com.didi.global.ninja.crash.CrashHandler;
import com.didi.global.ninja.strategy.IStrategy;
import com.didi.global.ninja.strategy.StrategyManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;

public class Ninja {
    public static final String TAG = "Ninja";

    /* renamed from: c */
    private static volatile Ninja f24775c;

    /* renamed from: a */
    private volatile boolean f24776a = false;

    /* renamed from: b */
    private CrashHandler f24777b;

    /* renamed from: d */
    private Context f24778d;

    /* renamed from: e */
    private boolean f24779e = false;

    private Ninja(Context context) {
        this.f24778d = context.getApplicationContext();
        this.f24779e = Apollo.getToggle("global_passenger_ninja_control", true).allow();
        SystemUtils.log(6, TAG, "apollo toggle:" + this.f24779e, (Throwable) null, "com.didi.global.ninja.Ninja", 27);
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.didi.global.ninja.Ninja getInstance(android.content.Context r2) {
        /*
            java.lang.Class<com.didi.global.ninja.Ninja> r0 = com.didi.global.ninja.Ninja.class
            monitor-enter(r0)
            com.didi.global.ninja.Ninja r1 = f24775c     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.didi.global.ninja.Ninja r1 = f24775c     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.didi.global.ninja.Ninja r1 = new com.didi.global.ninja.Ninja     // Catch:{ all -> 0x0015 }
            r1.<init>(r2)     // Catch:{ all -> 0x0015 }
            f24775c = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.didi.global.ninja.Ninja r2 = f24775c     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.ninja.Ninja.getInstance(android.content.Context):com.didi.global.ninja.Ninja");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f24779e     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            boolean r0 = r2.f24776a     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023
            r0 = 1
            r2.f24776a = r0     // Catch:{ all -> 0x0025 }
            com.didi.global.ninja.crash.CrashHandler r0 = new com.didi.global.ninja.crash.CrashHandler     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
            r2.f24777b = r0     // Catch:{ all -> 0x0025 }
            android.content.Context r1 = r2.f24778d     // Catch:{ all -> 0x0025 }
            r0.init(r1)     // Catch:{ all -> 0x0025 }
            android.content.Context r0 = r2.f24778d     // Catch:{ all -> 0x0025 }
            com.didi.global.ninja.strategy.StrategyManager r0 = com.didi.global.ninja.strategy.StrategyManager.getInstance(r0)     // Catch:{ all -> 0x0025 }
            r0.init()     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.ninja.Ninja.init():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initByLocal() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f24779e     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            boolean r0 = r2.f24776a     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023
            r0 = 1
            r2.f24776a = r0     // Catch:{ all -> 0x0025 }
            com.didi.global.ninja.crash.CrashHandler r0 = new com.didi.global.ninja.crash.CrashHandler     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
            r2.f24777b = r0     // Catch:{ all -> 0x0025 }
            android.content.Context r1 = r2.f24778d     // Catch:{ all -> 0x0025 }
            r0.init(r1)     // Catch:{ all -> 0x0025 }
            android.content.Context r0 = r2.f24778d     // Catch:{ all -> 0x0025 }
            com.didi.global.ninja.strategy.StrategyManager r0 = com.didi.global.ninja.strategy.StrategyManager.getInstance(r0)     // Catch:{ all -> 0x0025 }
            r0.processConfigData()     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.ninja.Ninja.initByLocal():void");
    }

    public void registe(String str, IStrategy iStrategy) throws Exception {
        if (this.f24779e) {
            if (TextUtils.isEmpty(str) || iStrategy == null) {
                SystemUtils.log(6, TAG, "registe error empty key or strategy", (Throwable) null, "com.didi.global.ninja.Ninja", 90);
                throw new Exception();
            }
            iStrategy.setContext(this.f24778d);
            StrategyManager.getInstance(this.f24778d).registerException(str, iStrategy);
        }
    }

    public boolean isHit(String str) {
        if (TextUtils.isEmpty(str) || !this.f24779e) {
            return false;
        }
        StrategyManager instance = StrategyManager.getInstance(this.f24778d);
        if (str.equals("FACEBOOK_LOGIN") || str.equals("FACEBOOK_SHARE")) {
            if (instance.isApolloHit(NinjaConst.Apollo.INTERNAL_APOLLO_NAME, NinjaConst.Apollo.FACEBOOK_APOLLO_PARAM, true)) {
                return true;
            }
        } else if (str.equals("GOOGLE_LOGIN") && instance.isApolloHit(NinjaConst.Apollo.INTERNAL_APOLLO_NAME, NinjaConst.Apollo.GOOGLE_LOGIN_APOLLO_PARAM, false)) {
            return true;
        }
        return instance.isHit(str);
    }

    public void setApolloToggle(boolean z) {
        this.f24779e = z;
    }
}
