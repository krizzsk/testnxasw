package com.didi.map.global.sdk.movement.sensor;

public class SMAHandler {

    /* renamed from: a */
    private final SMAQueue f30196a;

    /* renamed from: b */
    private final int f30197b;

    public SMAHandler(int i) {
        this.f30197b = i;
        if (i >= 1) {
            this.f30196a = new SMAQueue();
            return;
        }
        throw new IllegalArgumentException("SMA Queue's length < 1");
    }

    public float handleValues(float f) {
        return m23480a(f, this.f30196a);
    }

    public void destroy() {
        this.f30196a.clear();
    }

    /* renamed from: a */
    private float m23480a(float f, SMAQueue sMAQueue) {
        float f2 = 0.0f;
        if (sMAQueue == null) {
            return 0.0f;
        }
        if (sMAQueue.isEmpty()) {
            sMAQueue.enQueue(Float.valueOf(f));
            return f;
        }
        sMAQueue.enQueue(Float.valueOf(f));
        if (sMAQueue.QueueLength() > this.f30197b) {
            sMAQueue.deQueue();
        }
        int QueueLength = sMAQueue.QueueLength();
        for (int i = 0; i < QueueLength; i++) {
            f2 += ((Float) sMAQueue.get(i)).floatValue();
        }
        return f2 / ((float) QueueLength);
    }
}
