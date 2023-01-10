package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzfg extends BroadcastReceiver {
    static final String zza = zzfg.class.getName();
    /* access modifiers changed from: private */
    public final zzli zzb;
    private boolean zzc;
    private boolean zzd;

    zzfg(zzli zzli) {
        Preconditions.checkNotNull(zzli);
        this.zzb = zzli;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzaz().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(action)) {
            boolean zza2 = this.zzb.zzl().zza();
            if (this.zzd != zza2) {
                this.zzd = zza2;
                this.zzb.zzaA().zzp(new zzff(this, zza2));
                return;
            }
            return;
        }
        this.zzb.zzaz().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zzb() {
        this.zzb.zzB();
        this.zzb.zzaA().zzg();
        if (!this.zzc) {
            try {
                this.zzb.zzav().registerReceiver(this, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            this.zzd = this.zzb.zzl().zza();
            this.zzb.zzaz().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaA().zzg();
        this.zzb.zzaA().zzg();
        if (this.zzc) {
            this.zzb.zzaz().zzj().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzav().unregisterReceiver(this);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (IllegalArgumentException e2) {
                    this.zzb.zzaz().zzd().zzb("Failed to unregister the network broadcast receiver", e2);
                }
            }
        }
    }
}
