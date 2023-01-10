package com.google.android.gms.internal.instantapps;

public class zzdk {
    private static final zzck zzakk = zzck.zzbf();
    private zzbp zzaqp;
    private volatile zzef zzaqq;
    private volatile zzbp zzaqr;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdk)) {
            return false;
        }
        zzdk zzdk = (zzdk) obj;
        zzef zzef = this.zzaqq;
        zzef zzef2 = zzdk.zzaqq;
        if (zzef == null && zzef2 == null) {
            return zzm().equals(zzdk.zzm());
        }
        if (zzef != null && zzef2 != null) {
            return zzef.equals(zzef2);
        }
        if (zzef != null) {
            return zzef.equals(zzdk.zzg(zzef.zzbx()));
        }
        return zzg(zzef2.zzbx()).equals(zzef2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.instantapps.zzef zzg(com.google.android.gms.internal.instantapps.zzef r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.instantapps.zzef r0 = r1.zzaqq
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.instantapps.zzef r0 = r1.zzaqq     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzaqq = r2     // Catch:{ zzdf -> 0x0012 }
            com.google.android.gms.internal.instantapps.zzbp r0 = com.google.android.gms.internal.instantapps.zzbp.zzakv     // Catch:{ zzdf -> 0x0012 }
            r1.zzaqr = r0     // Catch:{ zzdf -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzaqq = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.instantapps.zzbp r2 = com.google.android.gms.internal.instantapps.zzbp.zzakv     // Catch:{ all -> 0x001a }
            r1.zzaqr = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.instantapps.zzef r2 = r1.zzaqq
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzdk.zzg(com.google.android.gms.internal.instantapps.zzef):com.google.android.gms.internal.instantapps.zzef");
    }

    public final zzef zzh(zzef zzef) {
        zzef zzef2 = this.zzaqq;
        this.zzaqp = null;
        this.zzaqr = null;
        this.zzaqq = zzef;
        return zzef2;
    }

    public final int zzbz() {
        if (this.zzaqr != null) {
            return this.zzaqr.size();
        }
        if (this.zzaqq != null) {
            return this.zzaqq.zzbz();
        }
        return 0;
    }

    public final zzbp zzm() {
        if (this.zzaqr != null) {
            return this.zzaqr;
        }
        synchronized (this) {
            if (this.zzaqr != null) {
                zzbp zzbp = this.zzaqr;
                return zzbp;
            }
            if (this.zzaqq == null) {
                this.zzaqr = zzbp.zzakv;
            } else {
                this.zzaqr = this.zzaqq.zzm();
            }
            zzbp zzbp2 = this.zzaqr;
            return zzbp2;
        }
    }
}
