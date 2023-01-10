package kotlin.reflect.jvm.internal.impl.utils;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a */
    private int f5910a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object f5911b;

    /* renamed from: a */
    private static /* synthetic */ void m5288a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = Constants.FILE_ANR_KEY;
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public E get(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.f5910a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f5910a);
        } else if (i2 == 1) {
            return this.f5911b;
        } else {
            return ((Object[]) this.f5911b)[i];
        }
    }

    public boolean add(E e) {
        int i = this.f5910a;
        if (i == 0) {
            this.f5911b = e;
        } else if (i == 1) {
            this.f5911b = new Object[]{this.f5911b, e};
        } else {
            Object[] objArr = (Object[]) this.f5911b;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.f5911b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f5910a] = e;
        }
        this.f5910a++;
        this.modCount++;
        return true;
    }

    public void add(int i, E e) {
        int i2;
        if (i < 0 || i > (i2 = this.f5910a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f5910a);
        }
        if (i2 == 0) {
            this.f5911b = e;
        } else if (i2 == 1 && i == 0) {
            this.f5911b = new Object[]{e, this.f5911b};
        } else {
            int i3 = this.f5910a;
            Object[] objArr = new Object[(i3 + 1)];
            if (i3 == 1) {
                objArr[0] = this.f5911b;
            } else {
                Object[] objArr2 = (Object[]) this.f5911b;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.f5910a - i);
            }
            objArr[i] = e;
            this.f5911b = objArr;
        }
        this.f5910a++;
        this.modCount++;
    }

    public int size() {
        return this.f5910a;
    }

    public void clear() {
        this.f5911b = null;
        this.f5910a = 0;
        this.modCount++;
    }

    public E set(int i, E e) {
        int i2;
        if (i < 0 || i >= (i2 = this.f5910a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f5910a);
        } else if (i2 == 1) {
            E e2 = this.f5911b;
            this.f5911b = e;
            return e2;
        } else {
            E[] eArr = (Object[]) this.f5911b;
            E e3 = eArr[i];
            eArr[i] = e;
            return e3;
        }
    }

    public E remove(int i) {
        int i2;
        E e;
        if (i < 0 || i >= (i2 = this.f5910a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f5910a);
        }
        if (i2 == 1) {
            e = this.f5911b;
            this.f5911b = null;
        } else {
            E[] eArr = (Object[]) this.f5911b;
            E e2 = eArr[i];
            if (i2 == 2) {
                this.f5911b = eArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(eArr, i + 1, eArr, i, i3);
                }
                eArr[this.f5910a - 1] = null;
            }
            e = e2;
        }
        this.f5910a--;
        this.modCount++;
        return e;
    }

    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    public Iterator<E> iterator() {
        int i = this.f5910a;
        if (i == 0) {
            EmptyIterator instance = EmptyIterator.getInstance();
            if (instance == null) {
                m5288a(2);
            }
            return instance;
        } else if (i == 1) {
            return new SingletonIterator();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                m5288a(3);
            }
            return it;
        }
    }

    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        /* access modifiers changed from: protected */
        public abstract void checkCoModification();

        /* access modifiers changed from: protected */
        public abstract T getElement();

        private SingletonIteratorBase() {
        }

        public final boolean hasNext() {
            return !this.myVisited;
        }

        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                checkCoModification();
                return getElement();
            }
            throw new NoSuchElementException();
        }
    }

    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = SmartList.this.modCount;
        }

        /* access modifiers changed from: protected */
        public E getElement() {
            return SmartList.this.f5911b;
        }

        /* access modifiers changed from: protected */
        public void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr == null) {
            m5288a(4);
        }
        int length = tArr.length;
        int i = this.f5910a;
        if (i == 1) {
            if (length != 0) {
                tArr[0] = this.f5911b;
            } else {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                tArr2[0] = this.f5911b;
                if (tArr2 == null) {
                    m5288a(5);
                }
                return tArr2;
            }
        } else if (length < i) {
            T[] copyOf = Arrays.copyOf((Object[]) this.f5911b, i, tArr.getClass());
            if (copyOf == null) {
                m5288a(6);
            }
            return copyOf;
        } else if (i != 0) {
            System.arraycopy(this.f5911b, 0, tArr, 0, i);
        }
        int i2 = this.f5910a;
        if (length > i2) {
            tArr[i2] = null;
        }
        if (tArr == null) {
            m5288a(7);
        }
        return tArr;
    }
}
