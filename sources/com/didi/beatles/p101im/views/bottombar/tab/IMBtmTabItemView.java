package com.didi.beatles.p101im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabItemView */
public class IMBtmTabItemView extends FrameLayout {

    /* renamed from: a */
    private static final String f11965a = IMBtmTabItemView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f11966b;

    public IMBtmTabItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View view = new View(context, (AttributeSet) null);
        this.f11966b = view;
        view.setBackgroundResource(R.color.im_palette_first);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(IMViewUtil.dp2px(context, 46.0f), IMViewUtil.dp2px(context, 1.0f));
        layoutParams.gravity = 81;
        this.f11966b.setLayoutParams(layoutParams);
    }

    public void addTabView(final View view) {
        removeAllViews();
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                    IMLog.m10020d(f11965a, "[addTabView] #ViewParent# removeView.");
                }
            } catch (Exception e) {
                IMTraceError.trackError("IMBtmTabItemView#addTabView", e);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            view.setLayoutParams(layoutParams);
            addView(view);
            addView(this.f11966b);
            IMViewUtil.hide(this.f11966b);
            post(new Runnable() {
                public void run() {
                    int measuredWidth;
                    try {
                        if (view != null && IMBtmTabItemView.this.f11966b != null && (measuredWidth = view.getMeasuredWidth() - IMBtmTabItemView.this.getResources().getDimensionPixelSize(R.dimen.im_10_dp)) > 0) {
                            ViewGroup.LayoutParams layoutParams = IMBtmTabItemView.this.f11966b.getLayoutParams();
                            layoutParams.width = measuredWidth;
                            IMBtmTabItemView.this.f11966b.setLayoutParams(layoutParams);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void setChecked(boolean z) {
        if (z) {
            IMViewUtil.show(this.f11966b);
        } else {
            IMViewUtil.hide(this.f11966b);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}
