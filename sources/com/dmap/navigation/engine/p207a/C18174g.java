package com.dmap.navigation.engine.p207a;

import com.didi.map.base.RouteSectionWithName;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IMarkerSection;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.api.route.IRouteTag;
import com.dmap.navigation.api.route.ITunnelGeoPoint;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.location.IPassPoint;
import com.dmap.navigation.base.route.IToastInfo;
import com.dmap.navigation.jni.swig.IntList;
import com.dmap.navigation.jni.swig.MarkerSectionList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.NaviMJOLinkInfo;
import com.dmap.navigation.jni.swig.NaviMJOLinkInfoList;
import com.dmap.navigation.jni.swig.NaviPoi;
import com.dmap.navigation.jni.swig.NaviPoiList;
import com.dmap.navigation.jni.swig.NaviRoadName;
import com.dmap.navigation.jni.swig.NaviRoadNameList;
import com.dmap.navigation.jni.swig.NaviRoute;
import com.dmap.navigation.jni.swig.NaviRouteTag;
import com.dmap.navigation.jni.swig.NaviRouteTagList;
import com.dmap.navigation.jni.swig.PassPoint;
import com.dmap.navigation.jni.swig.PassPointList;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_void;
import com.dmap.navigation.jni.swig.TunnelGeoPointList;
import com.dmap.navigation.simple.SimpleLatlng;
import com.dmap.navigation.simple.SimplePassPoint;
import com.dmap.navigation.simple.SimplePoi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.g */
/* compiled from: SimpleRoute */
public final class C18174g implements IRouteEx {

    /* renamed from: A */
    private final List<DidiMapExt.MJOLinkInfo> f54320A;

    /* renamed from: B */
    private final int f54321B;

    /* renamed from: C */
    private final int f54322C;

    /* renamed from: D */
    private final int f54323D;

    /* renamed from: E */
    private final List<IMarkerSection> f54324E;

    /* renamed from: a */
    private final List<LatLng> f54325a;

    /* renamed from: b */
    private final List<INaviPoi> f54326b;

    /* renamed from: c */
    private final List<IPassPoint> f54327c;

    /* renamed from: d */
    private final ArrayList<Integer> f54328d;

    /* renamed from: e */
    private final ArrayList<LatLng> f54329e;

    /* renamed from: f */
    private final List<LatLng> f54330f;

    /* renamed from: g */
    private final List<RouteSectionWithName> f54331g;

    /* renamed from: h */
    private final Collection<RouteSectionWithName> f54332h;

    /* renamed from: i */
    private final HashMap<String, IRouteTag> f54333i;

    /* renamed from: j */
    private final INaviPoi f54334j;

    /* renamed from: k */
    private final INaviPoi f54335k;

    /* renamed from: l */
    private final double f54336l;

    /* renamed from: m */
    private final SWIGTYPE_p_void f54337m;

    /* renamed from: n */
    private final int f54338n;

    /* renamed from: o */
    private final BigInteger f54339o;

    /* renamed from: p */
    private final byte[] f54340p;

    /* renamed from: q */
    private final byte[] f54341q;

    /* renamed from: r */
    private final int f54342r;

    /* renamed from: s */
    private final int f54343s;

    /* renamed from: t */
    private final int f54344t;

    /* renamed from: u */
    private final boolean f54345u;

    /* renamed from: v */
    private final Object f54346v;

    /* renamed from: w */
    private final List<IToastInfo> f54347w;

    /* renamed from: x */
    private final LinkedList<Integer> f54348x;

    /* renamed from: y */
    private final LinkedList<Integer> f54349y;

    /* renamed from: z */
    private final List<ITunnelGeoPoint> f54350z;

    public C18174g(NaviRoute naviRoute) {
        this((Object) null, naviRoute, (byte[]) null, (byte[]) null, (List<IToastInfo>) null, -1);
    }

