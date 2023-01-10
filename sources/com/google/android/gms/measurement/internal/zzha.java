package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzha extends zzen {
    /* access modifiers changed from: private */
    public final zzli zza;
    private Boolean zzb;
    private String zzc = null;

    public zzha(zzli zzli, String str) {
        Preconditions.checkNotNull(zzli);
        this.zza = zzli;
    }

    private final void zzA(zzav zzav, zzp zzp) {
        this.zza.zzA();
        this.zza.zzD(zzav, zzp);
    }

    private final void zzy(zzp zzp, boolean z) {
        Preconditions.checkNotNull(zzp);
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        this.zza.zzv().zzX(zzp.zzb, zzp.zzq);
    }

    private final void zzz(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzav(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzav()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzaz().zzd().zzb("Measurement Service called with invalid calling package. appId", zzey.zzn(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzav(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzaz().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final zzav zzb(zzav zzav, zzp zzp) {
        zzat zzat;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzav.zza) || (zzat = zzav.zzb) == null || zzat.zza() == 0)) {
            String zzg = zzav.zzb.zzg("_cis");
            if ("referrer broadcast".equals(zzg) || "referrer API".equals(zzg)) {
                this.zza.zzaz().zzi().zzb("Event has been filtered ", zzav.toString());
                return new zzav("_cmpx", zzav.zzb, zzav.zzc, zzav.zzd);
            }
        }
        return zzav;
    }

    public final String zzd(zzp zzp) {
        zzy(zzp, false);
        return this.zza.zzx(zzp);
    }

    public final List zze(zzp zzp, boolean z) {
        zzy(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzln> list = (List) this.zza.zzaA().zzh(new zzgx(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzc("Failed to get user properties. appId", zzey.zzn(zzp.zza), e);
            return null;
        }
    }

    public final List zzf(String str, String str2, zzp zzp) {
        zzy(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaA().zzh(new zzgo(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) this.zza.zzaA().zzh(new zzgp(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final List zzh(String str, String str2, boolean z, zzp zzp) {
        zzy(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzln> list = (List) this.zza.zzaA().zzh(new zzgm(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzc("Failed to query user properties. appId", zzey.zzn(zzp.zza), e);
            return Collections.emptyList();
        }
    }

    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        try {
            List<zzln> list = (List) this.zza.zzaA().zzh(new zzgn(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzc("Failed to get user properties as. appId", zzey.zzn(str), e);
            return Collections.emptyList();
        }
    }

    public final void zzj(zzp zzp) {
        zzy(zzp, false);
        zzx(new zzgy(this, zzp));
    }

    public final void zzk(zzav zzav, zzp zzp) {
        Preconditions.checkNotNull(zzav);
        zzy(zzp, false);
        zzx(new zzgt(this, zzav, zzp));
    }

    public final void zzl(zzav zzav, String str, String str2) {
        Preconditions.checkNotNull(zzav);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new zzgu(this, zzav, str));
    }

    public final void zzm(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        zzx(new zzgq(this, zzp));
    }

    public final void zzn(zzab zzab, zzp zzp) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        zzy(zzp, false);
        zzab zzab2 = new zzab(zzab);
        zzab2.zza = zzp.zza;
        zzx(new zzgk(this, zzab2, zzp));
    }

    public final void zzo(zzab zzab) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zza);
        zzz(zzab.zza, true);
        zzx(new zzgl(this, new zzab(zzab)));
    }

    public final void zzp(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        Preconditions.checkNotNull(zzp.zzv);
        zzgs zzgs = new zzgs(this, zzp);
        Preconditions.checkNotNull(zzgs);
        if (this.zza.zzaA().zzs()) {
            zzgs.run();
        } else {
            this.zza.zzaA().zzq(zzgs);
        }
    }

    public final void zzq(long j, String str, String str2, String str3) {
        zzx(new zzgz(this, str2, str3, str, j));
    }

    public final void zzr(Bundle bundle, zzp zzp) {
        zzy(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        zzx(new zzgj(this, str, bundle));
    }

    public final void zzs(zzp zzp) {
        zzy(zzp, false);
        zzx(new zzgr(this, zzp));
    }

    public final void zzt(zzll zzll, zzp zzp) {
        Preconditions.checkNotNull(zzll);
        zzy(zzp, false);
        zzx(new zzgw(this, zzll, zzp));
    }

    public final byte[] zzu(zzav zzav, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzav);
        zzz(str, true);
        this.zza.zzaz().zzc().zzb("Log and bundle. event", this.zza.zzj().zzd(zzav.zza));
        long nanoTime = this.zza.zzaw().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzaA().zzi(new zzgv(this, zzav, str)).get();
            if (bArr == null) {
                this.zza.zzaz().zzd().zzb("Log and bundle returned null. appId", zzey.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzaz().zzc().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzj().zzd(zzav.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzaw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaz().zzd().zzd("Failed to log and bundle. appId, event, error", zzey.zzn(str), this.zza.zzj().zzd(zzav.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv(zzav zzav, zzp zzp) {
        zzc zzc2;
        if (!this.zza.zzo().zzo(zzp.zza)) {
            zzA(zzav, zzp);
            return;
        }
        this.zza.zzaz().zzj().zzb("EES config found for", zzp.zza);
        zzfz zzo = this.zza.zzo();
        String str = zzp.zza;
        if (TextUtils.isEmpty(str)) {
            zzc2 = null;
        } else {
            zzc2 = (zzc) zzo.zzd.get(str);
        }
        if (zzc2 != null) {
            try {
                Map zzs = this.zza.zzu().zzs(zzav.zzb.zzc(), true);
                String zza2 = zzhf.zza(zzav.zza);
                if (zza2 == null) {
                    zza2 = zzav.zza;
                }
                if (zzc2.zze(new zzaa(zza2, zzav.zzd, zzs))) {
                    if (zzc2.zzg()) {
                        this.zza.zzaz().zzj().zzb("EES edited event", zzav.zza);
                        zzA(this.zza.zzu().zzi(zzc2.zza().zzb()), zzp);
                    } else {
                        zzA(zzav, zzp);
                    }
                    if (zzc2.zzf()) {
                        for (zzaa zzaa : zzc2.zza().zzc()) {
                            this.zza.zzaz().zzj().zzb("EES logging created event", zzaa.zzd());
                            zzA(this.zza.zzu().zzi(zzaa), zzp);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.zza.zzaz().zzd().zzc("EES error. appId, eventName", zzp.zzb, zzav.zza);
            }
            this.zza.zzaz().zzj().zzb("EES was not applied to event", zzav.zza);
            zzA(zzav, zzp);
            return;
        }
        this.zza.zzaz().zzj().zzb("EES not loaded for", zzp.zza);
        zzA(zzav, zzp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(String str, Bundle bundle) {
        zzal zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzW();
        byte[] zzby = zzi.zzf.zzu().zzj(new zzaq(zzi.zzs, "", str, "dep", 0, 0, bundle)).zzby();
        zzi.zzs.zzaz().zzj().zzc("Saving default event parameters, appId, data size", zzi.zzs.zzj().zzd(str), Integer.valueOf(zzby.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzby);
        try {
            if (zzi.zzh().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzi.zzs.zzaz().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzey.zzn(str));
            }
        } catch (SQLiteException e) {
            zzi.zzs.zzaz().zzd().zzc("Error storing default event parameters. appId", zzey.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaA().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaA().zzp(runnable);
        }
    }
}
