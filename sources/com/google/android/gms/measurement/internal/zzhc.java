package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
abstract class zzhc extends zzhb {
    private boolean zza;

    zzhc(zzgi zzgi) {
        super(zzgi);
        this.zzs.zzD();
    }

    /* access modifiers changed from: protected */
    public void zzaB() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzf();

    /* access modifiers changed from: protected */
    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzs.zzB();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzaB();
            this.zzs.zzB();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zza;
    }
}
