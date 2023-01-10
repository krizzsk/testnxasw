package com.didi.onehybrid.log.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;

public class ShakeUtils implements SensorEventListener {

    /* renamed from: d */
    private static final int f32121d = 30;

    /* renamed from: a */
    int f32122a = 0;

    /* renamed from: b */
    private SensorManager f32123b = null;

    /* renamed from: c */
    private OnShakeListener f32124c = null;

    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public ShakeUtils(Context context) {
        if (context != null) {
            this.f32123b = (SensorManager) context.getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.f32124c = onShakeListener;
    }

    public void onStart() {
        SensorManager sensorManager = this.f32123b;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
        }
    }

    public void onStop() {
        SensorManager sensorManager = this.f32123b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (type != 1) {
            return;
        }
        if (Math.abs(fArr[0]) > 30.0f || Math.abs(fArr[1]) > 30.0f || Math.abs(fArr[2]) > 30.0f) {
            this.f32122a++;
            System.out.println("sensor value ==  " + fArr[0] + " " + fArr[1] + " " + fArr[2]);
            OnShakeListener onShakeListener = this.f32124c;
            if (onShakeListener != null && this.f32122a >= 4) {
                this.f32122a = 0;
                onShakeListener.onShake();
            }
        }
    }
}
