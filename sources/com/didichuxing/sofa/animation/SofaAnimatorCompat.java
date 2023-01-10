package com.didichuxing.sofa.animation;

import android.view.View;

public class SofaAnimatorCompat {

    /* renamed from: a */
    private static int f51646a = 1;

    private SofaAnimatorCompat() {
    }

    public static void doRealAnimation() {
        f51646a = 1;
    }

    public static void doFakeAnimation() {
        f51646a = 2;
    }

    /* renamed from: a */
    private static AnimatorBuilder m38759a() {
        int i = f51646a;
        if (i == 1) {
            return new C17278x();
        }
        if (i != 2) {
            return new C17278x();
        }
        return new C17270o();
    }

    /* renamed from: b */
    private static ValueAnimatorBuilder m38760b() {
        return new ValueAnimatorBuilder();
    }

    public static AnimatorBuilder play(View view) {
        AnimatorBuilder a = m38759a();
        a.play(view);
        return a;
    }

    public static ValueAnimatorBuilder valueAnimation() {
        return m38760b();
    }

    public static Animator playTogether(Animator... animatorArr) {
        if (animatorArr == null || animatorArr.length == 0) {
            throw new IllegalArgumentException("No animator to play!");
        } else if (animatorArr[0] instanceof C17276v) {
            return m38760b().playTogether(animatorArr);
        } else {
            return m38759a().playTogether(animatorArr);
        }
    }

    public static Animator playSequentially(Animator... animatorArr) {
        if (animatorArr == null || animatorArr.length == 0) {
            throw new IllegalArgumentException("No animator to play!");
        } else if (animatorArr[0] instanceof C17276v) {
            return m38760b().playSequentially(animatorArr);
        } else {
            return m38759a().playSequentially(animatorArr);
        }
    }
}
