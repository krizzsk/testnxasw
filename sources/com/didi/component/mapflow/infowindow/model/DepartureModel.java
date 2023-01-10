package com.didi.component.mapflow.infowindow.model;

public class DepartureModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private String f16053a;

    /* renamed from: b */
    private String f16054b;

    /* renamed from: c */
    private String f16055c;

    /* renamed from: d */
    private boolean f16056d;

    /* renamed from: e */
    private boolean f16057e;

    /* renamed from: f */
    private boolean f16058f;

    /* renamed from: g */
    private boolean f16059g;

    /* renamed from: h */
    private boolean f16060h;

    /* renamed from: i */
    private String f16061i;

    /* renamed from: j */
    private String f16062j;

    public void setShowNearbyHint(boolean z) {
        this.f16060h = z;
    }

    public boolean isShowNearbyHint() {
        return this.f16060h;
    }

    public boolean isShowLoading() {
        return this.f16056d;
    }

    public void setShowLoading(boolean z) {
        this.f16056d = z;
    }

    public String getEtaValue() {
        return this.f16053a;
    }

    public void setEtaValue(String str) {
        this.f16053a = str;
    }

    public String getEtaUnit() {
        return this.f16054b;
    }

    public void setEtaUnit(String str) {
        this.f16054b = str;
    }

    public String getMessage() {
        return this.f16055c;
    }

    public void setMessage(String str) {
        this.f16055c = str;
    }

    public void setArrow(boolean z) {
        this.f16057e = z;
    }

    public boolean isArrow() {
        return this.f16057e;
    }

    public boolean isMessageOnly() {
        return this.f16058f;
    }

    public void setMessageOnly(boolean z) {
        this.f16058f = z;
    }

    public boolean isLeftTwoLine() {
        return this.f16059g;
    }

    public void setLeftTwoLine(boolean z) {
        this.f16059g = z;
    }

    public String getEtd() {
        return this.f16061i;
    }

    public void setEtd(String str) {
        this.f16061i = str;
    }

    public String getMapStartPointText() {
        return this.f16062j;
    }

    public void setMapStartPointText(String str) {
        this.f16062j = str;
    }
}
