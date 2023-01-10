package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zznw;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzfo implements Runnable {
    final /* synthetic */ zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzfp zzc;

    zzfo(zzfp zzfp, zzbr zzbr, ServiceConnection serviceConnection) {
        this.zzc = zzfp;
        this.zza = zzbr;
        this.zzb = serviceConnection;
    }

    public final void run() {
        Bundle bundle;
        zzfp zzfp = this.zzc;
        zzfq zzfq = zzfp.zza;
        String zza2 = zzfp.zzb;
        zzbr zzbr = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfq.zza.zzaA().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString(GlobalCashierCoreModule.PACKAGE_NAME, zza2);
        try {
            bundle = zzbr.zzd(bundle2);
            if (bundle == null) {
                zzfq.zza.zzaz().zzd().zza("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e) {
            zzfq.zza.zzaz().zzd().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzfq.zza.zzaA().zzg();
        zzgi.zzO();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfq.zza.zzaz().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfq.zza.zzaz().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfq.zza.zzaz().zzj().zzb("InstallReferrer API result", string);
                    zzlp zzv = zzfq.zza.zzv();
                    Uri parse = Uri.parse("?".concat(string));
                    zznw.zzc();
                    boolean zzs = zzfq.zza.zzf().zzs((String) null, zzel.zzau);
                    zznw.zzc();
                    Bundle zzs2 = zzv.zzs(parse, zzs, zzfq.zza.zzf().zzs((String) null, zzel.zzax));
                    if (zzs2 == null) {
                        zzfq.zza.zzaz().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs2.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfq.zza.zzaz().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfq.zza.zzm().zzd.zza()) {
                            zzfq.zza.zzaz().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzfq.zza.zzJ()) {
                            zzfq.zza.zzm().zzd.zzb(j);
                            zzfq.zza.zzaz().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs2.putString("_cis", "referrer API v2");
                            zzfq.zza.zzq().zzG(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzs2, zza2);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfq.zza.zzav(), serviceConnection);
    }
}
