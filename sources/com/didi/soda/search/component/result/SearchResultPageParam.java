package com.didi.soda.search.component.result;

import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.search.repo.SearchWordModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u00020\u0010J\b\u00103\u001a\u000204H\u0016J\u000e\u00105\u001a\u0002042\u0006\u00106\u001a\u00020%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00068"}, mo148868d2 = {"Lcom/didi/soda/search/component/result/SearchResultPageParam;", "Lcom/didi/soda/datasource/page/PageParams;", "()V", "filterParams", "", "getFilterParams", "()Ljava/lang/String;", "setFilterParams", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "highRatingRecallNumm", "", "getHighRatingRecallNumm", "()I", "setHighRatingRecallNumm", "(I)V", "intentionType", "getIntentionType", "setIntentionType", "lastBusinessId", "getLastBusinessId", "setLastBusinessId", "lastQuery", "getLastQuery", "setLastQuery", "pageType", "getPageType", "setPageType", "queryCkJson", "getQueryCkJson", "setQueryCkJson", "searchFrom", "Lcom/didi/soda/search/repo/SearchWordModel$SearchFrom;", "searchTag", "getSearchTag", "setSearchTag", "sugCkJson", "getSugCkJson", "setSugCkJson", "sugId", "getSugId", "setSugId", "traceId", "getTraceId", "setTraceId", "getSearchFrom", "reset", "", "setSearchFrom", "from", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SearchResultPageParam.kt */
public final class SearchResultPageParam extends PageParams {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGETYPE_RECOMMMEND = 1;
    public static final int PAGETYPE_SEARCH = 0;

    /* renamed from: a */
    private boolean f46287a;

    /* renamed from: b */
    private String f46288b;

    /* renamed from: c */
    private String f46289c = "";

    /* renamed from: d */
    private String f46290d = "0";

    /* renamed from: e */
    private SearchWordModel.SearchFrom f46291e = SearchWordModel.SearchFrom.EDIT;

    /* renamed from: f */
    private int f46292f;

    /* renamed from: g */
    private String f46293g;

    /* renamed from: h */
    private String f46294h;

    /* renamed from: i */
    private String f46295i;

    /* renamed from: j */
    private String f46296j;

    /* renamed from: k */
    private String f46297k;

    /* renamed from: l */
    private int f46298l;

    /* renamed from: m */
    private int f46299m;

    public boolean getHasMore() {
        return this.f46287a;
    }

    public void setHasMore(boolean z) {
        this.f46287a = z;
    }

    public final String getSearchTag() {
        return this.f46288b;
    }

    public final void setSearchTag(String str) {
        this.f46288b = str;
    }

    public final String getFilterParams() {
        return this.f46289c;
    }

    public final void setFilterParams(String str) {
        this.f46289c = str;
    }

    public final String getLastBusinessId() {
        return this.f46290d;
    }

    public final void setLastBusinessId(String str) {
        this.f46290d = str;
    }

    public final int getPageType() {
        return this.f46292f;
    }

    public final void setPageType(int i) {
        this.f46292f = i;
    }

    public final String getSugId() {
        return this.f46293g;
    }

    public final void setSugId(String str) {
        this.f46293g = str;
    }

    public final String getSugCkJson() {
        return this.f46294h;
    }

    public final void setSugCkJson(String str) {
        this.f46294h = str;
    }

    public final String getQueryCkJson() {
        return this.f46295i;
    }

    public final void setQueryCkJson(String str) {
        this.f46295i = str;
    }

    public final String getLastQuery() {
        return this.f46296j;
    }

    public final void setLastQuery(String str) {
        this.f46296j = str;
    }

    public final String getTraceId() {
        return this.f46297k;
    }

    public final void setTraceId(String str) {
        this.f46297k = str;
    }

    public final int getIntentionType() {
        return this.f46298l;
    }

    public final void setIntentionType(int i) {
        this.f46298l = i;
    }

    public final int getHighRatingRecallNumm() {
        return this.f46299m;
    }

    public final void setHighRatingRecallNumm(int i) {
        this.f46299m = i;
    }

    public final void setSearchFrom(SearchWordModel.SearchFrom searchFrom) {
        Intrinsics.checkNotNullParameter(searchFrom, "from");
        this.f46291e = searchFrom;
    }

    public final int getSearchFrom() {
        return this.f46291e.ordinal();
    }

    public void reset() {
        super.reset();
        this.f46289c = "";
        this.f46290d = "0";
        this.f46291e = SearchWordModel.SearchFrom.EDIT;
        this.f46292f = 0;
        this.f46293g = null;
        this.f46294h = null;
        this.f46295i = null;
        this.f46296j = null;
        this.f46297k = "";
        this.f46298l = 0;
        this.f46299m = 0;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/soda/search/component/result/SearchResultPageParam$Companion;", "", "()V", "PAGETYPE_RECOMMMEND", "", "PAGETYPE_SEARCH", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SearchResultPageParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
