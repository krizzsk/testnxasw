package com.google.android.gms.internal.instantapps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdn extends zzbj<String> implements zzdm, RandomAccess {
    private static final zzdn zzaqt;
    private static final zzdm zzaqu = zzaqt;
    private final List<Object> zzaqv;

    public zzdn() {
        this(10);
    }

    public zzdn(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzdn(ArrayList<Object> arrayList) {
        this.zzaqv = arrayList;
    }

    public final int size() {
        return this.zzaqv.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzt();
        if (collection instanceof zzdm) {
            collection = ((zzdm) collection).zzcq();
        }
        boolean addAll = this.zzaqv.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzt();
        this.zzaqv.clear();
        this.modCount++;
    }

    public final void zzc(zzbp zzbp) {
        zzt();
        this.zzaqv.add(zzbp);
        this.modCount++;
    }

    public final Object zzam(int i) {
        return this.zzaqv.get(i);
    }

    private static String zze(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbp) {
            return ((zzbp) obj).zzu();
        }
        return zzcy.zze((byte[]) obj);
    }

    public final List<?> zzcq() {
        return Collections.unmodifiableList(this.zzaqv);
    }

    public final zzdm zzcr() {
        return zzr() ? new zzfr(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzt();
        return zze(this.zzaqv.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzt();
        Object remove = this.zzaqv.remove(i);
        this.modCount++;
        return zze(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzr() {
        return super.zzr();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzt();
        this.zzaqv.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzaqv);
            return new zzdn((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzaqv.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbp) {
            zzbp zzbp = (zzbp) obj;
            String zzu = zzbp.zzu();
            if (zzbp.zzv()) {
                this.zzaqv.set(i, zzu);
            }
            return zzu;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzcy.zze(bArr);
        if (zzcy.zzd(bArr)) {
            this.zzaqv.set(i, zze);
        }
        return zze;
    }

    static {
        zzdn zzdn = new zzdn();
        zzaqt = zzdn;
        zzdn.zzs();
    }
}
