package com.didi.global.fintech.cashier.p118ui.widget.tickerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerColumnManager */
public class TickerColumnManager {

    /* renamed from: a */
    final ArrayList<TickerColumn> f23895a = new ArrayList<>();

    /* renamed from: b */
    private final TickerDrawMetrics f23896b;

    /* renamed from: c */
    private TickerCharacterList[] f23897c;

    /* renamed from: d */
    private Set<Character> f23898d;

    TickerColumnManager(TickerDrawMetrics tickerDrawMetrics) {
        this.f23896b = tickerDrawMetrics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71433a(String... strArr) {
        this.f23897c = new TickerCharacterList[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.f23897c[i] = new TickerCharacterList(strArr[i]);
        }
        this.f23898d = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.f23898d.addAll(this.f23897c[i2].mo71419a());
        }
        Iterator<TickerColumn> it = this.f23895a.iterator();
        while (it.hasNext()) {
            it.next().mo71425a(this.f23897c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TickerCharacterList[] mo71434a() {
        return this.f23897c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71432a(char[] cArr) {
        if (this.f23897c != null) {
            int i = 0;
            while (i < this.f23895a.size()) {
                if (this.f23895a.get(i).mo71427c() > 0.0f) {
                    i++;
                } else {
                    this.f23895a.remove(i);
                }
            }
            int[] computeColumnActions = LevenshteinUtils.computeColumnActions(mo71438e(), cArr, this.f23898d);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < computeColumnActions.length; i4++) {
                int i5 = computeColumnActions[i4];
                if (i5 != 0) {
                    if (i5 == 1) {
                        this.f23895a.add(i2, new TickerColumn(this.f23897c, this.f23896b));
                    } else if (i5 == 2) {
                        this.f23895a.get(i2).mo71422a(0);
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Unknown action: " + computeColumnActions[i4]);
                    }
                }
                this.f23895a.get(i2).mo71422a(cArr[i3]);
                i2++;
                i3++;
            }
            return;
        }
        throw new IllegalStateException("Need to call #setCharacterLists first.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71435b() {
        int size = this.f23895a.size();
        for (int i = 0; i < size; i++) {
            this.f23895a.get(i).mo71429e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71430a(float f) {
        int size = this.f23895a.size();
        for (int i = 0; i < size; i++) {
            this.f23895a.get(i).mo71423a(f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo71436c() {
        int size = this.f23895a.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += this.f23895a.get(i).mo71428d();
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo71437d() {
        int size = this.f23895a.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += this.f23895a.get(i).mo71427c();
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public char[] mo71438e() {
        int size = this.f23895a.size();
        char[] cArr = new char[size];
        for (int i = 0; i < size; i++) {
            cArr[i] = this.f23895a.get(i).mo71421a();
        }
        return cArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71431a(Canvas canvas, Paint paint) {
        int size = this.f23895a.size();
        for (int i = 0; i < size; i++) {
            TickerColumn tickerColumn = this.f23895a.get(i);
            tickerColumn.mo71424a(canvas, paint);
            canvas.translate(tickerColumn.mo71427c(), 0.0f);
        }
    }
}
