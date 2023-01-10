package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import android.content.Context;
import android.view.View;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.globalsafetoolkit.business.bubble.GlobalSfViewOwner;
import com.didi.globalsafetoolkit.business.bubble.IGlobalSfViewOwner;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenterV2;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAJarvisViewV2 */
public class SAJarvisViewV2 implements SAIJarvisViewV2 {

    /* renamed from: a */
    private IGlobalSfViewOwner f53628a;

    /* renamed from: b */
    private View f53629b;

    /* renamed from: c */
    private Context f53630c;

    public void onBackHome() {
    }

    public void setPresenter(SAIJarvisPresenterV2 sAIJarvisPresenterV2) {
    }

    public SAJarvisViewV2(Context context) {
        this.f53630c = context;
        GlobalSfViewOwner globalSfViewOwner = new GlobalSfViewOwner(context, UiUtils.dip2px(context, 40.0f));
        this.f53628a = globalSfViewOwner;
        this.f53629b = globalSfViewOwner.getView();
    }

    public View getView() {
        return this.f53629b;
    }

    public void setJarvisData(SfJarvisData sfJarvisData) {
        if (this.f53628a == null) {
        }
    }

    public IGlobalSfViewOwner getViewOwner() {
        return this.f53628a;
    }

    public void closeSafePanel() {
        IGlobalSfViewOwner iGlobalSfViewOwner = this.f53628a;
        if (iGlobalSfViewOwner != null) {
            iGlobalSfViewOwner.closeSafePanel();
        }
    }

    public void onRemove() {
        IGlobalSfViewOwner iGlobalSfViewOwner = this.f53628a;
        if (iGlobalSfViewOwner != null) {
            iGlobalSfViewOwner.onRemove();
            this.f53628a.removeCallback();
        }
    }

    public void onLeaveHome() {
        IGlobalSfViewOwner iGlobalSfViewOwner = this.f53628a;
        if (iGlobalSfViewOwner != null) {
            iGlobalSfViewOwner.onRemove();
        }
    }

    public void setBubbleData(SfBubbleData sfBubbleData) {
        if (this.f53628a == null) {
        }
    }
}
