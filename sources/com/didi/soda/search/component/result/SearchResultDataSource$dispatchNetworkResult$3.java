package com.didi.soda.search.component.result;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo148868d2 = {"<anonymous>", "", "Lcom/didi/soda/search/component/result/SearchResultPageParam;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SearchResultDataSource.kt */
final class SearchResultDataSource$dispatchNetworkResult$3 extends Lambda implements Function1<SearchResultPageParam, Unit> {
    final /* synthetic */ SearchResultEntity $searchEntity;
    final /* synthetic */ boolean $searchRecommendHasMore;
    final /* synthetic */ boolean $searchResultHasMore;
    final /* synthetic */ String $traceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultDataSource$dispatchNetworkResult$3(boolean z, boolean z2, SearchResultEntity searchResultEntity, String str) {
        super(1);
        this.$searchResultHasMore = z;
        this.$searchRecommendHasMore = z2;
        this.$searchEntity = searchResultEntity;
        this.$traceId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SearchResultPageParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SearchResultPageParam searchResultPageParam) {
        Intrinsics.checkNotNullParameter(searchResultPageParam, "$this$updateParams");
        searchResultPageParam.setHasMore(this.$searchResultHasMore || this.$searchRecommendHasMore);
        searchResultPageParam.setRecId(TextUtils.isEmpty(this.$searchEntity.mRecId) ? "" : this.$searchEntity.mRecId);
        searchResultPageParam.setTraceId(this.$traceId);
        searchResultPageParam.setIntentionType(this.$searchEntity.mIntentionType);
    }
}
