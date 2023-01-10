package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BinaryVersion.kt */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final int[] f5397a;

    /* renamed from: b */
    private final int f5398b;

    /* renamed from: c */
    private final int f5399c;

    /* renamed from: d */
    private final int f5400d;

    /* renamed from: e */
    private final List<Integer> f5401e;

    public BinaryVersion(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "numbers");
        this.f5397a = iArr;
        Integer orNull = ArraysKt.getOrNull(iArr, 0);
        int i = -1;
        this.f5398b = orNull == null ? -1 : orNull.intValue();
        Integer orNull2 = ArraysKt.getOrNull(this.f5397a, 1);
        this.f5399c = orNull2 == null ? -1 : orNull2.intValue();
        Integer orNull3 = ArraysKt.getOrNull(this.f5397a, 2);
        this.f5400d = orNull3 != null ? orNull3.intValue() : i;
        int[] iArr2 = this.f5397a;
        this.f5401e = iArr2.length > 3 ? CollectionsKt.toList(ArraysKt.asList(iArr2).subList(3, this.f5397a.length)) : CollectionsKt.emptyList();
    }

    public final int getMajor() {
        return this.f5398b;
    }

    public final int getMinor() {
        return this.f5399c;
    }

    public final int[] toArray() {
        return this.f5397a;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isCompatibleTo(kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r5) {
        /*
            r4 = this;
            java.lang.String r0 = "ourVersion"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r4.f5398b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0016
            int r0 = r5.f5398b
            if (r0 != 0) goto L_0x0021
            int r0 = r4.f5399c
            int r5 = r5.f5399c
            if (r0 != r5) goto L_0x0021
            goto L_0x0022
        L_0x0016:
            int r3 = r5.f5398b
            if (r0 != r3) goto L_0x0021
            int r0 = r4.f5399c
            int r5 = r5.f5399c
            if (r0 > r5) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion.isCompatibleTo(kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion):boolean");
    }

    public final boolean isAtLeast(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "version");
        return isAtLeast(binaryVersion.f5398b, binaryVersion.f5399c, binaryVersion.f5400d);
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.f5398b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.f5399c;
        if (i5 > i2) {
            return true;
        }
        if (i5 >= i2 && this.f5400d >= i3) {
            return true;
        }
        return false;
    }

    public final boolean isAtMost(int i, int i2, int i3) {
        int i4 = this.f5398b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.f5399c;
        if (i5 < i2) {
            return true;
        }
        if (i5 <= i2 && this.f5400d <= i3) {
            return true;
        }
        return false;
    }

    public String toString() {
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int i2 = array[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        List list = arrayList;
        return list.isEmpty() ? "unknown" : CollectionsKt.joinToString$default(list, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            return this.f5398b == binaryVersion.f5398b && this.f5399c == binaryVersion.f5399c && this.f5400d == binaryVersion.f5400d && Intrinsics.areEqual((Object) this.f5401e, (Object) binaryVersion.f5401e);
        }
    }

    public int hashCode() {
        int i = this.f5398b;
        int i2 = i + (i * 31) + this.f5399c;
        int i3 = i2 + (i2 * 31) + this.f5400d;
        return i3 + (i3 * 31) + this.f5401e.hashCode();
    }

    /* compiled from: BinaryVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
