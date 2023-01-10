package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo148868d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ProgressionIterators.kt */
public final class LongProgressionIterator extends LongIterator {

    /* renamed from: a */
    private final long f4690a;

    /* renamed from: b */
    private boolean f4691b;

    /* renamed from: c */
    private long f4692c;

    /* renamed from: d */
    private final long f4693d;

    public LongProgressionIterator(long j, long j2, long j3) {
        this.f4693d = j3;
        this.f4690a = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i <= 0 ? i2 < 0 : i2 > 0) {
            z = false;
        }
        this.f4691b = z;
        this.f4692c = !z ? this.f4690a : j;
    }

    public final long getStep() {
        return this.f4693d;
    }

    public boolean hasNext() {
        return this.f4691b;
    }

    public long nextLong() {
        long j = this.f4692c;
        if (j != this.f4690a) {
            this.f4692c = this.f4693d + j;
        } else if (this.f4691b) {
            this.f4691b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
