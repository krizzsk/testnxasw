package com.didi.map.global.flow.scene.sug;

import android.content.Context;
import com.didi.address.model.SugParams;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class PopSugSceneParam extends PageSceneParam {

    /* renamed from: a */
    private SugParams f29570a;

    /* renamed from: b */
    private ISugSceneCallback f29571b;

    public SugParams getSugParams() {
        return this.f29570a;
    }

    public ISugSceneCallback getSugSceneCallback() {
        return this.f29571b;
    }

    private PopSugSceneParam(Builder builder) {
        super(builder);
        this.f29571b = builder.iSugSceneCallback;
        this.f29570a = builder.sugParams;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public ISugSceneCallback iSugSceneCallback;
        /* access modifiers changed from: private */
        public SugParams sugParams;

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder sugSceneCallback(ISugSceneCallback iSugSceneCallback2) {
            this.iSugSceneCallback = iSugSceneCallback2;
            return this;
        }

        public Builder sugParams(SugParams sugParams2) {
            this.sugParams = sugParams2;
            return this;
        }

        public PopSugSceneParam build() {
            return new PopSugSceneParam(this);
        }
    }
}
