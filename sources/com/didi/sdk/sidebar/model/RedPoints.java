package com.didi.sdk.sidebar.model;

import java.io.Serializable;

public class RedPoints implements Serializable {
    public static final int IS_CLICKED = 1;
    public static final int IS_NOT_CLICKED = 0;
    private long componentId;
    private long endTime;
    private String iconUrl;

    /* renamed from: id */
    private long f40136id;
    private int isCLicked;
    private String level;
    private String page;
    private long startTime;

    public int getIsCLicked() {
        return this.isCLicked;
    }

    public void setIsCLicked(int i) {
        this.isCLicked = i;
    }

    public long getId() {
        return this.f40136id;
    }

    public void setId(long j) {
        this.f40136id = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getComponentId() {
        return this.componentId;
    }

    public void setComponentId(long j) {
        this.componentId = j;
    }

    public String getLevel() {
        return this.level;
    }

    public String getPage() {
        return this.page;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String toString() {
        return "RedPoints{id=" + this.f40136id + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", componentId=" + this.componentId + '}';
    }
}
