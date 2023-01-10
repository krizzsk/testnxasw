package com.didi.entrega.customer.widget.headerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.headerview.tabitem.ITab;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private static final String f22319a = "CustomerTabLayout";

    /* renamed from: b */
    private static final int f22320b = 0;

    /* renamed from: c */
    private static final int f22321c = 1;

    /* renamed from: d */
    private static final int f22322d = 2;

    /* renamed from: e */
    private static final int f22323e = 3;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f22324f;

    /* renamed from: g */
    private LinearLayout f22325g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LinearLayout f22326h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<View> f22327i;

    /* renamed from: j */
    private int f22328j;

    /* renamed from: k */
    private int f22329k;

    /* renamed from: l */
    private boolean f22330l = true;

    /* renamed from: m */
    private boolean f22331m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f22332n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f22333o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f22334p = false;

    /* renamed from: q */
    private TabAdapter f22335q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnTabSelectedListener f22336r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTabExposureListener f22337s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ObjectAnimator f22338t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Rect f22339u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<Integer> f22340v;

    /* renamed from: w */
    private ViewTreeObserver.OnScrollChangedListener f22341w;

    public CustomerTabLayout(Context context) {
        super(context);
        m18392a();
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18395a(attributeSet);
        m18392a();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.f22336r = onTabSelectedListener;
    }

    public void setOnTabExposureListener(OnTabExposureListener onTabExposureListener) {
        this.f22337s = onTabExposureListener;
    }

    public void setTabAdapter(TabAdapter tabAdapter) {
        if (!m18403a(tabAdapter)) {
            this.f22340v.clear();
            this.f22335q = tabAdapter;
            if (tabAdapter != null && tabAdapter.getItemCount() > 0) {
                int itemCount = tabAdapter.getItemCount();
                this.f22327i = new ArrayList();
                this.f22326h.removeAllViews();
                for (int i = 0; i < itemCount; i++) {
                    ITab itemView = tabAdapter.getItemView(i);
                    if (itemView instanceof View) {
                        itemView.updateTabView(tabAdapter.getData().get(i), i, itemCount);
                        itemView.setSelectedState(false);
                        m18396a((View) itemView, i);
                    }
                }
                this.f22326h.post(new Runnable() {
                    public void run() {
                        if (CustomerTabLayout.this.f22334p) {
                            CustomerTabLayout.this.f22338t.cancel();
                        }
                        CustomerTabLayout.this.setSelectorColor(0);
                        CustomerTabLayout.this.m18409d();
                        if (CustomerTabLayout.this.f22336r != null) {
                            CustomerTabLayout.this.f22336r.onTabSelected(0, false, true);
                        }
                    }
                });
            }
        }
    }

    public void selectTab(final int i) {
        this.f22326h.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f22327i != null && CustomerTabLayout.this.f22333o != (i = i) && i >= 0 && i < CustomerTabLayout.this.f22327i.size()) {
                    ((View) CustomerTabLayout.this.f22327i.get(i)).performClick();
                }
            }
        });
    }

    public void selectTab(final int i, final boolean z) {
        this.f22326h.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f22327i != null && CustomerTabLayout.this.f22333o != (i = i) && i >= 0 && i < CustomerTabLayout.this.f22327i.size()) {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m18397a((View) customerTabLayout.f22327i.get(i), i, z);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m18405b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m18406c();
    }

    /* renamed from: a */
    private void m18395a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaTabLayout);
        this.f22329k = obtainStyledAttributes.getColor(1, ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        this.f22332n = obtainStyledAttributes.getInt(0, 0);
        this.f22331m = obtainStyledAttributes.getBoolean(3, false);
        this.f22328j = obtainStyledAttributes.getDimensionPixelSize(2, DisplayUtils.dip2px(getContext(), 3.0f));
        this.f22330l = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m18392a() {
        this.f22325g = new LinearLayout(getContext());
        this.f22326h = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.f22325g.setLayoutParams(layoutParams);
        this.f22325g.setMinimumWidth(DisplayUtils.getScreenWidth(getContext()));
        this.f22326h.setLayoutParams(layoutParams);
        this.f22325g.setOrientation(1);
        this.f22326h.setOrientation(0);
        addView(this.f22325g);
        this.f22325g.addView(this.f22326h);
        setHorizontalScrollBarEnabled(false);
        if (this.f22330l) {
            View view = new View(getContext());
            this.f22324f = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, this.f22328j));
            this.f22324f.setBackgroundColor(this.f22329k);
            this.f22325g.addView(this.f22324f);
        }
        if (this.f22331m) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
            this.f22325g.addView(view2);
        }
        this.f22340v = new ArrayList();
        this.f22339u = new Rect();
        this.f22341w = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                int childCount = CustomerTabLayout.this.f22326h.getChildCount();
                if (CustomerTabLayout.this.f22340v.size() < childCount) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = CustomerTabLayout.this.f22326h.getChildAt(i);
                        if (!CustomerTabLayout.this.f22340v.contains(Integer.valueOf(i)) && childAt.getLocalVisibleRect(CustomerTabLayout.this.f22339u)) {
                            CustomerTabLayout.this.f22340v.add(Integer.valueOf(i));
                            LogUtil.m18185i(CustomerTabLayout.f22319a, "Visible:" + i);
                            if (CustomerTabLayout.this.f22337s != null) {
                                CustomerTabLayout.this.f22337s.onTabItemExposure(i);
                            }
                        }
                    }
                }
            }
        };
    }

    /* renamed from: b */
    private void m18405b() {
        getViewTreeObserver().addOnScrollChangedListener(this.f22341w);
    }

    /* renamed from: c */
    private void m18406c() {
        getViewTreeObserver().removeOnScrollChangedListener(this.f22341w);
    }

    /* renamed from: a */
    private void m18396a(final View view, final int i) {
        this.f22327i.add(view);
        this.f22326h.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomerTabLayout.this.m18397a(view, i, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18397a(final View view, int i, boolean z) {
        if (i != this.f22333o) {
            if (this.f22334p) {
                this.f22338t.cancel();
            }
            setSelectorColor(i);
            OnTabSelectedListener onTabSelectedListener = this.f22336r;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(i, z, false);
            }
            if (this.f22330l) {
                m18393a(i);
            }
            post(new Runnable() {
                public void run() {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m18394a(customerTabLayout.f22332n, view);
                }
            });
        }
    }

    /* renamed from: a */
    private void m18393a(int i) {
        float x = this.f22326h.getX();
        View view = this.f22327i.get(i);
        if (view != null) {
            final ViewGroup.LayoutParams layoutParams = this.f22324f.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(C17272q.f51679a, new float[]{Float.valueOf(this.f22324f.getX()).floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + x).floatValue()});
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22324f, new PropertyValuesHolder[]{ofInt, ofFloat});
            this.f22338t = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
            this.f22338t.start();
            this.f22338t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    CustomerTabLayout.this.f22324f.setLayoutParams(layoutParams);
                }
            });
            this.f22338t.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f22334p = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f22334p = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18409d() {
        List<View> list = this.f22327i;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                this.f22324f.setLayoutParams(new LinearLayout.LayoutParams((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), this.f22328j));
                this.f22324f.setX((float) view.getPaddingLeft());
            }
            scrollTo(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void setSelectorColor(int i) {
        int i2 = this.f22333o;
        if (i2 >= 0 && i2 < this.f22327i.size()) {
            ((ITab) this.f22327i.get(this.f22333o)).setSelectedState(false);
        }
        this.f22333o = i;
        if (i >= 0 && i < this.f22327i.size()) {
            ((ITab) this.f22327i.get(this.f22333o)).setSelectedState(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18394a(int i, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (i == 1) {
            smoothScrollBy(iArr[0], 0);
        } else if (i == 2) {
            smoothScrollBy((iArr[0] + view.getWidth()) - DisplayUtils.getScreenWidth(getContext()), 0);
        } else if (i == 3) {
            smoothScrollBy((iArr[0] + (view.getWidth() / 2)) - (DisplayUtils.getScreenWidth(getContext()) / 2), 0);
        } else if (iArr[0] + view.getWidth() > DisplayUtils.getScreenWidth(getContext())) {
            smoothScrollBy(view.getWidth(), 0);
        } else if (iArr[0] < 0) {
            smoothScrollBy(-view.getWidth(), 0);
        }
    }

    /* renamed from: a */
    private boolean m18403a(TabAdapter tabAdapter) {
        TabAdapter tabAdapter2 = this.f22335q;
        if (tabAdapter2 == null || tabAdapter2.getData() == null || tabAdapter.getItemCount() != this.f22335q.getItemCount()) {
            return false;
        }
        if (tabAdapter.getData() == null) {
            return true;
        }
        return this.f22335q.getData().toString().equals(tabAdapter.getData().toString());
    }
}
