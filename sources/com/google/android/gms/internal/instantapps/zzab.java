package com.google.android.gms.internal.instantapps;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;

final class zzab extends zze {
    private final /* synthetic */ zzz zzbf;

    zzab(zzz zzz) {
        this.zzbf = zzz;
    }

    public final void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbf.setResult(new zzae(this, parcelFileDescriptor, status));
    }
}
