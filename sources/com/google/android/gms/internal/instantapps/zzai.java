package com.google.android.gms.internal.instantapps;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.instantapps.InstantAppIntentData;

public final class zzai {
    private static Boolean zzbm;
    private static ContentProviderClient zzbn;

    /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.common.internal.safeparcel.SafeParcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.instantapps.InstantAppIntentData zza(android.content.Context r15, java.lang.String r16, android.os.Parcelable r17, boolean r18, com.google.android.gms.internal.instantapps.zzar r19, android.os.Bundle r20) {
        /*
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r20
            java.lang.String r5 = "While calling %s %s:\n"
            java.lang.String r6 = "method_getInstantAppIntentData"
            r7 = 0
            r8 = r18
        L_0x000e:
            if (r1 == 0) goto L_0x0138
            if (r2 == 0) goto L_0x0138
            com.google.android.gms.internal.instantapps.zzbc$zza$zzb r0 = com.google.android.gms.internal.instantapps.zzbc.zza.zzb.GET_IA_INTENT_DATA_START
            com.google.android.gms.internal.instantapps.zzba$zzb r9 = com.google.android.gms.internal.instantapps.zzp.zza(r0)
            boolean r0 = zzd(r15)
            if (r0 != 0) goto L_0x0021
            com.google.android.gms.instantapps.InstantAppIntentData r0 = com.google.android.gms.instantapps.InstantAppIntentData.zzj
            return r0
        L_0x0021:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r10 = "key_preferParcelableIntentData"
            r11 = 1
            r0.putBoolean(r10, r11)
            if (r3 == 0) goto L_0x0033
            java.lang.String r10 = "key_fallbackIntent"
            r0.putParcelable(r10, r3)
        L_0x0033:
            if (r19 == 0) goto L_0x003e
            byte[] r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.serializeToBytes(r19)
            java.lang.String r12 = "key_routingOptions"
            r0.putByteArray(r12, r10)
        L_0x003e:
            if (r4 == 0) goto L_0x0043
            r0.putAll(r4)
        L_0x0043:
            r10 = 2
            android.os.Bundle r0 = zza(r15, r6, r2, r0)     // Catch:{ DeadObjectException -> 0x00f0, IllegalArgumentException -> 0x00ee, RemoteException -> 0x00ec }
            if (r0 != 0) goto L_0x004d
            com.google.android.gms.instantapps.InstantAppIntentData r0 = com.google.android.gms.instantapps.InstantAppIntentData.zzj
            return r0
        L_0x004d:
            java.lang.Class<com.google.android.gms.instantapps.InstantAppIntentData> r1 = com.google.android.gms.instantapps.InstantAppIntentData.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            r1 = 0
            java.lang.String r2 = "key_instantAppIntentDataParcelable"
            android.os.Parcelable r2 = r0.getParcelable(r2)     // Catch:{ Exception -> 0x0060 }
            com.google.android.gms.instantapps.InstantAppIntentData r2 = (com.google.android.gms.instantapps.InstantAppIntentData) r2     // Catch:{ Exception -> 0x0060 }
            goto L_0x0061
        L_0x0060:
            r2 = r1
        L_0x0061:
            if (r2 != 0) goto L_0x0077
            java.lang.String r2 = "key_instantAppIntentData"
            byte[] r0 = r0.getByteArray(r2)
            if (r0 != 0) goto L_0x006e
            com.google.android.gms.instantapps.InstantAppIntentData r0 = com.google.android.gms.instantapps.InstantAppIntentData.zzj
            return r0
        L_0x006e:
            android.os.Parcelable$Creator<com.google.android.gms.instantapps.InstantAppIntentData> r2 = com.google.android.gms.instantapps.InstantAppIntentData.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromBytes(r0, r2)
            r2 = r0
            com.google.android.gms.instantapps.InstantAppIntentData r2 = (com.google.android.gms.instantapps.InstantAppIntentData) r2
        L_0x0077:
            if (r2 == 0) goto L_0x00eb
            android.content.Intent r0 = r2.getIntent()
            if (r0 == 0) goto L_0x00eb
            android.content.Intent r0 = r2.getIntent()
            java.lang.String r3 = "key_eventListProtoBytes"
            boolean r0 = r0.hasExtra(r3)
            if (r0 == 0) goto L_0x00eb
            android.content.Intent r4 = r2.getIntent()
            com.google.android.gms.internal.instantapps.zzbc$zza$zzb r0 = com.google.android.gms.internal.instantapps.zzbc.zza.zzb.GET_IA_INTENT_DATA_END
            com.google.android.gms.internal.instantapps.zzba$zzb r5 = com.google.android.gms.internal.instantapps.zzp.zza(r0)
            byte[] r0 = r4.getByteArrayExtra(r3)
            if (r0 == 0) goto L_0x00c4
            com.google.android.gms.internal.instantapps.zzba$zza$zza r6 = com.google.android.gms.internal.instantapps.zzba.zza.zzf()     // Catch:{ zzdf -> 0x00ac }
            com.google.android.gms.internal.instantapps.zzck r8 = com.google.android.gms.internal.instantapps.zzck.zzbf()     // Catch:{ zzdf -> 0x00ac }
            int r10 = r0.length     // Catch:{ zzdf -> 0x00ac }
            com.google.android.gms.internal.instantapps.zzbh r0 = r6.zza(r0, r7, r10, r8)     // Catch:{ zzdf -> 0x00ac }
            com.google.android.gms.internal.instantapps.zzba$zza$zza r0 = (com.google.android.gms.internal.instantapps.zzba.zza.C22236zza) r0     // Catch:{ zzdf -> 0x00ac }
            r1 = r0
            goto L_0x00c4
        L_0x00ac:
            r0 = move-exception
            r6 = 6
            r8 = 58
            java.lang.String r10 = "EventLogHelper"
            java.lang.String r11 = "Could not read event list proto"
            java.lang.String r12 = "com.google.android.gms.internal.instantapps.zzai"
            r15 = r6
            r16 = r10
            r17 = r11
            r18 = r0
            r19 = r12
            r20 = r8
            com.didi.sdk.apm.SystemUtils.log(r15, r16, r17, r18, r19, r20)
        L_0x00c4:
            if (r1 != 0) goto L_0x00d2
            com.google.android.gms.internal.instantapps.zzba$zza$zza r1 = com.google.android.gms.internal.instantapps.zzba.zza.zzf()
            com.google.android.gms.internal.instantapps.zzba$zza$zza r0 = r1.zza(r9)
            r0.zza(r5)
            goto L_0x00dc
        L_0x00d2:
            r1.zza(r7, r9)
            int r0 = r1.zzd()
            r1.zza(r0, r5)
        L_0x00dc:
            com.google.android.gms.internal.instantapps.zzef r0 = r1.zzbw()
            com.google.android.gms.internal.instantapps.zzcx r0 = (com.google.android.gms.internal.instantapps.zzcx) r0
            com.google.android.gms.internal.instantapps.zzba$zza r0 = (com.google.android.gms.internal.instantapps.zzba.zza) r0
            byte[] r0 = r0.toByteArray()
            r4.putExtra(r3, r0)
        L_0x00eb:
            return r2
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f3
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f3
        L_0x00f0:
            r0 = move-exception
            r12 = r0
            goto L_0x0117
        L_0x00f3:
            java.lang.Object[] r1 = new java.lang.Object[r10]
            android.net.Uri r2 = com.google.android.gms.internal.instantapps.zzj.zzak
            r1[r7] = r2
            r1[r11] = r6
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r2 = 6
            r3 = 27
            java.lang.String r4 = "InstantAppsApi"
            java.lang.String r5 = "com.google.android.gms.internal.instantapps.zzai"
            r15 = r2
            r16 = r4
            r17 = r1
            r18 = r0
            r19 = r5
            r20 = r3
            com.didi.sdk.apm.SystemUtils.log(r15, r16, r17, r18, r19, r20)
            com.google.android.gms.instantapps.InstantAppIntentData r0 = com.google.android.gms.instantapps.InstantAppIntentData.zzj
            return r0
        L_0x0117:
            java.lang.Object[] r0 = new java.lang.Object[r10]
            android.net.Uri r9 = com.google.android.gms.internal.instantapps.zzj.zzak
            r0[r7] = r9
            r0[r11] = r6
            java.lang.String r11 = java.lang.String.format(r5, r0)
            r9 = 6
            r14 = 19
            java.lang.String r10 = "InstantAppsApi"
            java.lang.String r13 = "com.google.android.gms.internal.instantapps.zzai"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
            reset()
            if (r8 == 0) goto L_0x0135
            r8 = 0
            goto L_0x000e
        L_0x0135:
            com.google.android.gms.instantapps.InstantAppIntentData r0 = com.google.android.gms.instantapps.InstantAppIntentData.zzj
            return r0
        L_0x0138:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Parameter is null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzai.zza(android.content.Context, java.lang.String, android.os.Parcelable, boolean, com.google.android.gms.internal.instantapps.zzar, android.os.Bundle):com.google.android.gms.instantapps.InstantAppIntentData");
    }

    private static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzai.class) {
            if (zzbn == null) {
                zzbn = context.getApplicationContext().getContentResolver().acquireUnstableContentProviderClient(zzj.zzak);
            }
            z = zzbn != null;
        }
        return z;
    }

    private static synchronized Bundle zza(String str, String str2, Bundle bundle) throws RemoteException {
        Bundle call;
        synchronized (zzai.class) {
            call = zzbn.call(str, str2, bundle);
        }
        return call;
    }

    private static synchronized Bundle zza(Context context, String str, String str2, Bundle bundle) throws RemoteException {
        synchronized (zzai.class) {
            if (zzbn == null) {
                Bundle call = context.getContentResolver().call(zzj.zzak, str, str2, bundle);
                return call;
            }
            Bundle zza = zza(str, str2, bundle);
            return zza;
        }
    }

    static InstantAppIntentData zza(Context context, String str, Intent intent, zzar zzar, Bundle bundle) {
        return zza(context, str, intent, true, zzar, bundle);
    }

    static synchronized boolean zzd(Context context) {
        synchronized (zzai.class) {
            if (context == null) {
                throw new IllegalArgumentException("Parameter is null");
            } else if (zzbm != null) {
                boolean booleanValue = zzbm.booleanValue();
                return booleanValue;
            } else {
                Boolean valueOf = Boolean.valueOf(zze(context));
                zzbm = valueOf;
                boolean booleanValue2 = valueOf.booleanValue();
                return booleanValue2;
            }
        }
    }

    private static synchronized boolean zze(Context context) {
        synchronized (zzai.class) {
            if (!zzav.zzg(context)) {
                return false;
            }
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(zzj.zzak.getAuthority(), 0);
            if (resolveContentProvider == null) {
                return false;
            }
            if (!resolveContentProvider.packageName.equals("com.google.android.gms")) {
                String valueOf = String.valueOf(resolveContentProvider.packageName);
                SystemUtils.log(6, "InstantAppsApi", valueOf.length() != 0 ? "Incorrect package name for instant apps content provider: ".concat(valueOf) : new String("Incorrect package name for instant apps content provider: "), (Throwable) null, "com.google.android.gms.internal.instantapps.zzai", 94);
                return false;
            } else if (Build.VERSION.SDK_INT < 17 || zzc(context)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static synchronized void reset() {
        synchronized (zzai.class) {
            if (zzbn != null) {
                zzbn.release();
                zzbn = null;
            }
            zzbm = null;
        }
    }
}
