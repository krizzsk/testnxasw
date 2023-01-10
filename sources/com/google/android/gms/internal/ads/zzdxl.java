package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxl {
    private final ConcurrentHashMap zza;
    private final zzcgc zzb;
    private final zzfef zzc;
    private final String zzd;
    private final String zze;

    public zzdxl(zzdxv zzdxv, zzcgc zzcgc, zzfef zzfef, String str, String str2) {
        this.zza = zzdxv.zzc();
        this.zzb = zzcgc;
        this.zzc = zzfef;
        this.zzd = str;
        this.zze = str2;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgd)).booleanValue()) {
            int zzd2 = zzf.zzd(this.zzc);
            int i = zzd2 - 1;
            if (i != 0) {
                if (i == 1) {
                    this.zza.put("se", "query_g");
                } else if (i == 2) {
                    this.zza.put("se", "r_adinfo");
                } else if (i != 3) {
                    this.zza.put("se", "r_both");
                } else {
                    this.zza.put("se", "r_adstring");
                }
                this.zza.put("scar", "true");
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzgE)).booleanValue()) {
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, this.zze);
                }
                if (zzd2 == 2) {
                    this.zza.put("rid", this.zzd);
                }
                zzd("ragent", this.zzc.zzd.zzp);
                zzd("rtype", zzf.zza(zzf.zzb(this.zzc.zzd)));
                return;
            }
            this.zza.put("scar", SDKConsts.BOOLEAN_FALSE);
        }
    }

    private final void zzd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final Map zza() {
        return this.zza;
    }

    public final void zzb(zzfdw zzfdw) {
        if (zzfdw.zzb.zza.size() > 0) {
            switch (((zzfdk) zzfdw.zzb.zza.get(0)).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, Const.ComponentType.BANNER);
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    this.zza.put("as", true != this.zzb.zzj() ? "0" : "1");
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        zzd("gqi", zzfdw.zzb.zzb.zzb);
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
