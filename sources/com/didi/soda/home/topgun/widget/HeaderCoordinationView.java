package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class HeaderCoordinationView extends View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f45576a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f45577b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f45578c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f45579d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f45580e = false;

    /* renamed from: f */
    private ScopeContext f45581f;

    /* renamed from: g */
    private LifeCycleObserver f45582g = new LifeCycleObserver();

    /* renamed from: h */
    private ViewTreeObserver.OnPreDrawListener f45583h = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            if (!GlobalContext.isEmbed() || !HeaderCoordinationView.this.f45580e || HeaderCoordinationView.this.f45576a == null) {
                return true;
            }
            if (HeaderCoordinationView.this.f45579d == 0) {
                HeaderCoordinationView headerCoordinationView = HeaderCoordinationView.this;
                int unused = headerCoordinationView.f45579d = headerCoordinationView.getYOnWindow();
            }
            float alpha = HeaderCoordinationView.this.f45576a.getAlpha();
            int d = HeaderCoordinationView.this.getYOnWindow();
            if (d == 0) {
                d = PckErrCode.ASSERT_COPY_ERROR;
            }
            int c = d - HeaderCoordinationView.this.f45579d;
            if (HeaderCoordinationView.this.f45577b != null) {
                HeaderCoordinationView.this.f45577b.setY((float) (c + HeaderCoordinationView.this.f45578c));
                HeaderCoordinationView.this.f45577b.setAlpha(alpha);
            } else {
                GlobalContext.getTitleAndBizBarManager().offsetTitleBar((float) c, alpha);
            }
            return true;
        }
    };

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* renamed from: a */
    private void m33853a() {
        if (this.f45577b == null) {
            Object object = this.f45581f.getObject(Const.HomeTags.BACK_VIEW_TAG);
            View view = null;
            if (object instanceof View) {
                view = (View) object;
            }
            if (view != null && view.isAttachedToWindow()) {
                this.f45577b = view;
                this.f45578c = CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_2);
            }
        }
    }

    public HeaderCoordinationView(Context context) {
        super(context);
        m33857b();
    }

    public HeaderCoordinationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33857b();
    }

    public HeaderCoordinationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33857b();
    }

    public void setDependOnView(View view) {
        this.f45576a = view;
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f45581f = scopeContext;
        m33853a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f45576a != null) {
            getViewTreeObserver().addOnPreDrawListener(this.f45583h);
            ScopeContext scopeContext = this.f45581f;
            if (scopeContext != null) {
                this.f45580e = true;
                scopeContext.addObserver(this.f45582g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f45576a != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f45583h);
            ScopeContext scopeContext = this.f45581f;
            if (scopeContext != null) {
                scopeContext.removeObserver(this.f45582g);
                this.f45580e = false;
            }
        }
    }

    /* renamed from: b */
    private void m33857b() {
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public int getYOnWindow() {
        View view = this.f45576a;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    private class LifeCycleObserver implements IScopeLifecycle {
        public void onCreate(ILive iLive) {
        }

        public void onDestroy(ILive iLive) {
        }

        public void onStart(ILive iLive) {
        }

        public void onStop(ILive iLive) {
        }

        private LifeCycleObserver() {
        }

        public void onResume(ILive iLive) {
            boolean unused = HeaderCoordinationView.this.f45580e = true;
        }

        public void onPause(ILive iLive) {
            boolean unused = HeaderCoordinationView.this.f45580e = false;
        }
    }
}
