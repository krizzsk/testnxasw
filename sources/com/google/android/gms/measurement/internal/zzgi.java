package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgi implements zzhd {
    private static volatile zzgi zzd;
    private zzep zzA;
    private boolean zzB = false;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    private final AtomicInteger zzH = new AtomicInteger(0);
    protected Boolean zza;
    protected Boolean zzb;
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzaa zzj;
    private final zzaf zzk;
    private final zzfn zzl;
    private final zzey zzm;
    private final zzgf zzn;
    private final zzkr zzo;
    private final zzlp zzp;
    private final zzet zzq;
    private final Clock zzr;
    private final zzjb zzs;
    private final zzin zzt;
    private final zzd zzu;
    private final zzir zzv;
    private final String zzw;
    private zzer zzx;
    private zzkb zzy;
    private zzap zzz;

    zzgi(zzhl zzhl) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzhl);
        Context context = zzhl.zza;
        zzaa zzaa = new zzaa(context);
        this.zzj = zzaa;
        zzei.zza = zzaa;
        this.zze = context;
        this.zzf = zzhl.zzb;
        this.zzg = zzhl.zzc;
        this.zzh = zzhl.zzd;
        this.zzi = zzhl.zzh;
        this.zzE = zzhl.zze;
        this.zzw = zzhl.zzj;
        this.zzF = true;
        zzcl zzcl = zzhl.zzg;
        if (!(zzcl == null || (bundle = zzcl.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzcl.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzhy.zze(this.zze);
        this.zzr = DefaultClock.getInstance();
        Long l = zzhl.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = this.zzr.currentTimeMillis();
        }
        this.zzc = j;
        this.zzk = new zzaf(this);
        zzfn zzfn = new zzfn(this);
        zzfn.zzv();
        this.zzl = zzfn;
        zzey zzey = new zzey(this);
        zzey.zzv();
        this.zzm = zzey;
        zzlp zzlp = new zzlp(this);
        zzlp.zzv();
        this.zzp = zzlp;
        this.zzq = new zzet(new zzhk(zzhl, this));
        this.zzu = new zzd(this);
        zzjb zzjb = new zzjb(this);
        zzjb.zzb();
        this.zzs = zzjb;
        zzin zzin = new zzin(this);
        zzin.zzb();
        this.zzt = zzin;
        zzkr zzkr = new zzkr(this);
        zzkr.zzb();
        this.zzo = zzkr;
        zzir zzir = new zzir(this);
        zzir.zzv();
        this.zzv = zzir;
        zzgf zzgf = new zzgf(this);
        zzgf.zzv();
        this.zzn = zzgf;
        zzcl zzcl2 = zzhl.zzg;
        z = (zzcl2 == null || zzcl2.zzb == 0) ? true : z;
        if (this.zze.getApplicationContext() instanceof Application) {
            zzin zzq2 = zzq();
            if (zzq2.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq2.zzs.zze.getApplicationContext();
                if (zzq2.zza == null) {
                    zzq2.zza = new zzim(zzq2, (zzil) null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzq2.zza);
                    application.registerActivityLifecycleCallbacks(zzq2.zza);
                    zzq2.zzs.zzaz().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzaz().zzk().zza("Application context is not an Application");
        }
        this.zzn.zzp(new zzgh(this, zzhl));
    }

    static /* synthetic */ void zzA(zzgi zzgi, zzhl zzhl) {
        zzgi.zzaA().zzg();
        zzgi.zzk.zzn();
        zzap zzap = new zzap(zzgi);
        zzap.zzv();
        zzgi.zzz = zzap;
        zzep zzep = new zzep(zzgi, zzhl.zzf);
        zzep.zzb();
        zzgi.zzA = zzep;
        zzer zzer = new zzer(zzgi);
        zzer.zzb();
        zzgi.zzx = zzer;
        zzkb zzkb = new zzkb(zzgi);
        zzkb.zzb();
        zzgi.zzy = zzkb;
        zzgi.zzp.zzw();
        zzgi.zzl.zzw();
        zzgi.zzA.zzc();
        zzew zzi2 = zzgi.zzaz().zzi();
        zzgi.zzk.zzh();
        zzi2.zzb("App measurement initialized, version", 61000L);
        zzgi.zzaz().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl2 = zzep.zzl();
        if (TextUtils.isEmpty(zzgi.zzf)) {
            if (zzgi.zzv().zzae(zzl2)) {
                zzgi.zzaz().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzgi.zzaz().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl2)));
            }
        }
        zzgi.zzaz().zzc().zza("Debug-level message logging enabled");
        if (zzgi.zzG != zzgi.zzH.get()) {
            zzgi.zzaz().zzd().zzc("Not all components initialized", Integer.valueOf(zzgi.zzG), Integer.valueOf(zzgi.zzH.get()));
        }
        zzgi.zzB = true;
    }

    static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzhb zzhb) {
        if (zzhb == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzQ(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zze()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzf2.getClass()))));
        }
    }

    private static final void zzR(zzhc zzhc) {
        if (zzhc == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzhc.zzx()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzhc.getClass()))));
        }
    }

    public static zzgi zzp(Context context, zzcl zzcl, Long l) {
        Bundle bundle;
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, (String) null, (String) null, zzcl.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzgi.class) {
                if (zzd == null) {
                    zzd = new zzgi(new zzhl(context, zzcl, l));
                }
            }
        } else if (!(zzcl == null || (bundle = zzcl.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(String str, int i, Throwable th, byte[] bArr, Map map) {
        if (!(i == 200 || i == 204)) {
            if (i == 304) {
                i = 304;
            }
            zzaz().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
        }
        if (th == null) {
            zzm().zzm.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzaz().zzc().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    zzaz().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlp zzv2 = zzv();
                zzgi zzgi = zzv2.zzs;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzv2.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzlp zzv3 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(zzv3.zzs.zze, "google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv3.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e) {
                                zzv3.zzs.zzaz().zzd().zzb("Failed to persist Deferred Deep Link. exception", e);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzaz().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e2) {
                zzaz().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzaz().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
    }

    /* access modifiers changed from: package-private */
    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaA().zzg();
        zzR(zzr());
        String zzl2 = zzh().zzl();
        Pair zzb2 = zzm().zzb(zzl2);
        if (!this.zzk.zzr() || ((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
            zzaz().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzir zzr2 = zzr();
        zzr2.zzu();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzr2.zzs.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzaz().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzlp zzv2 = zzv();
        zzh().zzs.zzk.zzh();
        URL zzE2 = zzv2.zzE(61000, zzl2, (String) zzb2.first, zzm().zzn.zza() - 1);
        if (zzE2 != null) {
            zzir zzr3 = zzr();
            zzgg zzgg = new zzgg(this);
            zzr3.zzg();
            zzr3.zzu();
            Preconditions.checkNotNull(zzE2);
            Preconditions.checkNotNull(zzgg);
            zzr3.zzs.zzaA().zzo(new zziq(zzr3, zzl2, zzE2, (byte[]) null, (Map) null, zzgg, (byte[]) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzF(boolean z) {
        this.zzE = Boolean.valueOf(z);
    }

    public final void zzG(boolean z) {
        zzaA().zzg();
        this.zzF = z;
    }

    /* access modifiers changed from: protected */
    public final void zzH(zzcl zzcl) {
        zzah zzah;
        zzaA().zzg();
        zzah zzc2 = zzm().zzc();
        zzfn zzm2 = zzm();
        zzgi zzgi = zzm2.zzs;
        zzm2.zzg();
        int i = 100;
        int i2 = zzm2.zza().getInt("consent_source", 100);
        zzaf zzaf = this.zzk;
        zzgi zzgi2 = zzaf.zzs;
        Boolean zzk2 = zzaf.zzk("google_analytics_default_allow_ad_storage");
        zzaf zzaf2 = this.zzk;
        zzgi zzgi3 = zzaf2.zzs;
        Boolean zzk3 = zzaf2.zzk("google_analytics_default_allow_analytics_storage");
        if (!(zzk2 == null && zzk3 == null) && zzm().zzl(-10)) {
            zzah = new zzah(zzk2, zzk3);
            i = -10;
        } else {
            if (!TextUtils.isEmpty(zzh().zzm()) && (i2 == 0 || i2 == 30 || i2 == 10 || i2 == 30 || i2 == 30 || i2 == 40)) {
                zzq().zzT(zzah.zza, -10, this.zzc);
            } else if (TextUtils.isEmpty(zzh().zzm()) && zzcl != null && zzcl.zzg != null && zzm().zzl(30)) {
                zzah = zzah.zza(zzcl.zzg);
                if (!zzah.equals(zzah.zza)) {
                    i = 30;
                }
            }
            zzah = null;
        }
        if (zzah != null) {
            zzq().zzT(zzah, i, this.zzc);
            zzc2 = zzah;
        }
        zzq().zzX(zzc2);
        if (zzm().zzc.zza() == 0) {
            zzaz().zzj().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzm().zzc.zzb(this.zzc);
        }
        zzq().zzb.zzc();
        if (zzM()) {
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                zzlp zzv2 = zzv();
                String zzm3 = zzh().zzm();
                zzfn zzm4 = zzm();
                zzm4.zzg();
                String string = zzm4.zza().getString("gmp_app_id", (String) null);
                String zzk4 = zzh().zzk();
                zzfn zzm5 = zzm();
                zzm5.zzg();
                if (zzv2.zzan(zzm3, string, zzk4, zzm5.zza().getString("admob_app_id", (String) null))) {
                    zzaz().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzfn zzm6 = zzm();
                    zzm6.zzg();
                    Boolean zzd2 = zzm6.zzd();
                    SharedPreferences.Editor edit = zzm6.zza().edit();
                    edit.clear();
                    edit.apply();
                    if (zzd2 != null) {
                        zzm6.zzh(zzd2);
                    }
                    zzi().zzj();
                    this.zzy.zzs();
                    this.zzy.zzr();
                    zzm().zzc.zzb(this.zzc);
                    zzm().zze.zzb((String) null);
                }
                zzfn zzm7 = zzm();
                String zzm8 = zzh().zzm();
                zzm7.zzg();
                SharedPreferences.Editor edit2 = zzm7.zza().edit();
                edit2.putString("gmp_app_id", zzm8);
                edit2.apply();
                zzfn zzm9 = zzm();
                String zzk5 = zzh().zzk();
                zzm9.zzg();
                SharedPreferences.Editor edit3 = zzm9.zza().edit();
                edit3.putString("admob_app_id", zzk5);
                edit3.apply();
            }
            if (!zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                zzm().zze.zzb((String) null);
            }
            zzq().zzP(zzm().zze.zza());
            zzoc.zzc();
            if (this.zzk.zzs((String) null, zzel.zzad)) {
                try {
                    zzv().zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzm().zzo.zza())) {
                        zzaz().zzk().zza("Remote config removed with active feature rollouts");
                        zzm().zzo.zzb((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                boolean zzJ = zzJ();
                if (!zzm().zzj() && !this.zzk.zzv()) {
                    zzm().zzi(!zzJ);
                }
                if (zzJ) {
                    zzq().zzz();
                }
                zzu().zza.zza();
                zzt().zzu(new AtomicReference());
                zzt().zzH(zzm().zzr.zza());
            }
        } else if (zzJ()) {
            if (!zzv().zzad("android.permission.INTERNET")) {
                zzaz().zzd().zza("App is missing INTERNET permission");
            }
            if (!zzv().zzad("android.permission.ACCESS_NETWORK_STATE")) {
                zzaz().zzd().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx()) {
                if (!zzlp.zzaj(this.zze)) {
                    zzaz().zzd().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzlp.zzak(this.zze, false)) {
                    zzaz().zzd().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzaz().zzd().zza("Uploading is not possible. App measurement disabled");
        }
        zzm().zzi.zza(true);
    }

    public final boolean zzI() {
        return this.zzE != null && this.zzE.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzaA().zzg();
        return this.zzF;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    /* access modifiers changed from: protected */
    public final boolean zzM() {
        if (this.zzB) {
            zzaA().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzv().zzad("android.permission.INTERNET") && zzv().zzad("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzlp.zzaj(this.zze) && zzlp.zzak(this.zze, false))));
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzX(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z = false;
                    }
                    this.zzC = Boolean.valueOf(z);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaA().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaA().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 == null) {
            zzaf zzaf = this.zzk;
            zzaa zzaa = zzaf.zzs.zzj;
            Boolean zzk2 = zzaf.zzk("firebase_analytics_collection_enabled");
            if (zzk2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzE == null || this.zzE.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzk2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzd2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final zzgf zzaA() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final Context zzav() {
        return this.zze;
    }

    @Pure
    public final Clock zzaw() {
        return this.zzr;
    }

    @Pure
    public final zzaa zzax() {
        return this.zzj;
    }

    @Pure
    public final zzey zzaz() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzd zzd() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzaf zzf() {
        return this.zzk;
    }

    @Pure
    public final zzap zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzep zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzer zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzet zzj() {
        return this.zzq;
    }

    public final zzey zzl() {
        zzey zzey = this.zzm;
        if (zzey == null || !zzey.zzx()) {
            return null;
        }
        return zzey;
    }

    @Pure
    public final zzfn zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final zzgf zzo() {
        return this.zzn;
    }

    @Pure
    public final zzin zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzir zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzjb zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzkb zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzkr zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzlp zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzg;
    }

    @Pure
    public final String zzy() {
        return this.zzh;
    }

    @Pure
    public final String zzz() {
        return this.zzw;
    }
}
