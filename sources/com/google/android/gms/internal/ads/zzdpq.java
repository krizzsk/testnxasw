package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpq {
    private final zzg zza;
    private final zzfef zzb;
    private final zzdov zzc;
    private final zzdoq zzd;
    private final zzdqb zze;
    private final zzdqj zzf;
    private final Executor zzg;
    private final Executor zzh;
    private final zzbls zzi;
    private final zzdon zzj;

    public zzdpq(zzg zzg2, zzfef zzfef, zzdov zzdov, zzdoq zzdoq, zzdqb zzdqb, zzdqj zzdqj, Executor executor, Executor executor2, zzdon zzdon) {
        this.zza = zzg2;
        this.zzb = zzfef;
        this.zzi = zzfef.zzi;
        this.zzc = zzdov;
        this.zzd = zzdoq;
        this.zze = zzdqb;
        this.zzf = zzdqj;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzdon;
    }

    private final boolean zzh(ViewGroup viewGroup, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View zzf2 = z ? this.zzd.zzf() : this.zzd.zzg();
        if (zzf2 == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzf2.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzf2.getParent()).removeView(zzf2);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcX)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzf2, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        zzdoq zzdoq = this.zzd;
        if (zzdoq.zzf() == null) {
            return;
        }
        if (zzdoq.zzc() == 2 || zzdoq.zzc() == 1) {
            this.zza.zzI(this.zzb.zzf, String.valueOf(zzdoq.zzc()), z);
        } else if (zzdoq.zzc() == 6) {
            this.zza.zzI(this.zzb.zzf, "2", z);
            this.zza.zzI(this.zzb.zzf, "1", z);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzdql zzdql) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbmb zza2;
        Drawable drawable;
        IObjectWrapper iObjectWrapper = null;
        if (this.zzc.zzf() || this.zzc.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                View zzg2 = zzdql.zzg(strArr[i]);
                if (zzg2 != null && (zzg2 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg2;
                    break;
                }
                i++;
            }
        }
        viewGroup = null;
        Context context = zzdql.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdoq zzdoq = this.zzd;
        if (zzdoq.zze() != null) {
            view = zzdoq.zze();
            zzbls zzbls = this.zzi;
            if (zzbls != null && viewGroup == null) {
                zzg(layoutParams, zzbls.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(zzdoq.zzl() instanceof zzbln)) {
            view = null;
        } else {
            zzbln zzbln = (zzbln) zzdoq.zzl();
            if (viewGroup == null) {
                zzg(layoutParams, zzbln.zzc());
            }
            zzblo zzblo = new zzblo(context, zzbln, layoutParams);
            zzblo.setContentDescription((CharSequence) zzay.zzc().zzb(zzbjc.zzcV));
            view = zzblo;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdql.zzf().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzh2 = zzdql.zzh();
                if (zzh2 != null) {
                    zzh2.addView(zza3);
                }
            }
            zzdql.zzq(zzdql.zzk(), view, true);
        }
        zzfvn zzfvn = zzdpm.zza;
        int size = zzfvn.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg3 = zzdql.zzg((String) zzfvn.get(i2));
            i2++;
            if (zzg3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg3;
                break;
            }
        }
        this.zzh.execute(new zzdpn(this, viewGroup2));
        if (viewGroup2 != null) {
            if (zzh(viewGroup2, true)) {
                zzdoq zzdoq2 = this.zzd;
                if (zzdoq2.zzr() != null) {
                    zzdoq2.zzr().zzaq(new zzdpp(zzdql, viewGroup2));
                    return;
                }
                return;
            }
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzik)).booleanValue() || !zzh(viewGroup2, false)) {
                viewGroup2.removeAllViews();
                View zzf2 = zzdql.zzf();
                Context context2 = zzf2 != null ? zzf2.getContext() : null;
                if (context2 != null && (zza2 = this.zzj.zza()) != null) {
                    try {
                        IObjectWrapper zzi2 = zza2.zzi();
                        if (zzi2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi2)) != null) {
                            ImageView imageView = new ImageView(context2);
                            imageView.setImageDrawable(drawable);
                            if (zzdql != null) {
                                iObjectWrapper = zzdql.zzj();
                            }
                            if (iObjectWrapper != null) {
                                if (((Boolean) zzay.zzc().zzb(zzbjc.zzfl)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapper));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zze.zzj("Could not get main image drawable");
                    }
                }
            } else {
                zzdoq zzdoq3 = this.zzd;
                if (zzdoq3.zzp() != null) {
                    zzdoq3.zzp().zzaq(new zzdpp(zzdql, viewGroup2));
                }
            }
        }
    }

    public final void zzc(zzdql zzdql) {
        if (zzdql != null && this.zze != null && zzdql.zzh() != null && this.zzc.zzg()) {
            try {
                zzdql.zzh().addView(this.zze.zza());
            } catch (zzcna e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdql zzdql) {
        if (zzdql != null) {
            Context context = zzdql.zzf().getContext();
            if (zzbx.zzh(context, this.zzc.zza)) {
                if (!(context instanceof Activity)) {
                    zze.zze("Activity context is needed for policy validator.");
                } else if (this.zzf != null && zzdql.zzh() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzf.zza(zzdql.zzh(), windowManager), zzbx.zzb());
                    } catch (zzcna e) {
                        zze.zzb("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    public final void zze(zzdql zzdql) {
        this.zzg.execute(new zzdpo(this, zzdql));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzh(viewGroup, true);
    }

    private static void zzg(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
