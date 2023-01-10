package com.didi.entrega.customer.datasource.page;

import java.util.List;

public class PageResult<Value> {
    public static final int RESULT_APPEND = 2;
    public static final int RESULT_INIT = 1;

    /* renamed from: a */
    private int f21723a;

    /* renamed from: b */
    private List<Value> f21724b;

    /* renamed from: c */
    private int f21725c;

    public PageResult(int i, List<Value> list, int i2) {
        this.f21724b = list;
        this.f21723a = i;
        this.f21725c = i2;
    }

    public List<Value> getValueList() {
        return this.f21724b;
    }

    public int getCurrentPage() {
        return this.f21723a;
    }

    public int getResultType() {
        return this.f21725c;
    }

    public boolean isEmpty() {
        List<Value> list = this.f21724b;
        return list == null || list.isEmpty();
    }
}
