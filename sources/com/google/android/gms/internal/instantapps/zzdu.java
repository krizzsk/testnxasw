package com.google.android.gms.internal.instantapps;

final class zzdu implements zzec {
    private zzec[] zzard;

    zzdu(zzec... zzecArr) {
        this.zzard = zzecArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzec zza : this.zzard) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzed zzb(Class<?> cls) {
        for (zzec zzec : this.zzard) {
            if (zzec.zza(cls)) {
                return zzec.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
