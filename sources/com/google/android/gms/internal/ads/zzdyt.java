package com.google.android.gms.internal.ads;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdyt {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzdyt(String str, zzdys zzdys) {
        this.zzb = str;
    }

    static /* synthetic */ String zza(zzdyt zzdyt) {
        String str = (String) zzay.zzc().zzb(zzbjc.zzii);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdyt.zza);
            jSONObject.put("eventCategory", zzdyt.zzb);
            jSONObject.putOpt("event", zzdyt.zzc);
            jSONObject.putOpt(Constants.ERROR_CODE, zzdyt.zzd);
            jSONObject.putOpt("rewardType", zzdyt.zze);
            jSONObject.putOpt("rewardAmount", zzdyt.zzf);
        } catch (JSONException unused) {
            zze.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
