package com.didi.map.global.flow.scene.vamos.orderpreview.param;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;
import com.didi.map.global.flow.scene.vamos.model.VamosMarkerModel;
import com.didi.map.global.flow.scene.vamos.model.VamosMultiLineModel;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;

public class VamosOrderPreviewParams extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private VamosMarkerModel f29631a;

    /* renamed from: b */
    private VamosMultiLineModel f29632b;

    /* renamed from: c */
    private float f29633c;

    /* renamed from: d */
    private IEtaEdaCallback f29634d;

    /* renamed from: e */
    private OrderInfo f29635e;

    public VamosMarkerModel getVamosMarkerModel() {
        return this.f29631a;
    }

    public VamosMultiLineModel getVamosMultiLineModel() {
        return this.f29632b;
    }

    public IEtaEdaCallback getEtaEdaCallback() {
        return this.f29634d;
    }

    public float getMaxMapZoomLevel() {
        return this.f29633c;
    }

    public OrderInfo getOrderInfo() {
        return this.f29635e;
    }

    private VamosOrderPreviewParams(Builder builder) {
        super(builder);
        this.f29633c = 16.7f;
        this.f29634d = builder.etaEdaCallback;
        this.f29633c = builder.mMaxMapZoomLevel;
        this.f29631a = builder.mVamosMarkerModel;
        this.f29632b = builder.mVamosMultiLineModel;
        this.f29635e = builder.orderInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public float mMaxMapZoomLevel = 16.7f;
        /* access modifiers changed from: private */
        public VamosMarkerModel mVamosMarkerModel = new VamosMarkerModel();
        /* access modifiers changed from: private */
        public VamosMultiLineModel mVamosMultiLineModel = new VamosMultiLineModel();
        /* access modifiers changed from: private */
        public OrderInfo orderInfo;

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

        public Builder vamosMarkerModel(VamosMarkerModel vamosMarkerModel) {
            this.mVamosMarkerModel = vamosMarkerModel;
            return this;
        }

        public Builder vamosMultiLineModel(VamosMultiLineModel vamosMultiLineModel) {
            this.mVamosMultiLineModel = vamosMultiLineModel;
            return this;
        }

        public Builder maxMapZoomLevel(float f) {
            this.mMaxMapZoomLevel = f;
            return this;
        }

        public Builder etaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public VamosOrderPreviewParams build() {
            return new VamosOrderPreviewParams(this);
        }
    }
}
