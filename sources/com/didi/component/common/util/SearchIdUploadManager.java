package com.didi.component.common.util;

import java.util.ArrayList;
import java.util.List;

public class SearchIdUploadManager {

    /* renamed from: a */
    private List<String> f13638a;

    /* renamed from: b */
    private String f13639b;

    /* renamed from: c */
    private String f13640c;

    private SearchIdUploadManager() {
        this.f13638a = new ArrayList();
        this.f13639b = "";
        this.f13640c = "";
    }

    private static class SearchIdUploadHolder {
        /* access modifiers changed from: private */
        public static final SearchIdUploadManager HOLDER = new SearchIdUploadManager();

        private SearchIdUploadHolder() {
        }
    }

    public static SearchIdUploadManager getInstance() {
        return SearchIdUploadHolder.HOLDER;
    }

    public String getBubbleId() {
        return this.f13639b;
    }

    public void setBubbleId(String str) {
        this.f13639b = str;
    }

    public void addSearchId(String str) {
        this.f13638a.add(str);
    }

    public String getSearchIdBunch() {
        List<String> list = this.f13638a;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f13638a.size(); i++) {
            sb.append(this.f13638a.get(i));
            if (i < this.f13638a.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public String getEstimateAction() {
        return this.f13640c;
    }

    public void setEstimateAction(String str) {
        this.f13640c = str;
    }

    public void clear() {
        this.f13638a.clear();
    }
}
