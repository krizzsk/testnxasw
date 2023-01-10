package com.didi.map.global.component.collide.strategy1;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollideStrategyV1 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f27071a = "CollideStrategyV1";

    /* renamed from: b */
    private DMarkerMgr f27072b;

    /* renamed from: c */
    private List<Rect> f27073c;

    /* renamed from: d */
    private Map f27074d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f27075e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IDMarkerContractV1 f27076f;

    /* renamed from: g */
    private OnMapGestureListener f27077g = new OnMapGestureListener() {
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
            if (CollideStrategyV1.this.f27076f != null && !CollideStrategyV1.this.f27076f.isZoomConditionOnly()) {
                CollideStrategyV1.this.m21341a(100);
            }
        }
    };

    /* renamed from: h */
    private Handler f27078h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                CollideStrategyV1.this.m21348c();
            }
        }
    };
    protected OnCameraChangeListener mCameraChangeListener = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (cameraPosition != null && CollideStrategyV1.this.f27076f.isCanWork() && Math.abs(cameraPosition.zoom - CollideStrategyV1.this.f27075e) >= 0.1d) {
                double unused = CollideStrategyV1.this.f27075e = cameraPosition.zoom;
                CollideStrategyV1.this.m21341a(100);
            }
        }
    };

    public CollideStrategyV1(IDMarkerContractV1 iDMarkerContractV1) {
        this.f27076f = iDMarkerContractV1;
    }

    /* renamed from: a */
    private void m21340a() {
        IDMarkerContractV1 iDMarkerContractV1 = this.f27076f;
        if (iDMarkerContractV1 != null && this.f27074d == null) {
            Map map = iDMarkerContractV1.getMap();
            this.f27074d = map;
            if (map != null) {
                map.addOnCameraChangeListener(this.mCameraChangeListener);
                this.f27074d.addOnMapGestureListener(this.f27077g);
                this.f27072b = new DMarkerMgr();
                this.f27073c = new ArrayList();
                this.f27075e = this.f27074d.getCameraPosition().zoom;
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        m21340a();
        if (this.f27072b != null && (r0 = dMarkerArr.length) > 0) {
            m21347b();
            for (DMarker addMarker : dMarkerArr) {
                this.f27072b.addMarker(addMarker);
            }
            m21341a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f27072b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f27072b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f27072b != null && (r0 = strArr.length) > 0) {
            m21347b();
            for (String removeMarker : strArr) {
                this.f27072b.removeMarker(removeMarker);
            }
            m21341a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21341a(long j) {
        Handler handler;
        IDMarkerContractV1 iDMarkerContractV1 = this.f27076f;
        if (iDMarkerContractV1 != null && iDMarkerContractV1.isCanWork() && (handler = this.f27078h) != null) {
            handler.removeMessages(0);
            this.f27078h.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m21347b() {
        Handler handler = this.f27078h;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f27074d;
        if (map != null) {
            map.removeOnCameraChangeListener(this.mCameraChangeListener);
            this.f27074d.removeOnMapGestureListener(this.f27077g);
        }
        Handler handler = this.f27078h;
        if (handler != null) {
            handler.removeMessages(0);
            this.f27078h = null;
        }
        List<Rect> list = this.f27073c;
        if (list != null) {
            list.clear();
            this.f27073c = null;
        }
        this.f27074d = null;
        this.mCameraChangeListener = null;
        this.f27077g = null;
        DMarkerMgr dMarkerMgr = this.f27072b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f27072b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21348c() {
        Rect labelMarkerRectWithDirect;
        boolean z;
        Rect labelMarkerRectWithDirect2;
        Map map = this.f27074d;
        if (map != null && map.getProjection() != null && this.f27076f != null) {
            System.currentTimeMillis();
            DMarkerMgr dMarkerMgr = this.f27072b;
            if (dMarkerMgr == null || CollectionUtil.isEmpty((Collection<?>) dMarkerMgr.getAllMarkers()) || this.f27072b.getAllMarkers().size() <= 1) {
                DLog.m10773d(f27071a, "少于一个点", new Object[0]);
                return;
            }
            List<DMarker> allMarkers = this.f27072b.getAllMarkers();
            Collections.sort(allMarkers, new Comparator<DMarker>() {
                public int compare(DMarker dMarker, DMarker dMarker2) {
                    if (CollideStrategyV1.this.f27076f.isPined(dMarker2.f27069id)) {
                        return 1;
                    }
                    if (CollideStrategyV1.this.f27076f.isPined(dMarker.f27069id)) {
                        return -1;
                    }
                    if (CollideStrategyV1.this.m21344a(dMarker2) && !CollideStrategyV1.this.m21344a(dMarker)) {
                        return 1;
                    }
                    if ((!CollideStrategyV1.this.m21344a(dMarker2) && CollideStrategyV1.this.m21344a(dMarker)) || CollideStrategyV1.this.f27076f.getHot(dMarker.f27069id) > CollideStrategyV1.this.f27076f.getHot(dMarker2.f27069id)) {
                        return -1;
                    }
                    if (CollideStrategyV1.this.f27076f.getHot(dMarker.f27069id) < CollideStrategyV1.this.f27076f.getHot(dMarker2.f27069id)) {
                        return 1;
                    }
                    return 0;
                }
            });
            this.f27073c.clear();
            for (int i = 0; i < allMarkers.size(); i++) {
                DMarker dMarker = allMarkers.get(i);
                if (dMarker != null && StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f27074d)) {
                    if (this.f27076f.isPined(dMarker.f27069id)) {
                        this.f27076f.setVisible(dMarker.f27069id, true);
                        Rect markerRect = StrategyUtil.getMarkerRect(this.f27074d, dMarker.mRootMarker, dMarker.mRootMarkerPadding, true);
                        if (markerRect != null) {
                            this.f27073c.add(markerRect);
                        }
                        if (!this.f27076f.getIsLabelHideWhenPined() && (labelMarkerRectWithDirect2 = StrategyUtil.getLabelMarkerRectWithDirect(this.f27074d, dMarker, this.f27076f.getDefaultLabelPosition())) != null) {
                            this.f27073c.add(labelMarkerRectWithDirect2);
                        }
                    } else if (dMarker.mRootMarker != null) {
                        Rect markerRect2 = StrategyUtil.getMarkerRect(this.f27074d, dMarker.mRootMarker, dMarker.mRootMarkerPadding, true);
                        if (m21343a(markerRect2, this.f27076f.getDisabledRect()) || m21343a(markerRect2, this.f27073c)) {
                            this.f27076f.setVisible(dMarker.f27069id, false);
                        } else if (dMarker.mLabelMarker != null) {
                            int defaultLabelPosition = this.f27076f.getDefaultLabelPosition();
                            int i2 = defaultLabelPosition;
                            while (true) {
                                labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f27074d, dMarker, i2);
                                if (!m21343a(labelMarkerRectWithDirect, this.f27076f.getDisabledRect()) && !m21343a(labelMarkerRectWithDirect, this.f27073c)) {
                                    z = true;
                                    break;
                                }
                                i2 = m21338a(this.f27076f.isLabelDirectClockwise(), this.f27076f.getEnableLabelPosition(), i2);
                                if (defaultLabelPosition == i2) {
                                    z = false;
                                    break;
                                }
                            }
                            if (z) {
                                this.f27076f.setLabelDirect(dMarker.f27069id, i2);
                                this.f27076f.setVisible(dMarker.f27069id, true);
                                this.f27073c.add(labelMarkerRectWithDirect);
                                this.f27073c.add(markerRect2);
                            } else {
                                this.f27076f.setVisible(dMarker.f27069id, false);
                            }
                        } else {
                            this.f27076f.setVisible(dMarker.f27069id, true);
                            this.f27073c.add(markerRect2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m21344a(DMarker dMarker) {
        if (this.f27074d == null || dMarker.mRootMarker.getPosition() == null) {
            return false;
        }
        return LatLngUtils.isSameLatLng(this.f27074d.getCameraPosition().target, dMarker.mRootMarker.getPosition());
    }

    /* renamed from: a */
    private int m21338a(boolean z, int i, int i2) {
        int a = m21337a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m21338a(z, i, a);
    }

    /* renamed from: a */
    private int m21337a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m21343a(Rect rect, List<Rect> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && rect != null) {
            for (Rect isIntersect : list) {
                if (StrategyUtil.isIntersect(rect, isIntersect)) {
                    return true;
                }
            }
        }
        return false;
    }
}
