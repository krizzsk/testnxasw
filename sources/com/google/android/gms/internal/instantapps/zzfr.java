package com.google.android.gms.internal.instantapps;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzfr extends AbstractList<String> implements zzdm, RandomAccess {
    /* access modifiers changed from: private */
    public final zzdm zzath;

    public zzfr(zzdm zzdm) {
        this.zzath = zzdm;
    }

    public final zzdm zzcr() {
        return this;
    }

    public final Object zzam(int i) {
        return this.zzath.zzam(i);
    }

    public final int size() {
        return this.zzath.size();
    }

    public final void zzc(zzbp zzbp) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzfq(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzft(this);
    }

    public final List<?> zzcq() {
        return this.zzath.zzcq();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzath.get(i);
    }
}
