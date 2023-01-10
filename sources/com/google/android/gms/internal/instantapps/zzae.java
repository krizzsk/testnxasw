package com.google.android.gms.internal.instantapps;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.zzf;

final class zzae implements zzf {
    private final /* synthetic */ Status zzbg;
    private final /* synthetic */ ParcelFileDescriptor zzbh;

    zzae(zzab zzab, ParcelFileDescriptor parcelFileDescriptor, Status status) {
        this.zzbh = parcelFileDescriptor;
        this.zzbg = status;
    }

    public final ParcelFileDescriptor zzc() {
        return this.zzbh;
    }

    public final Status getStatus() {
        return this.zzbg;
    }
}
