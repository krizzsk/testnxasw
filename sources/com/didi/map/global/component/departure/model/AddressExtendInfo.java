package com.didi.map.global.component.departure.model;

public class AddressExtendInfo {

    /* renamed from: a */
    private int f27436a;

    /* renamed from: b */
    private String f27437b;

    /* renamed from: c */
    private String f27438c;

    /* renamed from: d */
    private String f27439d;

    /* renamed from: e */
    private AddressWalkGuide f27440e;

    /* renamed from: f */
    private String f27441f;

    /* renamed from: g */
    private String f27442g;

    public int getZoneType() {
        return this.f27436a;
    }

    public void setZoneType(int i) {
        this.f27436a = i;
    }

    public String getMainNoticeTitle() {
        return this.f27437b;
    }

    public void setMainNoticeTitle(String str) {
        this.f27437b = str;
    }

    public String getSubNoticeTitle() {
        return this.f27438c;
    }

    public void setSubNoticeTitle(String str) {
        this.f27438c = str;
    }

    public String getXpanelDesc() {
        return this.f27441f;
    }

    public void setXpanelDesc(String str) {
        this.f27441f = str;
    }

    public String getBubbleText() {
        return this.f27439d;
    }

    public void setBubbleText(String str) {
        this.f27439d = str;
    }

    public AddressWalkGuide getWalkGuide() {
        return this.f27440e;
    }

    public void setWalkGuide(AddressWalkGuide addressWalkGuide) {
        this.f27440e = addressWalkGuide;
    }

    public String getNavigationText() {
        return this.f27442g;
    }

    public void setNavigationText(String str) {
        this.f27442g = str;
    }

    public String toString() {
        return "AddressExtendInfo{zoneType=" + this.f27436a + ", mainNoticeTitle='" + this.f27437b + '\'' + ", subNoticeTitle='" + this.f27438c + '\'' + ", bubbleText='" + this.f27439d + '\'' + ", walkGuide=" + this.f27440e + '}';
    }
}
