package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbbr implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzc = ((Long) zzay.zzc().zzb(zzbjc.zzbf)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzbcd zzj;
    private final zzbz zzk = new zzbz(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzbbr(Context context, View view) {
        this.zzd = context.getApplicationContext();
        this.zzf = (WindowManager) context.getSystemService("window");
        this.zzg = (PowerManager) this.zzd.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzd;
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            this.zze = application;
            this.zzj = new zzbcd(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = this.zzf.getDefaultDisplay().getWidth();
        this.zzp.bottom = this.zzf.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i) {
        return (int) (((float) i) / this.zzo.density);
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0117, code lost:
        if (r11 == 0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012d, code lost:
        if (r11 == 0) goto L_0x012f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r33) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            java.util.HashSet r0 = r1.zzn
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference r0 = r1.zzb
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r0 = 2
            int[] r8 = new int[r0]
            int[] r0 = new int[r0]
            r9 = 0
            r10 = 1
            r11 = 0
            if (r3 == 0) goto L_0x006b
            boolean r12 = r3.getGlobalVisibleRect(r5)
            boolean r13 = r3.getLocalVisibleRect(r6)
            r3.getHitRect(r7)
            r3.getLocationOnScreen(r8)     // Catch:{ Exception -> 0x0049 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r0 = move-exception
            java.lang.String r14 = "Failure getting view location."
            com.google.android.gms.ads.internal.util.zze.zzh(r14, r0)
        L_0x004f:
            r0 = r8[r11]
            r4.left = r0
            r0 = r8[r10]
            r4.top = r0
            int r0 = r4.left
            int r8 = r3.getWidth()
            int r0 = r0 + r8
            r4.right = r0
            int r0 = r4.top
            int r8 = r3.getHeight()
            int r0 = r0 + r8
            r4.bottom = r0
            r8 = r3
            goto L_0x006e
        L_0x006b:
            r8 = r9
            r12 = 0
            r13 = 0
        L_0x006e:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbi
            com.google.android.gms.internal.ads.zzbja r14 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r14.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00bf
            if (r8 == 0) goto L_0x00bf
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b0 }
            r0.<init>()     // Catch:{ Exception -> 0x00b0 }
            android.view.ViewParent r14 = r8.getParent()     // Catch:{ Exception -> 0x00b0 }
        L_0x008b:
            boolean r15 = r14 instanceof android.view.View     // Catch:{ Exception -> 0x00b0 }
            if (r15 == 0) goto L_0x00c3
            r15 = r14
            android.view.View r15 = (android.view.View) r15     // Catch:{ Exception -> 0x00b0 }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b0 }
            r11.<init>()     // Catch:{ Exception -> 0x00b0 }
            boolean r17 = r15.isScrollContainer()     // Catch:{ Exception -> 0x00b0 }
            if (r17 == 0) goto L_0x00aa
            boolean r15 = r15.getGlobalVisibleRect(r11)     // Catch:{ Exception -> 0x00b0 }
            if (r15 == 0) goto L_0x00aa
            android.graphics.Rect r11 = r1.zza(r11)     // Catch:{ Exception -> 0x00b0 }
            r0.add(r11)     // Catch:{ Exception -> 0x00b0 }
        L_0x00aa:
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00b0 }
            r11 = 0
            goto L_0x008b
        L_0x00b0:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcfy r11 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r14 = "PositionWatcher.getParentScrollViewRects"
            r11.zzt(r0, r14)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00c3
        L_0x00bf:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00c3:
            r31 = r0
            r0 = 8
            if (r8 == 0) goto L_0x00ce
            int r11 = r8.getWindowVisibility()
            goto L_0x00d0
        L_0x00ce:
            r11 = 8
        L_0x00d0:
            int r14 = r1.zzm
            r15 = -1
            if (r14 == r15) goto L_0x00d6
            r11 = r14
        L_0x00d6:
            com.google.android.gms.ads.internal.zzt.zzp()
            long r26 = com.google.android.gms.ads.internal.util.zzs.zzt(r8)
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzim
            com.google.android.gms.internal.ads.zzbja r15 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x011a
            if (r3 == 0) goto L_0x0132
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzs.zzP(r8, r3, r14)
            if (r3 == 0) goto L_0x0132
            if (r12 == 0) goto L_0x0132
            if (r13 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzip
            com.google.android.gms.internal.ads.zzbja r14 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r14.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r14 = (long) r3
            int r3 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x0132
            if (r11 != 0) goto L_0x0132
            goto L_0x012f
        L_0x011a:
            if (r3 == 0) goto L_0x0132
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzs.zzP(r8, r3, r14)
            if (r3 == 0) goto L_0x0132
            if (r12 == 0) goto L_0x0132
            if (r13 == 0) goto L_0x0132
            if (r11 != 0) goto L_0x0132
        L_0x012f:
            r3 = 1
            r11 = 0
            goto L_0x0133
        L_0x0132:
            r3 = 0
        L_0x0133:
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzir
            com.google.android.gms.internal.ads.zzbja r15 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x018c
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r14 = r1.zzg
            android.app.KeyguardManager r15 = r1.zzh
            boolean r14 = com.google.android.gms.ads.internal.util.zzs.zzP(r8, r14, r15)
            if (r10 == r14) goto L_0x0154
            r14 = 0
            goto L_0x0156
        L_0x0154:
            r14 = 64
        L_0x0156:
            if (r10 == r12) goto L_0x015a
            r15 = 0
            goto L_0x015c
        L_0x015a:
            r15 = 8
        L_0x015c:
            r14 = r14 | r15
            if (r10 == r13) goto L_0x0161
            r15 = 0
            goto L_0x0163
        L_0x0161:
            r15 = 16
        L_0x0163:
            r14 = r14 | r15
            if (r11 != 0) goto L_0x0169
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x016a
        L_0x0169:
            r11 = 0
        L_0x016a:
            r11 = r11 | r14
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzip
            com.google.android.gms.internal.ads.zzbja r15 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r14 = (long) r14
            int r17 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r17 < 0) goto L_0x0183
            r14 = 32
            goto L_0x0184
        L_0x0183:
            r14 = 0
        L_0x0184:
            com.google.android.gms.ads.internal.zzt.zzp()
            r11 = r11 | r14
            r11 = r11 | r3
            com.google.android.gms.ads.internal.util.zzs.zzF(r8, r11, r9)
        L_0x018c:
            if (r2 != r10) goto L_0x019c
            com.google.android.gms.ads.internal.util.zzbz r9 = r1.zzk
            boolean r9 = r9.zzb()
            if (r9 != 0) goto L_0x019c
            boolean r9 = r1.zzl
            if (r3 == r9) goto L_0x019b
            goto L_0x019c
        L_0x019b:
            return
        L_0x019c:
            if (r3 != 0) goto L_0x01a6
            boolean r9 = r1.zzl
            if (r9 != 0) goto L_0x01a6
            if (r2 == r10) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            return
        L_0x01a6:
            com.google.android.gms.internal.ads.zzbbp r2 = new com.google.android.gms.internal.ads.zzbbp
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzt.zzB()
            long r17 = r9.elapsedRealtime()
            android.os.PowerManager r9 = r1.zzg
            boolean r9 = r9.isScreenOn()
            if (r8 == 0) goto L_0x01bf
            boolean r11 = r8.isAttachedToWindow()
            if (r11 == 0) goto L_0x01bf
            goto L_0x01c0
        L_0x01bf:
            r10 = 0
        L_0x01c0:
            if (r8 == 0) goto L_0x01c9
            int r0 = r8.getWindowVisibility()
            r19 = r0
            goto L_0x01cb
        L_0x01c9:
            r19 = 8
        L_0x01cb:
            android.graphics.Rect r0 = r1.zzp
            android.graphics.Rect r20 = r1.zza(r0)
            android.graphics.Rect r21 = r1.zza(r4)
            android.graphics.Rect r22 = r1.zza(r5)
            android.graphics.Rect r24 = r1.zza(r6)
            android.graphics.Rect r28 = r1.zza(r7)
            android.util.DisplayMetrics r0 = r1.zzo
            float r0 = r0.density
            r29 = r0
            r14 = r2
            r15 = r17
            r17 = r9
            r18 = r10
            r23 = r12
            r25 = r13
            r30 = r3
            r14.<init>(r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31)
            java.util.HashSet r0 = r1.zzn
            java.util.Iterator r0 = r0.iterator()
        L_0x01fd:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x020d
            java.lang.Object r4 = r0.next()
            com.google.android.gms.internal.ads.zzbbq r4 = (com.google.android.gms.internal.ads.zzbbq) r4
            r4.zzc(r2)
            goto L_0x01fd
        L_0x020d:
            r1.zzl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbr.zzj(int):void");
    }

    private final void zzk() {
        zzs.zza.post(new zzbbn(this));
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzbbo(this);
            zzt.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                zze.zzh("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            zze.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zze.zzh("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                zzt.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                zze.zzh("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzt.zzo().zzt(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                zze.zzh("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    /* access modifiers changed from: package-private */
    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzbbq zzbbq) {
        this.zzn.add(zzbbq);
        zzj(3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzbbq zzbbq) {
        this.zzn.remove(zzbbq);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j) {
        this.zzk.zza(j);
    }
}
