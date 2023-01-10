package com.didiglobal.pay.paysecure.prepaidcard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ViewHeightUtils;", "", "viewObserving", "Landroid/view/View;", "(Landroid/view/View;)V", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "mObservedView", "usableHPrevious", "", "computeUsableHeight", "resetLayoutByUsableHeight", "", "usableHeight", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ViewHeightUtils.kt */
public final class ViewHeightUtils {

    /* renamed from: a */
    private View f52913a;

    /* renamed from: b */
    private int f52914b;

    /* renamed from: c */
    private ViewGroup.LayoutParams f52915c;

    public ViewHeightUtils(View view) {
        Intrinsics.checkParameterIsNotNull(view, "viewObserving");
        this.f52913a = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            final /* synthetic */ ViewHeightUtils this$0;

            {
                this.this$0 = r1;
            }

            public final void onGlobalLayout() {
                ViewHeightUtils viewHeightUtils = this.this$0;
                viewHeightUtils.m39662a(viewHeightUtils.m39661a());
            }
        });
        ViewGroup.LayoutParams layoutParams = this.f52913a.getLayoutParams();
        Intrinsics.checkExpressionValueIsNotNull(layoutParams, "mObservedView.layoutParams");
        this.f52915c = layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m39662a(int i) {
        if (i != this.f52914b) {
            this.f52915c.height = i;
            this.f52913a.requestLayout();
            this.f52914b = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m39661a() {
        Rect rect = new Rect();
        this.f52913a.getLocalVisibleRect(rect);
        SystemUtils.log(4, "benzhang", rect.bottom + " | " + this.f52913a.getHeight(), (Throwable) null, "com.didiglobal.pay.paysecure.prepaidcard.ViewHeightUtils", 34);
        return 0;
    }
}
