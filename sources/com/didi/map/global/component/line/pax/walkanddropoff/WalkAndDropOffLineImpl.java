package com.didi.map.global.component.line.pax.walkanddropoff;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.model.URLHelper;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.LocationSource;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didi.security.uuid.Constants;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.RouteSearchUrls;
import com.didichuxing.routesearchsdk.multi.MultiRouteSearchParam;
import com.didichuxing.routesearchsdk.multi.MultiRouteSearchTask;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010'\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010(\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J \u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\u0012\u00101\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u000eH\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0018\u00105\u001a\u00020\u001b2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010$H\u0002J \u00108\u001a\u00020\u001b2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010$2\u0006\u00109\u001a\u00020\fH\u0002J\u0012\u0010:\u001a\u00020\u001b2\b\u0010;\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010:\u001a\u00020\u001b2\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019XD¢\u0006\u0002\n\u0000¨\u0006="}, mo148868d2 = {"Lcom/didi/map/global/component/line/pax/walkanddropoff/WalkAndDropOffLineImpl;", "Lcom/didi/map/global/component/line/pax/walkanddropoff/IWalkAndDropOffLine;", "()V", "mContext", "Landroid/content/Context;", "mDestPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "mDropOffLine", "Lcom/didi/map/global/component/line/pax/walkanddropoff/DropOffLine;", "mExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "mId", "", "mListener", "Lcom/didi/map/global/component/line/pax/walkanddropoff/onWalkDropChangeListener;", "mMap", "Lcom/didi/common/map/Map;", "mPickupPoint", "mVisible", "", "mWalkDropOffParam", "Lcom/didi/map/global/component/line/pax/walkanddropoff/WalkDropOffParam;", "mWalkingLine", "Lcom/didi/map/global/component/line/pax/walkanddropoff/WalkingLine;", "tag", "", "create", "", "c", "map", "createParamAndRequest", "destroy", "doOraRequest", "param", "Lcom/didichuxing/routesearchsdk/multi/MultiRouteSearchParam;", "getDropOffLine", "", "Lcom/didi/common/map/internal/IMapElement;", "getMyLocDoublePoint", "getReqParamLog", "getWalkLine", "initTreadPool", "corePoolSize", "maximumPoolSize", "keepAliveTime", "", "onMapVisible", "visible", "removeAllLine", "setConfigParam", "setOnWalkDropChangeListener", "listener", "setVisible", "showDropOffLine", "list", "Lcom/didi/common/map/model/LatLng;", "showWalkingLine", "style", "updateLines", "start", "dest", "compLine_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalkAndDropOffLineImpl.kt */
public final class WalkAndDropOffLineImpl implements IWalkAndDropOffLine {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f28167a = "WalkAndDropOffLineImpl";

    /* renamed from: b */
    private WalkDropOffParam f28168b;

    /* renamed from: c */
    private Context f28169c;

    /* renamed from: d */
    private Map f28170d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DoublePoint f28171e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DoublePoint f28172f;

    /* renamed from: g */
    private final ThreadPoolExecutor f28173g = m22101a(5, 5, 3);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f28174h;

    /* renamed from: i */
    private DropOffLine f28175i;

    /* renamed from: j */
    private WalkingLine f28176j;

    /* renamed from: k */
    private onWalkDropChangeListener f28177k;

