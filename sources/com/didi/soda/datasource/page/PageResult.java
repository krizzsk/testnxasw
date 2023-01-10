package com.didi.soda.datasource.page;

import java.util.List;

public class PageResult<Value> {
    public static final int RESULT_APPEND = 2;
    public static final int RESULT_INIT = 1;

    /* renamed from: a */
    private int f44832a;

    /* renamed from: b */
    private List<Value> f44833b;

    /* renamed from: c */
    private int f44834c;

    public PageResult(int i, List<Value> list, int i2) {
        this.f44833b = list;
        this.f44832a = i;
        this.f44834c = i2;
    }

    public List<Value> getValueList() {
        return this.f44833b;
    }

    public int getCurrentPage() {
        return this.f44832a;
    }

    public int getResultType() {
        return this.f44834c;
    }

    public boolean isEmpty() {
        List<Value> list = this.f44833b;
        return list == null || list.isEmpty();
    }
}
