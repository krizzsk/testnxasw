package com.google.android.gms.internal.instantapps;

import java.util.NoSuchElementException;

final class zzbo extends zzbq {
    private final int limit = this.zzaku.size();
    private int position = 0;
    private final /* synthetic */ zzbp zzaku;

    zzbo(zzbp zzbp) {
        this.zzaku = zzbp;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzaku.zzk(i);
        }
        throw new NoSuchElementException();
    }
}
