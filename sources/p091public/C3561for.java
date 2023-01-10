package p091public;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.domainservice.utils.DomainConstants;
import org.json.JSONObject;
import p095switch.C3658case;
import p095switch.C3680try;

/* renamed from: public.for */
/* compiled from: SensorData */
public class C3561for implements SensorEventListener {

    /* renamed from: a */
    private float[] f8559a = m7210c();

    /* renamed from: b */
    private float[] f8560b = m7210c();

    /* renamed from: c */
    private float[] f8561c = m7210c();

    /* renamed from: d */
    private float[] f8562d = m7210c();

    /* renamed from: e */
    private float[] f8563e = m7210c();

    /* renamed from: f */
    private Long f8564f;

    /* renamed from: g */
    private Long f8565g;

    /* renamed from: h */
    private boolean f8566h = true;

    /* renamed from: c */
    private static float[] m7210c() {
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo43298a() {
        return this.f8566h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo43299b() {
        JSONObject jSONObject = new JSONObject();
        C3680try.m7470do(jSONObject, "r", (Object) C3680try.m7467do(this.f8563e));
        C3680try.m7470do(jSONObject, Constants.FILE_ANR_KEY, (Object) C3680try.m7467do(this.f8561c));
        C3680try.m7470do(jSONObject, "ag", (Object) C3680try.m7467do(this.f8562d));
        C3680try.m7470do(jSONObject, DomainConstants.DOMAIN_SUFFIX_G, (Object) C3680try.m7467do(this.f8559a));
        C3680try.m7470do(jSONObject, RavenConfigKey.PHONE, (Object) C3680try.m7467do(this.f8560b));
        C3680try.m7470do(jSONObject, "t0", (Object) this.f8564f);
        C3680try.m7470do(jSONObject, RavenKey.TYPE, (Object) this.f8565g);
        return jSONObject;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Long valueOf = Long.valueOf(sensorEvent.timestamp);
        this.f8565g = valueOf;
        if (this.f8564f == null) {
            this.f8564f = valueOf;
        }
        int type = sensorEvent.sensor.getType();
        this.f8566h = false;
        if (type == 1) {
            this.f8562d = m7209a(sensorEvent.values);
        } else if (type != 4) {
            switch (type) {
                case 9:
                    this.f8559a = m7209a(sensorEvent.values);
                    return;
                case 10:
                    this.f8561c = m7209a(sensorEvent.values);
                    return;
                case 11:
                    this.f8560b = C3658case.m7401do(sensorEvent.values);
                    return;
                default:
                    return;
            }
        } else {
            float[] fArr = sensorEvent.values;
            float[] fArr2 = new float[fArr.length];
            this.f8563e = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        }
    }

    /* renamed from: a */
    private float[] m7209a(float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i] / 9.81f;
        }
        return fArr2;
    }
}
