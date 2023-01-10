package com.didi.soda.customer.widget.tabbar;

import android.view.View;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarController.kt */
final class TabBarController$setupTabItemView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ TabBarItemModel $model;
    final /* synthetic */ TabBarController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabBarController$setupTabItemView$2(TabBarController tabBarController, TabBarItemModel tabBarItemModel) {
        super(1);
        this.this$0 = tabBarController;
        this.$model = tabBarItemModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        TabBarItem tabBarItem;
        ComponentController controller;
        Intrinsics.checkNotNullParameter(view, "it");
        if (!Intrinsics.areEqual((Object) this.this$0.f44752c, (Object) this.$model)) {
            LogUtil.m32584d("TabBar", "DoubleClick but not active");
            this.this$0.m33215b(this.$model);
            this.this$0.m33208a(this.$model, true);
            return;
        }
        LogUtil.m32584d("TabBar", "invoke onDoubleClickTab");
        TabBarItemModel access$getCurSelected$p = this.this$0.f44752c;
        if (access$getCurSelected$p != null && (tabBarItem = access$getCurSelected$p.getTabBarItem()) != null && (controller = tabBarItem.getController()) != null) {
            controller.onDoubleClickTab();
        }
    }
}
