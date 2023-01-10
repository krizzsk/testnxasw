package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lkotlin/jvm/internal/ArrayCharIterator;", "Lkotlin/collections/CharIterator;", "array", "", "([C)V", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.c */
/* compiled from: ArrayIterators.kt */
final class C2407c extends CharIterator {

    /* renamed from: a */
    private int f4641a;

    /* renamed from: b */
    private final char[] f4642b;

    public C2407c(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.f4642b = cArr;
    }

    public boolean hasNext() {
        return this.f4641a < this.f4642b.length;
    }

    public char nextChar() {
        try {
            char[] cArr = this.f4642b;
            int i = this.f4641a;
            this.f4641a = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f4641a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
