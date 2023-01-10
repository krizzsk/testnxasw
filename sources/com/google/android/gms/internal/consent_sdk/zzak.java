package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzak implements zzg {
    private final Application zza;
    private final zzam zzb;
    private final Executor zzc;

    public zzak(Application application, zzam zzam, Executor executor) {
        this.zza = application;
        this.zzb = zzam;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.lang.String r18, org.json.JSONObject r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            int r3 = r18.hashCode()
            r4 = 94746189(0x5a5b64d, float:1.5583492E-35)
            r5 = 0
            r6 = 1
            if (r3 == r4) goto L_0x0022
            r4 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r3 == r4) goto L_0x0017
            goto L_0x002c
        L_0x0017:
            java.lang.String r3 = "write"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002c
            r1 = 0
            goto L_0x002d
        L_0x0022:
            java.lang.String r3 = "clear"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002c
            r1 = 1
            goto L_0x002d
        L_0x002c:
            r1 = -1
        L_0x002d:
            if (r1 == 0) goto L_0x00a8
            if (r1 == r6) goto L_0x0032
            return r5
        L_0x0032:
            java.lang.String r1 = "keys"
            org.json.JSONArray r1 = r2.optJSONArray(r1)
            if (r1 == 0) goto L_0x0081
            int r3 = r1.length()
            if (r3 != 0) goto L_0x0041
            goto L_0x0081
        L_0x0041:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            int r3 = r1.length()
        L_0x004a:
            if (r5 >= r3) goto L_0x007b
            java.lang.String r4 = r1.optString(r5)
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 == 0) goto L_0x0075
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r7 = 46
            r4.<init>(r7)
            java.lang.String r7 = "Action[clear]: empty key at index: "
            r4.append(r7)
            r4.append(r5)
            java.lang.String r10 = r4.toString()
            r8 = 3
            r11 = 0
            r13 = 24
            java.lang.String r9 = "UserMessagingPlatform"
            java.lang.String r12 = "com.google.android.gms.internal.consent_sdk.zzak"
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)
            goto L_0x0078
        L_0x0075:
            r2.add(r4)
        L_0x0078:
            int r5 = r5 + 1
            goto L_0x004a
        L_0x007b:
            android.app.Application r1 = r0.zza
            com.google.android.gms.internal.consent_sdk.zzca.zzb(r1, r2)
            goto L_0x00a7
        L_0x0081:
            java.lang.String r1 = r19.toString()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Action[clear]: wrong args."
            int r3 = r1.length()
            if (r3 == 0) goto L_0x0096
            java.lang.String r1 = r2.concat(r1)
            goto L_0x009b
        L_0x0096:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x009b:
            r9 = r1
            r7 = 3
            r10 = 0
            r12 = 18
            java.lang.String r8 = "UserMessagingPlatform"
            java.lang.String r11 = "com.google.android.gms.internal.consent_sdk.zzak"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
        L_0x00a7:
            return r6
        L_0x00a8:
            com.google.android.gms.internal.consent_sdk.zzbz r1 = new com.google.android.gms.internal.consent_sdk.zzbz
            android.app.Application r3 = r0.zza
            r1.<init>(r3)
            java.util.Iterator r3 = r19.keys()
        L_0x00b3:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0131
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.opt(r4)
            java.lang.String r7 = java.lang.String.valueOf(r5)
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r8 = r8.length()
            java.lang.String r9 = java.lang.String.valueOf(r7)
            int r9 = r9.length()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            int r8 = r8 + 23
            int r8 = r8 + r9
            r10.<init>(r8)
            java.lang.String r8 = "Writing to storage: ["
            r10.append(r8)
            r10.append(r4)
            java.lang.String r8 = "] "
            r10.append(r8)
            r10.append(r7)
            java.lang.String r13 = r10.toString()
            r11 = 3
            r14 = 0
            r16 = 8
            java.lang.String r12 = "UserMessagingPlatform"
            java.lang.String r15 = "com.google.android.gms.internal.consent_sdk.zzak"
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)
            boolean r5 = r1.zzc(r4, r5)
            if (r5 == 0) goto L_0x010e
            com.google.android.gms.internal.consent_sdk.zzam r5 = r0.zzb
            java.util.Set r5 = r5.zzc()
            r5.add(r4)
            goto L_0x00b3
        L_0x010e:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "Failed writing key: "
            int r7 = r4.length()
            if (r7 == 0) goto L_0x011f
            java.lang.String r4 = r5.concat(r4)
            goto L_0x0124
        L_0x011f:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r5)
        L_0x0124:
            r9 = r4
            r7 = 3
            r10 = 0
            r12 = 12
            java.lang.String r8 = "UserMessagingPlatform"
            java.lang.String r11 = "com.google.android.gms.internal.consent_sdk.zzak"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            goto L_0x00b3
        L_0x0131:
            com.google.android.gms.internal.consent_sdk.zzam r2 = r0.zzb
            r2.zze()
            r1.zzb()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzak.zzb(java.lang.String, org.json.JSONObject):boolean");
    }
}
