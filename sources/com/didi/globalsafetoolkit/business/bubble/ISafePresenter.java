package com.didi.globalsafetoolkit.business.bubble;

import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;

public interface ISafePresenter {

    public interface Callback {
        void callback(SfBubbleData sfBubbleData, boolean z);
    }

    void onActionClick(String str);

    void refreshJarvisData(GlobalSfBubbleData globalSfBubbleData, Callback callback);

    void removeCallBacks();
}
