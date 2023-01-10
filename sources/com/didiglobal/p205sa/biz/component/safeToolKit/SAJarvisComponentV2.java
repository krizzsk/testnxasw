package com.didiglobal.p205sa.biz.component.safeToolKit;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenterV2;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAJarvisPresenterV2;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAIJarvisViewV2;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAJarvisViewV2;

@ComponentName(category = 2, type = "component_sa_global_safe_jarvis")
/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.SAJarvisComponentV2 */
public class SAJarvisComponentV2 extends BaseComponent<SAIJarvisViewV2, SAIJarvisPresenterV2> {
    /* access modifiers changed from: protected */
    public SAIJarvisViewV2 onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SAJarvisViewV2(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public SAIJarvisPresenterV2 onCreatePresenter(ComponentParams componentParams) {
        return new SAJarvisPresenterV2(componentParams);
    }

    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return new ViewGroup.LayoutParams(-2, -2);
    }
}
