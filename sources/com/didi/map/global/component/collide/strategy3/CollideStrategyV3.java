package com.didi.map.global.component.collide.strategy3;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import java.util.Collection;
import java.util.List;

public class CollideStrategyV3 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f27093a = "CollideStrategyV3";

    /* renamed from: b */
    private DMarkerMgr f27094b;

    /* renamed from: c */
    private Map f27095c;

    /* renamed from: d */
    private IDMarkerContractV3 f27096d;

    /* renamed from: e */
    private OnMapGestureListener f27097e = new OnMapGestureListener() {
        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onDown(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public boolean onScroll(float f, float f2) {
            return false;
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        public boolean onUp(float f, float f2) {
            return false;
        }

        public void onMapStable() {
            CollideStrategyV3.this.m21373a(100);
        }
    };

    /* renamed from: f */
    private Handler f27098f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                CollideStrategyV3.this.m21379c();
            }
        }
    };

    public CollideStrategyV3(IDMarkerContractV3 iDMarkerContractV3) {
        this.f27096d = iDMarkerContractV3;
    }

    /* renamed from: a */
    private void m21372a() {
        IDMarkerContractV3 iDMarkerContractV3 = this.f27096d;
        if (iDMarkerContractV3 != null && this.f27095c == null) {
            Map map = iDMarkerContractV3.getMap();
            this.f27095c = map;
            if (map != null) {
                map.addOnMapGestureListener(this.f27097e);
                this.f27094b = new DMarkerMgr();
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        m21372a();
        if (this.f27094b != null && (r0 = dMarkerArr.length) > 0) {
            m21377b();
            for (DMarker addMarker : dMarkerArr) {
                this.f27094b.addMarker(addMarker);
            }
            m21373a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f27094b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f27094b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f27094b != null && (r0 = strArr.length) > 0) {
            m21377b();
            for (String removeMarker : strArr) {
                this.f27094b.removeMarker(removeMarker);
            }
            m21373a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21373a(long j) {
        Handler handler;
        IDMarkerContractV3 iDMarkerContractV3 = this.f27096d;
        if (iDMarkerContractV3 != null && iDMarkerContractV3.isCanWork() && (handler = this.f27098f) != null) {
            handler.removeMessages(0);
            this.f27098f.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m21377b() {
        Handler handler = this.f27098f;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f27095c;
        if (map != null) {
            map.removeOnMapGestureListener(this.f27097e);
        }
        Handler handler = this.f27098f;
        if (handler != null) {
            handler.removeMessages(0);
            this.f27098f = null;
        }
        this.f27095c = null;
        this.f27097e = null;
        DMarkerMgr dMarkerMgr = this.f27094b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f27094b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21379c() {
        DMarkerMgr dMarkerMgr;
        Map map = this.f27095c;
        if (map != null && map.getProjection() != null && this.f27096d != null && (dMarkerMgr = this.f27094b) != null && !CollectionUtil.isEmpty((Collection<?>) dMarkerMgr.getAllMarkers())) {
            boolean z = false;
            DMarker dMarker = this.f27094b.getAllMarkers().get(0);
            if (dMarker != null && StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f27095c) && dMarker.mRootMarker != null && dMarker.mLabelMarker != null) {
                int defaultLabelPosition = this.f27096d.getDefaultLabelPosition();
                int i = defaultLabelPosition;
                while (true) {
                    Rect labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f27095c, dMarker, i);
                    if (!m21376a(labelMarkerRectWithDirect) && !m21378b(labelMarkerRectWithDirect)) {
                        z = true;
                        break;
                    }
                    i = m21371a(true, this.f27096d.getEnableLabelPosition(), i);
                    if (defaultLabelPosition == i) {
                        break;
                    }
                }
                if (z) {
                    this.f27096d.setLabelDirect(dMarker.f27069id, i);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m21376a(Rect rect) {
        Rect d = m21380d();
        return d == null || d.left >= rect.left || d.right <= rect.right || d.top >= rect.top || d.bottom <= rect.bottom;
    }

    /* renamed from: b */
    private boolean m21378b(Rect rect) {
        List<Rect> collideAvoidRect;
        IDMarkerContractV3 iDMarkerContractV3 = this.f27096d;
        if (iDMarkerContractV3 == null || (collideAvoidRect = iDMarkerContractV3.getCollideAvoidRect()) == null) {
            return false;
        }
        for (Rect next : collideAvoidRect) {
            if (!(next == null || rect == null)) {
                int max = Math.max(next.right, rect.right);
                int min = Math.min(next.left, rect.left);
                int max2 = Math.max(next.bottom, rect.bottom);
                int min2 = Math.min(next.top, rect.top);
                int abs = Math.abs(max - min);
                int abs2 = Math.abs(max2 - min2);
                if (Math.abs(next.right - next.left) + Math.abs(rect.right - rect.left) >= abs && Math.abs(next.bottom - next.top) + Math.abs(rect.bottom - rect.top) >= abs2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    private Rect m21380d() {
        IDMarkerContractV3 iDMarkerContractV3;
        if (this.f27095c == null || (iDMarkerContractV3 = this.f27096d) == null || iDMarkerContractV3.getPadding() == null) {
            return null;
        }
        Rect rect = new Rect();
        Padding padding = this.f27096d.getPadding();
        rect.left = padding.left;
        rect.right = this.f27095c.getWidth() - padding.right;
        rect.top = padding.top;
        rect.bottom = padding.bottom;
        DLog.m10773d(f27093a, "屏幕可视区域：" + rect.toString(), new Object[0]);
        return rect;
    }

    /* renamed from: a */
    private int m21371a(boolean z, int i, int i2) {
        int a = m21370a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m21371a(z, i, a);
    }

    /* renamed from: a */
    private int m21370a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }
}
