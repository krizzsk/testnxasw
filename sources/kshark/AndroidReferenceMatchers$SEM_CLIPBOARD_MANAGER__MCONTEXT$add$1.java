package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "", "Lkshark/AndroidBuildMirror;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: AndroidReferenceMatchers.kt */
final class AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1 extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
    public static final AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1 INSTANCE = new AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1();

    AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r3 = r3.getSdkInt();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean invoke(kshark.AndroidBuildMirror r3) {
        /*
            r2 = this;
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = r3.getManufacturer()
            java.lang.String r1 = "samsung"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0021
            r0 = 28
            r1 = 19
            int r3 = r3.getSdkInt()
            if (r1 <= r3) goto L_0x001d
            goto L_0x0021
        L_0x001d:
            if (r0 < r3) goto L_0x0021
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1.invoke(kshark.AndroidBuildMirror):boolean");
    }
}
