package com.didi.map.global.component.collide.strategy4;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollideStrategyV4 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f27099a = "CollideStrategyV2";

    /* renamed from: b */
    private DMarkerMgr f27100b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<Rect> f27101c;

    /* renamed from: d */
    private Map f27102d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f27103e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IDMarkerContractV4 f27104f;

    /* renamed from: g */
    private int f27105g = 0;

    /* renamed from: h */
    private int f27106h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WorkThread f27107i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f27108j;

    /* renamed from: k */
    private Handler f27109k = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 0) {
                return;
            }
            if (CollideStrategyV4.this.f27108j) {
                CollideStrategyV4.this.m21393b();
                return;
            }
            if (CollideStrategyV4.this.f27107i == null) {
                WorkThread unused = CollideStrategyV4.this.f27107i = new WorkThread();
            }
            if (CollideStrategyV4.this.f27107i != null) {
                CollideStrategyV4.this.f27107i.executeTask(new Runnable() {
                    public void run() {
                        CollideStrategyV4.this.m21393b();
                    }
                });
            }
        }
    };
    protected OnCameraChangeListener mCameraChangeListener = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (cameraPosition != null && CollideStrategyV4.this.f27104f.isCanWork() && Math.abs(cameraPosition.zoom - CollideStrategyV4.this.f27103e) >= 0.5d) {
                double unused = CollideStrategyV4.this.f27103e = cameraPosition.zoom;
                CollideStrategyV4.this.m21387a(100);
            }
        }
    };

    public CollideStrategyV4(IDMarkerContractV4 iDMarkerContractV4) {
        this.f27104f = iDMarkerContractV4;
        Map map = iDMarkerContractV4.getMap();
        this.f27102d = map;
        try {
            this.f27108j = "gmap".equals(map.getMapVendor().toString());
        } catch (Exception unused) {
        }
        Map map2 = this.f27102d;
        if (map2 != null) {
            map2.addOnCameraChangeListener(this.mCameraChangeListener);
            this.f27100b = new DMarkerMgr();
            this.f27101c = new ArrayList();
            this.f27103e = this.f27102d.getCameraPosition().zoom;
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        if (this.f27100b != null && (r0 = dMarkerArr.length) > 0) {
            m21386a();
            for (DMarker addMarker : dMarkerArr) {
                this.f27100b.addMarker(addMarker);
            }
            m21387a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f27100b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f27100b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f27100b != null && (r0 = strArr.length) > 0) {
            m21386a();
            for (String removeMarker : strArr) {
                this.f27100b.removeMarker(removeMarker);
            }
            m21387a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21387a(long j) {
        Handler handler;
        IDMarkerContractV4 iDMarkerContractV4 = this.f27104f;
        if (iDMarkerContractV4 != null && iDMarkerContractV4.isCanWork() && (handler = this.f27109k) != null) {
            handler.removeMessages(0);
            this.f27109k.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: a */
    private void m21386a() {
        Handler handler = this.f27109k;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f27102d;
        if (map != null) {
            map.removeOnCameraChangeListener(this.mCameraChangeListener);
        }
        Handler handler = this.f27109k;
        if (handler != null) {
            handler.removeMessages(0);
            this.f27109k = null;
        }
        List<Rect> list = this.f27101c;
        if (list != null) {
            list.clear();
            this.f27101c = null;
        }
        this.f27102d = null;
        this.mCameraChangeListener = null;
        DMarkerMgr dMarkerMgr = this.f27100b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f27100b = null;
        }
        WorkThread workThread = this.f27107i;
        if (workThread != null) {
            workThread.destroy();
            this.f27107i = null;
        }
        this.f27104f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21393b() {
        try {
            if (this.f27102d != null && this.f27102d.getProjection() != null) {
                if (this.f27104f != null) {
                    System.currentTimeMillis();
                    if (this.f27100b == null) {
                        return;
                    }
                    if (!CollectionUtil.isEmpty((Collection<?>) this.f27100b.getAllMarkers())) {
                        List<DMarker> allMarkers = this.f27100b.getAllMarkers();
                        if (allMarkers.size() > 1) {
                            Collections.sort(allMarkers, new Comparator<DMarker>() {
                                public int compare(DMarker dMarker, DMarker dMarker2) {
                                    if (CollideStrategyV4.this.f27104f.getHot(dMarker.f27069id) > CollideStrategyV4.this.f27104f.getHot(dMarker2.f27069id)) {
                                        return -1;
                                    }
                                    return CollideStrategyV4.this.f27104f.getHot(dMarker.f27069id) < CollideStrategyV4.this.f27104f.getHot(dMarker2.f27069id) ? 1 : 0;
                                }
                            });
                        }
                        this.f27101c.clear();
                        for (int i = 0; i < allMarkers.size(); i++) {
                            final DMarker dMarker = allMarkers.get(i);
                            if (!(dMarker == null || dMarker.mRootMarker == null || !StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f27102d) || dMarker.mLabelMarker == null || !dMarker.mLabelMarker.isVisible())) {
                                List<Rect> disabledRect = this.f27104f.getDisabledRect(dMarker.f27069id);
                                final int currentLabelPosition = this.f27104f.getCurrentLabelPosition(dMarker.f27069id);
                                final Rect rect = null;
                                int i2 = currentLabelPosition;
                                Rect rect2 = null;
                                int i3 = 0;
                                int i4 = 0;
                                while (true) {
                                    Rect labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f27102d, dMarker, i2);
                                    if (rect == null) {
                                        rect = labelMarkerRectWithDirect;
                                    }
                                    this.f27105g = 0;
                                    this.f27106h = 0;
                                    m21388a(labelMarkerRectWithDirect, this.f27101c);
                                    m21388a(labelMarkerRectWithDirect, disabledRect);
                                    if (this.f27105g > i3) {
                                        i3 = this.f27105g;
                                        i4 = i2;
                                        rect2 = labelMarkerRectWithDirect;
                                    }
                                    if (this.f27105g != this.f27106h) {
                                        i2 = m21383a(this.f27104f.isLabelDirectClockwise(), this.f27104f.getEnableLabelPosition(dMarker.f27069id), i2);
                                        if (currentLabelPosition == i2) {
                                            DLog.m10773d(f27099a, "都不能完美坐下，循环结束", new Object[0]);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (i4 != 0) {
                                    DLog.m10773d(f27099a, "v2 使用备份方向：" + i4, new Object[0]);
                                    rect = rect2;
                                    currentLabelPosition = i4;
                                } else {
                                    DLog.m10773d(f27099a, "v2 使用默认方向：" + currentLabelPosition, new Object[0]);
                                }
                                this.f27109k.post(new Runnable() {
                                    public void run() {
                                        if (!(rect == null || CollideStrategyV4.this.f27101c == null)) {
                                            CollideStrategyV4.this.f27101c.add(rect);
                                        }
                                        if (CollideStrategyV4.this.f27104f != null && dMarker != null) {
                                            CollideStrategyV4.this.f27104f.setLabelDirect(dMarker.f27069id, currentLabelPosition);
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
    private int m21383a(boolean z, int i, int i2) {
        int a = m21382a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m21383a(z, i, a);
    }

    /* renamed from: a */
    private int m21382a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }

    /* renamed from: a */
    private void m21388a(Rect rect, List<Rect> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && rect != null) {
            this.f27106h += list.size() * 2;
            for (Rect isIntersect : list) {
                if (!StrategyUtil.isIntersect(rect, isIntersect)) {
                    this.f27105g += 2;
                }
            }
        }
    }

    /* renamed from: a */
    private void m21389a(Rect rect, List<LatLng>[] listArr) {
        if (!CollectionUtil.isEmpty((Object[]) listArr) && rect != null) {
            this.f27106h += listArr.length;
            for (List<LatLng> b : listArr) {
                System.currentTimeMillis();
                if (!m21394b(rect, b)) {
                    this.f27105g++;
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m21394b(Rect rect, List<LatLng> list) {
        if (rect != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            int i = 0;
            while (i < list.size() - 1) {
                i++;
                if (m21391a(rect, list.get(i), list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m21391a(Rect rect, LatLng latLng, LatLng latLng2) {
        Map map = this.f27102d;
        if (map == null || map.getProjection() == null || rect == null || !LatLngUtils.locateCorrect(latLng) || !LatLngUtils.locateCorrect(latLng2)) {
            return false;
        }
        return StrategyUtil.isLineIntersectWithRect(rect, this.f27102d.getProjection().toScreenLocation(latLng), this.f27102d.getProjection().toScreenLocation(latLng2));
    }
}
