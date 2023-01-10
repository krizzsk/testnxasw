package com.didiglobal.p205sa.biz.component.sapanel;

import android.animation.ValueAnimator;
import android.view.View;
import com.didi.common.map.model.Padding;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.PanelAnimatorMgr */
public class PanelAnimatorMgr {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static List<AnimationListener> f53631a = new ArrayList();

    /* renamed from: b */
    private static List<ScrolledListener> f53632b = new ArrayList();

    /* renamed from: c */
    private static List<RvScrollingListener> f53633c = new ArrayList();

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.PanelAnimatorMgr$AnimationListener */
    public interface AnimationListener {
        void onAnimationProcess(AnimationModel animationModel);
    }

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.PanelAnimatorMgr$RvScrollingListener */
    public interface RvScrollingListener {
        void onScroll(int i);
    }

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.PanelAnimatorMgr$ScrolledListener */
    public interface ScrolledListener {
        void onScrollChanged(Padding padding);
    }

    public static void valueAnimat(View view, int i, int i2, long j, boolean z, int i3, AnimationListener animationListener) {
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{i, i2}).setDuration(j);
        final AnimationModel animationModel = new AnimationModel();
        final boolean z2 = z;
        final int i4 = i3;
        final View view2 = view;
        final AnimationListener animationListener2 = animationListener;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedFraction == 1.0f && z2) {
                    PageTouchEventManger.pullToRid = true;
                }
                animationModel.setType(i4);
                animationModel.setProcess(num.intValue());
                animationModel.setFraction(animatedFraction);
                animationModel.setTarget(view2);
                animationModel.setExpand(z2);
                AnimationListener animationListener = animationListener2;
                if (animationListener != null) {
                    animationListener.onAnimationProcess(animationModel);
                }
                for (AnimationListener onAnimationProcess : PanelAnimatorMgr.f53631a) {
                    onAnimationProcess.onAnimationProcess(animationModel);
                }
            }
        });
        duration.start();
    }

    public static void addAnimationListener(AnimationListener animationListener) {
        f53631a.add(animationListener);
    }

    public static void removeListener(AnimationListener animationListener) {
        f53631a.remove(animationListener);
    }

    public static void addScrolledListener(ScrolledListener scrolledListener) {
        f53632b.add(scrolledListener);
    }

    public static void removeScrolledListener(ScrolledListener scrolledListener) {
        f53632b.remove(scrolledListener);
    }

    public static void onScrollChanged(Padding padding) {
        for (ScrolledListener onScrollChanged : f53632b) {
            onScrollChanged.onScrollChanged(padding);
        }
    }

    public static void addRvScrollListener(RvScrollingListener rvScrollingListener) {
        f53633c.add(rvScrollingListener);
    }

    public static void removeRvScrollListener(RvScrollingListener rvScrollingListener) {
        f53633c.remove(rvScrollingListener);
    }

    public static void onRvScroll(int i) {
        for (RvScrollingListener onScroll : f53633c) {
            onScroll.onScroll(i);
        }
    }

    public static void clear() {
        f53631a.clear();
        f53632b.clear();
        f53633c.clear();
    }
}
