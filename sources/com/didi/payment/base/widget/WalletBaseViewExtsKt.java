package com.didi.payment.base.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004¨\u0006\u0005"}, mo148868d2 = {"click", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "base_globalRelease"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletBaseViewExts.kt */
public final class WalletBaseViewExtsKt {
    public static final void click(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (function0 != null) {
            view.setOnClickListener(new WalletBaseViewExtsKt$click$1(function0));
        } else {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }
}
