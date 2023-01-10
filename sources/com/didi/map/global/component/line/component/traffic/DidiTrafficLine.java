package com.didi.map.global.component.line.component.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DidiTrafficLine implements ITrafficLine {
    public static final String TAG = "DidiTrafficLine";

    /* renamed from: a */
    private static final long f27999a = 500;

    /* renamed from: b */
    private static final int f28000b = 10;

    /* renamed from: c */
    private static final int f28001c = Color.parseColor("#FFAF38");

    /* renamed from: d */
    private Context f28002d;

    /* renamed from: e */
    private Map f28003e;

    /* renamed from: f */
    private LineParams f28004f;

    /* renamed from: g */
    private Line f28005g;

    /* renamed from: h */
    private ValueAnimator f28006h;

    /* renamed from: i */
    private List<LatLng> f28007i = new ArrayList();

    /* renamed from: j */
    private List<TrafficData> f28008j = new ArrayList();

    /* renamed from: k */
    private boolean f28009k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnLineDrawStatusListener f28010l;

    /* renamed from: m */
    private Interpolator f28011m;

    /* renamed from: n */
    private LineExParam f28012n;

    /* renamed from: o */
    private int f28013o = 10;

    /* renamed from: p */
    private int f28014p;

    /* renamed from: q */
    private int f28015q;

    /* renamed from: r */
    private List<Integer> f28016r;

    /* renamed from: s */
    private List<ColorLineOperator> f28017s;

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public DidiTrafficLine() {
        int i = f28001c;
        this.f28014p = i;
        this.f28015q = i;
        this.f28017s = new ArrayList();
    }

    public void create(Context context, Map map) {
        this.f28002d = context;
        this.f28003e = map;
    }

    public void destroy() {
        Map map;
        extensionAnimToggle(false);
        List<TrafficData> list = this.f28008j;
        if (list != null) {
            list.clear();
            this.f28008j = null;
        }
        List<LatLng> list2 = this.f28007i;
        if (list2 != null) {
            list2.clear();
            this.f28007i = null;
        }
        Line line = this.f28005g;
        if (!(line == null || (map = this.f28003e) == null)) {
            map.remove(line);
            this.f28005g = null;
        }
        this.f28011m = null;
        this.f28006h = null;
        this.f28002d = null;
        this.f28003e = null;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f28004f = lineParams;
            this.f28007i = lineParams.getLinePoints();
            this.f28008j = lineParams.getTrafficData();
            if (lineParams.getLineWidth() > 0) {
                this.f28013o = lineParams.getLineWidth();
            }
            if (lineParams.getLineColorWithArgb() != -1) {
                this.f28014p = lineParams.getLineColorWithArgb();
            }
            if (lineParams.getExParam() != null) {
                LineExParam exParam = lineParams.getExParam();
                this.f28012n = exParam;
                this.f28009k = exParam.isHasLineExtensionAnim();
                if (this.f28012n.getLineMinorColor() != -1) {
                    this.f28015q = this.f28012n.getLineMinorColor();
                } else {
                    this.f28015q = this.f28014p;
                }
            }
        }
    }

    public void start() {
        extensionAnimToggle(false);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28007i)) {
            if (CollectionUtil.isEmpty((Collection<?>) this.f28008j)) {
                this.f28008j = m22049a(this.f28007i);
            } else if (!TrafficUtils.checkDataValid(this.f28008j, this.f28007i.size())) {
                this.f28008j = m22049a(this.f28007i);
            }
            if (this.f28009k) {
                m22050a();
                extensionAnimToggle(true);
                return;
            }
            m22053a(this.f28007i, this.f28008j);
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f28007i;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f28005g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f28010l = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f28003e;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    DidiTrafficLine.this.m22052a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22052a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f28005g) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Line line = this.f28005g;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public void updateTraffic(List<TrafficData> list) {
        if (this.f28002d != null && this.f28003e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isSameTrafficData = TrafficUtils.isSameTrafficData(this.f28008j, list);
            List<LatLng> list2 = this.f28007i;
            boolean checkDataValid = TrafficUtils.checkDataValid(list, list2 != null ? list2.size() : 0);
            if (isSameTrafficData || !checkDataValid) {
                DLog.m10773d(TAG, "isSame-->" + isSameTrafficData + "--isValid-->" + checkDataValid, new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("判断路线是否满足刷新要求-->no");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                DLog.m10773d(TAG, sb.toString(), new Object[0]);
                return;
            }
            DLog.m10773d(TAG, "判断路线是否满足刷新要求-->yes" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            this.f28008j = list;
            m22053a(this.f28007i, list);
        }
    }

    /* renamed from: a */
    private void m22053a(List<LatLng> list, List<TrafficData> list2) {
        if (this.f28002d != null && this.f28003e != null && !CollectionUtil.isEmpty((Collection<?>) list) && !CollectionUtil.isEmpty((Collection<?>) list2)) {
            this.f28016r = m22054b();
            LineOptions lineOptions = new LineOptions();
            lineOptions.type(8);
            lineOptions.lineEndType(1);
            lineOptions.add(list);
            lineOptions.setCusTextureBitmapColors(this.f28016r);
            if (this.f28004f.getZIndex() != 0) {
                lineOptions.zIndex(this.f28004f.getZIndex());
            }
            lineOptions.width((double) DisplayUtils.dp2px(this.f28002d, (float) this.f28013o));
            if (this.f28004f.isClickable()) {
                lineOptions.clickable(this.f28004f.isClickable());
            }
            int size = list2.size();
            LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = new LineOptions.MultiColorLineInfo[size];
            for (int i = 0; i < list2.size(); i++) {
                TrafficData trafficData = list2.get(i);
                if (trafficData != null) {
                    LineOptions.MultiColorLineInfo multiColorLineInfo = new LineOptions.MultiColorLineInfo();
                    multiColorLineInfo.pointIndex = trafficData.fromIndex;
                    multiColorLineInfo.colorIndex = m22047a(trafficData.color);
                    if (i < size) {
                        multiColorLineInfoArr[i] = multiColorLineInfo;
                        this.f28017s.add(new ColorLineOperator(multiColorLineInfo, m22047a(trafficData.color), m22047a(trafficData.minorColor)));
                    }
                }
            }
            lineOptions.multiColorLineInfo(multiColorLineInfoArr);
            Line line = this.f28005g;
            if (line == null) {
                this.f28005g = this.f28003e.addLine(lineOptions);
            } else {
                line.setOptions(lineOptions);
            }
            Line line2 = this.f28005g;
            if (line2 != null) {
                line2.setNaviRouteLineErase(true);
            }
        }
    }

    /* renamed from: a */
    private List<TrafficData> m22049a(List<LatLng> list) {
        int size = !CollectionUtil.isEmpty((Collection<?>) list) ? list.size() - 1 : 0;
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = new TrafficData();
        trafficData.fromIndex = 0;
        trafficData.toIndex = size;
        trafficData.color = m22047a(this.f28014p);
        trafficData.minorColor = m22047a(this.f28015q);
        arrayList.add(trafficData);
        return arrayList;
    }

    /* renamed from: a */
    private void m22050a() {
        if (this.f28004f != null && this.f28003e != null) {
            if (this.f28006h == null) {
                this.f28006h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            }
            if (this.f28011m == null) {
                this.f28011m = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f28006h.setInterpolator(new LinearInterpolator());
            LineExParam lineExParam = this.f28012n;
            long j = 500;
            if (lineExParam != null && ((long) lineExParam.getLineExtensionAnimDuration()) >= 500) {
                j = (long) this.f28012n.getLineExtensionAnimDuration();
            }
            this.f28006h.setDuration(j);
            this.f28006h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DidiTrafficLine.this.m22051a(valueAnimator);
                }
            });
            this.f28006h.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (DidiTrafficLine.this.f28010l != null) {
                        DidiTrafficLine.this.f28010l.onLineDrawFinished();
                    }
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (DidiTrafficLine.this.f28010l != null) {
                        DidiTrafficLine.this.f28010l.onLineDrawStart();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22051a(ValueAnimator valueAnimator) {
        int size = (int) (((float) this.f28007i.size()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
        List<LatLng> list = this.f28007i;
        if (list != null && list.size() >= size) {
            List<LatLng> subList = this.f28007i.subList(0, size);
            m22053a(subList, m22055b(subList));
        }
    }

    /* renamed from: b */
    private List<TrafficData> m22055b(List<LatLng> list) {
        int size = list == null ? 0 : list.size();
        ArrayList arrayList = new ArrayList();
        List<TrafficData> list2 = this.f28008j;
        if (list2 != null && !list2.isEmpty()) {
            for (TrafficData next : this.f28008j) {
                if (next.toIndex <= size) {
                    arrayList.add(next);
                } else if (next.fromIndex > size) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void extensionAnimToggle(boolean z) {
        ValueAnimator valueAnimator = this.f28006h;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            valueAnimator.start();
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        this.f28006h.removeAllListeners();
        this.f28006h.cancel();
    }

    public void erase(int i, LatLng latLng) {
        Line line = this.f28005g;
        if (line != null) {
            line.insertPoint(i, latLng);
        }
    }

    public List<Line> getLines() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f28005g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void highLight(boolean z) {
        if (this.f28005g != null && !CollectionUtil.isEmpty((Collection<?>) this.f28017s)) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = new LineOptions.MultiColorLineInfo[this.f28017s.size()];
            for (int i = 0; i < this.f28017s.size(); i++) {
                ColorLineOperator colorLineOperator = this.f28017s.get(i);
                if (colorLineOperator != null) {
                    colorLineOperator.showHighLightColor(z);
                }
                multiColorLineInfoArr[i] = colorLineOperator.getLineInfo();
            }
            this.f28005g.setMultiColorLineInfo(multiColorLineInfoArr);
        }
    }

    /* renamed from: b */
    private List<Integer> m22054b() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28008j)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TrafficData next : this.f28008j) {
            if (next != null) {
                if (next.color != 0 && !arrayList.contains(Integer.valueOf(next.color))) {
                    arrayList.add(Integer.valueOf(next.color));
                }
                if (next.minorColor != 0 && !arrayList.contains(Integer.valueOf(next.minorColor))) {
                    arrayList.add(Integer.valueOf(next.minorColor));
                }
            }
        }
        int i = this.f28014p;
        if (i != 0) {
            arrayList.add(Integer.valueOf(i));
        }
        int i2 = this.f28015q;
        if (i2 != 0) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m22047a(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28016r)) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f28016r.size(); i2++) {
            if (i == this.f28016r.get(i2).intValue()) {
                return i2;
            }
        }
        return 0;
    }

    public void updateLinePoints(List<LatLng> list) {
        this.f28007i = list;
    }

    class ColorLineOperator {
        LineOptions.MultiColorLineInfo lineInfo;
        int mHighLightColor;
        int mMinorColor;

        public ColorLineOperator(LineOptions.MultiColorLineInfo multiColorLineInfo, int i, int i2) {
            this.mHighLightColor = i;
            this.mMinorColor = i2;
            this.lineInfo = multiColorLineInfo;
        }

        public void showHighLightColor(boolean z) {
            if (z) {
                this.lineInfo.colorIndex = this.mMinorColor;
                return;
            }
            this.lineInfo.colorIndex = this.mHighLightColor;
        }

        public LineOptions.MultiColorLineInfo getLineInfo() {
            return this.lineInfo;
        }
    }
}
