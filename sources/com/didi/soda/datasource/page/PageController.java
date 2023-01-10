package com.didi.soda.datasource.page;

import com.didi.soda.datasource.listener.PageEventListener;
import java.util.ArrayList;
import java.util.List;

public class PageController<Param, Value> {

    /* renamed from: a */
    private int f44825a;

    /* renamed from: b */
    private int f44826b;

    /* renamed from: c */
    private PageEventListener<Param> f44827c;

    /* renamed from: d */
    private PageStore<Value, ?> f44828d;

    public void initialize(int i, PageEventListener<Param> pageEventListener, PageStore pageStore) {
        this.f44825a = i;
        this.f44826b = i;
        this.f44827c = pageEventListener;
        this.f44828d = pageStore;
    }

    public void loadInit() {
        loadInit((Object) null);
    }

    public void loadInit(Param param) {
        int i = this.f44825a;
        this.f44826b = i;
        PageEventListener<Param> pageEventListener = this.f44827c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
    }

    public int loadNextPage() {
        return loadNextPage((Object) null);
    }

    public int loadNextPage(Param param) {
        int i = this.f44826b;
        PageEventListener<Param> pageEventListener = this.f44827c;
        if (pageEventListener != null) {
            pageEventListener.onPageLoad(i, param);
        }
        return i;
    }

    public PageResult<Value> receiveResult(List<Value> list, int i) {
        int i2 = i == this.f44825a ? 1 : 2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        PageResult<Value> pageResult = new PageResult<>(this.f44826b, arrayList, i2);
        this.f44828d.receivePageResult(pageResult);
        this.f44826b = i + 1;
        return pageResult;
    }
}
