package com.didi.soda.home.topgun.widget;

import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicItemAdapter.kt */
final class HomeTopicItemAdapter$Companion$ShopItemHolder2$setData$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HomeTopicBinder.Companion.Logic $logic;
    final /* synthetic */ HomeBusinessInfoRvModel $shopModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeTopicItemAdapter$Companion$ShopItemHolder2$setData$1$2(HomeTopicBinder.Companion.Logic logic, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        super(0);
        this.$logic = logic;
        this.$shopModel = homeBusinessInfoRvModel;
    }

    public final void invoke() {
        HomeTopicBinder.Companion.Logic logic = this.$logic;
        if (logic != null) {
            logic.showItemShop(this.$shopModel);
        }
    }
}
