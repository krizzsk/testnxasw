package com.didiglobal.p205sa.biz.component.interactivedialog;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IView;
import com.didi.component_processor.annonation.ComponentName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u001e\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogComponent;", "Lcom/didi/component/never/base/BaseComponent;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogPresenter;", "()V", "onCreatePresenter", "componentParams", "Lcom/didi/component/never/core/ComponentParams;", "onCreateView", "viewGroup", "Landroid/view/ViewGroup;", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@ComponentName(type = "component_INTERACTIVIE_DIALOG")
/* renamed from: com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogComponent */
/* compiled from: InteractiveDialogComponent.kt */
public final class InteractiveDialogComponent extends BaseComponent<IView<?>, InteractiveDialogPresenter> {
    /* access modifiers changed from: protected */
    public IView<?> onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return null;
    }

    /* access modifiers changed from: protected */
    public InteractiveDialogPresenter onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        return new InteractiveDialogPresenter(componentParams);
    }
}
