package com.didi.component.mapflow.infowindow.model;

public class TwoLineTwoSideModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private SubMessage f16084a;

    /* renamed from: b */
    private SubMessage f16085b;

    /* renamed from: c */
    private SubMessage f16086c;

    /* renamed from: d */
    private SubMessage f16087d;

    /* renamed from: e */
    private boolean f16088e;

    public boolean isShowArrow() {
        return this.f16088e;
    }

    public void setShowArrow(boolean z) {
        this.f16088e = z;
    }

    public SubMessage getLeftTop() {
        return this.f16084a;
    }

    public void setLeftTop(SubMessage subMessage) {
        this.f16084a = subMessage;
    }

    public SubMessage getLeftBottom() {
        return this.f16085b;
    }

    public void setLeftBottom(SubMessage subMessage) {
        this.f16085b = subMessage;
    }

    public SubMessage getRightTop() {
        return this.f16086c;
    }

    public void setRightTop(SubMessage subMessage) {
        this.f16086c = subMessage;
    }

    public SubMessage getRightBottom() {
        return this.f16087d;
    }

    public void setRightBottom(SubMessage subMessage) {
        this.f16087d = subMessage;
    }
}
