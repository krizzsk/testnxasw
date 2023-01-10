package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;

final class zzes implements zzed {
    private final int flags;
    private final String info;
    private final Object[] zzaro;
    private final zzef zzarr;

    zzes(zzef zzef, String str, Object[] objArr) {
        this.zzarr = zzef;
        this.info = str;
        this.zzaro = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzdj() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzdk() {
        return this.zzaro;
    }

    public final zzef zzdd() {
        return this.zzarr;
    }

    public final int zzdb() {
        return (this.flags & 1) == 1 ? zzcx.zzd.zzapo : zzcx.zzd.zzapp;
    }

    public final boolean zzdc() {
        return (this.flags & 2) == 2;
    }
}
