package com.didi.rfusion.widget.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RFScroller extends HorizontalScrollView implements C12392a {

    /* renamed from: b */
    private static final int f36502b = 8;

    /* renamed from: a */
    private int f36503a;

    /* renamed from: c */
    private LinearLayout f36504c;

    /* renamed from: d */
    private View f36505d;

    /* renamed from: e */
    private int f36506e;

    /* renamed from: f */
    private int f36507f;

    /* renamed from: g */
    private boolean f36508g;

    /* renamed from: h */
    private View f36509h;

    /* renamed from: i */
    private int f36510i;

    /* renamed from: j */
    private int f36511j;

    /* renamed from: k */
    private int f36512k;

    /* renamed from: l */
    private RFTabAdapter f36513l;

    /* renamed from: m */
    private List<View> f36514m;

    /* renamed from: n */
    private List<Integer> f36515n;

    /* renamed from: o */
    private int f36516o;

    /* renamed from: p */
    private OnRFTabSelectedListener f36517p;

    /* renamed from: q */
    private OnRFTabFirstExposureListener f36518q;

    /* renamed from: r */
    private ViewTreeObserver.OnScrollChangedListener f36519r;

    /* renamed from: s */
    private OnScrollPositionChangeListener f36520s;

    /* renamed from: t */
    private ObjectAnimator f36521t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f36522u;

    public RFScroller(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36503a = 1;
        this.f36508g = true;
        this.f36516o = -1;
        this.f36522u = false;
        m27484a(context);
    }

    public void setTabBarSpec(int i) {
        this.f36503a = i;
    }

    public void showDividerLine(boolean z) {
        this.f36509h.setVisibility(z ? 0 : 8);
    }

    public void setData(List<String> list) {
        setTabBarAdapter(new SimpleTabAdapter(getContext(), list));
    }

    public void setTabBarAdapter(RFTabAdapter rFTabAdapter) {
        if (!m27489a(rFTabAdapter)) {
            this.f36515n.clear();
            this.f36513l = rFTabAdapter;
            if (rFTabAdapter != null && rFTabAdapter.getItemCount() > 0) {
                int itemCount = rFTabAdapter.getItemCount();
                this.f36504c.removeAllViews();
                int i = 0;
                while (i < itemCount) {
                    m27487a(rFTabAdapter.getData(), rFTabAdapter.getItemView(), i, i == itemCount + -1);
                    i++;
                }
                m27480a();
            }
        }
    }

    public void selectTab(int i) {
        m27483a(i, false);
    }

    public void setOnTabSelectedListener(OnRFTabSelectedListener onRFTabSelectedListener) {
        this.f36517p = onRFTabSelectedListener;
    }

    public void setOnTabFirstExposureListener(OnRFTabFirstExposureListener onRFTabFirstExposureListener) {
        this.f36518q = onRFTabFirstExposureListener;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.f36511j = viewGroup.getPaddingLeft();
        this.f36512k = viewGroup.getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f36519r);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.f36519r);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        int measuredWidth = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (this.f36520s != null) {
            if (i == 0) {
                RFLogger.getLogger().debug("滑到最左");
                this.f36520s.onScrollToLeft();
            } else if (i == measuredWidth) {
                RFLogger.getLogger().debug("滑到最右");
                this.f36520s.onScrollToRight();
            } else {
                RFLogger.getLogger().debug("滑到中间");
                this.f36520s.onScrollToMiddle();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnScrollPositionChangeListener(OnScrollPositionChangeListener onScrollPositionChangeListener) {
        this.f36520s = onScrollPositionChangeListener;
    }

    /* renamed from: a */
    private void m27484a(Context context) {
        this.f36514m = new ArrayList();
        this.f36515n = new ArrayList();
        this.f36510i = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_56);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setMinimumWidth(RFDisplayUtils.getScreenWidth());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f36504c = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f36504c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        View view = new View(context);
        this.f36505d = view;
        view.setBackground(m27496d());
        this.f36506e = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_6);
        this.f36507f = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_68);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f36507f, this.f36506e);
        layoutParams.topMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_20);
        this.f36505d.setLayoutParams(layoutParams);
        View view2 = new View(context);
        this.f36509h = view2;
        view2.setBackgroundColor(RFResUtils.getColor(R.color.rf_color_gery_5_90_E5E5E5));
        this.f36509h.setLayoutParams(new LinearLayout.LayoutParams(-1, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_1)));
        linearLayout.addView(this.f36504c);
        linearLayout.addView(this.f36505d);
        linearLayout.addView(this.f36509h);
        addView(linearLayout);
        this.f36519r = new ViewTreeObserver.OnScrollChangedListener(new Rect()) {
            public final /* synthetic */ Rect f$1;

            {
                this.f$1 = r2;
            }

            public final void onScrollChanged() {
                RFScroller.this.m27485a(this.f$1);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27485a(Rect rect) {
        int childCount = this.f36504c.getChildCount();
        if (this.f36515n.size() < childCount) {
            for (int i = 0; i < childCount; i++) {
                if (!this.f36515n.contains(Integer.valueOf(i)) && this.f36504c.getChildAt(i).getLocalVisibleRect(rect)) {
                    this.f36515n.add(Integer.valueOf(i));
                    OnRFTabFirstExposureListener onRFTabFirstExposureListener = this.f36518q;
                    if (onRFTabFirstExposureListener != null) {
                        onRFTabFirstExposureListener.onTabFirstExposure(i);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m27480a() {
        m27483a(0, true);
    }

    /* renamed from: a */
    private void m27483a(int i, boolean z) {
        this.f36504c.post(new Runnable(i, z) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RFScroller.this.m27495c(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m27495c(int i, boolean z) {
        List<View> list = this.f36514m;
        if (list != null && this.f36516o != i && i >= 0 && i < list.size()) {
            m27492b(i, z);
        }
    }

    /* renamed from: a */
    private void m27487a(List list, IRFTab iRFTab, int i, boolean z) {
        if (iRFTab instanceof View) {
            int i2 = 0;
            iRFTab.setSelectedState(false);
            iRFTab.setTabBarSpec(this.f36503a);
            iRFTab.bindData(list.get(i));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (!z) {
                i2 = this.f36510i;
            }
            layoutParams.rightMargin = i2;
            View view = (View) iRFTab;
            view.setLayoutParams(layoutParams);
            this.f36514m.add(view);
            this.f36504c.addView(view);
            view.setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RFScroller.this.m27482a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27482a(int i, View view) {
        selectTab(i);
    }

    /* renamed from: b */
    private void m27492b(int i, boolean z) {
        m27491b(i);
        OnRFTabSelectedListener onRFTabSelectedListener = this.f36517p;
        if (onRFTabSelectedListener != null) {
            onRFTabSelectedListener.onTabSelected(i);
        }
        if (z) {
            m27490b();
            return;
        }
        m27494c(i);
        post(new Runnable(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RFScroller.this.m27497d(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27497d(int i) {
        View view = this.f36514m.get(i);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        smoothScrollBy((iArr[0] - this.f36510i) - (view.getWidth() / 3), 0);
    }

    /* renamed from: b */
    private void m27491b(int i) {
        int i2 = this.f36516o;
        if (i2 >= 0 && i2 < this.f36514m.size()) {
            ((IRFTab) this.f36514m.get(this.f36516o)).setSelectedState(false);
        }
        this.f36516o = i;
        if (i >= 0 && i < this.f36514m.size()) {
            ((IRFTab) this.f36514m.get(this.f36516o)).setSelectedState(true);
        }
    }

    /* renamed from: c */
    private void m27494c(int i) {
        m27493c();
        View view = this.f36514m.get(i);
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = this.f36505d.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            Float valueOf = Float.valueOf(this.f36505d.getX());
            if (this.f36508g) {
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationX", new float[]{valueOf.floatValue(), Float.valueOf(((view.getX() + ((float) view.getPaddingLeft())) + (((float) width) / 2.0f)) - (((float) this.f36505d.getWidth()) / 2.0f)).floatValue()});
                this.f36521t = ObjectAnimator.ofPropertyValuesHolder(this.f36505d, new PropertyValuesHolder[]{ofFloat});
            } else {
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationX", new float[]{valueOf.floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + this.f36504c.getX()).floatValue()});
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f36505d, new PropertyValuesHolder[]{ofInt, ofFloat2});
                this.f36521t = ofPropertyValuesHolder;
                ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams) {
                    public final /* synthetic */ ViewGroup.LayoutParams f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RFScroller.this.m27486a(this.f$1, valueAnimator);
                    }
                });
            }
            this.f36521t.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = RFScroller.this.f36522u = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = RFScroller.this.f36522u = false;
                }
            });
            this.f36521t.setInterpolator(new FastOutSlowInInterpolator());
            this.f36521t.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27486a(ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f36505d.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m27490b() {
        List<View> list = this.f36514m;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
                if (this.f36508g) {
                    float x = view.getX() + ((float) view.getPaddingLeft());
                    View view2 = this.f36505d;
                    view2.setX((x + (((float) width) / 2.0f)) - (((float) view2.getWidth()) / 2.0f));
                } else {
                    this.f36505d.setLayoutParams(new LinearLayout.LayoutParams(width, this.f36506e));
                    this.f36505d.setX((float) view.getPaddingLeft());
                }
            }
            scrollTo(0, 0);
        }
    }

    /* renamed from: c */
    private void m27493c() {
        ObjectAnimator objectAnimator;
        if (this.f36522u && (objectAnimator = this.f36521t) != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: d */
    private Drawable m27496d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        gradientDrawable.setCornerRadius((float) RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_3));
        return gradientDrawable;
    }

    /* renamed from: a */
    private boolean m27489a(RFTabAdapter rFTabAdapter) {
        RFTabAdapter rFTabAdapter2 = this.f36513l;
        if (rFTabAdapter2 == null || rFTabAdapter2.getData() == null || rFTabAdapter.getItemCount() != this.f36513l.getItemCount()) {
            return false;
        }
        if (rFTabAdapter.getData() == null) {
            return true;
        }
        return this.f36513l.getData().equals(rFTabAdapter.getData());
    }

    public static final class SimpleTab extends RFTextView implements IRFTab<String> {
        public SimpleTab(Context context) {
            this(context, (AttributeSet) null);
        }

        public SimpleTab(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public SimpleTab(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }

        private void init() {
            setPadding(0, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, 0);
            setTabBarSpec(1);
        }

        public void setSelectedState(boolean z) {
            if (z) {
                setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
                setTypeface(1);
                return;
            }
            setTextColor(RFResUtils.getColor(R.color.rf_color_gery_3_60_999999));
            setTypeface(0);
        }

        public void bindData(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 8) {
                    str = str.substring(0, 8);
                }
                setText(str);
            }
        }

        public void setTabBarSpec(int i) {
            if (i == 1) {
                setTextSize(0, (float) RFResUtils.getDimensionPixelSize(R.dimen.f_07_app_36_pad_24));
            } else {
                setTextSize(0, (float) RFResUtils.getDimensionPixelSize(R.dimen.f_10_app_28_pad_16));
            }
        }
    }

    public static final class SimpleTabAdapter extends RFTabAdapter<String> {
        private final List<String> mData;

        public SimpleTabAdapter(Context context, List<String> list) {
            super(context);
            this.mData = list;
        }

        public IRFTab<String> getItemView() {
            return new SimpleTab(getContext());
        }

        public int getItemCount() {
            if (getData() == null) {
                return 0;
            }
            return getData().size();
        }

        public List<String> getData() {
            return this.mData;
        }
    }

    static abstract class OnScrollPositionChangeListener {
        /* access modifiers changed from: package-private */
        public void onScrollToLeft() {
        }

        /* access modifiers changed from: package-private */
        public void onScrollToMiddle() {
        }

        /* access modifiers changed from: package-private */
        public void onScrollToRight() {
        }

        OnScrollPositionChangeListener() {
        }
    }
}
