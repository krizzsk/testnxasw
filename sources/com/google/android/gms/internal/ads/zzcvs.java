package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvs implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzcvs(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* synthetic */ Object zzb() {
        Set set;
        zzcvk zzcvk = (zzcvk) this.zza.zzb();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        if (((JSONObject) this.zzc.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdkg(zzcvk, zzfzq));
        }
        zzgxq.zzb(set);
        return set;
    }
}
