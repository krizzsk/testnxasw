package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcky implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzclb zzd;

    zzcky(zzclb zzclb, String str, String str2, int i) {
        this.zzd = zzclb;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put(Const.BlockParamConst.SRC, this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalBytes", Integer.toString(this.zzc));
        zzclb.zza(this.zzd, "onPrecacheEvent", hashMap);
    }
}
