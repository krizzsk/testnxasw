package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzfn extends zzhc {
    static final Pair zza = new Pair("", 0L);
    public zzfl zzb;
    public final zzfj zzc = new zzfj(this, "first_open_time", 0);
    public final zzfj zzd = new zzfj(this, "app_install_time", 0);
    public final zzfm zze = new zzfm(this, "app_instance_id", (String) null);
    public final zzfj zzf = new zzfj(this, "session_timeout", 1800000);
    public final zzfh zzg = new zzfh(this, "start_new_session", true);
    public final zzfm zzh = new zzfm(this, "non_personalized_ads", (String) null);
    public final zzfh zzi = new zzfh(this, "allow_remote_dynamite", false);
    public final zzfj zzj = new zzfj(this, "last_pause_time", 0);
    public boolean zzk;
    public final zzfh zzl = new zzfh(this, "app_backgrounded", false);
    public final zzfh zzm = new zzfh(this, "deep_link_retrieval_complete", false);
    public final zzfj zzn = new zzfj(this, "deep_link_retrieval_attempts", 0);
    public final zzfm zzo = new zzfm(this, "firebase_feature_rollouts", (String) null);
    public final zzfm zzp = new zzfm(this, "deferred_attribution_cache", (String) null);
    public final zzfj zzq = new zzfj(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfi zzr = new zzfi(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;

    zzfn(zzgi zzgi) {
        super(zzgi);
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzt);
        return this.zzt;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzaB() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.zzs.zzav(), "com.google.android.gms.measurement.prefs", 0);
        this.zzt = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzk = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzt.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzs.zzf();
        this.zzb = new zzfl(this, "health_monitor", Math.max(0, ((Long) zzel.zzb.zza((Object) null)).longValue()), (zzfk) null);
    }

    /* access modifiers changed from: package-private */
    public final Pair zzb(String str) {
        zzg();
        long elapsedRealtime = this.zzs.zzaw().elapsedRealtime();
        String str2 = this.zzu;
        if (str2 != null && elapsedRealtime < this.zzw) {
            return new Pair(str2, Boolean.valueOf(this.zzv));
        }
        this.zzw = elapsedRealtime + this.zzs.zzf().zzi(str, zzel.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzav());
            this.zzu = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzu = id;
            }
            this.zzv = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            this.zzs.zzaz().zzc().zzb("Unable to get advertising id", e);
            this.zzu = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzu, Boolean.valueOf(this.zzv));
    }

    /* access modifiers changed from: package-private */
    public final zzah zzc() {
        zzg();
        return zzah.zzb(zza().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzi(boolean z) {
        zzg();
        this.zzs.zzaz().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj() {
        SharedPreferences sharedPreferences = this.zzt;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(long j) {
        return j - this.zzf.zza() > this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl(int i) {
        return zzah.zzj(i, zza().getInt("consent_source", 100));
    }
}
