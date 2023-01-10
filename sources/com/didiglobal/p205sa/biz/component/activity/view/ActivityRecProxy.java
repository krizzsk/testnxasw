package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.View;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.presenter.IActivityPresenter;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRecProxy */
public class ActivityRecProxy implements IActivityViewProxy {

    /* renamed from: a */
    private final IActivityPanelView f53290a;

    public ActivityRecProxy(Context context) {
        this.f53290a = new ActivityRecyclerView(context);
    }

    public View getView() {
        return this.f53290a.getView();
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        this.f53290a.setData(list, i, i2);
    }

    public void setPresenter(IActivityPresenter iActivityPresenter) {
        this.f53290a.setPresenter(iActivityPresenter);
    }

    public void showErrorView(int i, String str) {
        this.f53290a.showErrorView(i, str);
    }

    public void resetLoading() {
        this.f53290a.resetLoading();
    }
}
