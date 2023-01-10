package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: com.yanzhenjie.permission.checker.m */
/* compiled from: SensorsTest */
class C21704m implements PermissionTest {

    /* renamed from: b */
    private static final SensorEventListener f58960b = new SensorsTest$1();

    /* renamed from: a */
    private Context f58961a;

    C21704m(Context context) {
        this.f58961a = context;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f58961a.getSystemService(ISecurityConf.KEY_SENSOR);
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(21);
            sensorManager.registerListener(f58960b, defaultSensor, 3);
            sensorManager.unregisterListener(f58960b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f58961a.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate");
        }
    }
}
