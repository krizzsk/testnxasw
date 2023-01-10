package com.didi.component.comp_selectseat.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public class ScheduleItemModel {
    public static int ITEM_TYPE_SHIFT = 1;
    public static int ITEM_TYPE_TITLE;

    /* renamed from: a */
    private LEGORichInfo f14245a;

    /* renamed from: b */
    private ShiftBean f14246b;

    /* renamed from: c */
    private int f14247c;

    public int getViewType() {
        return this.f14247c;
    }

    public void setViewType(int i) {
        this.f14247c = i;
    }

    public LEGORichInfo getTitleBean() {
        return this.f14245a;
    }

    public void setTitleBean(LEGORichInfo lEGORichInfo) {
        this.f14245a = lEGORichInfo;
    }

    public ShiftBean getShiftsBean() {
        return this.f14246b;
    }

    public void setShiftsBean(ShiftBean shiftBean) {
        this.f14246b = shiftBean;
    }
}
