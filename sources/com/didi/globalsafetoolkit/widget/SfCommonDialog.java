package com.didi.globalsafetoolkit.widget;

import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.didi.globalsafetoolkit.widget.SfBaseDialog;

public class SfCommonDialog extends SfBaseDialog {
    protected static SfCommonDialog getInstance(SfBaseDialog.DialogBuilder dialogBuilder) {
        SfCommonDialog sfCommonDialog = new SfCommonDialog();
        sfCommonDialog.mBuilder = dialogBuilder;
        return sfCommonDialog;
    }

    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(SfViewUtils.dp2px(getContext(), 267.0f), -2);
    }
}
