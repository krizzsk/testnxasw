package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzau;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzg extends zzk<DeviceMetaData> {
    final /* synthetic */ zzaq zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(AccountTransferClient accountTransferClient, int i, zzaq zzaq) {
        super(1608, (zzb) null);
        this.zza = zzaq;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzau zzau) throws RemoteException {
        zzau.zzd(new zzf(this, this), this.zza);
    }
}
