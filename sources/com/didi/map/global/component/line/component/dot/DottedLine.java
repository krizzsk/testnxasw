package com.didi.map.global.component.line.component.dot;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.utils.LineUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DottedLine implements ICompLineContract {

    /* renamed from: a */
    private static final String f27973a = "DottedLine";

    /* renamed from: b */
    private LineParams f27974b;

    /* renamed from: c */
    private Map f27975c;

    /* renamed from: d */
    private Context f27976d;

    /* renamed from: e */
    private Line f27977e;

    /* renamed from: f */
    private List<LatLng> f27978f;

    /* renamed from: g */
    private OnLineDrawStatusListener f27979g;

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public void create(Context context, Map map) {
        this.f27975c = map;
        this.f27976d = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f27974b = lineParams;
            this.f27978f = lineParams.getLinePoints();
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f27977e;
        if (line != null && line.isVisible()) {
            arrayList.add(this.f27977e);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27979g = onLineDrawStatusListener;
    }

    public void setLineVisible(boolean z) {
        Line line = this.f27977e;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f27975c;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    DottedLine.this.m22031a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22031a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f27977e) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void start() {
        if (!LineUtils.INSTANCE.isMainThread()) {
            throw new RuntimeException("don't run main thread.");
        } else if (this.f27975c != null && this.f27976d != null && !CollectionUtil.isEmpty((Collection<?>) this.f27978f) && this.f27974b != null) {
            clear();
            LineOptions lineOptions = new LineOptions();
            lineOptions.add(this.f27978f);
            lineOptions.type(2);
            lineOptions.lineEndType(1);
            lineOptions.width((double) DisplayUtils.dp2px(this.f27976d, (float) this.f27974b.getLineWidth()));
            lineOptions.spacing((float) DisplayUtils.dp2px(this.f27976d, this.f27974b.getDotSpace()));
            lineOptions.color(this.f27974b.getLineColorWithArgb());
            lineOptions.zIndex(this.f27974b.getZIndex());
            if (this.f27974b.isClickable()) {
                lineOptions.clickable(this.f27974b.isClickable());
            }
            if (this.f27974b.getDottedIconRes() != 0) {
                lineOptions.dottedResType(this.f27974b.getDottedIconRes());
            } else {
                lineOptions.dottedResType(5);
            }
            this.f27977e = this.f27975c.addLine(lineOptions);
            OnLineDrawStatusListener onLineDrawStatusListener = this.f27979g;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27978f;
    }

    public void updateLinePoints(List<LatLng> list) {
        this.f27978f = list;
        Line line = this.f27977e;
        if (line != null) {
            line.setPoints(list);
        } else {
            start();
        }
    }

    public void clear() {
        Map map;
        Line line = this.f27977e;
        if (line != null && (map = this.f27975c) != null) {
            map.remove(line);
            this.f27977e = null;
        }
    }

    public void destroy() {
        clear();
    }
}
