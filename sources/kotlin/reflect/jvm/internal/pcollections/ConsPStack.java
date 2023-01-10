package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ConsPStack<E> implements Iterable<E> {

    /* renamed from: c */
    private static final ConsPStack<Object> f5915c = new ConsPStack<>();

    /* renamed from: a */
    final E f5916a;

    /* renamed from: b */
    final ConsPStack<E> f5917b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f5918d;

    /* renamed from: a */
    public static <E> ConsPStack<E> m5294a() {
        return f5915c;
    }

    private ConsPStack() {
        this.f5918d = 0;
        this.f5916a = null;
        this.f5917b = null;
    }

    private ConsPStack(E e, ConsPStack<E> consPStack) {
        this.f5916a = e;
        this.f5917b = consPStack;
        this.f5918d = consPStack.f5918d + 1;
    }

    /* renamed from: a */
    public E mo27229a(int i) {
        if (i < 0 || i > this.f5918d) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return m5296c(i).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    public Iterator<E> iterator() {
        return m5296c(0);
    }

    /* renamed from: b */
    public int mo27231b() {
        return this.f5918d;
    }

    /* renamed from: c */
    private Iterator<E> m5296c(int i) {
        return new Itr(m5297d(i));
    }

    private static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        public boolean hasNext() {
            return this.next.f5918d > 0;
        }

        public E next() {
            E e = this.next.f5916a;
            this.next = this.next.f5917b;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public ConsPStack<E> mo27230a(E e) {
        return new ConsPStack<>(e, this);
    }

    /* renamed from: b */
    private ConsPStack<E> m5295b(Object obj) {
        if (this.f5918d == 0) {
            return this;
        }
        if (this.f5916a.equals(obj)) {
            return this.f5917b;
        }
        ConsPStack<E> b = this.f5917b.m5295b(obj);
        if (b == this.f5917b) {
            return this;
        }
        return new ConsPStack<>(this.f5916a, b);
    }

    /* renamed from: b */
    public ConsPStack<E> mo27232b(int i) {
        return m5295b(mo27229a(i));
    }

    /* renamed from: d */
    private ConsPStack<E> m5297d(int i) {
        if (i < 0 || i > this.f5918d) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.f5917b.m5297d(i - 1);
        }
    }
}
