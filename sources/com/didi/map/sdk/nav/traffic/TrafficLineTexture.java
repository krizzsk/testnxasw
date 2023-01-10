package com.didi.map.sdk.nav.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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

public class TrafficLineTexture implements ITrafficLine {

    /* renamed from: a */
    private static final String f30974a = "TrafficLine";

    /* renamed from: j */
    private static final int f30975j = 10;

    /* renamed from: k */
    private static final int f30976k = 1;

    /* renamed from: l */
    private static final long f30977l = 500;

    /* renamed from: b */
    private Map f30978b;

    /* renamed from: c */
    private List<Line> f30979c;

    /* renamed from: d */
    private List<MultiTextureLine> f30980d;

    /* renamed from: e */
    private TrafficOptions f30981e;

    /* renamed from: f */
    private TrafficLineAnimatorOptions f30982f;

    /* renamed from: g */
    private List<LatLng> f30983g;

    /* renamed from: h */
    private List<TrafficData> f30984h;

    /* renamed from: i */
    private ValueAnimator f30985i = null;

    /* renamed from: m */
    private int f30986m = 10;

    /* renamed from: n */
    private int f30987n = 1;

    /* renamed from: o */
    private int f30988o = 1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f30989p;

    /* renamed from: q */
    private int f30990q;

    /* renamed from: r */
    private TrafficData f30991r;

    /* renamed from: s */
    private int f30992s = 0;

    /* renamed from: t */
    private int f30993t = 0;

    /* renamed from: u */
    private int f30994u = 0;

    /* renamed from: v */
    private int f30995v = 0;

    /* renamed from: w */
    private Integer f30996w = 1;

