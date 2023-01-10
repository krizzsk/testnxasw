package com.didi.soda.business.widget;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.RFIconView;
import com.didi.sdk.util.SidConverter;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class BusinessDyHeaderAnimator implements IBusinessHeaderAnimator {

    /* renamed from: k */
    private static final float f42376k = 0.98f;

    /* renamed from: l */
    private static final String f42377l = "BusinessDyHeaderAnimator";

    /* renamed from: a */
    private float f42378a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Scroller f42379b;

    /* renamed from: c */
    private MeasurementRecordModel f42380c = new MeasurementRecordModel();

    /* renamed from: d */
    private boolean f42381d = false;

    /* renamed from: e */
    private IntEvaluator f42382e = new IntEvaluator();

    /* renamed from: f */
    private ArgbEvaluator f42383f = new ArgbEvaluator();

    /* renamed from: g */
    private FloatEvaluator f42384g = new FloatEvaluator();

    /* renamed from: h */
    private OnHeaderStateChangeListener f42385h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DependentViewChangedCallback f42386i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnHeaderCollapseListener f42387j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ScopeContext f42388m;
    @BindView(17948)
    ImageView mBusinessLogo;
    @BindView(17762)
    BusinessDyClassifyALayout mClassifyALayout;
    @BindView(17763)
    BusinessDyClassifyBLayout mClassifyBLayout;
    @BindView(18520)
    ConstraintLayout mClassifyTabContainer;
    @BindView(18363)
    RFIconView mCloseIcon;
    @BindView(18364)
    RFIconView mFavorImageIv;
    @BindView(17988)
    LottieLoadingView mFavorLoadingView;
    @BindView(17274)
    ConstraintLayout mHeadeRoot;
    @BindView(18362)
    ImageView mHeaderBackgroundImg;
    @BindView(18651)
    FrameLayout mHeaderCardContainer;
    @BindView(18243)
    View mHeaderCardShadowView;
    @BindView(18164)
    FrameLayout mLogoContainer;
    @BindView(18365)
    RFIconView mSearchIcon;
    @BindView(18829)
    TextView mStickyNameTv;
    @BindView(18112)
    BusinessDyStickyNavigationView mStickyNavigationView;
    @BindView(17853)
    ConstraintLayout mTitleContainer;

    /* renamed from: n */
    private Runnable f42389n = new Runnable() {
        public void run() {
            if (BusinessDyHeaderAnimator.this.f42388m == null || BusinessDyHeaderAnimator.this.f42388m.getLiveHandler() == null || BusinessDyHeaderAnimator.this.f42388m.getLiveHandler().isDestroyed()) {
                LogUtil.m32584d(BusinessDyHeaderAnimator.f42377l, "BusinessDyHeaderAnimator ScopeContext is null");
                return;
            }
            if (BusinessDyHeaderAnimator.this.f42379b.computeScrollOffset()) {
                BusinessDyHeaderAnimator businessDyHeaderAnimator = BusinessDyHeaderAnimator.this;
                businessDyHeaderAnimator.setAnimatedY((float) businessDyHeaderAnimator.f42379b.getCurrY());
                BusinessDyHeaderAnimator.this.m31887a((Runnable) this);
                if (BusinessDyHeaderAnimator.this.f42387j != null) {
                    BusinessDyHeaderAnimator.this.f42387j.onCollapseUpdated();
                }
            } else if (BusinessDyHeaderAnimator.this.f42387j != null) {
                BusinessDyHeaderAnimator.this.f42387j.onCollapseFinished();
                OnHeaderCollapseListener unused = BusinessDyHeaderAnimator.this.f42387j = null;
            }
            if (BusinessDyHeaderAnimator.this.f42386i != null) {
                BusinessDyHeaderAnimator.this.f42386i.onDependentViewChanged();
            }
        }
    };

    public interface DependentViewChangedCallback {
        void onDependentViewChanged();
    }

    public int getShadowHeight() {
        return 0;
    }

    BusinessDyHeaderAnimator(View view) {
        this.f42379b = new Scroller(view.getContext());
        ButterKnife.bind((Object) this, view);
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f42388m = scopeContext;
    }

    public void collapseHeader() {
        if (getAnimatedProgress() < 1.0f) {
            this.f42379b.startScroll(0, (int) this.f42378a, 0, (int) (getMaxAnimatedY() - this.f42378a));
            m31887a(this.f42389n);
        }
    }

    public void collapseHeader(OnHeaderCollapseListener onHeaderCollapseListener) {
        if (getAnimatedProgress() < 1.0f) {
            if (onHeaderCollapseListener != null) {
                this.f42387j = onHeaderCollapseListener;
            }
            this.f42379b.startScroll(0, (int) this.f42378a, 0, (int) (getMaxAnimatedY() - this.f42378a));
            m31887a(this.f42389n);
        }
    }

    public void expandHeader() {
        if (getAnimatedProgress() > 0.0f) {
            Scroller scroller = this.f42379b;
            float f = this.f42378a;
            scroller.startScroll(0, (int) f, 0, (int) (-f));
            m31887a(this.f42389n);
        }
    }

    public float getAnimatedProgress() {
        return Math.min(1.0f, Math.abs(this.f42378a / getMaxAnimatedY()));
    }

    public float getAnimatedY() {
        return this.f42378a;
    }

    public void setAnimatedY(float f) {
        this.f42378a = f;
        m31885a(getAnimatedProgress());
    }

    public float getMaxAnimatedY() {
        return (float) (-this.f42380c.totalOffset);
    }

    public void recordAnimationSpec() {
        if (!this.f42380c.recorded || this.f42381d) {
            this.mStickyNameTv.getLocationInWindow(new int[2]);
            this.f42380c.totalOffset = (this.mHeaderCardContainer.getTop() + this.mHeaderCardContainer.getHeight()) - this.mStickyNavigationView.getNavigationTitleHeight();
            this.f42380c.logoOffset = this.mBusinessLogo.getTop();
            this.f42380c.maskOffset = this.mHeaderCardContainer.getHeight();
            this.f42380c.navigationStartOffset = (this.mHeaderCardContainer.getTop() - this.mCloseIcon.getTop()) - this.mCloseIcon.getHeight();
            this.f42380c.recorded = true;
            this.f42381d = false;
        }
    }

    public void updateRecordState(boolean z) {
        this.f42381d = z;
    }

    public boolean isExpanded() {
        return Math.abs(this.f42378a) < 8.0f;
    }

    public boolean isCollapsed() {
        return getAnimatedProgress() == 1.0f;
    }

    public void setOnHeaderStateChangeListener(OnHeaderStateChangeListener onHeaderStateChangeListener) {
        this.f42385h = onHeaderStateChangeListener;
    }

    public void setDependentViewDyChangedCallback(DependentViewChangedCallback dependentViewChangedCallback) {
        this.f42386i = dependentViewChangedCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31887a(Runnable runnable) {
        this.mHeaderCardContainer.postOnAnimation(runnable);
    }

    /* renamed from: a */
    private void m31885a(float f) {
        LogUtil.m32584d(SidConverter.BUSINESS_STR, "fraction: " + f);
        float max = (float) ((int) Math.max((float) ((int) this.f42378a), getMaxAnimatedY()));
        this.mLogoContainer.setTranslationY(max);
        this.mHeaderBackgroundImg.setAlpha(1.0f - (Math.abs(this.f42378a) / ((float) this.f42380c.maskOffset)));
        this.mHeaderCardContainer.setTranslationY(max);
        this.mHeaderCardShadowView.setTranslationY(max);
        this.mClassifyTabContainer.setTranslationY(max);
        this.mClassifyBLayout.setBackgroundResource(f >= f42376k ? R.color.rf_color_v2_grey2_10_a100 : R.color.rf_color_v2_grey4_1_a100);
        m31889b(f);
        OnHeaderStateChangeListener onHeaderStateChangeListener = this.f42385h;
        if (onHeaderStateChangeListener != null) {
            if (f >= 0.7f) {
                onHeaderStateChangeListener.onHeaderStateChanged(true);
            } else {
                onHeaderStateChangeListener.onHeaderStateChanged(false);
            }
        }
        DependentViewChangedCallback dependentViewChangedCallback = this.f42386i;
        if (dependentViewChangedCallback != null) {
            dependentViewChangedCallback.onDependentViewChanged();
        }
    }

    /* renamed from: b */
    private void m31889b(float f) {
        float abs = (Math.abs(this.f42378a) - ((float) this.f42380c.navigationStartOffset)) / ((float) Math.abs(this.f42380c.totalOffset - this.f42380c.navigationStartOffset));
        LogUtil.m32584d(SidConverter.BUSINESS_STR, "naviFraction: " + abs + "mAnimatedY:" + this.f42378a + "naviStartOffset:" + this.f42380c.navigationStartOffset + "naviTotalOffset:" + this.f42380c.totalOffset);
        if (Math.abs(this.f42378a) >= ((float) this.f42380c.navigationStartOffset)) {
            this.mStickyNavigationView.setAlpha(abs);
            this.mStickyNavigationView.setVisibility(0);
            this.mTitleContainer.setAlpha(1.0f - abs);
        } else {
            this.mStickyNavigationView.setAlpha(0.0f);
            this.mStickyNavigationView.setVisibility(4);
            this.mTitleContainer.setAlpha(1.0f);
        }
        if (abs >= f42376k) {
            this.mStickyNavigationView.setAlpha(1.0f);
            this.mTitleContainer.setAlpha(0.0f);
            this.mTitleContainer.setVisibility(4);
            if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
                this.mClassifyALayout.setAlpha(1.0f - f);
                this.mClassifyALayout.setVisibility(4);
                this.mClassifyBLayout.setAlpha(f);
                this.mClassifyBLayout.setVisibility(0);
            }
            this.mClassifyBLayout.showClassifyTabSelectedColor(true);
            return;
        }
        this.mTitleContainer.setVisibility(0);
        if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
            this.mClassifyALayout.setAlpha(1.0f);
            this.mClassifyALayout.setVisibility(0);
            this.mClassifyBLayout.setAlpha(0.0f);
            this.mClassifyBLayout.setVisibility(4);
        }
        this.mClassifyBLayout.showClassifyTabSelectedColor(false);
    }

    private static class MeasurementRecordModel {
        int logoOffset;
        int maskOffset;
        int navigationStartOffset;
        boolean recorded;
        int totalOffset;

        private MeasurementRecordModel() {
            this.recorded = false;
            this.totalOffset = -1;
            this.navigationStartOffset = -1;
            this.logoOffset = -1;
            this.maskOffset = -1;
        }
    }
}
