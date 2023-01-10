package com.didi.entrega.customer.datasource.page;

import com.didi.entrega.customer.datasource.listener.PageEventListener;
import java.util.ArrayList;
import java.util.List;

public class PageController<Param, Value> {

    /* renamed from: a */
    private int f21719a;

    /* renamed from: b */
    private int f21720b;

    /* renamed from: c */
    private PageEventListener<Param> f21721c;

    /* renamed from: d */
    private PageStore<Value, ?> f21722d;

    public void initialize(int i, PageEventListener<Param> pageEventListener, PageStore pageStore) {
        this.f21719a = i;
        this.f21720b = i;
        this.f21721c = pageEventListener;
        this.f21722d = pageStore;
    }

    public void loadInit() {
        loadInit((Object) null);
    }

    public void loadInit(Param param) {
        int i = this.f21719a;
        this.f21720b = i;
        PageEventListener<Param> pageEventListener = this.f21721c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
    }

    public int loadNextPage() {
        return loadNextPage((Object) null);
    }

    public int loadNextPage(Param param) {
        int i = this.f21720b;
        PageEventListener<Param> pageEventListener = this.f21721c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
        return i;
    }

    public PageResult<Value> receiveResult(List<Value> list, int i) {
        int i2 = i == this.f21719a ? 1 : 2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        PageResult<Value> pageResult = new PageResult<>(this.f21720b, arrayList, i2);
        this.f21722d.receivePageResult(pageResult);
        this.f21720b = i + 1;
        return pageResult;
    }
}
