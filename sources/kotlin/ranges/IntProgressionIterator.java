package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo148868d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ProgressionIterators.kt */
public final class IntProgressionIterator extends IntIterator {

    /* renamed from: a */
    private final int f4682a;

    /* renamed from: b */
    private boolean f4683b;

    /* renamed from: c */
    private int f4684c;

    /* renamed from: d */
    private final int f4685d;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.f4685d = i3;
        this.f4682a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f4683b = z;
        this.f4684c = !z ? this.f4682a : i;
    }

    public final int getStep() {
        return this.f4685d;
    }

    public boolean hasNext() {
        return this.f4683b;
    }

    public int nextInt() {
        int i = this.f4684c;
        if (i != this.f4682a) {
            this.f4684c = this.f4685d + i;
        } else if (this.f4683b) {
            this.f4683b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