    public C18174g(Object obj, NaviRoute naviRoute, byte[] bArr, byte[] bArr2, List<IToastInfo> list, int i) {
        this.f54348x = new LinkedList<>();
        this.f54349y = new LinkedList<>();
        this.f54346v = obj;
        this.f54347w = list;
        this.f54321B = i;
        NaviPoi start = naviRoute.getStart();
        NaviPoi end = naviRoute.getEnd();
        this.f54334j = new SimplePoi(new SimpleLatlng(start.getLatLng().getLat(), start.getLatLng().getLng()), start.getName(), start.getUid());
        this.f54335k = new SimplePoi(new SimpleLatlng(end.getLatLng().getLat(), end.getLatLng().getLng()), end.getName(), end.getUid());
        this.f54336l = naviRoute.getConfidence();
        this.f54337m = naviRoute.getPbHandle();
        this.f54338n = naviRoute.getReqEventType();
        this.f54339o = naviRoute.getRouteId();
        this.f54340p = bArr;
        this.f54341q = bArr2;
        this.f54342r = naviRoute.getTotalDistance();
        this.f54343s = naviRoute.getTotalTime();
        this.f54344t = naviRoute.getLightCount();
        this.f54345u = naviRoute.getHasMjoEvent();
        this.f54322C = naviRoute.getSavingTime();
        this.f54323D = naviRoute.getJamCost();
        NaviLatLngList points = naviRoute.getPoints();
        this.f54325a = new ArrayList((int) points.size());
        for (int i2 = 0; ((long) i2) < points.size(); i2++) {
            NaviLatLng naviLatLng = points.get(i2);
            this.f54325a.add(new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng()));
        }
        NaviPoiList originalPassPoints = naviRoute.getOriginalPassPoints();
        this.f54326b = new ArrayList((int) originalPassPoints.size());
        for (int i3 = 0; ((long) i3) < originalPassPoints.size(); i3++) {
            NaviPoi naviPoi = originalPassPoints.get(i3);
            this.f54326b.add(new SimplePoi(new SimpleLatlng(naviPoi.getLatLng().getLat(), naviPoi.getLatLng().getLng()), naviPoi.getName(), naviPoi.getUid()));
        }
        PassPointList passPoints = naviRoute.getPassPoints();
        this.f54327c = new ArrayList((int) passPoints.size());
        for (int i4 = 0; ((long) i4) < passPoints.size(); i4++) {
            PassPoint passPoint = passPoints.get(i4);
            this.f54327c.add(new SimplePassPoint(passPoint.getPointIndex(), passPoint.getCoorIndex(), new SimpleLatlng(passPoint.getPassPoint().getLatLng().getLat(), passPoint.getPassPoint().getLatLng().getLng())));
        }
        IntList trafficIndexs = naviRoute.getTrafficIndexs();
        this.f54328d = new ArrayList<>((int) trafficIndexs.size());
        for (int i5 = 0; ((long) i5) < trafficIndexs.size(); i5++) {
            this.f54328d.add(Integer.valueOf(trafficIndexs.get(i5)));
        }
        NaviLatLngList trafficPoints = naviRoute.getTrafficPoints();
        this.f54329e = new ArrayList<>((int) trafficPoints.size());
        for (int i6 = 0; ((long) i6) < trafficPoints.size(); i6++) {
            NaviLatLng naviLatLng2 = trafficPoints.get(i6);
            this.f54329e.add(new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng()));
        }
        NaviRouteTagList tagsList = naviRoute.getTagsList();
        this.f54333i = new HashMap<>((int) tagsList.size());
        for (int i7 = 0; ((long) i7) < tagsList.size(); i7++) {
            NaviRouteTag naviRouteTag = tagsList.get(i7);
            this.f54333i.put(naviRouteTag.getKey(), new C18175h(naviRouteTag));
        }
        NaviRoadNameList roadNames = naviRoute.getRoadNames();
        this.f54331g = new ArrayList((int) roadNames.size());
        for (int i8 = 0; ((long) i8) < roadNames.size(); i8++) {
            NaviRoadName naviRoadName = roadNames.get(i8);
            RouteSectionWithName routeSectionWithName = new RouteSectionWithName();
            routeSectionWithName.roadName = MapSerializeUtil.stringToBytesEndNull(naviRoadName.getName());
            routeSectionWithName.startNum = naviRoadName.getStartNum();
            routeSectionWithName.endNum = naviRoadName.getEndNum();
            this.f54331g.add(routeSectionWithName);
        }
        NaviRoadNameList fishboneRoadNames = naviRoute.getFishboneRoadNames();
        this.f54332h = new HashSet((int) fishboneRoadNames.size());
        for (int i9 = 0; ((long) i9) < fishboneRoadNames.size(); i9++) {
            NaviRoadName naviRoadName2 = fishboneRoadNames.get(i9);
            RouteSectionWithName routeSectionWithName2 = new RouteSectionWithName();
            routeSectionWithName2.roadName = MapSerializeUtil.stringToBytesEndNull(naviRoadName2.getName());
            this.f54332h.add(routeSectionWithName2);
        }
        NaviLatLngList lights = naviRoute.getLights();
        this.f54330f = new ArrayList((int) lights.size());
        for (int i10 = 0; ((long) i10) < lights.size(); i10++) {
            NaviLatLng naviLatLng3 = lights.get(i10);
            this.f54330f.add(new SimpleLatlng(naviLatLng3.getLat(), naviLatLng3.getLng()));
        }
        IntList passEtasList = naviRoute.getPassEtasList();
        for (int i11 = 0; ((long) i11) < passEtasList.size(); i11++) {
            this.f54348x.add(i11, Integer.valueOf(passEtasList.get(i11)));
        }
        IntList passEdasList = naviRoute.getPassEdasList();
        for (int i12 = 0; ((long) i12) < passEdasList.size(); i12++) {
            this.f54349y.add(i12, Integer.valueOf(passEdasList.get(i12)));
        }
        TunnelGeoPointList tunnelGeoPointList = naviRoute.getTunnelGeoPointList();
        this.f54350z = new ArrayList((int) tunnelGeoPointList.size());
        for (int i13 = 0; ((long) i13) < tunnelGeoPointList.size(); i13++) {
            this.f54350z.add(new C18178k(tunnelGeoPointList.get(i13)));
        }
        NaviMJOLinkInfoList mjoLinkList = naviRoute.getMjoLinkList();
        this.f54320A = new ArrayList((int) mjoLinkList.size());
        for (int i14 = 0; ((long) i14) < mjoLinkList.size(); i14++) {
            NaviMJOLinkInfo naviMJOLinkInfo = mjoLinkList.get(i14);
            this.f54320A.add(new DidiMapExt.MJOLinkInfo(naviMJOLinkInfo.getLinkId().longValue(), naviMJOLinkInfo.getDirection(), naviMJOLinkInfo.getLinkDistance()));
        }
        MarkerSectionList sections = naviRoute.getSections();
        this.f54324E = new ArrayList((int) sections.size());
        if (sections.size() > 0) {
            for (int i15 = 0; ((long) i15) < sections.size(); i15++) {
                this.f54324E.add(new C18172e(sections.get(i15)));
            }
        }
    }

    public final String toString() {
        return "SimpleRoute{points=" + this.f54325a + ", passPoints=" + this.f54326b + ", routePassPoints=" + this.f54327c + ", trafficIndex=" + this.f54328d + ", trafficInsertPoint=" + this.f54329e + ", lights=" + this.f54330f + ", tags=" + this.f54333i + ", start=" + this.f54334j + ", end=" + this.f54335k + ", confidence=" + this.f54336l + ", reqEventType=" + this.f54338n + ", routeId=" + this.f54339o + ", totalDistance=" + this.f54342r + ", totalTime=" + this.f54343s + ", lightCount=" + this.f54344t + ", hasMjoEvent=" + this.f54345u + ", passEtas=" + this.f54348x + ", passEdas=" + this.f54349y + ", mandatory=" + this.f54321B + ", savingTime=" + this.f54322C + ", jamCost=" + this.f54323D + '}';
    }

    public final double getConfidence() {
        return this.f54336l;
    }

    public final INaviPoi getStart() {
        return this.f54334j;
    }

    public final INaviPoi getEnd() {
        return this.f54335k;
    }

    public final List<INaviPoi> getOriginalPassPoints() {
        return this.f54326b;
    }

    public final List<IToastInfo> getToastInfos() {
        return this.f54347w;
    }

    public final List<IPassPoint> getRoutePassPoints() {
        return this.f54327c;
    }

    public final List<LatLng> getLights() {
        return this.f54330f;
    }

    public final int getRemainTime(int i) {
        if (i > 0 && i < this.f54348x.size()) {
            return this.f54348x.get(i).intValue();
        }
        if (this.f54348x.size() <= 0) {
            return 0;
        }
        LinkedList<Integer> linkedList = this.f54348x;
        return linkedList.get(linkedList.size() - 1).intValue();
    }

    public final int getRemainDistance(int i) {
        if (i > 0 && i < this.f54349y.size()) {
            return this.f54349y.get(i).intValue();
        }
        if (this.f54349y.size() <= 0) {
            return 0;
        }
        LinkedList<Integer> linkedList = this.f54349y;
        return linkedList.get(linkedList.size() - 1).intValue();
    }

    public final void updateEta(int i, int i2) {
        if (i >= 0 && i < this.f54348x.size()) {
            this.f54348x.set(i, Integer.valueOf(i2));
        }
    }

    public final void updateEda(int i, int i2) {
        if (i >= 0 && i < this.f54349y.size()) {
            this.f54349y.set(i, Integer.valueOf(i2));
        }
    }

    public final List<ITunnelGeoPoint> getTunnelGeoPoints() {
        return this.f54350z;
    }

    public final int getReqEventType() {
        return this.f54338n;
    }

    public final SWIGTYPE_p_void getPbHandle() {
        return this.f54337m;
    }

    public final HashMap<String, IRouteTag> getTags() {
        return this.f54333i;
    }

    public final List<RouteSectionWithName> getRoadnames() {
        return this.f54331g;
    }

    public final Collection<RouteSectionWithName> getFishboneRoadnames() {
        return this.f54332h;
    }

    public final boolean hasMjoEvent() {
        return this.f54345u;
    }

    public final BigInteger getRouteId() {
        return this.f54339o;
    }

    public final List<LatLng> getRoutePoints() {
        return this.f54325a;
    }

    public final int getLightCnt() {
        return this.f54344t;
    }

    public final byte[] getTrafficEvent() {
        return this.f54340p;
    }

    public final int getTime() {
        return this.f54343s;
    }

    public final int getDistance() {
        return this.f54342r;
    }

    public final ArrayList<Integer> getRouteTrafficIndex() {
        return this.f54328d;
    }

    public final ArrayList<LatLng> getTrafficInsertPoint() {
        return this.f54329e;
    }

    public final LatLng getTagForPosition(String str) {
        IRouteTag iRouteTag;
        if (!this.f54333i.containsKey(str) || (iRouteTag = this.f54333i.get(str)) == null) {
            return null;
        }
        return iRouteTag.getPosition();
    }

    public final String getTagForValue(String str) {
        IRouteTag iRouteTag;
        if (!this.f54333i.containsKey(str) || (iRouteTag = this.f54333i.get(str)) == null) {
            return null;
        }
        return iRouteTag.getValue();
    }

    public final List<DidiMapExt.MJOLinkInfo> getMjoLinkInfos() {
        return this.f54320A;
    }

    public final byte[] getExtendData() {
        return this.f54341q;
    }

    public final int getMandatory() {
        return this.f54321B;
    }

    public final int getSavingTime() {
        return this.f54322C;
    }

    public final int getJamCost() {
        return this.f54323D;
    }

    public final List<IMarkerSection> getMarkerSections() {
        return this.f54324E;
    }
}
