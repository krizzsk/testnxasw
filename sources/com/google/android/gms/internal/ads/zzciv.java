package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.didi.security.wireless.ISecurityConf;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzciv implements SensorEventListener {
    private final SensorManager zza;
    private final Object zzb = new Object();
    private final Display zzc;
    private final float[] zzd = new float[9];
    private final float[] zze = new float[9];
    private float[] zzf;
    private Handler zzg;
    private zzciu zzh;

    zzciv(Context context) {
        this.zza = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.zzc = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzb) {
                if (this.zzf == null) {
                    this.zzf = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzd, fArr);
            int rotation = this.zzc.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzd, 2, 129, this.zze);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzd, 129, 130, this.zze);
            } else if (rotation != 3) {
                System.arraycopy(this.zzd, 0, this.zze, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzd, 130, 1, this.zze);
            }
            float[] fArr2 = this.zze;
            float f = fArr2[1];
            fArr2[1] = fArr2[3];
            fArr2[3] = f;
            float f2 = fArr2[2];
            fArr2[2] = fArr2[6];
            fArr2[6] = f2;
            float f3 = fArr2[5];
            fArr2[5] = fArr2[7];
            fArr2[7] = f3;
            synchronized (this.zzb) {
                System.arraycopy(this.zze, 0, this.zzf, 0, 9);
            }
            zzciu zzciu = this.zzh;
            if (zzciu != null) {
                zzciu.zza();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzciu zzciu) {
        this.zzh = zzciu;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (this.zzg == null) {
            Sensor defaultSensor = this.zza.getDefaultSensor(11);
            if (defaultSensor == null) {
                zze.zzg("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzfpz zzfpz = new zzfpz(handlerThread.getLooper());
            this.zzg = zzfpz;
            if (!this.zza.registerListener(this, defaultSensor, 0, zzfpz)) {
                zze.zzg("SensorManager.registerListener failed.");
                zzc();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zzg != null) {
            this.zza.unregisterListener(this);
            this.zzg.post(new zzcit(this));
            this.zzg = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(float[] fArr) {
        synchronized (this.zzb) {
            float[] fArr2 = this.zzf;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, 9);
            return true;
        }
    }
}
