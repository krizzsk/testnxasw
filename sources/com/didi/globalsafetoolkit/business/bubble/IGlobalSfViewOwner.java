package com.didi.globalsafetoolkit.business.bubble;

import android.view.View;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;

public interface IGlobalSfViewOwner {
    void closeSafePanel();

    View getView();

    void onRemove();

    void removeCallback();

    void updateBubbleData(GlobalSfBubbleData globalSfBubbleData);

    void updatePanelData(GlobalSfPanelData globalSfPanelData);
}
