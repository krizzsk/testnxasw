package com.didi.component.estimate.newui.view.vertical;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public class VerticalSelectAnimation {
    public static final int SEL_ITEM_HEIGHT = 100;
    public static final int SEL_ITEM_LOADING_HEIGHT = 100;
    public static final int SEL_ITEM_WITH_OPTIONS_HEIGHT = 135;
    public static final int SHADOW_MARGIN = 64;
    public static final int UN_SEL_ITEM_HEIGHT = 85;
    public static final int UN_SEL_ITEM_LOADING_HEIGHT = 85;

    /* renamed from: a */
    static final int f15033a = 22;

    /* renamed from: c */
    private static final int f15034c = 42;

    /* renamed from: d */
    private static final float f15035d = 1.0f;

    /* renamed from: e */
    private static final float f15036e = 1.5f;

    /* renamed from: b */
    private final Context f15037b;

    /* renamed from: f */
    private int f15038f;

    /* renamed from: g */
    private int f15039g = 0;

    /* renamed from: h */
    private int f15040h = 0;

    /* renamed from: i */
    private int f15041i = 0;

    /* renamed from: j */
    private int f15042j = 0;

    /* renamed from: k */
    private ValueAnimator f15043k;

    /* renamed from: l */
    private ValueAnimator f15044l;

    /* renamed from: m */
    private ValueAnimator f15045m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public EstimateItemModel f15046n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public EstimateItemModel f15047o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RecyclerView f15048p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public RecommendVerticalAdapter f15049q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f15050r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ViewGroup f15051s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f15052t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f15053u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public SelectAnimationEndCallBack f15054v;

    interface SelectAnimationEndCallBack {
        void selectAnimationEnd();
    }

    public float calculateCarIconScale(float f, boolean z) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return z ? (f * 0.5f) + 1.0f : 1.5f - (f * 0.5f);
    }

    public int calculateShadow(float f, int i, int i2) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return (int) (((float) i) + (((float) (i2 - i)) * f));
    }

    public void setAnimationEndCallBack(SelectAnimationEndCallBack selectAnimationEndCallBack) {
        this.f15054v = selectAnimationEndCallBack;
    }

    public VerticalSelectAnimation(Context context) {
        this.f15037b = context;
        m12370a();
    }

    /* renamed from: a */
    private void m12370a() {
        this.f15038f = UiUtils.dip2px(this.f15037b, 85.0f);
        this.f15039g = UiUtils.dip2px(this.f15037b, 90.0f);
        this.f15040h = UiUtils.dip2px(this.f15037b, 100.0f);
        this.f15041i = UiUtils.dip2px(this.f15037b, 60.0f);
        this.f15042j = UiUtils.dip2px(this.f15037b, 100.0f);
        ValueAnimator valueAnimator = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f15048p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f15049q.getDataList().indexOf(VerticalSelectAnimation.this.f15046n));
                if (valueAnimator != null && verticalCarViewHolder != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f15046n) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = verticalCarViewHolder.carInfoContainer.getLayoutParams();
                    layoutParams.height = VerticalSelectAnimation.this.calculateCardHeight(floatValue, true, verticalCarViewHolder.selectedInfoHeight);
                    verticalCarViewHolder.carInfoContainer.setLayoutParams(layoutParams);
                    float calculateCarIconScale = VerticalSelectAnimation.this.calculateCarIconScale(floatValue, true);
                    verticalCarViewHolder.carIcon.setScaleX(calculateCarIconScale);
                    verticalCarViewHolder.carIcon.setScaleY(calculateCarIconScale);
                }
            }
        });
        this.f15043k = valueAnimator;
        valueAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (VerticalSelectAnimation.this.f15054v != null) {
                    VerticalSelectAnimation.this.f15054v.selectAnimationEnd();
                }
            }
        });
        this.f15044l = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f15048p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f15049q.getDataList().indexOf(VerticalSelectAnimation.this.f15047o));
                if (valueAnimator != null && verticalCarViewHolder != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f15047o) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = verticalCarViewHolder.carInfoContainer.getLayoutParams();
                    layoutParams.height = VerticalSelectAnimation.this.calculateCardHeight(floatValue, false, verticalCarViewHolder.selectedInfoHeight);
                    verticalCarViewHolder.carInfoContainer.setLayoutParams(layoutParams);
                    float calculateCarIconScale = VerticalSelectAnimation.this.calculateCarIconScale(floatValue, false);
                    verticalCarViewHolder.carIcon.setScaleX(calculateCarIconScale);
                    verticalCarViewHolder.carIcon.setScaleY(calculateCarIconScale);
                }
            }
        });
        this.f15045m = GlobalUIKitAnimationFactory.getValueAnimator(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, 400, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerticalCarViewHolder verticalCarViewHolder;
                if (valueAnimator != null && (verticalCarViewHolder = (VerticalCarViewHolder) VerticalSelectAnimation.this.f15048p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f15049q.getDataList().indexOf(VerticalSelectAnimation.this.f15046n))) != null && verticalCarViewHolder.itemView.isAttachedToWindow() && verticalCarViewHolder.estimateItemModel == VerticalSelectAnimation.this.f15046n) {
                    VerticalCarViewHolder verticalCarViewHolder2 = (VerticalCarViewHolder) VerticalSelectAnimation.this.f15048p.findViewHolderForAdapterPosition(VerticalSelectAnimation.this.f15049q.getDataList().indexOf(VerticalSelectAnimation.this.f15047o));
                    if (verticalCarViewHolder2 == null || !verticalCarViewHolder2.itemView.isAttachedToWindow() || verticalCarViewHolder2.estimateItemModel != VerticalSelectAnimation.this.f15047o) {
                        verticalCarViewHolder2 = verticalCarViewHolder;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int calculateShadow = VerticalSelectAnimation.this.calculateShadow(floatValue, verticalCarViewHolder2.selectedCardHeight, verticalCarViewHolder.selectedCardHeight);
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    verticalCarViewHolder2.itemView.getLocationOnScreen(iArr);
                    verticalCarViewHolder.itemView.getLocationOnScreen(iArr2);
                    VerticalSelectAnimation.this.f15051s.getLocationOnScreen(iArr3);
                    int calculateShadow2 = VerticalSelectAnimation.this.calculateShadow(floatValue, iArr[1] - iArr3[1], iArr2[1] - iArr3[1]);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VerticalSelectAnimation.this.f15050r.getLayoutParams();
                    layoutParams.height = calculateShadow;
                    layoutParams.topMargin = calculateShadow2 + VerticalSelectAnimation.this.f15052t;
                    int unused = VerticalSelectAnimation.this.f15053u = layoutParams.topMargin;
                    VerticalSelectAnimation.this.f15050r.setLayoutParams(layoutParams);
                }
            }
        });
    }

    public void setRecyclerView(RecyclerView recyclerView, RecommendVerticalAdapter recommendVerticalAdapter, View view, ViewGroup viewGroup) {
        this.f15048p = recyclerView;
        this.f15049q = recommendVerticalAdapter;
        this.f15050r = view;
        this.f15051s = viewGroup;
    }

    public void setItemModel(EstimateItemModel estimateItemModel, EstimateItemModel estimateItemModel2) {
        this.f15046n = estimateItemModel;
        this.f15047o = estimateItemModel2;
    }

    public void startAnimation() {
        if (m12372b()) {
            m12374c();
        }
        this.f15043k.start();
        this.f15044l.start();
        this.f15045m.start();
    }

    public void resetShadow() {
        this.f15050r.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15050r.getLayoutParams();
        layoutParams.height = UIUtils.dip2pxInt(this.f15037b, 164.0f);
        layoutParams.topMargin = 0;
        this.f15050r.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private boolean m12372b() {
        return this.f15043k.isRunning();
    }

    /* renamed from: c */
    private void m12374c() {
        this.f15043k.end();
        this.f15044l.end();
        this.f15045m.end();
    }

    public void updateViewHolder(VerticalCarViewHolder verticalCarViewHolder, EstimateItemModel estimateItemModel) {
        if (verticalCarViewHolder != null && estimateItemModel != null) {
            float carIconScale = getCarIconScale(estimateItemModel);
            if (verticalCarViewHolder.carIcon != null) {
                verticalCarViewHolder.carIcon.setScaleX(carIconScale);
                verticalCarViewHolder.carIcon.setScaleY(carIconScale);
            }
        }
    }

    public int calculateCardHeight(float f, boolean z, int i) {
        int i2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i3 = this.f15038f;
            i2 = (int) (((float) i3) + (((float) (i - i3)) * f));
        } else {
            i2 = (int) (((float) i) - (((float) (i - this.f15038f)) * f));
        }
        int i4 = this.f15038f;
        return i2 < i4 ? i4 : i2;
    }

    public int calculateCarIconWidth(float f, boolean z) {
        float f2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i = this.f15039g;
            f2 = ((float) i) + (((float) (this.f15040h - i)) * f);
        } else {
            int i2 = this.f15040h;
            f2 = ((float) i2) - (((float) (i2 - this.f15039g)) * f);
        }
        return (int) f2;
    }

    public int calculateCarIconHeight(float f, boolean z) {
        float f2;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (z) {
            int i = this.f15041i;
            f2 = ((float) i) + (((float) (this.f15042j - i)) * f);
        } else {
            int i2 = this.f15042j;
            f2 = ((float) i2) - (((float) (i2 - this.f15041i)) * f);
        }
        return (int) f2;
    }

    public float getCarIconScale(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f15043k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f15046n && this.f15043k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconScale(f, true);
        }
        float floatValue2 = ((Float) this.f15044l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f15047o && this.f15044l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconScale(f, false);
    }

    public int getCarIconWidth(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f15043k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f15046n && this.f15043k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconWidth(f, true);
        }
        float floatValue2 = ((Float) this.f15044l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f15047o && this.f15044l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconWidth(f, false);
    }

    public int getCarIconHeight(EstimateItemModel estimateItemModel) {
        float f = 1.0f;
        if (estimateItemModel != null && estimateItemModel.isSelected) {
            float floatValue = ((Float) this.f15043k.getAnimatedValue()).floatValue();
            if (estimateItemModel == this.f15046n && this.f15043k.isRunning()) {
                f = floatValue;
            }
            return calculateCarIconHeight(f, true);
        }
        float floatValue2 = ((Float) this.f15044l.getAnimatedValue()).floatValue();
        if (estimateItemModel == this.f15047o && this.f15044l.isRunning()) {
            f = floatValue2;
        }
        return calculateCarIconHeight(f, false);
    }

    public int getmMagnifierViewTopMargin() {
        return this.f15053u;
    }

    public void setMoveMargin(int i) {
        this.f15052t = i;
    }
}
