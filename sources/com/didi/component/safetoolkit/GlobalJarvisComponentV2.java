package com.didi.component.safetoolkit;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenterV2;
import com.didi.component.safetoolkit.presenter.EndJarvisPresenterV2;
import com.didi.component.safetoolkit.presenter.HomeJarvisPresenterV2;
import com.didi.component.safetoolkit.presenter.OnServiceJarvisPresenterV2;
import com.didi.component.safetoolkit.presenter.WaitRspJarvisPresenterv2;
import com.didi.component.safetoolkit.views.IJarvisViewV2;
import com.didi.component.safetoolkit.views.JarvisViewV2;

@ComponentRegister(product = "ride", type = "global_safe_jarvis")
public class GlobalJarvisComponentV2 extends BaseComponent<IJarvisViewV2, AbsJarvisPresenterV2> {
    /* access modifiers changed from: protected */
    public IJarvisViewV2 onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new JarvisViewV2(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsJarvisPresenterV2 onCreatePresenter(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomeJarvisPresenterV2(componentParams);
        }
        if (i != 1040) {
            return null;
        }
        switch (componentParams.scene) {
            case 10401:
                return new WaitRspJarvisPresenterv2(componentParams);
            case 10402:
                return new OnServiceJarvisPresenterV2(componentParams);
            case 10403:
                return new EndJarvisPresenterV2(componentParams);
            default:
                return null;
        }
    }
}
