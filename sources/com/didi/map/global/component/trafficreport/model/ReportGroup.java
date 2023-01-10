package com.didi.map.global.component.trafficreport.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportGroup implements Serializable {
    final int CateCode;
    final List<ReportItem> members;
    final String title;

    public String getTitle() {
        return this.title;
    }

    public List<ReportItem> getMembers() {
        return this.members;
    }

    public int getCateCode() {
        return this.CateCode;
    }

    public ReportGroup(Builder builder) {
        this.title = builder.title;
        this.members = builder.members;
        this.CateCode = builder.CateCode;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int CateCode;
        /* access modifiers changed from: private */
        public List<ReportItem> members = new ArrayList();
        /* access modifiers changed from: private */
        public String title;

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder member(ReportItem reportItem) {
            this.members.add(reportItem);
            return this;
        }

        public Builder cateCode(int i) {
            this.CateCode = i;
            return this;
        }

        public ReportGroup build() {
            return new ReportGroup(this);
        }
    }
}
