package com.google.android.gms.internal.auth;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzgs implements ListIterator<String> {
    final ListIterator<String> zza = this.zzc.zza.listIterator(this.zzb);
    final /* synthetic */ int zzb;
    final /* synthetic */ zzgu zzc;

    zzgs(zzgu zzgu, int i) {
        this.zzc = zzgu;
        this.zzb = i;
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
