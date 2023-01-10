package com.didi.map.global.component.line.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.listener.OnPolygonClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.sdk.util.ToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArcLineComponent implements ICompLineContract {
    public static final String TAG = "Arc_line_component";

    /* renamed from: a */
    private Map f27900a;

    /* renamed from: b */
    private Context f27901b;

    /* renamed from: c */
    private LineParams f27902c;

    /* renamed from: d */
    private LineExParam f27903d;

    /* renamed from: e */
    private List<LatLng> f27904e;

    /* renamed from: f */
    private Polygon f27905f;

    /* renamed from: g */
    private Line f27906g;

    /* renamed from: h */
    private OnLineDrawStatusListener f27907h;

    /* renamed from: i */
    private ICompLineContract f27908i;

    /* renamed from: j */
    private ICompLineContract f27909j;

    /* renamed from: k */
    private ValueAnimator f27910k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* renamed from: l */
    private DrawLineMode f27911l;

    /* renamed from: m */
    private LatLng f27912m;

    /* renamed from: n */
    private LatLng f27913n;

    public enum DrawLineMode {
        TYPE_LINE,
        TYPE_POLYGON
    }

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f27900a = map;
        this.f27901b = context;
    }

    public void setConfigParam(LineParams lineParams) {
        LineExParam lineExParam;
        if (lineParams != null && !CollectionUtil.isEmpty((Collection<?>) lineParams.getLinePoints())) {
            if (lineParams.getLinePoints().size() != 2) {
                try {
                    throw new Exception("弧线绘制点集必须为两个");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f27902c = lineParams;
            this.f27903d = lineParams.getExParam();
            if (this.f27902c.getLineColorWithArgb() == 0) {
                this.f27902c.setLineColorWithArgb(Color.parseColor("#262B2E"));
            }
            if (this.f27902c.getLineWidth() == 0) {
                this.f27902c.setLineWidth(6);
            }
            Map map = this.f27900a;
            if (map != null) {
                if (map.getMapVendor() != MapVendor.DIDI || (lineExParam = this.f27903d) == null || !lineExParam.isHasPulseAnim()) {
                    this.f27911l = DrawLineMode.TYPE_POLYGON;
                } else {
                    this.f27911l = DrawLineMode.TYPE_LINE;
                }
            }
            this.f27912m = lineParams.getLinePoints().get(0);
            this.f27913n = lineParams.getLinePoints().get(1);
            this.f27904e = LineUtils.INSTANCE.getCornerLineDots(this.f27912m, this.f27913n);
        }
    }

    public void start() {
        List<LatLng> list = this.f27904e;
        if (list != null && this.f27911l != null) {
            if (list.size() <= 2) {
                this.f27911l = DrawLineMode.TYPE_LINE;
            }
            int i = C102831.f27914xacffd67a[this.f27911l.ordinal()];
            if (i == 1) {
                m22014d();
            } else if (i == 2) {
                m22013c();
            }
            LineExParam lineExParam = this.f27903d;
            if (lineExParam != null) {
                if (lineExParam.isHasPulseAnim()) {
                    starPulseAnim();
                }
                if (this.f27903d.isHasArcLineShadow()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f27912m);
                    arrayList.add(this.f27913n);
                    m22011a((List<LatLng>) arrayList);
                }
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.ArcLineComponent$1 */
    static /* synthetic */ class C102831 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$line$component$ArcLineComponent$DrawLineMode */
        static final /* synthetic */ int[] f27914xacffd67a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode[] r0 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27914xacffd67a = r0
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode r1 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.TYPE_LINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27914xacffd67a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode r1 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.TYPE_POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.component.ArcLineComponent.C102831.<clinit>():void");
        }
    }

    public void stop() {
        stopPulseAnim();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27904e;
    }

    public void destroy() {
        Polygon polygon = this.f27905f;
        if (polygon != null) {
            this.f27900a.remove(polygon);
            this.f27905f.remove();
            this.f27905f = null;
        }
        Line line = this.f27906g;
        if (line != null) {
            this.f27900a.remove(line);
            this.f27906g.remove();
            this.f27906g = null;
        }
        ICompLineContract iCompLineContract = this.f27908i;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f27908i = null;
        }
        List<LatLng> list = this.f27904e;
        if (list != null) {
            list.clear();
            this.f27904e = null;
        }
        ICompLineContract iCompLineContract2 = this.f27909j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
            this.f27909j = null;
        }
        this.f27902c = null;
        this.f27901b = null;
        this.f27900a = null;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27907h = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        if (this.f27900a != null && onLineClickListener != null) {
            if (this.f27911l == DrawLineMode.TYPE_LINE) {
                this.f27900a.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                    public final /* synthetic */ OnLineClickListener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onLineClick(Line line) {
                        ArcLineComponent.this.m22009a(this.f$1, line);
                    }
                });
            } else {
                this.f27900a.addOnPolygonClickListener(new OnPolygonClickListener(onLineClickListener) {
                    public final /* synthetic */ OnLineClickListener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onPolygonClick(Polygon polygon) {
                        ArcLineComponent.this.m22010a(this.f$1, polygon);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22009a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f27906g) {
            onLineClickListener.onLineClick(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22010a(OnLineClickListener onLineClickListener, Polygon polygon) {
        if (polygon == this.f27905f) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Polygon polygon = this.f27905f;
        if (polygon != null) {
            polygon.setVisible(z);
        }
        Line line = this.f27906g;
        if (line != null) {
            line.setVisible(z);
        }
        ICompLineContract iCompLineContract = this.f27908i;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        ICompLineContract iCompLineContract2 = this.f27909j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.setLineVisible(z);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Polygon polygon = this.f27905f;
        if (polygon != null) {
            arrayList.add(polygon);
        }
        Line line = this.f27906g;
        if (line != null) {
            arrayList.add(line);
        }
        ICompLineContract iCompLineContract = this.f27908i;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f27908i.getBestViewElements());
        }
        ICompLineContract iCompLineContract2 = this.f27909j;
        if (!(iCompLineContract2 == null || iCompLineContract2.getBestViewElements() == null)) {
            arrayList.addAll(this.f27909j.getBestViewElements());
        }
        return arrayList;
    }

    public void starPulseAnim() {
        int i = C102831.f27914xacffd67a[this.f27911l.ordinal()];
        if (i == 1) {
            m22012b();
        } else if (i == 2) {
            m22007a();
        }
    }

    public void stopPulseAnim() {
        ICompLineContract iCompLineContract = this.f27909j;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
        }
        ValueAnimator valueAnimator = this.f27910k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: a */
    private void m22011a(List<LatLng> list) {
        LineExParam lineExParam;
        if (this.f27901b != null && this.f27900a != null && this.f27902c != null && (lineExParam = this.f27903d) != null) {
            LineParams lineParams = new LineParams(list, lineExParam.getShadowLineColor() == 0 ? Color.parseColor("#1A294766") : this.f27903d.getShadowLineColor(), this.f27903d.getShadowLineWidth() == 0 ? 6 : this.f27903d.getShadowLineWidth());
            lineParams.setZIndex(this.f27902c.getZIndex());
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f27900a, this.f27901b, lineParams);
            this.f27908i = createLineComponent;
            createLineComponent.start();
        }
    }

    /* renamed from: a */
    private void m22007a() {
        if (this.f27901b != null && this.f27900a != null && this.f27902c != null && this.f27904e != null) {
            LineParams lineParams = new LineParams(this.f27904e, this.f27903d.getPulseLineColor() == 0 ? Color.parseColor("#66ffffff") : this.f27903d.getPulseLineColor(), this.f27902c.getLineWidth() + 1);
            lineParams.setExParam(this.f27903d);
            lineParams.setZIndex(this.f27902c.getZIndex() + 1);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f27900a, this.f27901b, lineParams);
            this.f27909j = createLineComponent;
            createLineComponent.start();
        }
    }

    /* renamed from: b */
    private void m22012b() {
        if (this.f27910k == null) {
            this.f27910k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        }
        LineExParam lineExParam = this.f27903d;
        if (lineExParam == null || lineExParam.getPulseAnimDuration() == 0) {
            this.f27910k.setDuration(2000);
        } else {
            this.f27910k.setDuration((long) this.f27903d.getPulseAnimDuration());
        }
        this.f27910k.setInterpolator(PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f));
        this.f27910k.setRepeatMode(1);
        this.f27910k.setRepeatCount(-1);
        this.f27910k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ArcLineComponent.this.m22008a(valueAnimator);
            }
        });
        this.f27910k.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22008a(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Line line = this.f27906g;
            if (line != null) {
                line.setPulsePercent(floatValue);
            }
        }
    }

    /* renamed from: c */
    private void m22013c() {
        List<LatLng> list = this.f27904e;
        if (list != null && !list.isEmpty()) {
            Polygon polygon = this.f27905f;
            if (polygon != null) {
                polygon.remove();
                this.f27905f = null;
            }
            if (this.f27902c == null) {
                ToastUtil.show(this.f27901b, (CharSequence) "请先添加参数");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f27904e);
            for (int size = this.f27904e.size() - 1; size >= 0; size--) {
                arrayList.add(this.f27904e.get(size));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.strokeColor(this.f27902c.getLineColorWithArgb());
            polygonOptions.strokeWidth((float) DisplayUtils.dp2px(this.f27901b, (float) this.f27902c.getLineWidth()));
            polygonOptions.fillColor(0);
            polygonOptions.geodesic(false);
            polygonOptions.setPolygonPatternType(2);
            polygonOptions.addAll(arrayList);
            if (this.f27902c.getZIndex() != 0) {
                polygonOptions.zIndex(this.f27902c.getZIndex());
            }
            this.f27905f = this.f27900a.addPolygon(polygonOptions);
            OnLineDrawStatusListener onLineDrawStatusListener = this.f27907h;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    /* renamed from: d */
    private void m22014d() {
        List<LatLng> list = this.f27904e;
        if (list != null && !list.isEmpty()) {
            Line line = this.f27906g;
            if (line != null) {
                line.remove();
                this.f27906g = null;
            }
            if (this.f27902c == null) {
                ToastUtil.show(this.f27901b, (CharSequence) "请先添加参数");
                return;
            }
            LineOptions lineOptions = new LineOptions();
            lineOptions.color(this.f27902c.getLineColorWithArgb());
            lineOptions.width((double) DisplayUtils.dp2px(this.f27901b, (float) this.f27902c.getLineWidth()));
            lineOptions.type(6);
            lineOptions.add(this.f27904e);
            if (this.f27902c.getZIndex() != 0) {
                lineOptions.zIndex(this.f27902c.getZIndex());
            }
            if (this.f27902c.isClickable()) {
                lineOptions.clickable(this.f27902c.isClickable());
            }
            if (!this.f27902c.isEnableDirArrow()) {
                lineOptions.road(false);
            }
            Line addLine = this.f27900a.addLine(lineOptions);
            this.f27906g = addLine;
            addLine.modLineColor(this.f27902c.getLineColorWithArgb());
            LineExParam lineExParam = this.f27903d;
            if (!(lineExParam == null || lineExParam.getPulseBitmap() == null)) {
                this.f27906g.setPulseBitmap(this.f27903d.getPulseBitmap());
            }
            OnLineDrawStatusListener onLineDrawStatusListener = this.f27907h;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public LatLng getArcLineCenter() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f27904e)) {
            return null;
        }
        if (this.f27904e.size() > 2) {
            List<LatLng> list = this.f27904e;
            return list.get(list.size() / 2);
        } else if (!LatLngUtils.locateCorrect(this.f27912m) || !LatLngUtils.locateCorrect(this.f27913n)) {
            return null;
        } else {
            double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(this.f27912m, this.f27913n);
            return DDSphericalUtil.computeOffset(this.f27913n, computeDistanceBetween * 0.5d, DDSphericalUtil.computeHeading(this.f27912m, this.f27913n));
        }
    }
}
