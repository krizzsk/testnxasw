package com.didi.app.nova.skeleton.mvp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.internal.dsl.DslHelper;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.nova.skeleton.dsl.ResolveDslResult;
import com.didi.soda.nova.skeleton.dsl.annotations.Layout;

public class MvpComponent<V extends IView, P extends IPresenter> extends Component {

    /* renamed from: a */
    private V f10334a;

    /* renamed from: b */
    private P f10335b;

    /* renamed from: c */
    private ResolveDslResult f10336c;

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V onCreateView() {
        return null;
    }

    public MvpComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        ResolveDslResult componentDslInfo = DslHelper.getComponentDslInfo(getClass());
        this.f10336c = componentDslInfo;
        if (componentDslInfo != null) {
            this.f10335b = (IPresenter) componentDslInfo.presenter;
            this.f10334a = (IView) this.f10336c.logicView;
        }
        if (this.f10334a == null) {
            this.f10334a = onCreateView();
        }
        if (this.f10335b == null) {
            this.f10335b = onCreatePresenter();
        }
        bind(this.f10334a, this.f10335b);
        V v = this.f10334a;
        if (v != null) {
            v.attachContext(this.mContainer.getContext());
            LayoutInflater from = LayoutInflater.from(this.mContainer.getContext());
            ResolveDslResult resolveDslResult = this.f10336c;
            if (resolveDslResult == null || resolveDslResult.layoutId == 0) {
                Layout layout = (Layout) this.f10334a.getClass().getAnnotation(Layout.class);
                if (layout == null || layout.value() == 0) {
                    V v2 = this.f10334a;
                    v2.mView = v2.inflateView(from, this.mContainer);
                } else {
                    this.f10334a.mView = from.inflate(layout.value(), this.mContainer, true);
                }
            } else {
                this.f10334a.mView = from.inflate(this.f10336c.layoutId, this.mContainer, true);
            }
            if (this.f10334a.mView == null) {
                SystemUtils.log(5, "Component", "mLogicalView.mView is null", (Throwable) null, "com.didi.app.nova.skeleton.mvp.MvpComponent", 66);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void bind(V v, P p) {
        if (v != null) {
            v.attachPresenter(p);
        }
        if (p != null) {
            p.attachScopeContext(this.mScopeContext);
            p.attachView(v);
        }
    }

    public final V getLogicView() {
        return this.f10334a;
    }

    public final P getPresenter() {
        return this.f10335b;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        V v = this.f10334a;
        if (v != null) {
            v.onCreate();
        }
        P p = this.f10335b;
        if (p != null) {
            p.onCreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        V v = this.f10334a;
        if (v != null) {
            v.onStart();
        }
        P p = this.f10335b;
        if (p != null) {
            p.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        V v = this.f10334a;
        if (v != null) {
            v.onResume();
        }
        P p = this.f10335b;
        if (p != null) {
            p.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        V v = this.f10334a;
        if (v != null) {
            v.onPause();
        }
        P p = this.f10335b;
        if (p != null) {
            p.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        V v = this.f10334a;
        if (v != null) {
            v.onStop();
        }
        P p = this.f10335b;
        if (p != null) {
            p.onStop();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        P p = this.f10335b;
        if (p != null) {
            p.onDestroy();
        }
        V v = this.f10334a;
        if (v != null) {
            v.onDestroy();
        }
    }
}
