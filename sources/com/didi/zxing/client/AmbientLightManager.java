package com.didi.zxing.client;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.security.wireless.ISecurityConf;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.camera.CameraManager;
import com.didi.zxing.barcodescanner.camera.CameraSettings;

public final class AmbientLightManager implements SensorEventListener {

    /* renamed from: a */
    private static final float f48111a = 1.0f;

    /* renamed from: b */
    private static final float f48112b = 600.0f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraManager f48113c;

    /* renamed from: d */
    private CameraSettings f48114d;

    /* renamed from: e */
    private Sensor f48115e;

    /* renamed from: f */
    private Context f48116f;

    /* renamed from: g */
    private Handler f48117g = new Handler();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public AmbientLightManager(Context context, CameraManager cameraManager, CameraSettings cameraSettings) {
        this.f48116f = context;
        this.f48113c = cameraManager;
        this.f48114d = cameraSettings;
    }

    public void start() {
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if ((config == null || !config.autoTorch()) && this.f48114d.isAutoTorchEnabled()) {
            SensorManager sensorManager = (SensorManager) this.f48116f.getSystemService(ISecurityConf.KEY_SENSOR);
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f48115e = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void stop() {
        if (this.f48115e != null) {
            ((SensorManager) this.f48116f.getSystemService(ISecurityConf.KEY_SENSOR)).unregisterListener(this);
            this.f48115e = null;
        }
    }

    /* renamed from: a */
    private void m36097a(final boolean z) {
        this.f48117g.post(new Runnable() {
            public void run() {
                AmbientLightManager.this.f48113c.setTorch(z);
            }
        });
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f48113c != null) {
            SystemUtils.log(6, "panlei", "ambientLightLux = " + f, (Throwable) null, "com.didi.zxing.client.AmbientLightManager", 94);
            if (f <= 1.0f) {
                m36097a(true);
            } else if (f >= f48112b) {
                m36097a(false);
            }
        }
    }
}
