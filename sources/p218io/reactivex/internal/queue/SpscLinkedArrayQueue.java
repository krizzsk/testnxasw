package p218io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p218io.reactivex.internal.fuseable.SimplePlainQueue;
import p218io.reactivex.internal.util.Pow2;

/* renamed from: io.reactivex.internal.queue.SpscLinkedArrayQueue */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: a */
    static final int f61959a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f61960j = new Object();

    /* renamed from: b */
    final AtomicLong f61961b = new AtomicLong();

    /* renamed from: c */
    int f61962c;

    /* renamed from: d */
    long f61963d;

    /* renamed from: e */
    final int f61964e;

    /* renamed from: f */
    AtomicReferenceArray<Object> f61965f;

    /* renamed from: g */
    final int f61966g;

    /* renamed from: h */
    AtomicReferenceArray<Object> f61967h;

    /* renamed from: i */
    final AtomicLong f61968i = new AtomicLong();

    /* renamed from: b */
    private static int m45971b(int i) {
        return i;
    }

    public SpscLinkedArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.f61965f = atomicReferenceArray;
        this.f61964e = i2;
        m45965a(roundToPowerOfTwo);
        this.f61967h = atomicReferenceArray;
        this.f61966g = i2;
        this.f61963d = (long) (i2 - 1);
        m45966a(0);
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f61965f;
            long c = m45976c();
            int i = this.f61964e;
            int a = m45961a(c, i);
            if (c < this.f61963d) {
                return m45970a(atomicReferenceArray, t, c, a);
            }
            long j = ((long) this.f61962c) + c;
            if (m45973b(atomicReferenceArray, m45961a(j, i)) == null) {
                this.f61963d = j - 1;
                return m45970a(atomicReferenceArray, t, c, a);
            } else if (m45973b(atomicReferenceArray, m45961a(1 + c, i)) == null) {
                return m45970a(atomicReferenceArray, t, c, a);
            } else {
                m45968a(atomicReferenceArray, c, a, t, (long) i);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    /* renamed from: a */
    private boolean m45970a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m45967a(atomicReferenceArray, i, (Object) t);
        m45966a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m45968a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f61965f = atomicReferenceArray2;
        this.f61963d = (j2 + j) - 1;
        m45967a(atomicReferenceArray2, i, (Object) t);
        m45969a(atomicReferenceArray, atomicReferenceArray2);
        m45967a(atomicReferenceArray, i, f61960j);
        m45966a(j + 1);
    }

    /* renamed from: a */
    private void m45969a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m45967a(atomicReferenceArray, m45971b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m45964a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b = m45971b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m45973b(atomicReferenceArray, b);
        m45967a(atomicReferenceArray, b, (Object) null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f61967h;
        long d = m45977d();
        int i = this.f61966g;
        int a = m45961a(d, i);
        T b = m45973b(atomicReferenceArray, a);
        boolean z = b == f61960j;
        if (b != null && !z) {
            m45967a(atomicReferenceArray, a, (Object) null);
            m45975b(d + 1);
            return b;
        } else if (z) {
            return m45963a(m45964a(atomicReferenceArray, i + 1), d, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m45963a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f61967h = atomicReferenceArray;
        int a = m45961a(j, i);
        T b = m45973b(atomicReferenceArray, a);
        if (b != null) {
            m45967a(atomicReferenceArray, a, (Object) null);
            m45975b(j + 1);
        }
        return b;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f61967h;
        long d = m45977d();
        int i = this.f61966g;
        T b = m45973b(atomicReferenceArray, m45961a(d, i));
        return b == f61960j ? m45974b(m45964a(atomicReferenceArray, i + 1), d, i) : b;
    }

    /* renamed from: b */
    private T m45974b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f61967h = atomicReferenceArray;
        return m45973b(atomicReferenceArray, m45961a(j, i));
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public int size() {
        long b = m45972b();
        while (true) {
            long a = m45962a();
            long b2 = m45972b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public boolean isEmpty() {
        return m45962a() == m45972b();
    }

    /* renamed from: a */
    private void m45965a(int i) {
        this.f61962c = Math.min(i / 4, f61959a);
    }

    /* renamed from: a */
    private long m45962a() {
        return this.f61961b.get();
    }

    /* renamed from: b */
    private long m45972b() {
        return this.f61968i.get();
    }

    /* renamed from: c */
    private long m45976c() {
        return this.f61961b.get();
    }

    /* renamed from: d */
    private long m45977d() {
        return this.f61968i.get();
    }

    /* renamed from: a */
    private void m45966a(long j) {
        this.f61961b.lazySet(j);
    }

    /* renamed from: b */
    private void m45975b(long j) {
        this.f61968i.lazySet(j);
    }

    /* renamed from: a */
    private static int m45961a(long j, int i) {
        return m45971b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m45967a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: b */
    private static <E> Object m45973b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f61965f;
        long a = m45962a();
        int i = this.f61964e;
        long j = 2 + a;
        if (m45973b(atomicReferenceArray, m45961a(j, i)) == null) {
            int a2 = m45961a(a, i);
            m45967a(atomicReferenceArray, a2 + 1, (Object) t2);
            m45967a(atomicReferenceArray, a2, (Object) t);
            m45966a(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f61965f = atomicReferenceArray2;
        int a3 = m45961a(a, i);
        m45967a(atomicReferenceArray2, a3 + 1, (Object) t2);
        m45967a(atomicReferenceArray2, a3, (Object) t);
        m45969a(atomicReferenceArray, atomicReferenceArray2);
        m45967a(atomicReferenceArray, a3, f61960j);
        m45966a(j);
        return true;
    }
}
