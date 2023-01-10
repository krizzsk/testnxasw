package com.didi.component.indriver;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.indriver.impl.IndriverPresenter;
import com.didi.component.indriver.impl.IndriverView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ComponentRegister(product = "ride", type = "passenger_newXpanel+bargainingCard_logic+bargaining_card")
@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/component/indriver/InDriverComponent;", "Lcom/didi/component/base/BaseComponent;", "Lcom/didi/component/indriver/IIndriverView;", "Lcom/didi/component/indriver/AbsIndriverPresenter;", "()V", "onCreatePresenter", "params", "Lcom/didi/component/core/ComponentParams;", "onCreateView", "container", "Landroid/view/ViewGroup;", "comp-indriver_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InDriverComponent.kt */
public final class InDriverComponent extends BaseComponent<IIndriverView, AbsIndriverPresenter<? extends IIndriverView>> {
    /* access modifiers changed from: protected */
    public IIndriverView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        return new IndriverView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsIndriverPresenter<? extends IIndriverView> onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return new IndriverPresenter(componentParams);
    }
}
