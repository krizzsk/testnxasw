package com.didi.globalsafetoolkit.business.safeCenter.view;

import com.didi.globalsafetoolkit.business.bubble.IGlobalSfViewOwner;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;

public interface IGlobalView {
    IGlobalSfViewOwner getViewControl();

    void updateBubbleData(GlobalSfBubbleData globalSfBubbleData);
}
