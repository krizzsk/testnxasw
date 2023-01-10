package com.didi.map.global.flow.scene.vamos.sctx.passenger.param;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.model.StartEndMarkerModel;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;
import java.util.List;

public class VamosSctxSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private OrderParams f29692a;

    /* renamed from: b */
    private StartEndMarkerModel f29693b;

    /* renamed from: c */
    private int f29694c;

    /* renamed from: d */
    private int f29695d;

    /* renamed from: e */
    private ICarBitmapDescriptor f29696e;

    /* renamed from: f */
    private List<String> f29697f;

    /* renamed from: g */
    private ClientParams f29698g;

    /* renamed from: h */
    private IEtaEdaCallback f29699h;

    /* renamed from: i */
    private ISctxStateCallback f29700i;

    /* renamed from: j */
    private IOraOrderStageCallback f29701j;

    /* renamed from: k */
    private LatLng f29702k;

    public OrderParams getOrderParams() {
        return this.f29692a;
    }

    public StartEndMarkerModel getStartEndMarkerModel() {
        return this.f29693b;
    }

    public int getStartAddressNameColorResId() {
        return this.f29694c;
    }

    public int getEndAddressNameColorResId() {
        return this.f29695d;
    }

    public ICarBitmapDescriptor getCarMarkerBitmap() {
        return this.f29696e;
    }

    public List<String> getCarIcons() {
        return this.f29697f;
    }

    public ClientParams getClientParams() {
        return this.f29698g;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f29699h;
    }

    public ISctxStateCallback getSctxStateCallback() {
        return this.f29700i;
    }

    public IOraOrderStageCallback getOraSyncOrderStageCallback() {
        return this.f29701j;
    }

    public LatLng getVamosDriverDestPoint() {
        return this.f29702k;
    }

    private VamosSctxSceneParam(Builder builder) {
        super(builder);
        this.f29692a = builder.orderParams;
        this.f29693b = builder.startEndMarkerModel;
        this.f29694c = builder.startAddressNameColorResId;
        this.f29695d = builder.endAddressNameColorResId;
        this.f29696e = builder.carMarkerBitmap;
        this.f29697f = builder.carIcons;
        this.f29698g = builder.clientParams;
        this.f29699h = builder.etaEdaCallback;
        this.f29700i = builder.sctxStateCallback;
        this.f29701j = builder.oraSyncOrderStageCallback;
        this.f29702k = builder.destPoint;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public List<String> carIcons;
        /* access modifiers changed from: private */
        public ICarBitmapDescriptor carMarkerBitmap;
        /* access modifiers changed from: private */
        public ClientParams clientParams;
        /* access modifiers changed from: private */
        public LatLng destPoint;
        /* access modifiers changed from: private */
        public int endAddressNameColorResId;
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public IOraOrderStageCallback oraSyncOrderStageCallback;
        /* access modifiers changed from: private */
        public OrderParams orderParams;
        /* access modifiers changed from: private */
        public ISctxStateCallback sctxStateCallback;
        /* access modifiers changed from: private */
        public int startAddressNameColorResId;
        /* access modifiers changed from: private */
        public StartEndMarkerModel startEndMarkerModel;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder actorGetter(IActorGetter iActorGetter) {
            return (Builder) super.actorGetter(iActorGetter);
        }

        public Builder travelId(String str) {
            return (Builder) super.travelId(str);
        }

        public Builder orderParams(OrderParams orderParams2) {
            this.orderParams = orderParams2;
            return this;
        }

        public Builder startEndMarkerModel(StartEndMarkerModel startEndMarkerModel2) {
            this.startEndMarkerModel = startEndMarkerModel2;
            return this;
        }

        public Builder startAddressColorResId(int i) {
            this.startAddressNameColorResId = i;
            return this;
        }

        public Builder endAddressColorResId(int i) {
            this.endAddressNameColorResId = i;
            return this;
        }

        public Builder carMarkerBitmap(ICarBitmapDescriptor iCarBitmapDescriptor) {
            this.carMarkerBitmap = iCarBitmapDescriptor;
            return this;
        }

        public Builder carIcons(List<String> list) {
            this.carIcons = list;
            return this;
        }

        public Builder clientParams(ClientParams clientParams2) {
            this.clientParams = clientParams2;
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

        public Builder oraSyncOrderStageCallback(IOraOrderStageCallback iOraOrderStageCallback) {
            this.oraSyncOrderStageCallback = iOraOrderStageCallback;
            return this;
        }

        public Builder destPoint(LatLng latLng) {
            this.destPoint = latLng;
            return this;
        }

        public VamosSctxSceneParam build() {
            return new VamosSctxSceneParam(this);
        }
    }
}
