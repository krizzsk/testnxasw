package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzim implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzin zza;

    /* synthetic */ zzim(zzin zzin, zzil zzil) {
        this.zza = zzin;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzgi zzgi;
        try {
            this.zza.zzs.zzaz().zzj().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzgi = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "gs";
                        String queryParameter = data.getQueryParameter(Payload.REFERRER);
                        if (bundle != null) {
                            z = false;
                        }
                        this.zza.zzs.zzaA().zzp(new zzik(this, z, data, str, queryParameter));
                        zzgi = this.zza.zzs;
                    }
                }
                zzgi = this.zza.zzs;
            }
        } catch (RuntimeException e) {
            this.zza.zzs.zzaz().zzd().zzb("Throwable caught in onActivityCreated", e);
            zzgi = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzs().zzr(activity, bundle);
            throw th;
        }
        zzgi.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzs().zzt(activity);
        zzkr zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaA().zzp(new zzkk(zzu, zzu.zzs.zzaw().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzkr zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaA().zzp(new zzkj(zzu, zzu.zzs.zzaw().elapsedRealtime()));
        this.zza.zzs.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
