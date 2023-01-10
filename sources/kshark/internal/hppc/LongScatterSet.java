package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0011\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lkshark/internal/hppc/LongScatterSet;", "", "()V", "assigned", "", "hasEmptyKey", "", "keys", "", "loadFactor", "", "mask", "resizeAt", "add", "key", "", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "contains", "ensureCapacity", "expectedElements", "hashKey", "plusAssign", "rehash", "fromKeys", "release", "size", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: LongScatterSet.kt */
public final class LongScatterSet {

    /* renamed from: a */
    private long[] f6565a = new long[0];

    /* renamed from: b */
    private int f6566b;

    /* renamed from: c */
    private int f6567c;

    /* renamed from: d */
    private int f6568d;

    /* renamed from: e */
    private boolean f6569e;

    /* renamed from: f */
    private final double f6570f = 0.75d;

    public LongScatterSet() {
        ensureCapacity(4);
    }

    /* renamed from: a */
    private final int m6414a(long j) {
        return HHPC.INSTANCE.mixPhi(j);
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public final boolean add(long j) {
        if (j == 0) {
            boolean z = !this.f6569e;
            this.f6569e = true;
            return z;
        }
        long[] jArr = this.f6565a;
        int i = this.f6567c;
        int a = m6414a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                return false;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        if (this.f6566b == this.f6568d) {
            m6416a(a, j);
        } else {
            jArr[a] = j;
        }
        this.f6566b++;
        return true;
    }

    public final boolean contains(long j) {
        if (j == 0) {
            return this.f6569e;
        }
        long[] jArr = this.f6565a;
        int i = this.f6567c;
        int a = m6414a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                return true;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        return false;
    }

    public final void release() {
        this.f6566b = 0;
        this.f6569e = false;
        m6415a(HHPC.INSTANCE.minBufferSize(4, this.f6570f));
    }

    public final void ensureCapacity(int i) {
        if (i > this.f6568d) {
            long[] jArr = this.f6565a;
            m6415a(HHPC.INSTANCE.minBufferSize(i, this.f6570f));
            if (size() != 0) {
                m6417a(jArr);
            }
        }
    }

    public final int size() {
        return this.f6566b + (this.f6569e ? 1 : 0);
    }

    /* renamed from: a */
    private final void m6417a(long[] jArr) {
        int i;
        long[] jArr2 = this.f6565a;
        int i2 = this.f6567c;
        int length = jArr.length - 1;
        while (true) {
            length--;
            if (length >= 0) {
                long j = jArr[length];
                if (j != 0) {
                    int a = m6414a(j);
                    while (true) {
                        i = a & i2;
                        if (jArr2[i] == 0) {
                            break;
                        }
                        a = i + 1;
                    }
                    jArr2[i] = j;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m6415a(int i) {
        long[] jArr = this.f6565a;
        try {
            this.f6565a = new long[(i + 1)];
            this.f6568d = HHPC.INSTANCE.expandAtCount(i, this.f6570f);
            this.f6567c = i - 1;
        } catch (OutOfMemoryError e) {
            this.f6565a = jArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(size()), Integer.valueOf(i)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    /* renamed from: a */
    private final void m6416a(int i, long j) {
        long[] jArr = this.f6565a;
        m6415a(HHPC.INSTANCE.nextBufferSize(this.f6567c + 1, size(), this.f6570f));
        jArr[i] = j;
        m6417a(jArr);
    }
}
