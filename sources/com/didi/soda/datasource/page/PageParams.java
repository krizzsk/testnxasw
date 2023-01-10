package com.didi.soda.datasource.page;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/soda/datasource/page/PageParams;", "", "()V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "pageIndex", "", "getPageIndex", "()I", "setPageIndex", "(I)V", "recId", "", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "reset", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PageParams.kt */
public class PageParams {

    /* renamed from: a */
    private int f44829a;

    /* renamed from: b */
    private String f44830b;

    /* renamed from: c */
    private boolean f44831c;

    public final int getPageIndex() {
        return this.f44829a;
    }

    public final void setPageIndex(int i) {
        this.f44829a = i;
    }

    public final String getRecId() {
        return this.f44830b;
    }

    public final void setRecId(String str) {
        this.f44830b = str;
    }

    public boolean getHasMore() {
        return this.f44831c;
    }

    public void setHasMore(boolean z) {
        this.f44831c = z;
    }

    public void reset() {
        this.f44829a = 0;
        this.f44830b = "";
        setHasMore(false);
    }
}
