package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import com.didi.map.global.sdk.movement.sensor.SensorGetter;
import com.didi.map.global.sdk.movement.sensor.StepDetection;

public class DidiMovementManager {

    /* renamed from: a */
    private static volatile DidiMovementManager f30186a;

    /* renamed from: b */
    private static Context f30187b;

    /* renamed from: c */
    private boolean f30188c = false;

    /* renamed from: d */
    private SensorGetter f30189d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public StepDetection f30190e;

    /* renamed from: f */
    private final SensorGetter.onSensorChanged f30191f = new SensorGetter.onSensorChanged() {
        public void onAccelerationChanged(float f, float f2, float f3) {
            if (DidiMovementManager.this.f30190e != null) {
                DidiMovementManager.this.f30190e.onReceiveAcceleration(new StepDetection.Acceleration((float) Math.sqrt(Math.pow((double) f, 2.0d) + Math.pow((double) f2, 2.0d) + Math.pow((double) f3, 2.0d)), System.currentTimeMillis()));
            }
        }
    };

    public static DidiMovementManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (f30186a == null) {
            synchronized (DidiMovementManager.class) {
                if (f30186a == null) {
                    f30186a = new DidiMovementManager(context);
                }
            }
        }
        return f30186a;
    }

    private DidiMovementManager(Context context) {
        f30187b = context.getApplicationContext();
    }

    public void start(onDidiMovementListener ondidimovementlistener) {
        if (!this.f30188c) {
            this.f30188c = true;
            SensorGetter sensorGetter = new SensorGetter(f30187b);
            this.f30189d = sensorGetter;
            sensorGetter.setOnSensorChanged(this.f30191f);
            this.f30190e = new StepDetection(f30187b, 400, ondidimovementlistener);
        }
    }

    public void stop() {
        if (this.f30188c) {
            this.f30188c = false;
            SensorGetter sensorGetter = this.f30189d;
            if (sensorGetter != null) {
                sensorGetter.destroy();
                this.f30189d = null;
            }
            StepDetection stepDetection = this.f30190e;
            if (stepDetection != null) {
                stepDetection.destroy();
                this.f30190e = null;
            }
        }
        f30186a = null;
        f30187b = null;
    }
}
