package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjb extends zzf {
    protected zziu zza;
    private volatile zziu zzb;
    private volatile zziu zzc;
    private final Map zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zziu zzg;
    /* access modifiers changed from: private */
    public zziu zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private zziu zzk;
    private String zzl;

    public zzjb(zzgi zzgi) {
        super(zzgi);
    }

    private final void zzA(Activity activity, zziu zziu, boolean z) {
        zziu zziu2;
        zziu zziu3;
        zziu zziu4 = zziu;
        if (this.zzb == null) {
            zziu2 = this.zzc;
        } else {
            zziu2 = this.zzb;
        }
        zziu zziu5 = zziu2;
        if (zziu4.zzb == null) {
            zziu3 = new zziu(zziu4.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zziu4.zzc, zziu4.zze, zziu4.zzf);
        } else {
            zziu3 = zziu4;
        }
        this.zzc = this.zzb;
        this.zzb = zziu3;
        this.zzs.zzaA().zzp(new zziw(this, zziu3, zziu5, this.zzs.zzaw().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    public final void zzB(zziu zziu, zziu zziu2, long j, boolean z, Bundle bundle) {
        long j2;
        long j3;
        zziu zziu3 = zziu;
        zziu zziu4 = zziu2;
        long j4 = j;
        Bundle bundle2 = bundle;
        zzg();
        boolean z2 = false;
        boolean z3 = zziu4 == null || zziu4.zzc != zziu3.zzc || !zzlp.zzal(zziu4.zzb, zziu3.zzb) || !zzlp.zzal(zziu4.zza, zziu3.zza);
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle2) : new Bundle();
            zzlp.zzK(zziu3, bundle3, true);
            if (zziu4 != null) {
                String str = zziu4.zza;
                if (str != null) {
                    bundle3.putString("_pn", str);
                }
                String str2 = zziu4.zzb;
                if (str2 != null) {
                    bundle3.putString("_pc", str2);
                }
                bundle3.putLong("_pi", zziu4.zzc);
            }
            if (z2) {
                zzkp zzkp = this.zzs.zzu().zzb;
                long j5 = j4 - zzkp.zzb;
                zzkp.zzb = j4;
                if (j5 > 0) {
                    this.zzs.zzv().zzI(bundle3, j5);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle3.putLong("_mst", 1);
            }
            String str3 = true != zziu3.zze ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "app";
            long currentTimeMillis = this.zzs.zzaw().currentTimeMillis();
            if (zziu3.zze) {
                j3 = currentTimeMillis;
                long j6 = zziu3.zzf;
                if (j6 != 0) {
                    j2 = j6;
                    this.zzs.zzq().zzI(str3, "_vs", j2, bundle3);
                }
            } else {
                j3 = currentTimeMillis;
            }
            j2 = j3;
            this.zzs.zzq().zzI(str3, "_vs", j2, bundle3);
        }
        if (z2) {
            zzC(this.zza, true, j4);
        }
        this.zza = zziu3;
        if (zziu3.zze) {
            this.zzh = zziu3;
        }
        this.zzs.zzt().zzG(zziu3);
    }

    /* access modifiers changed from: private */
    public final void zzC(zziu zziu, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzaw().elapsedRealtime());
        if (this.zzs.zzu().zzb.zzd(zziu != null && zziu.zzd, z, j) && zziu != null) {
            zziu.zzd = false;
        }
    }

    static /* synthetic */ void zzp(zzjb zzjb, Bundle bundle, zziu zziu, zziu zziu2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzjb.zzB(zziu, zziu2, j, true, zzjb.zzs.zzv().zzy((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List) null, false));
    }

    private final zziu zzz(Activity activity) {
        Preconditions.checkNotNull(activity);
        zziu zziu = (zziu) this.zzd.get(activity);
        if (zziu == null) {
            zziu zziu2 = new zziu((String) null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zziu2);
            zziu = zziu2;
        }
        return this.zzg != null ? this.zzg : zziu;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final zziu zzi() {
        return this.zzb;
    }

    public final zziu zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zziu zziu = this.zza;
        return zziu != null ? zziu : this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzs.zzf();
        return str2.substring(0, 100);
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.zzs.zzf().zzu() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zziu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = this.zzs.zzaw().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaA().zzp(new zziy(this, elapsedRealtime));
            return;
        }
        zziu zzz = zzz(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        this.zzs.zzaA().zzp(new zziz(this, zzz, elapsedRealtime));
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaA().zzp(new zzja(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaA().zzp(new zzix(this));
            return;
        }
        zzA(activity, zzz(activity), false);
        zzd zzd2 = this.zzs.zzd();
        zzd2.zzs.zzaA().zzp(new zzc(zzd2, zzd2.zzs.zzaw().elapsedRealtime()));
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zziu zziu;
        if (this.zzs.zzf().zzu() && bundle != null && (zziu = (zziu) this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zziu.zzc);
            bundle2.putString("name", zziu.zza);
            bundle2.putString("referrer_name", zziu.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r5.length() <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r6.length() <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.zziu r0 = r3.zzb
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L_0x0030:
            java.util.Map r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzl(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzlp.zzal(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzlp.zzal(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            com.google.android.gms.measurement.internal.zzgi r1 = r3.zzs
            r1.zzf()
            int r1 = r5.length()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.zzgi r1 = r3.zzs
            r1.zzf()
            int r1 = r6.length()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zziu r0 = new com.google.android.gms.measurement.internal.zziu
            com.google.android.gms.measurement.internal.zzgi r1 = r3.zzs
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            long r1 = r1.zzq()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzA(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjb.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r2 > 100) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r4 > 100) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        r0 = r12.zzs.zzaz().zzj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        if (r3 != null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        if (r4 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r0.zzc("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.zzb != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e3, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r2 = new com.google.android.gms.measurement.internal.zziu(r3, r4, r12.zzs.zzv().zzq(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        r12.zzs.zzaA().zzp(new com.google.android.gms.measurement.internal.zziv(r12, r13, r2, r0, r12.zzs.zzaw().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x011b }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.measurement.internal.zzgi r13 = r12.zzs     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzey r13 = r13.zzaz()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x0018:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x011b }
            r1 = 100
            if (r3 == 0) goto L_0x004c
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            if (r2 <= 0) goto L_0x0033
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgi r4 = r12.zzs     // Catch:{ all -> 0x011b }
            r4.zzf()     // Catch:{ all -> 0x011b }
            if (r2 <= r1) goto L_0x004c
        L_0x0033:
            com.google.android.gms.measurement.internal.zzgi r13 = r12.zzs     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzey r13 = r13.zzaz()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x004c:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x007e
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            if (r4 <= 0) goto L_0x0065
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgi r5 = r12.zzs     // Catch:{ all -> 0x011b }
            r5.zzf()     // Catch:{ all -> 0x011b }
            if (r4 <= r1) goto L_0x007e
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgi r13 = r12.zzs     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzey r13 = r13.zzaz()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x007e:
            if (r2 != 0) goto L_0x0093
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x008f
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zzl(r1, r2)     // Catch:{ all -> 0x011b }
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = "Activity"
        L_0x0091:
            r4 = r1
            goto L_0x0094
        L_0x0093:
            r4 = r2
        L_0x0094:
            com.google.android.gms.measurement.internal.zziu r1 = r12.zzb     // Catch:{ all -> 0x011b }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x011b }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x011b }
            boolean r2 = com.google.android.gms.measurement.internal.zzlp.zzal(r2, r4)     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x011b }
            boolean r1 = com.google.android.gms.measurement.internal.zzlp.zzal(r1, r3)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.zzgi r13 = r12.zzs     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzey r13 = r13.zzaz()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgi r0 = r12.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj()
            if (r3 != 0) goto L_0x00d0
            java.lang.String r1 = "null"
            goto L_0x00d1
        L_0x00d0:
            r1 = r3
        L_0x00d1:
            if (r4 != 0) goto L_0x00d6
            java.lang.String r2 = "null"
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.zzc(r5, r1, r2)
            com.google.android.gms.measurement.internal.zziu r0 = r12.zzb
            if (r0 != 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.zziu r0 = r12.zzc
            goto L_0x00e5
        L_0x00e3:
            com.google.android.gms.measurement.internal.zziu r0 = r12.zzb
        L_0x00e5:
            com.google.android.gms.measurement.internal.zziu r1 = new com.google.android.gms.measurement.internal.zziu
            com.google.android.gms.measurement.internal.zzgi r2 = r12.zzs
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            long r5 = r2.zzq()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.measurement.internal.zzgi r14 = r12.zzs
            com.google.android.gms.common.util.Clock r14 = r14.zzaw()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzgi r14 = r12.zzs
            com.google.android.gms.measurement.internal.zzgf r14 = r14.zzaA()
            com.google.android.gms.measurement.internal.zziv r15 = new com.google.android.gms.measurement.internal.zziv
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzp(r15)
            return
        L_0x011b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjb.zzx(android.os.Bundle, long):void");
    }

    public final void zzy(String str, zziu zziu) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zziu != null) {
                this.zzl = str;
                this.zzk = zziu;
            }
        }
    }
}
