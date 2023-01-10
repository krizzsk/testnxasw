package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzga;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzee {
    private static volatile zzee zzc;
    protected final Clock zza;
    protected final ExecutorService zzb;
    /* access modifiers changed from: private */
    public final String zzd;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzh;
    private final String zzi;
    /* access modifiers changed from: private */
    public volatile zzcc zzj;

    protected zzee(Context context, String str, String str2, String str3, Bundle bundle) {
        String str4 = str;
        String str5 = str2;
        if (str4 == null || !zzV(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str4;
        }
        this.zza = DefaultClock.getInstance();
        zzbx.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzdi(this));
        boolean z = true;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            try {
                if (zzit.zzc(context, "google_app_id", zzga.zza(context)) != null && !zzR()) {
                    this.zzi = null;
                    this.zzh = true;
                    SystemUtils.log(5, this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.", (Throwable) null, "com.google.android.gms.internal.measurement.zzee", 18);
                    return;
                }
            } catch (IllegalStateException unused) {
            }
        } catch (IllegalStateException unused2) {
            Context context2 = context;
        }
        if (!zzV(str2, str3)) {
            this.zzi = "fa";
            if (str5 == null || str3 == null) {
                if ((str5 == null) ^ (str3 != null ? false : z)) {
                    SystemUtils.log(5, this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.", (Throwable) null, "com.google.android.gms.internal.measurement.zzee", 12);
                }
            } else {
                SystemUtils.log(2, this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy", (Throwable) null, "com.google.android.gms.internal.measurement.zzee", 13);
            }
        } else {
            this.zzi = str5;
        }
        zzU(new zzcx(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            SystemUtils.log(5, this.zzd, "Unable to register lifecycle notifications. Application null.", (Throwable) null, "com.google.android.gms.internal.measurement.zzee", 16);
        } else {
            application.registerActivityLifecycleCallbacks(new zzed(this));
        }
    }

    protected static final boolean zzR() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzS(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            SystemUtils.log(5, this.zzd, "Data collection startup failed. No data will be collected.", exc, "com.google.android.gms.internal.measurement.zzee", 1);
            return;
        }
        if (z2) {
            zzA(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        SystemUtils.log(5, this.zzd, "Error with data collection. Data lost.", exc, "com.google.android.gms.internal.measurement.zzee", 3);
    }

    private final void zzT(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzU(new zzdr(this, l, str, str2, bundle, z, z2));
    }

    /* access modifiers changed from: private */
    public final void zzU(zzdt zzdt) {
        this.zzb.execute(zzdt);
    }

    /* access modifiers changed from: private */
    public static final boolean zzV(String str, String str2) {
        return (str2 == null || str == null || zzR()) ? false : true;
    }

    public static zzee zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzee.class) {
                if (zzc == null) {
                    zzc = new zzee(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final void zzA(int i, String str, Object obj, Object obj2, Object obj3) {
        zzU(new zzdg(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r9.zzj == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        com.didi.sdk.apm.SystemUtils.log(5, r9.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.", (java.lang.Throwable) null, "com.google.android.gms.internal.measurement.zzee", 9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdp(r9, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(com.google.android.gms.measurement.internal.zzhj r10) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            java.util.List r0 = r9.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r9.zzf     // Catch:{ all -> 0x0061 }
            int r2 = r2.size()     // Catch:{ all -> 0x0061 }
            if (r1 >= r2) goto L_0x0031
            java.util.List r2 = r9.zzf     // Catch:{ all -> 0x0061 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0061 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0061 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0061 }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x002e
            java.lang.String r4 = r9.zzd     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "OnEventListener already registered."
            r3 = 5
            r6 = 0
            java.lang.String r7 = "com.google.android.gms.internal.measurement.zzee"
            r8 = 11
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return
        L_0x002e:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0031:
            com.google.android.gms.internal.measurement.zzdv r1 = new com.google.android.gms.internal.measurement.zzdv     // Catch:{ all -> 0x0061 }
            r1.<init>(r10)     // Catch:{ all -> 0x0061 }
            java.util.List r2 = r9.zzf     // Catch:{ all -> 0x0061 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0061 }
            r3.<init>(r10, r1)     // Catch:{ all -> 0x0061 }
            r2.add(r3)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.measurement.zzcc r10 = r9.zzj
            if (r10 == 0) goto L_0x0058
            com.google.android.gms.internal.measurement.zzcc r10 = r9.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            r10.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            return
        L_0x004b:
            java.lang.String r3 = r9.zzd
            java.lang.String r4 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.google.android.gms.internal.measurement.zzee"
            r7 = 9
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0058:
            com.google.android.gms.internal.measurement.zzdp r10 = new com.google.android.gms.internal.measurement.zzdp
            r10.<init>(r9, r1)
            r9.zzU(r10)
            return
        L_0x0061:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzB(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final void zzC() {
        zzU(new zzcv(this));
    }

    public final void zzD(Bundle bundle) {
        zzU(new zzcn(this, bundle));
    }

    public final void zzE(Bundle bundle) {
        zzU(new zzct(this, bundle));
    }

    public final void zzF(Bundle bundle) {
        zzU(new zzcu(this, bundle));
    }

    public final void zzG(Activity activity, String str, String str2) {
        zzU(new zzcr(this, activity, str, str2));
    }

    public final void zzH(boolean z) {
        zzU(new zzdm(this, z));
    }

    public final void zzI(Bundle bundle) {
        zzU(new zzdn(this, bundle));
    }

    public final void zzJ(zzhi zzhi) {
        zzdu zzdu = new zzdu(zzhi);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzdu);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                SystemUtils.log(5, this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.", (Throwable) null, "com.google.android.gms.internal.measurement.zzee", 3);
            }
        }
        zzU(new zzdo(this, zzdu));
    }

    public final void zzK(Boolean bool) {
        zzU(new zzcs(this, bool));
    }

    public final void zzL(long j) {
        zzU(new zzcw(this, j));
    }

    public final void zzM(String str) {
        zzU(new zzcq(this, str));
    }

    public final void zzN(String str, String str2, Object obj, boolean z) {
        zzU(new zzds(this, str, str2, obj, z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r7.zzj == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r7.zzj.unregisterOnMeasurementEventListener(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        com.didi.sdk.apm.SystemUtils.log(5, r7.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.", (java.lang.Throwable) null, "com.google.android.gms.internal.measurement.zzee", 12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdq(r7, r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.measurement.internal.zzhj r8) {
        /*
            r7 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.util.List r0 = r7.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r7.zzf     // Catch:{ all -> 0x0066 }
            int r2 = r2.size()     // Catch:{ all -> 0x0066 }
            if (r1 >= r2) goto L_0x002b
            java.util.List r2 = r7.zzf     // Catch:{ all -> 0x0066 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0066 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0066 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0066 }
            boolean r2 = r8.equals(r2)     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0028
            java.util.List r8 = r7.zzf     // Catch:{ all -> 0x0066 }
            java.lang.Object r8 = r8.get(r1)     // Catch:{ all -> 0x0066 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0066 }
            goto L_0x002c
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            r8 = 0
        L_0x002c:
            if (r8 != 0) goto L_0x003c
            java.lang.String r2 = r7.zzd     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = "OnEventListener had not been registered."
            r1 = 5
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.internal.measurement.zzee"
            r6 = 6
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0066 }
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x003c:
            java.util.List r1 = r7.zzf     // Catch:{ all -> 0x0066 }
            r1.remove(r8)     // Catch:{ all -> 0x0066 }
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.measurement.zzdv r8 = (com.google.android.gms.internal.measurement.zzdv) r8     // Catch:{ all -> 0x0066 }
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.measurement.zzcc r0 = r7.zzj
            if (r0 == 0) goto L_0x005d
            com.google.android.gms.internal.measurement.zzcc r0 = r7.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0050 }
            r0.unregisterOnMeasurementEventListener(r8)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0050 }
            return
        L_0x0050:
            java.lang.String r2 = r7.zzd
            java.lang.String r3 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            r1 = 5
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.internal.measurement.zzee"
            r6 = 12
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x005d:
            com.google.android.gms.internal.measurement.zzdq r0 = new com.google.android.gms.internal.measurement.zzdq
            r0.<init>(r7, r8)
            r7.zzU(r0)
            return
        L_0x0066:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzO(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final int zza(String str) {
        zzbz zzbz = new zzbz();
        zzU(new zzdj(this, str, zzbz));
        Integer num = (Integer) zzbz.zze(zzbz.zzb(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzbz zzbz = new zzbz();
        zzU(new zzdc(this, zzbz));
        Long l = (Long) zzbz.zze(zzbz.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final Bundle zzc(Bundle bundle, boolean z) {
        zzbz zzbz = new zzbz();
        zzU(new zzdh(this, bundle, zzbz));
        if (z) {
            return zzbz.zzb(5000);
        }
        return null;
    }

    public final AppMeasurementSdk zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzcc zzf(Context context, boolean z) {
        try {
            return zzcb.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zzS(e, true, false);
            return null;
        }
    }

    public final Object zzh(int i) {
        zzbz zzbz = new zzbz();
        zzU(new zzdl(this, zzbz, i));
        return zzbz.zze(zzbz.zzb(15000), Object.class);
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        zzbz zzbz = new zzbz();
        zzU(new zzdk(this, zzbz));
        return zzbz.zzc(120000);
    }

    public final String zzl() {
        zzbz zzbz = new zzbz();
        zzU(new zzdb(this, zzbz));
        return zzbz.zzc(50);
    }

    public final String zzm() {
        zzbz zzbz = new zzbz();
        zzU(new zzde(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzn() {
        zzbz zzbz = new zzbz();
        zzU(new zzdd(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzo() {
        zzbz zzbz = new zzbz();
        zzU(new zzda(this, zzbz));
        return zzbz.zzc(500);
    }

    public final List zzp(String str, String str2) {
        zzbz zzbz = new zzbz();
        zzU(new zzcp(this, str, str2, zzbz));
        List list = (List) zzbz.zze(zzbz.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map zzq(String str, String str2, boolean z) {
        zzbz zzbz = new zzbz();
        zzU(new zzdf(this, str, str2, z, zzbz));
        Bundle zzb2 = zzbz.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzu(String str) {
        zzU(new zzcy(this, str));
    }

    public final void zzv(String str, String str2, Bundle bundle) {
        zzU(new zzco(this, str, str2, bundle));
    }

    public final void zzw(String str) {
        zzU(new zzcz(this, str));
    }

    public final void zzx(String str, Bundle bundle) {
        zzT((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzy(String str, String str2, Bundle bundle) {
        zzT(str, str2, bundle, true, true, (Long) null);
    }

    public final void zzz(String str, String str2, Bundle bundle, long j) {
        zzT(str, str2, bundle, true, false, Long.valueOf(j));
    }
}
