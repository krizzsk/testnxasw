package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzel<T> implements zzeu<T> {
    private final zzef zzarr;
    private final boolean zzars;
    private final zzfm<?, ?> zzasb;
    private final zzcm<?> zzasc;

    private zzel(zzfm<?, ?> zzfm, zzcm<?> zzcm, zzef zzef) {
        this.zzasb = zzfm;
        this.zzars = zzcm.zze(zzef);
        this.zzasc = zzcm;
        this.zzarr = zzef;
    }

    static <T> zzel<T> zza(zzfm<?, ?> zzfm, zzcm<?> zzcm, zzef zzef) {
        return new zzel<>(zzfm, zzcm, zzef);
    }

    public final T newInstance() {
        return this.zzarr.zzcc().zzbv();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzasb.zzq(t).equals(this.zzasb.zzq(t2))) {
            return false;
        }
        if (this.zzars) {
            return this.zzasc.zza((Object) t).equals(this.zzasc.zza((Object) t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzasb.zzq(t).hashCode();
        return this.zzars ? (hashCode * 53) + this.zzasc.zza((Object) t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzew.zza(this.zzasb, t, t2);
        if (this.zzars) {
            zzew.zza(this.zzasc, t, t2);
        }
    }

    public final void zza(T t, zzgi zzgi) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzasc.zza((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzcs zzcs = (zzcs) next.getKey();
            if (zzcs.zzbo() != zzgg.MESSAGE || zzcs.zzbp() || zzcs.zzbq()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzdi) {
                zzgi.zza(zzcs.zzk(), (Object) ((zzdi) next).zzcp().zzm());
            } else {
                zzgi.zza(zzcs.zzk(), next.getValue());
            }
        }
        zzfm<?, ?> zzfm = this.zzasb;
        zzfm.zzc(zzfm.zzq(t), zzgi);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.instantapps.zzcx$zze} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.instantapps.zzbk r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.instantapps.zzcx r0 = (com.google.android.gms.internal.instantapps.zzcx) r0
            com.google.android.gms.internal.instantapps.zzfp r1 = r0.zzapc
            com.google.android.gms.internal.instantapps.zzfp r2 = com.google.android.gms.internal.instantapps.zzfp.zzea()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.instantapps.zzfp r1 = com.google.android.gms.internal.instantapps.zzfp.zzeb()
            r0.zzapc = r1
        L_0x0011:
            com.google.android.gms.internal.instantapps.zzcx$zzb r10 = (com.google.android.gms.internal.instantapps.zzcx.zzb) r10
            r10.zzcd()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.instantapps.zzbl.zza(r11, r12, r14)
            int r2 = r14.zzako
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.instantapps.zzcm<?> r12 = r9.zzasc
            com.google.android.gms.internal.instantapps.zzck r0 = r14.zzakr
            com.google.android.gms.internal.instantapps.zzef r3 = r9.zzarr
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.instantapps.zzcx$zze r0 = (com.google.android.gms.internal.instantapps.zzcx.zze) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.instantapps.zzbl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.instantapps.zzfp) r6, (com.google.android.gms.internal.instantapps.zzbk) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.instantapps.zzeq.zzdi()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.instantapps.zzbl.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.instantapps.zzbk) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.instantapps.zzbl.zza(r11, r4, r14)
            int r5 = r14.zzako
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.instantapps.zzbl.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzakq
            com.google.android.gms.internal.instantapps.zzbp r2 = (com.google.android.gms.internal.instantapps.zzbp) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.instantapps.zzeq.zzdi()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.instantapps.zzbl.zza(r11, r4, r14)
            int r12 = r14.zzako
            com.google.android.gms.internal.instantapps.zzcm<?> r0 = r9.zzasc
            com.google.android.gms.internal.instantapps.zzck r5 = r14.zzakr
            com.google.android.gms.internal.instantapps.zzef r6 = r9.zzarr
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.instantapps.zzcx$zze r0 = (com.google.android.gms.internal.instantapps.zzcx.zze) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.instantapps.zzbl.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.instantapps.zzbk) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzb(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.instantapps.zzdf r10 = com.google.android.gms.internal.instantapps.zzdf.zzcl()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzel.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.instantapps.zzbk):void");
    }

    public final void zza(T t, zzev zzev, zzck zzck) throws IOException {
        boolean z;
        zzfm<?, ?> zzfm = this.zzasb;
        zzcm<?> zzcm = this.zzasc;
        Object zzr = zzfm.zzr(t);
        zzcq<?> zzb = zzcm.zzb(t);
        do {
            try {
                if (zzev.zzas() == Integer.MAX_VALUE) {
                    zzfm.zzf(t, zzr);
                    return;
                }
                int tag = zzev.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzbp zzbp = null;
                    while (zzev.zzas() != Integer.MAX_VALUE) {
                        int tag2 = zzev.getTag();
                        if (tag2 == 16) {
                            i = zzev.zzaj();
                            obj = zzcm.zza(zzck, this.zzarr, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzcm.zza(zzev, obj, zzck, zzb);
                            } else {
                                zzbp = zzev.zzai();
                            }
                        } else if (!zzev.zzat()) {
                            break;
                        }
                    }
                    if (zzev.getTag() != 12) {
                        throw zzdf.zzcj();
                    } else if (zzbp != null) {
                        if (obj != null) {
                            zzcm.zza(zzbp, obj, zzck, zzb);
                        } else {
                            zzfm.zza(zzr, i, zzbp);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzcm.zza(zzck, this.zzarr, tag >>> 3);
                    if (zza != null) {
                        zzcm.zza(zzev, zza, zzck, zzb);
                    } else {
                        z = zzfm.zza(zzr, zzev);
                        continue;
                    }
                } else {
                    z = zzev.zzat();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzfm.zzf(t, zzr);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzasb.zzc(t);
        this.zzasc.zzc(t);
    }

    public final boolean zzo(T t) {
        return this.zzasc.zza((Object) t).isInitialized();
    }

    public final int zzm(T t) {
        zzfm<?, ?> zzfm = this.zzasb;
        int zzs = zzfm.zzs(zzfm.zzq(t)) + 0;
        return this.zzars ? zzs + this.zzasc.zza((Object) t).zzbm() : zzs;
    }
}
