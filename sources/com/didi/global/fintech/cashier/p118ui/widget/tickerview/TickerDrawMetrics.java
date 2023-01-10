package com.didi.global.fintech.cashier.p118ui.widget.tickerview;

import android.graphics.Paint;
import com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerDrawMetrics */
public class TickerDrawMetrics {

    /* renamed from: a */
    private final Paint f23899a;

    /* renamed from: b */
    private final Map<Character, Float> f23900b = new HashMap(256);

    /* renamed from: c */
    private float f23901c;

    /* renamed from: d */
    private float f23902d;

    /* renamed from: e */
    private TickerView.ScrollingDirection f23903e = TickerView.ScrollingDirection.ANY;

    TickerDrawMetrics(Paint paint) {
        this.f23899a = paint;
        mo71440a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71440a() {
        this.f23900b.clear();
        Paint.FontMetrics fontMetrics = this.f23899a.getFontMetrics();
        this.f23901c = fontMetrics.bottom - fontMetrics.top;
        this.f23902d = -fontMetrics.top;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo71439a(char c) {
        if (c == 0) {
            return 0.0f;
        }
        Float f = this.f23900b.get(Character.valueOf(c));
        if (f != null) {
            return f.floatValue();
        }
        float measureText = this.f23899a.measureText(Character.toString(c));
        this.f23900b.put(Character.valueOf(c), Float.valueOf(measureText));
        return measureText;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo71442b() {
        return this.f23901c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo71443c() {
        return this.f23902d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TickerView.ScrollingDirection mo71444d() {
        return this.f23903e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71441a(TickerView.ScrollingDirection scrollingDirection) {
        this.f23903e = scrollingDirection;
    }
}
