package com.didi.map.global.flow.scene.vamos.confirm.order;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosConfirmOrderSceneParam extends BaseVamosPageSceneParam {

    /* renamed from: a */
    private boolean f29612a;

    /* renamed from: b */
    private int f29613b;

    /* renamed from: c */
    private double f29614c;

    /* renamed from: d */
    private StartEndInfo f29615d;

    /* renamed from: e */
    private StartEndInfo f29616e;

    public boolean isDrawLine() {
        return this.f29612a;
    }

    public int getLineColor() {
        return this.f29613b;
    }

    public double getLineWidth() {
        return this.f29614c;
    }

    public StartEndInfo getStartInfo() {
        return this.f29615d;
    }

    public StartEndInfo getEndInfo() {
        return this.f29616e;
    }

    private VamosConfirmOrderSceneParam(Builder builder) {
        super(builder);
        this.f29612a = builder.isDrawLine;
        this.f29613b = builder.lineColor;
        this.f29614c = builder.lineWidth;
        this.f29615d = builder.startInfo;
        this.f29616e = builder.endInfo;
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        /* access modifiers changed from: private */
        public StartEndInfo endInfo;
        /* access modifiers changed from: private */
        public boolean isDrawLine;
        /* access modifiers changed from: private */
        public int lineColor;
        /* access modifiers changed from: private */
        public double lineWidth;
        /* access modifiers changed from: private */
        public StartEndInfo startInfo;

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

        public Builder drawLine(boolean z) {
            this.isDrawLine = z;
            return this;
        }

        public Builder lineColor(int i) {
            this.lineColor = i;
            return this;
        }

        public Builder lineWidth(double d) {
            this.lineWidth = d;
            return this;
        }

        public Builder startInfo(StartEndInfo startEndInfo) {
            this.startInfo = startEndInfo;
            return this;
        }

        public Builder endInfo(StartEndInfo startEndInfo) {
            this.endInfo = startEndInfo;
            return this;
        }

        public VamosConfirmOrderSceneParam build() {
            return new VamosConfirmOrderSceneParam(this);
        }
    }
}
