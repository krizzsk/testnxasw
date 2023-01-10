package com.didi.map.global.flow.scene.order.serving.param;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.IEventCallback;
import com.didi.map.global.flow.scene.order.serving.IGuideEntranceCallback;
import com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback;
import com.didi.map.global.flow.scene.order.serving.IPassBTMStatusCallback;
import com.didi.map.global.flow.scene.order.serving.IPassPointStatusCallback;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.ISecRouteInfoCallback;
import com.didi.map.global.flow.scene.order.serving.ITrafficEventsCallback;
import com.didi.map.global.flow.scene.order.serving.scene.IOdPointsExpiredCallback;
import com.didi.map.global.flow.scene.order.serving.scene.ITripStateCallback;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.HashMap;
import java.util.List;

public class ServingParam extends PageSceneParam {

    /* renamed from: a */
    private Builder f29424a;

    /* renamed from: b */
    private HashMap<MapElementId, CommonMarkerParam> f29425b;

    /* renamed from: c */
    private boolean f29426c;

    /* renamed from: d */
    private ICarBitmapDescriptor f29427d;

    /* renamed from: e */
    private List<String> f29428e;

    /* renamed from: f */
    private OrderParams f29429f;

    /* renamed from: g */
    private ClientParams f29430g;

    /* renamed from: h */
    private boolean f29431h = false;

    /* renamed from: i */
    private boolean f29432i;

    /* renamed from: j */
    private IGuideEntranceCallback f29433j;

    /* renamed from: k */
    private IEtaEdaCallback f29434k;

    /* renamed from: l */
    private ISctxStateCallback f29435l;

    /* renamed from: m */
    private IOraOrderStageCallback f29436m;

    /* renamed from: n */
    private ISecRouteInfoCallback f29437n;

    /* renamed from: o */
    private IEventCallback f29438o;

    /* renamed from: p */
    private IOdPointsExpiredCallback f29439p;

    /* renamed from: q */
    private IPassPointStatusCallback f29440q;

    /* renamed from: r */
    private IPassBTMStatusCallback f29441r;

    /* renamed from: s */
    private ITripStateCallback f29442s;

    /* renamed from: t */
    private ITrafficEventsCallback f29443t;

    public Builder getBuilder() {
        return this.f29424a;
    }

    public OrderParams getOrderParams() {
        return this.f29429f;
    }

    public void setOrderParams(OrderParams orderParams) {
        this.f29429f = orderParams;
    }

    public HashMap<MapElementId, CommonMarkerParam> getMarkerParams() {
        return this.f29425b;
    }

    public CommonMarkerParam getMarkerParam(MapElementId mapElementId) {
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f29425b;
        if (hashMap == null || !hashMap.containsKey(mapElementId)) {
            return null;
        }
        return this.f29425b.get(mapElementId);
    }

    public boolean isNewVersion() {
        return this.f29426c;
    }

    public List<String> getCar3DIcons() {
        return this.f29428e;
    }

    public boolean bReadOnly() {
        return this.f29431h;
    }

    public boolean showGuideEntrance() {
        return this.f29432i;
    }

    public ICarBitmapDescriptor getCarBitmapDescriptor() {
        return this.f29427d;
    }

    public ClientParams getClientParams() {
        return this.f29430g;
    }

    public IGuideEntranceCallback getGuideEntranceCallback() {
        return this.f29433j;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f29434k;
    }

    public ISctxStateCallback getSctxStateCallback() {
        return this.f29435l;
    }

    public IOraOrderStageCallback getOraOrderStageCallback() {
        return this.f29436m;
    }

    public ISecRouteInfoCallback getSecRouteInfoCallback() {
        return this.f29437n;
    }

    public IEventCallback getEventCallback() {
        return this.f29438o;
    }

    public IOdPointsExpiredCallback getOdPointsExpiredCallback() {
        return this.f29439p;
    }

    public IPassPointStatusCallback getPassPointStatusCallback() {
        return this.f29440q;
    }

    public IPassBTMStatusCallback getPassBTMStatusCallback() {
        return this.f29441r;
    }

    public ITripStateCallback getTripStateCallback() {
        return this.f29442s;
    }

    public ITrafficEventsCallback getTrafficEventsCallback() {
        return this.f29443t;
    }

    public ServingParam(Builder builder) {
        super(builder);
        m22799a(builder);
    }

    public void reset(Builder builder) {
        super.reset(builder);
        m22799a(builder);
    }

