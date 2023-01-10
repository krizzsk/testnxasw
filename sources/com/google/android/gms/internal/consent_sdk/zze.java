package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzg[] zzc;

    public /* synthetic */ zze(String str, String str2, zzg[] zzgArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzgArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        String str2 = this.zzb;
        zzg[] zzgArr = this.zzc;
        if (TextUtils.isEmpty(str)) {
            SystemUtils.log(3, "UserMessagingPlatform", "Error on action: empty action name", (Throwable) null, "com.google.android.gms.internal.consent_sdk.zze", 2);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.isEmpty(str2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 32 + String.valueOf(str2).length());
                sb.append("Action[");
                sb.append(lowerCase);
                sb.append("]: failed to parse args: ");
                sb.append(str2);
                SystemUtils.log(3, "UserMessagingPlatform", sb.toString(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zze", 8);
                return;
            }
        }
        String valueOf = String.valueOf(jSONObject);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 10 + String.valueOf(valueOf).length());
        sb2.append("Action[");
        sb2.append(lowerCase);
        sb2.append("]: ");
        sb2.append(valueOf);
        SystemUtils.log(3, "UserMessagingPlatform", sb2.toString(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zze", 10);
        int length = zzgArr.length;
        int i = 0;
        while (i < length) {
            zzg zzg = zzgArr[i];
            FutureTask futureTask = new FutureTask(new zzf(zzg, lowerCase, jSONObject));
            zzg.zza().execute(futureTask);
            try {
                if (!((Boolean) futureTask.get()).booleanValue()) {
                    i++;
                } else {
                    return;
                }
            } catch (ExecutionException e) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(lowerCase).length() + 24);
                sb3.append("Failed to run Action[");
                sb3.append(lowerCase);
                sb3.append("]: ");
                SystemUtils.log(3, "UserMessagingPlatform", sb3.toString(), e.getCause(), "com.google.android.gms.internal.consent_sdk.zze", 19);
            } catch (InterruptedException e2) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(lowerCase).length() + 33);
                sb4.append("Thread interrupted for Action[");
                sb4.append(lowerCase);
                sb4.append("]: ");
                SystemUtils.log(3, "UserMessagingPlatform", sb4.toString(), e2, "com.google.android.gms.internal.consent_sdk.zze", 16);
            }
        }
    }
}
