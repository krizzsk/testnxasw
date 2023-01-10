package com.google.android.gms.internal.instantapps;

import java.util.Collections;
import java.util.List;

final class zzdr extends zzdp {
    private static final Class<?> zzaqy = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdr() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzfs.zzp(obj, j);
        if (list instanceof zzdm) {
            obj2 = ((zzdm) list).zzcr();
        } else if (!zzaqy.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzer) || !(list instanceof zzdc)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzdc zzdc = (zzdc) list;
                if (zzdc.zzr()) {
                    zzdc.zzs();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzfs.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.instantapps.zzdn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.instantapps.zzdn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.instantapps.zzdn} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzd(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzdm
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.instantapps.zzdn r0 = new com.google.android.gms.internal.instantapps.zzdn
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzer
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzdc
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.instantapps.zzdc r0 = (com.google.android.gms.internal.instantapps.zzdc) r0
            com.google.android.gms.internal.instantapps.zzdc r6 = r0.zzi(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.instantapps.zzfs.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = zzaqy
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.instantapps.zzfs.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzfr
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.instantapps.zzdn r1 = new com.google.android.gms.internal.instantapps.zzdn
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.instantapps.zzfr r0 = (com.google.android.gms.internal.instantapps.zzfr) r0
            r1.addAll(r0)
            com.google.android.gms.internal.instantapps.zzfs.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzer
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.instantapps.zzdc
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.instantapps.zzdc r1 = (com.google.android.gms.internal.instantapps.zzdc) r1
            boolean r2 = r1.zzr()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.instantapps.zzdc r0 = r1.zzi(r0)
            com.google.android.gms.internal.instantapps.zzfs.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzdr.zza(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzfs.zza(obj, j, (Object) zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfs.zzp(obj, j);
    }
}
