package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbn extends zzbj<Boolean> implements zzdc<Boolean>, zzer, RandomAccess {
    private static final zzbn zzaks;
    private int size;
    private boolean[] zzakt;

    zzbn() {
        this(new boolean[10], 0);
    }

    private zzbn(boolean[] zArr, int i) {
        this.zzakt = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzt();
        if (i2 >= i) {
            boolean[] zArr = this.zzakt;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzbn)) {
            return super.equals(obj);
        }
        zzbn zzbn = (zzbn) obj;
        if (this.size != zzbn.size) {
            return false;
        }
        boolean[] zArr = zzbn.zzakt;
        for (int i = 0; i < this.size; i++) {
            if (this.zzakt[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzcy.zzc(this.zzakt[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    private final void zza(int i, boolean z) {
        int i2;
        zzt();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        boolean[] zArr = this.zzakt;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzakt, i, zArr2, i + 1, this.size - i);
            this.zzakt = zArr2;
        }
        this.zzakt[i] = z;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzt();
        zzcy.checkNotNull(collection);
        if (!(collection instanceof zzbn)) {
            return super.addAll(collection);
        }
        zzbn zzbn = (zzbn) collection;
        int i = zzbn.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzakt;
            if (i3 > zArr.length) {
                this.zzakt = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzbn.zzakt, 0, this.zzakt, this.size, zzbn.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzt();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzakt[i]))) {
                boolean[] zArr = this.zzakt;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzt();
        zzg(i);
        boolean[] zArr = this.zzakt;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzt();
        zzg(i);
        boolean[] zArr = this.zzakt;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= this.size) {
            return new zzbn(Arrays.copyOf(this.zzakt, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Boolean.valueOf(this.zzakt[i]);
    }

    static {
        zzbn zzbn = new zzbn(new boolean[0], 0);
        zzaks = zzbn;
        zzbn.zzs();
    }
}
