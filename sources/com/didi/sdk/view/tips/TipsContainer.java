package com.didi.sdk.view.tips;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.taxis99.R;

public class TipsContainer extends FrameLayout {

    /* renamed from: a */
    private static int f40964a;

    /* renamed from: b */
    private Activity f40965b;

    /* renamed from: c */
    private OnActivityListener f40966c;

    /* renamed from: d */
    private OnTipClearListener f40967d;

    /* renamed from: e */
    private boolean f40968e = false;

    /* renamed from: f */
    private C14095a f40969f;

    public interface OnActivityListener {
        void onAttach();

        void onDetach();
    }

    public interface OnTipClearListener {
        void onDismiss();
    }

    public TipsContainer(Activity activity) {
        super(activity);
        m30704a(activity);
    }

    public TipsContainer(Activity activity, OnActivityListener onActivityListener) {
        super(activity);
        this.f40966c = onActivityListener;
        m30704a(activity);
    }

    /* renamed from: a */
    private void m30704a(Activity activity) {
        this.f40965b = activity;
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    /* renamed from: a */
    private void m30703a() {
        if (!this.f40968e) {
            this.f40968e = true;
            this.f40965b.addContentView(this, new ViewGroup.LayoutParams(-1, -1));
            OnActivityListener onActivityListener = this.f40966c;
            if (onActivityListener != null) {
                onActivityListener.onAttach();
            }
        }
    }

    public void detachFromActivity() {
        if (this.f40968e) {
            this.f40968e = false;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
                OnActivityListener onActivityListener = this.f40966c;
                if (onActivityListener != null) {
                    onActivityListener.onDetach();
                }
            }
        }
    }

    public void clearAllTips() {
        C14095a aVar = this.f40969f;
        if (aVar != null) {
            aVar.mo104339b();
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        removeAllViews();
        detachFromActivity();
        OnTipClearListener onTipClearListener = this.f40967d;
        if (onTipClearListener != null) {
            onTipClearListener.onDismiss();
        }
        f40964a = 0;
    }

    public static void subtractShowTime() {
        f40964a--;
    }

    public void show(TipsView tipsView, View view, int i, int i2) {
        show(tipsView, view, i, i2, 0, 0);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4) {
        show(tipsView, view, i, i2, 0, 0, false);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4, boolean z) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m30703a();
            C14098d dVar = new C14098d(this.f40965b, this);
            this.f40969f = dVar;
            dVar.mo104337a(view, tipsView);
            this.f40969f.mo104336a(i, i2, 0, i3, i4, z);
            f40964a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5) {
        showWithLine(tipsView, view, i, i2, i3, i4, i5, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5, long j, String str) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m30703a();
            C14097c cVar = new C14097c(this.f40965b, this);
            this.f40969f = cVar;
            cVar.mo104337a(view, tipsView);
            ((C14097c) this.f40969f).mo104341a(j, str);
            this.f40969f.mo104336a(i, i2, i3, i4, i5, false);
            f40964a++;
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

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
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

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Deprecated
    /* renamed from: b */
    private void m30705b() {
        C14095a aVar = this.f40969f;
        if (aVar != null) {
            aVar.mo104339b();
        }
        removeAllViews();
        f40964a = 0;
    }

    public static boolean isShowing() {
        return f40964a != 0;
    }

    public void setOnClearListener(OnTipClearListener onTipClearListener) {
        this.f40967d = onTipClearListener;
    }
}
