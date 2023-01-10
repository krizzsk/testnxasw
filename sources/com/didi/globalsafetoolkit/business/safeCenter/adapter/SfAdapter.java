package com.didi.globalsafetoolkit.business.safeCenter.adapter;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.globalsafetoolkit.business.bubble.IGlobalSfViewOwner;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import java.util.Map;

public class SfAdapter implements ISfAdapter {
    public void setBubbleVisible(int i) {
    }

    public void translateBubbleYPostion(int i) {
    }

    public void setCurSfView(String str, IGlobalSfViewOwner iGlobalSfViewOwner) {
        GlobalSfManager.getInstance().setCurView(str, iGlobalSfViewOwner);
    }

    public void refreshPanelData(int i, Map<String, Object> map, BffResponseListener bffResponseListener) {
        GlobalSfManager.getInstance().refreshPanelData(i, map, bffResponseListener);
    }

    public void refreshBubbleData(int i, Map<String, Object> map, BffResponseListener bffResponseListener) {
        GlobalSfManager.getInstance().refreshBubbleData(i, map, bffResponseListener);
    }

    public void openPanel() {
        GlobalSfManager.getInstance().openPanel();
    }

    public void closePanel() {
        GlobalSfManager.getInstance().closePanel();
    }

    public void stopBubbleAnimation() {
        GlobalSfManager.getInstance().stopBubbleAnimation();
    }

    public void onViewDestory() {
        GlobalSfManager.getInstance().onViewDestory();
    }
}
