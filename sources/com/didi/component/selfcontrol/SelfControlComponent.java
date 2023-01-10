package com.didi.component.selfcontrol;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.config.IComponentEx;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.util.CLog;
import com.didi.component.selfcontrol.InflateController;

public abstract class SelfControlComponent<V extends IView, P extends IPresenter, C extends InflateController> implements IComponentEx {
    public static final String BUNDLE_KEY_MUST_INFLATE = "BUNDLE_KEY_MUST_INFLATE";

    /* renamed from: a */
    private V f17376a;

    /* renamed from: b */
    private P f17377b;

    /* renamed from: c */
    private ComponentParams f17378c;

    /* renamed from: d */
    private Bundle f17379d;
    protected C mInflateController;
    public boolean mIsDefaultVisible = true;

    /* access modifiers changed from: protected */
    @Deprecated
    public void bind(ComponentParams componentParams, V v, P p) {
    }

    /* access modifiers changed from: protected */
    public abstract C createInflateController();

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    /* access modifiers changed from: protected */
    public abstract V onCreateView(ComponentParams componentParams, ViewGroup viewGroup);

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        this.mInflateController = createInflateController();
        if (m14594a(componentParams) || componentParams.extras.getBoolean(BUNDLE_KEY_MUST_INFLATE, false)) {
            this.mIsDefaultVisible = m14595b(componentParams);
            m14593a(componentParams, viewGroup);
            return;
        }
        CLog.m12101w("SelfControlComponent@init, " + componentParams.type + " is not allow to inflate.");
    }

    /* renamed from: a */
    private boolean m14594a(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.shouldInflate(componentParams);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m14595b(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.isVisible(componentParams);
        }
        return true;
    }

    /* renamed from: a */
    private void m14593a(ComponentParams componentParams, ViewGroup viewGroup) {
        V v;
        m14596c(componentParams);
        this.f17378c = componentParams;
        this.f17376a = onCreateView(componentParams, viewGroup);
        P onCreatePresenter = onCreatePresenter(componentParams);
        this.f17377b = onCreatePresenter;
        if (!(onCreatePresenter == null || (v = this.f17376a) == null)) {
            onCreatePresenter.setIView(v);
            this.f17376a.setPresenter(this.f17377b);
        }
        bind(componentParams, this.f17376a, this.f17377b);
    }

    public void setExtras(Bundle bundle) {
        this.f17379d = bundle;
    }

    public <T> T getExtra(String str) {
        Bundle bundle = this.f17379d;
        if (bundle == null) {
            return null;
        }
        return bundle.get(str);
    }

    public void changeVisible(boolean z) {
        V v;
        if (this.mIsDefaultVisible != z && (v = this.f17376a) != null) {
            this.mIsDefaultVisible = z;
            if (v.getView() != null) {
                this.f17376a.getView().setVisibility(z ? 0 : 8);
            }
        }
    }

    public V getView() {
        return this.f17376a;
    }

    public P getPresenter() {
        return this.f17377b;
    }

    public ComponentParams getParams() {
        return this.f17378c;
    }

    /* renamed from: c */
    private void m14596c(ComponentParams componentParams) {
        Bundle bundle;
        if (componentParams != null && (bundle = this.f17379d) != null && !bundle.isEmpty()) {
            componentParams.extras.putAll(this.f17379d);
            componentParams.bid = ((Integer) getExtra("BUNDLE_KEY_BID")).intValue();
            componentParams.comboType = ((Integer) getExtra("BUNDLE_KEY_COMBO_TYPE")).intValue();
        }
    }
}
