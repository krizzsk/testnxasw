package com.didi.map.global.flow.scene.order.waiting.p124v2;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplyParamV2 */
public class WaitingForReplyParamV2 extends PageSceneParam {

    /* renamed from: a */
    private List<CommonMarkerParam> f29497a;

    /* renamed from: b */
    private Bitmap f29498b;

    /* renamed from: c */
    private CarSlidingParam f29499c;

    private WaitingForReplyParamV2(Builder builder) {
        super(builder);
        this.f29498b = builder.defaultCarBitmap;
        this.f29499c = builder.slidingParam;
        this.f29497a = builder.markerParams;
    }

    public List<CommonMarkerParam> getMarkerParams() {
        return this.f29497a;
    }

    public Bitmap getDefaultCarBitmap() {
        return this.f29498b;
    }

    public CarSlidingParam getSlidingParam() {
        return this.f29499c;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplyParamV2$Builder */
    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public Bitmap defaultCarBitmap;
        /* access modifiers changed from: private */
        public List<CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public CarSlidingParam slidingParam;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder setMarkerParam(List<CommonMarkerParam> list) {
            this.markerParams = list;
            return this;
        }

        public Builder defaultCarBitmap(Bitmap bitmap) {
            this.defaultCarBitmap = bitmap;
            return this;
        }

        public Builder slidingParam(CarSlidingParam carSlidingParam) {
            this.slidingParam = carSlidingParam;
            return this;
        }

        public WaitingForReplyParamV2 build() {
            return new WaitingForReplyParamV2(this);
        }
    }
}
