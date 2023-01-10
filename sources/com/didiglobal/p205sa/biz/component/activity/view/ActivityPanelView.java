package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.View;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.IViewContainer;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.presenter.ActivityPanelPresenter;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityPanelView */
public class ActivityPanelView implements IView<ActivityPanelPresenter>, IViewContainer {

    /* renamed from: a */
    private final IActivityViewProxy f53288a;

    /* renamed from: b */
    private ActivityPanelPresenter f53289b;

    public ComponentPresenter getHostPresenter() {
        return null;
    }

    public ActivityPanelView(Context context) {
        this.f53288a = new ActivityRecProxy(context);
    }

    public View getView() {
        return this.f53288a.getView();
    }

    public void setPresenter(ActivityPanelPresenter activityPanelPresenter) {
        this.f53289b = activityPanelPresenter;
        this.f53288a.setPresenter(activityPanelPresenter);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        ActivityPanelPresenter activityPanelPresenter = this.f53289b;
        if (activityPanelPresenter != null) {
            activityPanelPresenter.setComponentCreator(iComponentCreator);
        }
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        this.f53288a.setData(list, i, i2);
    }

    public void showErrorView(int i, String str) {
        this.f53288a.showErrorView(i, str);
    }

    public void resetLoading() {
        this.f53288a.resetLoading();
    }
}
