package com.didi.map.global.component.line.component;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.sdk.util.ToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DotArcLineComponent implements ICompLineContract {
    public static final String TAG = "Arc_line_component";

    /* renamed from: a */
    private Map f27930a;

    /* renamed from: b */
    private Context f27931b;

    /* renamed from: c */
    private LineParams f27932c;

    /* renamed from: d */
    private List<LatLng> f27933d;

    /* renamed from: e */
    private OnLineDrawStatusListener f27934e;

    /* renamed from: f */
    private LatLng f27935f;

    /* renamed from: g */
    private LatLng f27936g;

    /* renamed from: h */
    private ICompLineContract f27937h;

    public void stop() {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f27930a = map;
        this.f27931b = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null && !CollectionUtil.isEmpty((Collection<?>) lineParams.getLinePoints())) {
            if (lineParams.getLinePoints().size() != 2) {
                try {
                    throw new Exception("弧线绘制点集必须为两个");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f27932c = lineParams;
            if (lineParams.getLineColorWithArgb() == 0) {
                this.f27932c.setLineColorWithArgb(Color.parseColor("#262B2E"));
            }
            if (this.f27932c.getLineWidth() == 0) {
                this.f27932c.setLineWidth(6);
            }
            this.f27935f = lineParams.getLinePoints().get(0);
            this.f27936g = lineParams.getLinePoints().get(1);
            this.f27933d = LineUtils.INSTANCE.getCornerLineDots(this.f27935f, this.f27936g);
        }
    }

    public void start() {
        m22025a();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27933d;
    }

    public void destroy() {
        ICompLineContract iCompLineContract = this.f27937h;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f27937h = null;
        }
        List<LatLng> list = this.f27933d;
        if (list != null) {
            list.clear();
            this.f27933d = null;
        }
        this.f27932c = null;
        this.f27931b = null;
        this.f27930a = null;
    }

    public void onMapVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f27937h;
        if (iCompLineContract != null) {
            iCompLineContract.onMapVisible(z);
        }
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27934e = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        ICompLineContract iCompLineContract;
        if (this.f27930a != null && onLineClickListener != null && (iCompLineContract = this.f27937h) != null) {
            iCompLineContract.setLineClickListener(onLineClickListener);
        }
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f27937h;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f27937h;
        if (iCompLineContract != null) {
            return iCompLineContract.getBestViewElements();
        }
        return new ArrayList();
    }

    /* renamed from: a */
    private void m22025a() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27933d)) {
            if (this.f27932c == null) {
                ToastUtil.show(this.f27931b, (CharSequence) "请先添加参数");
                return;
            }
            ICompLineContract iCompLineContract = this.f27937h;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.f27937h = null;
            }
            this.f27932c.setLinePoints(this.f27933d);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f27930a, this.f27931b, this.f27932c);
            this.f27937h = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.start();
            }
            OnLineDrawStatusListener onLineDrawStatusListener = this.f27934e;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public LatLng getArcLineCenter() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f27933d)) {
            return null;
        }
        if (this.f27933d.size() > 2) {
            List<LatLng> list = this.f27933d;
            return list.get(list.size() / 2);
        } else if (!LatLngUtils.locateCorrect(this.f27935f) || !LatLngUtils.locateCorrect(this.f27936g)) {
            return null;
        } else {
            double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(this.f27935f, this.f27936g);
            return DDSphericalUtil.computeOffset(this.f27936g, computeDistanceBetween * 0.5d, DDSphericalUtil.computeHeading(this.f27935f, this.f27936g));
        }
    }

    public void updateLineColor(int i, int i2) {
        ICompLineContract iCompLineContract = this.f27937h;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f27937h = null;
            LineParams lineParams = this.f27932c;
            if (lineParams != null) {
                if (i != 0) {
                    lineParams.setLineColorWithArgb(i);
                }
                if (i2 != this.f27932c.getDottedIconRes()) {
                    this.f27932c.setDottedIconRes(i2);
                }
                m22025a();
            }
        }
    }
}
