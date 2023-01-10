package com.didi.map.global.component.trafficreport.model;

import com.didi.common.map.util.CollectionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportItem implements Serializable {
    final String itemIcon;
    final Integer itemIndex;
    final String itemTitle;
    final Integer itemValue;
    final List<ReportGroup> secondaryList;

    public String getItemTitle() {
        return this.itemTitle;
    }

    public String getItemIcon() {
        return this.itemIcon;
    }

    public Integer getItemIndex() {
        return this.itemIndex;
    }

    public Integer getItemValue() {
        return this.itemValue;
    }

    public List<ReportGroup> getSecondaryList() {
        return this.secondaryList;
    }

    public ReportItem(Builder builder) {
        this.itemTitle = builder.itemTitle;
        this.itemIcon = builder.itemIcon;
        this.itemIndex = builder.itemIndex;
        this.itemValue = builder.itemValue;
        this.secondaryList = builder.secondaryList;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String itemIcon;
        /* access modifiers changed from: private */
        public Integer itemIndex;
        /* access modifiers changed from: private */
        public String itemTitle;
        /* access modifiers changed from: private */
        public Integer itemValue;
        /* access modifiers changed from: private */
        public List<ReportGroup> secondaryList = new ArrayList();

        public Builder itemTitle(String str) {
            this.itemTitle = str;
            return this;
        }

        public Builder itemIcon(String str) {
            this.itemIcon = str;
            return this;
        }

        public Builder itemIndex(int i) {
            this.itemIndex = Integer.valueOf(i);
            return this;
        }

        public Builder itemValue(int i) {
            this.itemValue = Integer.valueOf(i);
            return this;
        }

        public Builder secondaryList(List<ReportGroup> list) {
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                this.secondaryList.addAll(list);
            }
            return this;
        }

        public ReportItem build() {
            return new ReportItem(this);
        }
    }
}
