package com.didi.soda.customer.widget.goodsV2.stepper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goodsV2.EnlargeClickAreaContainer;
import com.taxis99.R;

public class GoodsQuantityAnimStepper extends RelativeLayout {

    /* renamed from: a */
    private static final int f44516a = 300;

    /* renamed from: b */
    private ImageView f44517b;

    /* renamed from: c */
    private ImageView f44518c;

    /* renamed from: d */
    private TextView f44519d;

    /* renamed from: e */
    private ObjectAnimator f44520e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoodsStepperListener f44521f;

    /* renamed from: g */
    private EnlargeClickAreaContainer f44522g;

    /* renamed from: h */
    private EnlargeClickAreaContainer f44523h;

    /* renamed from: i */
    private int f44524i;

    /* renamed from: j */
    private int f44525j;

    /* renamed from: k */
    private int f44526k;

    /* renamed from: l */
    private int f44527l;

    /* renamed from: m */
    private ViewGroup.LayoutParams f44528m;

    public GoodsQuantityAnimStepper(Context context) {
        super(context);
        m33046a(context, (AttributeSet) null);
    }

    public GoodsQuantityAnimStepper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33046a(context, attributeSet);
    }

    public void setGoodsStepperListener(GoodsStepperListener goodsStepperListener) {
        this.f44521f = goodsStepperListener;
    }

    public void initState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m33043a(goodsStepperModel.mCurQuantityNumber);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    public void updateState(GoodsStepperModel goodsStepperModel) {
        if (goodsStepperModel != null) {
            setAddEnabled(goodsStepperModel.mIsAddEnabled);
            m33049a(goodsStepperModel);
            goodsStepperModel.syncLastQuantityNumber();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(getDefaultSize(this.f44524i, i), i2);
    }

    private void setAddEnabled(boolean z) {
        this.f44517b.setImageResource(z ? this.f44526k : this.f44527l);
    }

    /* renamed from: a */
    private void m33043a(int i) {
        ObjectAnimator objectAnimator = this.f44520e;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f44520e.cancel();
        }
        if (i <= 0) {
            m33044a(this.f44524i, 0.0f);
            return;
        }
        m33044a(this.f44525j, 1.0f);
        this.f44519d.setText(String.valueOf(i));
    }

    /* renamed from: a */
    private void m33049a(GoodsStepperModel goodsStepperModel) {
        int i = goodsStepperModel.mCurQuantityNumber;
        if (i >= 0) {
            if (i > 0) {
                this.f44519d.setText(String.valueOf(i));
            }
            if (goodsStepperModel.needExpand()) {
                m33052c();
            } else if (goodsStepperModel.needCollapse()) {
                m33053d();
            }
        }
    }

    /* renamed from: a */
    private void m33046a(Context context, AttributeSet attributeSet) {
        int dip2px = DisplayUtils.dip2px(getContext(), 18.0f);
        int color = ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666);
        this.f44526k = R.drawable.customer_stepper_add_icon_v2;
        this.f44527l = R.drawable.customer_stepper_add_icon_disable_v2;
        this.f44524i = DisplayUtils.dip2px(getContext(), 22.0f);
        this.f44525j = DisplayUtils.dip2px(getContext(), 110.0f);
        int i = R.drawable.customer_stepper_sub_icon_v2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.GoodsQuantityAnimStepper);
            dip2px = obtainStyledAttributes.getDimensionPixelSize(6, dip2px);
            color = obtainStyledAttributes.getColor(5, color);
            i = obtainStyledAttributes.getResourceId(4, R.drawable.customer_stepper_sub_icon_v2);
            this.f44526k = obtainStyledAttributes.getResourceId(0, this.f44526k);
            this.f44527l = obtainStyledAttributes.getResourceId(1, this.f44527l);
            this.f44524i = obtainStyledAttributes.getDimensionPixelSize(3, this.f44524i);
            this.f44525j = obtainStyledAttributes.getDimensionPixelSize(2, this.f44525j);
            obtainStyledAttributes.recycle();
        }
        m33045a(context);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 26.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams.addRule(9);
        EnlargeClickAreaContainer newInstance = EnlargeClickAreaContainer.newInstance(getContext());
        this.f44522g = newInstance;
        newInstance.setTarget(this.f44518c).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m33051b(view);
            }
        }).setRootLayoutParams(layoutParams).build(dip2px2);
        this.f44518c.setImageResource(i);
        this.f44519d.setTextSize(0, (float) dip2px);
        this.f44519d.setTextColor(color);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f44519d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        layoutParams3.addRule(11);
        EnlargeClickAreaContainer newInstance2 = EnlargeClickAreaContainer.newInstance(getContext());
        this.f44523h = newInstance2;
        newInstance2.setTarget(this.f44517b).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsQuantityAnimStepper.this.m33047a(view);
            }
        }).setRootLayoutParams(layoutParams3).build(dip2px2);
        this.f44517b.setBackgroundColor(-1);
        setAddEnabled(true);
        addView(this.f44522g);
        addView(this.f44519d);
        addView(this.f44523h);
        this.f44518c.setAlpha(0.0f);
        this.f44519d.setAlpha(0.0f);
        m33042a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33051b(View view) {
        GoodsStepperListener goodsStepperListener = this.f44521f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onSubtractClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33047a(View view) {
        GoodsStepperListener goodsStepperListener = this.f44521f;
        if (goodsStepperListener != null) {
            goodsStepperListener.onAddClick();
        }
    }

    /* renamed from: a */
    private void m33042a() {
        this.f44517b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f44521f != null) {
                    GoodsQuantityAnimStepper.this.f44521f.onAddClick();
                }
            }
        });
        this.f44518c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GoodsQuantityAnimStepper.this.f44521f != null) {
                    GoodsQuantityAnimStepper.this.f44521f.onSubtractClick();
                }
            }
        });
    }

    /* renamed from: a */
    private void m33045a(Context context) {
        this.f44517b = new ImageView(context);
        this.f44518c = new ImageView(context);
        this.f44519d = new TextView(context);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44519d, IToolsService.FontType.BOLD);
        setGravity(16);
    }

    /* renamed from: b */
    private void m33050b() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "", new int[]{this.f44524i, this.f44525j});
        this.f44520e = ofInt;
        ofInt.setInterpolator(CustomerInterpolator.newInstance());
        this.f44520e.setDuration(300);
        this.f44520e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoodsQuantityAnimStepper.this.m33044a(((Integer) valueAnimator.getAnimatedValue()).intValue(), valueAnimator.getAnimatedFraction());
            }
        });
        this.f44520e.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33044a(int i, float f) {
        if (this.f44528m == null) {
            this.f44528m = getLayoutParams();
        }
        this.f44528m.width = i;
        setLayoutParams(this.f44528m);
        this.f44518c.setAlpha(f);
        this.f44519d.setAlpha(f);
    }

    /* renamed from: c */
    private void m33052c() {
        if (this.f44520e == null) {
            m33050b();
        }
        this.f44520e.start();
    }

    /* renamed from: d */
    private void m33053d() {
        if (this.f44520e == null) {
            m33050b();
        }
        this.f44520e.reverse();
    }
}
