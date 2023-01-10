package com.didi.soda.search.component.result;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo148868d2 = {"<anonymous>", "", "Lcom/didi/soda/search/component/result/SearchResultPageParam;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SearchResultDataSource.kt */
final class SearchResultDataSource$updateLastShopId$1 extends Lambda implements Function1<SearchResultPageParam, Unit> {
    final /* synthetic */ String $shopId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultDataSource$updateLastShopId$1(String str) {
        super(1);
        this.$shopId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SearchResultPageParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SearchResultPageParam searchResultPageParam) {
        Intrinsics.checkNotNullParameter(searchResultPageParam, "$this$updateParams");
        searchResultPageParam.setLastBusinessId(this.$shopId);
    }
}