    /* renamed from: x */
    private boolean f30997x;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (this.f30981e == null && m23777a(trafficOptions)) {
            this.f30981e = trafficOptions;
            this.f30992s = trafficOptions.points.size();
            if (this.f30981e.lineWidth > 0) {
                this.f30986m = this.f30981e.lineWidth;
            }
            if (this.f30981e.lineTextureIndex != -1) {
                this.f30987n = this.f30981e.lineTextureIndex;
            }
            if (this.f30981e.lineMinorTextureIndex != -1) {
                this.f30988o = this.f30981e.lineMinorTextureIndex;
            } else {
                this.f30988o = this.f30987n;
            }
            this.f30997x = trafficOptions.clickable;
        }
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        if (map != null && this.f30979c == null && m23777a(this.f30981e)) {
            this.f30978b = map;
            this.f30979c = new ArrayList();
            this.f30980d = new ArrayList();
            m23778b();
            if (trafficLineAnimatorOptions == null || trafficLineAnimatorOptions.duration <= 0) {
                m23773a();
                return;
            }
            this.f30982f = trafficLineAnimatorOptions;
            m23780c();
            m23782d();
        }
    }

    /* renamed from: a */
    private void m23773a() {
        this.f30989p = true;
        for (TrafficData next : this.f30981e.trafficDatas) {
            Line a = m23771a(this.f30981e.points.subList(next.fromIndex, next.toIndex + 1), next.textureIndex, this.f30986m);
            if (a != null) {
                this.f30979c.add(a);
                this.f30980d.add(new MultiTextureLine(a, next.textureIndex, next.minorTextureIndex));
            }
        }
        this.f30993t = this.f30979c.size();
        m23789j();
    }

    /* renamed from: b */
    private void m23778b() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = new TrafficData();
        trafficData.fromIndex = 0;
        trafficData.toIndex = this.f30992s - 1;
        trafficData.textureIndex = this.f30987n;
        trafficData.minorTextureIndex = this.f30988o;
        arrayList.add(trafficData);
        this.f30981e.trafficDatas = arrayList;
    }

    /* renamed from: c */
    private void m23780c() {
        this.f30983g = new ArrayList();
        this.f30984h = new ArrayList();
        MapLineSegmentorUtil.insertPoints(this.f30981e.points, this.f30983g, this.f30981e.trafficDatas, this.f30984h);
    }

    /* renamed from: a */
    private Line m23771a(List<LatLng> list, int i, int i2) {
        LineOptions lineOptions = new LineOptions();
        lineOptions.type(7);
        lineOptions.add(list);
        lineOptions.width((double) i2);
        lineOptions.lineEndType(1);
        lineOptions.clickable(this.f30997x);
        LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = {new LineOptions.MultiColorLineInfo()};
        multiColorLineInfoArr[0].pointIndex = 0;
        multiColorLineInfoArr[0].colorIndex = i;
        lineOptions.multiColorLineInfo(multiColorLineInfoArr);
        Line addLine = this.f30978b.addLine(lineOptions);
        addLine.setNaviRouteLineErase(true);
        return addLine;
    }

    /* renamed from: d */
    private void m23782d() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f30983g) || CollectionUtil.isEmpty((Collection<?>) this.f30984h)) {
            m23773a();
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f30983g.size()});
        this.f30985i = ofInt;
        long j = 500;
        if (this.f30982f.duration >= 500) {
            j = this.f30982f.duration;
        }
        ofInt.setDuration(j);
        this.f30985i.addUpdateListener(m23784e());
        this.f30985i.setInterpolator(new AccelerateInterpolator());
        this.f30985i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = TrafficLineTexture.this.f30989p = true;
                TrafficLineTexture.this.m23787h();
            }

            public void onAnimationEnd(Animator animator) {
                TrafficLineTexture.this.m23786g();
                TrafficLineTexture.this.m23789j();
                TrafficLineTexture.this.m23788i();
            }
        });
        this.f30985i.start();
    }

    /* renamed from: e */
    private ValueAnimator.AnimatorUpdateListener m23784e() {
        List<LatLng> list = this.f30983g;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrafficLineTexture.this.m23774a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23774a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        int intValue = this.f30996w.intValue();
        while (intValue < num.intValue() && intValue <= i) {
            TrafficData trafficData = this.f30991r;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f30991r.toIndex) {
                TrafficData a = m23772a(intValue);
                this.f30991r = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f30991r.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f30979c.get(this.f30990q).setPoints(subList);
            }
            intValue++;
        }
        this.f30996w = num;
    }

    /* renamed from: f */
    private void m23785f() {
        ValueAnimator valueAnimator = this.f30985i;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f30985i.removeAllListeners();
            this.f30985i.cancel();
            this.f30985i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m23786g() {
        List<Line> list = this.f30979c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f30979c.size(); i++) {
                TrafficData trafficData = this.f30981e.trafficDatas.get(i);
                this.f30979c.get(i).setPoints(this.f30981e.points.subList(trafficData.fromIndex, trafficData.toIndex + 1));
            }
        }
        this.f30983g.clear();
        this.f30984h.clear();
        this.f30993t = this.f30979c.size();
    }

    /* renamed from: a */
    private TrafficData m23772a(int i) {
        int size = this.f30984h.size();
        int i2 = this.f30990q;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f30984h.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f30990q++;
                i2++;
            } else {
                Line a = m23771a(this.f30983g.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.textureIndex, this.f30986m);
                if (a != null) {
                    this.f30979c.add(a);
                    this.f30980d.add(new MultiTextureLine(a, trafficData.textureIndex, trafficData.minorTextureIndex));
                    if (this.f30990q < this.f30979c.size()) {
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
        if (latLng != null && i >= 0 && i >= this.f30995v && i <= this.f30992s - 1 && this.f30993t >= 1 && !this.f30989p) {
            this.f30995v = i;
            TrafficData trafficData = this.f30991r;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f30991r.toIndex) {
                int i3 = 0;
                this.f30991r = null;
                Iterator<TrafficData> it = this.f30981e.trafficDatas.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i3 >= this.f30990q && i >= next.fromIndex && i < next.toIndex) {
                        this.f30991r = next;
                        this.f30990q = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (this.f30991r != null) {
                int i4 = this.f30990q;
                if (i4 > 0 && i4 > (i2 = this.f30994u)) {
                    while (i2 < this.f30993t && i2 < this.f30990q) {
                        this.f30978b.remove(this.f30979c.get(i2));
                        this.f30994u = i2;
                        i2++;
                    }
                }
                int i5 = this.f30990q;
                if (i5 < this.f30993t) {
                    Line line = this.f30979c.get(i5);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    arrayList.addAll(this.f30981e.points.subList(i + 1, this.f30991r.toIndex + 1));
                    line.setPoints(arrayList);
                    line.setMultiColorLineInfo(line.getMultiColorLineInfo());
                    return;
                }
                return;
            }
            int i6 = this.f30990q;
            if (i6 == this.f30993t - 1) {
                this.f30978b.remove(this.f30979c.get(i6));
                return;
            }
            for (int i7 = this.f30994u; i7 < this.f30993t; i7++) {
                this.f30978b.remove(this.f30979c.get(i7));
            }
        }
    }

    public List<Line> getLines() {
        return this.f30979c;
    }

    /* renamed from: a */
    private boolean m23777a(TrafficOptions trafficOptions) {
        return trafficOptions != null && trafficOptions.available();
    }

    public void remove() {
        List<Line> list;
        m23785f();
        if (this.f30978b != null && (list = this.f30979c) != null) {
            for (Line remove : list) {
                this.f30978b.remove(remove);
            }
            this.f30979c.clear();
            this.f30993t = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m23787h() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f30982f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f30982f.animatorListener.onStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m23788i() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f30982f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f30982f.animatorListener.onEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m23789j() {
        this.f30989p = false;
        this.f30991r = null;
        this.f30990q = 0;
    }

    public void highLight(boolean z) {
        List<MultiTextureLine> list = this.f30980d;
        if (list != null) {
            for (MultiTextureLine highLight : list) {
                highLight.highLight(z);
            }
        }
    }

    class MultiTextureLine {
        int mCurTextureIndex;
        Line mLine;
        int mMinorTextureIndex;
        int mTextureIndex;

        public MultiTextureLine(Line line, int i, int i2) {
            this.mLine = line;
            this.mTextureIndex = i;
            this.mMinorTextureIndex = i2;
            this.mCurTextureIndex = i;
        }

        public void transparent(boolean z) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfo = this.mLine.getMultiColorLineInfo();
            if (multiColorLineInfo != null) {
                for (LineOptions.MultiColorLineInfo multiColorLineInfo2 : multiColorLineInfo) {
                    if (multiColorLineInfo2 != null) {
                        if (z) {
                            multiColorLineInfo2.colorIndex = 0;
                        } else {
                            multiColorLineInfo2.colorIndex = this.mMinorTextureIndex;
                        }
                    }
                }
                this.mLine.setMultiColorLineInfo(multiColorLineInfo);
            }
        }

        public void highLight(boolean z) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfo = this.mLine.getMultiColorLineInfo();
            if (multiColorLineInfo != null) {
                for (LineOptions.MultiColorLineInfo multiColorLineInfo2 : multiColorLineInfo) {
                    if (multiColorLineInfo2 != null) {
                        if (z) {
                            multiColorLineInfo2.colorIndex = this.mTextureIndex;
                            this.mCurTextureIndex = this.mTextureIndex;
                        } else {
                            multiColorLineInfo2.colorIndex = this.mMinorTextureIndex;
                            this.mCurTextureIndex = this.mMinorTextureIndex;
                        }
                    }
                }
                this.mLine.setMultiColorLineInfo(multiColorLineInfo);
            }
        }

        public void setVisible(boolean z) {
            this.mLine.setVisible(z);
        }

        public void setZIndex(int i) {
            this.mLine.setZIndex(i);
        }

        public int getZIndex() {
            return this.mLine.getZIndex();
        }
    }
}
