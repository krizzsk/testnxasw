package com.didi.soda.bill.widgets.notify;

import android.animation.ValueAnimator;
import com.didi.soda.customer.animation.CustomerInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NotifyLayout.kt */
final class NotifyLayout$animator$2 extends Lambda implements Function0<ValueAnimator> {
    final /* synthetic */ NotifyLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotifyLayout$animator$2(NotifyLayout notifyLayout) {
        super(0);
        this.this$0 = notifyLayout;
    }

    public final ValueAnimator invoke() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        NotifyLayout notifyLayout = this.this$0;
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NotifyLayout$animator$2.m47286invoke$lambda1$lambda0(NotifyLayout.this, valueAnimator);
            }
        });
        ofFloat.addListener(notifyLayout.f42037g);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m47286invoke$lambda1$lambda0(NotifyLayout notifyLayout, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(notifyLayout, "this$0");
        notifyLayout.requestLayout();
    }
}
