package com.didi.hawaii.p120ar.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.hawaii.ar.utils.SensorUtil */
public class SensorUtil implements SensorEventListener {
    public static final float MAX_NAVIGATION_ANGLE = 115.0f;
    public static final float MIN_NAVIGATION_ANGLE = 65.0f;

    /* renamed from: b */
    private static SensorUtil f25592b = null;

    /* renamed from: h */
    private static ArrayList<Float> f25593h = null;

    /* renamed from: i */
    private static boolean f25594i = false;
    public static boolean isNavigationPitchAviable = true;

    /* renamed from: j */
    private static int f25595j = 15;

    /* renamed from: k */
    private static final int f25596k = 200;

    /* renamed from: a */
    private float[] f25597a = new float[9];

    /* renamed from: c */
    private SensorManager f25598c;

    /* renamed from: d */
    private Sensor f25599d;

    /* renamed from: e */
    private Sensor f25600e;

    /* renamed from: f */
    private Sensor f25601f;

    /* renamed from: g */
    private boolean f25602g = true;

    /* renamed from: l */
    private float f25603l = -1.0f;

    /* renamed from: m */
    private SensorUtilListener f25604m = null;

    /* renamed from: n */
    private long f25605n = 0;

    /* renamed from: o */
    private PostureChangeListener f25606o;

    /* renamed from: com.didi.hawaii.ar.utils.SensorUtil$PostureChangeListener */
    public interface PostureChangeListener {
        void onPitchAviableChange(boolean z);

        void onStableOrMoveHanppen(boolean z);
    }

    /* renamed from: com.didi.hawaii.ar.utils.SensorUtil$SensorUtilListener */
    public interface SensorUtilListener {
        void onOrientationChanged(float f, float f2, float f3, float[] fArr);
    }

    /* renamed from: a */
    private static float m20391a(float f) {
        return f < 0.0f ? f + 360.0f : f > 360.0f ? f % 360.0f : f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public static synchronized SensorUtil getInstance() {
        SensorUtil sensorUtil;
        synchronized (SensorUtil.class) {
            if (f25592b == null) {
                f25592b = new SensorUtil();
            }
            sensorUtil = f25592b;
        }
        return sensorUtil;
    }

    public void init(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.f25598c = sensorManager;
        this.f25599d = sensorManager.getDefaultSensor(11);
        this.f25600e = this.f25598c.getDefaultSensor(3);
        this.f25601f = this.f25598c.getDefaultSensor(6);
    }

    public void startListenRotationVector() {
        Sensor sensor = this.f25599d;
        if (sensor != null) {
            this.f25598c.registerListener(this, sensor, 3);
        }
        Sensor sensor2 = this.f25600e;
        if (sensor2 != null) {
            this.f25598c.registerListener(this, sensor2, 3);
        }
        Sensor sensor3 = this.f25601f;
        if (sensor3 != null) {
            this.f25598c.registerListener(this, sensor3, 200000);
        }
    }

    public void stopListenRotationVector() {
        this.f25598c.unregisterListener(this);
    }

    public void startZGSensor(SensorUtilListener sensorUtilListener) {
        this.f25604m = sensorUtilListener;
        Sensor sensor = this.f25599d;
        if (sensor != null) {
            this.f25598c.registerListener(this, sensor, 1);
        }
    }

    public void stopZGSensor() {
        Sensor sensor = this.f25599d;
        if (sensor != null) {
            this.f25598c.unregisterListener(this, sensor);
        }
        this.f25604m = null;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            SensorManager.getRotationMatrixFromVector(this.f25597a, sensorEvent.values);
            if (this.f25604m != null) {
                float[] fArr = new float[4];
                SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(this.f25597a, fArr2);
                float degrees = (float) Math.toDegrees((double) fArr2[0]);
                float[] fArr3 = {fArr[1], fArr[2], fArr[3], fArr[0]};
                this.f25604m.onOrientationChanged((float) Math.toDegrees((double) fArr2[1]), (float) Math.toDegrees((double) fArr2[2]), degrees, fArr3);
            }
        } else if (sensorEvent.sensor.getType() == 3) {
            if ((sensorEvent.values[1] < (-ARNavGlobal.locationParam.maxAngle) || sensorEvent.values[1] > (-ARNavGlobal.locationParam.minAngle)) && (sensorEvent.values[1] < ARNavGlobal.locationParam.maxAngle || sensorEvent.values[1] > ARNavGlobal.locationParam.minAngle)) {
                this.f25602g = false;
            } else {
                this.f25602g = true;
            }
            if ((sensorEvent.values[1] < -115.0f || sensorEvent.values[1] > -65.0f) && (sensorEvent.values[1] < 115.0f || sensorEvent.values[1] > 65.0f)) {
                isNavigationPitchAviable = false;
            } else {
                isNavigationPitchAviable = true;
            }
            PostureChangeListener postureChangeListener = this.f25606o;
            if (postureChangeListener != null) {
                postureChangeListener.onPitchAviableChange(this.f25602g);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f25605n >= 200) {
                if (f25594i) {
                    f25593h.add(Float.valueOf(sensorEvent.values[0]));
                    if (f25593h.size() > f25595j) {
                        f25593h.remove(0);
                        m20392a();
                    }
                }
                this.f25605n = currentTimeMillis;
            }
        } else if (sensorEvent.sensor.getType() == 6) {
            this.f25603l = sensorEvent.values[0];
        }
    }

    public float[] getRotationMatrix3D() {
        return this.f25597a;
    }

    public float GetPressureData() {
        return this.f25603l;
    }

    public void setPostureChangeListener(PostureChangeListener postureChangeListener) {
        this.f25606o = postureChangeListener;
    }

    public void startMoveStatusCheck() {
        ArrayList<Float> arrayList = f25593h;
        if (arrayList != null) {
            arrayList.clear();
        }
        f25595j = (ARNavGlobal.locationParam.maxMotionlessTime * 1000) / 200;
        f25593h = new ArrayList<>(f25595j + 1);
        f25594i = true;
    }

    /* renamed from: a */
    private void m20392a() {
        float f = ARNavGlobal.locationParam.maxMotionlessAngle;
        boolean z = false;
        float floatValue = f25593h.get(0).floatValue() - f;
        float floatValue2 = f25593h.get(0).floatValue() + f;
        Iterator<Float> it = f25593h.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (m20393a(it.next().floatValue(), floatValue, floatValue2)) {
                i++;
            }
        }
        if (i < f25593h.size()) {
            z = true;
        }
        PostureChangeListener postureChangeListener = this.f25606o;
        if (postureChangeListener != null) {
            postureChangeListener.onStableOrMoveHanppen(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m20393a(float r2, float r3, float r4) {
        /*
            float r2 = m20391a(r2)
            float r3 = m20391a(r3)
            float r4 = m20391a(r4)
            r0 = 1
            int r1 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x001a
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x001a:
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            r3 = 1135869952(0x43b40000, float:360.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002f
        L_0x0024:
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.utils.SensorUtil.m20393a(float, float, float):boolean");
    }
}
