package com.didi.addressnew.framework.fragmentmarket.map.presenter;

import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.fragmentmarket.map.ISugWayPointPageView;
import com.didi.addressnew.util.CommonUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SugMapWayPointPagePresenter {

    /* renamed from: a */
    private ISugWayPointPageView f9009a;

    /* renamed from: b */
    private WayPointParam f9010b;

    /* renamed from: c */
    private List<Integer> f9011c = new ArrayList();

    /* renamed from: d */
    private List<WayPoint> f9012d = new ArrayList();

    /* renamed from: e */
    private List<WayPoint> f9013e = new ArrayList();

    /* renamed from: f */
    private List<WayPoint> f9014f = new ArrayList();

    /* renamed from: g */
    private List<WayPoint> f9015g = new ArrayList();

    /* renamed from: h */
    private boolean f9016h = true;

    /* renamed from: i */
    private int f9017i = -1;

    public SugMapWayPointPagePresenter(ISugWayPointPageView iSugWayPointPageView, WayPointParam wayPointParam) {
        this.f9009a = iSugWayPointPageView;
        this.f9010b = wayPointParam;
        m7732a();
    }

    /* renamed from: a */
    private void m7732a() {
        WayPointParam wayPointParam = this.f9010b;
        if (wayPointParam != null) {
            List<WayPoint> wayPoints = wayPointParam.getWayPoints();
            if (!CollectionUtil.isEmpty((Collection<?>) wayPoints)) {
                this.f9013e.addAll(m7731a(wayPoints));
            }
            m7738b("loadWayPoints mAllWayPoints.size=" + this.f9013e.size());
            List<Integer> wayPointTypes = this.f9010b.getWayPointTypes();
            if (!CollectionUtil.isEmpty((Collection<?>) wayPointTypes)) {
                this.f9011c.addAll(wayPointTypes);
            }
            m7738b("loadWayTypes mWayPointTypes.size=" + this.f9011c.size() + "mWayPointTypes = " + this.f9011c);
        }
        m7739c();
        m7741d();
        this.f9014f = findWayPointsByType(2, this.f9013e);
        Collections.sort(this.f9013e, C3734xa2c6e2fa.INSTANCE);
        UiThreadHandler.post(new Runnable() {
            public final void run() {
                SugMapWayPointPagePresenter.this.m7743e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m7729a(WayPoint wayPoint, WayPoint wayPoint2) {
        return wayPoint.getWayPointType() - wayPoint2.getWayPointType();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7743e() {
        WayPointParam wayPointParam;
        WayPoint wayPoint = null;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f9011c)) {
            for (WayPoint next : this.f9013e) {
                next.setEditable(this.f9011c.contains(Integer.valueOf(next.getWayPointType())));
                if (this.f9009a.addWayPoint(next)) {
                    m7733a(next);
                }
                if (next.getWayPointType() == 2) {
                    wayPoint = next;
                }
            }
        }
        this.f9009a.onWayPointsUpdated();
        this.f9009a.updatePageContent();
        this.f9009a.updateAddStopEnterVisible(findWayPointsByType(3, this.f9013e).get(0), canAddStop());
        if (wayPoint == null && (wayPointParam = this.f9010b) != null && wayPointParam.isAddDefaultWayPoint()) {
            m7738b("loadWayTypes addDefaultWayPoint is true");
            createStop();
            this.f9009a.onWayPointsUpdated();
        }
    }

    /* renamed from: c */
    private void m7739c() {
        WayPoint wayPoint = null;
        WayPoint wayPoint2 = null;
        for (WayPoint next : this.f9013e) {
            if (next.getWayPointType() == 1) {
                wayPoint = next;
            } else if (next.getWayPointType() == 3) {
                wayPoint2 = next;
            }
        }
        if (wayPoint == null) {
            this.f9013e.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint2 == null) {
            List<WayPoint> list = this.f9013e;
            list.add(list.size(), new WayPoint(3, (Address) null));
        }
    }

    /* renamed from: d */
    private void m7741d() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f9011c)) {
            this.f9011c.add(1);
            this.f9011c.add(2);
            this.f9011c.add(3);
        }
    }

    public List<WayPoint> getValidWayPoints() {
        return this.f9012d;
    }

    public List<WayPoint> getChangedWayPoints() {
        return this.f9015g;
    }

    public boolean canAddStop() {
        return this.f9014f.size() < 2;
    }

    /* renamed from: a */
    private void m7733a(WayPoint wayPoint) {
        if (wayPoint.valid()) {
            if (this.f9012d.indexOf(wayPoint) < 0) {
                this.f9012d.add(wayPoint);
            }
            updateSubmitStatus(this.f9012d);
        }
    }

    public boolean sortWayPoints() {
        List<WayPoint> list = this.f9012d;
        if (list == null || list.size() < 2) {
            return false;
        }
        Collections.sort(this.f9012d, new Comparator<WayPoint>() {
            public int compare(WayPoint wayPoint, WayPoint wayPoint2) {
                int wayPointType;
                int wayPointType2;
                if (wayPoint.getWayPointType() == wayPoint2.getWayPointType() && wayPoint2.getWayPointType() == 2) {
                    wayPointType = SugMapWayPointPagePresenter.this.getStopIndex(wayPoint);
                    wayPointType2 = SugMapWayPointPagePresenter.this.getStopIndex(wayPoint2);
                } else {
                    wayPointType = wayPoint.getWayPointType();
                    wayPointType2 = wayPoint2.getWayPointType();
                }
                return wayPointType - wayPointType2;
            }
        });
        List<WayPoint> list2 = this.f9012d;
        WayPoint wayPoint = list2.get(list2.size() - 1);
        if (wayPoint.getWayPointType() != 3) {
            wayPoint.setWayPointType(3);
        }
        return true;
    }

    public int getStopIndex(WayPoint wayPoint) {
        return this.f9014f.indexOf(wayPoint);
    }

    public void createStop() {
        if (canAddStop()) {
            WayPoint wayPoint = new WayPoint(2, (Address) null);
            m7737b(wayPoint);
            addToStopPoints(wayPoint);
            if (this.f9009a.addWayPoint(wayPoint)) {
                addToChangedWayPoints(wayPoint);
                this.f9009a.updateAddStopEnterVisible(findWayPointsByType(3, this.f9013e).get(0), canAddStop());
                return;
            }
            m7747h(wayPoint);
            m7746g(wayPoint);
        }
    }

    public boolean hasEditableStopPoint() {
        if (this.f9014f.isEmpty()) {
            return false;
        }
        for (WayPoint isEditable : this.f9014f) {
            if (isEditable.isEditable()) {
                return true;
            }
        }
        return false;
    }

    public void addToChangedWayPoints(WayPoint wayPoint) {
        if (wayPoint != null && wayPoint.valid()) {
            int indexOf = this.f9015g.indexOf(wayPoint);
            if (indexOf >= 0) {
                this.f9015g.set(indexOf, wayPoint);
            } else {
                this.f9015g.add(wayPoint);
            }
        }
    }

    /* renamed from: b */
    private void m7737b(WayPoint wayPoint) {
        if (wayPoint != null) {
            if (hasWayPointBy(this.f9013e, 3)) {
                List<WayPoint> list = this.f9013e;
                list.add(list.size() - 1, wayPoint);
            } else {
                this.f9013e.add(wayPoint);
            }
            m7733a(wayPoint);
        }
    }

    public void deleteWayPoint(WayPoint wayPoint) {
        if (wayPoint != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("del_lat", Double.valueOf(wayPoint.getAddress().getLatitude()));
            hashMap.put("del_lng", Double.valueOf(wayPoint.getAddress().getLongitude()));
            if (wayPoint.getWayPointType() == 2) {
                m7740c(wayPoint);
            } else if (wayPoint.getWayPointType() == 3) {
                m7742d(wayPoint);
            }
        }
    }

    /* renamed from: c */
    private void m7740c(WayPoint wayPoint) {
        if (this.f9009a.removeWayPoint(wayPoint)) {
            m7747h(wayPoint);
            m7746g(wayPoint);
            if (m7744e(wayPoint)) {
                m7745f(wayPoint);
            } else {
                addToChangedWayPoints(wayPoint);
            }
            this.f9009a.updateAddStopEnterVisible(findWayPointsByType(3, this.f9013e).get(0), canAddStop());
        }
    }

    /* renamed from: d */
    private void m7742d(WayPoint wayPoint) {
        if (this.f9009a.removeWayPoint(wayPoint)) {
            m7747h(wayPoint);
            m7746g(wayPoint);
            if (m7744e(wayPoint)) {
                m7745f(wayPoint);
            } else {
                addToChangedWayPoints(wayPoint);
            }
            this.f9009a.resetWayPointList();
        }
    }

    /* renamed from: e */
    private boolean m7744e(WayPoint wayPoint) {
        return this.f9015g.indexOf(wayPoint) >= 0;
    }

    /* renamed from: f */
    private void m7745f(WayPoint wayPoint) {
        this.f9015g.remove(wayPoint);
    }

    /* renamed from: g */
    private void m7746g(WayPoint wayPoint) {
        this.f9017i = this.f9014f.indexOf(wayPoint);
        this.f9014f.remove(wayPoint);
        if (this.f9014f.isEmpty()) {
            this.f9017i = -1;
        }
    }

    public void clearStopPoints() {
        this.f9014f.clear();
        this.f9017i = -1;
    }

    /* access modifiers changed from: protected */
    public boolean hasWayPointBy(List<WayPoint> list, int... iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            int i3 = iArr[i];
            Iterator<WayPoint> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getWayPointType() == i3) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                i2++;
            }
            i++;
        }
        if (iArr.length == i2) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    private void m7747h(WayPoint wayPoint) {
        this.f9013e.remove(wayPoint);
        this.f9012d.remove(wayPoint);
        updateSubmitStatus(this.f9012d);
    }

    public void addToStopPoints(WayPoint wayPoint) {
        int i = this.f9017i;
        if (i != -1) {
            this.f9014f.add(i, wayPoint);
        } else {
            this.f9014f.add(wayPoint);
        }
    }

    public void updateSubmitStatus(List<WayPoint> list) {
        if (this.f9009a != null) {
            boolean z = false;
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f9009a.setSubmitEnable(false);
                return;
            }
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (WayPoint next : list) {
                if (CommonUtils.isValidLocation(next.getAddress())) {
                    if (next.getWayPointType() == 1) {
                        z2 = true;
                    } else if (next.getWayPointType() == 2) {
                        z3 = true;
                    } else if (next.getWayPointType() == 3) {
                        z4 = true;
                    }
                }
            }
            ISugWayPointPageView iSugWayPointPageView = this.f9009a;
            if (iSugWayPointPageView != null) {
                if (z2 && (z3 || z4)) {
                    z = true;
                }
                iSugWayPointPageView.setSubmitEnable(z);
            }
        }
    }

    /* renamed from: a */
    private List<WayPoint> m7731a(List<WayPoint> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (WayPoint next : list) {
            if (next.getWayPointType() != 2) {
                arrayList.add(next);
            } else if (i <= 2) {
                arrayList.add(next);
                i++;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> findWayPointsByType(int i, List<WayPoint> list) {
        ArrayList arrayList = new ArrayList();
        for (WayPoint next : list) {
            if (next.getWayPointType() == i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void onAddressResult(Address address, WayPoint wayPoint) {
        m7734a(address, wayPoint);
    }

    /* renamed from: a */
    private void m7734a(Address address, WayPoint wayPoint) {
        if (address != null) {
            if (!m7735a(m7735a(address.poiId) ? address.uid : address.poiId)) {
                Address address2 = wayPoint.getAddress();
                wayPoint.setTripState(0);
                wayPoint.setAddress(address);
                m7733a(wayPoint);
                if (this.f9009a.updateWayPoint(wayPoint)) {
                    addToChangedWayPoints(wayPoint);
                } else {
                    wayPoint.setAddress(address2);
                    m7733a(wayPoint);
                }
                List<WayPoint> findWayPointsByType = findWayPointsByType(3, this.f9013e);
                if (findWayPointsByType != null && !findWayPointsByType.isEmpty()) {
                    this.f9009a.updateAddStopEnterVisible(findWayPointsByType.get(0), canAddStop());
                }
            }
        }
    }

    /* renamed from: a */
    private int m7730a(Address address, String str) {
        if (str == null) {
            return -1;
        }
        for (WayPoint next : this.f9013e) {
            if (str.equals(next.getAddress().poiId) && LatLngUtils.locateCorrect(new LatLng(next.getAddress().getLatitude(), next.getAddress().getLongitude()))) {
                return address.equals(next.getAddress()) ^ true ? 1 : 0;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private boolean m7735a(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    /* renamed from: b */
    private void m7738b(String str) {
        SystemUtils.log(4, "WayPointPresenterDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter", 538);
    }
}
