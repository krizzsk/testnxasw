package com.didi.beatles.p101im.access.notify.decorfloat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p101im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p101im.access.notify.decorfloat.wrapper.IMFloatMessageWrapper;
import com.didi.beatles.p101im.common.util.IMUtils;
import com.didi.beatles.p101im.manager.IMActivityController;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMWindowUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController */
public class IMDecorFloatController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10648a = IMDecorFloatController.class.getSimpleName();

    /* renamed from: b */
    private static final int f10649b = 1000;

    /* renamed from: c */
    private DecorFloatViewGroup f10650c;

    /* renamed from: d */
    private Queue<IIMDecorFloatMsg<?>> f10651d;

    /* renamed from: e */
    private Runnable f10652e;

    /* renamed from: f */
    private Runnable f10653f;

    private IMDecorFloatController() {
        this.f10651d = new LinkedList();
        this.f10652e = new Runnable() {
            public void run() {
                IMDecorFloatController.this.m9270a(true, 0);
            }
        };
        this.f10653f = new Runnable() {
            public void run() {
                IMDecorFloatController.this.m9272b();
            }
        };
    }

    public static IMDecorFloatController getInstance() {
        return Holder.INSTANCE;
    }

    public void add(IMMessage iMMessage) {
        if (iMMessage == null) {
            IMLog.m10021e(f10648a, "[add] null message");
            return;
        }
        add((IIMDecorFloatMsg<?>) new IMFloatMessageWrapper(iMMessage));
    }

    public void add(IIMDecorFloatMsg<?> iIMDecorFloatMsg) {
        IMLog.m10020d(f10648a, "[add] new decor float msg");
        if (iIMDecorFloatMsg != null) {
            this.f10651d.add(iIMDecorFloatMsg);
            if (this.f10650c == null) {
                Runnable runnable = this.f10653f;
                if (runnable != null) {
                    UiThreadHandler.removeCallbacks(runnable);
                }
                m9272b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9272b() {
        Queue<IIMDecorFloatMsg<?>> queue = this.f10651d;
        if (queue == null || queue.isEmpty()) {
            IMLog.m10020d(f10648a, "[showNext] #queue is empty#");
        } else if (!m9271a(this.f10651d.poll())) {
            IMLog.m10020d(f10648a, "[showNext] #poll#");
            m9272b();
        }
    }

    /* renamed from: a */
    private <T> boolean m9271a(IIMDecorFloatMsg<T> iIMDecorFloatMsg) {
        if (iIMDecorFloatMsg == null) {
            return false;
        }
        if (!IMUtils.isAppForeground()) {
            IMLog.m10021e(f10648a, "[show] ignore with app in background");
            iIMDecorFloatMsg.showNotification();
            return false;
        }
        Activity topActivity = IMActivityController.getInstance().getTopActivity();
        if (topActivity == null) {
            IMLog.m10021e(f10648a, "[show] ignore with top activity is null");
            iIMDecorFloatMsg.showNotification();
            return false;
        } else if (!iIMDecorFloatMsg.canShowFloat(topActivity)) {
            IMLog.m10021e(f10648a, "[show] ignore with can't show float");
            return false;
        } else {
            ViewGroup a = m9266a(topActivity);
            if (a == null) {
                IMLog.m10021e(f10648a, "[show] #IGNORE# with null parent view");
                iIMDecorFloatMsg.showNotification();
                return false;
            }
            View view = iIMDecorFloatMsg.getView(topActivity, new IIMDecorFloatMsg.RequestCallback() {
                public void requestDismiss(int i) {
                    IMDecorFloatController.this.m9270a(true, i);
                }

                public void requestCancelDismissTask() {
                    IMDecorFloatController.this.m9274c();
                }
            });
            if (view == null) {
                IMLog.m10021e(f10648a, "[show] #IGNORE# with null float view");
                return false;
            }
            Animator enterAnimator = iIMDecorFloatMsg.getEnterAnimator(view);
            DecorFloatViewGroup decorFloatViewGroup = new DecorFloatViewGroup(a, view, enterAnimator, iIMDecorFloatMsg.getExitAnimator(view));
            this.f10650c = decorFloatViewGroup;
            decorFloatViewGroup.showFloatView();
            UiThreadHandler.postDelayed(this.f10652e, iIMDecorFloatMsg.getDisplayDuration() + (enterAnimator != null ? enterAnimator.getDuration() : 0));
            return true;
        }
    }

    /* renamed from: a */
    private ViewGroup m9266a(Activity activity) {
        View decorView;
        if (activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return null;
        }
        View findViewById = decorView.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9270a(boolean z, int i) {
        IMLog.m10020d(f10648a, C4786I.m9980t("[dismiss] showNextFloat=", Boolean.valueOf(z)));
        DecorFloatViewGroup decorFloatViewGroup = this.f10650c;
        long j = 0;
        if (decorFloatViewGroup != null) {
            Animator exitAnimation = decorFloatViewGroup.getExitAnimation();
            if (exitAnimation != null) {
                j = exitAnimation.getDuration();
            }
            this.f10650c.dismissFloatView(i);
            this.f10650c = null;
        }
        if (z) {
            Runnable runnable = this.f10652e;
            if (runnable != null) {
                UiThreadHandler.removeCallbacks(runnable);
            }
            UiThreadHandler.postDelayed(this.f10653f, j + 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9274c() {
        Runnable runnable = this.f10652e;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
        }
    }

    public void destroy() {
        m9274c();
        m9270a(false, 0);
        Queue<IIMDecorFloatMsg<?>> queue = this.f10651d;
        if (queue != null) {
            queue.clear();
        }
    }

    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController$DecorFloatViewGroup */
    private static class DecorFloatViewGroup {
        private Animator enterAnimation;
        private Animator exitAnimation;
        private View mFloatView;
        private ViewGroup mParentView;

        public DecorFloatViewGroup(ViewGroup viewGroup, View view, Animator animator, Animator animator2) {
            this.mParentView = viewGroup;
            this.mFloatView = view;
            this.enterAnimation = animator;
            this.exitAnimation = animator2;
        }

        public Animator getEnterAnimation() {
            return this.enterAnimation;
        }

        public Animator getExitAnimation() {
            return this.exitAnimation;
        }

        public void showFloatView() {
            try {
                if (this.mParentView != null && this.mFloatView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    marginLayoutParams.topMargin = IMWindowUtil.getStatusBarHeight();
                    this.mParentView.addView(this.mFloatView, marginLayoutParams);
                    if (this.enterAnimation != null) {
                        this.enterAnimation.start();
                    }
                }
            } catch (Exception e) {
                IMLog.m10021e(IMDecorFloatController.f10648a, "[showFloatView]", e);
                IMTraceError.trackError("im_decor_float#showFloatView", e);
            }
        }

        /* access modifiers changed from: private */
        public void executeDismiss(int i) {
            try {
                if (this.mFloatView != null && (this.mFloatView instanceof IIMDecorFloatView)) {
                    ((IIMDecorFloatView) this.mFloatView).onFloatViewRemoved(i);
                }
                if (this.mParentView != null) {
                    this.mParentView.removeView(this.mFloatView);
                }
                this.mParentView = null;
                this.mFloatView = null;
            } catch (Exception e) {
                IMLog.m10021e(IMDecorFloatController.f10648a, "[executeDismiss]", e);
                IMTraceError.trackError("im_decor_float#executeDismiss", e);
            }
        }

        public void dismissFloatView(final int i) {
            if (this.mParentView != null && this.mFloatView != null) {
                Animator animator = this.exitAnimation;
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            DecorFloatViewGroup.this.executeDismiss(i);
                        }
                    });
                    this.exitAnimation.start();
                    return;
                }
                executeDismiss(i);
            }
        }
    }

    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMDecorFloatController INSTANCE = new IMDecorFloatController();

        private Holder() {
        }
    }
}
