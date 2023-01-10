package com.didi.component.safetoolkit.views;

import com.didi.component.core.IView;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenterV2;
import com.didi.globalsafetoolkit.business.bubble.GlobalSfViewOwner;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;

public interface IJarvisViewV2 extends IView<AbsJarvisPresenterV2> {
    void closeSafePanel();

    GlobalSfViewOwner getViewOwner();

    void onBackHome();

    void onLeaveHome();

    void onRemove();

    void setBubbleData(SfBubbleData sfBubbleData);

    void setJarvisData(SfJarvisData sfJarvisData);

    void setJarvisDismissedByAlpha(boolean z);

    void setJarvisVisible(int i);

    void setTranslationY(int i);
}
