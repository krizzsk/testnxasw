package com.didi.payment.base.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LoadingController.kt */
final class LoadingController$loadingView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ LoadingController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadingController$loadingView$2(LoadingController loadingController) {
        super(0);
        this.this$0 = loadingController;
    }

    public final View invoke() {
        if (this.this$0.f32450b.getLoadingLayoutId() == 0) {
            return this.this$0.f32450b.getLoadingLayoutView();
        }
        return View.inflate(this.this$0.f32449a.getContext(), this.this$0.f32450b.getLoadingLayoutId(), (ViewGroup) null);
    }
}
