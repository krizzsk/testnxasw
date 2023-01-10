package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaqe {
    private static final String zzd = zzaqe.class.getSimpleName();
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzapk zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzana zzm;
    private Future zzn;
    private zzaoz zzo;
    private final Map zzp;
    private boolean zzq;
    private zzapx zzr;

    private zzaqe(Context context) {
        boolean z = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzq = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z;
        this.zza = applicationContext != null ? applicationContext : context;
        this.zzp = new HashMap();
        if (this.zzr == null) {
            this.zzr = new zzapx(this.zza);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|(3:27|28|(17:30|(2:32|33)|34|35|36|37|(2:39|(1:41)(2:42|43))|44|(1:46)|47|48|49|50|51|52|53|82)(3:71|72|73))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ zzapv -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ IllegalArgumentException -> 0x0157, zzapj -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0151 A[SYNTHETIC, Splitter:B:71:0x0151] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaqe zzg(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r11 = "1658186039475"
            com.google.android.gms.internal.ads.zzaqe r0 = new com.google.android.gms.internal.ads.zzaqe
            r0.<init>(r9)
            com.google.android.gms.internal.ads.zzaqa r9 = new com.google.android.gms.internal.ads.zzaqa     // Catch:{ zzapv -> 0x0165 }
            r9.<init>()     // Catch:{ zzapv -> 0x0165 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzapv -> 0x0165 }
            r0.zze = r9     // Catch:{ zzapv -> 0x0165 }
            r0.zzj = r12     // Catch:{ zzapv -> 0x0165 }
            if (r12 == 0) goto L_0x0025
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzapv -> 0x0165 }
            com.google.android.gms.internal.ads.zzaqb r12 = new com.google.android.gms.internal.ads.zzaqb     // Catch:{ zzapv -> 0x0165 }
            r12.<init>(r0)     // Catch:{ zzapv -> 0x0165 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzapv -> 0x0165 }
            r0.zzk = r9     // Catch:{ zzapv -> 0x0165 }
        L_0x0025:
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzapv -> 0x0165 }
            com.google.android.gms.internal.ads.zzaqd r12 = new com.google.android.gms.internal.ads.zzaqd     // Catch:{ zzapv -> 0x0165 }
            r12.<init>(r0)     // Catch:{ zzapv -> 0x0165 }
            r9.execute(r12)     // Catch:{ zzapv -> 0x0165 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r2 = r1.getApkVersion(r2)     // Catch:{ all -> 0x004f }
            if (r2 <= 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            r0.zzb = r2     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            r0.zzc = r1     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0.zzo(r12, r9)     // Catch:{ zzapv -> 0x0165 }
            boolean r1 = com.google.android.gms.internal.ads.zzaqh.zzf()     // Catch:{ zzapv -> 0x0165 }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzcx     // Catch:{ zzapv -> 0x0165 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzapv -> 0x0165 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ zzapv -> 0x0165 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzapv -> 0x0165 }
            boolean r1 = r1.booleanValue()     // Catch:{ zzapv -> 0x0165 }
            if (r1 != 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzapv -> 0x0165 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzapv -> 0x0165 }
            throw r9     // Catch:{ zzapv -> 0x0165 }
        L_0x0073:
            com.google.android.gms.internal.ads.zzapk r1 = new com.google.android.gms.internal.ads.zzapk     // Catch:{ zzapv -> 0x0165 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzapv -> 0x0165 }
            r0.zzg = r1     // Catch:{ zzapv -> 0x0165 }
            java.lang.String r3 = "HeBkX9XaSpC6sV82I6X2HUgm82vH8VhIWt26LGkrI3A="
            byte[] r3 = com.google.android.gms.internal.ads.zzanp.zzb(r3, r12)     // Catch:{ IllegalArgumentException -> 0x0157 }
            int r4 = r3.length     // Catch:{ IllegalArgumentException -> 0x0157 }
            r5 = 32
            if (r4 != r5) goto L_0x0151
            r4 = 4
            r5 = 16
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0157 }
            byte[] r4 = new byte[r5]     // Catch:{ IllegalArgumentException -> 0x0157 }
            r3.get(r4)     // Catch:{ IllegalArgumentException -> 0x0157 }
            r3 = 0
        L_0x0093:
            if (r3 >= r5) goto L_0x009f
            byte r6 = r4[r3]     // Catch:{ IllegalArgumentException -> 0x0157 }
            r6 = r6 ^ 68
            byte r6 = (byte) r6     // Catch:{ IllegalArgumentException -> 0x0157 }
            r4[r3] = r6     // Catch:{ IllegalArgumentException -> 0x0157 }
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009f:
            r0.zzh = r4     // Catch:{ zzapj -> 0x015e }
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            if (r1 != 0) goto L_0x00ba
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r3 = "dex"
            java.io.File r1 = r1.getDir(r3, r12)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            if (r1 == 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            com.google.android.gms.internal.ads.zzapv r9 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            throw r9     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x00ba:
            java.lang.String r3 = "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"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r6[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r6[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r7 = "%s/%s.jar"
            java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            boolean r6 = r4.exists()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            if (r6 != 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzapk r6 = r0.zzg     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            byte[] r7 = r0.zzh     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            byte[] r3 = r6.zzb(r7, r3)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            int r7 = r3.length     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r6.write(r3, r12, r7)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r6.close()     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x00eb:
            r0.zzx(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            dalvik.system.DexClassLoader r3 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x0120 }
            java.lang.String r6 = r4.getAbsolutePath()     // Catch:{ all -> 0x0120 }
            java.lang.String r7 = r1.getAbsolutePath()     // Catch:{ all -> 0x0120 }
            android.content.Context r8 = r0.zza     // Catch:{ all -> 0x0120 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x0120 }
            r3.<init>(r6, r7, r2, r8)     // Catch:{ all -> 0x0120 }
            r0.zzf = r3     // Catch:{ all -> 0x0120 }
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r2[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r2[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r10 = java.lang.String.format(r10, r2)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            zzz(r10)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            com.google.android.gms.internal.ads.zzaoz r10 = new com.google.android.gms.internal.ads.zzaoz     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r0)     // Catch:{ zzapv -> 0x0165 }
            r0.zzo = r10     // Catch:{ zzapv -> 0x0165 }
            r0.zzq = r9     // Catch:{ zzapv -> 0x0165 }
            goto L_0x0165
        L_0x0120:
            r2 = move-exception
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r3[r12] = r1     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            r3[r9] = r11     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            java.lang.String r9 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            zzz(r9)     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
            throw r2     // Catch:{ FileNotFoundException -> 0x014a, IOException -> 0x0143, zzapj -> 0x013c, NullPointerException -> 0x0135 }
        L_0x0135:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapv r10 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzapv -> 0x0165 }
            throw r10     // Catch:{ zzapv -> 0x0165 }
        L_0x013c:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapv r10 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzapv -> 0x0165 }
            throw r10     // Catch:{ zzapv -> 0x0165 }
        L_0x0143:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapv r10 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzapv -> 0x0165 }
            throw r10     // Catch:{ zzapv -> 0x0165 }
        L_0x014a:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapv r10 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzapv -> 0x0165 }
            throw r10     // Catch:{ zzapv -> 0x0165 }
        L_0x0151:
            com.google.android.gms.internal.ads.zzapj r9 = new com.google.android.gms.internal.ads.zzapj     // Catch:{ IllegalArgumentException -> 0x0157 }
            r9.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0157 }
            throw r9     // Catch:{ IllegalArgumentException -> 0x0157 }
        L_0x0157:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapj r10 = new com.google.android.gms.internal.ads.zzapj     // Catch:{ zzapj -> 0x015e }
            r10.<init>(r1, r9)     // Catch:{ zzapj -> 0x015e }
            throw r10     // Catch:{ zzapj -> 0x015e }
        L_0x015e:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzapv r10 = new com.google.android.gms.internal.ads.zzapv     // Catch:{ zzapv -> 0x0165 }
            r10.<init>(r9)     // Catch:{ zzapv -> 0x0165 }
            throw r10     // Catch:{ zzapv -> 0x0165 }
        L_0x0165:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqe.zzg(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzaqe");
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00be */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC, Splitter:B:42:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[SYNTHETIC, Splitter:B:54:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec A[SYNTHETIC, Splitter:B:58:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r12 = "test"
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r11
            r4 = 1
            java.lang.String r5 = "1658186039475"
            r2[r4] = r5
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0020
            return
        L_0x0020:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r11
            r1[r4] = r5
            java.lang.String r11 = "%s/%s.dex"
            java.lang.String r11 = java.lang.String.format(r11, r1)
            r2.<init>(r11)
            boolean r11 = r2.exists()
            if (r11 != 0) goto L_0x0038
            return
        L_0x0038:
            long r6 = r2.length()
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x0043
            return
        L_0x0043:
            int r11 = (int) r6
            byte[] r11 = new byte[r11]
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00cf }
            r4.<init>(r2)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00cf }
            int r6 = r4.read(r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            if (r6 > 0) goto L_0x0059
            r4.close()     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            zzy(r2)
            return
        L_0x0059:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r6.print(r12)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r6.print(r12)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r6.print(r12)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzand r12 = com.google.android.gms.internal.ads.zzane.zza()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzgpw r6 = com.google.android.gms.internal.ads.zzgpw.zzv(r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r12.zzc(r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            byte[] r5 = r5.getBytes()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzgpw r5 = com.google.android.gms.internal.ads.zzgpw.zzv(r5)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r12.zzd(r5)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzapk r5 = r10.zzg     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            byte[] r6 = r10.zzh     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            java.lang.String r11 = r5.zza(r6, r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            byte[] r11 = r11.getBytes()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzgpw r5 = com.google.android.gms.internal.ads.zzgpw.zzv(r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r12.zza(r5)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            byte[] r11 = com.google.android.gms.internal.ads.zzant.zze(r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzgpw r11 = com.google.android.gms.internal.ads.zzgpw.zzv(r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r12.zzb(r11)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r0.createNewFile()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            r11.<init>(r0)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzgre r12 = r12.zzam()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            com.google.android.gms.internal.ads.zzane r12 = (com.google.android.gms.internal.ads.zzane) r12     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            byte[] r12 = r12.zzax()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            int r0 = r12.length     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            r11.write(r12, r3, r0)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            r11.close()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c5 }
            r4.close()     // Catch:{ IOException -> 0x00be }
        L_0x00be:
            r11.close()     // Catch:{ IOException -> 0x00c1 }
        L_0x00c1:
            zzy(r2)
            return
        L_0x00c5:
            r12 = move-exception
            goto L_0x00ca
        L_0x00c7:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00ca:
            r1 = r4
            goto L_0x00d2
        L_0x00cc:
            r11 = r1
        L_0x00cd:
            r1 = r4
            goto L_0x00e3
        L_0x00cf:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00d2:
            if (r1 == 0) goto L_0x00d9
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r11 == 0) goto L_0x00de
            r11.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzy(r2)
            throw r12
        L_0x00e2:
            r11 = r1
        L_0x00e3:
            if (r1 == 0) goto L_0x00ea
            r1.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
        L_0x00ea:
            if (r11 == 0) goto L_0x00ef
            r11.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            zzy(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqe.zzw(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:30|31|32|33|34|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e9, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00d3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e1 */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: zzapj | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f0 A[SYNTHETIC, Splitter:B:61:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7 A[SYNTHETIC, Splitter:B:65:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fe A[SYNTHETIC, Splitter:B:72:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0105 A[SYNTHETIC, Splitter:B:76:0x0105] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzx(java.io.File r14, java.lang.String r15) {
        /*
            r13 = this;
            java.io.File r15 = new java.io.File
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r14
            r3 = 1
            java.lang.String r4 = "1658186039475"
            r1[r3] = r4
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r15.<init>(r1)
            boolean r1 = r15.exists()
            if (r1 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r14
            r0[r3] = r4
            java.lang.String r14 = "%s/%s.dex"
            java.lang.String r14 = java.lang.String.format(r14, r0)
            r1.<init>(r14)
            boolean r14 = r1.exists()
            if (r14 != 0) goto L_0x0108
            r14 = 0
            long r5 = r15.length()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0043
            zzy(r15)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            return r2
        L_0x0043:
            int r0 = (int) r5     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            byte[] r0 = new byte[r0]     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            r5.<init>(r15)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00fb, all -> 0x00ec }
            int r6 = r5.read(r0)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            if (r6 > 0) goto L_0x0065
            java.lang.String r8 = zzd     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            java.lang.String r9 = "Cannot read the cache data."
            r7 = 3
            r10 = 0
            java.lang.String r11 = "com.google.android.gms.internal.ads.zzaqe"
            r12 = 23
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            zzy(r15)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r5.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            return r2
        L_0x0065:
            com.google.android.gms.internal.ads.zzgqq r6 = com.google.android.gms.internal.ads.zzgqq.zza()     // Catch:{ NullPointerException -> 0x00e1, zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, zzapj | IOException | NoSuchAlgorithmException -> 0x00e9 }
            com.google.android.gms.internal.ads.zzane r0 = com.google.android.gms.internal.ads.zzane.zzd(r0, r6)     // Catch:{ NullPointerException -> 0x00e1, zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, zzapj | IOException | NoSuchAlgorithmException -> 0x00e9 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzgpw r7 = r0.zzh()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r7 = r7.zzE()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r6.<init>(r7)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            boolean r4 = r4.equals(r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            if (r4 == 0) goto L_0x00da
            com.google.android.gms.internal.ads.zzgpw r4 = r0.zzf()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r4 = r4.zzE()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzgpw r6 = r0.zze()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r6 = r6.zzE()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r6 = com.google.android.gms.internal.ads.zzant.zze(r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            if (r4 == 0) goto L_0x00da
            com.google.android.gms.internal.ads.zzgpw r4 = r0.zzg()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r4 = r4.zzE()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            if (r4 != 0) goto L_0x00af
            goto L_0x00da
        L_0x00af:
            com.google.android.gms.internal.ads.zzapk r15 = r13.zzg     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r4 = r13.zzh     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            com.google.android.gms.internal.ads.zzgpw r0 = r0.zze()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r0 = r0.zzE()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r6.<init>(r0)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            byte[] r15 = r15.zzb(r4, r6)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r1.createNewFile()     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r0.<init>(r1)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            int r14 = r15.length     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            r0.write(r15, r2, r14)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            r5.close()     // Catch:{ IOException -> 0x00d3 }
        L_0x00d3:
            r0.close()     // Catch:{ IOException -> 0x00d6 }
        L_0x00d6:
            return r3
        L_0x00d7:
            r14 = move-exception
            r15 = r14
            goto L_0x00e7
        L_0x00da:
            zzy(r15)     // Catch:{ zzapj | IOException | NoSuchAlgorithmException -> 0x00e9, all -> 0x00e5 }
            r5.close()     // Catch:{ IOException -> 0x00e0 }
        L_0x00e0:
            return r2
        L_0x00e1:
            r5.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            return r2
        L_0x00e5:
            r15 = move-exception
            r0 = r14
        L_0x00e7:
            r14 = r5
            goto L_0x00ee
        L_0x00e9:
            r0 = r14
        L_0x00ea:
            r14 = r5
            goto L_0x00fc
        L_0x00ec:
            r15 = move-exception
            r0 = r14
        L_0x00ee:
            if (r14 == 0) goto L_0x00f5
            r14.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x00f5
        L_0x00f4:
        L_0x00f5:
            if (r0 == 0) goto L_0x00fa
            r0.close()     // Catch:{ IOException -> 0x00fa }
        L_0x00fa:
            throw r15
        L_0x00fb:
            r0 = r14
        L_0x00fc:
            if (r14 == 0) goto L_0x0103
            r14.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0103
        L_0x0102:
        L_0x0103:
            if (r0 == 0) goto L_0x0108
            r0.close()     // Catch:{ IOException -> 0x0108 }
        L_0x0108:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqe.zzx(java.io.File, java.lang.String):boolean");
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            SystemUtils.log(3, zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}), (Throwable) null, "com.google.android.gms.internal.ads.zzaqe", 2);
            return;
        }
        file.delete();
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzaoz.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzana zzc() {
        return this.zzm;
    }

    public final zzaoz zzd() {
        return this.zzo;
    }

    public final zzapk zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final zzapx zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        if (!this.zzj) {
            return null;
        }
        if (this.zzi != null) {
            return this.zzi;
        }
        Future future = this.zzk;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzarp zzarp = (zzarp) this.zzp.get(new Pair(str, str2));
        if (zzarp == null) {
            return null;
        }
        return zzarp.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzaqc(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzp.containsKey(pair)) {
            return false;
        }
        this.zzp.put(pair, new zzarp(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
