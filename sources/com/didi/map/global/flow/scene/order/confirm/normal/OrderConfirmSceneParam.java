package com.didi.map.global.flow.scene.order.confirm.normal;

import android.content.Context;
import com.didi.map.global.component.departure.view.LoadingInfoWindow;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.simple.IDeparturePinCallback;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public class OrderConfirmSceneParam extends PageSceneParam {

    /* renamed from: a */
    private IDeparturePinCallback f29171a;

    /* renamed from: b */
    private ILineSelectedListener f29172b;

    /* renamed from: c */
    private LoadingInfoWindow.CollideRectCallback f29173c;

    /* renamed from: d */
    private Address f29174d;

    /* renamed from: e */
    private Address f29175e;

    /* renamed from: f */
    private boolean f29176f;

    /* renamed from: g */
    private List<CommonMarkerParam> f29177g;

    /* renamed from: h */
    private Runnable f29178h;

    public Runnable getSlidingSuccessRunnable() {
        return this.f29178h;
    }

    public IDeparturePinCallback getPinCallback() {
        return this.f29171a;
    }

    public ILineSelectedListener getLineSelectedListener() {
        return this.f29172b;
    }

    public Address getStartAddress() {
        return this.f29174d;
    }

    public Address getEndAddress() {
        return this.f29175e;
    }

    public boolean isGuessDestination() {
        return this.f29176f;
    }

    public List<CommonMarkerParam> getMarkerParams() {
        return this.f29177g;
    }

    public LoadingInfoWindow.CollideRectCallback getCollideRectCallback() {
        return this.f29173c;
    }

    public OrderConfirmSceneParam(Builder builder) {
        super(builder);
        this.f29176f = builder.isGuessDestination;
        this.f29171a = builder.pinCallback;
        this.f29178h = builder.slidingSuccessRunnable;
        this.f29172b = builder.lineSelectedListener;
        this.f29174d = builder.startAddress;
        this.f29177g = builder.markerParams;
        this.f29175e = builder.endAddress;
        this.f29173c = builder.collideRectCallback;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public LoadingInfoWindow.CollideRectCallback collideRectCallback;
        /* access modifiers changed from: private */
        public Address endAddress;
        /* access modifiers changed from: private */
        public boolean isGuessDestination;
        /* access modifiers changed from: private */
        public ILineSelectedListener lineSelectedListener;
        /* access modifiers changed from: private */
        public List<CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public IDeparturePinCallback pinCallback;
        /* access modifiers changed from: private */
        public Runnable slidingSuccessRunnable;
        /* access modifiers changed from: private */
        public Address startAddress;

        public /* bridge */ /* synthetic */ PageSceneParam.Builder context(Context context) {
            return super.context(context);
        }

        public /* bridge */ /* synthetic */ PageSceneParam.Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return super.mapChangeListener(iMapChangeListener);
        }

        public Builder setPinCallback(IDeparturePinCallback iDeparturePinCallback) {
            this.pinCallback = iDeparturePinCallback;
            return this;
        }

        public Builder setCollideRectCallback(LoadingInfoWindow.CollideRectCallback collideRectCallback2) {
            this.collideRectCallback = collideRectCallback2;
            return this;
        }

        public Builder setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
            this.lineSelectedListener = iLineSelectedListener;
            return this;
        }

        public Builder setStartAddress(Address address) {
            this.startAddress = address;
            return this;
        }

        public Builder setEndAddress(Address address) {
            this.endAddress = address;
            return this;
        }

        public Builder setGuessDestination(boolean z) {
            this.isGuessDestination = z;
            return this;
        }

        public Builder setMarkerParams(List<CommonMarkerParam> list) {
            this.markerParams = list;
            return this;
        }

        public Builder setCarSlidingSuccessRunnable(Runnable runnable) {
            this.slidingSuccessRunnable = runnable;
            return this;
        }
    }
}
