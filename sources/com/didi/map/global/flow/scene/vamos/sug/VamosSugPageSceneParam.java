package com.didi.map.global.flow.scene.vamos.sug;

import android.content.Context;
import com.didi.address.model.SugParams;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.flow.scene.global.IDeparturePinInfo;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosSugPageSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private SugParams f29714a;

    /* renamed from: b */
    private IVamosSugSceneCallback f29715b;

    /* renamed from: c */
    private IDeparturePinInfo f29716c;

    /* renamed from: d */
    private PinStyle f29717d;

    /* renamed from: e */
    private int f29718e;

    public IDeparturePinInfo getDeparturePinInfo() {
        return this.f29716c;
    }

    public PinStyle getPinStyleData() {
        return this.f29717d;
    }

    public SugParams getSugParams() {
        return this.f29714a;
    }

    public IVamosSugSceneCallback getSugSceneCallback() {
        return this.f29715b;
    }

    public int getContainer() {
        return this.f29718e;
    }

    private VamosSugPageSceneParam(Builder builder) {
        super(builder);
        this.f29716c = builder.departurePinInfo;
        this.f29717d = builder.pinStyleData;
        this.f29715b = builder.iSugSceneCallback;
        this.f29714a = builder.sugParams;
        this.f29718e = builder.container;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public int container;
        /* access modifiers changed from: private */
        public IDeparturePinInfo departurePinInfo;
        /* access modifiers changed from: private */
        public IVamosSugSceneCallback iSugSceneCallback;
        /* access modifiers changed from: private */
        public PinStyle pinStyleData;
        /* access modifiers changed from: private */
        public SugParams sugParams;

        public Builder actorGetter(IActorGetter iActorGetter) {
            return (Builder) super.actorGetter(iActorGetter);
        }

        public Builder travelId(String str) {
            return (Builder) super.travelId(str);
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder sugSceneCallback(IVamosSugSceneCallback iVamosSugSceneCallback) {
            this.iSugSceneCallback = iVamosSugSceneCallback;
            return this;
        }

        public Builder sugParams(SugParams sugParams2) {
            this.sugParams = sugParams2;
            return this;
        }

        public Builder departurePinInfo(IDeparturePinInfo iDeparturePinInfo) {
            this.departurePinInfo = iDeparturePinInfo;
            return this;
        }

        public Builder pinStyleData(PinStyle pinStyle) {
            this.pinStyleData = pinStyle;
            return this;
        }

        public Builder container(int i) {
            this.container = i;
            return this;
        }

        public VamosSugPageSceneParam build() {
            return new VamosSugPageSceneParam(this);
        }
    }
}
