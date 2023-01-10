package com.didi.map.global.flow.scene.minibus.component;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkingLine;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniBusLineGroupComponent {

    /* renamed from: a */
    private static final int f28861a = 5;

    /* renamed from: b */
    private static final int f28862b = 3;

    /* renamed from: c */
    private Context f28863c;

    /* renamed from: d */
    private Map f28864d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<CommonLineParam> f28865e;

    /* renamed from: f */
    private HashMap<String, ICompLineContract> f28866f;

    /* renamed from: g */
    private HashMap<String, WalkingLine> f28867g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LineDateListener f28868h;

    /* renamed from: i */
    private BaseLineRoute f28869i;

    /* renamed from: j */
    private int f28870j;

    /* renamed from: k */
    private Integer f28871k = null;

    /* renamed from: l */
    private String f28872l = null;

    /* renamed from: m */
    private String f28873m = null;

    /* renamed from: n */
    private String f28874n = null;

    public interface LineDateListener {
        void onLineDateRequestSuccess();
    }

    public void create(Context context, Map map) {
        this.f28863c = context;
        this.f28864d = map;
        this.f28869i = LineDataFactory.createLineRoute(context, LineDataFactory.LineDataType.ROUTE_MULTI_PLAN);
    }

    public void setConfigParam(List<CommonLineParam> list, int i) {
        this.f28865e = list;
        this.f28870j = i;
    }

    public void setDidiVersion(String str) {
        this.f28872l = str;
    }

    public void setOrderStage(int i) {
        this.f28871k = Integer.valueOf(i);
    }

    public void setProductId(String str) {
        this.f28873m = str;
    }

    public void setOrderId(String str) {
        this.f28874n = str;
    }

    public void setLineDateListener(LineDateListener lineDateListener) {
        this.f28868h = lineDateListener;
    }

    public void destroy() {
        BaseLineRoute baseLineRoute = this.f28869i;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f28869i = null;
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28866f)) {
            for (ICompLineContract next : this.f28866f.values()) {
                if (next != null) {
                    next.destroy();
                }
            }
            this.f28866f.clear();
            this.f28866f = null;
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28867g)) {
            for (WalkingLine next2 : this.f28867g.values()) {
                if (next2 != null) {
                    next2.destroy();
                }
            }
            this.f28867g.clear();
            this.f28867g = null;
        }
        this.f28865e = null;
        this.f28863c = null;
        this.f28864d = null;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28866f)) {
            for (ICompLineContract next : this.f28866f.values()) {
                if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.getBestViewElements())) {
                    arrayList.addAll(next.getBestViewElements());
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28867g)) {
            for (WalkingLine next2 : this.f28867g.values()) {
                if (next2 != null && !CollectionUtil.isEmpty((Collection<?>) next2.getWalkLine())) {
                    arrayList.addAll(next2.getWalkLine());
                }
            }
        }
        return arrayList;
    }

    public List<IMapElement> getBestViewElements(String str) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28866f)) {
            for (Map.Entry next : this.f28866f.entrySet()) {
                String str2 = (String) next.getKey();
                ICompLineContract iCompLineContract = (ICompLineContract) next.getValue();
                if (!(next == null || str2 == null || iCompLineContract == null || !str2.equals(str))) {
                    z = true;
                    if (!CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
                        arrayList.addAll(iCompLineContract.getBestViewElements());
                        return arrayList;
                    }
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28867g) && !z) {
            Iterator<Map.Entry<String, WalkingLine>> it = this.f28867g.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next2 = it.next();
                String str3 = (String) next2.getKey();
                WalkingLine walkingLine = (WalkingLine) next2.getValue();
                if (next2 != null && str3 != null && walkingLine != null && str3.equals(str) && !CollectionUtil.isEmpty((Collection<?>) walkingLine.getWalkLine())) {
                    arrayList.addAll(walkingLine.getWalkLine());
                    break;
                }
            }
        }
        return arrayList;
    }

    public void setLineVisible(boolean z) {
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28866f)) {
            for (ICompLineContract next : this.f28866f.values()) {
                if (next != null) {
                    next.setLineVisible(z);
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f28867g)) {
            for (WalkingLine next2 : this.f28867g.values()) {
                if (next2 != null) {
                    next2.setVisible(z);
                }
            }
        }
    }

    public void start() {
        CallFrom callFrom;
        if (this.f28869i != null && this.f28865e != null) {
            ArrayList arrayList = new ArrayList();
            for (CommonLineParam next : this.f28865e) {
                if (next != null) {
                    arrayList.add(new SingleRouteReqParam(convertToDoublePoint(next.getStartPoint()), convertToDoublePoint(next.getEndPoint()), convertToOdPoints(next.getWayPoints()), next.getLineMode() == 0 ? TravelMode.WALKING : TravelMode.DRIVING));
                }
            }
            if (this.f28870j != 2) {
                callFrom = CallFrom.ORDERROUTEAPI_MINBUS_BUBBULE;
            } else {
                callFrom = CallFrom.ORDERROUTEAPI;
            }
            if (TextUtils.isEmpty(this.f28873m)) {
                this.f28873m = PaxEnvironment.getInstance().getProductId();
            }
            MultiRouteLineRequest multiRouteLineRequest = new MultiRouteLineRequest(callFrom, this.f28873m);
            Integer num = this.f28871k;
            if (num != null) {
                multiRouteLineRequest.setOrderStage(num.intValue());
            }
            if (!TextUtils.isEmpty(this.f28872l)) {
                multiRouteLineRequest.setDidiVersion(this.f28872l);
            }
            multiRouteLineRequest.setLineParams(arrayList);
            if (!TextUtils.isEmpty(this.f28874n)) {
                multiRouteLineRequest.setOrderId(this.f28874n);
            }
            BaseLineRoute baseLineRoute = this.f28869i;
            if (baseLineRoute != null) {
                baseLineRoute.start(multiRouteLineRequest, new IRouteSearchResultCallback() {
                    public void onGetRouteResultError(String str) {
                    }

                    public void onGetRouteResult(LineDataResponse lineDataResponse) {
                        if (lineDataResponse != null && lineDataResponse.getMultiRoutePlanRes() != null) {
                            List<SingleRouteRes> list = lineDataResponse.getMultiRoutePlanRes().routeRes;
                            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                                for (int i = 0; i < list.size(); i++) {
                                    SingleRouteRes singleRouteRes = list.get(i);
                                    CommonLineParam commonLineParam = null;
                                    String str = "";
                                    if (MiniBusLineGroupComponent.this.f28865e != null && i < MiniBusLineGroupComponent.this.f28865e.size()) {
                                        commonLineParam = (CommonLineParam) MiniBusLineGroupComponent.this.f28865e.get(i);
                                        if (MiniBusLineGroupComponent.this.f28865e.get(i) != null) {
                                            str = ((CommonLineParam) MiniBusLineGroupComponent.this.f28865e.get(i)).getId().name();
                                        }
                                    }
                                    if (!(singleRouteRes == null || singleRouteRes.routeGeos == null)) {
                                        List<LatLng> latLngListFromDiffGeoPoints = MiniBusLineGroupComponent.this.getLatLngListFromDiffGeoPoints(singleRouteRes.routeGeos);
                                        int i2 = C104632.$SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode[singleRouteRes.travelMode.ordinal()];
                                        if (i2 == 1) {
                                            MiniBusLineGroupComponent.this.m22489a(latLngListFromDiffGeoPoints, commonLineParam, str);
                                        } else if (i2 == 2) {
                                            MiniBusLineGroupComponent.this.m22486a(singleRouteRes.style == null ? -1 : singleRouteRes.style.intValue(), latLngListFromDiffGeoPoints, commonLineParam, str);
                                        }
                                    }
                                    if (MiniBusLineGroupComponent.this.f28868h != null) {
                                        MiniBusLineGroupComponent.this.f28868h.onLineDateRequestSuccess();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent$2 */
    static /* synthetic */ class C104632 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.sdk.proto.driver_gl.TravelMode[] r0 = com.didi.map.sdk.proto.driver_gl.TravelMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode = r0
                com.didi.map.sdk.proto.driver_gl.TravelMode r1 = com.didi.map.sdk.proto.driver_gl.TravelMode.DRIVING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.proto.driver_gl.TravelMode r1 = com.didi.map.sdk.proto.driver_gl.TravelMode.WALKING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent.C104632.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22486a(int i, List<LatLng> list, CommonLineParam commonLineParam, String str) {
        if (commonLineParam != null) {
            WalkingLine walkingLine = new WalkingLine();
            int lineSpace = commonLineParam.getLineSpace() <= 0 ? 3 : commonLineParam.getLineSpace();
            int lineWidth = commonLineParam.getLineSpace() <= 0 ? 5 : commonLineParam.getLineWidth();
            if (i != 0) {
                if (i == 2) {
                    if (list.size() >= 1) {
                        walkingLine.createA(this.f28863c, this.f28864d, list.get(0), lineWidth, (float) lineSpace, commonLineParam.getLineColor());
                    } else {
                        return;
                    }
                }
            } else if (list.size() >= 2) {
                if (commonLineParam.getAnimate()) {
                    walkingLine.createB(this.f28863c, this.f28864d, list, 10.0f);
                } else {
                    walkingLine.createC(this.f28863c, this.f28864d, list, lineWidth, (float) lineSpace, commonLineParam.getLineColor());
                }
            } else {
                return;
            }
            if (this.f28867g == null) {
                this.f28867g = new HashMap<>();
            }
            this.f28867g.put(str, walkingLine);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22489a(List<LatLng> list, CommonLineParam commonLineParam, String str) {
        if (commonLineParam != null) {
            LineParams lineParams = new LineParams(list, commonLineParam.getLineColor(), commonLineParam.getLineWidth() == 0 ? 6 : commonLineParam.getLineWidth());
            lineParams.setZIndex(11);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f28864d, this.f28863c, lineParams);
            createLineComponent.start();
            if (this.f28866f == null) {
                this.f28866f = new HashMap<>();
            }
            this.f28866f.put(str, createLineComponent);
        }
    }

    public List<LatLng> getLatLngListFromDiffGeoPoints(DiffGeoPoints diffGeoPoints) {
        ArrayList arrayList = new ArrayList();
        if (!(diffGeoPoints == null || diffGeoPoints.base == null)) {
            double floatValue = (double) diffGeoPoints.base.lat.floatValue();
            double floatValue2 = (double) diffGeoPoints.base.lng.floatValue();
            arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
            if (diffGeoPoints.dlats.size() == diffGeoPoints.dlngs.size()) {
                for (int i = 0; i < diffGeoPoints.dlats.size(); i++) {
                    floatValue += ((double) diffGeoPoints.dlats.get(i).intValue()) / 100.0d;
                    floatValue2 += ((double) diffGeoPoints.dlngs.get(i).intValue()) / 100.0d;
                    arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
                }
            }
        }
        return arrayList;
    }

    public List<OdPoint> convertToOdPoints(List<LatLng> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng next : list) {
            arrayList.add(new OdPoint(0L, 0, new DoublePoint.Builder().lat(Float.valueOf((float) next.latitude)).lng(Float.valueOf((float) next.longitude)).build(), "", 0, Float.valueOf(0.0f), 0, (DoublePoint) null, (String) null));
        }
        return arrayList;
    }

    public DoublePoint convertToDoublePoint(LatLng latLng) {
        if (latLng != null) {
            return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).build();
        }
        return null;
    }
}
