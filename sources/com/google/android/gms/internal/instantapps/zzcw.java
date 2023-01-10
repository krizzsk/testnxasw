package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcw extends zzbj<Float> implements zzdc<Float>, zzer, RandomAccess {
    private static final zzcw zzaox;
    private int size;
    private float[] zzaoy;

    zzcw() {
        this(new float[10], 0);
    }

    private zzcw(float[] fArr, int i) {
        this.zzaoy = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzt();
        if (i2 >= i) {
            float[] fArr = this.zzaoy;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzcw)) {
            return super.equals(obj);
        }
        zzcw zzcw = (zzcw) obj;
        if (this.size != zzcw.size) {
            return false;
        }
        float[] fArr = zzcw.zzaoy;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzaoy[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzaoy[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        int i2;
        zzt();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        float[] fArr = this.zzaoy;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzaoy, i, fArr2, i + 1, this.size - i);
            this.zzaoy = fArr2;
        }
        this.zzaoy[i] = f;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzt();
        zzcy.checkNotNull(collection);
        if (!(collection instanceof zzcw)) {
            return super.addAll(collection);
        }
        zzcw zzcw = (zzcw) collection;
        int i = zzcw.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzaoy;
            if (i3 > fArr.length) {
                this.zzaoy = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzcw.zzaoy, 0, this.zzaoy, this.size, zzcw.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzt();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzaoy[i]))) {
                float[] fArr = this.zzaoy;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzt();
        zzg(i);
        float[] fArr = this.zzaoy;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzt();
        zzg(i);
        float[] fArr = this.zzaoy;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= this.size) {
            return new zzcw(Arrays.copyOf(this.zzaoy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Float.valueOf(this.zzaoy[i]);
    }

    static {
        zzcw zzcw = new zzcw(new float[0], 0);
        zzaox = zzcw;
        zzcw.zzs();
    }
}
