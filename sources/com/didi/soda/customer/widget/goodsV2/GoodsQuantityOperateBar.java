package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.taxis99.R;

public class GoodsQuantityOperateBar extends LinearLayout implements GoodsQuantityActionHandler {

    /* renamed from: a */
    private static final int f44485a = 2;

    /* renamed from: b */
    private String f44486b;

    /* renamed from: c */
    private GoodsQuantityListener f44487c;

    /* renamed from: d */
    private Bundle f44488d;

    /* renamed from: e */
    private boolean f44489e = false;

    /* renamed from: f */
    private TextView f44490f;

    /* renamed from: g */
    private View f44491g;

    /* renamed from: h */
    private View f44492h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f44493i;

    /* renamed from: j */
    private FrameLayout f44494j;

    /* renamed from: k */
    private TextView f44495k;

    /* renamed from: l */
    private GoodsAmountModel f44496l;

    /* renamed from: m */
    private Context f44497m;

    /* renamed from: n */
    private Drawable f44498n = null;

    /* renamed from: o */
    private Drawable f44499o = null;

    public GoodsQuantityOperateBar(Context context) {
        super(context);
        m33022a(context, (AttributeSet) null);
    }

    public GoodsQuantityOperateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33022a(context, attributeSet);
    }

    public void onHandleAddGoodsAction() {
        m33023a((View) this.f44493i);
    }

    public void onHandleSubtractGoodsAction() {
        m33028c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f44491g.setEnabled(z);
        this.f44493i.setEnabled(z);
        this.f44492h.setEnabled(z);
        this.f44494j.setEnabled(z);
        this.f44495k.setEnabled(z);
        if (this.f44489e) {
            this.f44490f.setEnabled(z);
            if (z) {
                this.f44490f.setTextColor(this.f44497m.getResources().getColor(R.color.rf_color_jianbian_2));
            } else {
                this.f44490f.setTextColor(this.f44497m.getResources().getColor(R.color.rf_color_gery_3_60_999999));
            }
        } else {
            this.f44490f.setEnabled(z);
        }
    }

    public void setGoodsQuantityListener(GoodsQuantityListener goodsQuantityListener) {
        this.f44487c = goodsQuantityListener;
    }

    public void setSubtractBgDisabled() {
        this.f44492h.setBackground(getContext().getResources().getDrawable(R.drawable.customer_img_goods_subtract_disabled));
    }

    public void setSubtractEnabled(boolean z) {
        super.setEnabled(z);
        this.f44492h.setBackground(this.f44499o);
        this.f44492h.setEnabled(z);
        this.f44494j.setEnabled(z);
    }

    public void updateGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        this.f44496l = goodsAmountModel;
        int currentAmount = goodsAmountModel.getCurrentAmount();
        this.f44486b = goodsAmountModel.mGoodsId;
        m33020a(currentAmount);
        m33026b(currentAmount);
        m33029c(currentAmount);
        m33030d(currentAmount);
    }

    /* access modifiers changed from: package-private */
    public void setExtra(Bundle bundle) {
        this.f44488d = bundle;
    }

    /* renamed from: a */
    private void m33022a(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        ColorStateList colorStateList;
        int i3;
        this.f44497m = context;
        float f = 0.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.GoodsQuantityOperateBar);
            i3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            colorStateList = obtainStyledAttributes.getColorStateList(3);
            i2 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            this.f44499o = obtainStyledAttributes.getDrawable(2);
            this.f44498n = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            i = (int) obtainStyledAttributes.getDimension(4, 0.0f);
            f = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
        } else {
            colorStateList = null;
            i = 0;
            i3 = 0;
            i2 = 0;
        }
        m33025b();
        m33021a(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = i2;
        this.f44493i.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.rightMargin = i2;
        this.f44494j.setLayoutParams(layoutParams2);
        this.f44492h.setBackground(this.f44499o);
        this.f44491g.setBackground(this.f44498n);
        this.f44495k.setTextSize(0, f);
        this.f44495k.setMinWidth(i);
        if (colorStateList != null) {
            this.f44495k.setTextColor(colorStateList);
        }
        this.f44495k.setGravity(17);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44495k, IToolsService.FontType.BOLD);
        setOrientation(0);
        setGravity(16);
        this.f44493i.addView(this.f44491g, new FrameLayout.LayoutParams(i3, i3));
        this.f44494j.addView(this.f44492h, new FrameLayout.LayoutParams(i3, i3));
        addView(this.f44490f);
        addView(this.f44494j);
        addView(this.f44495k);
        addView(this.f44493i);
        this.f44494j.setVisibility(8);
        this.f44495k.setVisibility(8);
        this.f44493i.setVisibility(8);
        this.f44495k.setMaxEms(2);
        m33019a();
        setEnabled(true);
    }

    /* renamed from: a */
    private void m33019a() {
        this.f44490f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar goodsQuantityOperateBar = GoodsQuantityOperateBar.this;
                    goodsQuantityOperateBar.m33023a((View) goodsQuantityOperateBar.f44493i);
                }
            }
        });
        this.f44493i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m33023a(view);
                }
            }
        });
        this.f44494j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ClickUtils.isFastClick()) {
                    GoodsQuantityOperateBar.this.m33028c();
                }
            }
        });
    }

    /* renamed from: a */
    private void m33021a(Context context) {
        this.f44491g = new View(context);
        this.f44492h = new View(context);
        this.f44493i = new FrameLayout(context);
        this.f44494j = new FrameLayout(context);
        this.f44495k = new TextView(context);
        if (this.f44489e) {
            TextView textView = new TextView(context);
            this.f44490f = textView;
            textView.setText(context.getResources().getString(R.string.customer_global_add));
            this.f44490f.setTextColor(context.getResources().getColor(R.color.rf_color_jianbian_2));
            this.f44490f.setBackground(this.f44497m.getResources().getDrawable(R.drawable.customer_selector_goods_operator_initial_view));
        } else {
            TextView textView2 = new TextView(context);
            this.f44490f = textView2;
            textView2.setBackground(this.f44498n);
        }
        this.f44490f.setEnabled(true);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44490f, IToolsService.FontType.BOLD);
    }

    /* renamed from: b */
    private void m33025b() {
        boolean z = true;
        if (((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().showStyle != 1) {
            z = false;
        }
        this.f44489e = z;
    }

    /* renamed from: a */
    private void m33020a(int i) {
        if (i > 0) {
            this.f44495k.setText(String.valueOf(i));
            this.f44495k.setVisibility(0);
            return;
        }
        this.f44495k.setVisibility(8);
    }

    /* renamed from: b */
    private void m33026b(int i) {
        this.f44490f.setVisibility(i == 0 ? 0 : 8);
    }

    /* renamed from: c */
    private void m33029c(int i) {
        this.f44493i.setVisibility(i > 0 ? 0 : 8);
    }

    /* renamed from: d */
    private void m33030d(int i) {
        this.f44494j.setVisibility(i > 0 ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33023a(View view) {
        GoodsQuantityListener goodsQuantityListener = this.f44487c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onAddGoodsClick(this.f44486b, view, this.f44488d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33028c() {
        GoodsQuantityListener goodsQuantityListener = this.f44487c;
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onSubtractGoodsClick(this.f44486b, this.f44488d);
        }
    }
}
