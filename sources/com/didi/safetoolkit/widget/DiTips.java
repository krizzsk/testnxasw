package com.didi.safetoolkit.widget;

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
    public View f37307a;

    /* renamed from: b */
    private View f37308b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f37309c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float[] f37310d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f37311e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f37312f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f37313g;

    /* renamed from: h */
    private int f37314h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f37315i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f37316j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f37317k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f37318l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f37319m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator f37320n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Animator f37321o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f37322p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public FrameLayout f37323q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewTreeObserver.OnGlobalLayoutListener f37324r;

    private DiTips(Context context) {
        super(context);
        this.f37309c = new Point();
        this.f37310d = new float[2];
        this.f37315i = false;
        this.f37316j = false;
        this.f37317k = false;
        this.f37324r = new ViewTreeObserver.OnGlobalLayoutListener() {
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
                    if (DiTips.this.f37307a != null) {
                        if (DiTips.this.f37307a.getMeasuredWidth() == 0 || DiTips.this.f37307a.getMeasuredHeight() == 0) {
                            DiTips.this.f37307a.post(new Runnable() {
                                public void run() {
                                    C126081.this.onGlobalLayout();
                                }
                            });
                        }
                        if (!DiTips.this.f37316j) {
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f37324r);
                        }
                        if (DiTips.this.f37319m) {
                            int[] iArr = new int[2];
                            DiTips.this.f37307a.getLocationOnScreen(iArr);
                            if (DiTips.this.f37315i) {
                                iArr[1] = iArr[1] - DiTips.this.getStatusBarHeight();
                            }
                            int i8 = iArr[0];
                            int i9 = iArr[1];
                            int measuredWidth = DiTips.this.getMeasuredWidth() / 2;
                            int measuredHeight = DiTips.this.getMeasuredHeight() / 2;
                            if (DiTips.this.f37318l) {
                                measuredWidth = 0;
                            }
                            int h = DiTips.this.f37311e;
                            if (h != 1) {
                                if (h != 2) {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f37307a.getMeasuredWidth() / 2;
                                } else {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f37307a.getMeasuredWidth();
                                }
                                i = i7 + i6;
                            } else {
                                i = i8 - measuredWidth;
                            }
                            int i10 = DiTips.this.f37312f;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    i5 = DiTips.this.getMeasuredHeight();
                                } else {
                                    i5 = DiTips.this.getMeasuredHeight();
                                }
                                i2 = i9 - i5;
                            } else {
                                i2 = i9 + DiTips.this.f37307a.getMeasuredHeight();
                            }
                            if (DiTips.this.f37310d[0] == 0.0f) {
                                i3 = i + DiTips.this.f37309c.x;
                            } else {
                                if (DiTips.this.f37318l) {
                                    f2 = (float) i;
                                    f = DiTips.this.f37310d[0];
                                    measuredWidth = DiTips.this.getMeasuredWidth();
                                } else {
                                    f2 = (float) i;
                                    f = DiTips.this.f37310d[0];
                                }
                                i3 = (int) (f2 + (f * ((float) measuredWidth)));
                            }
                            if (DiTips.this.f37310d[1] == 0.0f) {
                                i4 = i2 + DiTips.this.f37309c.y;
                            } else {
                                i4 = (int) (((float) i2) + (DiTips.this.f37310d[1] * ((float) DiTips.this.getMeasuredHeight())));
                            }
                            if (DiTips.this.f37317k) {
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
                            if (DiTips.this.f37321o != null) {
                                DiTips.this.f37321o.start();
                                Animator unused = DiTips.this.f37321o = null;
                            }
                            if (DiTips.this.f37322p) {
                                DiTips.this.f37323q.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View view, MotionEvent motionEvent) {
                                        if (motionEvent.getAction() != 0 || !DiTips.this.f37322p || !DiTips.this.isShow()) {
                                            return false;
                                        }
                                        DiTips.this.dismiss();
                                        return false;
                                    }
                                });
                            } else {
                                DiTips.this.f37323q.setOnTouchListener((View.OnTouchListener) null);
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
    public void m28157a() {
        LayoutInflater.from(getContext()).inflate(this.f37313g, this, true);
        if (this.f37314h != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f37314h, this, false);
            this.f37308b = inflate;
            inflate.setVisibility(4);
            addView(this.f37308b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private int m28151a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static class Builder {
        private DiTips mDiTips;

        public Builder(Context context, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            int unused = diTips.f37313g = i;
        }

        public Builder setAnchor(View view) {
            View unused = this.mDiTips.f37307a = view;
            return this;
        }

        public Builder setBelowAnchor(boolean z) {
            int unused = this.mDiTips.f37312f = z ? 1 : 0;
            return this;
        }

        public Builder setAboveAnchor(boolean z) {
            int unused = this.mDiTips.f37312f = z ? 2 : 0;
            return this;
        }

        public Builder setLeftAnchor(boolean z) {
            int unused = this.mDiTips.f37311e = z ? 1 : 0;
            return this;
        }

        public Builder setRightAnchor(boolean z) {
            int unused = this.mDiTips.f37311e = z ? 2 : 0;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mDiTips.f37309c.x = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mDiTips.f37309c.y = i;
            return this;
        }

        public Builder setDismissInTouchOut(boolean z) {
            boolean unused = this.mDiTips.f37322p = z;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            boolean unused = this.mDiTips.f37315i = z;
            return this;
        }

        public Builder setOffsetXPercent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f37310d[0] = f;
            return this;
        }

        public Builder setOffsetYPersent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f37310d[1] = f;
            return this;
        }

        public Builder setFollowingLayout(boolean z) {
            boolean unused = this.mDiTips.f37316j = z;
            return this;
        }

        public Builder setKeepInScreenRange(boolean z) {
            boolean unused = this.mDiTips.f37317k = z;
            return this;
        }

        public Builder setUseOriginalDrawPoint(boolean z) {
            boolean unused = this.mDiTips.f37318l = z;
            return this;
        }

        public DiTips build() {
            this.mDiTips.m28157a();
            return this.mDiTips;
        }
    }

    public boolean isShow() {
        return this.f37319m;
    }

    public void show(final Animator animator) {
        if (!this.f37319m) {
            final Activity activity = (Activity) getContext();
            if (!activity.isFinishing()) {
                setVisibility(4);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        FrameLayout unused = DiTips.this.f37323q = new FrameLayout(DiTips.this.getContext());
                        DiTips.this.f37323q.setBackgroundColor(0);
                        DiTips.this.f37323q.addView(DiTips.this, new FrameLayout.LayoutParams(-2, -2));
                        activity.addContentView(DiTips.this.f37323q, layoutParams);
                        DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f37324r);
                        DiTips.this.getViewTreeObserver().addOnGlobalLayoutListener(DiTips.this.f37324r);
                        DiTips.this.requestLayout();
                        if (DiTips.this.f37320n != null) {
                            DiTips.this.f37320n.cancel();
                            Animator unused2 = DiTips.this.f37320n = null;
                        }
                        if (DiTips.this.f37321o != null) {
                            DiTips.this.f37321o.cancel();
                            Animator unused3 = DiTips.this.f37321o = null;
                        }
                        Animator animator = animator;
                        if (animator != null) {
                            Animator unused4 = DiTips.this.f37321o = animator;
                        }
                        boolean unused5 = DiTips.this.f37319m = true;
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
        if (this.f37319m) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f37324r);
            if (animator != null) {
                Animator animator2 = this.f37320n;
                if (animator2 != null) {
                    animator2.cancel();
                    this.f37320n = null;
                }
                Animator animator3 = this.f37321o;
                if (animator3 != null) {
                    animator3.cancel();
                    this.f37321o = null;
                }
                this.f37320n = animator;
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(DiTips.this);
                                }
                                boolean unused = DiTips.this.f37319m = false;
                            }
                        });
                    }
                });
                animator.start();
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (DiTips.this.f37320n != null) {
                        DiTips.this.f37320n.cancel();
                        Animator unused = DiTips.this.f37320n = null;
                    }
                    if (DiTips.this.f37321o != null) {
                        DiTips.this.f37321o.cancel();
                        Animator unused2 = DiTips.this.f37321o = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(DiTips.this);
                    }
                    boolean unused3 = DiTips.this.f37319m = false;
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
