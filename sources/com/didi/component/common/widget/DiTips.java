package com.didi.component.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class DiTips extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f13828a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f13829b;

    /* renamed from: c */
    private View f13830c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Point f13831d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float[] f13832e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f13833f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f13834g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f13835h;

    /* renamed from: i */
    private int f13836i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f13837j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f13838k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f13839l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f13840m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f13841n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f13842o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Animator f13843p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Animator f13844q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewTreeObserver.OnGlobalLayoutListener f13845r;

    private DiTips(Context context) {
        super(context);
        this.f13831d = new Point();
        this.f13832e = new float[2];
        this.f13837j = false;
        this.f13838k = false;
        this.f13839l = false;
        this.f13845r = new ViewTreeObserver.OnGlobalLayoutListener() {
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
                    if (DiTips.this.f13829b != null) {
                        if (DiTips.this.f13829b.getMeasuredWidth() == 0 || DiTips.this.f13829b.getMeasuredHeight() == 0) {
                            DiTips.this.f13829b.post(new Runnable() {
                                public void run() {
                                    C54221.this.onGlobalLayout();
                                }
                            });
                        }
                        if (!DiTips.this.f13838k) {
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f13845r);
                        }
                        if (DiTips.this.f13841n) {
                            int[] iArr = new int[2];
                            DiTips.this.f13829b.getLocationOnScreen(iArr);
                            if (DiTips.this.f13837j) {
                                iArr[1] = iArr[1] - DiTips.this.getStatusBarHeight();
                            }
                            int i8 = iArr[0];
                            int i9 = iArr[1];
                            int measuredWidth = DiTips.this.getMeasuredWidth() / 2;
                            int measuredHeight = DiTips.this.getMeasuredHeight() / 2;
                            if (DiTips.this.f13840m) {
                                measuredWidth = 0;
                            }
                            int h = DiTips.this.f13833f;
                            if (h != 1) {
                                if (h != 2) {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f13829b.getMeasuredWidth() / 2;
                                } else {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f13829b.getMeasuredWidth();
                                }
                                i = i7 + i6;
                            } else {
                                i = i8 - measuredWidth;
                            }
                            int i10 = DiTips.this.f13834g;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    i5 = DiTips.this.getMeasuredHeight();
                                } else {
                                    i5 = DiTips.this.getMeasuredHeight();
                                }
                                i2 = i9 - i5;
                            } else {
                                i2 = i9 + DiTips.this.f13829b.getMeasuredHeight();
                            }
                            if (DiTips.this.f13832e[0] == 0.0f) {
                                i3 = i + DiTips.this.f13831d.x;
                            } else {
                                if (DiTips.this.f13840m) {
                                    f2 = (float) i;
                                    f = DiTips.this.f13832e[0];
                                    measuredWidth = DiTips.this.getMeasuredWidth();
                                } else {
                                    f2 = (float) i;
                                    f = DiTips.this.f13832e[0];
                                }
                                i3 = (int) (f2 + (f * ((float) measuredWidth)));
                            }
                            if (DiTips.this.f13832e[1] == 0.0f) {
                                i4 = i2 + DiTips.this.f13831d.y;
                            } else {
                                i4 = (int) (((float) i2) + (DiTips.this.f13832e[1] * ((float) DiTips.this.getMeasuredHeight())));
                            }
                            if (DiTips.this.f13839l) {
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
                            DiTips.this.setTranslationX((float) i3);
                            DiTips.this.setTranslationY((float) i4);
                            DiTips.this.setVisibility(0);
                            if (DiTips.this.f13844q != null) {
                                DiTips.this.f13844q.start();
                                Animator unused = DiTips.this.f13844q = null;
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
    public void m11465a() {
        LayoutInflater.from(getContext()).inflate(this.f13835h, this, true);
        if (this.f13836i != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f13836i, this, false);
            this.f13830c = inflate;
            inflate.setVisibility(4);
            addView(this.f13830c, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private int m11459a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static class Builder {
        private DiTips mDiTips;

        public Builder(Context context, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            int unused = diTips.f13835h = i;
        }

        public Builder(Context context, ViewGroup viewGroup, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            ViewGroup unused = diTips.f13828a = viewGroup;
            int unused2 = this.mDiTips.f13835h = i;
        }

        public Builder setAnchor(View view) {
            View unused = this.mDiTips.f13829b = view;
            return this;
        }

        public Builder setBelowAnchor(boolean z) {
            int unused = this.mDiTips.f13834g = z ? 1 : 0;
            return this;
        }

        public Builder setAboveAnchor(boolean z) {
            int unused = this.mDiTips.f13834g = z ? 2 : 0;
            return this;
        }

        public Builder setLeftAnchor(boolean z) {
            int unused = this.mDiTips.f13833f = z ? 1 : 0;
            return this;
        }

        public Builder setRightAnchor(boolean z) {
            int unused = this.mDiTips.f13833f = z ? 2 : 0;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mDiTips.f13831d.x = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mDiTips.f13831d.y = i;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            boolean unused = this.mDiTips.f13837j = z;
            return this;
        }

        public Builder setOffsetXPercent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f13832e[0] = f;
            return this;
        }

        public Builder setOffsetYPersent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f13832e[1] = f;
            return this;
        }

        public Builder setFollowingLayout(boolean z) {
            boolean unused = this.mDiTips.f13838k = z;
            return this;
        }

        public Builder setKeepInScreenRange(boolean z) {
            boolean unused = this.mDiTips.f13839l = z;
            return this;
        }

        public Builder setUseOriginalDrawPoint(boolean z) {
            boolean unused = this.mDiTips.f13840m = z;
            return this;
        }

        public DiTips build() {
            this.mDiTips.m11465a();
            return this.mDiTips;
        }
    }

    public boolean isShow() {
        return this.f13841n;
    }

    public void show(final Animator animator) {
        if (!this.f13841n) {
            this.f13842o = false;
            final Activity activity = (Activity) getContext();
            if (!activity.isFinishing()) {
                setVisibility(4);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!DiTips.this.f13842o) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            if (DiTips.this.f13828a != null) {
                                DiTips.this.f13828a.addView(DiTips.this, layoutParams);
                            } else {
                                activity.addContentView(DiTips.this, layoutParams);
                            }
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f13845r);
                            DiTips.this.getViewTreeObserver().addOnGlobalLayoutListener(DiTips.this.f13845r);
                            DiTips.this.requestLayout();
                            if (DiTips.this.f13843p != null) {
                                DiTips.this.f13843p.cancel();
                                Animator unused = DiTips.this.f13843p = null;
                            }
                            if (DiTips.this.f13844q != null) {
                                DiTips.this.f13844q.cancel();
                                Animator unused2 = DiTips.this.f13844q = null;
                            }
                            Animator animator = animator;
                            if (animator != null) {
                                Animator unused3 = DiTips.this.f13844q = animator;
                            }
                            boolean unused4 = DiTips.this.f13841n = true;
                        }
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
        if (this.f13841n) {
            this.f13842o = true;
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f13845r);
            if (animator != null) {
                Animator animator2 = this.f13843p;
                if (animator2 != null) {
                    animator2.cancel();
                    this.f13843p = null;
                }
                Animator animator3 = this.f13844q;
                if (animator3 != null) {
                    animator3.cancel();
                    this.f13844q = null;
                }
                this.f13843p = animator;
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(DiTips.this);
                                }
                                boolean unused = DiTips.this.f13841n = false;
                            }
                        });
                    }
                });
                animator.start();
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (DiTips.this.f13843p != null) {
                        DiTips.this.f13843p.cancel();
                        Animator unused = DiTips.this.f13843p = null;
                    }
                    if (DiTips.this.f13844q != null) {
                        DiTips.this.f13844q.cancel();
                        Animator unused2 = DiTips.this.f13844q = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(DiTips.this);
                    }
                    boolean unused3 = DiTips.this.f13841n = false;
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
