package com.didi.global.fintech.cashier.p118ui.widget.tickerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerCharacterList;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerColumn */
public class TickerColumn {

    /* renamed from: a */
    private TickerCharacterList[] f23878a;

    /* renamed from: b */
    private final TickerDrawMetrics f23879b;

    /* renamed from: c */
    private char f23880c = 0;

    /* renamed from: d */
    private char f23881d = 0;

    /* renamed from: e */
    private char[] f23882e;

    /* renamed from: f */
    private int f23883f;

    /* renamed from: g */
    private int f23884g;

    /* renamed from: h */
    private int f23885h;

    /* renamed from: i */
    private float f23886i;

    /* renamed from: j */
    private float f23887j;

    /* renamed from: k */
    private float f23888k;

    /* renamed from: l */
    private float f23889l;

    /* renamed from: m */
    private float f23890m;

    /* renamed from: n */
    private float f23891n;

    /* renamed from: o */
    private float f23892o;

    /* renamed from: p */
    private float f23893p;

    /* renamed from: q */
    private int f23894q;

    TickerColumn(TickerCharacterList[] tickerCharacterListArr, TickerDrawMetrics tickerDrawMetrics) {
        this.f23878a = tickerCharacterListArr;
        this.f23879b = tickerDrawMetrics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71425a(TickerCharacterList[] tickerCharacterListArr) {
        this.f23878a = tickerCharacterListArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71422a(char c) {
        this.f23881d = c;
        this.f23888k = this.f23889l;
        float a = this.f23879b.mo71439a(c);
        this.f23890m = a;
        this.f23891n = Math.max(this.f23888k, a);
        m19348f();
        int i = 1;
        if (!(this.f23884g >= this.f23883f)) {
            i = -1;
        }
        this.f23894q = i;
        this.f23893p = this.f23892o;
        this.f23892o = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public char mo71421a() {
        return this.f23880c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public char mo71426b() {
        return this.f23881d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo71427c() {
        m19349g();
        return this.f23889l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo71428d() {
        m19349g();
        return this.f23891n;
    }

    /* renamed from: f */
    private void m19348f() {
        this.f23882e = null;
        for (TickerCharacterList tickerCharacterList : this.f23878a) {
            TickerCharacterList.CharacterIndices a = tickerCharacterList.mo71418a(this.f23880c, this.f23881d, this.f23879b.mo71444d());
            if (a != null) {
                this.f23882e = tickerCharacterList.mo71420b();
                this.f23883f = a.startIndex;
                this.f23884g = a.endIndex;
            }
        }
        if (this.f23882e == null) {
            char c = this.f23880c;
            char c2 = this.f23881d;
            if (c == c2) {
                this.f23882e = new char[]{c};
                this.f23884g = 0;
                this.f23883f = 0;
                return;
            }
            this.f23882e = new char[]{c, c2};
            this.f23883f = 0;
            this.f23884g = 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo71429e() {
        m19349g();
        this.f23891n = this.f23889l;
    }

    /* renamed from: g */
    private void m19349g() {
        float a = this.f23879b.mo71439a(this.f23881d);
        float f = this.f23889l;
        float f2 = this.f23890m;
        if (f == f2 && f2 != a) {
            this.f23890m = a;
            this.f23889l = a;
            this.f23891n = a;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71423a(float f) {
        if (f == 1.0f) {
            this.f23880c = this.f23881d;
            this.f23892o = 0.0f;
            this.f23893p = 0.0f;
        }
        float b = this.f23879b.mo71442b();
        float abs = ((((float) Math.abs(this.f23884g - this.f23883f)) * b) * f) / b;
        int i = (int) abs;
        float f2 = this.f23893p * (1.0f - f);
        int i2 = this.f23894q;
        this.f23886i = ((abs - ((float) i)) * b * ((float) i2)) + f2;
        this.f23885h = this.f23883f + (i * i2);
        this.f23887j = b;
        float f3 = this.f23888k;
        this.f23889l = f3 + ((this.f23890m - f3) * f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71424a(Canvas canvas, Paint paint) {
        if (m19347a(canvas, paint, this.f23882e, this.f23885h, this.f23886i)) {
            int i = this.f23885h;
            if (i >= 0) {
                this.f23880c = this.f23882e[i];
            }
            this.f23892o = this.f23886i;
        }
        m19347a(canvas, paint, this.f23882e, this.f23885h + 1, this.f23886i - this.f23887j);
        m19347a(canvas, paint, this.f23882e, this.f23885h - 1, this.f23886i + this.f23887j);
    }

    /* renamed from: a */
    private boolean m19347a(Canvas canvas, Paint paint, char[] cArr, int i, float f) {
        if (i < 0 || i >= cArr.length) {
            return false;
        }
        canvas.drawText(cArr, i, 1, 0.0f, f, paint);
        return true;
    }
}
