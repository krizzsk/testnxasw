package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.raven.config.RavenEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzpp;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzgv implements Callable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzha zzc;

    zzgv(zzha zzha, zzav zzav, String str) {
        this.zzc = zzha;
        this.zza = zzav;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzli zzli;
        zzln zzln;
        zzfz zzfz;
        Bundle bundle;
        zzgb zzgb;
        zzg zzg;
        String str;
        long j;
        String str2;
        zzar zzar;
        this.zzc.zza.zzA();
        zzis zzr = this.zzc.zza.zzr();
        zzav zzav = this.zza;
        String str3 = this.zzb;
        zzr.zzg();
        zzgi.zzO();
        Preconditions.checkNotNull(zzav);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.zzs.zzf().zzs(str3, zzel.zzT)) {
            zzr.zzs.zzaz().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if ("_iap".equals(zzav.zza) || "_iapx".equals(zzav.zza)) {
            zzfz zza2 = zzga.zza();
            zzr.zzf.zzi().zzw();
            zzg zzj = zzr.zzf.zzi().zzj(str3);
            if (zzj == null) {
                zzr.zzs.zzaz().zzc().zzb("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
                zzli = zzr.zzf;
            } else if (!zzj.zzaj()) {
                zzr.zzs.zzaz().zzc().zzb("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
                zzli = zzr.zzf;
            } else {
                zzgb zzu = zzgc.zzu();
                zzu.zzae(1);
                zzu.zzaa("android");
                if (!TextUtils.isEmpty(zzj.zzt())) {
                    zzu.zzE(zzj.zzt());
                }
                if (!TextUtils.isEmpty(zzj.zzv())) {
                    zzu.zzG((String) Preconditions.checkNotNull(zzj.zzv()));
                }
                if (!TextUtils.isEmpty(zzj.zzw())) {
                    zzu.zzH((String) Preconditions.checkNotNull(zzj.zzw()));
                }
                if (zzj.zzb() != -2147483648L) {
                    zzu.zzI((int) zzj.zzb());
                }
                zzu.zzW(zzj.zzm());
                zzu.zzQ(zzj.zzk());
                String zzy = zzj.zzy();
                String zzr2 = zzj.zzr();
                if (!TextUtils.isEmpty(zzy)) {
                    zzu.zzV(zzy);
                } else if (!TextUtils.isEmpty(zzr2)) {
                    zzu.zzC(zzr2);
                }
                zzah zzh = zzr.zzf.zzh(str3);
                zzu.zzN(zzj.zzj());
                if (zzr.zzs.zzJ() && zzr.zzs.zzf().zzt(zzu.zzaq()) && zzh.zzi(zzag.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzu.zzP((String) null);
                }
                zzu.zzM(zzh.zzh());
                if (zzh.zzi(zzag.AD_STORAGE)) {
                    Pair zzd = zzr.zzf.zzs().zzd(zzj.zzt(), zzh);
                    if (zzj.zzai() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzu.zzaf(zzis.zza((String) zzd.first, Long.toString(zzav.zzd)));
                            if (zzd.second != null) {
                                zzu.zzY(((Boolean) zzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzr.zzs.zzaz().zzc().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzli = zzr.zzf;
                        } catch (Throwable th) {
                            zzr.zzf.zzi().zzx();
                            throw th;
                        }
                    }
                }
                zzr.zzs.zzg().zzu();
                zzu.zzO(Build.MODEL);
                zzr.zzs.zzg().zzu();
                zzu.zzZ(Build.VERSION.RELEASE);
                zzu.zzak((int) zzr.zzs.zzg().zzb());
                zzu.zzao(zzr.zzs.zzg().zzc());
                try {
                    if (zzh.zzi(zzag.ANALYTICS_STORAGE) && zzj.zzu() != null) {
                        zzu.zzF(zzis.zza((String) Preconditions.checkNotNull(zzj.zzu()), Long.toString(zzav.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzj.zzx())) {
                        zzu.zzU((String) Preconditions.checkNotNull(zzj.zzx()));
                    }
                    String zzt = zzj.zzt();
                    List zzu2 = zzr.zzf.zzi().zzu(zzt);
                    Iterator it = zzu2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzln = null;
                            break;
                        }
                        zzln = (zzln) it.next();
                        if ("_lte".equals(zzln.zzc)) {
                            break;
                        }
                    }
                    if (zzln == null || zzln.zze == null) {
                        zzln zzln2 = new zzln(zzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzr.zzs.zzaw().currentTimeMillis(), 0L);
                        zzu2.add(zzln2);
                        zzr.zzf.zzi().zzL(zzln2);
                    }
                    zzlk zzu3 = zzr.zzf.zzu();
                    zzu3.zzs.zzaz().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu3.zzs.zzg().zze()) {
                        String zzt2 = zzj.zzt();
                        Preconditions.checkNotNull(zzt2);
                        if (zzj.zzai() && zzu3.zzf.zzo().zzn(zzt2)) {
                            zzu3.zzs.zzaz().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it2 = zzu2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((zzln) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zzu2.add(new zzln(zzt2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzu3.zzs.zzaw().currentTimeMillis(), 1L));
                        }
                    }
                    zzgl[] zzglArr = new zzgl[zzu2.size()];
                    for (int i = 0; i < zzu2.size(); i++) {
                        zzgk zzd2 = zzgl.zzd();
                        zzd2.zzf(((zzln) zzu2.get(i)).zzc);
                        zzd2.zzg(((zzln) zzu2.get(i)).zzd);
                        zzr.zzf.zzu().zzu(zzd2, ((zzln) zzu2.get(i)).zze);
                        zzglArr[i] = (zzgl) zzd2.zzaE();
                    }
                    zzu.zzj(Arrays.asList(zzglArr));
                    zzez zzb2 = zzez.zzb(zzav);
                    zzr.zzs.zzv().zzL(zzb2.zzd, zzr.zzf.zzi().zzi(str3));
                    zzr.zzs.zzv().zzM(zzb2, zzr.zzs.zzf().zzd(str3));
                    Bundle bundle2 = zzb2.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzs.zzaz().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong(RavenEvent.DefaultEvent.REQUEST, 1);
                    bundle2.putString("_o", zzav.zzc);
                    if (zzr.zzs.zzv().zzae(zzu.zzaq())) {
                        zzr.zzs.zzv().zzO(bundle2, "_dbg", 1L);
                        zzr.zzs.zzv().zzO(bundle2, RavenEvent.DefaultEvent.REQUEST, 1L);
                    }
                    zzar zzn = zzr.zzf.zzi().zzn(str3, zzav.zza);
                    if (zzn == null) {
                        zzgb = zzu;
                        zzg = zzj;
                        zzfz = zza2;
                        str = str3;
                        bundle = bundle2;
                        str2 = null;
                        zzar = new zzar(str3, zzav.zza, 0, 0, 0, zzav.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zzg = zzj;
                        zzfz = zza2;
                        str = str3;
                        bundle = bundle2;
                        zzgb = zzu;
                        str2 = null;
                        long j2 = zzn.zzf;
                        zzar = zzn.zzc(zzav.zzd);
                        j = j2;
                    }
                    zzr.zzf.zzi().zzE(zzar);
                    zzaq zzaq = new zzaq(zzr.zzs, zzav.zzc, str, zzav.zza, zzav.zzd, j, bundle);
                    zzfr zze = zzfs.zze();
                    zze.zzm(zzaq.zzd);
                    zze.zzi(zzaq.zzb);
                    zze.zzl(zzaq.zze);
                    zzas zzas = new zzas(zzaq.zzf);
                    while (zzas.hasNext()) {
                        String zza3 = zzas.next();
                        zzfv zze2 = zzfw.zze();
                        zze2.zzj(zza3);
                        Object zzf = zzaq.zzf.zzf(zza3);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzt(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzgb zzgb2 = zzgb;
                    zzgb2.zzk(zze);
                    zzgd zza4 = zzgf.zza();
                    zzft zza5 = zzfu.zza();
                    zza5.zza(zzar.zzc);
                    zza5.zzb(zzav.zza);
                    zza4.zza(zza5);
                    zzgb2.zzab(zza4);
                    zzgb2.zzf(zzr.zzf.zzf().zza(zzg.zzt(), Collections.emptyList(), zzgb2.zzat(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgb2.zzaj(zze.zzc());
                        zzgb2.zzR(zze.zzc());
                    }
                    long zzn2 = zzg.zzn();
                    int i2 = (zzn2 > 0 ? 1 : (zzn2 == 0 ? 0 : -1));
                    if (i2 != 0) {
                        zzgb2.zzac(zzn2);
                    }
                    long zzp = zzg.zzp();
                    if (zzp != 0) {
                        zzgb2.zzad(zzp);
                    } else if (i2 != 0) {
                        zzgb2.zzad(zzn2);
                    }
                    String zzB = zzg.zzB();
                    zzpp.zzc();
                    if (zzr.zzs.zzf().zzs(str2, zzel.zzaH) && zzB != null) {
                        zzgb2.zzai(zzB);
                    }
                    zzg.zzE();
                    zzgb2.zzJ((int) zzg.zzo());
                    zzr.zzs.zzf().zzh();
                    zzgb2.zzam(61000);
                    zzgb2.zzal(zzr.zzs.zzaw().currentTimeMillis());
                    zzgb2.zzah(Boolean.TRUE.booleanValue());
                    zzfz zzfz2 = zzfz;
                    zzfz2.zza(zzgb2);
                    zzg zzg2 = zzg;
                    zzg2.zzac(zzgb2.zzd());
                    zzg2.zzaa(zzgb2.zzc());
                    zzr.zzf.zzi().zzD(zzg2);
                    zzr.zzf.zzi().zzC();
                    zzr.zzf.zzi().zzx();
                    try {
                        return zzr.zzf.zzu().zzy(((zzga) zzfz2.zzaE()).zzby());
                    } catch (IOException e2) {
                        zzr.zzs.zzaz().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzey.zzn(str), e2);
                        return str2;
                    }
                } catch (SecurityException e3) {
                    zzr.zzs.zzaz().zzc().zzb("app instance id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzli = zzr.zzf;
                }
            }
            zzli.zzi().zzx();
            return bArr;
        } else {
            zzr.zzs.zzaz().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzav.zza);
            return null;
        }
    }
}
