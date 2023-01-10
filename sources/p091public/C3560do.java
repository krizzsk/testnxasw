package p091public;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.List;
import p091public.C3563new;

/* renamed from: public.do */
/* compiled from: LivenessSensorDataBuffer */
public class C3560do implements C3563new.C3564do {

    /* renamed from: a */
    private C3561for f8554a = new C3561for();

    /* renamed from: b */
    private Long f8555b;

    /* renamed from: c */
    private final int f8556c;

    /* renamed from: d */
    private final C3565try f8557d;

    /* renamed from: e */
    private final Object f8558e = new Object();

    public C3560do(int i, int i2) {
        this.f8556c = i;
        this.f8557d = new C3565try(i2);
    }

    /* renamed from: a */
    private boolean m7206a() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (this.f8555b == null) {
            this.f8555b = valueOf;
            return true;
        } else if (valueOf.longValue() - this.f8555b.longValue() >= ((long) this.f8556c)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private C3561for m7207b() {
        C3561for forR = this.f8554a;
        this.f8554a = new C3561for();
        return forR;
    }

    /* renamed from: do */
    public List<C3561for> mo43295do() {
        List<C3561for> list;
        synchronized (this.f8558e) {
            list = this.f8557d.mo43310do();
        }
        return list;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        this.f8554a.onAccuracyChanged(sensor, i);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f8554a.onSensorChanged(sensorEvent);
        StringBuilder sb = new StringBuilder();
        sb.append("Sensors ");
        sb.append(sensorEvent.sensor.getName());
        sb.append(" ");
        sb.append(sensorEvent.values.length);
        if (m7206a()) {
            synchronized (this.f8558e) {
                C3561for b = m7207b();
                if (!b.mo43298a()) {
                    this.f8557d.mo43311do(b);
                }
            }
            this.f8555b = Long.valueOf(System.currentTimeMillis());
        }
    }
}
