package com.didi.map.global.component.line.pax.over;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.BaseLineRequest;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.line.utils.LineDataConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderTrajLineManager {

    /* renamed from: a */
    private static final String f28149a = "OrderTrajServiceManager";

    /* renamed from: b */
    private Context f28150b;

    /* renamed from: c */
    private Map f28151c;

    /* renamed from: d */
    private ICompLineContract f28152d;

    /* renamed from: e */
    private BaseLineRoute f28153e;

    /* renamed from: f */
    private BaseLineRequest f28154f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnLineDrawStatusListener f28155g;

    /* renamed from: h */
    private int f28156h;

    /* renamed from: i */
    private int f28157i;

    public void create(Context context, Map map, OrderTrajParam orderTrajParam) {
        this.f28150b = context;
        this.f28151c = map;
        if (orderTrajParam != null) {
            this.f28156h = orderTrajParam.getLineColor();
            this.f28157i = orderTrajParam.getLineWidth();
            this.f28154f = orderTrajParam.getRequest();
            this.f28155g = orderTrajParam.getLineDrawStatusListener();
            this.f28153e = LineDataFactory.createLineRoute(this.f28150b, LineDataFactory.LineDataType.ROUTE_TRAJ);
            start();
        }
    }

    public void start() {
        if (this.f28153e != null && this.f28154f != null) {
            OnLineDrawStatusListener onLineDrawStatusListener = this.f28155g;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawStart();
            }
            this.f28153e.start(this.f28154f, new IRouteSearchResultCallback() {
                public void onGetRouteResultError(String str) {
                }

                public void onGetRouteResult(LineDataResponse lineDataResponse) {
                    if (lineDataResponse != null && lineDataResponse.getOrderTrajResponse() != null && !CollectionUtil.isEmpty((Collection<?>) lineDataResponse.getOrderTrajResponse().trajs)) {
                        OrderTrajLineManager.this.m22097a(LineDataConverter.getLatLngListFromDiffGeoPoints(lineDataResponse.getOrderTrajResponse().trajs.get(0)));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22097a(List<LatLng> list) {
        LineParams lineParams = new LineParams(list, this.f28156h, this.f28157i);
        ICompLineContract iCompLineContract = this.f28152d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f28152d = null;
        }
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f28151c, this.f28150b, lineParams);
        this.f28152d = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setListener(new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    if (OrderTrajLineManager.this.f28155g != null) {
                        OrderTrajLineManager.this.f28155g.onLineDrawFinished();
                    }
                }
            });
            this.f28152d.start();
        }
    }

    public void destroy() {
        ICompLineContract iCompLineContract = this.f28152d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f28152d = null;
        }
        BaseLineRoute baseLineRoute = this.f28153e;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f28153e = null;
        }
        this.f28150b = null;
        this.f28151c = null;
    }

    public ICompLineContract getLine() {
        return this.f28152d;
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f28152d;
        if (iCompLineContract == null || CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
            return new ArrayList();
        }
        return this.f28152d.getBestViewElements();
    }
}
