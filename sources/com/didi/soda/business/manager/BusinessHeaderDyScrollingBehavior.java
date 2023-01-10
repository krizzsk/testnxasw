package com.didi.soda.business.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.business.widget.BusinessDyHeaderAnimator;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.business.widget.IBusinessHeaderAnimator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.lang.ref.WeakReference;

public class BusinessHeaderDyScrollingBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    /* renamed from: a */
    private static final String f42291a = "BusinessHeaderScrollingBehavior";

    /* renamed from: b */
    private static final float f42292b = 0.0f;

    /* renamed from: c */
    private static final float f42293c = 1.0f;

    /* renamed from: d */
    private static final int f42294d = 1;

    /* renamed from: e */
    private static final int f42295e = 2;

    /* renamed from: f */
    private static final int f42296f = 6000;

    /* renamed from: g */
    private int f42297g = 0;

    /* renamed from: h */
    private WeakReference<BusinessDyHomeHeaderView> f42298h;

    /* renamed from: i */
    private boolean f42299i = false;

    /* renamed from: a */
    private TextView m31811a(BusinessDyHomeHeaderView businessDyHomeHeaderView) {
        return null;
    }

    public BusinessHeaderDyScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        if (!(view instanceof BusinessDyHomeHeaderView)) {
            return super.layoutDependsOn(coordinatorLayout, recyclerView, view);
        }
        BusinessDyHomeHeaderView businessDyHomeHeaderView = (BusinessDyHomeHeaderView) view;
        this.f42298h = new WeakReference<>(businessDyHomeHeaderView);
        businessDyHomeHeaderView.getHeaderAnimator().setDependentViewDyChangedCallback(new BusinessDyHeaderAnimator.DependentViewChangedCallback(view) {
            public final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onDependentViewChanged() {
                CoordinatorLayout.this.dispatchDependentViewsChanged(this.f$1);
            }
        });
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, int i) {
        m31814a(recyclerView, (View) coordinatorLayout);
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        m31814a(recyclerView, (View) coordinatorLayout);
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        m31815a("onStartNestedScroll---type:" + i2);
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        super.onNestedScrollAccepted(coordinatorLayout, recyclerView, view, view2, i, i2);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i, int i2, int[] iArr, int i3) {
        if (i2 > 0) {
            this.f42297g = 1;
        } else if (i2 < 0) {
            this.f42297g = 2;
            this.f42299i = false;
        }
        if (i2 > 0 || !recyclerView.canScrollVertically(-1)) {
            IBusinessHeaderAnimator d = m31819d();
            float animatedY = d.getAnimatedY() - ((float) i2);
            float maxAnimatedY = d.getMaxAnimatedY();
            m31815a("onNestedPreScroll-----" + i2 + "---- type:" + i3 + " newTranslateY:" + animatedY + " minHeaderTranslate:" + maxAnimatedY);
            if (animatedY > 0.0f) {
                return;
            }
            if (animatedY > maxAnimatedY) {
                d.setAnimatedY(animatedY);
                iArr[1] = i2;
            } else if (animatedY <= maxAnimatedY && !this.f42299i) {
                this.f42299i = true;
                d.setAnimatedY(maxAnimatedY);
            }
        }
    }

    /* renamed from: a */
    private int m31810a() {
        int[] iArr = new int[2];
        m31815a("location[1] Y : " + iArr[1]);
        return iArr[1];
    }

    /* renamed from: a */
    private boolean m31816a(TextView textView) {
        if (textView == null || textView.getText() == null || m31818c().currentCategoryRvModel == null || m31818c().currentCategoryRvModel.businessTabTipRvModel == null || m31818c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null || !m31818c().currentCategoryRvModel.businessTabTipRvModel.getTopContent().equals(textView.getText().toString())) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m31812a(RecyclerView recyclerView) {
        return (m31818c().currentCategoryRvModel == null || m31818c().currentCategoryRvModel.businessTabTipRvModel == null || m31818c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null) ? "" : m31818c().currentCategoryRvModel.businessTabTipRvModel.getTopContent();
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2) {
        m31815a("onNestedPreFling-----" + f2);
        if (f2 > 0.0f) {
            this.f42297g = 1;
        } else if (f2 < 0.0f) {
            this.f42297g = 2;
        }
        if (f2 >= 0.0f || Math.abs(f2) <= 6000.0f) {
            return false;
        }
        recyclerView.scrollToPosition(0);
        return true;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        m31815a("onNestedFling-----" + f2);
        m31814a(recyclerView, (View) coordinatorLayout);
        return super.onNestedFling(coordinatorLayout, recyclerView, view, f, f2, z);
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i) {
        m31815a("onStopNestedScroll-----" + i);
        m31819d().getAnimatedProgress();
        m31815a("scroll direction: " + this.f42297g);
        m31817b();
        m31818c().getBusinessHeaderViewTipHelper().setTouchNow(false);
    }

    /* renamed from: b */
    private void m31817b() {
        this.f42297g = 0;
    }

    /* renamed from: c */
    private BusinessDyHomeHeaderView m31818c() {
        return (BusinessDyHomeHeaderView) this.f42298h.get();
    }

    /* renamed from: d */
    private IBusinessHeaderAnimator m31819d() {
        return ((BusinessDyHomeHeaderView) this.f42298h.get()).getHeaderAnimator();
    }

    /* renamed from: a */
    private void m31814a(RecyclerView recyclerView, View view) {
        int height = m31818c().getHeight() - m31820e();
        recyclerView.setTranslationY(((float) height) + m31819d().getAnimatedY());
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = (int) (((float) (view.getHeight() - height)) + Math.abs(m31819d().getAnimatedY()));
        recyclerView.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    private int m31820e() {
        TextView a = m31811a(m31818c());
        if (a != null) {
            return a.getHeight();
        }
        return 0;
    }

    /* renamed from: a */
    private void m31815a(String str) {
        LogUtil.m32584d(f42291a, str);
    }
}
