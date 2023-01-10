package p091public;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.didi.security.wireless.ISecurityConf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: public.new */
/* compiled from: SensorDataManager */
public class C3563new implements SensorEventListener {

    /* renamed from: a */
    private static final String f8567a = C3563new.class.getSimpleName();

    /* renamed from: b */
    private static final int[] f8568b = {1, 10, 4, 9, 11};

    /* renamed from: c */
    private final Map<Integer, Boolean> f8569c = new HashMap();

    /* renamed from: d */
    private final HandlerThread f8570d;

    /* renamed from: e */
    private final Handler f8571e;

    /* renamed from: f */
    private volatile boolean f8572f;

    /* renamed from: g */
    private final SensorManager f8573g;

    /* renamed from: h */
    private C3564do f8574h;

    /* renamed from: public.new$do */
    /* compiled from: SensorDataManager */
    public interface C3564do {
        void onAccuracyChanged(Sensor sensor, int i);

        void onSensorChanged(SensorEvent sensorEvent);
    }

    public C3563new(Context context) throws C3562if {
        HandlerThread handlerThread = new HandlerThread("Sensor Data Manager");
        this.f8570d = handlerThread;
        this.f8572f = false;
        this.f8574h = null;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
        this.f8573g = sensorManager;
        if (sensorManager != null) {
            handlerThread.start();
            this.f8571e = new Handler(handlerThread.getLooper());
            m7213a();
            return;
        }
        throw new C3562if();
    }

    /* renamed from: a */
    private void m7213a() {
        for (int i : f8568b) {
            Sensor defaultSensor = this.f8573g.getDefaultSensor(i);
            if (defaultSensor != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Sensors ");
                sb.append(i);
                sb.append(" ");
                sb.append(defaultSensor.getName());
                this.f8569c.put(Integer.valueOf(i), Boolean.valueOf(this.f8573g.registerListener(this, defaultSensor, 100000, this.f8571e)));
            }
        }
    }

    /* renamed from: do */
    public static JSONArray m7214do(List<C3561for> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (C3561for b : list) {
                jSONArray.put(b.mo43299b());
            }
        }
        return jSONArray;
    }

    /* renamed from: case  reason: not valid java name */
    public synchronized void m46644case() {
        this.f8573g.unregisterListener(this);
        this.f8570d.quit();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46645for() {
        for (Sensor next : this.f8573g.getSensorList(-1)) {
            String.format("Available Sensors [%s] Type = %s ON = %s", new Object[]{next.getName(), Integer.valueOf(next.getType()), this.f8569c.get(Integer.valueOf(next.getType()))});
        }
    }

    /* renamed from: if */
    public boolean mo43306if() {
        Boolean bool = this.f8569c.get(1);
        Boolean bool2 = Boolean.TRUE;
        if (bool == bool2 || this.f8569c.get(10) == bool2) {
            return true;
        }
        return false;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        C3564do doVar = this.f8574h;
        if (doVar != null) {
            doVar.onAccuracyChanged(sensor, i);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        C3564do doVar;
        if (this.f8572f && (doVar = this.f8574h) != null) {
            doVar.onSensorChanged(sensorEvent);
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m46646try() {
        this.f8572f = true;
    }

    /* renamed from: do */
    public Map<Integer, Boolean> mo43303do() {
        return this.f8569c;
    }

    /* renamed from: do */
    public void mo43304do(C3564do doVar) {
        this.f8574h = doVar;
    }
}
