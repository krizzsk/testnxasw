package com.rider.rlab_im_map_plugin.xpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.common.map.util.DisplayUtils;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XPanelLayout extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f58732a;

    /* renamed from: b */
    private Context f58733b;

    /* renamed from: c */
    private double f58734c = 0.0d;

    /* renamed from: d */
    private boolean f58735d = false;

    /* renamed from: e */
    private ArrayList<Map<String, Double>> f58736e = new ArrayList<>();

    /* renamed from: f */
    private double f58737f;

    /* renamed from: g */
    private boolean f58738g;

    /* renamed from: h */
    private boolean f58739h = false;

    public XPanelLayout(Context context) {
        super(context);
        m44413a(context);
    }

    public XPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m44413a(context);
    }

    public XPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m44413a(context);
    }

    /* renamed from: a */
    private void m44413a(Context context) {
        this.f58733b = context;
        this.f58737f = (double) DisplayUtils.getWindowHeight(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup;
        boolean z = ((double) motionEvent.getY()) < this.f58737f - this.f58734c;
        boolean a = m44414a(motionEvent);
        if (!this.f58738g && (viewGroup = this.f58732a) != null && z && !this.f58735d && !a) {
            return viewGroup.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 6) {
            motionEvent.setAction(3);
            return super.dispatchTouchEvent(motionEvent);
        } else if (!this.f58739h) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setAction(3);
            return this.f58732a.dispatchTouchEvent(motionEvent);
        }
    }

    public void setMoveFlag(boolean z) {
        this.f58739h = z;
    }

    public void setSodaMapView(ViewGroup viewGroup) {
        this.f58732a = viewGroup;
    }

    /* renamed from: a */
    private boolean m44414a(MotionEvent motionEvent) {
        ArrayList<Map<String, Double>> arrayList = this.f58736e;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i = 0; i < this.f58736e.size(); i++) {
                Map map = this.f58736e.get(i);
                double doubleValue = ((Double) map.get("x")).doubleValue();
                double doubleValue2 = ((Double) map.get(SameLayerRenderingUtil.KEY_COMP_Y)).doubleValue();
                double doubleValue3 = ((Double) map.get("width")).doubleValue();
                double doubleValue4 = ((Double) map.get("height")).doubleValue();
                float dp2px = (float) DisplayUtils.dp2px(this.f58733b, (float) doubleValue);
                float dp2px2 = (float) DisplayUtils.dp2px(this.f58733b, (float) doubleValue2);
                float dp2px3 = (float) DisplayUtils.dp2px(this.f58733b, (float) doubleValue3);
                float dp2px4 = (float) DisplayUtils.dp2px(this.f58733b, (float) doubleValue4);
                if (motionEvent.getY() > dp2px2 && motionEvent.getY() < dp2px2 + dp2px4 && motionEvent.getX() > dp2px && motionEvent.getX() < dp2px + dp2px3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setScrolling(Boolean bool) {
        this.f58735d = bool.booleanValue();
    }

    public void setMapTouchHeight(Double d) {
        this.f58734c = d.doubleValue();
    }

    public void setHitFrames(List<Map<String, Double>> list) {
        this.f58736e.clear();
        this.f58736e.addAll(list);
    }

    public void setNotHandling(boolean z) {
        this.f58738g = z;
    }
}
