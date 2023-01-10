package com.didi.map.global.flow.scene.mainpage;

import android.content.Context;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.FenceChangeListener;
import com.didi.map.global.flow.scene.global.ICarSlidingChangeListener;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.global.IMapLocationLoadedListener;
import com.didi.map.global.flow.scene.global.IReverseGeoListener;
import com.sdk.poibase.model.AddressParam;

public class MainPageSceneParam extends PageSceneParam {

    /* renamed from: a */
    private IMapLocationLoadedListener f28841a;

    /* renamed from: b */
    private AddressParam f28842b;

    /* renamed from: c */
    private FenceChangeListener f28843c;

    /* renamed from: d */
    private IReverseGeoListener f28844d;

    /* renamed from: e */
    private CarSlidingParam f28845e;

    /* renamed from: f */
    private ICarSlidingChangeListener f28846f;

    /* renamed from: g */
    private boolean f28847g;

    /* renamed from: h */
    private IMapEventCallBack f28848h;

    public IMapLocationLoadedListener getMapLocationLoadedCallback() {
        return this.f28841a;
    }

    public AddressParam getAddressParam() {
        return this.f28842b;
    }

    public FenceChangeListener getFenceChangeListener() {
        return this.f28843c;
    }

    public IReverseGeoListener getReverseGeoListener() {
        return this.f28844d;
    }

    public CarSlidingParam getSlidingParam() {
        return this.f28845e;
    }

    public ICarSlidingChangeListener getCarSlidingChangeListener() {
        return this.f28846f;
    }

    public boolean isSuperAppScene() {
        return this.f28847g;
    }

    public IMapEventCallBack getMapClickListener() {
        return this.f28848h;
    }

    private MainPageSceneParam(Builder builder) {
        super(builder);
        this.f28841a = builder.mapLocationLoadedCallback;
        this.f28842b = builder.addressParam;
        this.f28843c = builder.fenceChangeListener;
        this.f28844d = builder.reverseGeoListener;
        this.f28845e = builder.slidingParam;
        this.f28846f = builder.carSlidingChangeListener;
        this.f28847g = builder.isSuperAppScene;
        this.f28848h = builder.mapClickListener;
    }

    public static class Builder extends PageSceneParam.Builder {
        AddressParam addressParam;
        ICarSlidingChangeListener carSlidingChangeListener;
        FenceChangeListener fenceChangeListener;
        boolean isSuperAppScene;
        IMapEventCallBack mapClickListener;
        IMapLocationLoadedListener mapLocationLoadedCallback;
        IReverseGeoListener reverseGeoListener;
        CarSlidingParam slidingParam;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder locationLoaded(IMapLocationLoadedListener iMapLocationLoadedListener) {
            this.mapLocationLoadedCallback = iMapLocationLoadedListener;
            return this;
        }

        public Builder addressParam(AddressParam addressParam2) {
            this.addressParam = addressParam2;
            return this;
        }

        public Builder fenceChange(FenceChangeListener fenceChangeListener2) {
            this.fenceChangeListener = fenceChangeListener2;
            return this;
        }

        public Builder reverseGeo(IReverseGeoListener iReverseGeoListener) {
            this.reverseGeoListener = iReverseGeoListener;
            return this;
        }

        public Builder slidingParam(CarSlidingParam carSlidingParam) {
            this.slidingParam = carSlidingParam;
            return this;
        }

        public Builder slidingChange(ICarSlidingChangeListener iCarSlidingChangeListener) {
            this.carSlidingChangeListener = iCarSlidingChangeListener;
            return this;
        }

        public Builder isSuperAppScene(boolean z) {
            this.isSuperAppScene = z;
            return this;
        }

        public Builder iMapEventCallBack(IMapEventCallBack iMapEventCallBack) {
            this.mapClickListener = iMapEventCallBack;
            return this;
        }

        public MainPageSceneParam build() {
            return new MainPageSceneParam(this);
        }
    }
}
