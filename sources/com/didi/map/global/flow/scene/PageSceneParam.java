package com.didi.map.global.flow.scene;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class PageSceneParam {

    /* renamed from: a */
    private IMapChangeListener f28824a;

    /* renamed from: b */
    private Context f28825b;

    public IMapChangeListener getMapChangeListener() {
        return this.f28824a;
    }

    public Context getContext() {
        return this.f28825b;
    }

    public PageSceneParam(Builder builder) {
        m22409a(builder);
    }

    public void reset(Builder builder) {
        m22409a(builder);
    }

    /* renamed from: a */
    private void m22409a(Builder builder) {
        this.f28824a = builder.mapChangeListener;
        this.f28825b = builder.context;
    }

    protected static abstract class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public IMapChangeListener mapChangeListener;

        protected Builder() {
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            this.mapChangeListener = iMapChangeListener;
            return this;
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }
    }
}
