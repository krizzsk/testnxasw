package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfvn extends zzfvi implements List, RandomAccess {
    private static final zzfxn zza = new zzfvl(zzfww.zza, 0);

    zzfvn() {
    }

    public static zzfvk zzi() {
        return new zzfvk(4);
    }

    static zzfvn zzj(Object[] objArr) {
        return zzk(objArr, objArr.length);
    }

    static zzfvn zzk(Object[] objArr, int i) {
        if (i == 0) {
            return zzfww.zza;
        }
        return new zzfww(objArr, i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfvn zzl(java.lang.Iterable r0) {
        /*
            if (r0 == 0) goto L_0x0007
            com.google.android.gms.internal.ads.zzfvn r0 = zzm(r0)
            return r0
        L_0x0007:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvn.zzl(java.lang.Iterable):com.google.android.gms.internal.ads.zzfvn");
    }

    public static zzfvn zzm(Collection collection) {
        if (collection instanceof zzfvi) {
            zzfvn zzd = ((zzfvi) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzk(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzfwu.zzb(array2, length);
        return zzk(array2, length);
    }

    public static zzfvn zzn(Object[] objArr) {
        if (objArr.length == 0) {
            return zzfww.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzfwu.zzb(objArr2, length);
        return zzk(objArr2, length);
    }

    public static zzfvn zzo() {
        return zzfww.zza;
    }

    public static zzfvn zzp(Object obj) {
        Object[] objArr = {obj};
        zzfwu.zzb(objArr, 1);
        return zzk(objArr, 1);
    }

    public static zzfvn zzq(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzfwu.zzb(objArr, 2);
        return zzk(objArr, 2);
    }

    public static zzfvn zzr(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {"2011", "1009", "3010"};
        zzfwu.zzb(objArr, 3);
        return zzk(objArr, 3);
    }

    public static zzfvn zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzfwu.zzb(objArr, 5);
        return zzk(objArr, 5);
    }

    public static zzfvn zzt(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzfwu.zzb(objArr, 6);
        return zzk(objArr, 6);
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzfss.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzfss.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzfvn zzd() {
        return this;
    }

    public final zzfxm zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfvn subList(int i, int i2) {
        zzfsx.zzg(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzfww.zza;
        }
        return new zzfvm(this, i, i3);
    }

    /* renamed from: zzu */
    public final zzfxn listIterator(int i) {
        zzfsx.zzb(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzfvl(this, i);
    }
}
