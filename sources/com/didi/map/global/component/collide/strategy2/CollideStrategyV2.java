package com.didi.map.global.component.collide.strategy2;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.sdk.utils.DouglasUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollideStrategyV2 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f27079a = "CollideStrategyV2";

    /* renamed from: b */
    private DMarkerMgr f27080b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<Rect> f27081c;

    /* renamed from: d */
    private List<LatLng>[] f27082d;

    /* renamed from: e */
    private Map f27083e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public double f27084f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDMarkerContractV2 f27085g;

    /* renamed from: h */
    private int f27086h = 0;

    /* renamed from: i */
    private int f27087i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WorkThread f27088j;

    /* renamed from: k */
    private Handler f27089k = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (CollideStrategyV2.this.f27088j == null) {
                    WorkThread unused = CollideStrategyV2.this.f27088j = new WorkThread();
                }
                if (CollideStrategyV2.this.f27088j != null) {
                    CollideStrategyV2.this.f27088j.executeTask(new Runnable() {
                        public void run() {
                            CollideStrategyV2.this.m21365c();
                        }
                    });
                }
            }
        }
    };
    protected OnCameraChangeListener mCameraChangeListener = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (cameraPosition != null && CollideStrategyV2.this.f27085g.isCanWork() && Math.abs(cameraPosition.zoom - CollideStrategyV2.this.f27084f) >= 0.5d) {
                double unused = CollideStrategyV2.this.f27084f = cameraPosition.zoom;
                CollideStrategyV2.this.m21356a(100);
            }
        }
    };

    public CollideStrategyV2(IDMarkerContractV2 iDMarkerContractV2) {
        this.f27085g = iDMarkerContractV2;
        Map map = iDMarkerContractV2.getMap();
        this.f27083e = map;
        if (map != null) {
            map.addOnCameraChangeListener(this.mCameraChangeListener);
            this.f27080b = new DMarkerMgr();
            this.f27081c = new ArrayList();
            this.f27084f = this.f27083e.getCameraPosition().zoom;
        }
    }

    /* renamed from: a */
    private void m21355a() {
        IDMarkerContractV2 iDMarkerContractV2;
        if (this.f27082d == null && (iDMarkerContractV2 = this.f27085g) != null) {
            List<RouteInfo> disabledLines = iDMarkerContractV2.getDisabledLines();
            if (!CollectionUtil.isEmpty((Collection<?>) disabledLines)) {
                this.f27082d = new List[disabledLines.size()];
            }
            for (int i = 0; i < disabledLines.size(); i++) {
                this.f27082d[i] = new DouglasUtil().getDouglasOptimiseLatLngs(disabledLines.get(i).latLngs);
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        if (this.f27080b != null && (r0 = dMarkerArr.length) > 0) {
            m21362b();
            for (DMarker addMarker : dMarkerArr) {
                this.f27080b.addMarker(addMarker);
            }
            m21356a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f27080b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f27080b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f27080b != null && (r0 = strArr.length) > 0) {
            m21362b();
            for (String removeMarker : strArr) {
                this.f27080b.removeMarker(removeMarker);
            }
            m21356a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21356a(long j) {
        Handler handler;
        IDMarkerContractV2 iDMarkerContractV2 = this.f27085g;
        if (iDMarkerContractV2 != null && iDMarkerContractV2.isCanWork() && (handler = this.f27089k) != null) {
            handler.removeMessages(0);
            this.f27089k.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m21362b() {
        Handler handler = this.f27089k;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f27083e;
        if (map != null) {
            map.removeOnCameraChangeListener(this.mCameraChangeListener);
        }
        Handler handler = this.f27089k;
        if (handler != null) {
            handler.removeMessages(0);
            this.f27089k = null;
        }
        List<Rect> list = this.f27081c;
        if (list != null) {
            list.clear();
            this.f27081c = null;
        }
        this.f27083e = null;
        this.f27082d = null;
        this.mCameraChangeListener = null;
        DMarkerMgr dMarkerMgr = this.f27080b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f27080b = null;
        }
        WorkThread workThread = this.f27088j;
        if (workThread != null) {
            workThread.destroy();
            this.f27088j = null;
        }
        this.f27085g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21365c() {
        try {
            if (this.f27083e != null && this.f27083e.getProjection() != null) {
                if (this.f27085g != null) {
                    System.currentTimeMillis();
                    if (this.f27080b == null) {
                        return;
                    }
                    if (!CollectionUtil.isEmpty((Collection<?>) this.f27080b.getAllMarkers())) {
                        m21355a();
                        List<DMarker> allMarkers = this.f27080b.getAllMarkers();
                        if (allMarkers.size() > 1) {
                            Collections.sort(allMarkers, new Comparator<DMarker>() {
                                public int compare(DMarker dMarker, DMarker dMarker2) {
                                    if (CollideStrategyV2.this.f27085g.getHot(dMarker.f27069id) > CollideStrategyV2.this.f27085g.getHot(dMarker2.f27069id)) {
                                        return -1;
                                    }
                                    return CollideStrategyV2.this.f27085g.getHot(dMarker.f27069id) < CollideStrategyV2.this.f27085g.getHot(dMarker2.f27069id) ? 1 : 0;
                                }
                            });
                        }
                        this.f27081c.clear();
                        List<Rect> disabledRect = this.f27085g.getDisabledRect();
                        for (int i = 0; i < allMarkers.size(); i++) {
                            final DMarker dMarker = allMarkers.get(i);
                            if (!(dMarker == null || dMarker.mRootMarker == null || !StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f27083e) || dMarker.mLabelMarker == null || !dMarker.mLabelMarker.isVisible())) {
                                final int currentLabelPosition = this.f27085g.getCurrentLabelPosition(dMarker.f27069id);
                                final Rect rect = null;
                                int i2 = currentLabelPosition;
                                Rect rect2 = null;
                                int i3 = 0;
                                int i4 = 0;
                                while (true) {
                                    Rect labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f27083e, dMarker, i2);
                                    if (rect == null) {
                                        rect = labelMarkerRectWithDirect;
                                    }
                                    this.f27086h = 0;
                                    this.f27087i = 0;
                                    m21357a(labelMarkerRectWithDirect, this.f27081c);
                                    m21357a(labelMarkerRectWithDirect, disabledRect);
                                    m21358a(labelMarkerRectWithDirect, this.f27082d);
                                    if (this.f27086h > i3) {
                                        i3 = this.f27086h;
                                        i4 = i2;
                                        rect2 = labelMarkerRectWithDirect;
                                    }
                                    if (this.f27086h != this.f27087i) {
                                        i2 = m21352a(this.f27085g.isLabelDirectClockwise(), this.f27085g.getEnableLabelPosition(dMarker.f27069id), i2);
                                        if (currentLabelPosition == i2) {
                                            DLog.m10773d(f27079a, "都不能完美坐下，循环结束", new Object[0]);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (i4 != 0) {
                                    DLog.m10773d(f27079a, "v2 使用备份方向：" + i4, new Object[0]);
                                    rect = rect2;
                                    currentLabelPosition = i4;
                                } else {
                                    DLog.m10773d(f27079a, "v2 使用默认方向：" + currentLabelPosition, new Object[0]);
                                }
                                this.f27089k.post(new Runnable() {
                                    public void run() {
                                        if (!(rect == null || CollideStrategyV2.this.f27081c == null)) {
                                            CollideStrategyV2.this.f27081c.add(rect);
                                        }
                                        if (CollideStrategyV2.this.f27085g != null && dMarker != null) {
                                            CollideStrategyV2.this.f27085g.setLabelDirect(dMarker.f27069id, currentLabelPosition);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m21352a(boolean z, int i, int i2) {
        int a = m21351a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m21352a(z, i, a);
    }

    /* renamed from: a */
    private int m21351a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }

    /* renamed from: a */
    private void m21357a(Rect rect, List<Rect> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && rect != null) {
            this.f27087i += list.size() * 2;
            for (Rect isIntersect : list) {
                if (!StrategyUtil.isIntersect(rect, isIntersect)) {
                    this.f27086h += 2;
                }
            }
        }
    }

    /* renamed from: a */
    private void m21358a(Rect rect, List<LatLng>[] listArr) {
        if (!CollectionUtil.isEmpty((Object[]) listArr) && rect != null) {
            this.f27087i += listArr.length;
            for (List<LatLng> b : listArr) {
                System.currentTimeMillis();
                if (!m21363b(rect, b)) {
                    this.f27086h++;
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m21363b(Rect rect, List<LatLng> list) {
        if (rect != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            int i = 0;
            while (i < list.size() - 1) {
                i++;
                if (m21360a(rect, list.get(i), list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m21360a(Rect rect, LatLng latLng, LatLng latLng2) {
        Map map = this.f27083e;
        if (map == null || map.getProjection() == null || rect == null || !LatLngUtils.locateCorrect(latLng) || !LatLngUtils.locateCorrect(latLng2)) {
            return false;
        }
        return StrategyUtil.isLineIntersectWithRect(rect, this.f27083e.getProjection().toScreenLocation(latLng), this.f27083e.getProjection().toScreenLocation(latLng2));
    }
}
