package com.didi.map.global.flow.scene.simple.params;

import android.content.Context;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.simple.IDeparturePinCallback;
import com.didi.sdk.address.address.entity.Address;

public class SimpleSceneParams extends PageSceneParam {

    /* renamed from: a */
    private IDeparturePinCallback f29561a;

    /* renamed from: b */
    private Address f29562b;

    /* renamed from: c */
    private boolean f29563c;

    /* renamed from: d */
    private PinStyle f29564d;

    /* renamed from: e */
    private DepartureLocationInfo f29565e;

    /* renamed from: f */
    private int f29566f;

    private SimpleSceneParams(Builder builder) {
        super(builder);
        this.f29561a = builder.componentCallback;
        this.f29565e = builder.departureLocationInfo;
        this.f29562b = builder.endInfo;
        this.f29563c = builder.hasWayPoint;
        this.f29564d = builder.pinStyle;
        this.f29566f = builder.sceneType;
    }

    public IDeparturePinCallback getDeparturePinCallback() {
        return this.f29561a;
    }

    public Address getEndInfo() {
        return this.f29562b;
    }

    public boolean isHasWayPoint() {
        return this.f29563c;
    }

    public PinStyle getPinStyle() {
        return this.f29564d;
    }

    public DepartureLocationInfo getDepartureLocationInfo() {
        return this.f29565e;
    }

    public int getSceneType() {
        return this.f29566f;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IDeparturePinCallback componentCallback;
        /* access modifiers changed from: private */
        public DepartureLocationInfo departureLocationInfo;
        /* access modifiers changed from: private */
        public Address endInfo;
        /* access modifiers changed from: private */
        public boolean hasWayPoint;
        /* access modifiers changed from: private */
        public PinStyle pinStyle;
        /* access modifiers changed from: private */
        public int sceneType = 0;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder departurePinCallback(IDeparturePinCallback iDeparturePinCallback) {
            this.componentCallback = iDeparturePinCallback;
            return this;
        }

        public Builder endInfo(Address address) {
            this.endInfo = address;
            return this;
        }

        public Builder hasWayPoint(boolean z) {
            this.hasWayPoint = z;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder departureLocationInfo(DepartureLocationInfo departureLocationInfo2) {
            this.departureLocationInfo = departureLocationInfo2;
            return this;
        }

        public Builder sceneType(int i) {
            this.sceneType = i;
            return this;
        }

        public SimpleSceneParams build() {
            return new SimpleSceneParams(this);
        }
    }
}
