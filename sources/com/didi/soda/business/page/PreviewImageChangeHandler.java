package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.soda.business.page.OverlayView;
import com.didi.soda.business.page.PreviewImageChangeHandler;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;
import java.util.ArrayList;

public class PreviewImageChangeHandler extends SimpleSwapChangeHandler {

    /* renamed from: a */
    private static final String f42347a = "PreviewImageChangeHandler";

    /* renamed from: b */
    private TranslationValue f42348b;

    /* renamed from: c */
    private TranslationValue f42349c;

    /* renamed from: d */
    private String f42350d;

    /* renamed from: e */
    private FrameLayout f42351e;

    /* renamed from: f */
    private boolean f42352f;

    /* renamed from: g */
    private boolean f42353g = false;

    public PreviewImageChangeHandler() {
        super(false);
    }

    public PreviewImageChangeHandler(String str) {
        super(false);
        this.f42350d = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m31850b(View view, int[] iArr) {
        view.getLocationOnScreen(iArr);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f42352f = true;
    }

    public void setPopFadeChange() {
        this.f42353g = true;
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        final int i;
        ViewGroup viewGroup2 = viewGroup;
        if (view == null || view2 == null) {
            super.performChange(viewGroup, view, view2, z, controllerChangeCompletedListener);
            return;
        }
        boolean z2 = !TextUtils.isEmpty(this.f42350d);
        if (z2) {
            int[] iArr = new int[2];
            m31850b(viewGroup, iArr);
            i = iArr[1];
            m31843a(view, true, i);
        } else {
            i = 0;
        }
        m31845a(viewGroup, view, view2, z, controllerChangeCompletedListener);
        if (z2) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f42351e = frameLayout;
            frameLayout.setClickable(false);
            viewGroup.addView(this.f42351e, new ViewGroup.LayoutParams(-1, -1));
            if (!z) {
                this.f42351e.addView(view);
            }
            final View view3 = view2;
            final ViewGroup viewGroup3 = viewGroup;
            final View view4 = view;
            final boolean z3 = z;
            final ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener2 = controllerChangeCompletedListener;
            view2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    PreviewImageChangeHandler.this.m31843a(view3, false, i);
                    PreviewImageChangeHandler.this.m31846a(viewGroup3, view4, view3, z3, (OverlayView.AnimateEndListener) new OverlayView.AnimateEndListener(controllerChangeCompletedListener2) {
                        public final /* synthetic */ ControllerChangeHandler.ControllerChangeCompletedListener f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onAnimationEnd() {
                            PreviewImageChangeHandler.C143001.this.lambda$onPreDraw$0$PreviewImageChangeHandler$1(this.f$1);
                        }
                    });
                    return true;
                }

                public /* synthetic */ void lambda$onPreDraw$0$PreviewImageChangeHandler$1(ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
                    controllerChangeCompletedListener.onChangeCompleted();
                    PreviewImageChangeHandler.this.m31852d();
                }
            });
        }
    }

    /* renamed from: a */
    private void m31845a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (!this.f42352f) {
            if (view != null && (!z || removesFromViewOnPush())) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31846a(ViewGroup viewGroup, View view, View view2, boolean z, final OverlayView.AnimateEndListener animateEndListener) {
        Animator a = m31842a(view, view2, z);
        Animator c = this.f42353g ? null : m31851c();
        if (a == null && c == null) {
            animateEndListener.onAnimationEnd();
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (a != null) {
            arrayList.add(a);
        }
        if (c != null) {
            arrayList.add(c);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                animateEndListener.onAnimationEnd();
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animateEndListener.onAnimationEnd();
            }
        });
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200);
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        animatorSet.start();
    }

    /* renamed from: a */
    private Animator m31842a(View view, View view2, boolean z) {
        int i;
        int i2;
        View view3;
        if (view == null || view2 == null) {
            return null;
        }
        if (z) {
            view3 = view2.findViewById(R.id.customer_cl_image_root_view);
            i2 = 0;
            i = 1;
        } else {
            view3 = view.findViewById(R.id.customer_cl_image_root_view);
            i2 = 1;
            i = 0;
        }
        if (view3 == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{(float) i2, (float) i});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        return ofFloat;
    }

    /* renamed from: c */
    private Animator m31851c() {
        TranslationValue translationValue = this.f42348b;
        if (!(translationValue == null || this.f42349c == null)) {
            View view = translationValue.mView;
            try {
                Bitmap createBitmap = (view.getWidth() <= 0 || view.getHeight() <= 0) ? null : Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    LogUtil.m32586e("PreviewImage", "创建图片失败，不支持转场动画");
                    return null;
                }
                view.draw(new Canvas(createBitmap));
                OverlayView overlayView = new OverlayView(this.f42351e.getContext(), createBitmap);
                this.f42351e.addView(overlayView, new ViewGroup.LayoutParams(-1, -1));
                overlayView.mo107268a(view, this.f42348b.mScreenX, this.f42348b.mScreenY);
                overlayView.mo107270b(this.f42349c.mView, this.f42349c.mScreenX, this.f42349c.mScreenY);
                return overlayView.mo107269b();
            } catch (OutOfMemoryError unused) {
                LogUtil.m32586e("PreviewImage", "创建图片失败 OOM 异常，不支持转场动画");
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m31852d() {
        FrameLayout frameLayout = this.f42351e;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f42351e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31843a(View view, boolean z, int i) {
        if (view != null && !TextUtils.isEmpty(this.f42350d)) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (z) {
                if (TextUtils.equals(this.f42350d, transitionName)) {
                    if (this.f42348b == null) {
                        this.f42348b = TranslationValue.create(view, i);
                    } else {
                        LogUtil.m32590w(f42347a, "页面中含有两个相同的 Transition Name value = " + transitionName + "， 动画时会忽略第二个");
                    }
                }
            } else if (TextUtils.equals(this.f42350d, transitionName)) {
                if (this.f42349c == null) {
                    this.f42349c = TranslationValue.create(view, i);
                } else {
                    LogUtil.m32590w(f42347a, "页面中含有两个相同的 Transition Name value = " + transitionName + "， 动画时会忽略第二个");
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    m31843a(viewGroup.getChildAt(i2), z, i);
                }
            }
        }
    }

    private static class TranslationValue {
        int mScreenX;
        int mScreenY;
        View mView;

        private TranslationValue() {
        }

        static TranslationValue create(View view, int i) {
            TranslationValue translationValue = new TranslationValue();
            translationValue.mView = view;
            int[] iArr = new int[2];
            PreviewImageChangeHandler.m31850b(view, iArr);
            translationValue.mScreenX = iArr[0];
            translationValue.mScreenY = iArr[1] - i;
            return translationValue;
        }
    }
}
