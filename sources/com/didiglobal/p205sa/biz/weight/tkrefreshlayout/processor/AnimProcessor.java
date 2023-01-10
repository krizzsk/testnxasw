package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.LogUtil;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil;
import java.io.PrintStream;
import java.util.LinkedList;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.AnimProcessor */
public class AnimProcessor implements IAnimOverScroll, IAnimRefresh {

    /* renamed from: b */
    private static final float f53860b = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TwinklingRefreshLayout.CoContext f53861a;

    /* renamed from: c */
    private DecelerateInterpolator f53862c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f53863d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f53864e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f53865f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f53866g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f53867h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f53868i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f53869j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f53870k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f53871l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f53872m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f53873n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f53874o = false;

    /* renamed from: p */
    private ValueAnimator.AnimatorUpdateListener f53875p = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!AnimProcessor.this.f53863d || !AnimProcessor.this.f53861a.isEnableKeepIView()) {
                AnimProcessor.this.f53861a.getHeader().getLayoutParams().height = intValue;
                AnimProcessor.this.f53861a.getHeader().requestLayout();
                AnimProcessor.this.f53861a.getHeader().setTranslationY(AnimProcessor.this.m40163a());
                AnimProcessor.this.f53861a.onPullDownReleasing((float) intValue);
            } else {
                AnimProcessor.this.m40165a((float) intValue);
            }
            if (!AnimProcessor.this.f53861a.isOpenFloatRefresh()) {
                AnimProcessor.this.f53861a.getTargetView().setTranslationY((float) intValue);
                AnimProcessor.this.m40166a(intValue);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ValueAnimator.AnimatorUpdateListener f53876q = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!AnimProcessor.this.f53864e || !AnimProcessor.this.f53861a.isEnableKeepIView()) {
                AnimProcessor.this.f53861a.getFooter().getLayoutParams().height = intValue;
                AnimProcessor.this.f53861a.getFooter().requestLayout();
                AnimProcessor.this.f53861a.getFooter().setTranslationY(0.0f);
                AnimProcessor.this.f53861a.onPullUpReleasing((float) intValue);
            } else {
                AnimProcessor.this.m40172b((float) intValue);
            }
            AnimProcessor.this.f53861a.getTargetView().setTranslationY((float) (-intValue));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ValueAnimator.AnimatorUpdateListener f53877r = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (AnimProcessor.this.f53861a.isOverScrollTopShow()) {
                if (AnimProcessor.this.f53861a.getHeader().getVisibility() != 0) {
                    AnimProcessor.this.f53861a.getHeader().setVisibility(0);
                }
            } else if (AnimProcessor.this.f53861a.getHeader().getVisibility() != 8) {
                AnimProcessor.this.f53861a.getHeader().setVisibility(8);
            }
            if (!AnimProcessor.this.f53863d || !AnimProcessor.this.f53861a.isEnableKeepIView()) {
                AnimProcessor.this.f53861a.getHeader().setTranslationY(AnimProcessor.this.m40163a());
                AnimProcessor.this.f53861a.getHeader().getLayoutParams().height = intValue;
                AnimProcessor.this.f53861a.getHeader().requestLayout();
                AnimProcessor.this.f53861a.onPullDownReleasing((float) intValue);
            } else {
                AnimProcessor.this.m40165a((float) intValue);
            }
            AnimProcessor.this.f53861a.getTargetView().setTranslationY((float) intValue);
            AnimProcessor.this.m40166a(intValue);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ValueAnimator.AnimatorUpdateListener f53878s = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (AnimProcessor.this.f53861a.isOverScrollBottomShow()) {
                if (AnimProcessor.this.f53861a.getFooter().getVisibility() != 0) {
                    AnimProcessor.this.f53861a.getFooter().setVisibility(0);
                }
            } else if (AnimProcessor.this.f53861a.getFooter().getVisibility() != 8) {
                AnimProcessor.this.f53861a.getFooter().setVisibility(8);
            }
            if (!AnimProcessor.this.f53864e || !AnimProcessor.this.f53861a.isEnableKeepIView()) {
                AnimProcessor.this.f53861a.getFooter().getLayoutParams().height = intValue;
                AnimProcessor.this.f53861a.getFooter().requestLayout();
                AnimProcessor.this.f53861a.getFooter().setTranslationY(0.0f);
                AnimProcessor.this.f53861a.onPullUpReleasing((float) intValue);
            } else {
                AnimProcessor.this.m40172b((float) intValue);
            }
            AnimProcessor.this.f53861a.getTargetView().setTranslationY((float) (-intValue));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LinkedList<Animator> f53879t;

    public AnimProcessor(TwinklingRefreshLayout.CoContext coContext) {
        this.f53861a = coContext;
        this.f53862c = new DecelerateInterpolator(8.0f);
    }

    public void scrollHeadByMove(float f) {
        float interpolation = (this.f53862c.getInterpolation((f / this.f53861a.getMaxHeadHeight()) / 2.0f) * f) / 2.0f;
        if (this.f53861a.isPureScrollModeOn() || (!this.f53861a.enableRefresh() && !this.f53861a.isOverScrollTopShow())) {
            if (this.f53861a.getHeader().getVisibility() != 8) {
                this.f53861a.getHeader().setVisibility(8);
            }
        } else if (this.f53861a.getHeader().getVisibility() != 0) {
            this.f53861a.getHeader().setVisibility(0);
        }
        if (!this.f53863d || !this.f53861a.isEnableKeepIView()) {
            this.f53861a.getHeader().setTranslationY(m40163a());
            this.f53861a.getHeader().getLayoutParams().height = (int) Math.abs(interpolation);
            this.f53861a.getHeader().bringToFront();
            this.f53861a.getHeader().requestLayout();
            this.f53861a.onPullingDown(interpolation);
        } else {
            this.f53861a.getHeader().setTranslationY(interpolation - ((float) this.f53861a.getHeader().getLayoutParams().height));
        }
        if (!this.f53861a.isOpenFloatRefresh()) {
            this.f53861a.getTargetView().setTranslationY(interpolation);
            m40166a((int) interpolation);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m40163a() {
        return UIUtils.dip2px(this.f53861a.getHeader().getContext(), 72.0f) + ((float) AppUtils.getStatusBarHeight(this.f53861a.getHeader().getContext()));
    }

    public void scrollBottomByMove(float f) {
        float interpolation = (this.f53862c.getInterpolation((f / ((float) this.f53861a.getMaxBottomHeight())) / 2.0f) * f) / 2.0f;
        if (this.f53861a.isPureScrollModeOn() || (!this.f53861a.enableLoadmore() && !this.f53861a.isOverScrollBottomShow())) {
            if (this.f53861a.getFooter().getVisibility() != 8) {
                this.f53861a.getFooter().setVisibility(8);
            }
        } else if (this.f53861a.getFooter().getVisibility() != 0) {
            this.f53861a.getFooter().setVisibility(0);
        }
        if (!this.f53864e || !this.f53861a.isEnableKeepIView()) {
            this.f53861a.getFooter().setTranslationY(0.0f);
            this.f53861a.getFooter().getLayoutParams().height = (int) Math.abs(interpolation);
            this.f53861a.getFooter().requestLayout();
            this.f53861a.onPullingUp(-interpolation);
        } else {
            this.f53861a.getFooter().setTranslationY(((float) this.f53861a.getFooter().getLayoutParams().height) - interpolation);
        }
        this.f53861a.getTargetView().setTranslationY(-interpolation);
    }

    public void dealPullDownRelease() {
        if (this.f53861a.isPureScrollModeOn() || !this.f53861a.enableRefresh() || m40171b() < this.f53861a.getHeadHeight() - this.f53861a.getTouchSlop()) {
            animHeadBack(false);
        } else {
            animHeadToRefresh();
        }
    }

    public void dealPullUpRelease() {
        if (this.f53861a.isPureScrollModeOn() || !this.f53861a.enableLoadmore() || m40177c() < this.f53861a.getBottomHeight() - this.f53861a.getTouchSlop()) {
            animBottomBack(false);
        } else {
            animBottomToLoad();
        }
    }

    /* renamed from: b */
    private int m40171b() {
        LogUtil.m40202i("header translationY:" + this.f53861a.getHeader().getTranslationY() + ",Visible head height:" + (((float) this.f53861a.getHeader().getLayoutParams().height) + this.f53861a.getHeader().getTranslationY()));
        return this.f53861a.getHeader().getLayoutParams().height;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m40177c() {
        LogUtil.m40202i("footer translationY:" + this.f53861a.getFooter().getTranslationY() + "");
        return (int) (((float) this.f53861a.getFooter().getLayoutParams().height) - this.f53861a.getFooter().getTranslationY());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40165a(float f) {
        this.f53861a.getHeader().setTranslationY((m40163a() + f) - ((float) this.f53861a.getHeader().getLayoutParams().height));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40172b(float f) {
        this.f53861a.getFooter().setTranslationY(((float) this.f53861a.getFooter().getLayoutParams().height) - f);
    }

    public void animHeadToRefresh() {
        LogUtil.m40202i("animHeadToRefresh:");
        this.f53865f = true;
        animLayoutByTime(m40171b(), this.f53861a.getHeadHeight(), this.f53875p, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f53865f = false;
                if (AnimProcessor.this.f53861a.getHeader().getVisibility() != 0) {
                    AnimProcessor.this.f53861a.getHeader().setVisibility(0);
                }
                AnimProcessor.this.f53861a.setRefreshVisible(true);
                if (!AnimProcessor.this.f53861a.isEnableKeepIView()) {
                    AnimProcessor.this.f53861a.setRefreshing(true);
                    AnimProcessor.this.f53861a.onRefresh();
                } else if (!AnimProcessor.this.f53863d) {
                    AnimProcessor.this.f53861a.setRefreshing(true);
                    AnimProcessor.this.f53861a.onRefresh();
                    boolean unused2 = AnimProcessor.this.f53863d = true;
                }
            }
        });
    }

    public void animHeadBack(final boolean z) {
        LogUtil.m40202i("animHeadBack：finishRefresh?->" + z);
        this.f53866g = true;
        if (z && this.f53863d && this.f53861a.isEnableKeepIView()) {
            this.f53861a.setPrepareFinishRefresh(true);
        }
        animLayoutByTime(m40171b(), 0, this.f53875p, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f53866g = false;
                AnimProcessor.this.f53861a.setRefreshVisible(false);
                if (z && AnimProcessor.this.f53863d && AnimProcessor.this.f53861a.isEnableKeepIView()) {
                    AnimProcessor.this.f53861a.getHeader().getLayoutParams().height = 0;
                    AnimProcessor.this.f53861a.getHeader().requestLayout();
                    AnimProcessor.this.f53861a.getHeader().setTranslationY(AnimProcessor.this.m40163a());
                    boolean unused2 = AnimProcessor.this.f53863d = false;
                    AnimProcessor.this.f53861a.setRefreshing(false);
                    AnimProcessor.this.f53861a.resetHeaderView();
                }
            }
        });
    }

    public void animBottomToLoad() {
        LogUtil.m40202i("animBottomToLoad");
        this.f53867h = true;
        animLayoutByTime(m40177c(), this.f53861a.getBottomHeight(), this.f53876q, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f53867h = false;
                if (AnimProcessor.this.f53861a.getFooter().getVisibility() != 0) {
                    AnimProcessor.this.f53861a.getFooter().setVisibility(0);
                }
                AnimProcessor.this.f53861a.setLoadVisible(true);
                if (!AnimProcessor.this.f53861a.isEnableKeepIView()) {
                    AnimProcessor.this.f53861a.setLoadingMore(true);
                    AnimProcessor.this.f53861a.onLoadMore();
                } else if (!AnimProcessor.this.f53864e) {
                    AnimProcessor.this.f53861a.setLoadingMore(true);
                    AnimProcessor.this.f53861a.onLoadMore();
                    boolean unused2 = AnimProcessor.this.f53864e = true;
                }
            }
        });
    }

    public void animBottomBack(final boolean z) {
        LogUtil.m40202i("animBottomBack：finishLoading?->" + z);
        this.f53868i = true;
        if (z && this.f53864e && this.f53861a.isEnableKeepIView()) {
            this.f53861a.setPrepareFinishLoadMore(true);
        }
        animLayoutByTime(m40177c(), 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int e;
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (!ScrollingUtil.isViewToBottom(AnimProcessor.this.f53861a.getTargetView(), AnimProcessor.this.f53861a.getTouchSlop()) && (e = AnimProcessor.this.m40177c() - intValue) > 0) {
                    if (AnimProcessor.this.f53861a.getTargetView() instanceof RecyclerView) {
                        ScrollingUtil.scrollAViewBy(AnimProcessor.this.f53861a.getTargetView(), e);
                    } else {
                        ScrollingUtil.scrollAViewBy(AnimProcessor.this.f53861a.getTargetView(), e / 2);
                    }
                }
                AnimProcessor.this.f53876q.onAnimationUpdate(valueAnimator);
            }
        }, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f53868i = false;
                AnimProcessor.this.f53861a.setLoadVisible(false);
                if (z && AnimProcessor.this.f53864e && AnimProcessor.this.f53861a.isEnableKeepIView()) {
                    AnimProcessor.this.f53861a.getFooter().getLayoutParams().height = 0;
                    AnimProcessor.this.f53861a.getFooter().requestLayout();
                    AnimProcessor.this.f53861a.getFooter().setTranslationY(0.0f);
                    boolean unused2 = AnimProcessor.this.f53864e = false;
                    AnimProcessor.this.f53861a.resetBottomView();
                    AnimProcessor.this.f53861a.setLoadingMore(false);
                }
            }
        });
    }

    public void animHeadHideByVy(int i) {
        if (!this.f53869j) {
            this.f53869j = true;
            LogUtil.m40202i("animHeadHideByVy：vy->" + i);
            int abs = Math.abs(i);
            if (abs < 5000) {
                abs = 8000;
            }
            animLayoutByTime(m40171b(), 0, (long) (Math.abs((m40171b() * 1000) / abs) * 5), this.f53875p, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    boolean unused = AnimProcessor.this.f53869j = false;
                    AnimProcessor.this.f53861a.setRefreshVisible(false);
                    if (!AnimProcessor.this.f53861a.isEnableKeepIView()) {
                        AnimProcessor.this.f53861a.setRefreshing(false);
                        AnimProcessor.this.f53861a.onRefreshCanceled();
                        AnimProcessor.this.f53861a.resetHeaderView();
                    }
                }
            });
        }
    }

    public void animBottomHideByVy(int i) {
        LogUtil.m40202i("animBottomHideByVy：vy->" + i);
        if (!this.f53870k) {
            this.f53870k = true;
            int abs = Math.abs(i);
            if (abs < 5000) {
                abs = 8000;
            }
            animLayoutByTime(m40177c(), 0, (long) (((m40177c() * 5) * 1000) / abs), this.f53876q, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    boolean unused = AnimProcessor.this.f53870k = false;
                    AnimProcessor.this.f53861a.setLoadVisible(false);
                    if (!AnimProcessor.this.f53861a.isEnableKeepIView()) {
                        AnimProcessor.this.f53861a.setLoadingMore(false);
                        AnimProcessor.this.f53861a.onLoadmoreCanceled();
                        AnimProcessor.this.f53861a.resetBottomView();
                    }
                }
            });
        }
    }

    public void animOverScrollTop(float f, int i) {
        LogUtil.m40202i("animOverScrollTop：vy->" + f + ",computeTimes->" + i);
        if (!this.f53872m) {
            this.f53872m = true;
            this.f53871l = true;
            this.f53861a.setStatePTD();
            int abs = (int) Math.abs((f / ((float) i)) / 2.0f);
            if (abs > this.f53861a.getOsHeight()) {
                abs = this.f53861a.getOsHeight();
            }
            final int i2 = abs;
            final int i3 = i2 <= 50 ? 115 : (int) ((((double) i2) * 0.3d) + 100.0d);
            animLayoutByTime(m40171b(), i2, (long) i3, this.f53877r, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (!AnimProcessor.this.f53863d || !AnimProcessor.this.f53861a.isEnableKeepIView() || !AnimProcessor.this.f53861a.showRefreshingWhenOverScroll()) {
                        AnimProcessor animProcessor = AnimProcessor.this;
                        animProcessor.animLayoutByTime(i2, 0, (long) (i3 * 2), animProcessor.f53877r, new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                boolean unused = AnimProcessor.this.f53871l = false;
                                boolean unused2 = AnimProcessor.this.f53872m = false;
                            }
                        });
                        return;
                    }
                    AnimProcessor.this.animHeadToRefresh();
                    boolean unused = AnimProcessor.this.f53871l = false;
                    boolean unused2 = AnimProcessor.this.f53872m = false;
                }
            });
        }
    }

    public void animOverScrollBottom(float f, int i) {
        LogUtil.m40202i("animOverScrollBottom：vy->" + f + ",computeTimes->" + i);
        if (!this.f53874o) {
            this.f53861a.setStatePBU();
            int abs = (int) Math.abs((f / ((float) i)) / 2.0f);
            if (abs > this.f53861a.getOsHeight()) {
                abs = this.f53861a.getOsHeight();
            }
            final int i2 = abs;
            final int i3 = i2 <= 50 ? 115 : (int) ((((double) i2) * 0.3d) + 100.0d);
            if (this.f53864e || !this.f53861a.autoLoadMore()) {
                this.f53874o = true;
                this.f53873n = true;
                animLayoutByTime(0, i2, (long) i3, this.f53878s, new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (!AnimProcessor.this.f53864e || !AnimProcessor.this.f53861a.isEnableKeepIView() || !AnimProcessor.this.f53861a.showLoadingWhenOverScroll()) {
                            AnimProcessor animProcessor = AnimProcessor.this;
                            animProcessor.animLayoutByTime(i2, 0, (long) (i3 * 2), animProcessor.f53878s, new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    boolean unused = AnimProcessor.this.f53873n = false;
                                    boolean unused2 = AnimProcessor.this.f53874o = false;
                                }
                            });
                            return;
                        }
                        AnimProcessor.this.animBottomToLoad();
                        boolean unused = AnimProcessor.this.f53873n = false;
                        boolean unused2 = AnimProcessor.this.f53874o = false;
                    }
                });
                return;
            }
            this.f53861a.startLoadMore();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40166a(int i) {
        if (!this.f53861a.isExHeadLocked()) {
            this.f53861a.getExHead().setTranslationY((float) i);
        }
    }

    public void animLayoutByTime(int i, int i2, long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.addListener(animatorListener);
        ofInt.setDuration(j);
        ofInt.start();
    }

    public void animLayoutByTime(int i, int i2, long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.setDuration(j);
        ofInt.start();
    }

    public void animLayoutByTime(int i, int i2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.addListener(animatorListener);
        ofInt.setDuration((long) ((int) (((float) Math.abs(i - i2)) * 1.0f)));
        ofInt.start();
    }

    /* renamed from: a */
    private void m40167a(Animator animator) {
        if (animator != null) {
            if (this.f53879t == null) {
                this.f53879t = new LinkedList<>();
            }
            this.f53879t.offer(animator);
            PrintStream printStream = System.out;
            printStream.println("Current Animators：" + this.f53879t.size());
            animator.addListener(new AnimatorListenerAdapter() {
                long startTime = 0;

                public void onAnimationStart(Animator animator) {
                    this.startTime = System.currentTimeMillis();
                }

                public void onAnimationEnd(Animator animator) {
                    AnimProcessor.this.f53879t.poll();
                    if (AnimProcessor.this.f53879t.size() > 0) {
                        ((Animator) AnimProcessor.this.f53879t.getFirst()).start();
                    }
                    PrintStream printStream = System.out;
                    printStream.println("Anim end：start time->" + this.startTime + ",elapsed time->" + (System.currentTimeMillis() - this.startTime));
                }
            });
            if (this.f53879t.size() == 1) {
                animator.start();
            }
        }
    }
}
