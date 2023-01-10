package com.didi.map.global.component.line.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommLineComponent implements ICompLineContract {
    public static final String TAG = "CommLineComponent";

    /* renamed from: a */
    private static final int f27915a = 1500;

    /* renamed from: b */
    private Context f27916b;

    /* renamed from: c */
    private Map f27917c;

    /* renamed from: d */
    private LineParams f27918d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LineExParam f27919e;

    /* renamed from: f */
    private Line f27920f;

    /* renamed from: g */
    private ValueAnimator f27921g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<LatLng> f27922h = new ArrayList();

    /* renamed from: i */
    private int f27923i = 1500;

    /* renamed from: j */
    private boolean f27924j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnLineDrawStatusListener f27925k;

    /* renamed from: l */
    private Interpolator f27926l;

    /* renamed from: m */
    private ICompLineContract f27927m;

    /* renamed from: n */
    private LineOptions f27928n;

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f27916b = context;
        this.f27917c = map;
    }

    public void setConfigParam(LineParams lineParams) {
        int i;
        if (lineParams != null) {
            this.f27918d = lineParams;
            LineExParam exParam = lineParams.getExParam();
            this.f27919e = exParam;
            if (exParam != null) {
                this.f27924j = exParam.isHasLineExtensionAnim();
                if (this.f27919e.getLineExtensionAnimDuration() == 0) {
                    i = 1500;
                } else {
                    i = this.f27919e.getLineExtensionAnimDuration();
                }
                this.f27923i = i;
            }
            if (this.f27918d.getLineColorWithArgb() == 0) {
                this.f27918d.setLineColorWithArgb(Color.parseColor("#33BBFF"));
            }
            if (this.f27918d.getLineWidth() == 0) {
                this.f27918d.setLineWidth(6);
            }
        }
    }

    public void start() {
        cancelExtensionAnim();
        LineParams lineParams = this.f27918d;
        if (lineParams != null) {
            this.f27922h = lineParams.getLinePoints();
            if (!CollectionUtil.isEmpty((Collection<?>) this.f27918d.getLinePoints())) {
                m22021b();
            }
        }
    }

    public void stop() {
        stopPulseAnim();
    }

    public void destroy() {
        stop();
        cancelExtensionAnim();
        Line line = this.f27920f;
        if (line != null) {
            line.remove();
            this.f27920f = null;
        }
        ICompLineContract iCompLineContract = this.f27927m;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f27927m = null;
        }
        this.f27926l = null;
        this.f27921g = null;
        this.f27916b = null;
        this.f27917c = null;
    }

    public void stopPulseAnim() {
        ICompLineContract iCompLineContract = this.f27927m;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
        }
    }

    public void drawPulseLine(List<LatLng> list) {
        if (this.f27916b != null && this.f27917c != null) {
            if (this.f27918d != null || this.f27919e == null) {
                ICompLineContract iCompLineContract = this.f27927m;
                if (iCompLineContract != null) {
                    iCompLineContract.destroy();
                    this.f27927m = null;
                }
                LineParams lineParams = new LineParams(list, this.f27919e.getPulseLineColor() == 0 ? Color.parseColor("#66ffffff") : this.f27919e.getPulseLineColor(), this.f27918d.getLineWidth() + 1);
                lineParams.setZIndex(this.f27918d.getZIndex() + 1);
                lineParams.setExParam(this.f27919e);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f27917c, this.f27916b, lineParams);
                this.f27927m = createLineComponent;
                if (createLineComponent != null) {
                    createLineComponent.start();
                }
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f27920f;
        if (line != null) {
            arrayList.add(line);
        }
        ICompLineContract iCompLineContract = this.f27927m;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f27927m.getBestViewElements());
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27925k = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f27917c;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    CommLineComponent.this.m22018a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22018a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f27920f) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Line line = this.f27920f;
        if (line != null) {
            line.setVisible(z);
        }
        ICompLineContract iCompLineContract = this.f27927m;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    /* renamed from: a */
    private void m22019a(List<LatLng> list) {
        if (this.f27916b != null && this.f27917c != null) {
            if (C102852.$SwitchMap$com$didi$common$map$MapVendor[this.f27917c.getMapVendor().ordinal()] != 1) {
                m22022b(list);
            } else if (this.f27918d.isEnableEarthWormLine()) {
                m22024c(list);
            } else {
                m22022b(list);
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.CommLineComponent$2 */
    static /* synthetic */ class C102852 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        static {
            int[] iArr = new int[MapVendor.values().length];
            $SwitchMap$com$didi$common$map$MapVendor = iArr;
            try {
                iArr[MapVendor.DIDI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: b */
    private void m22022b(List<LatLng> list) {
        if (this.f27920f != null || this.f27918d == null) {
            this.f27920f.setPoints(list);
            return;
        }
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(this.f27918d.getLineColorWithArgb());
        lineOptions.width((double) DisplayUtils.dp2px(this.f27916b, (float) this.f27918d.getLineWidth()));
        lineOptions.lineEndType(1);
        lineOptions.clickable(true);
        if (this.f27918d.getZIndex() != 0) {
            lineOptions.zIndex(this.f27918d.getZIndex());
        }
        if (!this.f27918d.isEnableDirArrow()) {
            lineOptions.road(false);
        }
        lineOptions.setPoints(list);
        if (this.f27918d.isClickable()) {
            lineOptions.clickable(this.f27918d.isClickable());
        }
        this.f27920f = this.f27917c.addLine(lineOptions);
    }

    /* renamed from: c */
    private void m22024c(List<LatLng> list) {
        LineParams lineParams = this.f27918d;
        if (lineParams != null) {
            if (lineParams.getDidiColor() < 0) {
                this.f27918d.setDidiColor(24);
            }
            if (this.f27928n == null) {
                LineOptions lineOptions = new LineOptions();
                this.f27928n = lineOptions;
                lineOptions.type(0);
                this.f27928n.width((double) DisplayUtils.dp2px(this.f27916b, (float) this.f27918d.getLineWidth()));
                this.f27928n.lineEndType(1);
                if (this.f27918d.getZIndex() != 0) {
                    this.f27928n.zIndex(this.f27918d.getZIndex());
                }
                if (!this.f27918d.isEnableDirArrow()) {
                    this.f27928n.road(false);
                }
                LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = {new LineOptions.MultiColorLineInfo()};
                multiColorLineInfoArr[0].pointIndex = 0;
                multiColorLineInfoArr[0].colorIndex = this.f27918d.getDidiColor();
                this.f27928n.multiColorLineInfo(multiColorLineInfoArr);
                this.f27928n.clickable(true);
            }
            if (this.f27920f == null) {
                this.f27928n.add(list);
                this.f27920f = this.f27917c.addLine(this.f27928n);
                return;
            }
            this.f27928n.setPoints(list);
            this.f27920f.setOptions(this.f27928n);
        }
    }

    /* renamed from: a */
    private void m22016a() {
        if (this.f27918d != null && this.f27917c != null) {
            if (this.f27921g == null) {
                this.f27921g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            }
            if (this.f27926l == null) {
                this.f27926l = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f27921g.setInterpolator(this.f27926l);
            this.f27921g.setDuration((long) this.f27923i);
            this.f27921g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommLineComponent.this.m22017a(valueAnimator);
                }
            });
            this.f27921g.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (CommLineComponent.this.f27919e != null && CommLineComponent.this.f27919e.isHasPulseAnim()) {
                        CommLineComponent commLineComponent = CommLineComponent.this;
                        commLineComponent.drawPulseLine(commLineComponent.f27922h);
                    }
                    if (CommLineComponent.this.f27925k != null) {
                        CommLineComponent.this.f27925k.onLineDrawFinished();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22017a(ValueAnimator valueAnimator) {
        int size;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        List<LatLng> list = this.f27922h;
        if (list != null && this.f27922h.size() > (size = (int) (((float) list.size()) * floatValue))) {
            m22019a(this.f27922h.subList(0, size));
        }
    }

    public void startExtensionAnim() {
        ValueAnimator valueAnimator = this.f27921g;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void cancelExtensionAnim() {
        ValueAnimator valueAnimator = this.f27921g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: b */
    private void m22021b() {
        if (this.f27924j) {
            m22016a();
            startExtensionAnim();
            return;
        }
        m22019a(this.f27922h);
        LineExParam lineExParam = this.f27919e;
        if (lineExParam != null && lineExParam.isHasPulseAnim()) {
            drawPulseLine(this.f27922h);
        }
        OnLineDrawStatusListener onLineDrawStatusListener = this.f27925k;
        if (onLineDrawStatusListener != null) {
            onLineDrawStatusListener.onLineDrawFinished();
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27922h;
    }
}
