package com.didi.map.global.component.line.component.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GoogleTrafficLine implements ITrafficLine {

    /* renamed from: a */
    private static final String f28018a = "GoogleTrafficLine";

    /* renamed from: b */
    private static final int f28019b = 10;

    /* renamed from: c */
    private static final int f28020c = Color.parseColor("#FFAF38");

    /* renamed from: d */
    private static final long f28021d = 500;

    /* renamed from: e */
    private static final int f28022e = 30;

    /* renamed from: A */
    private List<LatLng> f28023A = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OnLineDrawStatusListener f28024B;

    /* renamed from: C */
    private boolean f28025C = false;

    /* renamed from: D */
    private List<MultiColorLine> f28026D = new ArrayList();

    /* renamed from: E */
    private LatLng f28027E;

    /* renamed from: f */
    private Map f28028f;

    /* renamed from: g */
    private Context f28029g;

    /* renamed from: h */
    private ValueAnimator f28030h = null;

    /* renamed from: i */
    private int f28031i = 10;

    /* renamed from: j */
    private int f28032j = f28020c;

    /* renamed from: k */
    private int f28033k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f28034l;

    /* renamed from: m */
    private int f28035m;

    /* renamed from: n */
    private TrafficData f28036n;

    /* renamed from: o */
    private int f28037o = 0;

    /* renamed from: p */
    private int f28038p = 0;

    /* renamed from: q */
    private int f28039q = 0;

    /* renamed from: r */
    private int f28040r = 0;

    /* renamed from: s */
    private Integer f28041s = 1;

    /* renamed from: t */
    private List<LatLng> f28042t = new ArrayList();

    /* renamed from: u */
    private List<TrafficData> f28043u = new ArrayList();

    /* renamed from: v */
    private List<Line> f28044v = new ArrayList();

    /* renamed from: w */
    private List<Line> f28045w = new ArrayList();

    /* renamed from: x */
    private LineParams f28046x;

    /* renamed from: y */
    private LineExParam f28047y;

    /* renamed from: z */
    private List<TrafficData> f28048z = new ArrayList();

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f28028f = map;
        this.f28029g = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f28046x = lineParams;
            this.f28047y = lineParams.getExParam();
            this.f28023A = lineParams.getLinePoints();
            this.f28048z = lineParams.getTrafficData();
            this.f28037o = CollectionUtil.isEmpty((Collection<?>) this.f28023A) ? 0 : this.f28023A.size();
            if (lineParams.getLineWidth() > 0) {
                this.f28031i = lineParams.getLineWidth();
            }
            if (lineParams.getLineColorWithArgb() != 0) {
                this.f28032j = lineParams.getLineColorWithArgb();
            }
            LineExParam lineExParam = this.f28047y;
            if (lineExParam != null) {
                this.f28025C = lineExParam.isHasLineExtensionAnim();
                if (this.f28047y.getLineMinorColor() != 0) {
                    this.f28033k = this.f28047y.getLineMinorColor();
                } else {
                    this.f28033k = this.f28032j;
                }
            }
        }
    }

    public void start() {
        if (this.f28028f != null && !CollectionUtil.isEmpty((Collection<?>) this.f28023A)) {
            this.f28034l = true;
            m22072g();
            m22073h();
            if (this.f28046x == null || !this.f28025C) {
                m22060a();
                return;
            }
            MapLineSegmentUtil.insertPoints(this.f28023A, this.f28042t, this.f28048z, this.f28043u);
            m22065b();
        }
    }

    /* renamed from: a */
    private void m22060a() {
        Line a;
        this.f28034l = true;
        for (TrafficData next : this.f28048z) {
            List<LatLng> list = this.f28023A;
            if (!(list == null || list.size() <= next.toIndex || (a = m22056a(this.f28023A.subList(next.fromIndex, next.toIndex + 1), next.color, this.f28031i)) == null)) {
                this.f28044v.add(a);
                this.f28026D.add(new MultiColorLine(a, next.color, next.minorColor));
            }
        }
        this.f28038p = this.f28044v.size();
        m22071f();
    }

    public void erase(int i, LatLng latLng) {
        int i2;
        int i3;
        if (latLng != null && i >= 0 && i >= this.f28040r && i <= this.f28037o - 1 && this.f28038p >= 1 && !this.f28034l) {
            this.f28027E = latLng;
            this.f28040r = i;
            TrafficData trafficData = this.f28036n;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f28036n.toIndex) {
                int i4 = 0;
                this.f28036n = null;
                Iterator<TrafficData> it = this.f28048z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i4 >= this.f28035m && i >= next.fromIndex && i < next.toIndex) {
                        this.f28036n = next;
                        this.f28035m = i4;
                        break;
                    }
                    i4++;
                }
            }
            if (this.f28036n != null) {
                int i5 = this.f28035m;
                if (i5 > 0 && i5 > (i3 = this.f28039q)) {
                    while (i3 < this.f28038p && i3 < this.f28035m) {
                        List<Line> list = this.f28044v;
                        if (list != null) {
                            m22062a(list.get(i3));
                        }
                        this.f28039q = i3;
                        i3++;
                    }
                }
                int i6 = this.f28035m;
                if (i6 < this.f28038p) {
                    Line line = this.f28044v.get(i6);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    if (this.f28023A.size() > this.f28036n.toIndex) {
                        arrayList.addAll(this.f28023A.subList(i + 1, this.f28036n.toIndex + 1));
                    }
                    line.setPoints(arrayList);
                }
            } else if (this.f28035m == this.f28038p - 1) {
                List<Line> list2 = this.f28044v;
                if (list2 != null && list2.size() > (i2 = this.f28035m)) {
                    m22062a(this.f28044v.get(i2));
                }
            } else {
                for (int i7 = this.f28039q; i7 < this.f28038p; i7++) {
                    List<Line> list3 = this.f28044v;
                    if (list3 != null && list3.size() > i7) {
                        m22062a(this.f28044v.get(i7));
                    }
                }
            }
        }
    }

    public List<Line> getLines() {
        List<Line> list = this.f28044v;
        return list == null ? new ArrayList() : list;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        List<Line> list = this.f28044v;
        if (list != null) {
            for (Line next : list) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f28024B = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f28028f;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    GoogleTrafficLine.this.m22063a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22063a(OnLineClickListener onLineClickListener, Line line) {
        List<Line> list = this.f28044v;
        if (list != null) {
            for (Line line2 : list) {
                if (line2 == line) {
                    onLineClickListener.onLineClick(this);
                    return;
                }
            }
        }
    }

    public void setLineVisible(boolean z) {
        for (Line next : this.f28044v) {
            if (next != null) {
                next.setVisible(z);
            }
        }
    }

    public void highLight(boolean z) {
        List<MultiColorLine> list = this.f28026D;
        if (list != null) {
            for (MultiColorLine showHighLightColor : list) {
                showHighLightColor.showHighLightColor(z);
            }
        }
    }

    public void destroy() {
        List<Line> list;
        m22069d();
        if (this.f28028f != null && (list = this.f28044v) != null) {
            for (Line remove : list) {
                this.f28028f.remove(remove);
            }
            this.f28044v.clear();
            this.f28045w.clear();
            this.f28038p = 0;
        }
    }

    public void updateTraffic(List<TrafficData> list) {
        Map map;
        Line line;
        int i = 0;
        DLog.m10773d(f28018a, "updateTraffic", new Object[0]);
        if (this.f28029g != null && this.f28028f != null) {
            if (TrafficUtils.isSameTrafficData(this.f28048z, list)) {
                DLog.m10773d(f28018a, "isSameTrafficData: true", new Object[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!TrafficUtils.checkDataValid(list, this.f28023A.size())) {
                DLog.m10773d(f28018a, "checkDataValid: false", new Object[0]);
                return;
            }
            DLog.m10773d(f28018a, "判断路线是否满足刷新要求-->yes" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            this.f28048z = list;
            int size = list.size();
            DLog.m10773d(f28018a, "traffic data size:" + size, new Object[0]);
            if (this.f28040r == 0 && this.f28027E == null) {
                DLog.m10773d(f28018a, "no erase", new Object[0]);
                int size2 = this.f28044v.size();
                ArrayList arrayList = new ArrayList();
                while (i < list.size()) {
                    TrafficData trafficData = list.get(i);
                    if (i < size2) {
                        line = this.f28044v.get(i);
                        line.setPoints(this.f28023A.subList(trafficData.fromIndex, trafficData.toIndex + 1));
                        line.setColor(trafficData.color);
                    } else {
                        line = m22056a(this.f28023A.subList(trafficData.fromIndex, trafficData.toIndex + 1), trafficData.color, this.f28031i);
                    }
                    arrayList.add(line);
                    i++;
                }
                for (Line next : this.f28044v) {
                    if (next != null && !arrayList.contains(next)) {
                        m22062a(next);
                    }
                }
                this.f28044v.clear();
                this.f28045w.clear();
                this.f28044v.addAll(arrayList);
                this.f28038p = this.f28044v.size();
                arrayList.clear();
                return;
            }
            int i2 = this.f28040r;
            DLog.m10773d(f28018a, "last erase point index:" + this.f28040r, new Object[0]);
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                TrafficData trafficData2 = list.get(i3);
                if (i2 >= trafficData2.fromIndex && i2 < trafficData2.toIndex) {
                    this.f28036n = trafficData2;
                    this.f28035m = i3;
                    break;
                }
                i3++;
            }
            if (this.f28036n != null) {
                int i4 = this.f28035m;
                if (i4 > 0) {
                    this.f28039q = i4 - 1;
                } else {
                    this.f28039q = 0;
                }
                if (this.f28035m < size) {
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = this.f28044v.size();
                    int i5 = 0;
                    while (i < size) {
                        Line line2 = null;
                        if (i < this.f28035m) {
                            arrayList2.add((Object) null);
                        } else {
                            while (true) {
                                if (i5 < size3) {
                                    Line line3 = this.f28044v.get(i5);
                                    if (line3 != null && !this.f28045w.contains(line3)) {
                                        i5++;
                                        line2 = line3;
                                        break;
                                    }
                                    i5++;
                                } else {
                                    break;
                                }
                            }
                            if (i == this.f28035m) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(this.f28027E);
                                if (this.f28023A.size() > this.f28036n.toIndex) {
                                    arrayList3.addAll(this.f28023A.subList(i2 + 1, this.f28036n.toIndex + 1));
                                }
                                if (line2 != null) {
                                    line2.setPoints(arrayList3);
                                    line2.setColor(this.f28036n.color);
                                } else {
                                    line2 = m22056a((List<LatLng>) arrayList3, this.f28036n.color, this.f28031i);
                                }
                                arrayList2.add(line2);
                            } else {
                                TrafficData trafficData3 = this.f28048z.get(i);
                                if (trafficData3 != null && this.f28023A.size() > trafficData3.toIndex) {
                                    ArrayList arrayList4 = new ArrayList(this.f28023A.subList(trafficData3.fromIndex, trafficData3.toIndex + 1));
                                    if (line2 != null) {
                                        line2.setPoints(arrayList4);
                                        line2.setColor(trafficData3.color);
                                    } else {
                                        line2 = m22056a((List<LatLng>) arrayList4, trafficData3.color, this.f28031i);
                                    }
                                    arrayList2.add(line2);
                                }
                            }
                        }
                        i++;
                    }
                    for (Line next2 : this.f28044v) {
                        if (!(arrayList2.contains(next2) || (map = this.f28028f) == null || next2 == null)) {
                            map.remove(next2);
                        }
                    }
                    this.f28044v.clear();
                    this.f28044v.addAll(arrayList2);
                    this.f28038p = this.f28044v.size();
                    arrayList2.clear();
                    this.f28045w.clear();
                }
            }
        }
    }

    /* renamed from: a */
    private void m22062a(Line line) {
        Map map = this.f28028f;
        if (map != null && line != null) {
            map.remove(line);
            this.f28045w.add(line);
        }
    }

    /* renamed from: a */
    private Line m22056a(List<LatLng> list, int i, int i2) {
        if (this.f28028f == null) {
            return null;
        }
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(i);
        lineOptions.width((double) DisplayUtils.dp2px(this.f28029g, (float) i2));
        lineOptions.setPoints(list);
        if (this.f28046x.isClickable()) {
            lineOptions.clickable(this.f28046x.isClickable());
        }
        Line addLine = this.f28028f.addLine(lineOptions);
        if (addLine != null) {
            addLine.setLineEndType(0);
        }
        return addLine;
    }

    /* renamed from: b */
    private void m22065b() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28042t) || CollectionUtil.isEmpty((Collection<?>) this.f28043u)) {
            m22060a();
            return;
        }
        this.f28030h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        long j = 0;
        LineExParam lineExParam = this.f28047y;
        if (lineExParam != null) {
            j = ((long) lineExParam.getLineExtensionAnimDuration()) >= 500 ? (long) this.f28047y.getLineExtensionAnimDuration() : 500;
        }
        this.f28030h.setDuration(j);
        this.f28030h.addUpdateListener(m22067c());
        this.f28030h.setInterpolator(new AccelerateInterpolator());
        this.f28030h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = GoogleTrafficLine.this.f28034l = true;
                if (GoogleTrafficLine.this.f28024B != null) {
                    GoogleTrafficLine.this.f28024B.onLineDrawStart();
                }
            }

            public void onAnimationEnd(Animator animator) {
                GoogleTrafficLine.this.m22070e();
                GoogleTrafficLine.this.m22071f();
                if (GoogleTrafficLine.this.f28024B != null) {
                    GoogleTrafficLine.this.f28024B.onLineDrawFinished();
                }
            }
        });
        this.f28030h.start();
    }

    /* renamed from: c */
    private ValueAnimator.AnimatorUpdateListener m22067c() {
        List<LatLng> list = this.f28042t;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleTrafficLine.this.m22061a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22061a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) i));
        int intValue = this.f28041s.intValue();
        while (intValue < floatValue && intValue <= i) {
            TrafficData trafficData = this.f28036n;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f28036n.toIndex) {
                TrafficData a = m22058a(intValue);
                this.f28036n = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f28036n.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f28044v.get(this.f28035m).setPoints(subList);
            }
            intValue++;
        }
        this.f28041s = Integer.valueOf(floatValue);
    }

    /* renamed from: d */
    private void m22069d() {
        ValueAnimator valueAnimator = this.f28030h;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f28030h.removeAllListeners();
            this.f28030h.cancel();
            this.f28030h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22070e() {
        List<Line> list = this.f28044v;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f28044v.size(); i++) {
                TrafficData trafficData = this.f28048z.get(i);
                if (this.f28023A.size() > trafficData.toIndex) {
                    this.f28044v.get(i).setPoints(this.f28023A.subList(trafficData.fromIndex, trafficData.toIndex + 1));
                }
            }
        }
        this.f28042t.clear();
        this.f28043u.clear();
        this.f28038p = this.f28044v.size();
    }

    /* renamed from: a */
    private TrafficData m22058a(int i) {
        int size = this.f28043u.size();
        int i2 = this.f28035m;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f28043u.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f28035m++;
                i2++;
            } else {
                Line a = m22056a(this.f28042t.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.color, this.f28031i);
                if (a != null) {
                    this.f28044v.add(a);
                    this.f28026D.add(new MultiColorLine(a, trafficData.color, trafficData.minorColor));
                    if (this.f28035m < this.f28044v.size()) {
                        return trafficData;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m22071f() {
        this.f28034l = false;
        this.f28036n = null;
        this.f28035m = 0;
    }

    /* renamed from: g */
    private void m22072g() {
        ArrayList arrayList = new ArrayList();
        int i = this.f28037o - 1;
        int i2 = 0;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28048z)) {
            for (TrafficData next : this.f28048z) {
                if (next != null) {
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
                                TrafficData a = m22059a(i2, next.fromIndex, this.f28032j, this.f28033k);
                                arrayList.add(a);
                                i2 = a.toIndex;
                            }
                        }
                        if (next.toIndex - next.fromIndex >= 1) {
                            arrayList.add(next);
                            i2 = next.toIndex;
                        }
                    }
                }
            }
            if (i > i2) {
                if (i - i2 > 1) {
                    arrayList.add(m22059a(i2, i, this.f28032j, this.f28033k));
                } else if (!arrayList.isEmpty()) {
                    ((TrafficData) arrayList.get(arrayList.size() - 1)).toIndex = i;
                }
            }
        } else {
            arrayList.add(m22059a(0, i, this.f28032j, this.f28033k));
        }
        this.f28048z = arrayList;
    }

    /* renamed from: a */
    private TrafficData m22059a(int i, int i2, int i3, int i4) {
        TrafficData trafficData = new TrafficData();
        trafficData.fromIndex = i;
        trafficData.toIndex = i2;
        trafficData.color = i3;
        trafficData.minorColor = i4;
        return trafficData;
    }

    public List<LatLng> getAllLinePoints() {
        return this.f28023A;
    }

    /* renamed from: h */
    private void m22073h() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = null;
        for (TrafficData next : this.f28048z) {
            if (next != null) {
                int i = next.toIndex - next.fromIndex;
                if (i > 30) {
                    int i2 = i / 30;
                    int i3 = i % 30;
                    int i4 = next.toIndex;
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = next.fromIndex + (i5 * 30);
                        i4 = i6 + 30;
                        trafficData = m22059a(i6, i4, next.color, next.minorColor);
                        arrayList.add(trafficData);
                    }
                    if (i3 > 0) {
                        if (i3 >= 10) {
                            trafficData = m22059a(i4, i3 + i4, next.color, next.minorColor);
                            arrayList.add(trafficData);
                        } else if (trafficData != null) {
                            trafficData.toIndex += i3;
                        }
                    }
                } else {
                    arrayList.add(next);
                }
            }
        }
        this.f28038p = arrayList.size();
        this.f28048z = arrayList;
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
