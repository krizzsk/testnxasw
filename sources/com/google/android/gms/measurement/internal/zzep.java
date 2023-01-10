package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzof;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzep extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    zzep(zzgi zzgi, long j) {
        super(zzgi);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018c A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0195 A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01bd A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x024d  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            android.content.Context r0 = r0.zzav()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzgi r1 = r11.zzs
            android.content.Context r1 = r1.zzav()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r4 = ""
            r5 = 0
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zzb(r9, r8)
        L_0x0033:
            r8 = r2
            goto L_0x009c
        L_0x0036:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003b }
            goto L_0x004e
        L_0x003b:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzb(r9, r8)
        L_0x004e:
            if (r6 != 0) goto L_0x0053
            java.lang.String r6 = "manual_install"
            goto L_0x005c
        L_0x0053:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x005c
            r6 = r4
        L_0x005c:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs     // Catch:{ NameNotFoundException -> 0x0086 }
            android.content.Context r7 = r7.zzav()     // Catch:{ NameNotFoundException -> 0x0086 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0086 }
            android.content.pm.PackageInfo r7 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r1, r7, r5)     // Catch:{ NameNotFoundException -> 0x0086 }
            if (r7 == 0) goto L_0x0033
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0086 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0086 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0086 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0086 }
            goto L_0x007e
        L_0x007d:
            r8 = r2
        L_0x007e:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0083 }
            int r3 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0083 }
            goto L_0x009c
        L_0x0083:
            r7 = r2
            r2 = r8
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            com.google.android.gms.measurement.internal.zzgi r8 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzd()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x009c:
            r11.zza = r0
            r11.zzd = r6
            r11.zzb = r2
            r11.zzc = r3
            r11.zze = r8
            r2 = 0
            r11.zzf = r2
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs
            java.lang.String r2 = r2.zzw()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            if (r2 != 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs
            java.lang.String r2 = r2.zzx()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c7
            r2 = 1
            goto L_0x00c8
        L_0x00c7:
            r2 = 0
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzgi r6 = r11.zzs
            int r6 = r6.zza()
            switch(r6) {
                case 0: goto L_0x0152;
                case 1: goto L_0x0142;
                case 2: goto L_0x0132;
                case 3: goto L_0x0122;
                case 4: goto L_0x0112;
                case 5: goto L_0x0102;
                case 6: goto L_0x00f2;
                case 7: goto L_0x00e2;
                default: goto L_0x00d1;
            }
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0161
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0161
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzl()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0161
        L_0x0102:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0161
        L_0x0112:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0161
        L_0x0122:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0161
        L_0x0132:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0161
        L_0x0142:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0161
        L_0x0152:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0161:
            r11.zzk = r4
            r11.zzl = r4
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            r7.zzax()
            if (r2 == 0) goto L_0x0174
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs
            java.lang.String r2 = r2.zzw()
            r11.zzl = r2
        L_0x0174:
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.Context r2 = r2.zzav()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r7 = r7.zzz()     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r8 = "google_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzit.zzc(r2, r8, r7)     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r3 == r7) goto L_0x018d
            r4 = r2
        L_0x018d:
            r11.zzk = r4     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r2 != 0) goto L_0x01bb
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.Context r2 = r2.zzav()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzgi r3 = r11.zzs     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r3 = r3.zzz()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.res.Resources r4 = r2.getResources()     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r7 != 0) goto L_0x01af
            goto L_0x01b3
        L_0x01af:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzga.zza(r2)     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01b3:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzga.zzb(r2, r4, r3)     // Catch:{ IllegalStateException -> 0x01dc }
            r11.zzl = r2     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01bb:
            if (r6 != 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzgi r2 = r11.zzs     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r4 = r11.zza     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r6 == 0) goto L_0x01d6
            java.lang.String r6 = r11.zzl     // Catch:{ IllegalStateException -> 0x01dc }
            goto L_0x01d8
        L_0x01d6:
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01d8:
            r2.zzc(r3, r4, r6)     // Catch:{ IllegalStateException -> 0x01dc }
            goto L_0x01f0
        L_0x01dc:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r4 = "Fetching Google App Id failed with exception. appId"
            r3.zzc(r4, r0, r2)
        L_0x01f0:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            r0.zzax()
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzp(r2)
            if (r0 != 0) goto L_0x0207
            goto L_0x023c
        L_0x0207:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x021d
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x023e
        L_0x021d:
            java.util.Iterator r2 = r0.iterator()
        L_0x0221:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x023c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzgi r4 = r11.zzs
            com.google.android.gms.measurement.internal.zzlp r4 = r4.zzv()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r4.zzab(r6, r3)
            if (r3 != 0) goto L_0x0221
            goto L_0x023e
        L_0x023c:
            r11.zzh = r0
        L_0x023e:
            if (r1 == 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            android.content.Context r0 = r0.zzav()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x024d:
            r11.zzj = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zzd():void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzh() {
        zza();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0272  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzp zzj(java.lang.String r37) {
        /*
            r36 = this;
            r1 = r36
            r36.zzg()
            com.google.android.gms.measurement.internal.zzp r33 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r3 = r36.zzl()
            java.lang.String r4 = r36.zzm()
            r36.zza()
            java.lang.String r5 = r1.zzb
            r36.zza()
            int r0 = r1.zzc
            long r6 = (long) r0
            r36.zza()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            r0.zzh()
            r36.zza()
            r36.zzg()
            long r9 = r1.zzf
            r2 = 0
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzlp r9 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            android.content.Context r0 = r0.zzav()
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzs
            android.content.Context r10 = r10.zzav()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzlp.zzF()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00d2
        L_0x0078:
            if (r13 == 0) goto L_0x00d1
            boolean r10 = r9.zzag(r0, r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 != 0) goto L_0x00bf
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzgi r10 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.Context r10 = r10.zzav()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00c1 }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 == 0) goto L_0x00af
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            int r10 = r10.length     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 <= 0) goto L_0x00af
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            long r9 = com.google.android.gms.measurement.internal.zzlp.zzp(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            r15 = r9
            goto L_0x0076
        L_0x00af:
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzk()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            goto L_0x0076
        L_0x00bf:
            r15 = r11
            goto L_0x0076
        L_0x00c1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r9 = r9.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzd()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00d1:
            r9 = r11
        L_0x00d2:
            r1.zzf = r9
        L_0x00d4:
            r13 = r9
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            boolean r0 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfn r9 = r9.zzm()
            boolean r9 = r9.zzk
            r10 = 1
            r15 = r9 ^ 1
            r36.zzg()
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            boolean r9 = r9.zzJ()
            r11 = 0
            if (r9 != 0) goto L_0x00f6
        L_0x00f2:
            r20 = r11
            goto L_0x017c
        L_0x00f6:
            com.google.android.gms.internal.measurement.zzpv.zzc()
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r9 = r9.zzf()
            com.google.android.gms.measurement.internal.zzek r12 = com.google.android.gms.measurement.internal.zzel.zzab
            boolean r9 = r9.zzs(r11, r12)
            if (r9 == 0) goto L_0x0117
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzj()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00f2
        L_0x0117:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs     // Catch:{ ClassNotFoundException -> 0x017a }
            android.content.Context r9 = r9.zzav()     // Catch:{ ClassNotFoundException -> 0x017a }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x017a }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x017a }
            if (r9 != 0) goto L_0x012a
            goto L_0x00f2
        L_0x012a:
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x016b }
            java.lang.Class<android.content.Context> r18 = android.content.Context.class
            r12[r2] = r18     // Catch:{ Exception -> 0x016b }
            java.lang.String r11 = "getInstance"
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x016b }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzs     // Catch:{ Exception -> 0x016b }
            android.content.Context r10 = r10.zzav()     // Catch:{ Exception -> 0x016b }
            r12[r2] = r10     // Catch:{ Exception -> 0x016b }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x016b }
            if (r11 != 0) goto L_0x0148
            goto L_0x017a
        L_0x0148:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x015b }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x015b }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x015b }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x015b }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x015b }
            r20 = r9
            goto L_0x017c
        L_0x015b:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzl()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r10)
            goto L_0x017a
        L_0x016b:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzm()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r10)
        L_0x017a:
            r20 = 0
        L_0x017c:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfn r10 = r9.zzm()
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzc
            long r10 = r10.zza()
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0194
            long r9 = r9.zzc
            r12 = r3
            r22 = r9
            goto L_0x019d
        L_0x0194:
            r12 = r3
            long r2 = r9.zzc
            long r2 = java.lang.Math.min(r2, r10)
            r22 = r2
        L_0x019d:
            r36.zza()
            int r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzf()
            boolean r24 = r2.zzr()
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfn r2 = r2.zzm()
            r2.zzg()
            android.content.SharedPreferences r2 = r2.zza()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r25 = r2.getBoolean(r3, r9)
            r36.zza()
            java.lang.String r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzf()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzk(r9)
            if (r2 != 0) goto L_0x01d6
            r26 = 0
            goto L_0x01e2
        L_0x01d6:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r26 = r2
        L_0x01e2:
            long r9 = r1.zzg
            java.util.List r2 = r1.zzh
            r19 = r2
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfn r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzah r2 = r2.zzc()
            java.lang.String r30 = r2.zzh()
            java.lang.String r2 = r1.zzi
            if (r2 != 0) goto L_0x021f
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzf()
            r21 = r3
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzaN
            r27 = r9
            r9 = 0
            boolean r2 = r2.zzs(r9, r3)
            if (r2 == 0) goto L_0x021a
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            java.lang.String r2 = r2.zzC()
            r1.zzi = r2
            goto L_0x0223
        L_0x021a:
            java.lang.String r2 = ""
            r1.zzi = r2
            goto L_0x0223
        L_0x021f:
            r21 = r3
            r27 = r9
        L_0x0223:
            java.lang.String r3 = r1.zzi
            com.google.android.gms.internal.measurement.zzpp.zzc()
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzf()
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzaI
            r10 = 0
            boolean r2 = r2.zzs(r10, r9)
            if (r2 == 0) goto L_0x0272
            r36.zzg()
            long r9 = r1.zzn
            r16 = 0
            int r2 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r2 != 0) goto L_0x0245
            r16 = r3
            goto L_0x0266
        L_0x0245:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.common.util.Clock r2 = r2.zzaw()
            long r9 = r2.currentTimeMillis()
            r16 = r3
            long r2 = r1.zzn
            long r9 = r9 - r2
            java.lang.String r2 = r1.zzm
            if (r2 == 0) goto L_0x0266
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r17 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r17 <= 0) goto L_0x0266
            java.lang.String r2 = r1.zzo
            if (r2 != 0) goto L_0x0266
            r36.zzo()
        L_0x0266:
            java.lang.String r2 = r1.zzm
            if (r2 != 0) goto L_0x026d
            r36.zzo()
        L_0x026d:
            java.lang.String r2 = r1.zzm
            r32 = r2
            goto L_0x0276
        L_0x0272:
            r16 = r3
            r32 = r10
        L_0x0276:
            r9 = 61000(0xee48, double:3.0138E-319)
            r17 = 0
            r29 = 0
            r31 = r19
            r2 = r33
            r35 = r16
            r34 = r21
            r3 = r12
            r21 = r11
            r11 = r13
            r13 = r37
            r14 = r0
            r16 = r20
            r19 = r22
            r22 = r24
            r23 = r25
            r24 = r34
            r25 = r26
            r26 = r27
            r28 = r31
            r31 = r35
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzp");
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        zza();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzm() {
        zzof.zzc();
        if (this.zzs.zzf().zzs((String) null, zzel.zzal)) {
            zzg();
        }
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final List zzn() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        String str;
        zzg();
        if (!this.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
            this.zzs.zzaz().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzs.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzew zzc2 = this.zzs.zzaz().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzc2.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzs.zzaw().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
