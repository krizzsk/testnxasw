package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RiskView extends NormalPayView {
    public RiskView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    public void setActionText(String str) {
        super.setActionText(str);
    }

    public void setActionButtonEnable(boolean z) {
        if (!z) {
            disableActionBtn();
        }
    }
}
