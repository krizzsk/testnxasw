package com.didi.component.mapflow.infowindow.model;

public class OneLineTwoMessageModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private SubMessage f16073a;

    /* renamed from: b */
    private SubMessage f16074b;

    /* renamed from: c */
    private boolean f16075c;

    public boolean isShowArrow() {
        return this.f16075c;
    }

    public void setShowArrow(boolean z) {
        this.f16075c = z;
    }

    public SubMessage getLeftMessage() {
        return this.f16073a;
    }

    public void setLeftMessage(SubMessage subMessage) {
        this.f16073a = subMessage;
    }

    public SubMessage getRightMessage() {
        return this.f16074b;
    }

    public void setRightMessage(SubMessage subMessage) {
        this.f16074b = subMessage;
    }
}
