package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzju implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzp zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzkb zzf;

    zzju(zzkb zzkb, AtomicReference atomicReference, String str, String str2, String str3, zzp zzp, boolean z) {
        this.zzf = zzkb;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzp;
        this.zze = z;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzkb zzkb = this.zzf;
                zzeo zzh = zzkb.zzb;
                if (zzh == null) {
                    zzkb.zzs.zzaz().zzd().zzd("(legacy) Failed to get user properties; not connected to service", (Object) null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzh.zzh(this.zzb, this.zzc, this.zze, this.zzd));
                } else {
                    this.zza.set(zzh.zzi((String) null, this.zzb, this.zzc, this.zze));
                }
                this.zzf.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzs.zzaz().zzd().zzd("(legacy) Failed to get user properties; remote exception", (Object) null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
