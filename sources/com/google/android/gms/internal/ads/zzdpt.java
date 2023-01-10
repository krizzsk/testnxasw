package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.push.fcm.Constact;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpt implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdtn zzd;
    private final Clock zze;
    private zzbny zzf;
    private zzbpu zzg;

    public zzdpt(zzdtn zzdtn, Clock clock) {
        this.zzd = zzdtn;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put(Constact.KEY_LINK_MESSAGETYPE, "onePointFiveClick");
                this.zzd.zzg("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final zzbny zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzc(zzbny zzbny) {
        this.zzf = zzbny;
        zzbpu zzbpu = this.zzg;
        if (zzbpu != null) {
            this.zzd.zzk("/unconfirmedClick", zzbpu);
        }
        zzdps zzdps = new zzdps(this, zzbny);
        this.zzg = zzdps;
        this.zzd.zzi("/unconfirmedClick", zzdps);
    }
}
