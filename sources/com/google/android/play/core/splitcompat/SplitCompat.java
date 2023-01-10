package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C20043at;
import com.google.android.play.core.internal.C20044au;
import com.google.android.play.core.internal.C20046aw;
import com.google.android.play.core.internal.C20066bp;
import com.google.android.play.core.splitinstall.C20202l;
import com.google.android.play.core.splitinstall.C20206o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {

    /* renamed from: a */
    private static final AtomicReference<SplitCompat> f56159a = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C20151c f56160b;

    /* renamed from: c */
    private final Set<String> f56161c = new HashSet();

    /* renamed from: d */
    private final C20149a f56162d;

    private SplitCompat(Context context) {
        try {
            C20151c cVar = new C20151c(context);
            this.f56160b = cVar;
            this.f56162d = new C20149a(cVar);
        } catch (PackageManager.NameNotFoundException e) {
            throw new C20066bp((Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m42405a() {
        return f56159a.get() != null;
    }

    /* renamed from: a */
    public static boolean m42406a(Context context) {
        return m42407a(context, true);
    }

    /* renamed from: a */
    private static boolean m42407a(Context context, boolean z) {
        if (m42410b()) {
            return false;
        }
        boolean compareAndSet = f56159a.compareAndSet((Object) null, new SplitCompat(context));
        SplitCompat splitCompat = f56159a.get();
        if (compareAndSet) {
            C20202l.f56264a.mo164515a(new C20043at(context, C20164p.m42452a(), new C20044au(context, splitCompat.f56160b, new C20046aw(), (byte[]) null), splitCompat.f56160b, new C20164p()));
            C20206o.m42540a(new C20160l(splitCompat));
            C20164p.m42452a().execute(new C20161m(context));
        }
        try {
            splitCompat.m42409b(context, z);
            return true;
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error installing additional splits", e, "com.google.android.play.core.splitcompat.SplitCompat", -1);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ae A[SYNTHETIC, Splitter:B:81:0x01ae] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m42409b(android.content.Context r17, boolean r18) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            monitor-enter(r16)
            if (r0 == 0) goto L_0x000d
            com.google.android.play.core.splitcompat.c r2 = r1.f56160b     // Catch:{ all -> 0x0263 }
            r2.mo164435a()     // Catch:{ all -> 0x0263 }
            goto L_0x0019
        L_0x000d:
            java.util.concurrent.Executor r2 = com.google.android.play.core.splitcompat.C20164p.m42452a()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.n r3 = new com.google.android.play.core.splitcompat.n     // Catch:{ all -> 0x0263 }
            r3.<init>(r1)     // Catch:{ all -> 0x0263 }
            r2.execute(r3)     // Catch:{ all -> 0x0263 }
        L_0x0019:
            java.lang.String r2 = r17.getPackageName()     // Catch:{ all -> 0x0263 }
            r3 = 0
            android.content.pm.PackageManager r4 = r17.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0251 }
            android.content.pm.PackageInfo r4 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r4, r2, r3)     // Catch:{ NameNotFoundException -> 0x0251 }
            java.lang.String[] r5 = r4.splitNames     // Catch:{ NameNotFoundException -> 0x0251 }
            if (r5 != 0) goto L_0x0030
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x0251 }
            r4.<init>()     // Catch:{ NameNotFoundException -> 0x0251 }
            goto L_0x0036
        L_0x0030:
            java.lang.String[] r4 = r4.splitNames     // Catch:{ NameNotFoundException -> 0x0251 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NameNotFoundException -> 0x0251 }
        L_0x0036:
            com.google.android.play.core.splitcompat.c r2 = r1.f56160b     // Catch:{ all -> 0x0263 }
            java.util.Set r2 = r2.mo164441d()     // Catch:{ all -> 0x0263 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r5.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0045:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x006a
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C20165q) r7     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r7.mo164455b()     // Catch:{ all -> 0x0263 }
            boolean r8 = r4.contains(r7)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x0045
            if (r0 == 0) goto L_0x0063
            com.google.android.play.core.splitcompat.c r8 = r1.f56160b     // Catch:{ all -> 0x0263 }
            r8.mo164445f(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0066
        L_0x0063:
            r5.add(r7)     // Catch:{ all -> 0x0263 }
        L_0x0066:
            r6.remove()     // Catch:{ all -> 0x0263 }
            goto L_0x0045
        L_0x006a:
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x0263 }
            if (r6 != 0) goto L_0x007c
            java.util.concurrent.Executor r6 = com.google.android.play.core.splitcompat.C20164p.m42452a()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.o r7 = new com.google.android.play.core.splitcompat.o     // Catch:{ all -> 0x0263 }
            r7.<init>(r1, r5)     // Catch:{ all -> 0x0263 }
            r6.execute(r7)     // Catch:{ all -> 0x0263 }
        L_0x007c:
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r5.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0085:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x009f
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C20165q) r7     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r7.mo164455b()     // Catch:{ all -> 0x0263 }
            boolean r8 = com.google.android.play.core.splitinstall.C20207p.m42542b(r7)     // Catch:{ all -> 0x0263 }
            if (r8 != 0) goto L_0x0085
            r5.add(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0085
        L_0x009f:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x00a3:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0263 }
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0263 }
            boolean r7 = com.google.android.play.core.splitinstall.C20207p.m42542b(r6)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x00a3
            r5.add(r6)     // Catch:{ all -> 0x0263 }
            goto L_0x00a3
        L_0x00b9:
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            int r6 = r2.size()     // Catch:{ all -> 0x0263 }
            r4.<init>(r6)     // Catch:{ all -> 0x0263 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x00c6:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0263 }
            if (r6 == 0) goto L_0x00fc
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r6 = (com.google.android.play.core.splitcompat.C20165q) r6     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r6.mo164455b()     // Catch:{ all -> 0x0263 }
            boolean r7 = com.google.android.play.core.splitinstall.C20207p.m42541a(r7)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x00f8
            java.lang.String r7 = r6.mo164455b()     // Catch:{ all -> 0x0263 }
            boolean r8 = com.google.android.play.core.splitinstall.C20207p.m42541a(r7)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x00e9
            java.lang.String r7 = ""
            goto L_0x00f2
        L_0x00e9:
            java.lang.String r8 = "\\.config\\."
            r9 = 2
            java.lang.String[] r7 = r7.split(r8, r9)     // Catch:{ all -> 0x0263 }
            r7 = r7[r3]     // Catch:{ all -> 0x0263 }
        L_0x00f2:
            boolean r7 = r5.contains(r7)     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x00c6
        L_0x00f8:
            r4.add(r6)     // Catch:{ all -> 0x0263 }
            goto L_0x00c6
        L_0x00fc:
            com.google.android.play.core.splitcompat.k r2 = new com.google.android.play.core.splitcompat.k     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.c r3 = r1.f56160b     // Catch:{ all -> 0x0263 }
            r2.<init>(r3)     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.internal.av r3 = com.google.android.play.core.internal.C20046aw.m42170a()     // Catch:{ all -> 0x0263 }
            java.lang.ClassLoader r5 = r17.getClassLoader()     // Catch:{ all -> 0x0263 }
            if (r0 == 0) goto L_0x0115
            java.util.Set r2 = r2.mo164448a()     // Catch:{ all -> 0x0263 }
            r3.mo164286a(r5, r2)     // Catch:{ all -> 0x0263 }
            goto L_0x0133
        L_0x0115:
            java.util.Iterator r6 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0119:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x0133
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C20165q) r7     // Catch:{ all -> 0x0263 }
            java.util.Set r7 = r2.mo164449a(r7)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x012f
            r6.remove()     // Catch:{ all -> 0x0263 }
            goto L_0x0119
        L_0x012f:
            r3.mo164286a(r5, r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0119
        L_0x0133:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r2.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x013c:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x01b8
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C20165q) r7     // Catch:{ all -> 0x0263 }
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x01a9 }
            java.io.File r9 = r7.mo164454a()     // Catch:{ IOException -> 0x01a9 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r9 = "classes.dex"
            java.util.zip.ZipEntry r9 = r8.getEntry(r9)     // Catch:{ IOException -> 0x01a7 }
            r8.close()     // Catch:{ IOException -> 0x01a7 }
            if (r9 == 0) goto L_0x019f
            com.google.android.play.core.splitcompat.c r8 = r1.f56160b     // Catch:{ all -> 0x0263 }
            java.lang.String r9 = r7.mo164455b()     // Catch:{ all -> 0x0263 }
            java.io.File r8 = r8.mo164440c((java.lang.String) r9)     // Catch:{ all -> 0x0263 }
            java.io.File r9 = r7.mo164454a()     // Catch:{ all -> 0x0263 }
            boolean r8 = r3.mo164287a(r5, r8, r9, r0)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x0171
            goto L_0x019f
        L_0x0171:
            java.io.File r7 = r7.mo164454a()     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0263 }
            int r8 = r8.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r8 = r8 + 24
            r9.<init>(r8)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = "split was not installed "
            r9.append(r8)     // Catch:{ all -> 0x0263 }
            r9.append(r7)     // Catch:{ all -> 0x0263 }
            java.lang.String r11 = "SplitCompat"
            java.lang.String r12 = r9.toString()     // Catch:{ all -> 0x0263 }
            r10 = 5
            r13 = 0
            java.lang.String r14 = "com.google.android.play.core.splitcompat.SplitCompat"
            r15 = -1
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0263 }
            goto L_0x013c
        L_0x019f:
            java.io.File r7 = r7.mo164454a()     // Catch:{ all -> 0x0263 }
            r2.add(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x013c
        L_0x01a7:
            r0 = move-exception
            goto L_0x01ab
        L_0x01a9:
            r0 = move-exception
            r8 = 0
        L_0x01ab:
            r2 = r0
            if (r8 == 0) goto L_0x01b7
            r8.close()     // Catch:{ IOException -> 0x01b2 }
            goto L_0x01b7
        L_0x01b2:
            r0 = move-exception
            r3 = r0
            com.google.android.play.core.internal.C20087cj.m42281a(r2, r3)     // Catch:{ all -> 0x0263 }
        L_0x01b7:
            throw r2     // Catch:{ all -> 0x0263 }
        L_0x01b8:
            com.google.android.play.core.splitcompat.a r0 = r1.f56162d     // Catch:{ all -> 0x0263 }
            r3 = r17
            r0.mo164430b(r3, r2)     // Catch:{ all -> 0x0263 }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r0.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r3 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x01c8:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0263 }
            if (r4 == 0) goto L_0x0243
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r4 = (com.google.android.play.core.splitcompat.C20165q) r4     // Catch:{ all -> 0x0263 }
            java.io.File r5 = r4.mo164454a()     // Catch:{ all -> 0x0263 }
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x0263 }
            if (r5 == 0) goto L_0x0214
            java.lang.String r5 = r4.mo164455b()     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0263 }
            int r6 = r6.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r6 = r6 + 30
            r7.<init>(r6)     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = "Split '"
            r7.append(r6)     // Catch:{ all -> 0x0263 }
            r7.append(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = "' installation emulated"
            r7.append(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r9 = "SplitCompat"
            java.lang.String r10 = r7.toString()     // Catch:{ all -> 0x0263 }
            r8 = 3
            r11 = 0
            java.lang.String r12 = "com.google.android.play.core.splitcompat.SplitCompat"
            r13 = -1
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0263 }
            java.lang.String r4 = r4.mo164455b()     // Catch:{ all -> 0x0263 }
            r0.add(r4)     // Catch:{ all -> 0x0263 }
            goto L_0x01c8
        L_0x0214:
            java.lang.String r4 = r4.mo164455b()     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0263 }
            int r5 = r5.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r5 = r5 + 35
            r6.<init>(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = "Split '"
            r6.append(r5)     // Catch:{ all -> 0x0263 }
            r6.append(r4)     // Catch:{ all -> 0x0263 }
            java.lang.String r4 = "' installation not emulated."
            r6.append(r4)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = "SplitCompat"
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0263 }
            r7 = 3
            r10 = 0
            java.lang.String r11 = "com.google.android.play.core.splitcompat.SplitCompat"
            r12 = -1
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0263 }
            goto L_0x01c8
        L_0x0243:
            java.util.Set<java.lang.String> r2 = r1.f56161c     // Catch:{ all -> 0x0263 }
            monitor-enter(r2)     // Catch:{ all -> 0x0263 }
            java.util.Set<java.lang.String> r3 = r1.f56161c     // Catch:{ all -> 0x024e }
            r3.addAll(r0)     // Catch:{ all -> 0x024e }
            monitor-exit(r2)     // Catch:{ all -> 0x024e }
            monitor-exit(r16)
            return
        L_0x024e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x024e }
            throw r0     // Catch:{ all -> 0x0263 }
        L_0x0251:
            r0 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0263 }
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0263 }
            r5[r3] = r2     // Catch:{ all -> 0x0263 }
            java.lang.String r2 = "Cannot load data for application '%s'"
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x0263 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0263 }
            throw r4     // Catch:{ all -> 0x0263 }
        L_0x0263:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.m42409b(android.content.Context, boolean):void");
    }

    /* renamed from: b */
    private static boolean m42410b() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final Set<String> m42411c() {
        HashSet hashSet;
        synchronized (this.f56161c) {
            hashSet = new HashSet(this.f56161c);
        }
        return hashSet;
    }

    public static boolean install(Context context) {
        return m42407a(context, false);
    }

    public static boolean installActivity(Context context) {
        if (m42410b()) {
            return false;
        }
        SplitCompat splitCompat = f56159a.get();
        if (splitCompat != null) {
            return splitCompat.f56162d.mo164429a(context, splitCompat.m42411c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
