package com.didi.map.global.flow.scene.order.waiting;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.model.AddressMarkerParam;
import com.didi.map.global.flow.model.StartEndMarkerModel;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class WaitingForReplyParam extends PageSceneParam {

    /* renamed from: a */
    private final float f29473a;

    /* renamed from: b */
    private final StartEndMarkerModel f29474b;

    /* renamed from: c */
    private boolean f29475c;

    /* renamed from: d */
    private int f29476d;

    /* renamed from: e */
    private AddressMarkerParam f29477e;

    public float getZoomLevel() {
        return this.f29473a;
    }

    public StartEndMarkerModel getStartEndMarkerModel() {
        return this.f29474b;
    }

    public boolean isShowWalkLine() {
        return this.f29475c;
    }

    public int getDottedLineColor() {
        return this.f29476d;
    }

    private WaitingForReplyParam(Builder builder) {
        super(builder);
        this.f29473a = builder.zoomLevel;
        this.f29475c = builder.isShowWalkLine;
        this.f29476d = builder.dottedLineColor;
        AddressMarkerParam access$300 = builder.startParam;
        this.f29477e = access$300;
        this.f29474b = new StartEndMarkerModel(access$300.position, this.f29477e.name, this.f29477e.icon, this.f29477e.anchorU, this.f29477e.anchorV, (LatLng) null, (String) null, (Bitmap) null, 0.0f, 1.0f);
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public int dottedLineColor;
        /* access modifiers changed from: private */
        public boolean isShowWalkLine;
        /* access modifiers changed from: private */
        public AddressMarkerParam startParam;
        /* access modifiers changed from: private */
        public float zoomLevel;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder zoomLevel(float f) {
            this.zoomLevel = f;
            return this;
        }

        public Builder isShowWalkLine(boolean z) {
            this.isShowWalkLine = z;
            return this;
        }

        public Builder dottedLineColor(int i) {
            this.dottedLineColor = i;
            return this;
        }

        public Builder startParam(AddressMarkerParam addressMarkerParam) {
            this.startParam = addressMarkerParam;
            return this;
        }

        public WaitingForReplyParam build() {
            return new WaitingForReplyParam(this);
        }
    }
}
