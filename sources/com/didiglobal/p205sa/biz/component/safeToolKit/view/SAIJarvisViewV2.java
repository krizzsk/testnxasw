package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import com.didi.component.never.core.IView;
import com.didi.globalsafetoolkit.business.bubble.IGlobalSfViewOwner;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenterV2;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAIJarvisViewV2 */
public interface SAIJarvisViewV2 extends IView<SAIJarvisPresenterV2> {
    void closeSafePanel();

    IGlobalSfViewOwner getViewOwner();

    void onBackHome();

    void onLeaveHome();

    void onRemove();

    void setBubbleData(SfBubbleData sfBubbleData);

    void setJarvisData(SfJarvisData sfJarvisData);
}
