package com.didi.global.loading.render;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.global.loading.ILoadingRender;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoadingRender implements ILoadingRender {
    public static final int MAX_PARENT_LEVEL = 1;
    public static final int STATUS_RENDER_CREATED = 1;
    public static final int STATUS_RENDER_HIDE = 0;
    public static final int STATUS_RENDER_LAYOUT = 2;
    public static final int STATUS_RENDER_SHOWING = 3;
    public static final String kBackgroundColor = "Loading::Background::Color";
    public static final String kDuration = "Loading::Duration";
    public static final String kGravity = "Loading::Gravity";
    public static final String kInterpolatorId = "Loading::Interpolator::Id";

    /* renamed from: a */
    List<ILoadingRender.Callback> f24574a = new ArrayList();

    /* renamed from: b */
    private int f24575b = 0;

    /* renamed from: c */
    private View f24576c;

    /* renamed from: d */
    private int f24577d = 80;
    public int mRenderStatus = 0;

    /* access modifiers changed from: protected */
    public int maxParentSearchLevel() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public abstract View onCreateView(Context context, Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract void onStartLoading();

    /* access modifiers changed from: package-private */
    public abstract void onStopLoading();

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r10 != 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
        if (r10 != 1) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m19752a(int r10) {
        /*
            r9 = this;
            int r0 = r9.mRenderStatus
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0022
            r3 = 3
            r4 = 2
            if (r0 == r2) goto L_0x0012
            if (r0 == r4) goto L_0x0016
            if (r0 == r3) goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0027
        L_0x0010:
            r0 = 0
            goto L_0x001d
        L_0x0012:
            if (r10 == 0) goto L_0x0018
            if (r10 == r4) goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            if (r10 == r3) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            if (r10 == 0) goto L_0x0020
            goto L_0x0027
        L_0x0020:
            r0 = 1
            goto L_0x0027
        L_0x0022:
            if (r10 == 0) goto L_0x0020
            if (r10 == r2) goto L_0x0020
            goto L_0x000e
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r9.mRenderStatus = r10
            return r1
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[ERROR] status "
            r0.append(r1)
            int r1 = r9.mRenderStatus
            r0.append(r1)
            java.lang.String r1 = "can't move to "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r5 = r0.toString()
            r3 = 6
            r6 = 0
            r8 = 85
            java.lang.String r4 = "zl-loading"
            java.lang.String r7 = "com.didi.global.loading.render.BaseLoadingRender"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.loading.render.BaseLoadingRender.m19752a(int):boolean");
    }

    public void createRender(Context context, Bundle bundle) {
        if (!m19752a(1)) {
            this.f24576c = onCreateView(context, bundle);
            this.f24577d = bundle.getInt("Loading::Gravity", 80);
            for (ILoadingRender.Callback onCreate : this.f24574a) {
                onCreate.onCreate(bundle);
            }
        }
    }

    public final void layoutRender(View view, ViewGroup viewGroup) {
        if (!m19752a(2)) {
            this.f24575b = 0;
            onLayoutView(view, m19751a(view), viewGroup);
            for (ILoadingRender.Callback onLayout : this.f24574a) {
                onLayout.onLayout();
            }
        }
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        int measuredWidth = view.getMeasuredWidth();
        ViewGroup.LayoutParams a = m19750a(view, viewGroup, new ViewGroup.LayoutParams(measuredWidth, -2));
        View view2 = this.f24576c;
        if (!(view2 == null || view2.getParent() == null)) {
            ((ViewGroup) this.f24576c.getParent()).removeView(this.f24576c);
        }
        if (viewGroup2 != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            viewGroup2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            this.f24576c.setX((float) (i - i3));
            if (this.f24577d == 48) {
                this.f24576c.setY((float) (i2 - i4));
            } else {
                this.f24576c.setY(((float) (i2 - i4)) + ((float) view.getMeasuredHeight()));
            }
            viewGroup2.addView(this.f24576c, new ViewGroup.LayoutParams(measuredWidth, -2));
        } else if (viewGroup == null) {
        } else {
            if (viewGroup.getLayoutParams() != null && viewGroup == view && this.f24577d == 80 && viewGroup.getLayoutParams().height == -2) {
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                int measuredHeight = viewGroup.getMeasuredHeight();
                if (measuredHeight > 0) {
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                } else {
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, getBorder().height()));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, getBorder().height());
                layoutParams.gravity = 80;
                frameLayout.addView(this.f24576c, layoutParams);
                viewGroup.addView(frameLayout);
                return;
            }
            viewGroup.addView(this.f24576c, a);
        }
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m19750a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        int measuredWidth = view.getMeasuredWidth();
        if (viewGroup instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f24577d == 48) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 48;
                } else {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                }
            } else if (this.f24577d == 48) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = view.getMeasuredHeight();
            }
        } else if (viewGroup instanceof ConstraintLayout) {
            layoutParams = new ConstraintLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f24577d == 48) {
                    ((ConstraintLayout.LayoutParams) layoutParams).topToTop = view.getId();
                } else {
                    ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = view.getId();
                }
            } else if (this.f24577d == 48) {
                ((ConstraintLayout.LayoutParams) layoutParams).topToTop = view.getId();
            } else {
                ((ConstraintLayout.LayoutParams) layoutParams).topToBottom = view.getId();
            }
        } else if (viewGroup instanceof RelativeLayout) {
            layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f24577d == 48) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(10);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                }
            } else if (this.f24577d == 48) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(6, view.getId());
            } else {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, view.getId());
            }
        }
        return layoutParams;
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f24576c.getMeasuredWidth(), this.f24576c.getMeasuredHeight());
    }

    /* renamed from: a */
    private ViewGroup m19751a(View view) {
        if (this.f24575b > maxParentSearchLevel()) {
            return null;
        }
        this.f24575b++;
        ViewParent parent = view.getParent();
        if (m19753b(view)) {
            return (ViewGroup) view;
        }
        if (parent instanceof ViewGroup) {
            return m19751a((View) (ViewGroup) parent);
        }
        return null;
    }

    public View getView() {
        return this.f24576c;
    }

    /* renamed from: b */
    private boolean m19753b(View view) {
        return (view instanceof FrameLayout) || (view instanceof ConstraintLayout) || (view instanceof RelativeLayout);
    }

    public final void start() {
        if (!m19752a(3)) {
            SystemUtils.log(3, "zl-loading", "base render start", (Throwable) null, "com.didi.global.loading.render.BaseLoadingRender", 287);
            onStartLoading();
            for (ILoadingRender.Callback onStart : this.f24574a) {
                onStart.onStart();
            }
        }
    }

    public final void stop() {
        if (!m19752a(0)) {
            SystemUtils.log(3, "zl-loading", "base render stop", (Throwable) null, "com.didi.global.loading.render.BaseLoadingRender", 299);
            onStopLoading();
            View view = this.f24576c;
            if (!(view == null || view.getParent() == null)) {
                ((ViewGroup) this.f24576c.getParent()).removeView(this.f24576c);
            }
            for (ILoadingRender.Callback onStop : this.f24574a) {
                onStop.onStop();
            }
            this.f24574a.clear();
        }
    }

    public final void addCallback(ILoadingRender.Callback callback) {
        this.f24574a.add(callback);
    }
}
