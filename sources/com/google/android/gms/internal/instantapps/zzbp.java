package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzbp implements Serializable, Iterable<Byte> {
    public static final zzbp zzakv = new zzbz(zzcy.zzapu);
    private static final zzbv zzakw = (zzbi.zzp() ? new zzby((zzbo) null) : new zzbt((zzbo) null));
    private static final Comparator<zzbp> zzaky = new zzbr();
    private int zzakx = 0;

    zzbp() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzbp zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzbm zzbm) throws IOException;

    public abstract byte zzj(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzk(int i);

    public abstract boolean zzv();

    public static zzbp zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzbz(zzakw.zzc(bArr, i, i2));
    }

    static zzbp zza(byte[] bArr) {
        return new zzbz(bArr);
    }

    public static zzbp zze(String str) {
        return new zzbz(str.getBytes(zzcy.UTF_8));
    }

    public final String zzu() {
        return size() == 0 ? "" : zza(zzcy.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzakx;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzakx = i;
        }
        return i;
    }

    static zzbx zzl(int i) {
        return new zzbx(i, (zzbo) null);
    }

    /* access modifiers changed from: protected */
    public final int zzw() {
        return this.zzakx;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzbo(this);
    }
}
