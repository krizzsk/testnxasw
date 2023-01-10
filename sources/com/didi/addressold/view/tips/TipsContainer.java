package com.didi.addressold.view.tips;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.taxis99.R;

public class TipsContainer extends FrameLayout {

    /* renamed from: a */
    private static int f9809a;

    /* renamed from: b */
    private Activity f9810b;

    /* renamed from: c */
    private OnActivityListener f9811c;

    /* renamed from: d */
    private OnTipClearListener f9812d;

    /* renamed from: e */
    private boolean f9813e = false;

    /* renamed from: f */
    private C4088a f9814f;

    public interface OnActivityListener {
        void onAttach();

        void onDetach();
    }

    public interface OnTipClearListener {
        void onDismiss();
    }

    public TipsContainer(Activity activity) {
        super(activity);
        m8549a(activity);
    }

    public TipsContainer(Activity activity, OnActivityListener onActivityListener) {
        super(activity);
        this.f9811c = onActivityListener;
        m8549a(activity);
    }

    /* renamed from: a */
    private void m8549a(Activity activity) {
        this.f9810b = activity;
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    /* renamed from: a */
    private void m8548a() {
        if (!this.f9813e) {
            this.f9813e = true;
            this.f9810b.addContentView(this, new FrameLayout.LayoutParams(-1, -1));
            OnActivityListener onActivityListener = this.f9811c;
            if (onActivityListener != null) {
                onActivityListener.onAttach();
            }
        }
    }

    public void detachFromActivity() {
        if (this.f9813e) {
            this.f9813e = false;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
                OnActivityListener onActivityListener = this.f9811c;
                if (onActivityListener != null) {
                    onActivityListener.onDetach();
                }
            }
        }
    }

    public void clearAllTips() {
        C4088a aVar = this.f9814f;
        if (aVar != null) {
            aVar.mo44859b();
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        removeAllViews();
        detachFromActivity();
        OnTipClearListener onTipClearListener = this.f9812d;
        if (onTipClearListener != null) {
            onTipClearListener.onDismiss();
        }
        f9809a = 0;
    }

    public static void subtractShowTime() {
        f9809a--;
    }

    public void show(TipsView tipsView, View view, int i, int i2) {
        show(tipsView, view, i, i2, 0, 0);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4) {
        show(tipsView, view, i, i2, i3, i4, false);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4, boolean z) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m8548a();
            C4091d dVar = new C4091d(this.f9810b, this);
            this.f9814f = dVar;
            dVar.mo44857a(view, tipsView);
            this.f9814f.mo44856a(i, i2, 0, i3, i4, z);
            f9809a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5) {
        showWithLine(tipsView, view, i, i2, i3, i4, i5, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5, long j, String str) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m8548a();
            C4090c cVar = new C4090c(this.f9810b, this);
            this.f9814f = cVar;
            cVar.mo44857a(view, tipsView);
            ((C4090c) this.f9814f).mo44861a(j, str);
            this.f9814f.mo44856a(i, i2, i3, i4, i5, false);
            f9809a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3) {
        showWithLine(tipsView, view, i, i2, i3, 0, 0, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, long j, String str) {
        showWithLine(tipsView, view, i, i2, i3, 0, 0, j, str);
    }

    public void addView(View view) {
        super.addView(view);
    }

    public void addView(View view, FrameLayout.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, layoutParams);
        }
    }

    public void addView(View view, int i) {
        if (view.getParent() == null) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (view.getParent() == null) {
            super.addView(view, i, i2);
        }
    }

    public void addView(View view, int i, FrameLayout.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Deprecated
    /* renamed from: b */
    private void m8550b() {
        C4088a aVar = this.f9814f;
        if (aVar != null) {
            aVar.mo44859b();
        }
        removeAllViews();
        f9809a = 0;
    }

    public static boolean isShowing() {
        return f9809a != 0;
    }

    public void setOnClearListener(OnTipClearListener onTipClearListener) {
        this.f9812d = onTipClearListener;
    }
}
