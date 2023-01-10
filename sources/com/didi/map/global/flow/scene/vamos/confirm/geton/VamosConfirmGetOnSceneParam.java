package com.didi.map.global.flow.scene.vamos.confirm.geton;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.scene.global.IDeparturePinInfo;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.param.PinStyle;
import com.didi.map.sdk.departure.param.RecPointStyle;
import com.didi.sdk.address.address.entity.Address;

public class VamosConfirmGetOnSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private IDeparturePinInfo f29599a;

    /* renamed from: b */
    private LatLng f29600b;

    /* renamed from: c */
    private PinStyle f29601c;

    /* renamed from: d */
    private RecPointStyle f29602d;

    /* renamed from: e */
    private IDepartureCompContract.IDepartueCompCallback f29603e;

    /* renamed from: f */
    private float f29604f;

    /* renamed from: g */
    private boolean f29605g;

    /* renamed from: h */
    private Address f29606h;

    /* renamed from: i */
    private int f29607i;

    public IDeparturePinInfo getPinInfo() {
        return this.f29599a;
    }

    public LatLng getPinStartLatLng() {
        return this.f29600b;
    }

    public PinStyle getPinStyle() {
        return this.f29601c;
    }

    public RecPointStyle getRecPointStyle() {
        return this.f29602d;
    }

    public IDepartureCompContract.IDepartueCompCallback getDeparturePinChangedListener() {
        return this.f29603e;
    }

    public float getZoomLevel() {
        return this.f29604f;
    }

    public boolean isShowGuideLine() {
        return this.f29605g;
    }

    public Address getStartAddress() {
        return this.f29606h;
    }

    public int getGuideLineColor() {
        return this.f29607i;
    }

    private VamosConfirmGetOnSceneParam(Builder builder) {
        super(builder);
        this.f29603e = builder.departurePinChangedListener;
        this.f29607i = builder.guideLineColor;
        this.f29599a = builder.pinInfo;
        this.f29600b = builder.pinStartLatLng;
        this.f29601c = builder.pinStyle;
        this.f29602d = builder.recPointStyle;
        this.f29605g = builder.showGuideLine;
        this.f29606h = builder.startAddress;
        this.f29604f = builder.zoomLevel;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IDepartureCompContract.IDepartueCompCallback departurePinChangedListener;
        /* access modifiers changed from: private */
        public int guideLineColor;
        /* access modifiers changed from: private */
        public IDeparturePinInfo pinInfo;
        /* access modifiers changed from: private */
        public LatLng pinStartLatLng;
        /* access modifiers changed from: private */
        public PinStyle pinStyle;
        /* access modifiers changed from: private */
        public RecPointStyle recPointStyle;
        /* access modifiers changed from: private */
        public boolean showGuideLine;
        /* access modifiers changed from: private */
        public Address startAddress;
        /* access modifiers changed from: private */
        public float zoomLevel = 18.0f;

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

        public Builder departurePinInfo(IDeparturePinInfo iDeparturePinInfo) {
            this.pinInfo = iDeparturePinInfo;
            return this;
        }

        public Builder startLatLng(LatLng latLng) {
            this.pinStartLatLng = latLng;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder recPointStyle(RecPointStyle recPointStyle2) {
            this.recPointStyle = recPointStyle2;
            return this;
        }

        public Builder departueCompCallback(IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback) {
            this.departurePinChangedListener = iDepartueCompCallback;
            return this;
        }

        public Builder guideLineColor(int i) {
            this.guideLineColor = i;
            return this;
        }

        public Builder startAddress(Address address) {
            this.startAddress = address;
            return this;
        }

        public Builder showGuideLine(boolean z) {
            this.showGuideLine = z;
            return this;
        }

        public Builder zoomLevel(float f) {
            if (f < 0.0f) {
                f = 18.0f;
            }
            this.zoomLevel = f;
            return this;
        }

        public VamosConfirmGetOnSceneParam build() {
            return new VamosConfirmGetOnSceneParam(this);
        }
    }
}
