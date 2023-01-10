package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.k */
public final class C20159k {

    /* renamed from: a */
    public static final /* synthetic */ int f56180a = 0;

    /* renamed from: b */
    private static final Pattern f56181b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* renamed from: c */
    private final C20151c f56182c;

    C20159k(C20151c cVar) throws IOException {
        this.f56182c = cVar;
    }

    /* renamed from: a */
    static /* synthetic */ Set m42443a(C20159k kVar, Set set, C20165q qVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        kVar.m42446a(qVar, set, new C20155g(hashSet, qVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0122 A[SYNTHETIC, Splitter:B:33:0x0122] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m42445a(com.google.android.play.core.splitcompat.C20165q r20, com.google.android.play.core.splitcompat.C20156h r21) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0119 }
            java.io.File r0 = r20.mo164454a()     // Catch:{ IOException -> 0x0119 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0119 }
            java.lang.String r0 = r20.mo164455b()     // Catch:{ IOException -> 0x0117 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ IOException -> 0x0117 }
            r2.<init>()     // Catch:{ IOException -> 0x0117 }
            java.util.Enumeration r3 = r1.entries()     // Catch:{ IOException -> 0x0117 }
        L_0x0016:
            boolean r4 = r3.hasMoreElements()     // Catch:{ IOException -> 0x0117 }
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0070
            java.lang.Object r4 = r3.nextElement()     // Catch:{ IOException -> 0x0117 }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ IOException -> 0x0117 }
            java.lang.String r8 = r4.getName()     // Catch:{ IOException -> 0x0117 }
            java.util.regex.Pattern r9 = f56181b     // Catch:{ IOException -> 0x0117 }
            java.util.regex.Matcher r8 = r9.matcher(r8)     // Catch:{ IOException -> 0x0117 }
            boolean r9 = r8.matches()     // Catch:{ IOException -> 0x0117 }
            if (r9 == 0) goto L_0x0016
            java.lang.String r9 = r8.group(r7)     // Catch:{ IOException -> 0x0117 }
            java.lang.String r8 = r8.group(r5)     // Catch:{ IOException -> 0x0117 }
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x0117 }
            r10[r6] = r0     // Catch:{ IOException -> 0x0117 }
            r10[r7] = r8     // Catch:{ IOException -> 0x0117 }
            r10[r5] = r9     // Catch:{ IOException -> 0x0117 }
            java.lang.String r12 = "SplitCompat"
            java.lang.String r5 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.String r13 = java.lang.String.format(r5, r10)     // Catch:{ IOException -> 0x0117 }
            r11 = 3
            r14 = 0
            java.lang.String r15 = "com.google.android.play.core.splitcompat.k"
            r16 = -1
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)     // Catch:{ IOException -> 0x0117 }
            java.lang.Object r5 = r2.get(r9)     // Catch:{ IOException -> 0x0117 }
            java.util.Set r5 = (java.util.Set) r5     // Catch:{ IOException -> 0x0117 }
            if (r5 != 0) goto L_0x0067
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ IOException -> 0x0117 }
            r5.<init>()     // Catch:{ IOException -> 0x0117 }
            r2.put(r9, r5)     // Catch:{ IOException -> 0x0117 }
        L_0x0067:
            com.google.android.play.core.splitcompat.j r6 = new com.google.android.play.core.splitcompat.j     // Catch:{ IOException -> 0x0117 }
            r6.<init>(r4, r8)     // Catch:{ IOException -> 0x0117 }
            r5.add(r6)     // Catch:{ IOException -> 0x0117 }
            goto L_0x0016
        L_0x0070:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ IOException -> 0x0117 }
            r0.<init>()     // Catch:{ IOException -> 0x0117 }
            java.lang.String[] r3 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x0117 }
            int r4 = r3.length     // Catch:{ IOException -> 0x0117 }
            r8 = 0
        L_0x0079:
            if (r8 >= r4) goto L_0x0105
            r9 = r3[r8]     // Catch:{ IOException -> 0x0117 }
            boolean r10 = r2.containsKey(r9)     // Catch:{ IOException -> 0x0117 }
            if (r10 == 0) goto L_0x00ec
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0117 }
            r10[r6] = r9     // Catch:{ IOException -> 0x0117 }
            java.lang.String r12 = "SplitCompat"
            java.lang.String r11 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.String r13 = java.lang.String.format(r11, r10)     // Catch:{ IOException -> 0x0117 }
            r11 = 3
            r14 = 0
            java.lang.String r15 = "com.google.android.play.core.splitcompat.k"
            r16 = -1
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)     // Catch:{ IOException -> 0x0117 }
            java.lang.Object r10 = r2.get(r9)     // Catch:{ IOException -> 0x0117 }
            java.util.Set r10 = (java.util.Set) r10     // Catch:{ IOException -> 0x0117 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x0117 }
        L_0x00a2:
            boolean r11 = r10.hasNext()     // Catch:{ IOException -> 0x0117 }
            if (r11 == 0) goto L_0x0101
            java.lang.Object r11 = r10.next()     // Catch:{ IOException -> 0x0117 }
            com.google.android.play.core.splitcompat.j r11 = (com.google.android.play.core.splitcompat.C20158j) r11     // Catch:{ IOException -> 0x0117 }
            java.lang.String r12 = r11.f56178a     // Catch:{ IOException -> 0x0117 }
            boolean r12 = r0.containsKey(r12)     // Catch:{ IOException -> 0x0117 }
            if (r12 == 0) goto L_0x00d1
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0117 }
            java.lang.String r11 = r11.f56178a     // Catch:{ IOException -> 0x0117 }
            r12[r6] = r11     // Catch:{ IOException -> 0x0117 }
            r12[r7] = r9     // Catch:{ IOException -> 0x0117 }
            java.lang.String r14 = "SplitCompat"
            java.lang.String r11 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String r15 = java.lang.String.format(r11, r12)     // Catch:{ IOException -> 0x0117 }
            r13 = 3
            r16 = 0
            java.lang.String r17 = "com.google.android.play.core.splitcompat.k"
        L_0x00cb:
            r18 = -1
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)     // Catch:{ IOException -> 0x0117 }
            goto L_0x00a2
        L_0x00d1:
            java.lang.String r12 = r11.f56178a     // Catch:{ IOException -> 0x0117 }
            r0.put(r12, r11)     // Catch:{ IOException -> 0x0117 }
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0117 }
            java.lang.String r11 = r11.f56178a     // Catch:{ IOException -> 0x0117 }
            r12[r6] = r11     // Catch:{ IOException -> 0x0117 }
            r12[r7] = r9     // Catch:{ IOException -> 0x0117 }
            java.lang.String r14 = "SplitCompat"
            java.lang.String r11 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String r15 = java.lang.String.format(r11, r12)     // Catch:{ IOException -> 0x0117 }
            r13 = 3
            r16 = 0
            java.lang.String r17 = "com.google.android.play.core.splitcompat.k"
            goto L_0x00cb
        L_0x00ec:
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0117 }
            r10[r6] = r9     // Catch:{ IOException -> 0x0117 }
            java.lang.String r12 = "SplitCompat"
            java.lang.String r9 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.String r13 = java.lang.String.format(r9, r10)     // Catch:{ IOException -> 0x0117 }
            r11 = 3
            r14 = 0
            java.lang.String r15 = "com.google.android.play.core.splitcompat.k"
            r16 = -1
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)     // Catch:{ IOException -> 0x0117 }
        L_0x0101:
            int r8 = r8 + 1
            goto L_0x0079
        L_0x0105:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ IOException -> 0x0117 }
            java.util.Collection r0 = r0.values()     // Catch:{ IOException -> 0x0117 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0117 }
            r0 = r21
            r0.mo164447a(r1, r2)     // Catch:{ IOException -> 0x0117 }
            r1.close()     // Catch:{ IOException -> 0x0117 }
            return
        L_0x0117:
            r0 = move-exception
            goto L_0x011b
        L_0x0119:
            r0 = move-exception
            r1 = 0
        L_0x011b:
            r19 = r1
            r1 = r0
            r0 = r19
            if (r0 == 0) goto L_0x012b
            r0.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012b
        L_0x0126:
            r0 = move-exception
            r2 = r0
            com.google.android.play.core.internal.C20087cj.m42281a(r1, r2)
        L_0x012b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.C20159k.m42445a(com.google.android.play.core.splitcompat.q, com.google.android.play.core.splitcompat.h):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m42446a(C20165q qVar, Set<C20158j> set, C20157i iVar) throws IOException {
        for (C20158j next : set) {
            File a = this.f56182c.mo164434a(qVar.mo164455b(), next.f56178a);
            boolean z = false;
            if (a.exists() && a.length() == next.f56179b.getSize()) {
                z = true;
            }
            iVar.mo164446a(next, a, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Set<File> mo164448a() throws IOException {
        SystemUtils.log(3, "SplitCompat", "NativeLibraryExtractor: synchronizing native libraries", (Throwable) null, "com.google.android.play.core.splitcompat.k", -1);
        Set<C20165q> d = this.f56182c.mo164441d();
        for (String next : this.f56182c.mo164443e()) {
            Iterator<C20165q> it = d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().mo164455b().equals(next)) {
                        break;
                    }
                } else {
                    SystemUtils.log(4, "SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{next}), (Throwable) null, "com.google.android.play.core.splitcompat.k", -1);
                    this.f56182c.mo164442d(next);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (C20165q next2 : d) {
            HashSet hashSet2 = new HashSet();
            m42445a(next2, new C20154f(this, hashSet2, next2));
            for (File next3 : this.f56182c.mo164444e(next2.mo164455b())) {
                if (!hashSet2.contains(next3)) {
                    SystemUtils.log(4, "SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{next3.getAbsolutePath(), next2.mo164455b(), next2.mo164454a().getAbsolutePath()}), (Throwable) null, "com.google.android.play.core.splitcompat.k", -1);
                    this.f56182c.mo164438b(next3);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Set<File> mo164449a(C20165q qVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        m42445a(qVar, new C20153e(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
