package com.didiglobal.p205sa.biz.component.activity;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.p205sa.biz.component.activity.presenter.ActivityPanelPresenter;
import com.didiglobal.p205sa.biz.component.activity.view.ActivityPanelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/activity/ActivityPanelComponent;", "Lcom/didi/component/never/base/BaseComponent;", "Lcom/didiglobal/sa/biz/component/activity/view/ActivityPanelView;", "Lcom/didiglobal/sa/biz/component/activity/presenter/ActivityPanelPresenter;", "()V", "onCreatePresenter", "params", "Lcom/didi/component/never/core/ComponentParams;", "onCreateView", "container", "Landroid/view/ViewGroup;", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@ComponentName(type = "component_sa_activity")
/* renamed from: com.didiglobal.sa.biz.component.activity.ActivityPanelComponent */
/* compiled from: ActivityPanelComponent.kt */
public final class ActivityPanelComponent extends BaseComponent<ActivityPanelView, ActivityPanelPresenter> {
    /* access modifiers changed from: protected */
    public ActivityPanelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return new ActivityPanelView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public ActivityPanelPresenter onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return new ActivityPanelPresenter(componentParams);
    }
}
