package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.common.map.util.DLog;
import com.didi.security.wireless.ISecurityConf;

public class SensorGetter {

    /* renamed from: a */
    private SensorManager f30199a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public onSensorChanged f30200b;

    /* renamed from: c */
    private final SensorEventListener f30201c = new SensorEventListener() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1 && SensorGetter.this.f30200b != null) {
                SensorGetter.this.f30200b.onAccelerationChanged(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
            DLog.m10773d("ccc", "name:" + sensor.getName() + ",精度： " + i, new Object[0]);
        }
    };

    public interface onSensorChanged {
        void onAccelerationChanged(float f, float f2, float f3);
    }

    public SensorGetter(Context context) {
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
            this.f30199a = sensorManager;
            if (sensorManager != null) {
                this.f30199a.registerListener(this.f30201c, sensorManager.getDefaultSensor(1), 1);
            }
        }
    }

    public void setOnSensorChanged(onSensorChanged onsensorchanged) {
        this.f30200b = onsensorchanged;
    }

    public void destroy() {
        SensorManager sensorManager = this.f30199a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f30201c);
            this.f30199a = null;
        }
        this.f30200b = null;
    }
}
