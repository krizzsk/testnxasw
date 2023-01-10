package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzcq<FieldDescriptorType extends zzcs<FieldDescriptorType>> {
    private static final zzcq zzamh = new zzcq(true);
    final zzez<FieldDescriptorType, Object> zzame = zzez.zzau(16);
    private boolean zzamf;
    private boolean zzamg = false;

    private zzcq() {
    }

    private zzcq(boolean z) {
        zzs();
    }

    public static <T extends zzcs<T>> zzcq<T> zzbl() {
        return zzamh;
    }

    public final void zzs() {
        if (!this.zzamf) {
            this.zzame.zzs();
            this.zzamf = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzamf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        return this.zzame.equals(((zzcq) obj).zzame);
    }

    public final int hashCode() {
        return this.zzame.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzamg) {
            return new zzdl(this.zzame.entrySet().iterator());
        }
        return this.zzame.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzamg) {
            return new zzdl(this.zzame.zzdt().iterator());
        }
        return this.zzame.zzdt().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzame.get(fielddescriptortype);
        return obj instanceof zzdg ? zzdg.zzcn() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzbp()) {
            zza(fielddescriptortype.zzbn(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzbn(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzdg) {
            this.zzamg = true;
        }
        this.zzame.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.instantapps.zzdb) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.instantapps.zzdg) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.instantapps.zzgd r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.instantapps.zzcy.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.instantapps.zzcp.zzamd
            com.google.android.gms.internal.instantapps.zzgg r2 = r2.zzej()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                case 3: goto L_0x003b;
                case 4: goto L_0x0038;
                case 5: goto L_0x0035;
                case 6: goto L_0x0032;
                case 7: goto L_0x0029;
                case 8: goto L_0x0020;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0044
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.instantapps.zzef
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.instantapps.zzdg
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x001e:
            r0 = 0
            goto L_0x0043
        L_0x0020:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof com.google.android.gms.internal.instantapps.zzdb
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0029:
            boolean r2 = r3 instanceof com.google.android.gms.internal.instantapps.zzbp
            if (r2 != 0) goto L_0x0043
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x001e
            goto L_0x0043
        L_0x0032:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0043
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0043
        L_0x0038:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0043
        L_0x003b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0043
        L_0x003e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0043
        L_0x0041:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0043:
            r1 = r0
        L_0x0044:
            if (r1 == 0) goto L_0x0047
            return
        L_0x0047:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzcq.zza(com.google.android.gms.internal.instantapps.zzgd, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzame.zzdr(); i++) {
            if (!zzb(this.zzame.zzav(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzame.zzds()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzcs zzcs = (zzcs) entry.getKey();
        if (zzcs.zzbo() == zzgg.MESSAGE) {
            if (zzcs.zzbp()) {
                for (zzef isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzef) {
                    if (!((zzef) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdg) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzcq<FieldDescriptorType> zzcq) {
        for (int i = 0; i < zzcq.zzame.zzdr(); i++) {
            zzc(zzcq.zzame.zzav(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzcq.zzame.zzds()) {
            zzc(zzc);
        }
    }

    private static Object zzd(Object obj) {
        if (obj instanceof zzek) {
            return ((zzek) obj).zzde();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzcs zzcs = (zzcs) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdg) {
            value = zzdg.zzcn();
        }
        if (zzcs.zzbp()) {
            Object zza = zza(zzcs);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzd : (List) value) {
                ((List) zza).add(zzd(zzd));
            }
            this.zzame.put(zzcs, zza);
        } else if (zzcs.zzbo() == zzgg.MESSAGE) {
            Object zza2 = zza(zzcs);
            if (zza2 == null) {
                this.zzame.put(zzcs, zzd(value));
                return;
            }
            if (zza2 instanceof zzek) {
                obj = zzcs.zza((zzek) zza2, (zzek) value);
            } else {
                obj = zzcs.zza(((zzef) zza2).zzcb(), (zzef) value).zzbw();
            }
            this.zzame.put(zzcs, obj);
        } else {
            this.zzame.put(zzcs, zzd(value));
        }
    }

    static void zza(zzce zzce, zzgd zzgd, int i, Object obj) throws IOException {
        if (zzgd == zzgd.GROUP) {
            zzef zzef = (zzef) obj;
            zzcy.zzf(zzef);
            zzce.zzb(i, 3);
            zzef.zzb(zzce);
            zzce.zzb(i, 4);
            return;
        }
        zzce.zzb(i, zzgd.zzek());
        switch (zzcp.zzals[zzgd.ordinal()]) {
            case 1:
                zzce.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzce.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzce.zzd(((Long) obj).longValue());
                return;
            case 4:
                zzce.zzd(((Long) obj).longValue());
                return;
            case 5:
                zzce.zzw(((Integer) obj).intValue());
                return;
            case 6:
                zzce.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzce.zzz(((Integer) obj).intValue());
                return;
            case 8:
                zzce.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzef) obj).zzb(zzce);
                return;
            case 10:
                zzce.zzb((zzef) obj);
                return;
            case 11:
                if (obj instanceof zzbp) {
                    zzce.zza((zzbp) obj);
                    return;
                } else {
                    zzce.zzf((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbp) {
                    zzce.zza((zzbp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzce.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzce.zzx(((Integer) obj).intValue());
                return;
            case 14:
                zzce.zzz(((Integer) obj).intValue());
                return;
            case 15:
                zzce.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzce.zzy(((Integer) obj).intValue());
                return;
            case 17:
                zzce.zze(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzdb) {
                    zzce.zzw(((zzdb) obj).zzk());
                    return;
                } else {
                    zzce.zzw(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbm() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzame.zzdr(); i2++) {
            i += zzd(this.zzame.zzav(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zzame.zzds()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzcs zzcs = (zzcs) entry.getKey();
        Object value = entry.getValue();
        if (zzcs.zzbo() != zzgg.MESSAGE || zzcs.zzbp() || zzcs.zzbq()) {
            return zzb((zzcs<?>) zzcs, value);
        }
        if (value instanceof zzdg) {
            return zzce.zzb(((zzcs) entry.getKey()).zzk(), (zzdk) (zzdg) value);
        }
        return zzce.zzb(((zzcs) entry.getKey()).zzk(), (zzef) value);
    }

    static int zza(zzgd zzgd, int i, Object obj) {
        int zzaa = zzce.zzaa(i);
        if (zzgd == zzgd.GROUP) {
            zzcy.zzf((zzef) obj);
            zzaa <<= 1;
        }
        return zzaa + zzb(zzgd, obj);
    }

    private static int zzb(zzgd zzgd, Object obj) {
        switch (zzcp.zzals[zzgd.ordinal()]) {
            case 1:
                return zzce.zzb(((Double) obj).doubleValue());
            case 2:
                return zzce.zzb(((Float) obj).floatValue());
            case 3:
                return zzce.zzg(((Long) obj).longValue());
            case 4:
                return zzce.zzh(((Long) obj).longValue());
            case 5:
                return zzce.zzab(((Integer) obj).intValue());
            case 6:
                return zzce.zzj(((Long) obj).longValue());
            case 7:
                return zzce.zzae(((Integer) obj).intValue());
            case 8:
                return zzce.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzce.zzd((zzef) obj);
            case 10:
                if (obj instanceof zzdg) {
                    return zzce.zza((zzdk) (zzdg) obj);
                }
                return zzce.zzc((zzef) obj);
            case 11:
                if (obj instanceof zzbp) {
                    return zzce.zzb((zzbp) obj);
                }
                return zzce.zzg((String) obj);
            case 12:
                if (obj instanceof zzbp) {
                    return zzce.zzb((zzbp) obj);
                }
                return zzce.zzc((byte[]) obj);
            case 13:
                return zzce.zzac(((Integer) obj).intValue());
            case 14:
                return zzce.zzaf(((Integer) obj).intValue());
            case 15:
                return zzce.zzk(((Long) obj).longValue());
            case 16:
                return zzce.zzad(((Integer) obj).intValue());
            case 17:
                return zzce.zzi(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdb) {
                    return zzce.zzag(((zzdb) obj).zzk());
                }
                return zzce.zzag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzcs<?> zzcs, Object obj) {
        zzgd zzbn = zzcs.zzbn();
        int zzk = zzcs.zzk();
        if (!zzcs.zzbp()) {
            return zza(zzbn, zzk, obj);
        }
        int i = 0;
        if (zzcs.zzbq()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzbn, zzb);
            }
            return zzce.zzaa(zzk) + i + zzce.zzai(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzbn, zzk, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzcq zzcq = new zzcq();
        for (int i = 0; i < this.zzame.zzdr(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzav = this.zzame.zzav(i);
            zzcq.zza((zzcs) zzav.getKey(), zzav.getValue());
        }
        for (Map.Entry next : this.zzame.zzds()) {
            zzcq.zza((zzcs) next.getKey(), next.getValue());
        }
        zzcq.zzamg = this.zzamg;
        return zzcq;
    }
}
