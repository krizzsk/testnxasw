package com.didi.soda.bill.widgets;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.biz.helper.PointHelper;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerBottomButton extends ConstraintLayout {

    /* renamed from: a */
    private TextView f41986a;

    /* renamed from: b */
    private TextView f41987b;

    /* renamed from: c */
    private TextView f41988c;

    /* renamed from: d */
    private TextView f41989d;

    /* renamed from: e */
    private LottieLoadingView f41990e;

    /* renamed from: f */
    private FrameLayout f41991f;

    /* renamed from: g */
    private View f41992g;

    /* renamed from: h */
    private View f41993h;

    /* renamed from: i */
    private boolean f41994i;

    public interface OnSuccessAnimatorFinishedListener {
        void onAnimatorFinish();
    }

    public CustomerBottomButton(Context context) {
        super(context);
        m31497a();
    }

    public CustomerBottomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31497a();
    }

    public CustomerBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31497a();
    }

    public View getLeftText() {
        return this.f41986a;
    }

    public void setLeftText(String str) {
        this.f41986a.setText(str);
    }

    public void setLeftTextColor(int i) {
        this.f41986a.setTextColor(i);
    }

    public void setLeftTextSize(int i, float f) {
        this.f41986a.setTextSize(i, f);
    }

    public void setLeftFontType(IToolsService.FontType fontType) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41986a, fontType);
    }

    public void setLeftTextBackground(Drawable drawable) {
        this.f41986a.setBackground(drawable);
    }

    public void setLeftPadding(int i, int i2, int i3, int i4) {
        this.f41986a.setPadding(i, i2, i3, i4);
    }

    public PointF getNumberPointF() {
        return PointHelper.getPointF(this.f41986a);
    }

    public void hideLoading() {
        this.f41990e.setVisibility(8);
        this.f41990e.stop();
        this.f41991f.setVisibility(8);
        this.f41989d.setVisibility(0);
    }

    public boolean isLoading() {
        return this.f41990e.isRunning();
    }

    public void loading() {
        this.f41990e.setVisibility(0);
        this.f41990e.start();
        this.f41991f.setVisibility(0);
        this.f41989d.setVisibility(4);
    }

    public void setLeftVisible(int i) {
        this.f41986a.setVisibility(i);
    }

    public void setMiddleTextText(String str) {
        this.f41989d.setText(str);
    }

    public void setMiddleTextGravity(int i) {
        this.f41989d.setGravity(i);
    }

    public void setMiddleVisible(int i) {
        this.f41989d.setVisibility(i);
    }

    public void setMiddleTextSize(int i, float f) {
        this.f41989d.setTextSize(i, f);
    }

    public void setMiddleFontType(IToolsService.FontType fontType) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41989d, fontType);
    }

    public void setBackgroundRes(int i) {
        this.f41993h.setBackgroundResource(i);
    }

    public void setRightText(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f41987b.setVisibility(8);
        } else {
            this.f41987b.setText(str);
            this.f41987b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f41988c.setVisibility(8);
            return;
        }
        this.f41988c.setAlpha(0.5f);
        this.f41988c.setText(str2);
        TextView textView = this.f41988c;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.f41988c.setVisibility(0);
    }

    public void setRightTextVisibility(int i) {
        if (!TextUtils.isEmpty(this.f41987b.getText())) {
            this.f41987b.setVisibility(i);
        }
        if (!TextUtils.isEmpty(this.f41988c.getText())) {
            this.f41988c.setVisibility(i);
        }
    }

    public void setEnabledState(boolean z) {
        this.f41994i = z;
        if (z) {
            this.f41992g.setVisibility(4);
            setClickable(true);
            return;
        }
        this.f41992g.setVisibility(0);
        setClickable(false);
    }

    public boolean getIsEnabledState() {
        return this.f41994i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            CustomerSystemUtil.virate(getContext());
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m31497a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_bottom_button_container, this);
        this.f41993h = findViewById(R.id.customer_cl_mini_cart_bar);
        this.f41989d = (TextView) findViewById(R.id.customer_tv_bottom_button_middle_text);
        this.f41990e = (LottieLoadingView) findViewById(R.id.customer_custom_loading);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.customer_fl_loading_container);
        this.f41991f = frameLayout;
        frameLayout.setBackground(getBackground());
        this.f41986a = (TextView) findViewById(R.id.customer_tv_bottom_button_left_num);
        this.f41987b = (TextView) findViewById(R.id.customer_tv_bottom_button_right_top_text);
        this.f41988c = (TextView) findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        this.f41992g = findViewById(R.id.customer_view_disabled_mask);
        this.f41986a.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f41989d.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f41987b.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f41988c.setTextColor(SkinUtil.getMainButtonSideTextColor());
        hideLoading();
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41989d, IToolsService.FontType.BOLD);
    }
}
