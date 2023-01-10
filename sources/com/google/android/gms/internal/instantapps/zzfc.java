package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzfc implements Iterator<Object> {
    zzfc() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
