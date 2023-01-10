package com.iproov.sdk.core;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.iproov.sdk.core.public */
/* compiled from: RootedDetector.kt */
public final class C20885public {
    /* renamed from: do */
    public static /* synthetic */ String[] m43437do(String str, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = null;
        }
        return m43436do(str, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.p066io.CloseableKt.closeFinally(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        throw r2;
     */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String[] m43436do(java.lang.String r8, java.lang.String[] r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException | NoSuchElementException -> 0x0063 }
            java.lang.Process r8 = r1.exec(r8, r9)     // Catch:{ IOException | NoSuchElementException -> 0x0063 }
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ all -> 0x005e }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x005e }
            r1.<init>(r9)     // Catch:{ all -> 0x005e }
            java.lang.String r9 = "\\A"
            java.util.Scanner r9 = r1.useDelimiter(r9)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r9.next()     // Catch:{ all -> 0x0057 }
            java.lang.String r9 = "scanner.useDelimiter(\"\\\\A\").next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0057 }
            java.lang.String r9 = "\n"
            java.lang.String[] r3 = new java.lang.String[]{r9}     // Catch:{ all -> 0x0057 }
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r9 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r2, (java.lang.String[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0057 }
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x0057 }
            java.lang.Object[] r9 = r9.toArray(r3)     // Catch:{ all -> 0x0057 }
            if (r9 == 0) goto L_0x004f
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x0057 }
            kotlin.p066io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x005e }
            int r1 = r9.length     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x0047
            r2 = 1
        L_0x0047:
            if (r2 == 0) goto L_0x004a
            r9 = r0
        L_0x004a:
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0063 }
            r0 = r9
            goto L_0x0063
        L_0x004f:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r9.<init>(r2)     // Catch:{ all -> 0x0057 }
            throw r9     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r2 = move-exception
            kotlin.p066io.CloseableKt.closeFinally(r1, r9)     // Catch:{ all -> 0x005e }
            throw r2     // Catch:{ all -> 0x005e }
        L_0x005e:
            r9 = move-exception
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0063 }
            throw r9     // Catch:{ IOException | NoSuchElementException -> 0x0063 }
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C20885public.m43436do(java.lang.String, java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: do */
    public static final boolean m43434do(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, SDKConsts.TAG_KEY_FILENAME);
        return new File(str, str2).exists();
    }

    /* renamed from: do */
    public static final boolean m43435do(List<Boolean> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((Boolean) t).booleanValue()) {
                break;
            }
        }
        Boolean bool = (Boolean) t;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
