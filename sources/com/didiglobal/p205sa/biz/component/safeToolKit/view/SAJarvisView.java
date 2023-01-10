package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import android.content.Context;
import android.view.View;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.safetoolkit.business.bubble.ISfJarvisController;
import com.didi.safetoolkit.business.bubble.SfJarvisController;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenter;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAJarvisView */
public class SAJarvisView implements SAIJarvisView {

    /* renamed from: a */
    private ISfJarvisController f53625a;

    /* renamed from: b */
    private View f53626b;

    /* renamed from: c */
    private Context f53627c;

    public void setPresenter(SAIJarvisPresenter sAIJarvisPresenter) {
    }

    public SAJarvisView(Context context) {
        this.f53627c = context;
        SfJarvisController sfJarvisController = new SfJarvisController(context, UiUtils.dip2px(context, 40.0f));
        this.f53625a = sfJarvisController;
        this.f53626b = sfJarvisController.getView();
    }

    public View getView() {
        return this.f53626b;
    }

    public void setJarvisData(SfJarvisData sfJarvisData) {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.refreshJarvisData(sfJarvisData);
        }
    }

    public void closeSafePanel() {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.closeSafePanel();
        }
    }

    public void onRemove() {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
            this.f53625a.removeCallback();
        }
    }

    public void onLeaveHome() {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
        }
    }

    public void onBackHome() {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.init();
        }
    }

    public void setBubbleData(SfBubbleData sfBubbleData) {
        ISfJarvisController iSfJarvisController = this.f53625a;
        if (iSfJarvisController != null) {
            iSfJarvisController.setBubbleStatusAndShow(sfBubbleData);
        }
    }
}
