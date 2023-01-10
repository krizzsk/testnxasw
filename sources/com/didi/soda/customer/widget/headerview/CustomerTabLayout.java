package com.didi.soda.customer.widget.headerview;

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
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private static final String f44553a = "CustomerTabLayout";

    /* renamed from: b */
    private static final int f44554b = 0;

    /* renamed from: c */
    private static final int f44555c = 1;

    /* renamed from: d */
    private static final int f44556d = 2;

    /* renamed from: e */
    private static final int f44557e = 3;

    /* renamed from: f */
    private static final int f44558f = 4;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f44559g;

    /* renamed from: h */
    private LinearLayout f44560h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LinearLayout f44561i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<View> f44562j;

    /* renamed from: k */
    private int f44563k;

    /* renamed from: l */
    private int f44564l;

    /* renamed from: m */
    private boolean f44565m = true;

    /* renamed from: n */
    private boolean f44566n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f44567o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f44568p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f44569q = false;

    /* renamed from: r */
    private TabAdapter f44570r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTabSelectedListener f44571s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public OnTabExposureListener f44572t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ObjectAnimator f44573u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Rect f44574v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List<Integer> f44575w;

    /* renamed from: x */
    private ViewTreeObserver.OnScrollChangedListener f44576x;

    /* renamed from: y */
    private OnScollChangedListener f44577y = null;

    /* renamed from: z */
    private boolean f44578z = true;

    public interface OnScollChangedListener {
        void onScrollChanged(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4);
    }

    public void setCustomerOnScrollChanedListener(OnScollChangedListener onScollChangedListener) {
        this.f44577y = onScollChangedListener;
    }

    public CustomerTabLayout(Context context) {
        super(context);
        m33077a();
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33080a(attributeSet);
        m33077a();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.f44571s = onTabSelectedListener;
    }

    public void setOnTabExposureListener(OnTabExposureListener onTabExposureListener) {
        this.f44572t = onTabExposureListener;
    }

    public void setTabAdapter(TabAdapter tabAdapter) {
        if (!m33088a(tabAdapter)) {
            this.f44575w.clear();
            this.f44570r = tabAdapter;
            if (tabAdapter != null && tabAdapter.getItemCount() > 0) {
                int itemCount = tabAdapter.getItemCount();
                this.f44562j = new ArrayList();
                this.f44561i.removeAllViews();
                for (int i = 0; i < itemCount; i++) {
                    ITab itemView = tabAdapter.getItemView(i);
                    if (itemView instanceof View) {
                        itemView.updateTabView(tabAdapter.getData().get(i), i, itemCount);
                        itemView.setSelectedState(false, this.f44578z);
                        m33081a((View) itemView, i);
                    }
                }
                this.f44561i.post(new Runnable() {
                    public void run() {
                        if (CustomerTabLayout.this.f44569q) {
                            CustomerTabLayout.this.f44573u.cancel();
                        }
                        CustomerTabLayout.this.setSelectorColor(0);
                        CustomerTabLayout.this.m33094d();
                        if (CustomerTabLayout.this.f44571s != null) {
                            CustomerTabLayout.this.f44571s.onTabSelected(0, false, true);
                        }
                    }
                });
            }
        }
    }

    public void selectTab(final int i) {
        this.f44561i.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f44562j != null && CustomerTabLayout.this.f44568p != (i = i) && i >= 0 && i < CustomerTabLayout.this.f44562j.size()) {
                    ((View) CustomerTabLayout.this.f44562j.get(i)).performClick();
                }
            }
        });
    }

    public void selectTab(final int i, final boolean z) {
        this.f44561i.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f44562j != null && CustomerTabLayout.this.f44568p != (i = i) && i >= 0 && i < CustomerTabLayout.this.f44562j.size()) {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m33082a((View) customerTabLayout.f44562j.get(i), i, z);
                }
            }
        });
    }

    public void setShowSelectedItemColor(boolean z) {
        this.f44578z = z;
        setSelectorColor(this.f44568p);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m33090b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m33091c();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScollChangedListener onScollChangedListener = this.f44577y;
        if (onScollChangedListener != null) {
            onScollChangedListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private void m33080a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerTabLayout);
        this.f44564l = obtainStyledAttributes.getColor(1, ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        this.f44567o = obtainStyledAttributes.getInt(0, 0);
        this.f44566n = obtainStyledAttributes.getBoolean(3, false);
        this.f44563k = obtainStyledAttributes.getDimensionPixelSize(2, DisplayUtils.dip2px(getContext(), 3.0f));
        this.f44565m = obtainStyledAttributes.getBoolean(4, true);
        this.f44578z = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m33077a() {
        this.f44560h = new LinearLayout(getContext());
        this.f44561i = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.f44560h.setLayoutParams(layoutParams);
        this.f44560h.setMinimumWidth(DisplayUtils.getScreenWidth(getContext()));
        this.f44561i.setLayoutParams(layoutParams);
        this.f44560h.setOrientation(1);
        this.f44561i.setOrientation(0);
        addView(this.f44560h);
        this.f44560h.addView(this.f44561i);
        setHorizontalScrollBarEnabled(false);
        if (this.f44565m) {
            View view = new View(getContext());
            this.f44559g = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, this.f44563k));
            this.f44559g.setBackgroundColor(this.f44564l);
            this.f44560h.addView(this.f44559g);
        }
        if (this.f44566n) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
            this.f44560h.addView(view2);
        }
        this.f44575w = new ArrayList();
        this.f44574v = new Rect();
        this.f44576x = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                int childCount = CustomerTabLayout.this.f44561i.getChildCount();
                if (CustomerTabLayout.this.f44575w.size() < childCount) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = CustomerTabLayout.this.f44561i.getChildAt(i);
                        if (!CustomerTabLayout.this.f44575w.contains(Integer.valueOf(i)) && childAt.getLocalVisibleRect(CustomerTabLayout.this.f44574v)) {
                            CustomerTabLayout.this.f44575w.add(Integer.valueOf(i));
                            LogUtil.m32588i(CustomerTabLayout.f44553a, "Visible:" + i);
                            if (CustomerTabLayout.this.f44572t != null) {
                                CustomerTabLayout.this.f44572t.onTabItemExposure(i);
                            }
                        }
                    }
                }
            }
        };
    }

    /* renamed from: b */
    private void m33090b() {
        getViewTreeObserver().addOnScrollChangedListener(this.f44576x);
    }

    /* renamed from: c */
    private void m33091c() {
        getViewTreeObserver().removeOnScrollChangedListener(this.f44576x);
    }

    /* renamed from: a */
    private void m33081a(final View view, final int i) {
        this.f44562j.add(view);
        this.f44561i.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerTabLayout.this.m33082a(view, i, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33082a(final View view, int i, boolean z) {
        if (i == 0 || i != this.f44568p) {
            int i2 = i - 1;
            final View view2 = i2 >= 0 ? this.f44562j.get(i2) : null;
            if (this.f44569q) {
                this.f44573u.cancel();
            }
            setSelectorColor(i);
            OnTabSelectedListener onTabSelectedListener = this.f44571s;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(i, z, false);
            }
            if (this.f44565m) {
                m33078a(i);
            }
            post(new Runnable() {
                public void run() {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m33079a(customerTabLayout.f44567o, view, view2);
                }
            });
        }
    }

    /* renamed from: a */
    private void m33078a(int i) {
        float x = this.f44561i.getX();
        View view = this.f44562j.get(i);
        if (view != null) {
            final ViewGroup.LayoutParams layoutParams = this.f44559g.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(C17272q.f51679a, new float[]{Float.valueOf(this.f44559g.getX()).floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + x).floatValue()});
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f44559g, new PropertyValuesHolder[]{ofInt, ofFloat});
            this.f44573u = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
            this.f44573u.start();
            this.f44573u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    CustomerTabLayout.this.f44559g.setLayoutParams(layoutParams);
                }
            });
            this.f44573u.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f44569q = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f44569q = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33094d() {
        List<View> list = this.f44562j;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                this.f44559g.setLayoutParams(new LinearLayout.LayoutParams((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), this.f44563k));
                this.f44559g.setX((float) view.getPaddingLeft());
            }
            scrollTo(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void setSelectorColor(int i) {
        int i2 = this.f44568p;
        if (i2 >= 0 && i2 < this.f44562j.size()) {
            ((ITab) this.f44562j.get(this.f44568p)).setSelectedState(false, this.f44578z);
        }
        this.f44568p = i;
        if (i >= 0 && i < this.f44562j.size()) {
            ((ITab) this.f44562j.get(this.f44568p)).setSelectedState(true, this.f44578z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33079a(int i, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (i == 1) {
            smoothScrollBy(iArr[0], 0);
        } else if (i == 2) {
            smoothScrollBy((iArr[0] + view.getWidth()) - DisplayUtils.getScreenWidth(getContext()), 0);
        } else if (i == 3) {
            smoothScrollBy((iArr[0] + (view.getWidth() / 2)) - (DisplayUtils.getScreenWidth(getContext()) / 2), 0);
        } else if (i != 4) {
            if (iArr[0] + view.getWidth() > DisplayUtils.getScreenWidth(getContext())) {
                smoothScrollBy(view.getWidth(), 0);
            } else if (iArr[0] < 0) {
                smoothScrollBy(-view.getWidth(), 0);
            }
        } else if (view2 != null) {
            smoothScrollTo(view2.getLeft(), 0);
        } else {
            smoothScrollTo(view.getLeft(), 0);
        }
    }

    /* renamed from: a */
    private boolean m33088a(TabAdapter tabAdapter) {
        TabAdapter tabAdapter2 = this.f44570r;
        if (tabAdapter2 == null || tabAdapter2.getData() == null || tabAdapter.getItemCount() != this.f44570r.getItemCount()) {
            return false;
        }
        if (tabAdapter.getData() == null) {
            return true;
        }
        return this.f44570r.getData().toString().equals(tabAdapter.getData().toString());
    }
}
