package com.google.android.gms.internal.instantapps;

import java.util.Iterator;

final class zzft implements Iterator<String> {
    private final /* synthetic */ zzfr zzatg;
    private Iterator<String> zzauc = this.zzatg.zzath.iterator();

    zzft(zzfr zzfr) {
        this.zzatg = zzfr;
    }

    public final boolean hasNext() {
        return this.zzauc.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzauc.next();
    }
}
