package com.didiglobal.xpanelnew.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class XPanelAnimShadowFrame extends FrameLayout {

    /* renamed from: a */
    private static final int f54136a = 20;

    /* renamed from: b */
    private static final int f54137b = 300;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AnimatorEndListener f54138c;

    /* renamed from: d */
    private int f54139d = 0;

    /* renamed from: e */
    private int f54140e = 300;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Rect f54141f = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Rect f54142g = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f54143h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f54144i;

    public interface AnimatorEndListener {
        void onAnimatorEnd();

        void onAnimatorStart();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public XPanelAnimShadowFrame(Context context, int i, int i2) {
        super(context);
        this.f54139d = i;
        this.f54140e = i2;
    }

    public XPanelAnimShadowFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XPanelAnimShadowFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAnimView(RoundCornerRelativeLayout roundCornerRelativeLayout, RoundCornerRelativeLayout roundCornerRelativeLayout2) {
        this.f54143h = roundCornerRelativeLayout;
        this.f54144i = roundCornerRelativeLayout2;
        CheckHandler checkHandler = new CheckHandler(this);
        Message obtain = Message.obtain();
        obtain.arg1 = 1;
        checkHandler.removeCallbacksAndMessages((Object) null);
        checkHandler.sendMessageDelayed(obtain, 20);
    }

    public Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null || !drawingCache.isRecycled()) {
            return drawingCache;
        }
        return null;
    }

    public Bitmap convertViewToBitmap2(View view) {
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return convertViewToBitmap(view);
        }
        if (drawingCache == null || !drawingCache.isRecycled()) {
            return drawingCache;
        }
        return null;
    }

    public void setAnimatorEndListener(AnimatorEndListener animatorEndListener) {
        this.f54138c = animatorEndListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40329a(RoundCornerRelativeLayout roundCornerRelativeLayout, RoundCornerRelativeLayout roundCornerRelativeLayout2) {
        Rect rect = this.f54141f;
        RoundCornerRelativeLayout roundCornerRelativeLayout3 = (RoundCornerRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.xpanel_card_parent_layout, this, false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) this.f54139d);
        gradientDrawable.setColor(-1);
        roundCornerRelativeLayout3.setBackground(gradientDrawable);
        roundCornerRelativeLayout3.setRadius(this.f54139d);
        roundCornerRelativeLayout3.setTop(rect.top);
        roundCornerRelativeLayout3.setLeft(rect.left);
        roundCornerRelativeLayout3.setRight(rect.right);
        roundCornerRelativeLayout3.setBottom(rect.bottom);
        ImageView imageView = new ImageView(getContext());
        Bitmap convertViewToBitmap2 = convertViewToBitmap2(roundCornerRelativeLayout);
        if (convertViewToBitmap2 == null) {
            AnimatorEndListener animatorEndListener = this.f54138c;
            if (animatorEndListener != null) {
                animatorEndListener.onAnimatorEnd();
                return;
            }
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        imageView.setImageBitmap(convertViewToBitmap2);
        imageView.setLayoutParams(layoutParams);
        roundCornerRelativeLayout3.addView(imageView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = ((LinearLayout.LayoutParams) roundCornerRelativeLayout.getLayoutParams()).leftMargin;
        layoutParams2.topMargin = rect.top;
        layoutParams2.rightMargin = ((LinearLayout.LayoutParams) roundCornerRelativeLayout.getLayoutParams()).rightMargin;
        roundCornerRelativeLayout3.setLayoutParams(layoutParams2);
        addView(roundCornerRelativeLayout3);
        ImageView imageView2 = new ImageView(getContext());
        Bitmap convertViewToBitmap22 = convertViewToBitmap2(roundCornerRelativeLayout2);
        if (convertViewToBitmap22 == null) {
            AnimatorEndListener animatorEndListener2 = this.f54138c;
            if (animatorEndListener2 != null) {
                animatorEndListener2.onAnimatorEnd();
                return;
            }
            return;
        }
        imageView2.setImageBitmap(convertViewToBitmap22);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        imageView2.setTranslationY((float) roundCornerRelativeLayout2.getHeight());
        roundCornerRelativeLayout3.addView(imageView2);
        m40328a((View) imageView, (View) imageView2);
    }

    /* renamed from: a */
    private void m40328a(final View view, final View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "alpha", new float[]{0.0f, 1.0f});
        this.f54144i.getHeight();
        (this.f54143h.getHeight() == 0 ? this.f54144i : this.f54143h).getHeight();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "translationY", new float[]{(float) this.f54144i.getHeight(), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration((long) this.f54140e);
        animatorSet.start();
        AnimatorEndListener animatorEndListener = this.f54138c;
        if (animatorEndListener != null) {
            animatorEndListener.onAnimatorStart();
        }
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (XPanelAnimShadowFrame.this.f54138c != null) {
                    XPanelAnimShadowFrame.this.f54138c.onAnimatorEnd();
                }
                view.setDrawingCacheEnabled(false);
                view2.setDrawingCacheEnabled(false);
            }
        });
    }

    private static class CheckHandler extends Handler {
        private WeakReference<XPanelAnimShadowFrame> ref;

        CheckHandler(XPanelAnimShadowFrame xPanelAnimShadowFrame) {
            this.ref = new WeakReference<>(xPanelAnimShadowFrame);
        }

        public void handleMessage(Message message) {
            XPanelAnimShadowFrame xPanelAnimShadowFrame = (XPanelAnimShadowFrame) this.ref.get();
            if (xPanelAnimShadowFrame != null) {
                xPanelAnimShadowFrame.f54143h.getGlobalVisibleRect(xPanelAnimShadowFrame.f54141f);
                xPanelAnimShadowFrame.f54144i.getGlobalVisibleRect(xPanelAnimShadowFrame.f54142g);
                if (message.arg1 >= 5 || xPanelAnimShadowFrame.m40331a()) {
                    removeCallbacksAndMessages((Object) null);
                    ((XPanelAnimShadowFrame) this.ref.get()).m40329a((RoundCornerRelativeLayout) xPanelAnimShadowFrame.f54143h, (RoundCornerRelativeLayout) xPanelAnimShadowFrame.f54144i);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.arg1 = message.arg1 + 1;
                sendMessageDelayed(obtain, 20);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m40331a() {
        return (this.f54141f.top == 0 && this.f54141f.bottom == 0) ? false : true;
    }
}
