package com.didi.soda.home.topgun.manager;

import com.didi.soda.datasource.page.PageParams;

public class HomeFeedParam extends PageParams {

    /* renamed from: a */
    private int f45481a;

    /* renamed from: b */
    private String f45482b;

    /* renamed from: c */
    private boolean f45483c;

    /* renamed from: d */
    private String f45484d;

    /* renamed from: e */
    private String f45485e;

    public String getCateId() {
        return this.f45485e;
    }

    public void setCateId(String str) {
        this.f45485e = str;
    }

    public void updateFilterParam(String str) {
        this.f45482b = str;
    }

    public void setIsFilter(boolean z) {
        this.f45483c = z;
    }

    public boolean isFilter() {
        return this.f45483c;
    }

    public void setScene(int i) {
        this.f45481a = i;
    }

    public int getScene() {
        return this.f45481a;
    }

    public String getFilterParam() {
        return this.f45482b;
    }

    public String getTraceId() {
        return this.f45484d;
    }

    public void setTraceId(String str) {
        this.f45484d = str;
    }

    public void reset() {
        super.reset();
        this.f45482b = "";
    }
}
