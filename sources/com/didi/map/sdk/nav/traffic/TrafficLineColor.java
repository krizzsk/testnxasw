package com.didi.map.sdk.nav.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import com.didi.map.sdk.nav.util.MapLineSegmentorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TrafficLineColor implements ITrafficLine {

    /* renamed from: a */
    private static final String f30949a = "TrafficLine";

    /* renamed from: j */
    private static final int f30950j = 10;

    /* renamed from: k */
    private static final int f30951k = Color.parseColor("#FFAF38");

    /* renamed from: l */
    private static final long f30952l = 500;

    /* renamed from: m */
    private static final int f30953m = 30;

    /* renamed from: b */
    private Map f30954b;

    /* renamed from: c */
    private List<Line> f30955c;

    /* renamed from: d */
    private List<MultiColorLine> f30956d;

    /* renamed from: e */
    private TrafficOptions f30957e;

    /* renamed from: f */
    private TrafficLineAnimatorOptions f30958f;

    /* renamed from: g */
    private List<LatLng> f30959g;

    /* renamed from: h */
    private List<TrafficData> f30960h;

    /* renamed from: i */
    private ValueAnimator f30961i = null;

    /* renamed from: n */
    private int f30962n = 10;

    /* renamed from: o */
    private int f30963o;

    /* renamed from: p */
    private int f30964p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f30965q;

    /* renamed from: r */
    private int f30966r;

    /* renamed from: s */
    private TrafficData f30967s;

    /* renamed from: t */
    private int f30968t;

    /* renamed from: u */
    private int f30969u;

    /* renamed from: v */
    private int f30970v;

    /* renamed from: w */
    private int f30971w;

    /* renamed from: x */
    private Integer f30972x;

    /* renamed from: y */
    private boolean f30973y;

    public TrafficLineColor() {
        int i = f30951k;
        this.f30963o = i;
        this.f30964p = i;
        this.f30968t = 0;
        this.f30969u = 0;
        this.f30970v = 0;
        this.f30971w = 0;
        this.f30972x = 1;
    }

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (this.f30957e == null && m23757a(trafficOptions)) {
            this.f30957e = trafficOptions;
            this.f30968t = trafficOptions.points.size();
            if (this.f30957e.lineWidth > 0) {
                this.f30962n = this.f30957e.lineWidth;
            }
            if (this.f30957e.lineColor != 0) {
                this.f30963o = this.f30957e.lineColor;
            }
            if (this.f30957e.lineMinorColor != 0) {
                this.f30964p = this.f30957e.lineMinorColor;
            } else {
                this.f30964p = this.f30963o;
            }
            this.f30973y = trafficOptions.clickable;
        }
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        if (map != null && this.f30955c == null && m23757a(this.f30957e)) {
            this.f30954b = map;
            this.f30955c = new ArrayList();
            this.f30956d = new ArrayList();
            m23758b();
            m23760c();
            if (trafficLineAnimatorOptions == null || trafficLineAnimatorOptions.duration <= 0) {
                m23753a();
                return;
            }
            this.f30958f = trafficLineAnimatorOptions;
            m23762d();
            m23764e();
        }
    }

    /* renamed from: a */
    private void m23753a() {
        this.f30965q = true;
        for (TrafficData next : this.f30957e.trafficDatas) {
            Line a = m23751a(this.f30957e.points.subList(next.fromIndex, next.toIndex + 1), next.color, this.f30962n);
            if (a != null) {
                this.f30955c.add(a);
                this.f30956d.add(new MultiColorLine(a, next.color, next.minorColor));
            }
        }
        this.f30969u = this.f30955c.size();
        m23770k();
    }

    /* renamed from: b */
    private void m23758b() {
        ArrayList arrayList = new ArrayList();
        int i = this.f30968t - 1;
        int i2 = 0;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30957e.trafficDatas)) {
            for (TrafficData next : this.f30957e.trafficDatas) {
                if (next.toIndex < next.fromIndex) {
                    int i3 = next.fromIndex;
                    next.fromIndex = next.toIndex;
                    next.toIndex = i3;
                }
                if (next.toIndex > i2 && next.fromIndex != next.toIndex && next.fromIndex < i) {
                    if (next.toIndex > i) {
                        next.toIndex = i;
                    }
                    if (next.fromIndex != i2) {
                        if (next.fromIndex < i2) {
                            next.fromIndex = i2;
                            if (next.toIndex - next.fromIndex < 1) {
                            }
                        } else if (next.fromIndex - i2 < 1) {
                            next.fromIndex = i2;
                        } else {
                            TrafficData trafficData = new TrafficData();
                            trafficData.fromIndex = i2;
                            trafficData.toIndex = next.fromIndex;
                            trafficData.color = this.f30963o;
                            trafficData.minorColor = this.f30964p;
                            arrayList.add(trafficData);
                            i2 = trafficData.toIndex;
                        }
                    }
                    if (next.toIndex - next.fromIndex >= 1) {
                        arrayList.add(next);
                        i2 = next.toIndex;
                    }
                }
            }
            if (i > i2) {
                if (i - i2 > 1) {
                    TrafficData trafficData2 = new TrafficData();
                    trafficData2.fromIndex = i2;
                    trafficData2.toIndex = i;
                    trafficData2.color = this.f30963o;
                    trafficData2.minorColor = this.f30964p;
                    arrayList.add(trafficData2);
                } else if (!arrayList.isEmpty()) {
                    ((TrafficData) arrayList.get(arrayList.size() - 1)).toIndex = i;
                }
            }
        } else {
            TrafficData trafficData3 = new TrafficData();
            trafficData3.fromIndex = 0;
            trafficData3.toIndex = i;
            trafficData3.color = this.f30963o;
            trafficData3.minorColor = this.f30964p;
            arrayList.add(trafficData3);
        }
        this.f30957e.trafficDatas = arrayList;
    }

    /* renamed from: c */
    private void m23760c() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = null;
        for (TrafficData next : this.f30957e.trafficDatas) {
            int i = next.toIndex - next.fromIndex;
            if (i > 30) {
                int i2 = i / 30;
                int i3 = i % 30;
                int i4 = next.toIndex;
                for (int i5 = 0; i5 < i2; i5++) {
                    trafficData = new TrafficData();
                    trafficData.fromIndex = next.fromIndex + (i5 * 30);
                    trafficData.toIndex = trafficData.fromIndex + 30;
                    trafficData.color = next.color;
                    trafficData.minorColor = next.minorColor;
                    arrayList.add(trafficData);
                    i4 = trafficData.toIndex;
                }
                if (i3 > 0) {
                    if (i3 < 10) {
                        trafficData.toIndex += i3;
                    } else {
                        trafficData = new TrafficData();
                        trafficData.fromIndex = i4;
                        trafficData.toIndex = trafficData.fromIndex + i3;
                        trafficData.color = next.color;
                        trafficData.minorColor = next.minorColor;
                        arrayList.add(trafficData);
                    }
                }
            } else {
                arrayList.add(next);
            }
        }
        this.f30969u = arrayList.size();
        this.f30957e.trafficDatas = arrayList;
    }

    /* renamed from: d */
    private void m23762d() {
        this.f30959g = new ArrayList();
        this.f30960h = new ArrayList();
        MapLineSegmentorUtil.insertPoints(this.f30957e.points, this.f30959g, this.f30957e.trafficDatas, this.f30960h);
    }

    /* renamed from: a */
    private Line m23751a(List<LatLng> list, int i, int i2) {
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(i);
        lineOptions.width((double) i2);
        lineOptions.setPoints(list);
        lineOptions.clickable(this.f30973y);
        Line addLine = this.f30954b.addLine(lineOptions);
        if (addLine != null) {
            addLine.setLineEndType(0);
        }
        return addLine;
    }

    /* renamed from: e */
    private void m23764e() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f30959g) || CollectionUtil.isEmpty((Collection<?>) this.f30960h)) {
            m23753a();
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f30959g.size()});
        this.f30961i = ofInt;
        long j = 500;
        if (this.f30958f.duration >= 500) {
            j = this.f30958f.duration;
        }
        ofInt.setDuration(j);
        this.f30961i.addUpdateListener(m23765f());
        this.f30961i.setInterpolator(new AccelerateInterpolator());
        this.f30961i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = TrafficLineColor.this.f30965q = true;
                TrafficLineColor.this.m23768i();
            }

            public void onAnimationEnd(Animator animator) {
                TrafficLineColor.this.m23767h();
                TrafficLineColor.this.m23770k();
                TrafficLineColor.this.m23769j();
            }
        });
        this.f30961i.start();
    }

    /* renamed from: f */
    private ValueAnimator.AnimatorUpdateListener m23765f() {
        List<LatLng> list = this.f30959g;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrafficLineColor.this.m23754a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23754a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        int intValue = this.f30972x.intValue();
        while (intValue < num.intValue() && intValue <= i) {
            TrafficData trafficData = this.f30967s;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f30967s.toIndex) {
                TrafficData a = m23752a(intValue);
                this.f30967s = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f30967s.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f30955c.get(this.f30966r).setPoints(subList);
            }
            intValue++;
        }
        this.f30972x = num;
    }

    /* renamed from: g */
    private void m23766g() {
        ValueAnimator valueAnimator = this.f30961i;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f30961i.removeAllListeners();
            this.f30961i.cancel();
            this.f30961i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m23767h() {
        List<Line> list = this.f30955c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f30955c.size(); i++) {
                TrafficData trafficData = this.f30957e.trafficDatas.get(i);
                this.f30955c.get(i).setPoints(this.f30957e.points.subList(trafficData.fromIndex, trafficData.toIndex + 1));
            }
        }
        this.f30959g.clear();
        this.f30960h.clear();
        this.f30969u = this.f30955c.size();
    }

    /* renamed from: a */
    private TrafficData m23752a(int i) {
        int size = this.f30960h.size();
        int i2 = this.f30966r;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f30960h.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f30966r++;
                i2++;
            } else {
                Line a = m23751a(this.f30959g.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.color, this.f30962n);
                if (a != null) {
                    this.f30955c.add(a);
                    this.f30956d.add(new MultiColorLine(a, trafficData.color, trafficData.minorColor));
                    if (this.f30966r < this.f30955c.size()) {
                        return trafficData;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public void erase(int i, LatLng latLng) {
        int i2;
        if (latLng != null && i >= 0 && i >= this.f30971w && i <= this.f30968t - 1 && this.f30969u >= 1 && !this.f30965q) {
            this.f30971w = i;
            TrafficData trafficData = this.f30967s;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f30967s.toIndex) {
                int i3 = 0;
                this.f30967s = null;
                Iterator<TrafficData> it = this.f30957e.trafficDatas.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i3 >= this.f30966r && i >= next.fromIndex && i < next.toIndex) {
                        this.f30967s = next;
                        this.f30966r = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (this.f30967s != null) {
                int i4 = this.f30966r;
                if (i4 > 0 && i4 > (i2 = this.f30970v)) {
                    while (i2 < this.f30969u && i2 < this.f30966r) {
                        this.f30954b.remove(this.f30955c.get(i2));
                        this.f30970v = i2;
                        i2++;
                    }
                }
                int i5 = this.f30966r;
                if (i5 < this.f30969u) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    arrayList.addAll(this.f30957e.points.subList(i + 1, this.f30967s.toIndex + 1));
                    this.f30955c.get(i5).setPoints(arrayList);
                    return;
                }
                return;
            }
            int i6 = this.f30966r;
            if (i6 == this.f30969u - 1) {
                this.f30954b.remove(this.f30955c.get(i6));
                return;
            }
            for (int i7 = this.f30970v; i7 < this.f30969u; i7++) {
                this.f30954b.remove(this.f30955c.get(i7));
            }
        }
    }

    public List<Line> getLines() {
        return this.f30955c;
    }

    /* renamed from: a */
    private boolean m23757a(TrafficOptions trafficOptions) {
        return trafficOptions != null && trafficOptions.available();
    }

    public void remove() {
        List<Line> list;
        m23766g();
        if (this.f30954b != null && (list = this.f30955c) != null) {
            for (Line remove : list) {
                this.f30954b.remove(remove);
            }
            this.f30955c.clear();
            this.f30969u = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m23768i() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f30958f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f30958f.animatorListener.onStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m23769j() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f30958f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f30958f.animatorListener.onEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m23770k() {
        this.f30965q = false;
        this.f30967s = null;
        this.f30966r = 0;
    }

    public void highLight(boolean z) {
        List<MultiColorLine> list = this.f30956d;
        if (list != null) {
            for (MultiColorLine showHighLightColor : list) {
                showHighLightColor.showHighLightColor(z);
            }
        }
    }

    class MultiColorLine {
        int mHighLightColor;
        Line mLine;
        int mMinorColor;

        public MultiColorLine(Line line, int i, int i2) {
            this.mLine = line;
            this.mHighLightColor = i;
            this.mMinorColor = i2;
        }

        public void showHighLightColor(boolean z) {
            if (z) {
                this.mLine.setColor(this.mHighLightColor);
            } else {
                this.mLine.setColor(this.mMinorColor);
            }
        }

        public void setVisible(boolean z) {
            this.mLine.setVisible(z);
        }

        public void setColor(int i) {
            this.mLine.setColor(i);
        }

        public void setZIndex(int i) {
            this.mLine.setZIndex(i);
        }

        public int getZIndex() {
            return this.mLine.getZIndex();
        }
    }
}
