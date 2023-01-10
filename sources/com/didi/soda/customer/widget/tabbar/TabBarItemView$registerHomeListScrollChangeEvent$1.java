package com.didi.soda.customer.widget.tabbar;

import com.didi.soda.home.manager.HomeRocketLaunchAnimManager;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo148868d2 = {"com/didi/soda/customer/widget/tabbar/TabBarItemView$registerHomeListScrollChangeEvent$1", "Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$OnHomeListScrollChangeListener;", "onScrollDownMoreThanOnePage", "", "onScrollUpLessThanOnePage", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarItemView.kt */
public final class TabBarItemView$registerHomeListScrollChangeEvent$1 implements HomeRocketLaunchAnimManager.OnHomeListScrollChangeListener {
    final /* synthetic */ TabBarItemModel $model;
    final /* synthetic */ TabBarItemView this$0;

    TabBarItemView$registerHomeListScrollChangeEvent$1(TabBarItemView tabBarItemView, TabBarItemModel tabBarItemModel) {
        this.this$0 = tabBarItemView;
        this.$model = tabBarItemModel;
    }

    public void onScrollUpLessThanOnePage() {
        this.this$0.m33219a(false, true, this.$model);
    }

    public void onScrollDownMoreThanOnePage() {
        this.this$0.m33219a(true, true, this.$model);
    }
}
