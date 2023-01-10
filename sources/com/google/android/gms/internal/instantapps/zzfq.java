package com.google.android.gms.internal.instantapps;

import java.util.ListIterator;

final class zzfq implements ListIterator<String> {
    private ListIterator<String> zzate = this.zzatg.zzath.listIterator(this.zzatf);
    private final /* synthetic */ int zzatf;
    private final /* synthetic */ zzfr zzatg;

    zzfq(zzfr zzfr, int i) {
        this.zzatg = zzfr;
        this.zzatf = i;
    }

    public final boolean hasNext() {
        return this.zzate.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzate.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzate.nextIndex();
    }

    public final int previousIndex() {
        return this.zzate.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzate.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzate.next();
    }
}
