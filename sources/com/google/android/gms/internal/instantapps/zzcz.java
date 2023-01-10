package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcz extends zzbj<Integer> implements zzdc<Integer>, zzer, RandomAccess {
    private static final zzcz zzapx;
    private int size;
    private int[] zzapy;

    zzcz() {
        this(new int[10], 0);
    }

    private zzcz(int[] iArr, int i) {
        this.zzapy = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzt();
        if (i2 >= i) {
            int[] iArr = this.zzapy;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcz)) {
            return super.equals(obj);
        }
        zzcz zzcz = (zzcz) obj;
        if (this.size != zzcz.size) {
            return false;
        }
        int[] iArr = zzcz.zzapy;
        for (int i = 0; i < this.size; i++) {
            if (this.zzapy[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzapy[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzg(i);
        return this.zzapy[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzal(int i) {
        zzo(this.size, i);
    }

    private final void zzo(int i, int i2) {
        int i3;
        zzt();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        int[] iArr = this.zzapy;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzapy, i, iArr2, i + 1, this.size - i);
            this.zzapy = iArr2;
        }
        this.zzapy[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzt();
        zzcy.checkNotNull(collection);
        if (!(collection instanceof zzcz)) {
            return super.addAll(collection);
        }
        zzcz zzcz = (zzcz) collection;
        int i = zzcz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzapy;
            if (i3 > iArr.length) {
                this.zzapy = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzcz.zzapy, 0, this.zzapy, this.size, zzcz.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzt();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzapy[i]))) {
                int[] iArr = this.zzapy;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    private final String zzh(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzt();
        zzg(i);
        int[] iArr = this.zzapy;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzt();
        zzg(i);
        int[] iArr = this.zzapy;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzo(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= this.size) {
            return new zzcz(Arrays.copyOf(this.zzapy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzcz zzcz = new zzcz(new int[0], 0);
        zzapx = zzcz;
        zzcz.zzs();
    }
}