    /* renamed from: l */
    private boolean f28178l = true;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28169c = context == null ? null : context.getApplicationContext();
        this.f28170d = map;
        DLog.m10773d(this.f28167a, Constants.CREATE_NAME, new Object[0]);
    }

    public void setConfigParam(WalkDropOffParam walkDropOffParam) {
        this.f28168b = walkDropOffParam;
    }

    public void destroy() {
        removeAllLine();
        this.f28174h = 0;
        this.f28173g.shutdownNow();
        DLog.m10773d(this.f28167a, "destroy", new Object[0]);
    }

    public List<IMapElement> getWalkLine() {
        WalkingLine walkingLine = this.f28176j;
        if (walkingLine == null) {
            return null;
        }
        return walkingLine.getWalkLine();
    }

    public List<IMapElement> getDropOffLine() {
        DropOffLine dropOffLine = this.f28175i;
        if (dropOffLine == null) {
            return null;
        }
        return dropOffLine.getDropOffLine();
    }

    public void updateLines(DoublePoint doublePoint, DoublePoint doublePoint2) {
        if (doublePoint != null && doublePoint2 != null) {
            String str = this.f28167a;
            DLog.m10773d(str, "updateLines start= " + doublePoint + ", dest =" + doublePoint2, new Object[0]);
            if (!Intrinsics.areEqual((Object) doublePoint, (Object) this.f28171e) || !Intrinsics.areEqual((Object) doublePoint2, (Object) this.f28172f)) {
                this.f28171e = doublePoint;
                this.f28172f = doublePoint2;
                m22106b();
            }
        }
    }

    public void updateLines(DoublePoint doublePoint) {
        if (doublePoint != null && !Intrinsics.areEqual((Object) doublePoint, (Object) this.f28171e)) {
            DLog.m10773d(this.f28167a, Intrinsics.stringPlus("updateLines start= ", doublePoint), new Object[0]);
            this.f28171e = doublePoint;
            this.f28172f = null;
            m22106b();
        }
    }

    public void setVisible(boolean z) {
        DLog.m10773d(this.f28167a, Intrinsics.stringPlus("updateLines setVisible= ", Boolean.valueOf(z)), new Object[0]);
        this.f28178l = z;
        WalkingLine walkingLine = this.f28176j;
        if (walkingLine != null) {
            walkingLine.setVisible(z);
        }
        DropOffLine dropOffLine = this.f28175i;
        if (dropOffLine != null) {
            dropOffLine.setVisible(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22104a(List<LatLng> list, int i) {
        DLog.m10773d(this.f28167a, Intrinsics.stringPlus("showWalkingLine  style=", Integer.valueOf(i)), new Object[0]);
        WalkingLine walkingLine = this.f28176j;
        if (walkingLine != null) {
            walkingLine.destroy();
        }
        if (this.f28168b == null || this.f28169c == null || this.f28170d == null) {
            DLog.m10773d(this.f28167a, "updateLines mWalkDropOffParam= null", new Object[0]);
        } else if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m10773d(this.f28167a, "showWalkingLine error list isEmpty ", new Object[0]);
        } else if (i == 0) {
            WalkDropOffParam walkDropOffParam = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam);
            if (walkDropOffParam.getAnimate()) {
                if (list != null) {
                    WalkingLine walkingLine2 = new WalkingLine();
                    this.f28176j = walkingLine2;
                    if (walkingLine2 != null) {
                        Context context = this.f28169c;
                        Intrinsics.checkNotNull(context);
                        Map map = this.f28170d;
                        Intrinsics.checkNotNull(map);
                        WalkDropOffParam walkDropOffParam2 = this.f28168b;
                        Intrinsics.checkNotNull(walkDropOffParam2);
                        walkingLine2.createB(context, map, list, walkDropOffParam2.getWalkLineBSpace());
                    }
                    WalkingLine walkingLine3 = this.f28176j;
                    if (walkingLine3 != null) {
                        walkingLine3.setVisible(this.f28178l);
                    }
                }
            } else if (list != null) {
                WalkingLine walkingLine4 = new WalkingLine();
                this.f28176j = walkingLine4;
                if (walkingLine4 != null) {
                    Context context2 = this.f28169c;
                    Intrinsics.checkNotNull(context2);
                    Map map2 = this.f28170d;
                    Intrinsics.checkNotNull(map2);
                    WalkDropOffParam walkDropOffParam3 = this.f28168b;
                    Intrinsics.checkNotNull(walkDropOffParam3);
                    int walkLineAWidth = walkDropOffParam3.getWalkLineAWidth();
                    WalkDropOffParam walkDropOffParam4 = this.f28168b;
                    Intrinsics.checkNotNull(walkDropOffParam4);
                    float walkLineASpace = walkDropOffParam4.getWalkLineASpace();
                    WalkDropOffParam walkDropOffParam5 = this.f28168b;
                    Intrinsics.checkNotNull(walkDropOffParam5);
                    walkingLine4.createC(context2, map2, list, walkLineAWidth, walkLineASpace, walkDropOffParam5.getWalkLineAColor());
                }
                WalkingLine walkingLine5 = this.f28176j;
                if (walkingLine5 != null) {
                    walkingLine5.setVisible(this.f28178l);
                }
            }
        } else if (i == 2) {
            LatLng latLng = null;
            Integer valueOf = list == null ? null : Integer.valueOf(list.size());
            if (valueOf != null && valueOf.intValue() == 1) {
                if (list != null) {
                    latLng = list.get(0);
                }
                LatLng latLng2 = latLng;
                if (latLng2 != null) {
                    WalkingLine walkingLine6 = new WalkingLine();
                    this.f28176j = walkingLine6;
                    if (walkingLine6 != null) {
                        Context context3 = this.f28169c;
                        Intrinsics.checkNotNull(context3);
                        Map map3 = this.f28170d;
                        Intrinsics.checkNotNull(map3);
                        WalkDropOffParam walkDropOffParam6 = this.f28168b;
                        Intrinsics.checkNotNull(walkDropOffParam6);
                        int walkLineAWidth2 = walkDropOffParam6.getWalkLineAWidth();
                        WalkDropOffParam walkDropOffParam7 = this.f28168b;
                        Intrinsics.checkNotNull(walkDropOffParam7);
                        float walkLineASpace2 = walkDropOffParam7.getWalkLineASpace();
                        WalkDropOffParam walkDropOffParam8 = this.f28168b;
                        Intrinsics.checkNotNull(walkDropOffParam8);
                        walkingLine6.createA(context3, map3, latLng2, walkLineAWidth2, walkLineASpace2, walkDropOffParam8.getWalkLineAColor());
                    }
                    WalkingLine walkingLine7 = this.f28176j;
                    if (walkingLine7 != null) {
                        walkingLine7.setVisible(this.f28178l);
                        return;
                    }
                    return;
                }
                return;
            }
            DLog.m10773d(this.f28167a, "showWalkingLine error list isEmpty ", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22103a(List<LatLng> list) {
        if (this.f28170d == null || (this.f28168b == null && CollectionUtil.isEmpty((Collection<?>) list))) {
            DLog.m10773d(this.f28167a, "showDropOffLine error", new Object[0]);
        } else if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m10773d(this.f28167a, "showWalkingLine error list isEmpty ", new Object[0]);
        } else {
            DropOffLine dropOffLine = this.f28175i;
            if (dropOffLine != null) {
                dropOffLine.destroy();
            }
            DropOffLine dropOffLine2 = new DropOffLine();
            this.f28175i = dropOffLine2;
            if (dropOffLine2 != null) {
                Context context = this.f28169c;
                Intrinsics.checkNotNull(context);
                Map map = this.f28170d;
                Intrinsics.checkNotNull(map);
                Intrinsics.checkNotNull(list);
                WalkDropOffParam walkDropOffParam = this.f28168b;
                Intrinsics.checkNotNull(walkDropOffParam);
                int dropOffLineWidth = walkDropOffParam.getDropOffLineWidth();
                WalkDropOffParam walkDropOffParam2 = this.f28168b;
                Intrinsics.checkNotNull(walkDropOffParam2);
                dropOffLine2.create(context, map, list, dropOffLineWidth, walkDropOffParam2.getDropOffLineColor());
            }
            DropOffLine dropOffLine3 = this.f28175i;
            if (dropOffLine3 != null) {
                dropOffLine3.setVisible(this.f28178l);
            }
            onWalkDropChangeListener onwalkdropchangelistener = this.f28177k;
            if (onwalkdropchangelistener != null) {
                Intrinsics.checkNotNull(list);
                onwalkdropchangelistener.onPickPointSnapRoute(list.get(0));
            }
        }
    }

    public void removeAllLine() {
        DLog.m10773d(this.f28167a, "removeAllLine ", new Object[0]);
        this.f28174h = 0;
        this.f28171e = null;
        this.f28172f = null;
        WalkingLine walkingLine = this.f28176j;
        if (walkingLine != null) {
            walkingLine.destroy();
        }
        this.f28176j = null;
        DropOffLine dropOffLine = this.f28175i;
        if (dropOffLine != null) {
            dropOffLine.destroy();
        }
        this.f28175i = null;
    }

    public void setOnWalkDropChangeListener(onWalkDropChangeListener onwalkdropchangelistener) {
        Intrinsics.checkNotNullParameter(onwalkdropchangelistener, "listener");
        this.f28177k = onwalkdropchangelistener;
    }

    /* renamed from: a */
    private final DoublePoint m22100a() {
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f28169c);
        if (lastKnownLocation == null) {
            DLog.m10773d(this.f28167a, "getMyLocDoublePoint null ", new Object[0]);
            return null;
        }
        DLog.m10773d(this.f28167a, "getMyLocDoublePoint ok ", new Object[0]);
        return new DoublePoint.Builder().lat(Float.valueOf((float) lastKnownLocation.getLatitude())).lng(Float.valueOf((float) lastKnownLocation.getLongitude())).dlat(Double.valueOf(lastKnownLocation.getLatitude())).dlng(Double.valueOf(lastKnownLocation.getLongitude())).speed(Integer.valueOf((int) lastKnownLocation.getSpeed())).accuracy(Double.valueOf((double) lastKnownLocation.getAccuracy())).timestamp(Long.valueOf(lastKnownLocation.getTime())).gpsTimestamp(Long.valueOf(lastKnownLocation.getTime())).gpsSource(LocationSource.GPS).build();
    }

    /* renamed from: b */
    private final void m22106b() {
        if (this.f28171e != null && this.f28168b != null) {
            DLog.m10773d(this.f28167a, "createParamAndRequest  ", new Object[0]);
            ArrayList arrayList = new ArrayList();
            DoublePoint a = m22100a();
            if (a != null) {
                arrayList.add(new SingleRouteReqParam(a, this.f28171e, (List<OdPoint>) null, TravelMode.WALKING));
            }
            DoublePoint doublePoint = this.f28172f;
            if (doublePoint != null) {
                arrayList.add(new SingleRouteReqParam(this.f28171e, doublePoint, (List<OdPoint>) null, TravelMode.DRIVING));
            }
            WalkDropOffParam walkDropOffParam = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam);
            String token = walkDropOffParam.getToken();
            WalkDropOffParam walkDropOffParam2 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam2);
            String phoneNum = walkDropOffParam2.getPhoneNum();
            WalkDropOffParam walkDropOffParam3 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam3);
            String countryId = walkDropOffParam3.getCountryId();
            WalkDropOffParam walkDropOffParam4 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam4);
            String productId = walkDropOffParam4.getProductId();
            WalkDropOffParam walkDropOffParam5 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam5);
            long passengerId = walkDropOffParam5.getPassengerId();
            WalkDropOffParam walkDropOffParam6 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam6);
            CallFrom callFrom = walkDropOffParam6.getCallFrom();
            WalkDropOffParam walkDropOffParam7 = this.f28168b;
            Intrinsics.checkNotNull(walkDropOffParam7);
            m22102a(new MultiRouteSearchParam(token, phoneNum, countryId, productId, passengerId, callFrom, walkDropOffParam7.getOrderId(), arrayList));
        }
    }

    /* renamed from: a */
    private final void m22102a(MultiRouteSearchParam multiRouteSearchParam) {
        WalkingLine walkingLine = this.f28176j;
        if (walkingLine != null) {
            walkingLine.destroy();
        }
        this.f28176j = null;
        DropOffLine dropOffLine = this.f28175i;
        if (dropOffLine != null) {
            dropOffLine.destroy();
        }
        this.f28175i = null;
        RouteSearchUrls.setHostGlobal(URLHelper.getUrlHost(this.f28169c));
        int i = this.f28174h + 1;
        this.f28174h = i;
        new MultiRouteSearchTask(i, new WalkAndDropOffLineImpl$doOraRequest$asyncTask$1(this)).executeOnExecutor(this.f28173g, new MultiRouteSearchParam[]{multiRouteSearchParam});
        String str = this.f28167a;
        DLog.m10773d(str, "doOraRequest  param =" + m22105b(multiRouteSearchParam) + ' ', new Object[0]);
    }

    /* renamed from: b */
    private final String m22105b(MultiRouteSearchParam multiRouteSearchParam) {
        if (multiRouteSearchParam == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Intrinsics.stringPlus("caller = ", multiRouteSearchParam.getCaller()));
        stringBuffer.append(Intrinsics.stringPlus(",phoneNum = ", multiRouteSearchParam.getPhoneNum()));
        stringBuffer.append(Intrinsics.stringPlus(",countryId = ", multiRouteSearchParam.getCountryId()));
        stringBuffer.append(Intrinsics.stringPlus(",passengerId = ", Long.valueOf(multiRouteSearchParam.getPassengerId())));
        stringBuffer.append(Intrinsics.stringPlus(",productId = ", multiRouteSearchParam.getProductId()));
        stringBuffer.append(Intrinsics.stringPlus(",token = ", multiRouteSearchParam.getToken()));
        stringBuffer.append(Intrinsics.stringPlus(",routeReq.size = ", Integer.valueOf(multiRouteSearchParam.getRouteReq().size())));
        if (multiRouteSearchParam.getRouteReq().size() > 0) {
            for (SingleRouteReqParam next : multiRouteSearchParam.getRouteReq()) {
                stringBuffer.append(Intrinsics.stringPlus(",{start = ", next.getStart()));
                stringBuffer.append(Intrinsics.stringPlus(",end = ", next.getEnd()));
                stringBuffer.append(",travelMode = " + next.getTravelMode() + " }");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    /* renamed from: a */
    private final ThreadPoolExecutor m22101a(int i, int i2, long j) {
        return new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new ArrayBlockingQueue(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    }
}
