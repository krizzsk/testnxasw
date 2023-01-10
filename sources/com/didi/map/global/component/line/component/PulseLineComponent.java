package com.didi.map.global.component.line.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import java.util.ArrayList;
import java.util.List;

public class PulseLineComponent implements ICompLineContract {
    public static final String TAG = "PulseLineComponent";

    /* renamed from: a */
    private LineParams f27962a;

    /* renamed from: b */
    private LineExParam f27963b;

    /* renamed from: c */
    private Context f27964c;

    /* renamed from: d */
    private Map f27965d;

    /* renamed from: e */
    private ValueAnimator f27966e;

    /* renamed from: f */
    private Interpolator f27967f;

    /* renamed from: g */
    private Line f27968g;

    /* renamed from: h */
    private LineOptions f27969h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnLineDrawStatusListener f27970i;

    /* renamed from: j */
    private List<LatLng> f27971j = new ArrayList();

    /* renamed from: k */
    private int f27972k = 0;

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f27964c = context;
        this.f27965d = map;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f27962a = lineParams;
            LineExParam exParam = lineParams.getExParam();
            this.f27963b = exParam;
            this.f27972k = exParam.getPulseAnimDuration() > 0 ? this.f27963b.getPulseAnimDuration() : 1500;
            this.f27971j = this.f27962a.getLinePoints();
            if (this.f27962a.getLineColorWithArgb() == 0) {
                this.f27962a.setLineColorWithArgb(Color.parseColor("#66ffffff"));
            }
            if (this.f27962a.getLineWidth() == 0) {
                this.f27962a.setLineWidth(3);
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f27968g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27970i = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f27965d;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    PulseLineComponent.this.m22029a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22029a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f27968g) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void start() {
        m22027a();
        ValueAnimator valueAnimator = this.f27966e;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.f27966e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void destroy() {
        stop();
        Line line = this.f27968g;
        if (line != null) {
            this.f27965d.remove(line);
            this.f27968g.remove();
            this.f27968g = null;
        }
        this.f27967f = null;
        this.f27964c = null;
        this.f27966e = null;
        this.f27962a = null;
        this.f27969h = null;
        this.f27965d = null;
    }

    public void setLineVisible(boolean z) {
        Line line = this.f27968g;
        if (line != null) {
            line.setVisible(z);
        }
    }

    /* renamed from: a */
    private void m22030a(List<LatLng> list) {
        if (this.f27964c != null && this.f27965d != null && this.f27962a != null) {
            if (this.f27969h == null) {
                LineOptions lineOptions = new LineOptions();
                this.f27969h = lineOptions;
                lineOptions.color(this.f27962a.getLineColorWithArgb());
                this.f27969h.width((double) DisplayUtils.dp2px(this.f27964c, (float) this.f27962a.getLineWidth()));
                this.f27969h.lineEndType(1);
                if (this.f27962a.getZIndex() != 0) {
                    this.f27969h.zIndex(this.f27962a.getZIndex());
                }
                if (this.f27962a.isClickable()) {
                    this.f27969h.clickable(this.f27962a.isClickable());
                }
            }
            Line line = this.f27968g;
            if (line == null) {
                this.f27969h.setPoints(list);
                this.f27968g = this.f27965d.addLine(this.f27969h);
                return;
            }
            line.setPoints(list);
        }
    }

    /* renamed from: a */
    private void m22027a() {
        List<LatLng> list;
        if (this.f27962a != null && (list = this.f27971j) != null && !list.isEmpty() && this.f27965d != null) {
            if (this.f27966e == null) {
                this.f27966e = ValueAnimator.ofInt(new int[]{0, this.f27971j.size()});
            }
            if (this.f27967f == null) {
                this.f27967f = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f27966e.setInterpolator(this.f27967f);
            this.f27966e.setDuration((long) this.f27972k);
            this.f27966e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PulseLineComponent.this.m22028a(valueAnimator);
                }
            });
            this.f27966e.setRepeatMode(1);
            this.f27966e.setRepeatCount(-1);
            this.f27966e.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (PulseLineComponent.this.f27970i != null) {
                        PulseLineComponent.this.f27970i.onLineDrawFinished();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22028a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        List<LatLng> list = this.f27971j;
        if (list != null && intValue < list.size()) {
            m22030a(this.f27971j.subList(0, intValue));
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27971j;
    }
}
