package com.didi.payment.commonsdk.utils;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "dm", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "mKeyBoardListen", "Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener$KeyBoardListener;", "mOriginHeight", "", "mPreHeight", "getRootView", "()Landroid/view/View;", "softKeyboardHeight", "onGlobalLayout", "", "setKeyBoardListener", "keyBoardListen", "KeyBoardListener", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NKeyboardChangeListener.kt */
public final class NKeyboardChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final View f32661a;

    /* renamed from: b */
    private int f32662b;

    /* renamed from: c */
    private int f32663c;

    /* renamed from: d */
    private KeyBoardListener f32664d;

    /* renamed from: e */
    private final DisplayMetrics f32665e;

    /* renamed from: f */
    private final int f32666f;

    @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener$KeyBoardListener;", "", "onKeyboardChange", "", "isShow", "", "wallet-service-commonsdk_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: NKeyboardChangeListener.kt */
    public interface KeyBoardListener {
        void onKeyboardChange(boolean z);
    }

    public NKeyboardChangeListener(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.f32661a = view;
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f32665e = displayMetrics;
        this.f32666f = displayMetrics.heightPixels / 4;
    }

    public final View getRootView() {
        return this.f32661a;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f32661a.getWindowVisibleDisplayFrame(rect);
        if (this.f32661a.getBottom() - rect.bottom > this.f32666f) {
            KeyBoardListener keyBoardListener = this.f32664d;
            Intrinsics.checkNotNull(keyBoardListener);
            keyBoardListener.onKeyboardChange(true);
            return;
        }
        KeyBoardListener keyBoardListener2 = this.f32664d;
        Intrinsics.checkNotNull(keyBoardListener2);
        keyBoardListener2.onKeyboardChange(false);
    }

    public final void setKeyBoardListener(KeyBoardListener keyBoardListener) {
        Intrinsics.checkNotNullParameter(keyBoardListener, "keyBoardListen");
        this.f32664d = keyBoardListener;
    }
}
