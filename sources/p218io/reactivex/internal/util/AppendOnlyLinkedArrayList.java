package p218io.reactivex.internal.util;

import org.reactivestreams.Subscriber;
import p218io.reactivex.Observer;
import p218io.reactivex.functions.BiPredicate;
import p218io.reactivex.functions.Predicate;

/* renamed from: io.reactivex.internal.util.AppendOnlyLinkedArrayList */
public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a */
    final int f62050a;

    /* renamed from: b */
    final Object[] f62051b;

    /* renamed from: c */
    Object[] f62052c;

    /* renamed from: d */
    int f62053d;

    /* renamed from: io.reactivex.internal.util.AppendOnlyLinkedArrayList$NonThrowingPredicate */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.f62050a = i;
        Object[] objArr = new Object[(i + 1)];
        this.f62051b = objArr;
        this.f62052c = objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(T r4) {
        /*
            r3 = this;
            int r0 = r3.f62050a
            int r1 = r3.f62053d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f62052c
            r2[r0] = r1
            r3.f62052c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f62052c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f62053d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.internal.util.AppendOnlyLinkedArrayList.add(java.lang.Object):void");
    }

    public void setFirst(T t) {
        this.f62051b[0] = t;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.f62050a;
        for (Object[] objArr = this.f62051b; objArr != null; objArr = objArr[i]) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.f62051b;
        int i = this.f62050a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, subscriber)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.f62051b;
        int i = this.f62050a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, observer)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.f62051b;
        int i = this.f62050a;
        while (true) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 != null && !biPredicate.test(s, objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
            objArr = objArr[i];
        }
    }
}
