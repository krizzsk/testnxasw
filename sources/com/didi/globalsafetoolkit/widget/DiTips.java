package com.didi.globalsafetoolkit.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class DiTips extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f25195a;

    /* renamed from: b */
    private View f25196b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f25197c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float[] f25198d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f25199e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f25200f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f25201g;

    /* renamed from: h */
    private int f25202h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f25203i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f25204j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f25205k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f25206l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f25207m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator f25208n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Animator f25209o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f25210p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public FrameLayout f25211q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewTreeObserver.OnGlobalLayoutListener f25212r;

    private DiTips(Context context) {
        super(context);
        this.f25197c = new Point();
        this.f25198d = new float[2];
        this.f25203i = false;
        this.f25204j = false;
        this.f25205k = false;
        this.f25212r = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int i;
                int i2;
                int i3;
                int i4;
                float f;
                float f2;
                int i5;
                int i6;
                int i7;
                try {
                    if (DiTips.this.f25195a != null) {
                        if (DiTips.this.f25195a.getMeasuredWidth() == 0 || DiTips.this.f25195a.getMeasuredHeight() == 0) {
                            DiTips.this.f25195a.post(new Runnable() {
                                public void run() {
                                    C95751.this.onGlobalLayout();
                                }
                            });
                        }
                        if (!DiTips.this.f25204j) {
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f25212r);
                        }
                        if (DiTips.this.f25207m) {
                            int[] iArr = new int[2];
                            DiTips.this.f25195a.getLocationOnScreen(iArr);
                            if (DiTips.this.f25203i) {
                                iArr[1] = iArr[1] - DiTips.this.getStatusBarHeight();
                            }
                            int i8 = iArr[0];
                            int i9 = iArr[1];
                            int measuredWidth = DiTips.this.getMeasuredWidth() / 2;
                            int measuredHeight = DiTips.this.getMeasuredHeight() / 2;
                            if (DiTips.this.f25206l) {
                                measuredWidth = 0;
                            }
                            int h = DiTips.this.f25199e;
                            if (h != 1) {
                                if (h != 2) {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f25195a.getMeasuredWidth() / 2;
                                } else {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f25195a.getMeasuredWidth();
                                }
                                i = i7 + i6;
                            } else {
                                i = i8 - measuredWidth;
                            }
                            int i10 = DiTips.this.f25200f;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    i5 = DiTips.this.getMeasuredHeight();
                                } else {
                                    i5 = DiTips.this.getMeasuredHeight();
                                }
                                i2 = i9 - i5;
                            } else {
                                i2 = i9 + DiTips.this.f25195a.getMeasuredHeight();
                            }
                            if (DiTips.this.f25198d[0] == 0.0f) {
                                i3 = i + DiTips.this.f25197c.x;
                            } else {
                                if (DiTips.this.f25206l) {
                                    f2 = (float) i;
                                    f = DiTips.this.f25198d[0];
                                    measuredWidth = DiTips.this.getMeasuredWidth();
                                } else {
                                    f2 = (float) i;
                                    f = DiTips.this.f25198d[0];
                                }
                                i3 = (int) (f2 + (f * ((float) measuredWidth)));
                            }
                            if (DiTips.this.f25198d[1] == 0.0f) {
                                i4 = i2 + DiTips.this.f25197c.y;
                            } else {
                                i4 = (int) (((float) i2) + (DiTips.this.f25198d[1] * ((float) DiTips.this.getMeasuredHeight())));
                            }
                            if (DiTips.this.f25205k) {
                                int i11 = DiTips.this.getResources().getDisplayMetrics().widthPixels;
                                int i12 = DiTips.this.getResources().getDisplayMetrics().heightPixels;
                                if (i3 < 0) {
                                    i3 = 0;
                                }
                                if (i4 < 0) {
                                    i4 = 0;
                                }
                                if (i3 > i11) {
                                    i3 = i11;
                                }
                                if (i4 > i12) {
                                    i4 = i12;
                                }
                            }
                            if (DRtlToolkit.rtl()) {
                                DiTips.this.setTranslationX((float) ((i3 - DiTips.this.getResources().getDisplayMetrics().widthPixels) + DiTips.this.getWidth()));
                            } else {
                                DiTips.this.setTranslationX((float) i3);
                            }
                            DiTips.this.setTranslationY((float) i4);
                            DiTips.this.setVisibility(0);
                            if (DiTips.this.f25209o != null) {
                                DiTips.this.f25209o.start();
                                Animator unused = DiTips.this.f25209o = null;
                            }
                            if (DiTips.this.f25210p) {
                                DiTips.this.f25211q.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View view, MotionEvent motionEvent) {
                                        if (motionEvent.getAction() != 0 || !DiTips.this.f25210p || !DiTips.this.isShow()) {
                                            return false;
                                        }
                                        DiTips.this.dismiss();
                                        return false;
                                    }
                                });
                            } else {
                                DiTips.this.f25211q.setOnTouchListener((View.OnTouchListener) null);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20171a() {
        LayoutInflater.from(getContext()).inflate(this.f25201g, this, true);
        if (this.f25202h != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f25202h, this, false);
            this.f25196b = inflate;
            inflate.setVisibility(4);
            addView(this.f25196b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private int m20165a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static class Builder {
        private DiTips mDiTips;

        public Builder(Context context, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            int unused = diTips.f25201g = i;
        }

        public Builder setAnchor(View view) {
            View unused = this.mDiTips.f25195a = view;
            return this;
        }

        public Builder setBelowAnchor(boolean z) {
            int unused = this.mDiTips.f25200f = z ? 1 : 0;
            return this;
        }

        public Builder setAboveAnchor(boolean z) {
            int unused = this.mDiTips.f25200f = z ? 2 : 0;
            return this;
        }

        public Builder setLeftAnchor(boolean z) {
            int unused = this.mDiTips.f25199e = z ? 1 : 0;
            return this;
        }

        public Builder setRightAnchor(boolean z) {
            int unused = this.mDiTips.f25199e = z ? 2 : 0;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mDiTips.f25197c.x = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mDiTips.f25197c.y = i;
            return this;
        }

        public Builder setDismissInTouchOut(boolean z) {
            boolean unused = this.mDiTips.f25210p = z;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            boolean unused = this.mDiTips.f25203i = z;
            return this;
        }

        public Builder setOffsetXPercent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f25198d[0] = f;
            return this;
        }

        public Builder setOffsetYPersent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f25198d[1] = f;
            return this;
        }

        public Builder setFollowingLayout(boolean z) {
            boolean unused = this.mDiTips.f25204j = z;
            return this;
        }

        public Builder setKeepInScreenRange(boolean z) {
            boolean unused = this.mDiTips.f25205k = z;
            return this;
        }

        public Builder setUseOriginalDrawPoint(boolean z) {
            boolean unused = this.mDiTips.f25206l = z;
            return this;
        }

        public DiTips build() {
            this.mDiTips.m20171a();
            return this.mDiTips;
        }
    }

    public boolean isShow() {
        return this.f25207m;
    }

    public void show(final Animator animator) {
        if (!this.f25207m) {
            final Activity activity = (Activity) getContext();
            if (!activity.isFinishing()) {
                setVisibility(4);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        FrameLayout unused = DiTips.this.f25211q = new FrameLayout(DiTips.this.getContext());
                        DiTips.this.f25211q.setBackgroundColor(0);
                        DiTips.this.f25211q.addView(DiTips.this, new FrameLayout.LayoutParams(-2, -2));
                        activity.addContentView(DiTips.this.f25211q, layoutParams);
                        DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f25212r);
                        DiTips.this.getViewTreeObserver().addOnGlobalLayoutListener(DiTips.this.f25212r);
                        DiTips.this.requestLayout();
                        if (DiTips.this.f25208n != null) {
                            DiTips.this.f25208n.cancel();
                            Animator unused2 = DiTips.this.f25208n = null;
                        }
                        if (DiTips.this.f25209o != null) {
                            DiTips.this.f25209o.cancel();
                            Animator unused3 = DiTips.this.f25209o = null;
                        }
                        Animator animator = animator;
                        if (animator != null) {
                            Animator unused4 = DiTips.this.f25209o = animator;
                        }
                        boolean unused5 = DiTips.this.f25207m = true;
                    }
                });
            }
        }
    }

    public void show() {
        show((Animator) null);
    }

    public void dismiss() {
        dismiss((Animator) null);
    }

    public void dismiss(Animator animator) {
        if (this.f25207m) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f25212r);
            if (animator != null) {
                Animator animator2 = this.f25208n;
                if (animator2 != null) {
                    animator2.cancel();
                    this.f25208n = null;
                }
                Animator animator3 = this.f25209o;
                if (animator3 != null) {
                    animator3.cancel();
                    this.f25209o = null;
                }
                this.f25208n = animator;
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(DiTips.this);
                                }
                                boolean unused = DiTips.this.f25207m = false;
                            }
                        });
                    }
                });
                animator.start();
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (DiTips.this.f25208n != null) {
                        DiTips.this.f25208n.cancel();
                        Animator unused = DiTips.this.f25208n = null;
                    }
                    if (DiTips.this.f25209o != null) {
                        DiTips.this.f25209o.cancel();
                        Animator unused2 = DiTips.this.f25209o = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(DiTips.this);
                    }
                    boolean unused3 = DiTips.this.f25207m = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
