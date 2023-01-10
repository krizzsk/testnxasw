package com.didi.globalsafetoolkit.business.safeCenter.adapter;

import com.android.didi.bfflib.business.BffResponseListener;
import java.util.Map;

public interface ISfAdapter {
    void closePanel();

    void onViewDestory();

    void openPanel();

    void refreshBubbleData(int i, Map<String, Object> map, BffResponseListener bffResponseListener);

    void refreshPanelData(int i, Map<String, Object> map, BffResponseListener bffResponseListener);

    void setBubbleVisible(int i);

    void stopBubbleAnimation();

    void translateBubbleYPostion(int i);
}
