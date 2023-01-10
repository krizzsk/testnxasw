package com.didichuxing.sofa.animation;

import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.didichuxing.sofa.animation.k */
/* compiled from: CommonAnimationHelper */
class C17266k {

    /* renamed from: a */
    private static final String f51671a = "CommonAnimationHelper";

    /* renamed from: b */
    private static float[] f51672b = {0.0f, 1.0f};

    /* renamed from: c */
    private static float[] f51673c = {1.0f, 0.0f};

    C17266k() {
    }

    /* renamed from: a */
    static AnimatorBuilder m38770a(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.alpha(f51672b).decelerate();
    }

    /* renamed from: b */
    static AnimatorBuilder m38772b(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.alpha(f51673c).decelerate();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static float[] m38779e(View view) {
        float f = (float) (-view.getHeight());
        float y = view.getY();
        LoggerUtil.m38757d(f51671a, "getTranslateInFromTopValues view: " + view + "[y: " + y + Const.jaRight);
        if (y < 0.0f) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                LoggerUtil.m38757d(f51671a, "getTranslateInFromTopValues parent: " + viewGroup + "[top padding: " + viewGroup.getPaddingTop() + Const.jaRight);
                y = (float) viewGroup.getPaddingTop();
            } else {
                y = 0.0f;
            }
        }
        LoggerUtil.m38757d(f51671a, "translateInFromTop valueFrom: " + f + " valueTo: " + y);
        return new float[]{f, y};
    }

    /* renamed from: c */
    static AnimatorBuilder m38774c(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo127598y(m38779e(target));
        } else {
            animatorBuilder.mo127552a((Runnable) new CommonAnimationHelper$1(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static float[] m38781f(View view) {
        float y = view.getY();
        float f = (float) (-view.getHeight());
        LoggerUtil.m38757d(f51671a, "translateOutToTop valueFrom: " + y + " valueTo: " + f);
        return new float[]{y, f};
    }

    /* renamed from: d */
    static AnimatorBuilder m38776d(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo127598y(m38781f(target));
        } else {
            animatorBuilder.mo127552a((Runnable) new CommonAnimationHelper$2(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static float[] m38783g(View view) {
        float height = (float) view.getRootView().getHeight();
        float y = view.getY();
        LoggerUtil.m38757d(f51671a, "translateInFromBottom valueFrom: " + height + " valueTo: " + y);
        return new float[]{height, y};
    }

    /* renamed from: e */
    static AnimatorBuilder m38778e(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo127598y(m38783g(target));
        } else {
            animatorBuilder.mo127552a((Runnable) new CommonAnimationHelper$3(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static float[] m38785h(View view) {
        View rootView = view.getRootView();
        float y = view.getY();
        float height = (float) rootView.getHeight();
        LoggerUtil.m38757d(f51671a, "translateOutToBottom valueFrom: " + y + " valueTo: " + height);
        return new float[]{y, height};
    }

    /* renamed from: f */
    static AnimatorBuilder m38780f(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo127598y(m38785h(target));
        } else {
            animatorBuilder.mo127552a((Runnable) new CommonAnimationHelper$4(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* renamed from: g */
    static AnimatorBuilder m38782g(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.scaleX(f51672b).scaleY(f51672b);
    }

    /* renamed from: h */
    static AnimatorBuilder m38784h(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.scaleX(f51673c).scaleY(f51673c);
    }

    /* renamed from: i */
    static AnimatorBuilder m38786i(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.rotate(0.0f, 360.0f);
    }

    /* renamed from: j */
    static AnimatorBuilder m38787j(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.rotate(360.0f, 0.0f);
    }
}
