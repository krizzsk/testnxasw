package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C20759const;
import java.util.List;
import p235do.C21825goto;
import p237final.C21836if;

/* renamed from: com.iproov.sdk.core.goto */
/* compiled from: IProovCameraZoomSelector */
public class C20872goto implements C21825goto {

    /* renamed from: a */
    private final C21836if f57103a;

    /* renamed from: b */
    private Double f57104b;

    C20872goto(C21836if ifVar) {
        this.f57103a = ifVar;
    }

    /* renamed from: a */
    private double m43292a(C20759const constR, Float f, Double d) {
        this.f57104b = d;
        String.format("Zoom Selector (%s) zoom factor as %.1f given focal length of %.1f", new Object[]{constR, d, f});
        return d.doubleValue();
    }

    /* renamed from: a */
    private Double m43293a(C20759const constR, Float f) {
        if (this.f57103a.m48242for() == null) {
            return Double.valueOf(1.0d);
        }
        String.format("Zoom Selector has zoom factor provided by device profile as %.1f", new Object[]{this.f57103a.m48242for()});
        return this.f57103a.m48242for();
    }

    /* renamed from: do */
    public synchronized Double mo171494do() {
        return this.f57104b;
    }

    /* renamed from: do */
    public synchronized double mo171492do(C20759const constR, Float f) {
        if (this.f57104b == null) {
            Double a = m43293a(constR, f);
            this.f57104b = a;
            m43292a(constR, f, a);
        }
        return this.f57104b.doubleValue();
    }

    /* renamed from: do */
    public synchronized int mo171493do(C20759const constR, Float f, List<Integer> list) {
        int doubleValue = (int) (m43293a(constR, f).doubleValue() * 100.0d);
        int i = 0;
        while (i < list.size()) {
            Integer num = list.get(i);
            if (num == null || num.intValue() < doubleValue) {
                i++;
            } else {
                m43292a(constR, f, Double.valueOf(Double.valueOf((double) num.intValue()).doubleValue() / 100.0d));
                return i;
            }
        }
        m43292a(constR, f, (Double) null);
        return -1;
    }
}