    /* renamed from: a */
    private void m22799a(Builder builder) {
        this.f29424a = builder;
        this.f29426c = builder.isNewVersion;
        this.f29425b = builder.markerParams;
        this.f29428e = builder.car3DIcons;
        this.f29427d = builder.carBitmapDescriptor;
        this.f29429f = builder.orderParams;
        this.f29430g = builder.clientParams;
        this.f29431h = builder.bReadOnly;
        this.f29432i = builder.showGuideEntrance;
        this.f29433j = builder.guideEntranceCallback;
        this.f29434k = builder.etaEdaCallback;
        this.f29435l = builder.sctxStateCallback;
        this.f29436m = builder.oraOrderStageCallback;
        this.f29437n = builder.secRouteInfoCallback;
        this.f29438o = builder.eventCallback;
        this.f29439p = builder.odPointsExpiredCallback;
        this.f29440q = builder.passPointStatusCallback;
        this.f29441r = builder.passBTMStatusCallback;
        this.f29442s = builder.tripStateCallback;
        this.f29443t = builder.trafficReportCallback;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public boolean bReadOnly;
        /* access modifiers changed from: private */
        public List<String> car3DIcons;
        /* access modifiers changed from: private */
        public ICarBitmapDescriptor carBitmapDescriptor;
        /* access modifiers changed from: private */
        public ClientParams clientParams;
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public IEventCallback eventCallback;
        /* access modifiers changed from: private */
        public IGuideEntranceCallback guideEntranceCallback;
        /* access modifiers changed from: private */
        public boolean isNewVersion;
        /* access modifiers changed from: private */
        public HashMap<MapElementId, CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public IOdPointsExpiredCallback odPointsExpiredCallback;
        /* access modifiers changed from: private */
        public IOraOrderStageCallback oraOrderStageCallback;
        /* access modifiers changed from: private */
        public OrderParams orderParams;
        /* access modifiers changed from: private */
        public IPassBTMStatusCallback passBTMStatusCallback;
        /* access modifiers changed from: private */
        public IPassPointStatusCallback passPointStatusCallback;
        /* access modifiers changed from: private */
        public ISctxStateCallback sctxStateCallback;
        /* access modifiers changed from: private */
        public ISecRouteInfoCallback secRouteInfoCallback;
        public boolean showGuideEntrance;
        /* access modifiers changed from: private */
        public ITrafficEventsCallback trafficReportCallback;
        /* access modifiers changed from: private */
        public ITripStateCallback tripStateCallback;

        public Builder context(Context context) {
            super.context(context);
            return this;
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            super.mapChangeListener(iMapChangeListener);
            return this;
        }

        public Builder isNewVersion(boolean z) {
            this.isNewVersion = z;
            return this;
        }

        public Builder markerParams(HashMap<MapElementId, CommonMarkerParam> hashMap) {
            this.markerParams = hashMap;
            return this;
        }

        public Builder carBitmapDescriptor(ICarBitmapDescriptor iCarBitmapDescriptor) {
            this.carBitmapDescriptor = iCarBitmapDescriptor;
            return this;
        }

        public Builder orderParams(OrderParams orderParams2) {
            this.orderParams = orderParams2;
            return this;
        }

        public Builder clientParams(ClientParams clientParams2) {
            this.clientParams = clientParams2;
            return this;
        }

        public Builder car3DIcons(List<String> list) {
            this.car3DIcons = list;
            return this;
        }

        public Builder bReadOnly(boolean z) {
            this.bReadOnly = z;
            return this;
        }

        public Builder showGuideEntrance(boolean z) {
            this.showGuideEntrance = z;
            return this;
        }

        public Builder guideEntranceCallback(IGuideEntranceCallback iGuideEntranceCallback) {
            this.guideEntranceCallback = iGuideEntranceCallback;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder sctxStateCallback(ISctxStateCallback iSctxStateCallback) {
            this.sctxStateCallback = iSctxStateCallback;
            return this;
        }

        public Builder oraOrderStageCallback(IOraOrderStageCallback iOraOrderStageCallback) {
            this.oraOrderStageCallback = iOraOrderStageCallback;
            return this;
        }

        public Builder secRouteInfoCallback(ISecRouteInfoCallback iSecRouteInfoCallback) {
            this.secRouteInfoCallback = iSecRouteInfoCallback;
            return this;
        }

        public Builder eventCallback(IEventCallback iEventCallback) {
            this.eventCallback = iEventCallback;
            return this;
        }

        public Builder odPointsExpiredCallback(IOdPointsExpiredCallback iOdPointsExpiredCallback) {
            this.odPointsExpiredCallback = iOdPointsExpiredCallback;
            return this;
        }

        public Builder passPointStatusCallback(IPassPointStatusCallback iPassPointStatusCallback) {
            this.passPointStatusCallback = iPassPointStatusCallback;
            return this;
        }

        public Builder passBTMStatusCallback(IPassBTMStatusCallback iPassBTMStatusCallback) {
            this.passBTMStatusCallback = iPassBTMStatusCallback;
            return this;
        }

        public Builder tripStateCallback(ITripStateCallback iTripStateCallback) {
            this.tripStateCallback = iTripStateCallback;
            return this;
        }

        public Builder trafficReportCallback(ITrafficEventsCallback iTrafficEventsCallback) {
            this.trafficReportCallback = iTrafficEventsCallback;
            return this;
        }
    }

    public void dump() {
        Object[] objArr = new Object[2];
        ClientParams clientParams = this.f29430g;
        String str = "";
        objArr[0] = clientParams == null ? str : clientParams.clientVersion;
        ClientParams clientParams2 = this.f29430g;
        if (clientParams2 != null) {
            str = clientParams2.imei;
        }
        objArr[1] = str;
        DLog.m10773d("ServingParam", "[ServingParam] start:%s, end:%s, padding:%s, clientVersion:%s, imei:%s", objArr);
    }
}
