package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J%\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0005J\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00028\u00000&0%J\u0018\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dH\u0002J%\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0015\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0002\u0010(J \u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d2\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014X\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0003¨\u00065"}, mo148868d2 = {"Lkshark/internal/hppc/LongObjectScatterMap;", "T", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "", "values$annotations", "[Ljava/lang/Object;", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "(IJLjava/lang/Object;)V", "containsKey", "key", "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "get", "(J)Ljava/lang/Object;", "hashKey", "rehash", "fromKeys", "fromValues", "([J[Ljava/lang/Object;)V", "release", "remove", "set", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "shiftConflictingKeys", "gapSlotArg", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: LongObjectScatterMap.kt */
public final class LongObjectScatterMap<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long[] f6558a = new long[0];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public T[] f6559b = new Object[0];

    /* renamed from: c */
    private int f6560c;

    /* renamed from: d */
    private int f6561d;

    /* renamed from: e */
    private int f6562e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6563f;

    /* renamed from: g */
    private double f6564g = 0.75d;

    /* renamed from: a */
    private static /* synthetic */ void m6409a() {
    }

    public LongObjectScatterMap() {
        ensureCapacity(4);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T set(long j, T t) {
        int i = this.f6561d;
        if (j == 0) {
            this.f6563f = true;
            T[] tArr = this.f6559b;
            int i2 = i + 1;
            T t2 = tArr[i2];
            tArr[i2] = t;
            return t2;
        }
        long[] jArr = this.f6558a;
        int a = m6408a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                T[] tArr2 = this.f6559b;
                T t3 = tArr2[a];
                tArr2[a] = t;
                return t3;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        if (this.f6560c == this.f6562e) {
            m6411a(a, j, t);
        } else {
            jArr[a] = j;
            this.f6559b[a] = t;
        }
        this.f6560c++;
        return null;
    }

    public final T remove(long j) {
        int i = this.f6561d;
        if (j == 0) {
            this.f6563f = false;
            T[] tArr = this.f6559b;
            int i2 = i + 1;
            T t = tArr[i2];
            tArr[i2] = null;
            return t;
        }
        long[] jArr = this.f6558a;
        int a = m6408a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                T t2 = this.f6559b[a];
                m6413b(a);
                return t2;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        return null;
    }

    public final T get(long j) {
        if (j != 0) {
            long[] jArr = this.f6558a;
            int i = this.f6561d;
            int a = m6408a(j) & i;
            long j2 = jArr[a];
            while (j2 != 0) {
                if (j2 == j) {
                    return this.f6559b[a];
                }
                a = (a + 1) & i;
                j2 = jArr[a];
            }
            return null;
        } else if (this.f6563f) {
            return this.f6559b[this.f6561d + 1];
        } else {
            return null;
        }
    }

    public final Sequence<Pair<Long, T>> entrySequence() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return SequencesKt.generateSequence(new LongObjectScatterMap$entrySequence$1(this, intRef, this.f6561d + 1));
    }

    public final boolean containsKey(long j) {
        if (j == 0) {
            return this.f6563f;
        }
        long[] jArr = this.f6558a;
        int i = this.f6561d;
        int a = m6408a(j) & i;
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
        this.f6560c = 0;
        this.f6563f = false;
        m6410a(HHPC.INSTANCE.minBufferSize(4, this.f6564g));
    }

    public final int getSize() {
        return this.f6560c + (this.f6563f ? 1 : 0);
    }

    public final void ensureCapacity(int i) {
        if (i > this.f6562e) {
            long[] jArr = this.f6558a;
            T[] tArr = this.f6559b;
            m6410a(HHPC.INSTANCE.minBufferSize(i, this.f6564g));
            if (!isEmpty()) {
                m6412a(jArr, tArr);
            }
        }
    }

    /* renamed from: a */
    private final int m6408a(long j) {
        return HHPC.INSTANCE.mixPhi(j);
    }

    /* renamed from: a */
    private final void m6412a(long[] jArr, T[] tArr) {
        int i;
        long[] jArr2 = this.f6558a;
        T[] tArr2 = this.f6559b;
        int i2 = this.f6561d;
        int length = jArr.length - 1;
        jArr2[jArr2.length - 1] = jArr[length];
        tArr2[tArr2.length - 1] = tArr[length];
        while (true) {
            length--;
            if (length >= 0) {
                long j = jArr[length];
                if (j != 0) {
                    int a = m6408a(j);
                    while (true) {
                        i = a & i2;
                        if (jArr2[i] == 0) {
                            break;
                        }
                        a = i + 1;
                    }
                    jArr2[i] = j;
                    tArr2[i] = tArr[length];
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m6410a(int i) {
        long[] jArr = this.f6558a;
        T[] tArr = this.f6559b;
        int i2 = i + 1;
        try {
            this.f6558a = new long[i2];
            this.f6559b = new Object[i2];
            this.f6562e = HHPC.INSTANCE.expandAtCount(i, this.f6564g);
            this.f6561d = i - 1;
        } catch (OutOfMemoryError e) {
            this.f6558a = jArr;
            this.f6559b = tArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f6561d + 1), Integer.valueOf(i)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    /* renamed from: a */
    private final void m6411a(int i, long j, T t) {
        long[] jArr = this.f6558a;
        T[] tArr = this.f6559b;
        m6410a(HHPC.INSTANCE.nextBufferSize(this.f6561d + 1, getSize(), this.f6564g));
        jArr[i] = j;
        tArr[i] = t;
        m6412a(jArr, tArr);
    }

    /* renamed from: b */
    private final void m6413b(int i) {
        int i2;
        long j;
        long[] jArr = this.f6558a;
        T[] tArr = this.f6559b;
        int i3 = this.f6561d;
        while (true) {
            int i4 = 0;
            do {
                i4++;
                i2 = (i + i4) & i3;
                j = jArr[i2];
                if (j == 0) {
                    jArr[i] = 0;
                    tArr[i] = null;
                    this.f6560c--;
                    return;
                }
            } while (((i2 - m6408a(j)) & i3) < i4);
            jArr[i] = j;
            tArr[i] = tArr[i2];
            i = i2;
        }
    }
}
