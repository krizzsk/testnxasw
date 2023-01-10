package com.didi.common.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.didi.security.wireless.ISecurityConf;
import java.util.ArrayList;
import java.util.List;

public class OrientationManager extends OrientationEventListener implements SensorEventListener {

    /* renamed from: a */
    private static OrientationManager f12791a;

    /* renamed from: b */
    private List<OrientationListener> f12792b = new ArrayList();

    /* renamed from: c */
    private int f12793c;

    /* renamed from: d */
    private float f12794d;

    /* renamed from: e */
    private Context f12795e = null;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public static OrientationManager getInstance(Context context) {
        if (f12791a == null) {
            f12791a = new OrientationManager(context.getApplicationContext());
        }
        return f12791a;
    }

    private OrientationManager(Context context) {
        super(context, 3);
        this.f12795e = context;
    }

    public void destroy() {
        this.f12792b.clear();
        try {
            disable();
            SensorManager sensorManager = (SensorManager) this.f12795e.getSystemService(ISecurityConf.KEY_SENSOR);
            if (!sensorManager.getSensorList(3).isEmpty()) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
        this.f12795e = null;
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        if (this.f12792b == null) {
            this.f12792b = new ArrayList();
        }
        if (!this.f12792b.contains(orientationListener)) {
            this.f12792b.add(orientationListener);
            if (this.f12792b.size() == 1) {
                try {
                    enable();
                    SensorManager sensorManager = (SensorManager) this.f12795e.getSystemService(ISecurityConf.KEY_SENSOR);
                    List<Sensor> sensorList = sensorManager.getSensorList(3);
                    if (!sensorList.isEmpty()) {
                        sensorManager.registerListener(this, sensorList.get(0), 2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        if (this.f12792b.contains(orientationListener)) {
            this.f12792b.remove(orientationListener);
            if (this.f12792b.isEmpty()) {
                try {
                    disable();
                    SensorManager sensorManager = (SensorManager) this.f12795e.getSystemService(ISecurityConf.KEY_SENSOR);
                    if (!sensorManager.getSensorList(3).isEmpty()) {
                        sensorManager.unregisterListener(this);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        if (sensorEvent.sensor.getType() == 3) {
            boolean z = false;
            float f2 = sensorEvent.values[0];
            float f3 = sensorEvent.values[1];
            float f4 = sensorEvent.values[2];
            if (f2 != 0.0f) {
                if (Math.abs(this.f12794d - f2) > 30.0f) {
                    this.f12794d = f2;
                    return;
                }
                float f5 = (f2 + this.f12794d) / 2.0f;
                this.f12794d = f5;
                try {
                    if (this.f12795e.getResources().getConfiguration().orientation == 2) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
                int i = this.f12793c;
                if (z) {
                    if (i > 45 && i <= 135) {
                        f = 270.0f;
                    } else if (i > 135 && i <= 225) {
                        f = 180.0f;
                    } else if (i > 225 && i < 315) {
                        f = 90.0f;
                    }
                    f5 = (f5 + f) % 360.0f;
                }
                try {
                    ArrayList<OrientationListener> arrayList = new ArrayList<>();
                    arrayList.addAll(this.f12792b);
                    for (OrientationListener orientationListener : arrayList) {
                        if (orientationListener != null) {
                            orientationListener.onOrientationChanged(f5, f3, f4);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException | OutOfMemoryError unused2) {
                }
            }
        }
    }

    public void onOrientationChanged(int i) {
        if (i >= 0) {
            this.f12793c = i;
        }
    }
}
