package com.didi.map.global.flow.scene.vamos.sctx.driver.param;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosDriverSctxParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private VamosDriverSctxOrderInfo f29676a;

    /* renamed from: b */
    private IEtaEdaCallback f29677b;

    public VamosDriverSctxOrderInfo getOrderInfo() {
        return this.f29676a;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f29677b;
    }

    private VamosDriverSctxParam(Builder builder) {
        super(builder);
        this.f29677b = builder.etaEdaCallback;
        this.f29676a = builder.orderInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public VamosDriverSctxOrderInfo orderInfo;

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

        public Builder orderInfo(VamosDriverSctxOrderInfo vamosDriverSctxOrderInfo) {
            this.orderInfo = vamosDriverSctxOrderInfo;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public VamosDriverSctxParam build() {
            return new VamosDriverSctxParam(this);
        }
    }
}
