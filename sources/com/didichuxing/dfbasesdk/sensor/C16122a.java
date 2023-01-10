package com.didichuxing.dfbasesdk.sensor;

import com.didichuxing.dfbasesdk.sensor.SensorData;

/* renamed from: com.didichuxing.dfbasesdk.sensor.a */
/* compiled from: SamplePool */
class C16122a {

    /* renamed from: a */
    static SensorData.Sample[] f49325a = new SensorData.Sample[11];

    C16122a() {
    }

    /* renamed from: a */
    static SensorData.Sample m37001a(int i) {
        if (i >= f49325a.length) {
            return m37003b(i);
        }
        int max = Math.max(i, 0);
        SensorData.Sample[] sampleArr = f49325a;
        SensorData.Sample sample = sampleArr[max];
        if (sample == null) {
            return m37003b(i);
        }
        sampleArr[max] = sample.next;
        sample.next = null;
        return sample;
    }

    /* renamed from: a */
    static void m37002a(SensorData.Sample sample) {
        if (sample != null) {
            int length = sample.values != null ? sample.values.length : 0;
            SensorData.Sample[] sampleArr = f49325a;
            if (length < sampleArr.length) {
                SensorData.Sample sample2 = sampleArr[length];
                if (sample2 != null) {
                    sample.next = sample2;
                }
                f49325a[length] = sample;
            }
        }
    }

    /* renamed from: b */
    private static SensorData.Sample m37003b(int i) {
        SensorData.Sample sample = new SensorData.Sample();
        if (i > 0) {
            sample.values = new float[i];
        }
        return sample;
    }
}
