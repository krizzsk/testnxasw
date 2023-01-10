package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ArrayQueue.kt */
public class ArrayQueue<T> {

    /* renamed from: a */
    private Object[] f6219a = new Object[16];

    /* renamed from: b */
    private int f6220b;

    /* renamed from: c */
    private int f6221c;

    public final boolean isEmpty() {
        return this.f6220b == this.f6221c;
    }

    public final void addLast(T t) {
        Object[] objArr = this.f6219a;
        int i = this.f6221c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f6221c = length;
        if (length == this.f6220b) {
            m6135a();
        }
    }

    public final T removeFirstOrNull() {
        int i = this.f6220b;
        if (i == this.f6221c) {
            return null;
        }
        T[] tArr = this.f6219a;
        T t = tArr[i];
        tArr[i] = null;
        this.f6220b = (i + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }

    public final void clear() {
        this.f6220b = 0;
        this.f6221c = 0;
        this.f6219a = new Object[this.f6219a.length];
    }

    /* renamed from: a */
    private final void m6135a() {
        Object[] objArr = this.f6219a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        ArraysKt.copyInto$default(objArr, objArr3, 0, this.f6220b, 0, 10, (Object) null);
        Object[] objArr4 = this.f6219a;
        int length2 = objArr4.length;
        int i = this.f6220b;
        ArraysKt.copyInto$default(objArr4, objArr2, length2 - i, 0, i, 4, (Object) null);
        this.f6219a = objArr3;
        this.f6220b = 0;
        this.f6221c = length;
    }
}
