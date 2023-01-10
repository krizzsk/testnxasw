package p097throw;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: throw.do */
/* compiled from: LightSensor */
public class C3686do implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f8817a;

    /* renamed from: b */
    private final Sensor f8818b;

    /* renamed from: c */
    private float f8819c = -1.0f;

    public C3686do(Context context) throws C3687if {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.f8817a = sensorManager;
        if (sensorManager != null) {
            this.f8818b = sensorManager.getDefaultSensor(5);
            return;
        }
        throw new C3687if();
    }

    /* renamed from: do */
    public void mo43529do() {
        this.f8817a.unregisterListener(this, this.f8818b);
    }

    /* renamed from: for  reason: not valid java name */
    public void m46679for() {
        this.f8817a.registerListener(this, this.f8818b, 3);
    }

    /* renamed from: if */
    public synchronized float mo43531if() {
        return this.f8819c;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public synchronized void onSensorChanged(SensorEvent sensorEvent) {
        this.f8819c = sensorEvent.values[0];
    }
}
