package com.didi.soda.customer.widget.tabbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarController.kt */
final class TabBarController$Event$onStop$1 extends Lambda implements Function1<ComponentController, Unit> {
    public static final TabBarController$Event$onStop$1 INSTANCE = new TabBarController$Event$onStop$1();

    TabBarController$Event$onStop$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ComponentController) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ComponentController componentController) {
        Intrinsics.checkNotNullParameter(componentController, "it");
        componentController.onStop();
    }
}
